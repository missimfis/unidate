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
public class FilterCriteriaTest {
    
    public FilterCriteriaTest() {
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
     * Test of getMinAge method, of class FilterCriteria.
     */
    @Test
    public void testGetMinAge() {
        System.out.println("getMinAge");
        FilterCriteria instance = new FilterCriteria();
        int expResult = 0;
        int result = instance.getMinAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinAge method, of class FilterCriteria.
     */
    @Test
    public void testSetMinAge() {
        System.out.println("setMinAge");
        int minAge = 0;
        FilterCriteria instance = new FilterCriteria();
        instance.setMinAge(minAge);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAge method, of class FilterCriteria.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        FilterCriteria instance = new FilterCriteria();
        int expResult = 0;
        int result = instance.getMaxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxAge method, of class FilterCriteria.
     */
    @Test
    public void testSetMaxAge() {
        System.out.println("setMaxAge");
        int maxAge = 0;
        FilterCriteria instance = new FilterCriteria();
        instance.setMaxAge(maxAge);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class FilterCriteria.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        FilterCriteria instance = new FilterCriteria();
        String expResult = "";
        String result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGender method, of class FilterCriteria.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "";
        FilterCriteria instance = new FilterCriteria();
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeCriteria method, of class FilterCriteria.
     */
    @Test
    public void testChangeCriteria() {
        System.out.println("changeCriteria");
        int minAge = 0;
        int maxAge = 0;
        String gender = "";
        FilterCriteria instance = new FilterCriteria();
        instance.changeCriteria(minAge, maxAge, gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCandidateList method, of class FilterCriteria.
     */
    @Test
    public void testCreateCandidateList() {
        System.out.println("createCandidateList");
        FilterCriteria instance = new FilterCriteria();
        ArrayList<Candidate> expResult = null;
        ArrayList<Candidate> result = instance.createCandidateList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
