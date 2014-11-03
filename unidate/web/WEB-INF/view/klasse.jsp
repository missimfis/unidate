<%-- This page provides the course overview and is built of many jsp fragment --%>
<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>

<%  boolean isUser = klasse.isUser(user.getId());
    boolean isMember = klasse.isMember(user.getId());
    boolean isAdmin = klasse.isAdministrator(user.getId());
%>

<!--Exists only for Member or Admin -->
<% if (isMember || isAdmin) { %>                      
    <%@include file="../jspf/klasse/courseName.jspf"%>           
<%}%>  

<!--Exists only for Members which are not Admin -->            
<% if (isMember && !isAdmin) { %>                       
    <%@include file="../jspf/klasse/admin.jspf"%>                  
<%}%>   

<!--Exists only if the admin has request for an admin change  --> 
<% if (klasse.userHasAdminRequests(user.getId())) { %>
    <%@include file="../jspf/klasse/adminChange.jspf"%>             
<%}%>  

<!--Exists only for users  -->
<% if (isUser) { %>
    <%@include file="../jspf/klasse/userOnly.jspf"%>
    
<!--Exists only if user has requests  -->
<% if (klasse.userHasRequests(user.getId())) { %>                         
        <%@include file="../jspf/klasse/hasRequests.jspf"%>     
<%}%> 

<!--Generates a new request  -->
<%@include file="../jspf/klasse/newRequest.jspf"%> 
    
    <!--Exists only if user has invitations  -->
<% if (klasse.userHasInvitations(user.getId())) { %>     
        <%@include file="../jspf/klasse/invitation.jspf"%>                                                                   
<%}%> 
    <%@include file="../jspf/klasse/newCourse.jspf"%> 
<%}%>

<!--Exists only for members or admins  -->
<% if (isMember|| isAdmin) { %>
     <%@include file="../jspf/klasse/courseMember.jspf"%> 
<%}%>

<!--Exists only for members which are not admins  -->
<% if (isMember && !isAdmin) { %>
     <%@include file="../jspf/klasse/leaveCourse.jspf"%> 
<%}%>

<!--Exists only for admins -->
<% if (isAdmin) { %>
    <%@include file="../jspf/klasse/adminTools.jspf"%>                          
    
    <!--Exists only when open requests exist -->
<% if (klasse.courseHasRequests(klasse.getCourseIdFromUserId(user.getId()))) { %>   
        <%@include file="../jspf/klasse/proceedingRequest.jspf"%>                                           
<% } %> 
    
    <!--Exists only when open invitations exist -->
<% if (klasse.courseHasInvitations(klasse.getCourseIdFromUserId(user.getId()))) { %> 
        <%@include file="../jspf/klasse/acceptInvitation.jspf"%>
<% } %>                          
    <%@include file="../jspf/klasse/sendInvitation.jspf"%>
<%}%>
<%@include file="../jspf/klasse/allPerson.jspf"%>                               