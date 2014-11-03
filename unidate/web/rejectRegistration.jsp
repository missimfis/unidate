<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.*"%>  
<div class="row">
    <div class="medium-6 columns">
        <%= TextFileReader.parse("webapps/lemas/txt/WelcomeTextDE.txt")%>
    </div>
    <div class="medium-6 columns registration">
        <h2>Registrierung</h2>
        <form id="registrierung" action="registrationProcess" method="post" accept-charset="ISO-8859-1">
            <input class="regform" id="regbenutzername" type="text" name="username" size="15" 
                   <% if (errorText.getError("userName") == null) {%>
                   value="<%=session.getAttribute("userName")%>" style="color:black"
                   <%} else {%> 
                   placeholder="<%=errorText.getError("userName")%>" style="color:red" onfocus="this.style.color = 'black'"
                   <%}%>/>
            <input class="regform" id="regvorname" type="text" name="firstname" size="15"
                   <% if (errorText.getError("firstName") == null) {%>
                   value="<%=session.getAttribute("firstName")%>" style="color:black"
                   <%} else {%> 
                   placeholder="<%=errorText.getError("firstName")%>" style="color:red" onfocus="this.style.color = 'black'"
                   <%}%>/>
            <input class="regform" id="regnachnahme" type="text" name="surname" size="15"
                   <% if (errorText.getError("surName") == null) {%>
                   value="<%=session.getAttribute("surName")%>" style="color:black"
                   <%} else {%> 
                   placeholder="<%=errorText.getError("surName")%>" style="color:red" onfocus="this.style.color = 'black'"
                   <%}%>/>
            <input class="regform" id="regemail" type="text" name="email" size="15"
                   <% if (errorText.getError("email") == null) {%>
                   value="<%=session.getAttribute("email")%>" style="color:black"
                   <%} else {%> 
                   placeholder="<%=errorText.getError("email")%>" style="color:red" onfocus="this.style.color = 'black'"
                   <%}%>/>
            <input class="regform" id="regpasswort" type="password" name="password" size="15"
                   <% if (errorText.getError("password") == null) {%>
                   value="<%=session.getAttribute("password")%>" style="color:black"
                   <%} else {%> 
                   placeholder="<%=errorText.getError("password")%>" style="color:red" onfocus="this.style.color = 'black'"
                   <%}%>/>
            <input class="regform button" id="regbutton" type="submit" value="Anmelden" />						
        </form>
    </div>
</div>
<% errorText.deleteAll(); %>
<% session.invalidate();%>
