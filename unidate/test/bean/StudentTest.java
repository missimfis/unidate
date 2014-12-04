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
     * Test of getDepartment method, of class Student.
     */
    @Test
    public void testGetDepartment_0args() {
        System.out.println("getDepartment");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getDepartment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartment method, of class Student.
     */
    @Test
    public void testSetDepartment() {
        System.out.println("setDepartment");
        String department = "";
        Student instance = new Student();
        instance.setDepartment(department);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudium method, of class Student.
     */
    @Test
    public void testGetStudium_0args() {
        System.out.println("getStudium");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getStudium();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStudium method, of class Student.
     */
    @Test
    public void testSetStudium() {
        System.out.println("setStudium");
        String studium = "";
        Student instance = new Student();
        instance.setStudium(studium);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAbout method, of class Student.
     */
    @Test
    public void testGetAbout_0args() {
        System.out.println("getAbout");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getAbout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAbout method, of class Student.
     */
    @Test
    public void testSetAbout() {
        System.out.println("setAbout");
        String about = "";
        Student instance = new Student();
        instance.setAbout(about);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Student.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Student.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Student instance = new Student();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Student.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Student.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Student instance = new Student();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Student.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Student.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Student instance = new Student();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInfos method, of class Student.
     */
    @Test
    public void testGetUserInfos() {
        System.out.println("getUserInfos");
        int userId = 0;
        Student instance = new Student();
        Student expResult = null;
        Student result = instance.getUserInfos(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        instance.editUserProfile(userId, firstname, lastname, gender, department, studium, about);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class Student.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        int userId = 0;
        Student instance = new Student();
        String expResult = "";
        String result = instance.getFirstname(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class Student.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        int userId = 0;
        Student instance = new Student();
        String expResult = "";
        String result = instance.getLastname(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartment method, of class Student.
     */
    @Test
    public void testGetDepartment_int() {
        System.out.println("getDepartment");
        int userId = 0;
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
        int userId = 0;
        Student instance = new Student();
        String expResult = "";
        String result = instance.getGender(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNewMessage method, of class Student.
     */
    @Test
    public void testCheckNewMessage() {
        System.out.println("checkNewMessage");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.checkNewMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNewLikes method, of class Student.
     */
    @Test
    public void testCheckNewLikes() {
        System.out.println("checkNewLikes");
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.checkNewLikes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blockStudent method, of class Student.
     */
    @Test
    public void testBlockStudent() {
        System.out.println("blockStudent");
        int candidateID = 0;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.blockStudent(candidateID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of like method, of class Student.
     */
    @Test
    public void testLike() {
        System.out.println("like");
        int candidateID = 0;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.like(candidateID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dislike method, of class Student.
     */
    @Test
    public void testDislike() {
        System.out.println("dislike");
        int candidateID = 0;
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
        Integer result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAge method, of class Student.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        Integer age = null;
        Student instance = new Student();
        instance.setAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMatchedStudent method, of class Student.
     */
    @Test
    public void testCheckMatchedStudent() {
        System.out.println("checkMatchedStudent");
        Student instance = new Student();
        ArrayList<MatchedStudent> expResult = null;
        ArrayList<MatchedStudent> result = instance.checkMatchedStudent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearMatchedStudentList method, of class Student.
     */
    @Test
    public void testClearMatchedStudentList() {
        System.out.println("clearMatchedStudentList");
        Student instance = new Student();
       // instance.clearMatchedStudentList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class Student.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        Student instance = new Student();
        instance.init();
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMatrikelnumber method, of class Student.
     */
    @Test
    public void testSetMatrikelnumber() {
        System.out.println("setMatrikelnumber");
        String matrikelnumber = "";
        Student instance = new Student();
        instance.setMatrikelnumber(matrikelnumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
