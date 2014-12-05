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
     */
    @Test
    public void testEditUserProfile() {
        System.out.println("editUserProfile");
        int userId = 0;
        String firstname = "";
        String lastname = "";
        String gender = "";
        String department = "";
        String studium = "";
        String about = "";
        String interest = "";
        int age=0;
        int minAge=0;
        int maxAge=0;
        UserProfile instance = new UserProfile();
        instance.editUserProfile(userId, firstname, lastname, gender, department, studium, about,interest, age, minAge, maxAge);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class UserProfile.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        int userId = 0;
        UserProfile instance = new UserProfile();
        String expResult = "";
        String result = instance.getFirstname(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class UserProfile.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        int userId = 0;
        UserProfile instance = new UserProfile();
        String expResult = "";
        String result = instance.getLastname(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartment method, of class UserProfile.
     */
    @Test
    public void testGetDepartment() {
        System.out.println("getDepartment");
        int userId = 0;
        UserProfile instance = new UserProfile();
        String expResult = "";
        String result = instance.getDepartment(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudium method, of class UserProfile.
     */
    @Test
    public void testGetStudium() {
        System.out.println("getStudium");
        int userId = 0;
        UserProfile instance = new UserProfile();
        String expResult = "";
        String result = instance.getStudium(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAbout method, of class UserProfile.
     */
    @Test
    public void testGetAbout() {
        System.out.println("getAbout");
        int userId = 0;
        UserProfile instance = new UserProfile();
        String expResult = "";
        String result = instance.getAbout(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class UserProfile.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        int userId = 0;
        UserProfile instance = new UserProfile();
        String expResult = "";
        String result = instance.getGender(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
