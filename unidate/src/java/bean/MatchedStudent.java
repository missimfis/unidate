/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author missimfis
 */

package bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class MatchedStudent extends User {
    private int candidateID;
    private int userID;
    private String stmt;
    private PreparedStatement pstmt;

    MatchedStudent(String firstname,
            String lastname,
            String interests,
            int person1,
            int person2) {
        
        this.candidateID = person2;
        
        // set variables for database insert
        addMatchToDatabase(person1, person2);
        
    }

    MatchedStudent() {
    }
    
    /**
     * 
     *
     * @return an candidateID as integer
     */
    public int getCandidateID(){   
        return candidateID;
    }
    
    public void setCandidateID(int id){
        candidateID = id;
    }
    
        /**
     * 
     *
     * @return an candidateID as integer
     */
    public int getUserID(){   
        return userID;
    }
    
    public void setUserID(int id){
        userID = id;
    }
   
    /**
     * Add match to database
     * @param student1
     * @param student2
     */
    public void addMatchToDatabase(
            int student1,
            int student2){
        try {
                stmt = "INSERT INTO matchedstudent (student1,student2) VALUES (?,?)";
                pstmt = DBConnectionPool.getStmtWithKey(stmt, Statement.RETURN_GENERATED_KEYS);

                pstmt.setInt(1, student1);
                pstmt.setInt(2, student2);
                pstmt.executeUpdate();
                
      
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to access user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
    }
    
    /**
     * creates a list of potential candiates for a student according to the 
     * filter criteria
     * @param id
     * @return 
     */
    public List<MatchedStudent> createMatchedList(int id) {
        List<MatchedStudent> matchedList = new ArrayList<>();
        MatchedStudent match;

        stmt = "SELECT "
                + "student1,"
                + "student2 "
                + "FROM matchedStudent  WHERE student1="+ id;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    
                    match = new MatchedStudent();
                    match.setUserID(rs.getInt(1));
                    match.setCandidateID(rs.getInt(2));
                    

                    matchedList.add(match);


                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return  matchedList;
    }

}
