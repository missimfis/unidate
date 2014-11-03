package bean;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DBConnectionPool {

    private static Connection con = null;
    private static DataSource datasource;
    private static javax.sql.DataSource ds;
    private static final String PATH = "webapps/lemas/WEB-INF/cfg/db_credentials.txt";
    private static String driver;
    private static String connection_url;
    private static String db;
    private static String username;
    private static String password;
    private static String port;
    private static boolean testing;
    
    public static void initaliseForJUnitTests() {
        testing = true;
        ds = new SimpleDataSource("jdbc:mysql://localhost:3306/lemas","lemas","lemaspw");
        try {
            ds.getConnection().prepareStatement("DROP DATABASE lemas").execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cmd1 = "mysql --user=lemas --password=lemaspw <web\\" + File.separator + "sql\\" + File.separator + "lemas.sql";
        String cmd2 = "mysql --user=lemas --password=lemaspw lemas <web\\" + File.separator + "sql\\" + File.separator + "inserts.sql";

        try {
            Process child = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"" + cmd1 + " && " + cmd2 + " && exit");
        } catch (IOException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds = new SimpleDataSource("jdbc:mysql://localhost:3306/lemas","lemas","lemaspw");
    }
    
    public static void initalise() {
        testing = false;
        loadParameters();
        PoolProperties p = new PoolProperties();
        p.setUrl(connection_url + ":" + port + "/" + db);
        p.setUrl("jdbc:mysql://localhost:3306/lemas");
        p.setDriverClassName(driver);
        p.setUsername(username);
        p.setUsername("lemas");
        p.setPassword(password);
        p.setPassword("lemaspw");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;"
                + "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");
        datasource = new DataSource();
        datasource.setPoolProperties(p);
    }

    /**
     * Loads necessary parameters for DB connection
     */
    private static void loadParameters() {
        try {
            String input = TextFileReader.parse(PATH);
            String[] lines = input.split("<<>>");
            for (String line : lines) {
                String[] fields = line.split("¦¦¦¦");
                switch (fields[0]) {
                    case "DRIVER":
                        driver = fields[1];
                        break;
                    case "CONNECTION_URL":
                        connection_url = fields[1];
                        break;
                    case "DB":
                        db = fields[1];
                        break;
                    case "USERNAME":
                        username = fields[1];
                        break;
                    case "PASSWORD":
                        password = fields[1];
                        break;
                    case "PORT":
                        port = fields[1];
                    default:
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DBConnectionPool.class.getName())
                    .log(Level.SEVERE, "Failure while getting parameters for DB connection", ex);
        }
    }

    /**
     * Creates and returnes a statement object that will return result sets when
     * executing queries on it. Catches SQL exceptions.
     *
     * @return a statement object that can be used for executing sql queries.
     */
    public static Statement getStmt() {
        try {
            if (testing){
                con = ds.getConnection();
            } else {
                if (con == null || con.isClosed()) {
                con = datasource.getConnection();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Creates a prepared statement that can be used to grant injection safe and
     * fast executing queries. Catches SQL exceptions.
     *
     * @param statement the querie that will be used with ? as variables.
     * @return an injection safe prepared statement on which variables can be
     * defined and executed
     */
    public static PreparedStatement getStmt(String statement) {
        try {
            if (testing){
                con = ds.getConnection();
            } else {
                if (con == null || con.isClosed()) {
                con = datasource.getConnection();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return con.prepareStatement(statement);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(
                    Level.SEVERE, "Failure while getting Prepared SQL Statement", ex);
        }
        return null;
    }

    /* hints for usage: set variables in query as ? - then. 
     * ps.setString(x,"string")for each used variable on the prepared statement.
     * get the resultset with ps.executeQuery()
     */
    public static PreparedStatement getStmtWithKey(String statement, int key) {
        try {
            if (testing){
                con = ds.getConnection();
            } else {
                if (con == null || con.isClosed()) {
                con = datasource.getConnection();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return con.prepareStatement(statement, key);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(
                    Level.SEVERE, "Failure while getting Prepared SQL Statement", ex);
        }
        return null;
    }

    /**
     * closes the Statement
     *
     * @param stmt Statement
     */
    public static void closeStmt(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(
                    Level.SEVERE, "Failure while closing SQL Statement", ex);
        }
    }

    /**
     * closes the PreparedStatement
     *
     * @param stmt PreparedStatement
     */
    public static void closeStmt(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).
                    log(Level.SEVERE,
                            "Failure while closing Prepares SQL Statement", ex);
        }
    }

    public static Connection getCon() {
        if (con != null) {
            return con;
        }
        return null;
    }

    /**
     * Closes the Connection
     */
    public static void closeCon() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(
                    Level.SEVERE, "Failure while closing DB connection", ex);
        }
    }

    /**
     * closes the Connection
     *
     * @param connection
     */
    public static void closeConection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(
                    Level.SEVERE, "Failure while closing DB connection", ex);
        }
    }

    /**
     * Closes the Connection Pool
     */
    public static void closePool() {
        closeCon();
        datasource.close(true);
        datasource = null;
    }
}
