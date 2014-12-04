/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
public class DBConnectionPoolTest {
    
    public DBConnectionPoolTest() {
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
     * Test of initaliseForJUnitTests method, of class DBConnectionPool.
     */
    @Test
    public void testInitaliseForJUnitTests() {
        System.out.println("initaliseForJUnitTests");
        DBConnectionPool.initaliseForJUnitTests();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initalise method, of class DBConnectionPool.
     */
    @Test
    public void testInitalise() {
        System.out.println("initalise");
        DBConnectionPool.initalise();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStmt method, of class DBConnectionPool.
     */
    @Test
    public void testGetStmt_0args() {
        System.out.println("getStmt");
        Statement expResult = null;
        Statement result = DBConnectionPool.getStmt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStmt method, of class DBConnectionPool.
     */
    @Test
    public void testGetStmt_String() {
        System.out.println("getStmt");
        String statement = "";
        PreparedStatement expResult = null;
        PreparedStatement result = DBConnectionPool.getStmt(statement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStmtWithKey method, of class DBConnectionPool.
     */
    @Test
    public void testGetStmtWithKey() {
        System.out.println("getStmtWithKey");
        String statement = "";
        int key = 0;
        PreparedStatement expResult = null;
        PreparedStatement result = DBConnectionPool.getStmtWithKey(statement, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeStmt method, of class DBConnectionPool.
     */
    @Test
    public void testCloseStmt_Statement() {
        System.out.println("closeStmt");
        Statement stmt = null;
        DBConnectionPool.closeStmt(stmt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeStmt method, of class DBConnectionPool.
     */
    @Test
    public void testCloseStmt_PreparedStatement() {
        System.out.println("closeStmt");
        PreparedStatement stmt = null;
        DBConnectionPool.closeStmt(stmt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCon method, of class DBConnectionPool.
     */
    @Test
    public void testGetCon() {
        System.out.println("getCon");
        Connection expResult = null;
        Connection result = DBConnectionPool.getCon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeCon method, of class DBConnectionPool.
     */
    @Test
    public void testCloseCon() {
        System.out.println("closeCon");
        DBConnectionPool.closeCon();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConection method, of class DBConnectionPool.
     */
    @Test
    public void testCloseConection() {
        System.out.println("closeConection");
        Connection connection = null;
        DBConnectionPool.closeConection(connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closePool method, of class DBConnectionPool.
     */
    @Test
    public void testClosePool() {
        System.out.println("closePool");
        DBConnectionPool.closePool();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
