/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ImageTest {
    
    public ImageTest() {
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
     * Test of getDescription method, of class Image.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Image instance = new Image();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescription method, of class Image.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Image instance = new Image();
        instance.setDescription(description);
fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class Image.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        Image instance = new Image();
        instance.doPost(request, response);
fail("The test case is a prototype.");
    }

    /**
     * Test of createDirectory method, of class Image.
     */
    @Test
    public void testCreateDirectory() {
        System.out.println("createDirectory");
        String savePath = "";
        Image instance = new Image();
        instance.createDirectory(savePath);
fail("The test case is a prototype.");
    }

    /**
     * Test of createTXT method, of class Image.
     */
    @Test
    public void testCreateTXT() throws Exception {
        System.out.println("createTXT");
        int id = 0;
        Image instance = new Image();
        instance.createTXT(id);
fail("The test case is a prototype.");
    }

    /**
     * Test of readTXT method, of class Image.
     */
    @Test
    public void testReadTXT() {
        System.out.println("readTXT");
        Image instance = new Image();
        instance.readTXT();
fail("The test case is a prototype.");
    }

    /**
     * Test of prepareHTML method, of class Image.
     */
    @Test
    public void testPrepareHTML() {
        System.out.println("prepareHTML");
        int id = 0;
        Image instance = new Image();
        instance.prepareHTML(id);
fail("The test case is a prototype.");
    }

    /**
     * Test of displayMessage method, of class Image.
     */
    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");
        int id = 0;
        Image instance = new Image();
        instance.displayMessage(id);
fail("The test case is a prototype.");
    }

    /**
     * Test of setProfilePic method, of class Image.
     */
    @Test
    public void testSetProfilePic() {
        System.out.println("setProfilePic");
        int id = 0;
        Image instance = new Image();
        instance.setProfilePic(id);
fail("The test case is a prototype.");
    }

    /**
     * Test of getProfilePic method, of class Image.
     */
    @Test
    public void testGetProfilePic() {
        System.out.println("getProfilePic");
        Image instance = new Image();
        String expResult = null;
        String result = instance.getProfilePic();
        assertEquals(expResult, result);
fail("The test case is a prototype.");
    }

    /**
     * Test of deleteImage method, of class Image.
     */
    @Test
    public void testDeleteImage() {
        System.out.println("deleteImage");
        String name = "";
        int id = 0;
        Image instance = new Image();
        instance.deleteImage(name, id);
fail("The test case is a prototype.");
    }

    /**
     * Test of getOutput method, of class Image.
     */
    @Test
    public void testGetOutput() {
        System.out.println("getOutput");
        Image instance = new Image();
        String expResult = null;
        String result = instance.getOutput();
        assertEquals(expResult, result);
fail("The test case is a prototype.");
    }

    /**
     * Test of resetOutput method, of class Image.
     */
    @Test
    public void testResetOutput() {
        System.out.println("resetOutput");
        Image instance = new Image();
        String expResult = "";
        String result = instance.resetOutput();
        assertEquals(expResult, result);
    fail("The test case is a prototype.");
    }

    
}
