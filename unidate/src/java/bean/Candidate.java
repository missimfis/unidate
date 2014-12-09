/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
     * @return  id from candidate as integer
     */
    @Override
    public int getId() {
        return userId;
    }

    /**
     *
     * @param id identification id from candidate
     * @return firstname from candidate as String
     */
    public String getCandidateFirstname(int id) {
        return candidateProfil.getFirstname(id);
    }
    
    /**
     *
     * @param id identification id from candidate
     * @return lastname from candidate as String
     */
    public String getCandidateLastname(int id) {
        return candidateProfil.getLastname(id);
    }

    /**
     *
     * @param id identification id from candidate
     * @return about from candidate as String 
     */
    public String getCandidateAbout(int id) {
        return candidateProfil.getFirstname(id);
    }

    /**
     *
     * @param id identification id from candidate
     * @return studium from candidate as String
     */
    public String getCandidateStudium(int id) {
        return candidateProfil.getFirstname(id);
    }

    /**
     *
     * @param id identification id from candidate
     * @return department from candidate as String
     */
    public String getCandidateDepartment(int id) {
        return candidateProfil.getFirstname(id);
    }

    /**
     *
     * @param id identification id from candidate
     * @return check the like of candidate
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
