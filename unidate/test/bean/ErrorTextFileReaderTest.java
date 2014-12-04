/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
public class ErrorTextFileReaderTest {
    
    public ErrorTextFileReaderTest() {
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
     * Test of getReader method, of class ErrorTextFileReader.
     */
    @Test
    public void testGetReader() throws Exception {
        System.out.println("getReader");
        String filename = "";
        ErrorTextFileReader instance = new ErrorTextFileReader();
        instance.getReader(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parse method, of class ErrorTextFileReader.
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        String meineDatei = "";
        ErrorTextFileReader instance = new ErrorTextFileReader();
        List expResult = null;
        List result = instance.parse(meineDatei);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
