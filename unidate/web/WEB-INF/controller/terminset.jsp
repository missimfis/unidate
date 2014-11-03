<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>

<!-- This jsp file is used to process the data of the forms in kalender_eintrag_bearbeiten.jsp.
    It's like a "transfer file" -->

<%  //takes the id from url and forwart to kalender_eintrag_bearbeiten.jsp
    event.setId(Integer.parseInt(request.getParameter("id")));
    event.setEvent(event.getId());
    event.setDate(new Date());
    out.print(event.getId());
    response.sendRedirect("kalender_eintrag_bearbeiten"); 
%>
