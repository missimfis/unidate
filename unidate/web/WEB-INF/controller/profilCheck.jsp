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
    String interest = request.getParameter("interesse");
    int age = Integer.parseInt(request.getParameter("age"));
    int minAge = Integer.parseInt(request.getParameter("minAge"));
    int maxAge = Integer.parseInt(request.getParameter("maxAge"));
    

    student.editUserProfile(userId, firstname, lastname, gender, department, studium, about, interest, age, minAge, maxAge);
    response.sendRedirect("profil_bearbeiten");
%>
