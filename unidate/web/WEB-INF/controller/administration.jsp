<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>


<!-- This jsp file is used to process the data of the forms in klasse.jsp.
    It's like a "transfer file" -->


<!-- Accept a request -->

<% if(request.getParameter("Antrag") != null && !"Antrag wählen".equals(request.getParameter("Antrag"))){ 
klasse.acceptRequest(user.getIdFromUsername(request.getParameter ("Antrag")), klasse.getCourseIdFromUserId(user.getId())); } %>                      
 
<!-- Delete a request -->

<% if(request.getParameter("Antragablehnen") != null && !"Antrag wählen".equals(request.getParameter("Antragablehnen"))){ 
klasse.deleteRequest(user.getIdFromUsername(request.getParameter ("Antragablehnen")), klasse.getCourseIdFromUserId(user.getId())); } %>

<!-- Edits User properties -->

<% if(request.getParameter("myNewFirstName")!=null||request.getParameter("myLastName")!=null||request.getParameter("myEmail")!=null||request.getParameter("myPassword1")!=null||request.getParameter("myPassword2")!=null){
user.editUserProperties(user.getId(),request.getParameter("myNewFirstName"),request.getParameter("myLastName"),request.getParameter("myEmail"),request.getParameter("myPassword1"),request.getParameter("myPassword2"));}  %>  

<!-- Edits User properties -->

<% if(request.getParameter("PersonBearbeiten") != null && !"Person wählen".equals(request.getParameter("PersonBearbeiten"))){
klasse.editUserProperties(user.getIdFromUsername(request.getParameter("PersonBearbeiten")),klasse.getCourseIdFromUserId(user.getId()), request.getParameter("EditEmail"),request.getParameter("EditPassword1"),request.getParameter("EditPassword2")); }%>

<!-- Removes a person from a course -->

<% if(request.getParameter("Personloeschen") != null && !"Person wählen".equals(request.getParameter("Personloeschen")))
{klasse.removePerson(user.getIdFromUsername(request.getParameter ("Personloeschen")));} %> 
 
<!-- Leave a course -->

<% if(request.getParameter("austreten")!=null){ 
klasse.removePerson(user.getId());} %>

<!-- send invitation -->

<% if(request.getParameter("adden") != null && !"Person wählen".equals(request.getParameter("adden"))){ 
klasse.sendInvitation(user.getIdFromUsername(request.getParameter ("adden")),klasse.getCourseIdFromUserId(user.getId()));} %>

<!-- create a new course -->

<% if(request.getParameter("Klasse")!=null){ 
klasse.createCourse(request.getParameter("Klasse"),user.getId());}%>

<!-- creates a request for a course -->

<% if(request.getParameter("Antragwaehlen") != null && !"Klasse wählen".equals(request.getParameter("Antragwaehlen"))){
klasse.createRequest(user.getId(),klasse.getIdFromClassname(request.getParameter("Antragwaehlen")));}%> 
 
<!-- assign a new course administrator -->

<% if(request.getParameter("Adminwerden")!=null){ 
klasse.assignNewAdmin(klasse.getCourseIdFromUserId(user.getId()),klasse.getAdminIdForUserId(user.getId()),user.getId());} %>

<!-- accept an invitation -->

<% if(request.getParameter("Einladungwaehlen") != null && !"Einladung wählen".equals(request.getParameter("Einladungwaehlen"))){
  klasse.acceptInvitation(user.getId(),klasse.getIdFromClassname(request.getParameter("Einladungwaehlen")));}%>  

<!-- creates a request to change the course administrator -->  
  
<% if(!"Person wählen".equals(request.getParameter("neuerAdmin")) && request.getParameter("neuerAdmin") != null){
klasse.newAdministratorSwitch(user.getId(),user.getIdFromUsername(request.getParameter("neuerAdmin")),klasse.getCourseIdFromUserId(user.getId()));} %> 

<% response.sendRedirect("klasse"); %>
