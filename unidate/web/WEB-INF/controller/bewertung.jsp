<%@ page pageEncoding="UTF-8" %>                            
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<%@page import="bean.*"%>  



<% 
    String rating = request.getParameter("rating");
    if(rating!=null){
    
    if(rating.equals("like")){
        student.like(Integer.parseInt(request.getParameter("id")));
    }
    else if(rating.equals("dislike")){
       //student.dislike(Integer.parseInt(request.getParameter("id")));
       out.println(Integer.parseInt(request.getParameter("id")));
    }
    }
    student.createCandidateList();

    response.sendRedirect("anzeigen");
%>