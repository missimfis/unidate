<%@ page pageEncoding="UTF-8" %>
<%@page import="bean.*"%>   
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>
                            

<%  
    int id = 1;
    int matchId=1;
    int userId = student.getId();
   
    String text = request.getParameter("text");
    
    out.println(id+ "<br>");
    out.println(userId+ "<br>");
    out.println(matchId+ "<br>");  
    out.println(text+ "<br>");
%>
