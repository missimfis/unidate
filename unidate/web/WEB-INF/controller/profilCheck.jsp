<%@ page pageEncoding="UTF-8" %>                            
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<%@page import="bean.*"%>  



<%  
    int userId = student.getId();
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String gender = request.getParameter("geschlecht");
    String department = request.getParameter("department");
    String studium = request.getParameter("studium");
    String about = request.getParameter("about");
    

    student.editUserProfile(userId, firstname, lastname, gender, department, studium, about);
    response.sendRedirect("profil_bearbeiten");
%>


<%--
   // New location to be redirected
   String site = new String("http://localhost:8084/unidate/profil_bearbeiten.jsp");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
--%>