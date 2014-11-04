package bean;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ProfileUpdate extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	
	    String email = request.getParameter("email");
	    String first = request.getParameter("first");
	    String last = request.getParameter("last");
	    int matrikNR = Integer.parseInt(request.getParameter("matrikNR"));
	    try{
	    
	    //loading driver 
	    Class.forName("com.mysql.jdbc.Driver");

	    //creating connection with the database 
        Connection  con=DriverManager.getConnection
                     ("jdbc:mysql://localhost/unidate","unidate","unidatepw");	
        
        
        
  	// *********************************user_id is fix atm*********************************************			
      	String query = "UPDATE users SET email=?, first=?, last=?, matrikNR=? WHERE user_id=10";  
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, first);
        ps.setString(3, last);
        ps.setInt(4, matrikNR);
        

        ps.executeUpdate();       
        int i=ps.executeUpdate();
        con.close();
        if(i>0)
        {
        	out.println("User succesfully inserted");
        }

        }catch(Exception se)
        {
            se.printStackTrace();
        }finally{
        	
            // Set response content type
            response.setContentType("text/html");

            // New location to be redirected
            String site = new String("http://localhost:8080/userProfile.jsp");

            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);    
        }
		
      }
	
}
