<%-- 
    Document   : updateProcess
    Created on : Nov 11, 2014, 9:32:31 PM
    Author     : Thomas Huynh
--%>

<%@page import="bean.*"%>  
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:setProperty property="*" name="user"/>  
<%
    if (user.register()) { // if user registration is successful
            session.setAttribute("session","TRUE"); 
            session.setAttribute("userData", user);
            session.setAttribute("userID", user.getId());
            response.sendRedirect("updateSuccess");
    } else { // if user registration fails
           session.setAttribute("userName", user.getUsername());
           session.setAttribute("firstName", user.getFirstname());
           session.setAttribute("surName", user.getSurname());
           session.setAttribute("email", user.getEmail());
           session.setAttribute("password", user.getPassword());
           response.sendRedirect("rejectUpdate.jsp");
    }
%>
