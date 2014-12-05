<%@page import="bean.TextFileReader"%>
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<div class="row">
    <div class="medium-12 columns">
        <% session.invalidate(); %>
        Sie haben sich nun erfolgreich aufgeloggt.<% out.print(student.getFirstname() + " " + student.getSurname() + ".</p>");%></p>
    </div>
</div>	