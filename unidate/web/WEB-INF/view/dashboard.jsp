<%-- This page grants an overview over new events, files and messages.
You will reach it, when clicking on the header. --%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.*"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<jsp:useBean id="user" class="bean.User" scope="session"/> 
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>
<jsp:useBean id="dateFormatter" class="bean.DateFormatter" scope="session"/>
<jsp:useBean id="message" class="bean.Message" scope="session"/>

<div class="row">
    <div class="medium-9 columns">
        <h1>Dashboard</h1>
    </div
    <dd><a href="nachrichten">
            <%-- Will be shown if unread messages exist --%>
        <div class="medium-3 columns" id="neueNachricht">
            <% if(message.unreadMessagesExist(user.getId())){
            %>
            <img src="img/message.png" alt="lemas Logo" height="24" width="16">  Neue Nachricht             
            <%}
            %>   
         </div> 
    </a></dd> 
</div>

<div class="row">
    <div class="large-6 medium-6 columns">
        <h2><a href="kalender">N&auml;chste Termine</a></h2>
        <div class="row">
            <!-- Show the next 4 events -->  
            <%  event.deleteOldEventsfromBetrifft(); // delete old events first
                event.deleteOldEventsfromTermin();
                event.setNumberOfEvents(4); // events to be shown

                List<Event> eventlist = event.getEvent(user.getCourse());
                int listenlaenge;
                if (eventlist.size() < event.getNumberOfEvents()) {
                    listenlaenge = eventlist.size();
                } else {
                    listenlaenge = event.getNumberOfEvents();
                }
                for (int r = 0; r < listenlaenge; r++) {
            %>         
            <a href="terminset?id=<% out.print(eventlist.get(r).getId()); %>" method="post"><div class="large-3 medium-3 small-3 columns">
                    <div class="calender">                       
                        <h3><% out.print(eventlist.get(r).getName()); %></h3>
                        <p><% out.print(eventlist.get(r).getDescription()); %><br/>
                            <% out.print(dateFormatter.formatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(eventlist.get(r).getDate()))); %></p>
                    </div>
                </div></a>
                <%
                    } %>         
        </div>
    </div>
    <div class="large-6 medium-6 columns">
        <%-- Show newest files --%>
        <h2><a href="dateien">Neuste Dateien</a></h2>			
        <%
            if (user.getCourse() > 0) {
                Filehandling fhandling = new Filehandling(klasse.getCourseNameFromId(user.getCourse()));
                fhandling.createFolder("");
                List<String> filelist = fhandling.getFiles();
                if (filelist != null && filelist.size() > 0) {
                    out.print("<ul class=\"file-manager-list\">");
                    for (String filename : filelist) {
                        out.print("<li class=\"file\"> <img src=\"img/glyphicons_036_file.png\"> <a href=\"dateiProcess?dam_action=download&&file=" + filename + "\">");
                        out.print(filename.substring(filename.lastIndexOf("/")+1, filename.length()));
                        out.print("</a></li>");
                    }
                    out.print("</ul>");
                }
            }
        %>
    </div>
</div>