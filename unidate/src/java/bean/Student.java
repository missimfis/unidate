package bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private int id;
    private String firstname;
    private String surname;
    private String email;
    private String password;
    private String username;
    private String loginusername;
    private String loginpassword;
    private String stmt;
    private boolean registrated;
    private boolean completedProfile;
    private PreparedStatement pstmt;
     
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
     * @param registrated
     * @param completedProfile
      */
    public Student(int userId, String firstname, String surname, String email,
            String password, String username, String loginpassword, String loginusername,
            boolean registrated, boolean completedProfile){
        this.id = userId;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.loginusername = loginusername;
        this.loginpassword = loginpassword;
        this.registrated = registrated;
        this.completedProfile = completedProfile;
    }
    
    /**
     * empty constructor of new user. Creates new User Object
     */
    public Student(){  
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
                stmt = "SELECT * FROM student WHERE username='" + getUsername() + "'";
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet resultset = pstmt.executeQuery()) {
                    if (resultset.next()) {
                        ErrorText errors = ErrorText.getInstance();
                        errors.setError("usernameExistsAlready");
                        return false;
                    }
                }
                stmt = "SELECT * FROM student WHERE email='" + getEmail() + "'";
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet emailResult = pstmt.executeQuery()) {
                    if (emailResult.next()) {
                        ErrorText errors = ErrorText.getInstance();
                        errors.setError("emailExistsAlready");
                        return false;
                    }
                }
                stmt = "INSERT INTO student (username,firstname,name,email,pw) VALUES (?,?,?,?,?)";
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
            Logger.getLogger(Student.class.getName()).log(
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
        stmt = "SELECT * from student WHERE username='" + getLoginusername()
                + "' AND BINARY Pw='" + getLoginpassword() + "'";
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery(stmt)) {
                status = rs.next();

                if (status) {
                    setId(rs.getInt("s"));
                    setUsername(rs.getString("username"));
                    setFirstname(rs.getString("firstname"));
                    setSurname(rs.getString("name"));
                    setEmail(rs.getString("email"));
                    setPassword(rs.getString("pw"));
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

    /**
     * Returns the identity number of the User with a given username.
     *
     * @return userId
     * @param username to identify the person
     */
    public int getIdFromUsername(String username) {
        int result = 0;
        if (!"".equals(username)) {
            stmt = "SELECT s FROM student WHERE username='" + username + "'";
            try {
                pstmt = DBConnectionPool.getStmt(stmt);
                try (ResultSet rs = pstmt.executeQuery()) {
                    boolean status = rs.next();
                    if (status) {
                        result = rs.getInt("P");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(
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
    public Student getUserInfos(int userId) {
        Student user = new Student();
        stmt = "SELECT "
                + "st.Pusername,"
                + "st.firstname,"
                + "st.name,"
                + "st.email  "
                + "FROM student st WHERE st.s=" + userId + "";
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
            Logger.getLogger(Student.class.getName()).log(
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
                stmt = "UPDATE student SET firstname=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, firstname);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(surname)) {
                stmt = "UPDATE student SET name=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, surname);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(email)) {
                stmt = "UPDATE student SET email=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, email);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(password1) && !"".equals(password2)) {
                stmt = "UPDATE student SET pw=? WHERE s=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, password1);
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
     * @return the registrated
     */
    public boolean isRegistrated() {
        return registrated;
    }

    /**
     * @param registrated the registrated to set
     */
    public void setRegistrated(boolean registrated) {
        this.registrated = registrated;
    }

    /**
     * @return the completedProfile
     */
    public boolean isCompletedProfile() {
        return completedProfile;
    }

    /**
     * @param completedProfile the completedProfile to set
     */
    public void setCompletedProfile(boolean completedProfile) {
        this.completedProfile = completedProfile;
    }
}