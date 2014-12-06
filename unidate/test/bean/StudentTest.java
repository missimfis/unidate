/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
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
public class StudentTest {
    
    public StudentTest() {
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
     * Test of getIdFromUsername method, of class Student.
     */
    @Test
    public void testGetIdFromUsername() {
        System.out.println("getIdFromUsername");
        String username = "";
        Student instance = new Student();
        int expResult = 0;
        int result = instance.getIdFromUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdFromUsername method with a Testuser, of class Student.
     * This test will fail, when the Testuser isn't available in the database.
     */
    @Test
    public void testGetIdFromUsername2() {
        System.out.println("getIdFromUsername");
        String username = "fraserui";
        Student instance = new Student();
        int expResult = 1;
        int result = instance.getIdFromUsername(username);
        assertEquals(expResult, result);
    }
    /**
     * Test of getUserInfos method, of class Student.
     */
    @Test
    public void testGetUserInfos() {
        System.out.println("getUserInfos");
        int userId = 1;
        Student instance = new Student();
        Student expResult = null;
        Student result = instance.getUserInfos(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of editUserProfile method, of class Student.
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
        Student instance = new Student();
        //instance.editUserProfile(userId, firstname, lastname, gender, department, studium, about);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class Student.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        int userId = 1;
        Student instance = new Student();
        String expResult = "Brianna";
        String result = instance.getFirstname(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastname method, of class Student.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        int userId = 1;
        Student instance = new Student();
        String expResult = "Fraser";
        String result = instance.getLastname(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDepartment method, of class Student.
     */
    @Test
    public void testGetDepartment_int() {
        System.out.println("getDepartment");
        int userId = 1;
        Student instance = new Student();
        String expResult = "";
        String result = instance.getDepartment(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudium method, of class Student.
     */
    @Test
    public void testGetStudium_int() {
        System.out.println("getStudium");
        int userId = 0;
        Student instance = new Student();
        String expResult = "";
        String result = instance.getStudium(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAbout method, of class Student.
     */
    @Test
    public void testGetAbout_int() {
        System.out.println("getAbout");
        int userId = 0;
        Student instance = new Student();
        String expResult = "";
        String result = instance.getAbout(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class Student.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        int userId = 4;
        Student instance = new Student();
        String expResult = "";
        String result = instance.getGender(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of isRegistrated method, of class Student.
     */
    @Test
    public void testIsRegistrated() {
        System.out.println("isRegistrated");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.isRegistrated();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegistrated method, of class Student.
     */
    @Test
    public void testSetRegistrated() {
        System.out.println("setRegistrated");
        boolean registrated = false;
        Student instance = new Student();
        instance.setRegistrated(registrated);
        assertEquals(instance.isRegistrated(),registrated);
    }

    /**
     * Test of isCompletedProfile method, of class Student.
     */
    @Test
    public void testIsCompletedProfile() {
        System.out.println("isCompletedProfile");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.isCompletedProfile();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompletedProfile method, of class Student.
     */
    @Test
    public void testSetCompletedProfile() {
        System.out.println("setCompletedProfile");
        boolean completedProfile = false;
        Student instance = new Student();
        instance.setCompletedProfile(completedProfile);
    }

    /**
     * Test of checkNewMessage method, of class Student.
     */
    @Test
    public void testCheckNewMessage() {
        System.out.println("checkNewMessage");
        Student instance = new Student();
        boolean expResult = true;
        boolean result = instance.checkNewMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkNewLikes method, of class Student.
     */
    @Test
    public void testCheckNewLikes() {
        System.out.println("checkNewLikes");
        Student instance = new Student();
        boolean expResult = true;
        boolean result = instance.checkNewLikes();
        assertEquals(expResult, result);
    }

    /**
     * Test of blockStudent method, of class Student.
     */
    @Test
    public void testBlockStudent() {
        System.out.println("blockStudent");
        int candidateID = 1;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.blockStudent(candidateID);
        assertEquals(expResult, result);
    }

    /**
     * Test of like method, of class Student.
     */
    @Test
    public void testLike() {
        System.out.println("like");
        int candidateID = 1;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.like(candidateID);
        assertEquals(expResult, result);
    }

    /**
     * Test of dislike method, of class Student.
     */
    @Test
    public void testDislike() {
        System.out.println("dislike");
        int candidateID = 1;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.dislike(candidateID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matchCheck method, of class Student.
     */
    @Test
    public void testMatchCheck() {
        System.out.println("matchCheck");
        int studentID = 0;
        int candidateID = 0;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.matchCheck(studentID, candidateID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFilterCriteria method, of class Student.
     */
    @Test
    public void testCreateFilterCriteria() {
        System.out.println("createFilterCriteria");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.createFilterCriteria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBlockedStudentList method, of class Student.
     */
    @Test
    public void testCreateBlockedStudentList() {
        System.out.println("createBlockedStudentList");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.createBlockedStudentList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createLikedStudentList method, of class Student.
     */
    @Test
    public void testCreateLikedStudentList() {
        System.out.println("createLikedStudentList");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.createLikedStudentList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCandidateList method, of class Student.
     */
    @Test
    public void testCreateCandidateList() {
        System.out.println("createCandidateList");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.createCandidateList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateList method, of class Student.
     */
    @Test
    public void testGetCandidateList() {
        System.out.println("getCandidateList");
        Student instance = new Student();
        ArrayList<Candidate> expResult = null;
        ArrayList<Candidate> result = instance.getCandidateList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Student.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Student instance = new Student();
        Integer expResult = null;
        //Integer result = instance.getAge();
        //assertEquals(expResult, result);
    }

    /**
     * Test of setAge method, of class Student.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        Integer age = 1;
        Student instance = new Student();
        //instance.setAge(age);
        //assertEquals(age, instance.getAge());
    }

    /**
     * Test of checkLikedStudent method, of class Student.
     */
    @Test
    public void testCheckLikedStudent() {
        System.out.println("checkLikedStudent");
        Student instance = new Student();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.checkLikedStudent();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkMatchedStudent method, of class Student.
     */
    @Test
    public void testCheckMatchedStudent() {
        System.out.println("checkMatchedStudent");
        Student instance = new Student();
        ArrayList<MatchedStudent> expResult = null;
        //ArrayList<MatchedStudent> result = instance.checkMatchedStudent();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewMatch method, of class Student.
     */
    @Test
    public void testCreateNewMatch() {
        System.out.println("createNewMatch");
        int userID = 0;
        Student instance = new Student();
        instance.createNewMatch(userID);
    }

    /**
     * Test of addLikedStudent method, of class Student.
     */
    @Test
    public void testAddLikedStudent() {
        System.out.println("addLikedStudent");
        int candidateID = 0;
        Student instance = new Student();
        instance.addLikedStudent(candidateID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrikelnumber method, of class Student.
     */
    @Test
    public void testGetMatrikelnumber() {
        System.out.println("getMatrikelnumber");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getMatrikelnumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMatrikelnumber method, of class Student.
     */
    @Test
    public void testSetMatrikelnumber() {
        System.out.println("setMatrikelnumber");
        String matrikelnumber = "resultS12345678";
        Student instance = new Student();
        instance.setMatrikelnumber(matrikelnumber);
        assertEquals(instance.getMatrikelnumber(), matrikelnumber);
    }
    
}
