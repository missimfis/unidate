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
public class CandidateTest {
    
    public CandidateTest() {
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
     * Test of like method, of class Candidate.
     */
    @Test
    public void testLike() {
        System.out.println("like");
        Candidate instance = null;
        boolean expResult = false;
        boolean result = instance.like();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dislike method, of class Candidate.
     */
    @Test
    public void testDislike() {
        System.out.println("dislike");
        Candidate instance = null;
        boolean expResult = false;
        boolean result = instance.dislike();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Candidate.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Candidate instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateFirstname method, of class Candidate.
     */
    @Test
    public void testGetCandidateFirstname() {
        System.out.println("getCandidateFirstname");
        int id = 0;
        Candidate instance = null;
        String expResult = "";
        String result = instance.getCandidateFirstname(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateLastname method, of class Candidate.
     */
    @Test
    public void testGetCandidateLastname() {
        System.out.println("getCandidateLastname");
        int id = 0;
        Candidate instance = null;
        String expResult = "";
        String result = instance.getCandidateLastname(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateAbout method, of class Candidate.
     */
    @Test
    public void testGetCandidateAbout() {
        System.out.println("getCandidateAbout");
        int id = 0;
        Candidate instance = null;
        String expResult = "";
        String result = instance.getCandidateAbout(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateStudium method, of class Candidate.
     */
    @Test
    public void testGetCandidateStudium() {
        System.out.println("getCandidateStudium");
        int id = 0;
        Candidate instance = null;
        String expResult = "";
        String result = instance.getCandidateStudium(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateDepartment method, of class Candidate.
     */
    @Test
    public void testGetCandidateDepartment() {
        System.out.println("getCandidateDepartment");
        int id = 0;
        Candidate instance = null;
        String expResult = "";
        String result = instance.getCandidateDepartment(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateLike method, of class Candidate.
     */
    @Test
    public void testGetCandidateLike() {
        System.out.println("getCandidateLike");
        int id = 0;
        Candidate instance = null;
        boolean expResult = false;
        boolean result = instance.getCandidateLike(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCandidateLike method, of class Candidate.
     */
    @Test
    public void testSetCandidateLike() {
        System.out.println("setCandidateLike");
        Candidate instance = null;
        instance.setCandidateLike();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
