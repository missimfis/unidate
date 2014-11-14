<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="student" class="bean.Student" scope="session"/> 


<jsp:setProperty property="*" name="student"/>  

<!-- If the userinfos are valid the system checks whether open reminders exist or not.
     It will generate new reminders. When the userinfos are not valid the user is 
     forwarded to rejectLogin.jsp
-->

<%
    if (student.validate()) { // checks if user login is valid
        session.setAttribute("session", "TRUE");
        session.setAttribute("userData", student);
        session.setAttribute("userID", student.getId());           
        response.sendRedirect("dashboard");
} else {
        response.sendRedirect("rejectLogin.jsp");
    }
%>  

