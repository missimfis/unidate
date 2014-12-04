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
public class UnidateTest {
    
    public UnidateTest() {
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
     * Test of register method, of class Unidate.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Unidate instance = new Unidate();
        boolean expResult = false;
        boolean result = instance.register();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class Unidate.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Unidate instance = new Unidate();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendConfirmationMail method, of class Unidate.
     */
    @Test
    public void testSendConfirmationMail() {
        System.out.println("sendConfirmationMail");
        Unidate instance = new Unidate();
        boolean expResult = false;
        boolean result = instance.sendConfirmationMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unlockProfil method, of class Unidate.
     */
    @Test
    public void testUnlockProfil() {
        System.out.println("unlockProfil");
        Unidate instance = new Unidate();
        boolean expResult = false;
        boolean result = instance.unlockProfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class Unidate.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Unidate instance = new Unidate();
        boolean expResult = false;
        boolean result = instance.login();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class Unidate.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Unidate instance = new Unidate();
        boolean expResult = false;
        boolean result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStudent method, of class Unidate.
     */
    @Test
    public void testSetStudent() {
        System.out.println("setStudent");
        Student student = null;
        Unidate instance = new Unidate();
        instance.setStudent(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
