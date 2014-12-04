<%@ page pageEncoding="UTF-8" %> 
<%@page import="bean.*"%>   
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
                            

<%  
    int receiverId = 42;
   // message.setMatchedStudent(Integer.parseInt(request.getParameter("id")));
   out.println("id " + receiverId);
   message.setMatchedStudent(Integer.parseInt(request.getParameter("match")));
   response.sendRedirect("chat");
        
%>
