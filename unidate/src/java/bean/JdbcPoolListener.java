package bean;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JdbcPoolListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent myServletContextEvent) {
        // do things on server startup
        // Set up ConnectionPool
        DBConnectionPool.initalise();
    }

    @Override
    public void contextDestroyed(ServletContextEvent myServletContextEvent) {
        // close Connection Pool on server shutdown
        DBConnectionPool.closePool();
        // deregister JDBC driver to prevent Tomcat 7 from complaining about memory leaks
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                Logger.getLogger(JdbcPoolListener.class.getName())
                        .log(Level.SEVERE, "FAILURE Deregistering jdbc driver: " + driver, e);
            }
        }
    }
}
