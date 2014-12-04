/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Logger;
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
public class SimpleDataSourceTest {
    
    public SimpleDataSourceTest() {
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
     * Test of getConnection method, of class SimpleDataSource.
     */
    @Test
    public void testGetConnection_0args() throws Exception {
        System.out.println("getConnection");
        SimpleDataSource instance = null;
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class SimpleDataSource.
     */
    @Test
    public void testGetConnection_String_String() throws Exception {
        System.out.println("getConnection");
        String dbUser = "";
        String dbPasswd = "";
        SimpleDataSource instance = null;
        Connection expResult = null;
        Connection result = instance.getConnection(dbUser, dbPasswd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoginTimeout method, of class SimpleDataSource.
     */
    @Test
    public void testGetLoginTimeout() {
        System.out.println("getLoginTimeout");
        SimpleDataSource instance = null;
        int expResult = 0;
        int result = instance.getLoginTimeout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogWriter method, of class SimpleDataSource.
     */
    @Test
    public void testGetLogWriter() {
        System.out.println("getLogWriter");
        SimpleDataSource instance = null;
        PrintWriter expResult = null;
        PrintWriter result = instance.getLogWriter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoginTimeout method, of class SimpleDataSource.
     */
    @Test
    public void testSetLoginTimeout() {
        System.out.println("setLoginTimeout");
        int seconds = 0;
        SimpleDataSource instance = null;
        instance.setLoginTimeout(seconds);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogWriter method, of class SimpleDataSource.
     */
    @Test
    public void testSetLogWriter() {
        System.out.println("setLogWriter");
        PrintWriter out = null;
        SimpleDataSource instance = null;
        instance.setLogWriter(out);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isWrapperFor method, of class SimpleDataSource.
     */
    @Test
    public void testIsWrapperFor() throws Exception {
        System.out.println("isWrapperFor");
        Class iface = null;
        SimpleDataSource instance = null;
        boolean expResult = false;
        boolean result = instance.isWrapperFor(iface);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unwrap method, of class SimpleDataSource.
     */
    @Test
    public void testUnwrap() throws Exception {
        System.out.println("unwrap");
        SimpleDataSource instance = null;
        Object expResult = null;
        Object result = instance.unwrap(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentLogger method, of class SimpleDataSource.
     */
    @Test
    public void testGetParentLogger() throws Exception {
        System.out.println("getParentLogger");
        SimpleDataSource instance = null;
        Logger expResult = null;
        Logger result = instance.getParentLogger();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
