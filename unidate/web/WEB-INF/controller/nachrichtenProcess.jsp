<%-- controller to process messages --%>
<%@page import="java.util.Enumeration"%>
<%@page import="bean.*"%>  
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="message" class="bean.Message" scope="session"/>
<jsp:useBean id="errorText" class="bean.ErrorText" scope="session"/>
<%      // if one message is selected to delete
        if (("delete").equals(request.getParameter("oneAction"))) {
            message.deleteMessage(message.getId());
            response.sendRedirect("nachrichten");
        } 
        // if many messages are selected to delete
        else if (("deleteMany").equals(request.getParameter("manyAction"))) {
            String[] toDelete = request.getParameterValues("messageId");
            for (String id : toDelete) {
                message.deleteMessage(Integer.valueOf(id));
            }
            response.sendRedirect("nachrichten");
        // if a message ist to be answered
        } else if (("answer").equals(request.getParameter("oneAction"))){
            String messageSender = request.getParameter("messageSender");
            String id = request.getParameter("messageId");
            response.sendRedirect("nachrichten_senden?to=" + messageSender + "&N=" + id);
        // if a message is to be forwarded    
        } else if (("forward").equals(request.getParameter("oneAction"))){
            String messageSender = request.getParameter("messageSender");
            String id = request.getParameter("messageId");
            response.sendRedirect("nachrichten_senden?fw=" + messageSender + "&N=" + id);
        // sends many messages if addressees are selected    
        }else if (request.getParameter("addressees") != null) {
            String[] addressees = request.getParameterValues("addressees");
            for (String adressee : addressees) {
                message.sendMessage(user.getId(), Integer.valueOf(adressee), request.getParameter("messageTitle"), request.getParameter("messageContent"));
            }
            response.sendRedirect("nachrichten");
        // sends one message if only one addressee is selected    
        } else if (request.getParameter("messageAddress") != null){
            message.sendMessage(user.getId(), Integer.valueOf(request.getParameter("messageAddress")), request.getParameter("messageTitle"), request.getParameter("messageContent"));
            response.sendRedirect("nachrichten");
        }
        else {response.sendRedirect("nachrichten");}
%>

