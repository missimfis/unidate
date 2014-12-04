/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
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
public class MessageTest {
    
    public MessageTest() {
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
     * Test of getId method, of class Message.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Message.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Message instance = new Message();
        Message expResult = null;
        Message result = instance.setId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSender method, of class Message.
     */
    @Test
    public void testGetSender() {
        System.out.println("getFrom");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getSender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSender method, of class Message.
     */
    @Test
    public void testSetFrom() {
        System.out.println("setFrom");
        int from = 0;
        Message instance = new Message();
        Message expResult = null;
        Message result = instance.setSender(from);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTo method, of class Message.
     */
    @Test
    public void testGetTo() {
        System.out.println("getTo");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTo method, of class Message.
     */
    @Test
    public void testSetTo() {
        System.out.println("setTo");
        int to = 0;
        Message instance = new Message();
        Message expResult = null;
        Message result = instance.setTo(to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatchedStudent method, of class Message.
     */
    @Test
    public void testGetMatchedStudent() {
        System.out.println("getMatchedStudent");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getMatchedStudent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMatchedStudent method, of class Message.
     */
    @Test
    public void testSetMatchedStudent() {
        System.out.println("setMatchedStudent");
        int matchedStudent = 0;
        Message instance = new Message();
        int expResult = 0;
        int result = instance.setMatchedStudent(matchedStudent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsRead method, of class Message.
     */
    @Test
    public void testIsIsRead() {
        System.out.println("isIsRead");
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.isIsRead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsRead method, of class Message.
     */
    @Test
    public void testSetIsRead() {
        System.out.println("setIsRead");
        boolean isRead = false;
        Message instance = new Message();
        Message expResult = null;
        Message result = instance.setIsRead(isRead);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSentDate method, of class Message.
     */
    @Test
    public void testGetSentDate() {
        System.out.println("getSentDate");
        Message instance = new Message();
        Date expResult = null;
        Date result = instance.getSentDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSentDate method, of class Message.
     */
    @Test
    public void testSetSentDate() {
        System.out.println("setSentDate");
        Date sentDate = null;
        Message instance = new Message();
        Message expResult = null;
        Message result = instance.setSentDate(sentDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class Message.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class Message.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        Message instance = new Message();
        Message expResult = null;
        Message result = instance.setText(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadMessage method, of class Message.
     */
    @Test
    public void testLoadMessage() {
        System.out.println("loadMessage");
        int studentId = 0;
        int matchId = 0;
        Message instance = new Message();
        Message expResult = null;
        List<Message> result = instance.loadMessages(studentId, matchId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class Message.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        int matchedStudent = 0;
        String text = "";
        int senderId = 0;
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.sendMessage(text, matchedStudent, senderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageAsRead method, of class Message.
     */
    @Test
    public void testSetMessageAsRead() {
        System.out.println("setMessageAsRead");
        int matchedStudent = 0;
        Message instance = new Message();
        instance.setMessageAsRead(matchedStudent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unreadMessagesExist method, of class Message.
     */
    @Test
    public void testUnreadMessagesExist() {
        System.out.println("unreadMessagesExist");
        int userId = 0;
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.unreadMessagesExist(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
