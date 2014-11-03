package bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private int id;
    private String firstname;
    private String surname;
    private String email;
    private String password;
    private String username;
    private String loginusername;
    private String loginpassword;
    private String coursename;
    private String stmt;
    private PreparedStatement pstmt;
    private int course;
    private boolean admin;
     
    /**
      *Creates a new User Object 
      * @param userId identification id of the user
      * @param firstname firstname of the user
      * @param surname surname of the user
      * @param email email of the user
      * @param password pw of the user
      * @param username username of the user
      * @param loginpassword password for the user to log in
      * @param loginusername username for the user ot log in
      * @param coursename coursename of the user
      * @param course course id of the course
      * @param admin boolean if user is admin
      */
    public User(int userId, String firstname, String surname, String email,
            String password, String username, String loginpassword, String loginusername,
            String coursename, int course, boolean admin){
        this.id = userId;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.coursename = coursename;
        this.course = course;
        this.admin = admin;
        this.loginusername = loginusername;
        this.loginpassword = loginpassword;
    }
    
    /**
     * empty constructor of new user. Creates new User Object
     */
    public User(){  
    }
    
    /**
     * Returns the ID of the user
     *
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID for an User
     *
     * @param id of the User
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the Firstname of an user
     *
     * @return Firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set a Firstname of a User
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get Surname of the User
     *
     * @return Surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set the Surname of an User
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Get email of an User
     *
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set Email of an User
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the Password of an User
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set Password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get Username
     *
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set Username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get Loginusername
     *
     * @return loginusername
     */
    public String getLoginusername() {
        return loginusername;
    }

    /**
     * Set loginusername
     *
     * @param loginusername
     */
    public void setLoginusername(String loginusername) {
        this.loginusername = loginusername;
    }

    /**
     * Get Loginpassword
     *
     * @return loginpassword
     */
    public String getLoginpassword() {
        return loginpassword;
    }

    /**
     * Set Loginpassword
     *
     * @param loginpassword
     */
    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    /**
     * Get Coursename
     *
     * @return coursename
     */
    public String getCourseName() {
        return coursename;
    }

    /**
     * Set Coursename
     *
     * @param coursename
     */
    public void setCourseName(String coursename) {
        this.coursename = coursename;
    }

    /**
     * Get Klasse of User
     *
     * @return id of Klasse
     */
    public int getCourse() {
        return course;
    }

    /**
     * Set Klasse
     *
     * @param course
     */
    public void setCourse(int course) {
        this.course = course;
    }

    /**
     * Get Admin
     *
     * @return admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Set Admin
     *
     * @param admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

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
            if (!validator.checkString(getUsername(), "userName")) {
                result = false;
            }
            if (!validator.checkString(getFirstname(), "firstName")) {
                result = false;
            }
            if (!validator.checkString(getSurname(), "surName")) {
                result = false;
            }
            if (!validator.checkString(getPassword(), "password")) {
                result = false;
            }
            if (!validator.checkEmail(getEmail(), "email")) {
                result = false;
            }
            if (result) {
                stmt = "SELECT * FROM Person WHERE Pusername='" + getUsername() + "'";
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet resultset = pstmt.executeQuery()) {
                    if (resultset.next()) {
                        ErrorText errors = ErrorText.getInstance();
                        errors.setError("usernameExistsAlready");
                        return false;
                    }
                }
                stmt = "SELECT * FROM Person WHERE Email='" + getEmail() + "'";
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet emailResult = pstmt.executeQuery()) {
                    if (emailResult.next()) {
                        ErrorText errors = ErrorText.getInstance();
                        errors.setError("emailExistsAlready");
                        return false;
                    }
                }
                stmt = "INSERT INTO Person (Pusername,Pvorname,Pnachname,Email,Pw) VALUES (?,?,?,?,?)";
                pstmt = DBConnectionPool.getStmtWithKey(stmt, Statement.RETURN_GENERATED_KEYS);

                pstmt.setString(1, getUsername());
                pstmt.setString(2, getFirstname());
                pstmt.setString(3, getSurname());
                pstmt.setString(4, getEmail());
                pstmt.setString(5, getPassword());

                pstmt.executeUpdate();
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs != null && rs.next()) {
                        setId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(
                    Level.SEVERE, "Failure while trying to register new User", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return false;
    }

    /**
     * Takes the userId and sets the corresponding course number acc to the
     * database.
     */
    public void setCourse() {
        stmt = "SELECT K FROM Mitglied WHERE P='" + getId() + "'";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    setCourse(rs.getInt("K"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(
                    Level.SEVERE, "Failure while trying to set course for a Member", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
    }

    /**
     * Checks in the database whether the person is a administrator or not. If
     * the person is an administrator the variable admin is set true otherwise
     * false.
     */
    public void setAdmin() {
        stmt = "SELECT K FROM Klassenadministrator WHERE P='" + getId() + "'";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt("K") != 0) {
                    setAdmin(true);
                } else {
                    setAdmin(false);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(
                    Level.SEVERE, "Failure while trying to check DB if user is admin", e);
            setAdmin(false);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
    }

    /**
     * Sets the user variables.
     *
     * @return Success of the validation process
     */
    public boolean validate() {
        boolean status = false;
        stmt = "SELECT * from Person WHERE Pusername='" + getLoginusername()
                + "' AND BINARY Pw='" + getLoginpassword() + "'";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery(stmt)) {
                status = rs.next();

                if (status) {
                    setId(rs.getInt("P"));
                    setUsername(rs.getString("Pusername"));
                    setFirstname(rs.getString("Pvorname"));
                    setSurname(rs.getString("Pnachname"));
                    setEmail(rs.getString("email"));
                    setPassword(rs.getString("Pw"));
                    setCourse();
                    setAdmin();
                } else {
                    ErrorText errors = ErrorText.getInstance();
                    errors.setError("loginFailed");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(
                    Level.SEVERE, "Failure while checking in DB if user exists", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return status;
    }

    /**
     * Returns the identity number of the User with a given username.
     *
     * @return userId
     * @param username to identify the person
     */
    public int getIdFromUsername(String username) {
        int result = 0;
        if (!"".equals(username)) {
            stmt = "SELECT P FROM Person WHERE Pusername='" + username + "'";
            try {
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet rs = pstmt.executeQuery()) {
                    boolean status = rs.next();
                    if (status) {
                        result = rs.getInt("P");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(
                        Level.SEVERE, "Failure while trying to get the id from a user", ex);
            } finally {
                DBConnectionPool.closeStmt(pstmt);
                DBConnectionPool.closeCon();
            }
        }
        return result;
    }

    /**
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public User getUserInfos(int userId) {
        User user = new User();
        stmt = "SELECT "
                + "Person.Pusername,"
                + "Person.Pvorname,"
                + "Person.Pnachname,"
                + "Person.Email  "
                + "FROM Person WHERE Person.P=" + userId + "";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    user.setUsername(rs.getString(1));
                    user.setFirstname(rs.getString(2));
                    user.setSurname(rs.getString(3));
                    user.setEmail(rs.getString(4));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return user;
    }

    /**
     * Edits the user data in the database but only if the input is not an empty
     * string or null. Both passwords have to be equal.
     *
     * @param userId
     * @param firstname
     * @param surname
     * @param email
     * @param password1
     * @param password2
     */
    public void editUserProperties(
            int userId,
            String firstname,
            String surname,
            String email,
            String password1,
            String password2
    ) {
        try {
            if (!"".equals(firstname)) {
                stmt = "UPDATE Person SET Pvorname=? WHERE P=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, firstname);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(surname)) {
                stmt = "UPDATE Person SET Pnachname=? WHERE P=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, surname);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(email)) {
                stmt = "UPDATE Person SET Email=? WHERE P=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, email);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(password1) && !"".equals(password2)) {
                stmt = "UPDATE Person SET Pw=? WHERE P=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, password1);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(
                    Level.SEVERE, "Failure while trying to access user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
    }
}