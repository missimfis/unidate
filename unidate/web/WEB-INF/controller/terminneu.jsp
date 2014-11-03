<%@page import="java.util.List"%>
<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<!doctype html>

<!-- This jsp file is used to process the data of the forms in termin.jsp and
    create a new event.
    It's like a "transfer file" -->

<%  //Sets the new attributes of an Termin and save into db.
    if (request.getParameter("name") != null || request.getParameter("description") != null || request.getParameter("date") != null) {
        List<User> courseMembers = klasse.getCourseMembers(user.getCourse());
        event.createEvent(request.getParameter("name"), request.getParameter("description"), request.getParameter("date"), courseMembers); 
        response.sendRedirect("kalender");
    }
%>
