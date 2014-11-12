            <%@page import="bean.TextFileReader"%>
            <%
            if ("TRUE".equals(session.getAttribute("session"))){
                response.sendRedirect("dashboard");
            }
            %>
    <div class="row">
      <div class="large-12 columns">
	        <h2>unidate</h2>
	        <p>unidate ist eine Datingplattform für Studierende. Es ist ganz einfach Kontakt mit neuen Studierenden zu knüpfen. Das Vorgeschlagene Bild liken oder disliken. Wenn ihr beide euch mögt könnt ihr miteinander chatten. Viel Spass </p>
      </div>
    </div>

    <div class="row">
		<div class="large-6 medium-6 columns">
			<h3>Anmelden</h3>
                        <form action="loginProcess">
				<div class="row">
					<div class="large-6 medium-6 columns">
					  <label>Benutzername</label>
					  <input type="text" placeholder="Benutzername" />
					</div>
					  <div class="large-6 medium-6  columns">
					  <label>Passwort</label>
					  <input type="password" placeholder="Passwort" />
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
					 <a href="#" class="small round button">Anmelden</a><br/> 
					</div>
				</div>
			 </form>
		</div>     

		<div class="large-6 medium-6 columns">
			<h3>Registration</h3>
			<form action="registrationProcess">
				<div class="row">
					<div class="large-6 medium-6 columns">
					  <label>Vorname</label>
					  <input type="text" placeholder="Vorname" />
					</div>
					<div class="large-6 medium-6 columns">
					  <label>Nachname</label>
					  <input type="text" placeholder="Nachname" />
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
					  <label>Benutzername</label>
					  <input type="text" placeholder="Benutzername" />
					</div>
				</div>
				<div class="row">
					<div class="small-12 columns">
					  <div class="row collapse">
						<label>Studenten E-Mail Adresse</label>
						<div class="small-9 columns">
						  <input type="text" placeholder="E-Mail Adresse" />
						</div>
						<div class="small-3 columns">
						  <span class="postfix round">.ch</span>
						</div>
					  </div>
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
					  <label>Immatrikulations Nummer (zur Überprüfung, wird danacht nicht weiter verwendet)</label>
					  <input type="text" placeholder="Immatrikulations Nummer" />
					</div>
				</div>
				<div class="row">
					<div class="large-6 medium-6  columns">
					  <label>Passwort</label>
					  <input type="password" placeholder="Passwort" />
					</div>
					<div class="large-6 medium-6 columns">
					  <label>Passwort Wiederholen</label>
					  <input type="password" placeholder="Passwort Wiederholen" />
					</div>
				</div>
				<div class="row">
					<div class="large-12 columns">
						<a href="#" class="small round button">Registrieren</a><br/> 
					</div>
				</div>
			</form>
		</div>
    </div>