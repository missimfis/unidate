<%@page import="bean.TextFileReader"%>
<%
    if ("TRUE".equals(session.getAttribute("session"))) {
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
        <form action="loginProcess" method="POST">
            <div class="row">
                <div class="large-6 medium-6 columns">
                    <label>Benutzername</label>
                    <input type="text" placeholder="Benutzername" name="username" />
                </div>
                <div class="large-6 medium-6  columns">
                    <label>Passwort</label>
                    <input type="password" placeholder="Passwort" name="password"/>
                </div>
            </div>
            <div class="row">
                <div class="large-12 columns">
                    <input type="submit" class="small round button" value="Anmelden"><br/> 
                </div>
            </div>
        </form>
    </div>     

    <div class="large-6 medium-6 columns">
        <h3>Registration</h3>
        <form action="registrationProcess" method="POST">
            <div class="row">
                <div class="large-6 medium-6 columns">
                    <label>Vorname</label>
                    <input type="text" placeholder="Vorname" name="firstname"/>
                </div>
                <div class="large-6 medium-6 columns">
                    <label>Nachname</label>
                    <input type="text" placeholder="Nachname" name="surname" />
                </div>
            </div>
            <div class="row">
                <div class="large-12 columns">
                    <label>Benutzername</label>
                    <input type="text" placeholder="Benutzername" name="username" />
                </div>
            </div>
            <div class="row">
                <div class="small-12 columns">
                    <div class="row collapse">
                        <label>Studenten E-Mail Adresse</label>
                        <div class="small-9 columns">
                            <input type="text" placeholder="E-Mail Adresse" name="email" />
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
                    <input type="text" placeholder="Immatrikulations Nummer"name="matrikelnumber" />
                </div>
            </div>
            <div class="row">
                <div class="large-6 medium-6  columns">
                    <label>Passwort</label>
                    <input type="password" placeholder="Passwort" name="password" />
                </div>
                <div class="large-6 medium-6 columns">
                    <label>Passwort Wiederholen</label>
                    <input type="password" placeholder="Passwort Wiederholen" name="password_repeated" />
                </div>
            </div>
            <div class="row">
                <div class="large-12 columns">
                    <input type="submit" class="small round button" value="Registrieren" /><br/> 
                </div>
            </div>
        </form>
    </div>
</div>