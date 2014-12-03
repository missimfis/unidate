<%@ page pageEncoding="UTF-8" %>
<%@page import="bean.*"%>   
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>
                            

<%  
    int id = 1;
    int matchId=1;
    String text="blabla";
    int from=27;
    message.sendMessage(1, "blabla", 7);
    message.setTo(5);
    message.setMatchedStudent(2);
    message.setFrom(student.getId());
    message.setIsRead(false);
    message.setText(request.getParameter("text"));
    
    
    
    out.println(id+ "<br>");
    out.println(student.getId() + "<br>");
    out.println(matchId+ "<br>");  
    out.println(message.getText()+ "<br>");
    
%>
