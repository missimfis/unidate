<%-- On this page a user can create and send a new message 
or answer/forward incoming messages--%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.*"%>  
<jsp:useBean id="user" class="bean.User" scope="session"/> 
<jsp:useBean id="message" class="bean.Message" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>
<jsp:useBean id="dateFormatter" class="bean.DateFormatter" scope="session"/>

<div class="row">
    <div class="medium-12 columns">
        <h1>Nachrichten</h1>
    </div>
</div>
<form id="messageSend" action="nachrichtenProcess" method="post" accept-charset="ISO-8859-1">
    <div class="row">
        <div class="small-12 columns">
            <table>
                <tbody>
                    <tr><%-- On message answer the addressee is already set --%>
                        <% if (request.getParameter("to") != null) {%>
                <input type="hidden" name="messageAddress" value="<%=request.getParameter("to")%>">
                <th>Empfaenger</th>
                <td><%-- Get the name of the addressee --%>
                    <%=user.getUserInfos(Integer.valueOf(request.getParameter("to"))).getUsername()%>
                </td>
                <% } else { %> <%-- One or many addressees can be chosen from a multipleSelect --%>
                <th title="Mit gedrückter Ctrl Taste können mehrere Empfänger ausgewählt werden">Empfaenger</th>
                <td title="Mit gedrückter Ctrl Taste können mehrere Empfänger ausgewählt werden">
                    <select name="addressees" multiple="" size="4" id="selectAddressees" class="multipleSelect" title="Mit gedrückter Ctrl Taste können mehrere Empfänger ausgewählt werden">
                        <%  List<User> users = klasse.getCourseMembers(
                                    klasse.getCourseIdFromUserId(user.getId()));
                            for (User aUser : users) {
                        %><option value="<%out.print(aUser.getId());%>"><%out.print(aUser.getUsername());%></option>
                        <% } %>
                    </select>
                </td>
                <% } %>
                </tr>
                <tr>
                    <th>Betreff</th> <%-- The message title will be automatically set if its an answer or forward message --%>
                    <td><input id="messageTitle" type="text" name="messageTitle" size="30" autofocus <% if (request.getParameter("to") != null || request.getParameter("fw") != null) {
                            Message actualMessage = message.loadMessage(Integer.parseInt(request.getParameter("N")));
                            String placeholder = "WG";
                            if (request.getParameter("to") != null) {
                                placeholder = "AW";
                            }
                               %>value="<%=placeholder%>: <%= actualMessage.getTitle()%>"<% }%> />
                    </td>
                </tr>
                <tr>
                    <th>Inhalt</th> <%-- If it's a forward or answer message, the old text will be inserted
                    and additional infos (timestamp) added. --%>
                    <td><pre><textarea id="messageText" class="messages" rows="15" name="messageContent"><% if (request.getParameter("to") != null || request.getParameter("fw") != null) {
                            Message actualMessage = message.loadMessage(Integer.parseInt(request.getParameter("N")));
                                %>

______________________________________________
Von: <%= user.getUserInfos(actualMessage.getFrom()).getFirstname()%> <%= user.getUserInfos(actualMessage.getFrom()).getSurname()%> (<%= user.getUserInfos(actualMessage.getFrom()).getUsername()%>)
Gesendet: <%=dateFormatter.formatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(actualMessage.getSentDate()))%>
An: <%= user.getFirstname()%> <%= user.getSurname()%> (<%= user.getUsername()%>)
Betreff: <%= actualMessage.getTitle()%>

                                <%= actualMessage.getText()%><% }%></textarea></pre></td>
                </tr>
                </tbody>
            </table>
            <input id="sendMessage" class="button" type="submit" value="Senden" />
        </div>	  
    </div>
</form>
