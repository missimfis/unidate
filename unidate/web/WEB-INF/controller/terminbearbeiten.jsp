<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<!doctype html>

<!-- This jsp file is used to process the data of the forms in termin.jsp.
    It's like a "transfer file" -->

<%  //Sets the new attributes of a Termin and saves into db.
    event.setId(Integer.parseInt(request.getParameter("id")));
    event.setName(request.getParameter("name"));
    event.setDescription(request.getParameter("description"));
    event.setStringDate(request.getParameter("date"));
    event.editEvent(event.getId(), event.getName(), event.getDescription(), event.getStringDate());
    response.sendRedirect("kalender");
    %>
