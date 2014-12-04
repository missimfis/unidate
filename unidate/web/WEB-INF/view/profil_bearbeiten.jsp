<%@ page import="bean.*"%> 
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<%@ page import="java.util.*" %>

<%Image image = new Image(); %>
<%  image.readTXT();
    int test = student.getId();
%>


<% String firstname = student.getFirstname(test);%>
<% String lastname = student.getLastname(test);%>
<% String department = student.getDepartment(test);%>
<% String studium = student.getStudium(test);%>
<% String about = student.getAbout(test);%>
<% String gender = student.getGender(test);%>
<% image.setProfilePic(test);
String profilePic = image.getProfilePic();%>



    <div class="row">
      <div class="large-12 columns">
	        <h2>Profil</h2>
                <%=test%>
    <% 
            if(request.getParameter("submit") != null) {
    %>
            <%String value = request.getParameter("submit"); 
            image.deleteImage(value, test);%>
    <%
            }
    %> 
	        <p>Herzlich Willkommen auf unidate. Die Registration ist abgeschlossen, bevor jedoch begonnen werden kann. Bitten Wir dich ein paar Einstellungen zu machen. Damit wir dir erste Vorschläge senden können.</p>
      </div>
    </div>
	
	<div class="row">
      <div class="large-4 medium-4 columns">
		<div class="bigpicture">
                        <%=profilePic%>
			<div class="white_big_circle">
			</div>
			<div class="blue_big_circle">
			</div>
                        
		</div>
	  </div>
	  <div class="large-8 medium-8 columns">
		<form method="post" action="profilCheck">
                    <h3>Profileinstellung</h3>
			<div class="row">                                       
                            <div class="large-6 medium-6 small-6 columns">
                            <label>Vorname</label>
                            <input type="text" value="<%=firstname %>" name="firstname"/>
                            </div>
                            <div class="large-6 medium-6 small-6 columns">
                            <label>Nachname</label>
                            <input type="text" value="<%=lastname %>" name="lastname"/>
                            </div>
                        </div>
                        <div class="row">
                                <div class="large-6 medium-6 columns">
                                  <label>Geschlecht</label>
                                  <input type="radio" <%if ("frau".equals(gender)) {%> checked="checked" <%}%>name="geschlecht" value="frau" id="f"/>
                                  <label for="f">Frau</label>
                                  <input type="radio" <%if ("mann".equals(gender)) {%> checked="checked" <%}%> name="geschlecht" value="mann" id="m"/>
                                  <label for="m">Mann</label>
                                </div>
                        </div>    
                        <div class="row">
                                <div class="large-12 medium-12 columns">
                                  <label>Department</label>
                                  <select class="radius" name="department">
                                        <option <%if ("Angewandte Linguistik".equals(department)) {%> selected="selected" <%}%> value="Angewandte Linguistik">Angewandte Linguistik</option>
                                        <option <%if ("Angewandte Psychologie".equals(department)) {%> selected="selected" <%}%> value="Angewandte Psychologie">Angewandte Psychologie</option>
                                        <option <%if ("Architektur, Gestaltung und Bauinginieurwesen".equals(department)) {%>selected="selected"<%}%>  value="Architektur, Gestaltung und Bauinginieurwesen">Architektur, Gestaltung und Bauinginieurwesen</option>
                                        <option <%if ("Gesundheit".equals(department)) {%> selected="selected" <%}%> value="Gesundheit">Gesundheit</option>
                                        <option <%if ("School of Engineering".equals(department)) {%> selected="selected" <%}%> value="School of Engineering">School of Engineering</option>
                                        <option <%if ("Life Sciences und Facility Management".equals(department)) {%> selected="selected"<%}%>  value="Life Sciences und Facility Management">Life Sciences und Facility Management</option>
                                        <option <%if ("Soziale Arbeit".equals(department)) {%> selected="selected" <%}%>  value="Soziale Arbeit">Soziale Arbeit</option>
                                        <option <%if ("School of Management and Law".equals(department)) {%> selected="selected" <%}%>  value="School of Management and Law">School of Management and Law</option>
                                  </select>
                                </div>
                        </div>
                        <div class="row">
                                <div class="large-12 columns">
                                  <label>Studium</label>
                                  <input type="text" placeholder="Studium" name="studium" value="<%=studium %>"/>
                                </div>
                        </div>
                        <div class="row">
                                <div class="large-12 columns">
                                  <label>Über Dich</label>
                                  <textarea style="border-radius:10px;" rows="10" name="about"><%out.println(about);%>
                                  </textarea>
                                </div>
                        </div>

                        <div class="row">
                                <div class="large-12 columns">
                                        <input class="small round button" type="submit" value="Speichern" />
                                        <%--<a href="#" class="small round button">Speichern</a><br/> */--%>

                                </div>
                        </div>
				
		</form>
                <form> 
                    <h3>Einstellungen für Anzeigen</h3>
                    <div class="row">
                            <div class="large-6 medium-6 columns">
                              <label>Interessiert an</label>
                              <input type="radio" name="Frauen" value="Frauen" id="f"/>
                              <label for="f">Frauen</label>
                              <input type="radio" name="Maenner" value="Maenner" id="m"/>
                              <label for="m">Männer</label>
                            </div>
                            <div class="large-6 medium-6 columns">
                              <label>Alter</label>
                              <input type="text" placeholder="Alter" />
                            </div>
                    </div>
                    <div class="row">
                            <div class="large-6 medium-6 columns">
                              <label>Alter zwischen</label>
                              <input type="text" placeholder="minimum Alter" />
                            </div>
                            <div class="large-6 medium-6 columns">
                              <label>und</label>
                              <input type="text" placeholder="maximum Alter" />
                            </div>
                    </div>
                    <div class="row">
                            <div class="large-12 columns">
                             <a href="#" class="small round button">Speichern</a><br/> 
                            </div>
                    </div>
                  </div>
                </form>
	</div>   
	
	<div class="row">   
            <%   
                image.prepareHTML(test);
                if(image.getOutput()!=null){
                    out.println(image.getOutput());
                }
                 
            %>               
        <div class="large-2 medium-2 columns">
            <div class="mediumepicture right">
                <%--<img src="icons/plus13.png" alt="profile">--%>
                <form method="post" action="Image" enctype="multipart/form-data" >
                    
                    <div class="image-upload">
                        <label for="file-input">
                            <img src="icons/plus13.png" style="margin-top:45px;" />
                        </label>
                        
                        <input style=" display: none;"  id="file-input" type="file" name="file" accept="image/x-png, image/gif, image/jpeg" onchange="this.form.submit();"/>
                    </div> 
                    <%image.createTXT(test);%>
                </form>
                
            </div>
        </div>
                
	  <div class="large-2 medium-2 columns">
	    &nbsp;
      </div>
	  <div class="large-2 medium-2 columns">
	    &nbsp;
      </div>
	  <div class="large-2 medium-2 columns">
	    &nbsp;
      </div>
	  <div class="large-2 medium-2 columns">
	    &nbsp;
      </div>
    </div>
   
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
    <script>
      $(document).foundation();
      $('.delete').click(function(){
         var r = confirm('sicher löschen?');
         if(r!=true){
             return false;
         }
      });
    </script>
