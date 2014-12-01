/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.awt.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *This class organizes the reading and sendig of messages. How they are read 
 * from the database and shown on the page.
 * @author masha
 */
public class Message {
    private int id;
    private int from;
    private int to;
    private int matchedStudent;
    private boolean isRead;
    private Date sentDate;
    private String text;
    private String stmt;
    private PreparedStatement pstmt;
    private Connection con;
 
    Message(int matchedStudent, int senderID, int receiverID, String text){
        this.matchedStudent = matchedStudent;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    private Message() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Gets the id of the message
     * @return return the id of the message
     */
    public int getId(){
        return id;
    }
    
    /**
     * Sets the id of the message
     * @param id
     * @return reference to this message
     */
    public Message setId(int id){
        this.id=id;
        return this;
    }
    
    /**
     * Get the id of the sender of the message.
     * @return the id of the sender of the message
     */
    public int getFrom(){
        return from;
    }
    
    /**
     * Sets the id of the sender of the message
     * 
     * @param from the id of the sender of the message.
     * @return reference to this message.
     */
    public Message setFrom(int from){
        this.from=from;
        return this;
    }
    
    /**
     * Returns id of the reciever of the message.
     * 
     * @return the id of the receiver of the message. 
     */
    public int getTo(){
        return to;
    }
    
    /**
     * Set the id of the receiver of the message
     * 
     * @param to the id of the receiver of the message.
     * @return reference to this message
     */
    public Message setTo(int to){
        this.to=to;
        return this;
    }
    
    /**
     * Get the id of the MatchedStudent
     * @return id of MatchedStudent
     */
    public int getMatchedStudent(){
        return matchedStudent;
    }
    
    public int setMatchedStudent(int matchedStudent){
        this.matchedStudent = matchedStudent;
        return matchedStudent;
    }
    
    /**
     * Returns if a message already has been read.
     * @return true if a massage has been read.
     */
    public boolean isIsRead(){
        return isRead;
    }
    
    /**
     * Sets the parameter if a message has been read.
     * 
     * @param isRead true if a message has been read.
     * @return reference to this message. 
     */
    public Message setIsRead(boolean isRead){
        this.isRead=isRead;
        return this;
    }
    
    /**
     * Gets the date when the message has been sent.
     * 
     * @return the date when the message has been sent. 
     */
    public Date getSentDate(){
        return sentDate;
    }
    
    /**
     * Sets the Date when the message has been sent
     * @param sentDate the date when the message has been sent
     * @return reference to this message.
     */
    public Message setSentDate(Date sentDate){
        this.sentDate = sentDate;
        return this;
    }
    
     /**
     * Gets the text of the message.
     *
     * @return the text of the message as String.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the message.
     *
     * @param text the text of the message as String.
     * @return reference to this message.
     */
    public Message setText(String text) {
        this.text = text;
        return this;
    }
    
    /**
     * Loads a specific message from the database.
     *
     * @param messageID the id of the message that is to be shown.
     * @return the message as a Message object
     */
    public Message loadMessage(int matchedStudent) {
        Message message = null;
        stmt = "SELECT message.text, "
                + "message.sender "
                + "message.read "
                + "FROM message "
                + "WHERE message.ms=" + matchedStudent + " "
                + "ORDER BY message.sentDate DESC";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    message = new Message()
                            .setText(rs.getString(1))
                            .setIsRead(rs.getInt(2)!= 0 )
                            .setSentDate(rs.getTimestamp(3))
                            .setText(rs.getString(4));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(
                    Level.SEVERE, "Failure while loading a message from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        setId(id);
        return message;
    }
    
    /**
     * Sends a message with a specified sent time to a specified User and
     * inserts the requiered fields into the database.
     *
     * @return true if the message has been successfully sent
     */
    public boolean sendMessage() {
        Statement statement = DBConnectionPool.getStmt();
        try {
            statement.executeQuery("START TRANSACTION");
            stmt = "INSERT INTO message (ms, text, from, read) VALUES (?,?,?,?)";
            pstmt = DBConnectionPool.getStmtWithKey(stmt, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, matchedStudent);
            pstmt.setString(2, text);
            pstmt.setInt(3, from);
            pstmt.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));
            pstmt.setInt(5, 0);
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs != null && rs.next()) {
                    int lastID = rs.getInt(1);
                    statement.execute("COMMIT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(
                    Level.SEVERE, "Failure while sending message", ex);
            try {
                statement.executeQuery("ROLLBACK");
            } catch (SQLException ex1) {
                Logger.getLogger(Message.class.getName()).log(
                        Level.SEVERE, "Failure while rollbacking DB", ex1);
            }
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeStmt(statement);
            DBConnectionPool.closeCon();
        }
        return true;
    }
    
    /**
     * Sets messages from student match as read.
     *
     * @param matchedStudent id of match
     */
    public void setMessageAsRead(int matchedStudent) {
        stmt = "UPDATE message SET read='1' WHERE ms=" + matchedStudent + "";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(
                    Level.SEVERE, "Failure while trying to set message as read", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
    }
    
    /**
     * Checks whether a unread Message exists for a specified user or not.
     *
     * @param userId
     * @return true if unread Message exists
     */
    public boolean unreadMessagesExist(int userId) {
        boolean result = false;
        List<Message> nachrichten = loadMessages(userId);
        for (Message temp : nachrichten) {
            if (!temp.isIsRead()) {
                result = true;
            }
        }
        return result;
    }
}