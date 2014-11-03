<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<!doctype html>

<!-- This jsp file is used to process the data of the forms in klasse.jsp.
    It's like a "transfer file" -->

<%  //delets the chosen event
    event.deleteEvent(event.getId());
    response.sendRedirect("kalender");
 %>
