<%-- On this page an overview of the upcoming calendar events will be shown --%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.*"%>  
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>
<jsp:useBean id="dateFormatter" class="bean.DateFormatter" scope="session"/>

<div class="row">
    <div class="small-12 columns">
        <h1>Kalender</h1>  
    </div>
</div>
<div class="row">
    <form action="kalender_neuereintrag" method="post">
        <div class="small-12 columns">
            <input id="choosebutton" class="button small" type="submit" value="Neuer Eintrag"/>
        </div>
    </form>
</div>
<div class="row">
    <div class="small-12 columns">
        <!-- shows next 10 events -->  
        <%  //deletes an old Event from Betrifft db
            event.deleteOldEventsfromBetrifft();
            //deletes an old Event from Termin db
            event.deleteOldEventsfromTermin();
            //set the Number of next events, which should be shown.
            event.setNumberOfEvents(10);
            List<Event> eventlist = event.getEvent(user.getCourse());
            int listenlaenge;
            if (eventlist.size() < event.getNumberOfEvents()) {
                listenlaenge = eventlist.size();
            } else {
                listenlaenge = event.getNumberOfEvents();
            }
            for (int r = 0; r < listenlaenge; r++) {
        %>
        <!-- design specific, per row 5 events... starts a row -->       
        <% if (r == 0 || r == 5) {%>
        <div class="row">
            <%}%>
            <a href="terminset?id=<% out.print(eventlist.get(r).getId()); %>" method="post"><div class="small10 columns">
                    <div class="calender">

                        <h2><% out.print(eventlist.get(r).getName()); %></h2>
                        <h3><% out.print(eventlist.get(r).getDescription()); %></h3>
                        <p><% out.print(dateFormatter.formatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(eventlist.get(r).getDate()))); %></p>
                    </div>
                </div></a>
            <!-- design specific, per row 5 events... ends a row --> 
            <% if (r == 4 || r == 9) {%>
        </div>
        <% } %>
        <% }%>                  
    </div>
</div>
