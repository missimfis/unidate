<%-- On this page existing calendar event details can be changed --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<jsp:useBean id="reminder" class="bean.Reminder" scope="session"/>
<jsp:useBean id="dateFormatter" class="bean.DateFormatter" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="small-12 columns">
        <h1>Eintrag bearbeiten, löschen</h1>                        
    </div>
</div>

<form action="terminbearbeiten" method="post" accept-charset="ISO-8859-1">        
    <div class="row">
        <div class="small-6 columns">
            <label>Was
                <input class="editmyform" id="name" name="name" type="text" value="<%out.print(event.getName());%>"/>
            </label>
        </div>
        <div class="small-6 columns">
            <label>Datum
                <input class="editmyform" id="date" name="date" type="datetime-local" 
                       value="<%out.print(dateFormatter.formatEventDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(event.getDateFromEventId(event.getId()))));%>"/>   
            </label>
        </div>
    </div>

    <div class="row">
        <div class="small-12 columns">
            <label>Beschreibung
                <input class="editmyform" id="description" name="description" type="text" value="<% out.print(event.getDescription());%>"/>
            </label>
        </div>
        <input class="editmyform" id="id" style="display:none;" name="id" type="text" value="<% out.print(event.getId());%>"/>
    </div>
    <div class="row">
        <div class="small-3 columns">
            <input id="edit" class="button small" type="submit" value="Änderung speichern" />
        </div>		
</form>
<form action="terminloeschen" method="post" accept-charset="ISO-8859-1">
    <div class="small-3 columns">
        <input id="edit" class="button small" type="submit" value="Eintrag löschen" /> 
    </div>
    <!-- the attributes of the choosen event were written in the input field --> 
    <input class="editmyform" id="id" style="display:none;" name="id" type="text" value="<%event.getId();%>"/>

</form> <%-- If no reminder exists, a new one can be generated --%>
<% if (!reminder.reminderExists(event.getId())) { %>                    
<form action="reminderadministration" method="post" accept-charset="ISO-8859-1">
    <div class="small-3 columns">
        <input id="edit" class="button small" name="" type="submit" value="Reminder erstellen" /> 
    </div>
</form>
<%}%>
</div>

<%-- Show reminder details if a reminder exists --%>
<% if (reminder.reminderExists(event.getId())) { /** change details of existing reminder **/ %>           
<form action="reminderadministration" method="post" accept-charset="ISO-8859-1">        
    <div class="row">
        <div class="small-6 columns">
            <label>Reminder Datum
                <input class="editmyform" id="Reminderdate" name="Reminderdate" type="datetime-local" value="<% out.print(dateFormatter.formatEventDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(reminder.getDateFromEventId(event.getId())))); %>"/>
            </label>
        </div>
    </div>
    <div class="row">                
        <div class="small-3 columns">
            <input id="Reminderedit" class="button small" type="submit" value="Reminder speichern" />
        </div>
</form>  <%-- Delete an existing reminder --%>                       
<form action="reminderloeschen" method="post">
    <div class="small-9 columns">
        <input id="reminderloeschen" NAME="loeschen" class="button small" type="submit" value="Reminder löschen" />
    </div>
</form>
</div>            

<%}%>      

