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
public class ActivationEMailServiceTest {
    
    public ActivationEMailServiceTest() {
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
     * Test of sendActivationEMail method, of class ActivationEMailService.
     */
    @Test
    public void testSendActivationEMail() {
        System.out.println("sendActivationEMail");
        String to = "";
        String activationLink = "";
        boolean expResult = false;
        boolean result = ActivationEMailService.sendActivationEMail(to, activationLink);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
