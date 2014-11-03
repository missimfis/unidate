<%-- Shows uploaded files per course. Files can be uploaded, downloaded or deleted.
Folderstructures can be created. --%>
<%@page import="bean.*"%>  
<jsp:useBean id="user" class="bean.User" scope="session"/>
<jsp:useBean id="klasse" class="bean.Klasse" scope="session"/>

            <div class="row">
                <div class="small-12 columns">
                    <h1>Dateien</h1>
                </div>
            </div>
            <form action="dateiProcess" method="POST">
                <div class="row">
                    <div class="small-4 columns">
                        <label>
                            <!-- Putting out the options available to choose from -->
                            <select name="dam_action">
                                <option value="choose">Aktion wählen</option>
                                <option value="delete">Löschen</option>
                                <option value="newfolder">Neuer Ordner</option>
                                <option value="fileupload">File Upload</option>
                            </select>
                        </label>
                    </div>
                    <div class="small-4 columns">
                        <input id="choosebutton" class="button tiny" type="submit" value="&Uuml;bernehmen" />
                    </div>
                    <div class="small-4 columns">
                        &nbsp;
                    </div>
                </div>
                <div class="row">
                    <div class="small-12 columns">
                        <div class="section">
                            <%  // printing the list of files and folders
                                if (user.getCourse() > 0) {
                                    Filehandling fhandling = new Filehandling(klasse.getCourseNameFromId(user.getCourse()));
                                    // if Class mainfolader not exists create the folder
                                    fhandling.createFolder("");
                                    // print out the htmlFileList (generated through recursive function in FILEHANDLING)
                                    out.print(fhandling.htmlListFiles(null, ""));
                                }
                            %>
                        </div>
                    </div>
                </div>
            </form>   