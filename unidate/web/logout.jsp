<%@page import="bean.TextFileReader"%>
<jsp:useBean id="user" class="bean.User" scope="session"/> 
<div class="row">
    <div class="medium-12 columns">
        <% session.invalidate(); %>
        <%= TextFileReader.parse("webapps/unidate/txt/LogoutTextDE.txt")%><% out.print(user.getFirstname() + " " + user.getSurname() + ".</p>");%></p>
    </div>
</div>	