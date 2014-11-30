/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author missimfis
 */
public class MatchedStudent extends User {
    private Message message;
    private int candidateID;
    private String candidateName;
    private String candidateDepartment;
    private String candidateStudium;
    private String candidateAbout;
    private String stmt;
    private PreparedStatement pstmt;

//    MatchedStudent(int candidateID, String candidateName, String candidateDepartment, String candidateStudium, String candidateAbout) {
//        
//        this.candidateID = candidateID;
//        this.candidateName = candidateName;
//        
//    }
    
    MatchedStudent(String firstname,
            String lastname,
            String interests,
            int student1,
            int candidateID) {
        
        this.candidateID = candidateID;
        addMatchToDatabase(firstname, lastname, interests, student1, candidateID);
        
    }
    
    public int getCandidateID(){
    
    return candidateID;
    }
    
    public String getCandidateName(){
    
    return candidateName;
    }
    
    public void addMatchToDatabase(
            String firstname,
            String lastname,
            String interests,
            int student1,
            int student2){
        try {
                stmt = "INSERT INTO matchedstudent (firstname,lastname,interests,student1,student2) VALUES (?,?,?,?,?)";
                pstmt = DBConnectionPool.getStmtWithKey(stmt, Statement.RETURN_GENERATED_KEYS);

                pstmt.setString(1, firstname);
                pstmt.setString(2, lastname);
                pstmt.setString(3, interests);
                pstmt.setInt(4, student1);
                pstmt.setInt(5, student2);
                pstmt.executeUpdate();
                
      
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to access user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
    }
    
    
    
    public boolean sendMessage(int matchedStudent, int senderID, int receiverID, String text) {    
        message = new Message(matchedStudent, senderID, receiverID, text);
        message.sendMessage();
        return true;
    }
    
    /**
     * Returns the Messages as String
     * @return 
     */
    public String showMessages(){
        
        return "message";
    }
    
    /**
     * Checks if Match exists
     * @param Person1
     * @param Person2
     * @return ID of Match
     */
    public int checkMatch(int Person1, int Person2){
        return 7;
    }
    
    
}
