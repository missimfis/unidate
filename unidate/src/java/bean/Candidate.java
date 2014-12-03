/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author missimfis
 */
public class Candidate extends User {

    private Student candidateProfil;
    private String stmt;
    private PreparedStatement pstmt;
    private ArrayList<Integer> like;
    private String firstname;
    private String lastname;
    private String about;
    private String studium;
    private String department;
    private Boolean likeTest;
    private int userId;

    public Candidate(int userId, String firstname, String surname) {
        this.like = new ArrayList();
        this.candidateProfil = new Student();
        super.setId(userId);
        super.setFirstname(firstname);
        super.setSurname(surname);
    }

    public Candidate(int userId, String firstname,String lastname, String about, String studium, String department, boolean likeTest) {
        this.like = new ArrayList();
        this.candidateProfil = new Student();
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.about = about;
        this.studium = studium;
        this.department = department;
        this.likeTest = likeTest;
    }

    public boolean like() {
        return true;
    }

    public boolean dislike() {
        return true;
    }

    @Override
    public int getId() {
        return userId;
    }

    public String getCandidateFirstname(int id) {
        return candidateProfil.getFirstname(id);
    }
    
    public String getCandidateLastname(int id) {
        return candidateProfil.getLastname(id);
    }

    public String getCandidateAbout(int id) {
        return candidateProfil.getFirstname(id);
    }

    public String getCandidateStudium(int id) {
        return candidateProfil.getFirstname(id);
    }

    public String getCandidateDepartment(int id) {
        return candidateProfil.getFirstname(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean getCandidateLike(int id) {
        like = candidateProfil.checkLikedStudent();
        for (int match : like) {
            return id == match;
        }
        return likeTest;
    }
    
    /**
     *
     * @param
     */
    public void setCandidateLike() {
        likeTest=true;
    }
}
