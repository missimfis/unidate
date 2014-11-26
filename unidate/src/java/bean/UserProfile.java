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
    private String dbName;

    /**
     * Creates a new User Object
     *
     * @param userId identification id of the user
     * @param firstname firstname of the user
     * @param surname surname of the user
     * @param name name of the user
     * @param department
     * @param studium
     * @param about

     */
//    public UserProfile(int userId, String firstname, String surname, String name, String department, String studium, String about){
//        super.setId(userId);
//        super.setFirstname(firstname);
//        super.setSurname(surname);
//        super.setName(name);
//        super.setDepartment(department);
//        super.setStudium(studium);
//        super.setAbout(about);
//    }
    
    /**
     * Edits the user data in the database but only if the input is not an empty
     * string or null.
     *
     * @param userId
     * @param name
     * @param department
     * @param studium
     * @param about
     */
    public void editUserProfile(
            int userId,
            String name,
            String department,
            String studium,
            String about
    ) {
        try {
            if (!"".equals(name)) {
                stmt = "UPDATE skills SET name=? WHERE personID=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, "test");
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(department)) {
                stmt = "UPDATE skills SET department=? WHERE personID=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, department);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(studium)) {
                stmt = "UPDATE skills SET studium=? WHERE personID=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, studium);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(about) && !"".equals(about)) {
                stmt = "UPDATE skills SET about=? WHERE personID=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, about);
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
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getDBName(int userId) {
        this.dbName = "";
        stmt = "SELECT name FROM skills WHERE personID=" + userId;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    dbName = rs.getString("name");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }

        return dbName;
    }

    /**
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getDBDepartment(int userId) {
        String dbDepartment = "";
        stmt = "SELECT department FROM skills WHERE personID=" + userId;
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


    public String getDBStudium(int userId) {
        String dbStudium = "";
        stmt = "SELECT studium FROM skills WHERE personID=" + userId;
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
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getDBAbout(int userId) {
        String dbAbout = "";
        stmt = "SELECT about FROM skills WHERE personID=" + userId;
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

        return dbAbout;
    }
    
    /**
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
//    public void prepareProfil(int userId) {
//        getDBName(userId);
//        getDBDepartment(userId);
//        getDBStudium(userId);
//        getDBAbout(userId);              
//    }
}

    /**
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
//    public void prepareUserProfile(int userId) {
//
//
//        stmt = "SELECT name, department, studium, about FROM student WHERE personID=" + userId;
//        try {
//            pstmt = DBConnectionPool.getStmt(stmt);
//  
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    
//                   name = rs.getString("name");
//                   department = rs.getString("name");
//                   studium = rs.getString("name");
//                   about = rs.getString("name");
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Student.class.getName()).log(
//                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
//        } finally {
//            DBConnectionPool.closeStmt(pstmt);
//            DBConnectionPool.closeCon();
//        }
//
//    } 