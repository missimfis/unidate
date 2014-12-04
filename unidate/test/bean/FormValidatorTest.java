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
public class FormValidatorTest {
    
    public FormValidatorTest() {
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
     * Test of getInstance method, of class FormValidator.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        FormValidator expResult = null;
        FormValidator result = FormValidator.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkEmail method, of class FormValidator.
     */
    @Test
    public void testCheckEmail() {
        System.out.println("checkEmail");
        String email = "";
        String type = "";
        FormValidator instance = new FormValidator();
        boolean expResult = false;
        boolean result = instance.checkEmail(email, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkString method, of class FormValidator.
     */
    @Test
    public void testCheckString() {
        System.out.println("checkString");
        String string = "";
        String type = "";
        FormValidator instance = new FormValidator();
        boolean expResult = false;
        boolean result = instance.checkString(string, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLeginumber method, of class FormValidator.
     */
    @Test
    public void testCheckLeginumber() {
        System.out.println("checkLeginumber");
        String string = "";
        String type = "";
        FormValidator instance = new FormValidator();
        boolean expResult = false;
        boolean result = instance.checkLeginumber(string, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
