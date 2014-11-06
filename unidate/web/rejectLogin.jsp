<%@page import="bean.TextFileReader"%>
<div class="row">
    <div class="medium-6 columns">
        <%= TextFileReader.parse("webapps/unidate/txt/WelcomeTextDE.txt")%>
    </div>
    <div class="medium-6 columns registration">
        <h2>Registrierung</h2>
        <form id="registrierung" action="registrationProcess" method="post" accept-charset="ISO-8859-1">
            <input class="regform" id="regbenutzername" type="text" name="username" size="15" placeholder="Benutzername" />
            <input class="regform" id="regvorname" type="text" name="firstname" size="15" placeholder="Vorname" />
            <input class="regform" id="regnachnahme" type="text" name="surname" size="15" placeholder="Nachname" />
            <input class="regform" id="regemail" type="text" name="email" size="15" placeholder="Email" />
            <input class="regform" id="regpasswort" type="password" name="password" size="15" placeholder="Passwort"/>
            <input class="regform button" id="regbutton" type="submit" value="Anmelden" />						
        </form>
        <div class="registrationfehler">
        </div>
    </div>
</div>
<% errorText.deleteAll(); %>
<% session.invalidate();%>
