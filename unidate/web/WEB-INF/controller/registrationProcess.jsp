<%-- controller to register a user --%>
<%@page import="bean.*"%>  
<jsp:useBean id="student" class="bean.Student" scope="session"/>
<jsp:setProperty property="*" name="student"/>  
<%
    Unidate unidate = new Unidate();
    unidate.setStudent(student);
    if (unidate.register()) { // if user registration is successful
            session.setAttribute("session","TRUE"); 
            session.setAttribute("userData", student);
            session.setAttribute("userID", student.getId());
            response.sendRedirect("registriert");
    } else { // if user registration fails
           session.setAttribute("username", student.getUsername());
           session.setAttribute("firstname", student.getFirstname());
           session.setAttribute("surname", student.getSurname());
           session.setAttribute("email", student.getEmail());
           session.setAttribute("password", student.getPassword());
           response.sendRedirect("rejectRegistration.jsp");
    }
%>

