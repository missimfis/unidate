<%-- On this page a specific message with all details will be shown --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.*"%>  
<jsp:useBean id="user" class="bean.User" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>
<jsp:useBean id="dateFormatter" class="bean.DateFormatter" scope="session"/>
<%    // checks if the requested message parameters are valid and the user is allowed to read the message
    if (request.getParameter("P") != null && request.getParameter("P").equals(Integer.toString(user.getId())) && request.getParameter("N") != null) {
        // sets the opened message as read
        message.setMessageAsRead(Integer.parseInt(request.getParameter("N")));
        // loads the message
        Message actualMessage = message.loadMessage(Integer.parseInt(request.getParameter("N")));
%>

<div class="row">
    <div class="medium-12 columns">
        <h1>Nachrichten</h1>
    </div>
</div>
<div class="row">
    <div class="small-12 columns">

        <table>
            <tbody>
                <tr>
                    <th width="150">Betreff</th>
                    <td><%=actualMessage.getTitle()%></td>
                </tr>
                <tr>
                    <th>Absender</th>
                    <td><%= user.getUserInfos(actualMessage.getFrom()).getUsername()%></td>
                </tr>
                <tr>
                    <th>Gesendet</th>
                    <td><%=dateFormatter.formatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(actualMessage.getSentDate()))%></td>
                </tr>
                <tr>
                    <th>Aktion</th>
                    <td>
                        <form action="nachrichtenProcess" method="POST">
                            <div class="small-4 columns nachrichtendiv"><label> 
                                    <%-- Hidden fields to transmit message infos for messages that are to be forwarded/answered --%>
                                    <input type="hidden" name="messageSender" value="<%=actualMessage.getFrom()%>">
                                    <input type="hidden" name="messageId" value="<%=request.getParameter("N")%>">
                                    <select name="oneAction" class="nachrichtenlabel">
                                        <option value="action">Aktion wählen</option>
                                        <option value="delete">Löschen</option>
                                        <option value="answer">Antworten</option>
                                        <option value="forward">Weiterleiten</option>
                                    </select>
                                </label></div>
                            <div class="small-8 columns nachrichtendiv"><input id="choosebutton" class="button tiny nachrichtenlabel" type="submit" value="&Uuml;bernehmen" /></div>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th>Inhalt</th>
                    <td><pre><%=actualMessage.getText()%></pre></td>
                </tr>
            </tbody>
        </table>
    </div>	  
</div>
<%} else {
%>
<jsp:forward page="nachrichten.jsp"/>
<%
    }
%>