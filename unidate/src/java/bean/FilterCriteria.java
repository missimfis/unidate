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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author missimfis
 */
public class FilterCriteria {

    private int minAge;
    private int maxAge;
    private String gender;
    private String stmt;
    private PreparedStatement pstmt;

    /**
     * @return the minAge
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * @param minAge the minAge to set
     */
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    /**
     * @return the maxAge
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * @param maxAge the maxAge to set
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void changeCriteria(
            int minAge,
            int maxAge,
            String gender
    ) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
    }

     /**
     * creates a list of potential candiates for a student according to the 
     * filter criteria
     * @return 
     */
    public ArrayList<Candidate> createCandidateList() {
        ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
        stmt = "SELECT "
                + "st.id,"
                + "st.firstname,"
                + "st.name,"
                + "st.about,"
                + "st.studium,"
                + "st.department  "
                + "FROM student st WHERE st.gender=" + gender + " AND st.age >="+ minAge +" AND st.age <="+ maxAge ;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    candidateList.add(new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),false));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return candidateList;
    }
}
