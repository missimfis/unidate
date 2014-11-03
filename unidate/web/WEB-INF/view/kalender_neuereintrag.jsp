<%-- On this page a new calendar event can be generated --%>
<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>

<div class="row">
    <div class="small-12 columns">
        <h1>Neuer Eintrag</h1>
    </div>
</div>
<form accept-charset="ISO-8859-1" method="POST" action="terminneu">
    <div class="row">
        <div class="small-6 columns">
            <label>Was
                <input type="text" name="name" placeholder="Terminname" />
            </label>
        </div>
        <div class="small-6 columns">
            <label>Datum
                <input type="datetime-local" name="date" placeholder="tt-mm-jjjj hh:mm" />
            </label>
        </div>
    </div>
    <div class="row">
        <div class="small-12 columns">
            <label>Beschreibung
                <input type="text" name="description" placeholder="Terminbeschreibung" />
            </label>
        </div>
    </div>
    <div class="row">
        <div class="small-12 columns">
            <input id="submit" class="button small" type="submit" value="Eintragen"/>
        </div>	
    </div>
</form>
