package bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private String email;
    private String password;
    private String username;
    private String matrikelnumber;
    private String stmt;
    private Integer age;
    private final FilterCriteria filterCriteria;
    private final List<MatchedStudent> matchedStudent;
    private final List<Candidate> candidateList;
    private final List<Integer> likedStudent;
    private final List<Integer> blockedStudent;
    private boolean registrated;
    private boolean completedProfile;
    private final UserProfile profile;
    private PreparedStatement pstmt;

    /**
     * Creates a new Student Object
     *
     * @param userId identification id of the student
     * @param firstname firstname of the student
     * @param surname surname of the student
     * @param email email of the student
     * @param password pw of the student
     * @param username username of the student
     * @param registrated registration
     * @param completedProfile  profile of the student
     */
    public Student(int userId, String firstname, String surname, String email,
            String password, String username, boolean registrated, boolean completedProfile) {
        super.setId(userId);
        super.setFirstname(firstname);
        super.setSurname(surname);
        this.email = email;
        this.password = password;
        this.username = username;
        this.registrated = registrated;
        this.completedProfile = completedProfile;
        this.matchedStudent = new ArrayList<>();
        this.candidateList = new ArrayList<>();
        this.likedStudent = new ArrayList<>();
        this.blockedStudent = new ArrayList<>();
        this.profile = new UserProfile();
        this.filterCriteria = new FilterCriteria();
        createFilterCriteria();
        createBlockedStudentList();
        createLikedStudentList();

    }

    /**
     * empty constructor of new student. Creates new Student Object
     */
    public Student() {
        super();
        this.profile = new UserProfile();
        this.matchedStudent = new ArrayList<>();
        this.candidateList = new ArrayList<>();
        this.likedStudent = new ArrayList<>();
        this.blockedStudent = new ArrayList<>();
        this.filterCriteria = new FilterCriteria();

    }

    /**
     * Get email of a Student
     *
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set Email of a Student
     *
     * @param email set email address of the student
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the Password of a Student
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set Password
     *
     * @param password set password of the student
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
     * @param username set username of the student
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the identity number of the Student with a given username.
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
                        result = rs.getInt("s");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(
                        Level.SEVERE, "Failure while trying to get the id from a student", ex);
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
     * @return an student object.
     */
    public Student getUserInfos(int userId) {
        Student student = new Student();
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
                    student.setUsername(rs.getString(1));
                    student.setFirstname(rs.getString(2));
                    student.setSurname(rs.getString(3));
                    student.setEmail(rs.getString(4));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get student infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return student;
    }

    /**
     * Edits the student data in the database but only if the input is not an empty
     * string or null.
     *
     * @param userId identification of the student
     * @param firstname firstname of the student
     * @param lastname lastname of the student
     * @param gender gender of the student
     * @param department department of the student
     * @param studium studium of the student
     * @param about about of the student
     * @param interest interest of the student
     * @param age age of the student
     * @param minAge minimum age of the candidate
     * @param maxAge maximum age of the candidate
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

        profile.editUserProfile(userId, firstname, lastname, gender, department, studium, about, interest, age, minAge, maxAge);
    }

    /**
     * Returns the UserInfos firstname from the database
     *
     * @param userId to identify the relevant person
     * @return a student object.
     */
    public String getFirstname(int userId) {
        return profile.getFirstname(userId);
    }

    /**
     * Returns the UserInfos lastname from the database
     *
     * @param userId to identify the relevant person
     * @return a student object.
     */
    public String getLastname(int userId) {
        return profile.getLastname(userId);
    }

    /**
     * Returns the UserInfos from the database
     *
     * @param userId to identify the relevant person
     * @return an student object.
     */
    public String getDepartment(int userId) {
        return profile.getDepartment(userId);
    }

    /**
     * Returns the UserInfos studium from the database
     *
     * @param userId to identify the relevant person
     * @return an student object.
     */
    public String getStudium(int userId) {
        return profile.getStudium(userId);
    }

    /**
     * Returns the UserInfos about from the database
     *
     * @param userId to identify the relevant person
     * @return an student object.
     */
    public String getAbout(int userId) {
        return profile.getAbout(userId);
    }

    /**
     * Returns the UserInfos about from the database
     *
     * @param userId to identify the relevant person
     * @return an student object.
     */
    public String getGender(int userId) {
        return profile.getGender(userId);
    }
    
    /**
     * @param userId identification of the student
     * @return interest (woman/man)
     */
    public String getInterest(int userId) {
        return profile.getInterest(userId);
    }


    /**
     * @param userId identification of the student
     * @return student age
     */
    public int getAge(int userId) {
        return profile.getAge(userId);
    }
    
    /**
     * @param userId identification of the student
     * @return min age for filter
     */
    public int getMinAge(int userId) {
        return profile.getMinAge(userId);
    }
    
    /**
     * @param userId identification of the student
     * @return the max age for filter
     */
    public int getMaxAge(int userId) {
        return profile.getMaxAge(userId);
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

    public boolean checkNewMessage() {
        return true;
    }
    /**
     * It blocks the candidate with the given ID for this student.
     * @param candidateID identification of the candidate
     * @return true if student if block succeeded
     */
    public boolean blockStudent(int candidateID) {
        blockedStudent.add(candidateID);
        int index = 0;
        for (int i = 0; i < candidateList.size(); i++) {
            if (candidateList.get(i).getId() == candidateID) {
                index = i;
            }
        }
        candidateList.remove(index);
        try {
            stmt = "INSERT INTO blockedstudent (studentid, blockedstudentid) VALUES (?,?)";
            pstmt = DBConnectionPool.getStmtWithKey(stmt, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, this.getId());
            pstmt.setInt(2, candidateID);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to insert blockedstudents on DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return true;
    }
    /**
     * It adds a the candidate with the given id to the liked list of the student
     * or if there is a match it starts the process of generating a new match.
     * @param candidateID identification of the candidate
     * @return true if student perform like
     */
    public boolean like(int candidateID) {
        if (matchCheck(this.getId(), candidateID)) {
            createNewMatch(candidateID);
        } else {
            addLikedStudent(candidateID);
        }
        int index = 0;
        for (int i = 0; i < candidateList.size(); i++) {
            if (candidateList.get(i).getId() == candidateID) {
                index = i;
            }
        }
        candidateList.remove(index);
        return true;
    }
    
    /**
     * The method starts the blockStudent process for the given candidateID
     * @param candidateID identification of the candidate
     * @return true if student perform dislike
     */
    public boolean dislike(int candidateID) {
        blockStudent(candidateID);
        return true;
    }

    /**
     * This method checks if the two students have a match or not
     * @param studentID identification of the student
     * @param candidateID identification of the candidate
     * @return true if match check succeed
     */
    public boolean matchCheck(int studentID, int candidateID) {
        boolean result = false;
        stmt = "SELECT COUNT(`studentid`) FROM `likedstudent` WHERE `studentid`=" + candidateID + " AND `likedstudentid`=" + studentID;
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    if (rs.getInt(1) == 1) {
                        result = true;
                        for(Candidate candidate: candidateList){
                            if(candidate.getId()==candidateID){
                                candidate.setCandidateLike();
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get student infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return result;
    }

    /**
     * It generates a new FilterCriteria object with db data
     * @return true if filter can be created
     */
    public final boolean createFilterCriteria() {
        stmt = "SELECT "
                + "st.interests,"
                + "st.minage,"
                + "st.maxage "
                + "FROM student st WHERE st.s=" + this.getId();
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    filterCriteria.changeCriteria(rs.getInt(2), rs.getInt(3), rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get user infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return true;
    }

    /**
     * It creates the blockedStudentList with db data.
     * @return true if a student is blocked
     */
    public final boolean createBlockedStudentList() {
        blockedStudent.clear();
        stmt = "SELECT "
                + "blockedstudentid "
                + "FROM blockedstudent WHERE studentid=" + this.getId();
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    blockedStudent.add(rs.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return true;
    }

    /**
     * It creates the likedStudentList with db data.
     * @return true if liked student list can be created
     */
    public final boolean createLikedStudentList() {
        likedStudent.clear();
        stmt = "SELECT "
                + "likedstudentid "
                + "FROM likedstudent WHERE studentid=" + this.getId();
        try {
            pstmt = DBConnectionPool.getStmt(stmt);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    likedStudent.add(rs.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to get infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        return true;
    }
    
    /**
     * It creates the candidateList with calling the FilterCriteria object and doing
     * some redundance checks.
     * @return true if candidate list can be created
     */
    public boolean createCandidateList() {
        candidateList.clear();
        ArrayList<Candidate> temp = filterCriteria.createCandidateList();
        ArrayList<Integer> matchedList = new ArrayList<Integer>();
        stmt = "SELECT "
                + "student1, student2 "
                + "FROM matchedstudent WHERE student1=" + this.getId()+" OR student2="+this.getId();
        try {
        pstmt = DBConnectionPool.getStmt(stmt);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
               matchedList.add(rs.getInt(1));
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                Level.SEVERE, "Failure while trying to get infos from DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
        
        for (Candidate candidate : temp) {
            boolean allreadyExists = false;
            for (int blockedId : blockedStudent) {
                if (candidate.getId() == blockedId) {
                    allreadyExists = true;
                    break;
                }
            }
            for (int likedId : likedStudent) {
                if (candidate.getId() == likedId) {
                    allreadyExists = true;
                    break;
                }
            }
            for (int matchedID : matchedList) {
                if (candidate.getId() == matchedID) {
                    allreadyExists = true;
                    break;
                }
            }
            if (!allreadyExists) {
                candidateList.add(candidate);
            }
        }
        return true;
    }
    
    /**
     * It delivers the whole candidateList
     * @return list of candidate as
     */
    public ArrayList<Candidate> getCandidateList() {
        return (ArrayList<Candidate>) candidateList;
    }
    
    /**
     * It delivers the whole candidateList
     * @return list of liked student
     */
    public ArrayList<Integer> checkLikedStudent() {
        return (ArrayList<Integer>) likedStudent;
    }

    /**
     * check match in the list of studentmatches
     *
     * @param id identification of the student
     * @return an arrayList of matched Student
     */
    public ArrayList<MatchedStudent> checkMatchedStudent(int id) {
        MatchedStudent match = new MatchedStudent();
        ArrayList<MatchedStudent> matchList = new ArrayList<>();
       
        matchList = (ArrayList<MatchedStudent>) match.createMatchedList(id);
        
        return (ArrayList<MatchedStudent>) matchList;
    }

    /**
     * initialize candidateList for tests
     *
     */
    public void init() {
        candidateList.add(new Candidate(1, "Thomas", "Huynh", "test", "physio", "ich bin bla", true));
        candidateList.add(new Candidate(3, "David", "wa", "test", "physio", "ich bin bla", true));
        candidateList.add(new Candidate(4, "miau", "bo", "test", "physio", "ich bin bla", true));
    }

    /**
     * create new matches for student
     *
     * @param userID identification of the student
     */
    public void createNewMatch(int userID) {
    MatchedStudent match = new MatchedStudent();
        //add to match list if both like
        for (Candidate temp : candidateList) {
            if (temp.getCandidateLike(userID) == true) {

                int candidateID = temp.getId();

                match.addMatchToDatabase(userID, candidateID);
            }
        }
    }

    /**
     * It adds a canidate to the likedLost of a student.
     * @param candidateID identification of the candidate
     */
    public void addLikedStudent(int candidateID) {
        likedStudent.add(candidateID);
        try {
            stmt = "INSERT INTO likedstudent (studentid, likedstudentid) VALUES (?,?)";
            pstmt = DBConnectionPool.getStmtWithKey(stmt, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, this.getId());
            pstmt.setInt(2, candidateID);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(
                    Level.SEVERE, "Failure while trying to insert likedstudents on DB", ex);
        } finally {
            DBConnectionPool.closeStmt(pstmt);
            DBConnectionPool.closeCon();
        }
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
