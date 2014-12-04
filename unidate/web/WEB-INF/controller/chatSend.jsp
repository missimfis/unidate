<%@ page pageEncoding="UTF-8" %>
<%@page import="bean.*"%>   
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>
                            

<%  
    int matchId=1;
    //String text=request.getParameter("text");
    //int studentId = student.getId();
    message.setMatchedStudent(1337);
    message.setText(request.getParameter("text"));
    message.setFrom(student.getId());
    message.sendMessage(matchId, message.getText(), message.getFrom());

    
%>
<%--
   // Rederict to chat.jsp
   String site = new String("http://localhost:8084/unidate/chat.jsp");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
--%>