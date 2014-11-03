<%-- This page opens after a successful user registration --%>
<%@page import="bean.*"%>  
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>

	<div class="row">
		<div class="medium-12 columns">
			<h1>Registrierung</h1>
			<p>
                            Willkommen <% out.print(user.getFirstname() + " " + user.getSurname());  %> auf der Plattform lemas. Die Registrierung war erfolgreich.
			</p>
		</div>
	</div>
