/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class FilterCriteriaTest{
    
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
        int expResult = 20;
        instance.setMinAge(20);
        int result = instance.getMinAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinAge method, of class FilterCriteria.
     */
    @Test
    public void testSetMinAge() {
        System.out.println("setMinAge");
        int minAge = 20;
        FilterCriteria instance = new FilterCriteria();
        instance.setMinAge(minAge);
    }

    /**
     * Test of getMaxAge method, of class FilterCriteria.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        FilterCriteria instance = new FilterCriteria();
        int expResult = 30;
        instance.setMaxAge(expResult);
        int result = instance.getMaxAge();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of getGender method, of class FilterCriteria.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        FilterCriteria instance = new FilterCriteria();
        String expResult = "women";
        instance.setGender(expResult);
        String result = instance.getGender();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of changeCriteria method, of class FilterCriteria.
     */
    @Test
    public void testChangeCriteria() {
        System.out.println("changeCriteria");
        int minAge = 20;
        int maxAge = 30;
        String gender = "women";
        FilterCriteria instance = new FilterCriteria();
        instance.changeCriteria(minAge, maxAge, gender);
    }

    /**
     * Test of createCandidateList method, of class FilterCriteria.
     */
    @Test
    public void testCreateCandidateList(){
        DBConnectionPool.initaliseForJUnitTests();
        ArrayList<Candidate> expResult = new ArrayList<>();
        expResult.add(new Candidate(4,"Henna","Frau","something interesting about me","Physio","Technikum",false));
        FilterCriteria instance = new FilterCriteria();
        instance.changeCriteria(20, 23, "women");
                
        ArrayList<Candidate> result = instance.createCandidateList();
        assertEquals(expResult.get(0).getFirstname(), result.get(0).getFirstname());
        DBConnectionPool.closeCon();
    }
    
}
