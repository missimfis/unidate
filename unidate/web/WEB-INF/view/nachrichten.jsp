<%-- On this page all messages for a certain user will be displayed in a list --%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.*"%>  
<jsp:useBean id="user" class="bean.User" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>
<jsp:useBean id="event" class="bean.Event" scope="session"/>
<jsp:useBean id="reminder" class="bean.Reminder" scope="session"/>
<jsp:useBean id="dateFormatter" class="bean.DateFormatter" scope="session"/>
<%  // checks if a reminder ist to be set and sets it if so
    reminder.checkAndGenerateReminder(event, message);
%>

<div class="row">
    <div class="medium-12 columns">
        <h1>Nachrichten</h1>
    </div>
</div>
<form action="nachrichtenProcess" method="POST">
    <div class="row">
        <div class="small-4 columns">
            <label>
                <select name="manyAction">
                    <option value="action">Aktion wählen</option>
                    <option value="deleteMany">Löschen</option>
                </select>
            </label>
        </div>
        <div class="small-4 columns">
            <input id="choosebutton" class="button tiny" type="submit" 
                   value="&Uuml;bernehmen" />
        </div>
        <div class="small-4 columns">
            <input id="newMessageButton" name="nachricht" formmethod="post" 
                   formaction="nachrichten_senden" class="button tiny" 
                   type="submit" value="Neue Nachricht" />
        </div>
    </div>
    
    <div class="row">
        <div class="small-12 columns">
            <table>
                <thead>
                    <tr>
                        <th>&nbsp;</th>
                        <th>Betreff</th>
                        <th width="300">Von</th>
                        <th width="300">Gesendet</th>
                    </tr>
                </thead>
                <tbody>
                    <% // generates a table of the messages for the user
                        List<Message> messages = message.loadMessages(user.getId());
                        for (int i = 0; i < messages.size(); i++) {%>
                    <tr>
                        <td><input type="checkbox" id="checkbox<%=messages.get(i).getId()%>" 
                                   name="messageId" value="<%=messages.get(i).getId()%>"></td>
                        <td><a href="nachrichten_detail?P=<%=messages.get(i).getTo()%>&N=<%=messages.get(i).getId()%>" 
                               <% if (!messages.get(i).isIsRead()) {%>
                               style="font-weight:bold"<%}%>><%=messages.get(i).getTitle()%></a></td>
                        <td><%= user.getUserInfos(messages.get(i).getFrom()).getUsername()%></td>
                        <td><%=dateFormatter.formatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(messages.get(i).getSentDate()))%></td>

                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>	  
    </div>
</form>
