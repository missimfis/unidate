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
public class MatchedStudentTest {
    
    public MatchedStudentTest() {
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
     * Test of getCandidateID method, of class MatchedStudent.
     */
    @Test
    public void testGetCandidateID() {
        System.out.println("getCandidateID");
        MatchedStudent instance = null;
        int expResult = 0;
        int result = instance.getCandidateID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateName method, of class MatchedStudent.
     */
    @Test
    public void testGetCandidateName() {
        System.out.println("getCandidateName");
        MatchedStudent instance = null;
        String expResult = "";
        String result = instance.getCandidateName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMatchToDatabase method, of class MatchedStudent.
     */
    @Test
    public void testAddMatchToDatabase() {
        System.out.println("addMatchToDatabase");
        String firstname = "";
        String lastname = "";
        String interests = "";
        int student1 = 0;
        int student2 = 0;
        MatchedStudent instance = null;
        instance.addMatchToDatabase(firstname, lastname, interests, student1, student2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class MatchedStudent.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        int matchedStudent = 0;
        int senderID = 0;
        int receiverID = 0;
        String text = "";
        MatchedStudent instance = null;
        boolean expResult = false;
        boolean result = instance.sendMessage(matchedStudent, senderID, receiverID, text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showMessages method, of class MatchedStudent.
     */
    @Test
    public void testShowMessages() {
        System.out.println("showMessages");
        MatchedStudent instance = null;
        String expResult = "";
        String result = instance.showMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMatch method, of class MatchedStudent.
     */
    @Test
    public void testCheckMatch() {
        System.out.println("checkMatch");
        int Person1 = 0;
        int Person2 = 0;
        MatchedStudent instance = null;
        int expResult = 0;
        int result = instance.checkMatch(Person1, Person2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
