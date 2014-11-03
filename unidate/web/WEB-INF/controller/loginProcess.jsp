<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="user" class="bean.User" scope="session"/> 
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>
<jsp:useBean id="message" class="bean.Message" scope="session"/> 
<jsp:useBean id="reminder" class="bean.Reminder" scope="session"/>
<jsp:useBean id="event" class="bean.Event" scope="session"/>


<jsp:setProperty property="*" name="user"/>  

<!-- If the userinfos are valid the system checks whether open reminders exist or not.
     It will generate new reminders. When the userinfos are not valid the user is 
     forwarded to rejectLogin.jsp
-->

<%
    if (user.validate()) { // checks if user login is valid
        session.setAttribute("session", "TRUE");
        session.setAttribute("userData", user);
        session.setAttribute("userID", user.getId());
        
        reminder.checkAndGenerateReminder(event, message);             
        response.sendRedirect("dashboard");
} else {
        response.sendRedirect("rejectLogin.jsp");
    }
%>  

