<%-- On this page a file can be uploaded into a chosen folder --%>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>
<jsp:useBean id="errorText" class="bean.ErrorText" scope="session"/>
<div class="row">
    <div class="medium-12 columns">
         <h1><% // title selection
             if (request.getParameter("dam_action") != null) {
                 if (request.getParameter("dam_action").equals("delete")) {
                     out.print("Löschen");
                 } else if (request.getParameter("dam_action").equals("newfolder")) {
                     out.print("Neuer Ordner erstellen");
                 } else if (request.getParameter("dam_action").equals("fileupload")) {
                     out.print("Datei hochladen");
                 } else {
                     response.sendRedirect("dateien");
                 }
             }
            %></h1>
    </div>
</div>
<% if (request.getParameter("dam_action") != null
            && !(request.getParameter("dam_action").equals("choose"))
            && !request.getParameter("dam_action").equals("delete")) {
        // seperating the different form definitions
        if (request.getParameter("dam_action") != null
                && (request.getParameter("dam_action").equals("fileupload"))) {
            out.print("<form action=\"#\" method=\"post\" enctype=\"multipart/form-data\">");
        } else {
            out.print("<form action=\"#\" method=\"post\">");
        }
// add hidden field to get the parameter of the selected thing
// through this side to the location wanted
        if (request.getParameter("selectedFile") != null
                && !(request.getParameter("selectedFile").contains("."))) {
            out.print("<input type=\"hidden\" name=\"selectedFile\" value=\""
                    + request.getParameter("selectedFile") + "\">");
        } %>
<div class="row">
    <div class="small-12 columns"><%
// display the right fields from the given parameters
        if (request.getParameter("dam_action") != null
                && request.getParameter("dam_action").equals("newfolder")) {%>
        <div class="form-group">
            <label for="title">Ordnername:</label>
            <input name="foldername" type="text" placeholder="MeinOrdner">
        </div>
        <% } else if (request.getParameter("dam_action").equals("fileupload")
                    || request.getParameter("dam_action").equals("edit")) { %>
        <div class="form-group">
            <label for="file">Datei hochladen:</label>
            <input name="file" type="file">
        </div>
        <% } %>
    </div>
    <div class="form-group">
        <div class="small-3 columns">
            <input name="save" type="submit"
                   class="button small" value="Speichern">
        </div>
        <div class="small-3 columns">
            <input name="abort" type="reset"
                   class="button small" value="Abbrechen">
        </div>
        <div class="small-6 columns">
        </div>
    </div>
</form>
</div>
<% } else {
        out.print("<div =\"row\"><div class=\"small-12 columns\">");
        // error or sucess message displaying
        if (errorText.getError("filehandling") != null) {
            out.print(errorText.getError("filehandling"));
        }
        out.print("</div></div>");
    }%>