/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author thomas
 */

import java.io.File;
import java.io.IOException;
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

    private String imagepath;
    private String description;
    private String fileNameOutput;
    private String path;
    private String relativePath;
    private String webLayoutBegin;
    private String webLayoutEnd;


    // initialize html text
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

    public boolean upload(HttpServletRequest request) {
        return true;
    }
    
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";

    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
            // gets absolute path of the web application
            String appPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String savePath = appPath + File.separator + SAVE_DIR;

            // creates the save directory if it does not exists
            createDirectory(savePath);   

            for (Part part : request.getParts()) {
                    String fileName = extractFileName(part);
                    part.write(savePath + File.separator + fileName);
            }
            //Redirect to same page
            String site = new String("http://localhost:8084/unidate/profil_bearbeiten.jsp");

            response.setStatus(response.SC_MOVED_TEMPORARILY);
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
     */
    public void createDirectory(String savePath) {
    // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
            }
    }
    

            

    public void prepareHTML(){
        path = "H:\\ZHAW\\netbean\\unidate\\unidate\\build\\web\\uploadFiles";
        relativePath = "uploadFiles/";  
        webLayoutBegin = "<div class=\"large-2 medium-2 columns\"><div class=\"mediumpicture\">";
        webLayoutEnd = "<div class=\"white_medium_circle\"></div><div class=\"blue_medium_circle\"></div></div></div>";
        //this.submitButton = "\"<FORM NAME=\"form2\" METHOD=\"POST\"><INPUT TYPE=\"SUBMIT\" NAME=\"submit\" VALUE=\"Button 2\"></FORM>\"";
        
        File f;
        f = new File(path);
        File[] list = f.listFiles();    
        int count= 1;
        for (File jpg : list) {
            
            String fileName = jpg.getName();
            //fileNameOutput = "<img src=\"" + relativePath + fileName + "\""+ "width=\"114\"" + "height=\"110\"" + ">" + "<br>" + fileNameOutput;
            if(fileNameOutput != null && fileName != null){
                //fileNameOutput = "<img src=\"" + relativePath + fileName + "\""+ "width=\"150\"" + "height=\"100\"" + ">" + fileNameOutput;
                fileNameOutput = fileNameOutput 
                        + webLayoutBegin 
                        + "<FORM NAME=\"form"+count+ "\" METHOD=\"POST\">"
                        + "<INPUT TYPE=\"IMAGE\" src=\"img\\delete.png\" width=\"40px\" NAME=\"submit\" VALUE=\""+fileName+"\">"
                        + "</FORM>" 
                        + "<img src=\"" + relativePath + fileName + "\"" + "width=\"150\"" + "height=\"150\"" + "alt=\"profile\"" + ">" 
                        + webLayoutEnd;
            }
            else{
                fileNameOutput = webLayoutBegin 
                        + "<FORM NAME=\"form"+count+ "\" METHOD=\"POST\">"
                        + "<INPUT TYPE=\"IMAGE\" src=\"img\\delete.png\" width=\"40px\" NAME=\"submit\" VALUE=\""+fileName+"\">"
                        + "</FORM>" 
                        + "<img src=\"" + relativePath + fileName + "\"" + "width=\"150\"" + "height=\"150\"" + "alt=\"profile\"" + ">"  
                        + webLayoutEnd;
            }
            count++;
        }
    }
    
    public void deleteImage(String name){
        try{

        File file = new File("H:\\ZHAW\\netbean\\unidate\\unidate\\build\\web\\uploadFiles\\"+name);

        if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
        }else{
                System.out.println("Delete operation is failed.");
        }

    	}catch(Exception e){
 
    		e.printStackTrace();
    	}
   
    }
    
    public String getOutput(){
        return fileNameOutput;   
    }
}
