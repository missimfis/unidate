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
public class UnidateTest {

    public UnidateTest() {
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
     * Test of register method, of class Unidate.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Unidate instance = new Unidate();
        Student student = new Student();
        instance.setStudent(student);
        boolean expResult = false;
        boolean result = instance.register();
        assertEquals(expResult, result);
    }

    /**
     * Test of sendConfirmationMail method, of class Unidate.
     */
    @Test
    public void testSendConfirmationMail() {
        System.out.println("sendConfirmationMail");
        Unidate instance = new Unidate();
        boolean expResult = true;
        boolean result = instance.sendConfirmationMail();
        assertEquals(expResult, result);
    }

    /**
     * Test of unlockProfil method, of class Unidate.
     */
    @Test
    public void testUnlockProfil() {
        System.out.println("unlockProfil");
        Unidate instance = new Unidate();
        boolean expResult = true;
        instance.setStudent(new Student());
        boolean result = instance.unlockProfil();
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class Unidate.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Unidate instance = new Unidate();
        Student student = new Student();
        student.setUsername("test");
        student.setPassword("testtest5");
        instance.setStudent(student);
        boolean expResult = false;
        boolean result = instance.login();
        assertEquals(expResult, result);
    }

    /**
     * Test of logout method, of class Unidate.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Unidate instance = new Unidate();
        boolean expResult = true;
        boolean result = instance.logout();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStudent method, of class Unidate.
     */
    @Test
    public void testSetStudent() {
        System.out.println("setStudent");
        Student student = null;
        Unidate instance = new Unidate();
        instance.setStudent(student);
    }

    /**
     * System Test over the whole application to see if everything is going like
     * it should.
     */
    @Test
    public void systemTest() {
        DBConnectionPool.initaliseForJUnitTests();
        // create a male test student
        Student student = new Student(10, "Hans", "Muster", "mustehan@students.zhaw", "admin", "admin", true, true);
        student.editUserProfile(student.getId(), student.getFirstname(), student.getSurname(), "men", "T", "Wirtschafts Infromatiker", "Bin de bescht, wos git!", "everything", 20, 19, 21);
        // create a female test student
        Student student2 = new Student(11, "Anna", "Beispiel", "beispann@students.zhaw", "admin1", "admin1", true, true);
        student2.editUserProfile(student2.getId(), student2.getFirstname(), student2.getSurname(), "women", "G", "Ergotherapeutin", "Bin di bescht, wos git!", "guys", 20, 19, 21);
        //Register both students
        Unidate instance = new Unidate();
        instance.setStudent(student);
        instance.register();
        instance.setStudent(student2);
        instance.register();
        // like each other to create a match
        student.like(student2.getId());
        student2.like(student.getId());
        // Send a Message from one student to the other
        Message message = new Message();
        message.sendMessage("Hey jo bin de Hans, wotsch mal eis go zieh?", student.getId(), student2.getId());
        message.sendMessage("Sali Hans, jo wieso nid? Morn am 17:00 im Cafesatz?", student2.getId(), student.getId());
        message.sendMessage("Ja das passt mir super, also bis morn.", student.getId(), student2.getId());
        // Sadly the date isn't going well and anna blocks hans
        student2.blockStudent(student.getId());
        DBConnectionPool.closeCon();
        DBConnectionPool.closePool();
    }

}
