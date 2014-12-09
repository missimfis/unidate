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
    
    private final int id=72;
    private final int senderId=42;
    private final int matchedStudentId= 882;
    private final int receiverId=31;
    private final String text = "weite stille erfüllt die nacht und weidet sich am schweigen der sterne";
    
   
    
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
        DBConnectionPool.initaliseForJUnitTests();
    }
    
    @After
    public void tearDown() {
        DBConnectionPool.closeCon();
    }

    /**
     * Test of getId method, of class Message.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Message instance = new Message();
        instance.setId(id);
        int expResult = 72;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Message.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Message instance = new Message();
        int expResult = id;
        Message result = instance.setId(id);
        assertEquals(expResult, result.getId());
    }

    /**
     * Test of getSender method, of class Message.
     */
    @Test
    public void testGetSender() {
        System.out.println("getFrom");
        Message instance = new Message(matchedStudentId, senderId, receiverId, text);
        int expResult = senderId;
        int result = instance.getSender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSender method, of class Message.
     */
    @Test
    public void testSetFrom() {
        System.out.println("setFrom");
        int from = senderId;
        Message instance = new Message();
        int expResult = senderId;
        Message result = instance.setSender(from);
        assertEquals(expResult, result.getSender());
    }
   
    /**
     * Test of getTo method, of class Message.
     */
    @Test
    public void testGetTo() {
        System.out.println("getTo");
        Message instance = new Message(matchedStudentId, senderId, receiverId, text);
        int expResult = receiverId;
        int result = instance.getTo();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setTo method, of class Message.
     */
    @Test
    public void testSetTo() {
        System.out.println("setTo");
        int to = receiverId;
        Message instance = new Message();
        int expResult = receiverId;
        Message result = instance.setTo(to);
        assertEquals(expResult, result.getTo());
    }
    
    /**
     * Test of getMatchedStudent method, of class Message.
     */
    @Test
    public void testGetMatchedStudent() {
        System.out.println("getMatchedStudent");
        Message instance = new Message(matchedStudentId, senderId, receiverId, text);
        int expResult = matchedStudentId;
        int result = instance.getMatchedStudent();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of setMatchedStudent method, of class Message.
     */
    @Test
    public void testSetMatchedStudent() {
        System.out.println("setMatchedStudent");
        int matchedStudent = matchedStudentId;
        Message instance = new Message();
        int expResult = matchedStudentId;
        int result = instance.setMatchedStudent(matchedStudent);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isIsRead method, of class Message.
     */
    @Test
    public void testIsIsRead() {
        System.out.println("isIsRead");
        Message instance = new Message();
        boolean isRead = true;
        boolean expResult = true;
        instance.setIsRead(isRead);
        boolean result = instance.isIsRead();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of setIsRead method, of class Message.
     */
    @Test
    public void testSetIsRead() {
        System.out.println("setIsRead");
        boolean isRead = true;
        Message instance = new Message();
        boolean expResult = true;
        Message result = instance.setIsRead(isRead);
        assertEquals(expResult, result.isIsRead());
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
        assertEquals(expResult, result.getSentDate());
    }
    
    /**
     * Test of getText method, of class Message.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        Message instance = new Message(matchedStudentId, senderId, receiverId, text);
        String expResult = text;
        String result = instance.getText();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setText method, of class Message.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        Message instance = new Message();
        String expResult = text;
        Message result = instance.setText(text);
        assertEquals(expResult, result.getText());
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
        boolean expResult = true;
        boolean result = instance.sendMessage(text, matchedStudent, senderId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of loadMessage method, of class Message.
     */
    @Test
    public void testLoadMessage() {
        System.out.println("loadMessage");
        int studentId = senderId;
        int matchId = receiverId;
        Message instance = new Message();
        instance.sendMessage(text, senderId, receiverId);
        String expResult1 = text;
        int expResult2 = senderId;
        List<Message> result = instance.loadMessages(studentId, matchId);
        assertEquals(expResult1, result.get(0).getText());
        assertEquals(expResult2, result.get(0).getSender());
    }
}