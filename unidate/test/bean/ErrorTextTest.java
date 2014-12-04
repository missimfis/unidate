/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
public class ErrorTextTest {
    
    public ErrorTextTest() {
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
     * Test of setFilePathForJUnitTesting method, of class ErrorText.
     */
    @Test
    public void testSetFilePathForJUnitTesting() {
        System.out.println("setFilePathForJUnitTesting");
        ErrorText.setFilePathForJUnitTesting();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class ErrorText.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ErrorText expResult = null;
        ErrorText result = ErrorText.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setError method, of class ErrorText.
     */
    @Test
    public void testSetError() {
        System.out.println("setError");
        String string = "";
        ErrorText instance = new ErrorText();
        instance.setError(string);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getError method, of class ErrorText.
     */
    @Test
    public void testGetError() {
        System.out.println("getError");
        String string = "";
        ErrorText instance = new ErrorText();
        String expResult = "";
        String result = instance.getError(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class ErrorText.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        ErrorText instance = new ErrorText();
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
