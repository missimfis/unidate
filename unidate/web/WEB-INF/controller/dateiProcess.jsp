<%@page import="bean.*"%>
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>
<jsp:useBean id="errorText" class="bean.ErrorText" scope="session"/>
<%

    String contentType = "";
    // Doing fileupload in this if by checking parameters and calling method
    // saveFile from the class Filehandling
    if (request.getContentType() != null
            && (request.getContentType().indexOf("multipart/form-data") >= 0)) {
        contentType = request.getContentType();
        if (user.getCourse() > 0) {
            Filehandling fhandling = new Filehandling(
                    klasse.getCourseNameFromId(user.getCourse()));
            if (fhandling.saveFile(request, response)) {
                errorText.setError("file_upload_success");
            } else {
                errorText.setError("file_upload_fail");
            }
        }
    } else {
        // If no selection done, redirect back to the page we came from
        if (request.getParameter("dam_action") != null
                && request.getParameter("dam_action").equals("choose")) {
            response.sendRedirect("dateien");
        }
        // Delete File given from parameter if possible
        if (request.getParameter("dam_action") != null
                && request.getParameter("dam_action").equals("delete")) {
            if (user.getCourse() > 0) {
                Filehandling fhandling = new Filehandling(
                        klasse.getCourseNameFromId(user.getCourse()));
                // generating message
                if (request.getParameter("selectedFile") != null
                        && request.getParameter("selectedFile").toString() != ""
                        && fhandling.deleteFile(
                                request.getParameter("selectedFile").toString())) {
                    errorText.setError("file_delete_success");
                } else {
                    errorText.setError("file_delete_fail");
                }
            }
        }
        // Initiate the download
        if (request.getParameter("dam_action") != null
                && request.getParameter("dam_action").equals("download")) {
            if (user.getCourse() > 0) {
                Filehandling fhandling = new Filehandling(
                        klasse.getCourseNameFromId(user.getCourse()));
                fhandling.downloadFile(request.getParameter("file"), response);
            }
        }
        // create a new folder from the name given doing 
        // some validationchecks before
        if (request.getParameter("foldername") != null
                && request.getParameter("foldername") != "") {
            String folder = "";
            if (request.getParameter("selectedFile") != null) {
                folder = request.getParameter("selectedFile").toString();
            }
            if (user.getCourse() > 0) {
                Filehandling fhandling = new Filehandling(
                        klasse.getCourseNameFromId(user.getCourse()));
                if (fhandling.createFolder(fhandling.validateFolderpath(folder)
                        + request.getParameter("foldername"))) {
                    errorText.setError("folder_creation_success");
                } else {
                    errorText.setError("folder_creation_fail");
                }
            }
        }
    }
    RequestDispatcher rd = request.getRequestDispatcher("../view/datei_upload.jsp");
    rd.forward(request, response);
%>