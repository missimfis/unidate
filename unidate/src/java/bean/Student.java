package bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends User {

    private String name;
    private String department;
    private String studium;
    private String about;
    private String email;
    private String password;
    private String username;
    private String loginusername;
    private String loginpassword;
    private String stmt;
    private Date birthday;
    private boolean registrated;
    private boolean completedProfile;
    private PreparedStatement pstmt;

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
     * @param email email of the user
     * @param password pw of the user
     * @param username username of the user
     * @param loginpassword password for the user to log in
     * @param loginusername username for the user ot log in
     * @param registrated
     * @param completedProfile
     */
    public Student(int userId, String firstname, String surname, String name, String department, String studium, String about, String email,
            String password, String username, String loginpassword, String loginusername,
            boolean registrated, boolean completedProfile) {
        super.setId(userId);
        super.setFirstname(firstname);
        super.setSurname(surname);
        this.name = name;
        this.department = department;
        this.studium = studium;
        this.about = about;
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
    public Student() {
        super();
    }

    /**
     * Get Surname of the User
     *
     * @return Surname
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Surname of an User
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Surname of the User
     *
     * @return Surname
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Set the Surname of an User
     *
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Get Surname of the User
     *
     * @return studium
     */
    public String getStudium() {
        return studium;
    }

    /**
     * Set the Surname of an User
     *
     * @param studium
     */
    public void setStudium(String studium) {
        this.studium = studium;
    }

    /**
     * Get Surname of the User
     *
     * @return about
     */
    public String getAbout() {
        return about;
    }

    /**
     * Set the Surname of an User
     *
     * @param about
     */
    public void setAbout(String about) {
        this.about = about;
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
                stmt = "UPDATE student SET name=? WHERE personID=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, name);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(department)) {
                stmt = "UPDATE student SET department=? WHERE personID=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, department);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(studium)) {
                stmt = "UPDATE student SET studium=? WHERE personID=?";
                pstmt = DBConnectionPool.getStmt(stmt);
                pstmt.setString(1, studium);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
            }
            if (!"".equals(about) && !"".equals(about)) {
                stmt = "UPDATE student SET about=? WHERE personID=?";
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
        String dbName = null;
        stmt = "SELECT name FROM student WHERE personID=" + userId;
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
        String dbDepartment = null;
        stmt = "SELECT department FROM student WHERE personID=" + userId;
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
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getDBStudium(int userId) {
        String dbStudium = null;
        stmt = "SELECT studium FROM student WHERE personID=" + userId;
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
        String dbAbout = "asdsad";
        stmt = "SELECT about FROM student WHERE personID=" + userId;
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

    public boolean checkNewMesage() {
        return true;
    }

    public boolean checkNewLikes() {
        return true;
    }

    public boolean blockStudent() {
        return true;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
