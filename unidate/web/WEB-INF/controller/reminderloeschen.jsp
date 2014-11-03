<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<jsp:useBean id="reminder" class="bean.Reminder" scope="session"/>
<!doctype html>

<!-- This jsp file is used to process the data of the forms in kalender_eintrag_bearbeiten.jsp 
and delete an event -->

<%  
    reminder.deleteReminder(event.getId());
    response.sendRedirect("kalender_eintrag_bearbeiten");
 %>
