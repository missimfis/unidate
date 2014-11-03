/*
 * This class is used to generate A datasource to provide access to the local database
 * for JUnitTests
 */

package bean;


import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

import javax.sql.DataSource;

public final class SimpleDataSource implements DataSource {
    private PrintWriter out = new PrintWriter(System.out);
    private int timeout = 10;
    private final String dbUrl;
    private String dbUser;
    private String dbPasswd;
    private Connection conn;

    /**
     * Obtain a connection to a DB using the provided arguments to call
     * 
     * @param dbUrl String - The URL of the database (e.g.
     *                       jdbc:postgresql://example.com:5432/mydb)
     * @param dbUser String - Username
     * @param dbPasswd String - Password
     * @see DriverManager#getConnection(String,String,String)
     * @see javax.sql.DataSource
     */
    public SimpleDataSource(String dbUrl, String dbUser, String dbPasswd) {
        this.dbUrl = dbUrl;
        try {
            getConnection(dbUser, dbPasswd); //test if access to db works
        } catch (SQLException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if ((conn == null) || (conn.isClosed())) {
            conn = getConnection(dbUser, dbPasswd);
        }
        return conn;
    }

    @Override
    public Connection getConnection(String dbUser, String dbPasswd)
            throws SQLException {
        this.dbUser = dbUser;
        this.dbPasswd = dbPasswd;
        this.conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
        return conn;
    }

    /* The following methods are dummy methods to fulfill the 
     * DataSource interface.
     */
    
    @Override
    public int getLoginTimeout() {
        return timeout;
    }

    @Override
    public PrintWriter getLogWriter() {
        return out;
    }

    @Override
    public void setLoginTimeout(int seconds) {
        timeout = seconds;
    }

    @Override
    public void setLogWriter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public boolean isWrapperFor(final Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public <T> T unwrap(final Class<T> iface) throws SQLException {
        throw new SQLException(
                "unwrap method not supported by this implementation");
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException(
                "Not supporting java.util.logging.Logger");
    }
}
