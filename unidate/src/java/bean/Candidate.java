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
    
    public Candidate() {
        this.like = new ArrayList();
        this.candidateProfil = new Student();
    }

    public boolean like() {
        return true;
    }

    public boolean dislike() {
        return true;
    }
    
    public String getCandidateProfil(int id){
        
        return candidateProfil.getDBName(id);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public boolean getCandidateLike(int id){
       
        like = candidateProfil.checkLikedStudent();

        for (int match : like) {
            return id == match;
        }
        
        return false;
    }
}
