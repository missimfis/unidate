<%@ page pageEncoding="UTF-8" %>
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/>                                

<%--jsp:getProperty property="name" name="userinfo"/><br--%> 
<jsp:getProperty property="department" name="userinfo"/><br> 
<jsp:getProperty property="studium" name="userinfo" /><br>
<jsp:getProperty property="about" name="userinfo" /><br>


<%  
    int userId = 1;
    String name = request.getParameter("name");
    String department = request.getParameter("department");
    String studium = request.getParameter("studium");
    String about = request.getParameter("about");
    
    //out.println("<br>" + name + "<br>");
    
    out.println(department+ "<br>");
    
    out.println(studium+ "<br>");
    
    out.println(about+ "<br>");
    

    userinfo.editUserProfile(userId, name, department, studium, about);
%>


<%
   // New location to be redirected
   String site = new String("http://localhost:8084/unidate/profil_bearbeiten.jsp");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
%>