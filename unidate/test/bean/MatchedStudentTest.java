/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
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
        MatchedStudent instance = new MatchedStudent();
        instance.setCandidateID(5);
        int expResult = 5;
        int result = instance.getCandidateID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test if the size of liked student in match is correct
     
    @Test
    public void testSizeOfMatched() {
        System.out.println("test Size");
           
        List<Candidate> candidateList = new ArrayList<>();
        Student student = new Student();
        student.init();
        student.createNewMatch(1);
        candidateList = student.getCandidateList();
        
        int expResult = 3;
        int result = student.getCandidateList().size();
        assertEquals(expResult, result);

    }*/

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
        //instance.addMatchToDatabase(firstname, lastname, interests, student1, student2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
