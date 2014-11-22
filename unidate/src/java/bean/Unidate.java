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
public class Unidate {

    private Student student;
    private PreparedStatement pstmt;
    private String stmt;

    /**
     * Checks whether the registration was correct or not. If the person is
     * already registred the return values is false. If the person was added to
     * the database the return value is true.
     *
     * @return success of registration process
     */
    public boolean register() {
        boolean result = true;
        try {
            FormValidator validator = FormValidator.getInstance();
            if (!validator.checkString(student.getUsername(), "userName")) {
                result = false;
            }
            if (!validator.checkString(student.getFirstname(), "firstName")) {
                result = false;
            }
            if (!validator.checkString(student.getSurname(), "surName")) {
                result = false;
            }
            if (!validator.checkString(student.getPassword(), "password")) {
                result = false;
            }
            if (!validator.checkEmail(student.getEmail(), "email")) {
                result = false;
            }
            if (result) {
                stmt = "SELECT * FROM student WHERE username='" + student.getUsername() + "'";
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet resultset = pstmt.executeQuery()) {
                    if (resultset.next()) {
                        ErrorText errors = ErrorText.getInstance();
                        errors.setError("usernameExistsAlready");
                        return false;
                    }
                }
                stmt = "SELECT * FROM student WHERE email='" + student.getEmail() + "'";
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet emailResult = pstmt.executeQuery()) {
                    if (emailResult.next()) {
                        ErrorText errors = ErrorText.getInstance();
                        errors.setError("emailExistsAlready");
                        return false;
                    }
                }
                stmt = "INSERT INTO student (username,firstname,lastname,email,password) VALUES (?,?,?,?,?)";
                pstmt = DBConnectionPool.getStmtWithKey(stmt, Statement.RETURN_GENERATED_KEYS);

                pstmt.setString(1, student.getUsername());
                pstmt.setString(2, student.getFirstname());
                pstmt.setString(3, student.getSurname());
                pstmt.setString(4, student.getEmail());
                pstmt.setString(5, student.getPassword());

                pstmt.executeUpdate();
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs != null && rs.next()) {
                        student.setId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Unidate.class.getName()).log(
                    Level.SEVERE, "Failure while trying to register new User", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return false;
    }

    /**
     * Sets the user variables.
     *
     * @return Success of the validation process
     */
    public boolean validate() {
        boolean status = false;
        stmt = "SELECT * from student WHERE username='" + student.getLoginusername()
                + "' AND BINARY Pw='" + student.getLoginpassword() + "'";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery(stmt)) {
                status = rs.next();

                if (status) {
                    student.setId(rs.getInt("s"));
                    student.setUsername(rs.getString("username"));
                    student.setFirstname(rs.getString("firstname"));
                    student.setSurname(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setPassword(rs.getString("pw"));
                } else {
                    ErrorText errors = ErrorText.getInstance();
                    errors.setError("loginFailed");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while checking in DB if user exists", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return status;
    }

    public boolean sendConfirmationMail() {
        return true;
    }

    public boolean unlockProfil() {
        student.setRegistrated(true);
        return true;
    }

    public boolean login() {
        return true;
    }

    public boolean logout() {
        return true;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }
}
