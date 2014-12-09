/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thomas
 */

package bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Image")
@MultipartConfig(fileSizeThreshold=1024*1024*2,                 // 2MB 
				 maxFileSize=1024*1024*10,      // 10MB
				 maxRequestSize=1024*1024*50)	// 50MB
public class Image extends HttpServlet{


    private String description;
    private String fileNameOutput;
    private String relativePath;
    private String forwardlink;
    private String forwardlinkend;
    private String webLayoutBegin;
    private String webLayoutEnd;
    private String personID;
    private String profilPic;
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";
    private final String path = "H:\\ZHAW\\netbean\\unidate\\unidate\\build\\web\\uploadFiles\\";

    public Image() {
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * handles file upload
     * @param request from client
     * @param response from server
     * @throws javax.servlet.ServletException if communication fails
     * @throws java.io.IOException if file not found
     */
    @Override
    protected void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
            // gets absolute path of the web application
            String appPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            //String savePath = appPath + File.separator + SAVE_DIR;      
             
            
            //createDirectory(savePath);   
            
            // read id from txt to manage folders
            readTXT();          
            String savePath2 = appPath + File.separator + SAVE_DIR + File.separator + personID;  
            // creates the save directory if it does not exists
            createDirectory(savePath2);

            for (Part part : request.getParts()) {
                    String fileName = extractFileName(part);
                    part.write(savePath2 + File.separator + fileName);
            }
            //Redirect to same page
            String site = "http://localhost:8084/unidate/profil_bearbeiten";

            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);                   
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
            String contentDisp = part.getHeader("content-disposition");
            String[] items = contentDisp.split(";");
            for (String s : items) {
                    if (s.trim().startsWith("filename")) {
                            return s.substring(s.indexOf("=") + 2, s.length()-1);
                    }
            }
            return "";
    }

    /**
     * Create directory if not exists
     * @param savePath define the path where to save
     * @return true if directory can be created
     */
    public boolean createDirectory(String savePath) {
    // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
            }
            return true;
    }
    
    /**
     * create textfile to save userID, which is necessary to upload picture into the right folder
     * @param id identifaction id of the user
     * @throws java.io.FileNotFoundException if file not exist
     * @throws java.io.UnsupportedEncodingException if the character Encoding is not supported.
     */
    public void createTXT(int id) throws FileNotFoundException, UnsupportedEncodingException {
        
        try {

        String content = Integer.toString(id);

        File file = new File(path+"\\id.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
                file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
            }

        System.out.println("Done");

        } catch (IOException e) {
        }
	
    }
    
    /**
     * Read ID to upload the picture into to right folder
     */
    public void readTXT(){
    BufferedReader br = null;

        try {
                                                       
                String sCurrentLine;

                br = new BufferedReader(new FileReader(path+"\\id.txt"));

                while ((sCurrentLine = br.readLine()) != null) {
                        //System.out.println(sCurrentLine);
                        personID=sCurrentLine;
                }

        } catch (IOException e) {
        } finally {
                try {
                        if (br != null)br.close();
                } catch (IOException ex) {
                }
        }
    }
            
    /**
     * prepare HTML for profil.jsp to display all picture from a specific user
     * @param id identifaction id of the user
     */
    public void prepareHTML(int id){
        
        relativePath = "uploadFiles/" + id +"/";  
        webLayoutBegin = "<div class=\"large-2 medium-2 columns\"><div class=\"mediumpicture\">";
        webLayoutEnd = "<div class=\"white_medium_circle\"></div><div class=\"blue_medium_circle\"></div></div></div>";
        createDirectory(path + id);
        
        File f;
        f = new File(path + id);    
        File[] list = f.listFiles();    
               
        int count= 1;
        for (File jpg : list) {
            
            String fileName = jpg.getName();
            if(fileNameOutput != null && fileName != null){
                fileNameOutput = fileNameOutput 
                        + webLayoutBegin 
                        + "<FORM NAME=\"form"+count+ "\" METHOD=\"POST\" action=\"profil_bearbeiten\">"
                        + "<INPUT class=\"delete\" TYPE=\"IMAGE\" src=\"img\\delete.png\" width=\"40px\" NAME=\"submit\" VALUE=\""+fileName+"\">"
                        + "</FORM>" 
                        + "<img src=\"" + relativePath + fileName + "\"" + "width=\"150\"" + "height=\"150\"" + "alt=\"profile\"" + ">" 
                        + webLayoutEnd;
            }
            else{
                fileNameOutput = webLayoutBegin 
                        + "<FORM NAME=\"form"+count+ "\" METHOD=\"POST\" action=\"profil_bearbeiten\">"
                        + "<INPUT class=\"delete\" TYPE=\"IMAGE\" src=\"img\\delete.png\" width=\"40px\" NAME=\"submit\" VALUE=\""+fileName+"\">"
                        + "</FORM>" 
                        + "<img src=\"" + relativePath + fileName + "\"" + "width=\"150\"" + "height=\"150\"" + "alt=\"profile\"" + ">"  
                        + webLayoutEnd;
            }
            count++;
        }
    }
    
    /**
     * display Message and Picture from matched student
     * @param id identification id from candidate
     */
   public void displayMessage(int id, int studentId){
        Message message = new Message();
        message.loadLastMessage(studentId, id);
        String text = message.getText();
        String defaultPic ="default-user-image.png";  
        String fileName = "";
        relativePath = "uploadFiles/" + id +"/";        
        webLayoutBegin  = "<div class=\"row\">" + "<a href=\"chatset?match=" +id+ "\">" +  "<div class=\"large-2 medium-2 columns\">" + "<div class=\"mediumpicture\">";
        //Image between
        webLayoutEnd    = "</div>" + "</div>" + "<div class=\"large-10 medium-10 columns panel\">" + "<p>"+ text +"</p>" + "</div>" +  "</a>" +"</div>";
        //create Folder if not exists
        createDirectory(path + id);
        
        File f;
        f = new File(path + id);    
        File[] list = f.listFiles();    
        
        //Display default picutre of no picutre is uploaded
        fileNameOutput = webLayoutBegin 
                        + "<img src=\"" + "uploadFiles/"+ defaultPic  + "\"" + "width=\"150\"" + "height=\"150\"" + "alt=\"profile\"" + ">"  
                        + webLayoutEnd;   
        //display picture of user
        for (File jpg : list) {
            
            fileName = jpg.getName();
            if(fileName != null){
                fileNameOutput = webLayoutBegin 
                                + "<img src=\"" + relativePath + fileName + "\"" + "width=\"150\"" + "height=\"150\"" + "alt=\"profile\"" + ">"  
                                + webLayoutEnd;           
            }

        }
    }
    
    /**
     * Display picture on profil
     * @param id identification id from student
     */
    public void setProfilePic(int id){

        createDirectory(path + id);    
        File f = new File(path + id);    
        File[] list = f.listFiles();    
        String fileName ="default-user-image.png";
        int index = 0;       
        boolean inBounds = (index >= 0) && (index < list.length);
        
        relativePath = "uploadFiles/";  
        createDirectory(path + id);  
        
        //check if file exists in a folder
        if(inBounds){
            fileName = list[0].getName();
            relativePath = "uploadFiles/" + id +"/";  
        }
      
        if(profilPic != null && fileName != null){
            profilPic = "";            
        }
        else{
            profilPic =  ""+ "<img src=\"" + relativePath + fileName + "\"" + "width=\"550\"" + "height=\"150\"" + "alt=\"profile\"" + ">" + "";    
        }
        
    }
    
    /**
     * return the profilPic as String for html
     * @return profilPic 
     */
    public String getProfilePic(){
        return profilPic;
    }
    
    /**
     * Delete picture in profile
     * @param name define the filename
     * @param id identification id of the student
     * @return true
     */
    public boolean deleteImage(String name, int id){
        try{

        File file = new File(path + id + "\\" + name);

        if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
        }else{
                System.out.println("Delete operation is failed.");
        }

    	}catch(Exception e){
    	}
        return true;
    }
    
    /**
     * Return name of the file
     * @return fileNameOutput 
     */
    public String getOutput(){
        return fileNameOutput;   
    }
    
    /**
     * reset nameOutput necessary for message to display matched Student in message
     * @return fileNameOutput 
     */
    public String resetOutput(){
            fileNameOutput = "";
        return fileNameOutput;   
    }
    
    /**
     * @return personID 
     */
    public String getPersonID(){
        return personID;   
    }
}
