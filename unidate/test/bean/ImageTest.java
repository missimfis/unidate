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
     * Test of createDirectory method, of class Image.
     */
    @Test
    public void testCreateDirectory() {
        System.out.println("createDirectory");
        String savePath = "";
        Image instance = new Image();
        
        assertTrue(instance.createDirectory(savePath));
    }

    /**
     * Test of prepareHTML method, of class Image.
     */
    @Test
    public void testPrepareHTML() {
        System.out.println("prepareHTML");
        int id = 1;
        Image instance = new Image();
        instance.prepareHTML(id);
        assertNull(instance.getOutput());
    }


    /**
     * Test of setProfilePic method, of class Image.
     */
    @Test
    public void testSetProfilePic() {
        System.out.println("setProfilePic");
        int id = 1;
        Image instance = new Image();
        instance.setProfilePic(id);
        
    }

    /**
     * Test of getProfilePic method, of class Image.
     */
    @Test
    public void testGetProfilePic() {
        System.out.println("getProfilePic");
        Image instance = new Image();

        instance.setProfilePic(1);
        String result = instance.getProfilePic();
        
        //not null means there at least a default ProfilePic
        assertNotNull(result);

    }

    /**
     * Test of deleteImage method, of class Image.
     */
    @Test
    public void testDeleteImage() {
        System.out.println("deleteImage");
        String name = "";
        int id = 1;
        Image instance = new Image();
        assertTrue(instance.deleteImage(name, id));
    }

    /**
     * Test of getOutput method, of class Image.
     * the output should be null because theres no File
     */
    @Test
    public void testGetOutput() {
        System.out.println("getOutput");
        Image instance = new Image();
        instance.prepareHTML(1);
        String result = instance.getOutput();
        assertNull(result);
    }

    /**
     * Test of resetOutput method, of class Image.
     */
    @Test
    public void testResetOutput() {
        System.out.println("resetOutput");
        Image instance = new Image();
        String expResult = "";
        instance.prepareHTML(1);
        String result = instance.resetOutput();
        assertEquals(expResult, result);
    }

    
}
