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

    /**
     *
     * @return true if clicked on like button
     */
    public boolean like() {
        return true;
    }

    /**
     *
     * @return true if clicked on dislike button
     */
    public boolean dislike() {
        return true;
    }
    
    /**
     *
     * @return id of candidate
     */
    @Override
    public int getId() {
        return userId;
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCandidateFirstname(int id) {
        return candidateProfil.getFirstname(id);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public String getCandidateLastname(int id) {
        return candidateProfil.getLastname(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCandidateAbout(int id) {
        return candidateProfil.getFirstname(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCandidateStudium(int id) {
        return candidateProfil.getFirstname(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCandidateDepartment(int id) {
        return candidateProfil.getFirstname(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean getCandidateLike(int id) {
        return likeTest;
    }
    
    /**
     * setCandidate like to true    
     */
    public void setCandidateLike() {
        likeTest=true;
    }
}
