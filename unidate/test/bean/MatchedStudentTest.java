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

    }
    
    /**
     * System Test over the whole application to see if everything is going like
     * it should.
     */
    @Test
    public void systemTest() {
        DBConnectionPool.initaliseForJUnitTests();
        MatchedStudent match = new MatchedStudent();
        ArrayList<MatchedStudent> matchList = new ArrayList<>();
        // create a male test student
        Student student = new Student(10, "Hans", "Muster", "mustehan@students.zhaw", "admin", "admin", true, true);
        student.editUserProfile(student.getId(), student.getFirstname(), student.getSurname(), "men", "T", "Wirtschafts Infromatiker", "Bin de bescht, wos git!", "everything", 20, 19, 21);
        // create a female test student
        Student student2 = new Student(11, "Anna", "Beispiel", "beispann@students.zhaw", "admin1", "admin1", true, true);
        student2.editUserProfile(student2.getId(), student2.getFirstname(), student2.getSurname(), "women", "G", "Ergotherapeutin", "Bin di bescht, wos git!", "guys", 20, 19, 21);
        //Register both students
        Unidate instance = new Unidate();
        instance.setStudent(student);
        instance.register();
        instance.setStudent(student2);
        instance.register();
        // like each other to create a match
        student.like(student2.getId());
        student2.like(student.getId());
        // Checks if student2 is added to the matchlist by getting the ID
        assertEquals(11, matchList.get(0).getCandidateID());
        
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
