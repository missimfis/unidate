/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author missimfis
 */
public class MatchedStudent extends User {
    private Message message;
    private int candidateID;
    private String candidateName;
    private String candidateDepartment;
    private String candidateStudium;
    private String candidateAbout;

    MatchedStudent(int candidateID, String candidateName, String candidateDepartment, String candidateStudium, String candidateAbout) {
        
        this.candidateID = candidateID;
        this.candidateName = candidateName;
    }
    
    public int getCandidateID(){
    
    return candidateID;
    }
    
    public String getCandidateName(){
    
    return candidateName;
    }
    
    
    
    public boolean sendMessage(int matchedStudent, int senderID, int receiverID, String text) {    
        message = new Message(matchedStudent, senderID, receiverID, text);
        message.sendMessage();
        return true;
    }
    
    /**
     * Returns the Messages as String
     * @return 
     */
    public String showMessages(){
        
        return "message";
    }
    
    /**
     * Checks if Match exists
     * @param Person1
     * @param Person2
     * @return ID of Match
     */
    public int checkMatch(int Person1, int Person2){
        return 7;
    }
    
    
}
