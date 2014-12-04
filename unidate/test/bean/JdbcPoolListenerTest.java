/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.servlet.ServletContextEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class JdbcPoolListenerTest {
    
    public JdbcPoolListenerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of contextInitialized method, of class JdbcPoolListener.
     */
    @Test
    public void testContextInitialized() {
        System.out.println("contextInitialized");
        ServletContextEvent myServletContextEvent = null;
        JdbcPoolListener instance = new JdbcPoolListener();
        instance.contextInitialized(myServletContextEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contextDestroyed method, of class JdbcPoolListener.
     */
    @Test
    public void testContextDestroyed() {
        System.out.println("contextDestroyed");
        ServletContextEvent myServletContextEvent = null;
        JdbcPoolListener instance = new JdbcPoolListener();
        instance.contextDestroyed(myServletContextEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
