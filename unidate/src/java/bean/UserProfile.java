/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class UserProfile {

    private String stmt;
    private PreparedStatement pstmt;

    
    /**
     * Edits the user data in the database but only if the input is not an empty
     * string or null.
     *
     * @param userId from user
     * @param firstname from user
     * @param lastname from user
     * @param gender from user
     * @param department from user
     * @param studium from user
     * @param about from user
     * @param interest from user
     * @param age from user
     * @param minAge from user
     * @param maxAge from user
     */
    public void editUserProfile(
            int userId,
            String firstname,
            String lastname,
            String gender,
            String department,
            String studium,
            String about,
            String interest,
            int age,
            int minAge,
            int maxAge
            
    ) {
        try {
            if (!"".equals(firstname)) {
                stmt = "UPDATE student SET firstname=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, firstname);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(lastname)) {
                stmt = "UPDATE student SET lastname=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, lastname);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(gender)) {
                stmt = "UPDATE student SET gender=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, gender);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(department)) {
                stmt = "UPDATE student SET department=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, department);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(studium)) {
                stmt = "UPDATE student SET studium=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, studium);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(about)) {
                stmt = "UPDATE student SET about=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, about);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(interest)) {
                stmt = "UPDATE student SET interests=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, interest);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (age >= 0) {
                stmt = "UPDATE student SET age=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setInt(1, age);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (minAge >= 0) {
                stmt = "UPDATE student SET minage=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setInt(1, minAge);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (maxAge >= 0) {
                stmt = "UPDATE student SET maxage=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setInt(1, maxAge);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to access user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
    }
    


    /**
     * Returns the firstname from the database
     *
     * @param userId to identify the relevant person
     * @return an user firstname as String.
     */
    public String getFirstname(int userId) {
        String dbFirstname = "";
        stmt = "SELECT firstname FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbFirstname = rs.getString("firstname");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbFirstname;
    }
    
        /**
     * Returns the lastname from the database
     *
     * @param userId to identify the relevant person
     * @return an user Name as String.
     */
    public String getLastname(int userId) {
        String dbLastname = "";
        stmt = "SELECT lastname FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbLastname = rs.getString("lastname");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbLastname;
    }

    /**
     * Returns the department from the database
     *
     * @param userId to identify the relevant person
     * @return an user department as String.
     */
    public String getDepartment(int userId) {
        String dbDepartment = "";
        stmt = "SELECT department FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbDepartment = rs.getString("department");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbDepartment;
    }

    /**
     * Returns the studium from the database
     *
     * @param userId to identify the relevant person
     * @return an user studium as String.
     */
    public String getStudium(int userId) {
        String dbStudium = "";
        stmt = "SELECT studium FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbStudium = rs.getString("studium");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbStudium;
    }


    /**
     * Returns the about from the database
     *
     * @param userId to identify the relevant person
     * @return an user about as String.
     */
    public String getAbout(int userId) {
        String dbAbout = "";
        stmt = "SELECT about FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbAbout = rs.getString("about");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        if(dbAbout==null){
            dbAbout="";
        }

        return dbAbout;
    }
    
    /**
     * Returns the gender from the database
     *
     * @param userId to identify the relevant person
     * @return an user gender as String.
     */
    public String getGender(int userId) {
        String dbGender = "";
        stmt = "SELECT gender FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbGender = rs.getString("gender");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbGender;
    }
    
    /**
     * Returns the interest from the database
     *
     * @param userId to identify the relevant person
     * @return an user interest as String.
     */
    public String getInterest(int userId) {
        String dbInterest = "";
        stmt = "SELECT interests FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbInterest = rs.getString("interests");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbInterest;
    }
    
    /**
     * Returns the age from the database
     *
     * @param userId to identify the relevant person
     * @return an user age as int.
     */
    public int getAge(int userId) {
        int dbAge = 0;
        stmt = "SELECT age FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbAge = rs.getInt("age");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbAge;
    }
    
    /**
     * Returns the minimum age from the database
     *
     * @param userId to identify the relevant person
     * @return an candidate minimum age as int.
     */
    public int getMinAge(int userId) {
        int dbMinAge = 0;
        stmt = "SELECT minage FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbMinAge = rs.getInt("minage");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbMinAge;
    }
    
    /**
     * Returns the maximum Age from the database
     *
     * @param userId to identify the relevant person
     * @return an candidate maximum age as String.
     */
    public int getMaxAge(int userId) {
        int dbMaxAge = 0;
        stmt = "SELECT maxage FROM student WHERE s=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbMaxAge = rs.getInt("maxage");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbMaxAge;
    }

}

