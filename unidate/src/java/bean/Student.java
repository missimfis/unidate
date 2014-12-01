package bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private String name;
    private String department;
    private String studium;
    private String about;
    private String email;
    private String password;
    private String username;
    private String matrikelnumber;
    private String stmt;
    private Integer age;
    private final List<MatchedStudent> matchedStudent;
    private final List<Candidate> candidateList;
    private final List<Integer> likedStudent;

    private boolean registrated;
    private boolean completedProfile;
    private final UserProfile profile;
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
     * @param registrated
     * @param completedProfile
     */
    public Student(int userId, String firstname, String surname, String name, String department, String studium, String about, String email,
            String password, String username, boolean registrated, boolean completedProfile) {
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
        this.registrated = registrated;
        this.completedProfile = completedProfile;
        this.matchedStudent = new ArrayList<>();
        this.candidateList = new ArrayList<>();
        this.likedStudent = new ArrayList<>();
        this.profile = new UserProfile();
    }

    /**
     * empty constructor of new user. Creates new User Object
     */
    public Student() {
        super();
        this.profile = new UserProfile();
        this.matchedStudent = new ArrayList<>();
        this.candidateList = new ArrayList<>();
        this.likedStudent = new ArrayList<>();

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
     * string or null.
     *
     * @param userId
     * @param firstname
     * @param lastname
     * @param department
     * @param studium
     * @param about
     */
    public void editUserProfile(
            int userId,
            String firstname,
            String lastname,
            String department,
            String studium,
            String about
    ) {

        
        profile.editUserProfile(userId, firstname, lastname, department, studium, about);
    }

    /**
     * Returns the UserInfos firstname from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getFirstname(int userId) {
        return profile.getFirstname(userId);
    }
    
    /**
     * Returns the UserInfos lastname from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getLastname(int userId) {
        return profile.getLastname(userId);
    }

    /**
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getDepartment(int userId) {
        return profile.getDepartment(userId);
    }

    /**
     * Returns the UserInfos studium from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getStudium(int userId) {
        return profile.getStudium(userId);
    }

    /**
     * Returns the UserInfos about from the database
     *
     * @param userId to identify the relevant person
     * @return an user object.
     */
    public String getAbout(int userId) {
        return profile.getAbout(userId);
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
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList<Integer> checkLikedStudent() {
        return (ArrayList<Integer>) likedStudent;
    }

    /**
     * check matches in the list of studentmatches
     *
     * @return arraylist of matched Student
     */
    public ArrayList<MatchedStudent> checkMatchedStudent() {
        return (ArrayList<MatchedStudent>) matchedStudent;
    }

    //initialize candidateList for tests
    public void init() {
        candidateList.add(new Candidate(1, "Thomas", "Huynh","test", "physio", "ich bin bla", true));
        candidateList.add(new Candidate(2, "David", "wa","test", "physio", "ich bin bla", true));
        candidateList.add(new Candidate(4, "miau", "bo","test", "physio", "ich bin bla", false));
    }

    /**
     * create new matches for student
     *
     * @param userID
     */
    public void createNewMatch(int userID) {
        String candidateFirstname;
        String candidateLastname;
        String candidateDepartment;
        String candidateStudium;
        String candidateAbout;

        //add to match list if both like
        for (Candidate temp : candidateList) {
            if (temp.getCandidateLike(userID) == true) {

                int candidateID = temp.getId();
                candidateFirstname = temp.getCandidateFirstname(candidateID);
                candidateLastname = temp.getCandidateLastname(candidateID);
                candidateDepartment = temp.getCandidateDepartment(candidateID);
                candidateStudium = temp.getCandidateStudium(candidateID);
                candidateAbout = temp.getCandidateAbout(candidateID);

                matchedStudent.add(new MatchedStudent("firstname", "lastname", "interests", userID, candidateID));
            }
        }
    }

    public void addLikedStudent(int id) {
        likedStudent.add(id);
    }

    /**
     * @return the matrikelnumber
     */
    public String getMatrikelnumber() {
        return matrikelnumber;
    }

    /**
     * @param matrikelnumber the matrikelnumber to set
     */
    public void setMatrikelnumber(String matrikelnumber) {
        this.matrikelnumber = matrikelnumber;
    }
}
