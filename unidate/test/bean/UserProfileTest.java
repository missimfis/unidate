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

    /**
     * Test of getFirstname method, of class UserProfile.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        int userId = 1;
        UserProfile instance = new UserProfile();
        String expResult = firstname;
        String result = instance.getFirstname(userId);
        assertEquals(expResult, result);

        
    }

    /**
     * Test of getLastname method, of class UserProfile.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        int userId = 1;
        UserProfile instance = new UserProfile();
        String expResult = lastname;
        String result = instance.getLastname(userId);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getGender method, of class UserProfile.
     */
    @Test
    public void testGetGender() {
        System.out.println("GetGender");
        int userId = 1;
        UserProfile instance = new UserProfile();
        String expResult = gender;
        String result = instance.getGender(userId);
        assertEquals(expResult, result);
    }


    /**
     * Test of getDepartment method, of class UserProfile.
     */
    @Test
    public void testGetDepartment() {
        System.out.println("getDepartment");
        int userId = 1;
        UserProfile instance = new UserProfile();
        String expResult = department;
        String result = instance.getDepartment(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudium method, of class UserProfile.
     */
    @Test
    public void testGetStudium() {
        System.out.println("getStudium");
        int userId = 1;
        UserProfile instance = new UserProfile();
        String expResult = studium;
        String result = instance.getStudium(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAbout method, of class UserProfile.
     */
    @Test
    public void testGetAbout() {
        System.out.println("getAbout");
        int userId = 1;
        UserProfile instance = new UserProfile();
        String expResult = about;
        String result = instance.getAbout(userId);
        assertEquals(expResult, result);
    }

        /**
     * Test of getInterest method, of class UserProfile.
     */
    @Test
    public void testGetInterest() {
        System.out.println("getInterest");
        int userId = 1;
        UserProfile instance = new UserProfile();
        String expResult = interest;
        String result = instance.getInterest(userId);
        assertEquals(expResult, result);
    }
        /**
     * Test of getAbout method, of class UserProfile.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int userId = 1;
        UserProfile instance = new UserProfile();
        int expResult = age;
        int result = instance.getAge(userId);
        assertEquals(expResult, result);
    }
    /**
     * Test of getMinAge method, of class UserProfile.
     */
    @Test
    public void testGetMinAge() {
        System.out.println("getMinAge");
        int userId = 1;
        UserProfile instance = new UserProfile();
        int expResult = minAge;
        int result = instance.getMinAge(userId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getMaxAge method, of class UserProfile.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        int userId = 1;
        UserProfile instance = new UserProfile();
        int expResult = maxAge;
        int result = instance.getMaxAge(userId);
        assertEquals(expResult, result);
    }
}
