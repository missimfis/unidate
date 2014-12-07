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
public class UserProfileTest {
    
    private Student student;
    private final String firstname = "Hans";
    private final String lastname = "Muster";
    private final String gender = "men";
    private final String department = "G";
    private final String studium = "Physio";
    private final String about = "bla";
    private final String interest = "sandwich";
    private final int age = 20;
    private final int minAge = 20;
    private final int maxAge = 30;

    
    public UserProfileTest() {
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
     * Test of editUserProfile method, of class UserProfile.
     * 
     */
    @Test
    public void testEditUserProfile() {
        DBConnectionPool.initaliseForJUnitTests();
        // create a test student        
        student = new Student(1, "Hans", "Muster", "mustehan@students.zhaw", "admin", "admin", true, true);       
        student.editUserProfile(student.getId(), student.getFirstname(), student.getSurname(), "men", "G", "Physio", "bla", "sandwich", 20, 20, 30);
        
        //Check if results is correct after edit
        assertEquals(firstname, student.getFirstname(student.getId()));
        assertEquals(lastname, student.getLastname(student.getId()));      
        assertEquals(gender, student.getGender(student.getId()));
        assertEquals(department,  student.getDepartment(student.getId()));
        assertEquals(studium, student.getStudium(student.getId()));
        assertEquals(about,  student.getAbout(student.getId()));
        assertEquals(interest,  student.getInterest(student.getId()));
        assertEquals(age, student.getAge(student.getId()));
        assertEquals(minAge, student.getMinAge(student.getId()));
        assertEquals(maxAge, student.getMaxAge(student.getId()));
        

        DBConnectionPool.closeCon();

    }

}
