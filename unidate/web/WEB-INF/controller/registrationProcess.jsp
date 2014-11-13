<%-- controller to register a user --%>
<%@page import="bean.*"%>  
<jsp:useBean id="student" class="bean.Student" scope="session"/>
<jsp:setProperty property="*" name="student"/>  
<%
    if (student.register()) { // if user registration is successful
            session.setAttribute("session","TRUE"); 
            session.setAttribute("userData", student);
            session.setAttribute("userID", student.getId());
            response.sendRedirect("registriert");
    } else { // if user registration fails
           session.setAttribute("userName", student.getUsername());
           session.setAttribute("firstName", student.getFirstname());
           session.setAttribute("surName", student.getSurname());
           session.setAttribute("email", student.getEmail());
           session.setAttribute("password", student.getPassword());
           response.sendRedirect("rejectRegistration.jsp");
    }
%>

