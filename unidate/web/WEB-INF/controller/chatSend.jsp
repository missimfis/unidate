<%@ page pageEncoding="UTF-8" %> 
<%@page import="bean.*"%>   
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
                            

<%  
    int receiverId = 42;;
    message.sendMessage(message.getText(), student.getId(), receiverId);
    response.sendRedirect("chat");
        
%>