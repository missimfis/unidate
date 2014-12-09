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
    }
    
    /**
     * Test if the size of liked student in match is correct
     */
    @Test
    public void testSizeOfMatched() {
        DBConnectionPool.initaliseForJUnitTests();
        System.out.println("test Size");
           
        List<Candidate> candidateList = new ArrayList<>();
        Student student = new Student();
        //generate 3 Candidate
        student.init();
        student.createNewMatch(1);
        candidateList = student.getCandidateList();
        
        int expResult = 3;
        int result = student.getCandidateList().size();
        assertEquals(expResult, result);
        DBConnectionPool.closeCon();
    }
    
    /**
     * System Test over the whole application to see if everything is going like
     * it should.
     */
    @Test
    public void testMatch() {
        DBConnectionPool.initaliseForJUnitTests();
        ArrayList<MatchedStudent> matchList = new ArrayList<>();
        // create a male test student
        Student student = new Student();
        // set id of student
        student.setId(2);
        student.init();
        // id of student  is 2
        student.createNewMatch(student.getId());
        matchList = student.checkMatchedStudent(student.getId());
        
        //check the element 2 of list match
        //result should be 4 because the the id of the candidate in element 3 is 4
        //example: candidateList.add(new Candidate(4, "miau", "bo", "test", "physio", "ich bin bla", true));
        assertEquals(4, matchList.get(2).getCandidateID());
        
        DBConnectionPool.closeCon();


    }

    /**
     * Test of addMatchToDatabase method, of class MatchedStudent.
     */
    @Test
    public void testAddMatchToDatabase() {
        DBConnectionPool.initaliseForJUnitTests();
        System.out.println("addMatchToDatabase");

        int student1 = 1;
        int student2 = 2;
        MatchedStudent instance = new MatchedStudent();
        
        instance.addMatchToDatabase(student1, student2);
        
        DBConnectionPool.closeCon();
    }

}
