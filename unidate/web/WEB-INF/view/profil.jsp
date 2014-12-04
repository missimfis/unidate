<%@ page import="bean.*"%> 
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<%@ page import="java.util.*" %>

<% int id = student.getId();%>
<%@ page import="java.util.*" %>
<% String firstname = student.getFirstname(id);%>
<% String lastname = student.getLastname(id);%>
<% String department = student.getDepartment(id);%>
<% String studium = student.getStudium(id);%>
<% String about = student.getAbout(id);%>

<%Image image = new Image();%>
<% image.setProfilePic(id);
String profilePic = image.getProfilePic();%>
<% 
        if(request.getParameter("submit") != null) {
%>
        <%String value = request.getParameter("submit"); 
        image.deleteImage(value, id);%>
<%
        }
%> 

    <div class="row">
      <div class="large-12 columns">
	        <h2>Profil</h2>
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
		<h3 class="blue"><%out.println(firstname + " " + lastname);%></h3>
			<p>24 Jahre<br/>
			<%out.println(studium);%><br/></p>
			<%out.println(about);%>
			
	  </div>
	</div>   
	
      <div class="row">
            <%   
                image.prepareHTML(id);
                if(image.getOutput()!=null){
                    out.println(image.getOutput());
                }
                 
            %>  
	  <div class="large-2 medium-2 columns">
	     <div class="mediumepicture right">
                <%--img src="icons/plus13.svg" alt="profile"--%>                        
                <form method="post" action="Image" enctype="multipart/form-data" >                   
                    <div class="image-upload">
                        <label for="file-input">
                            <img src="icons/plus13.png" style="margin-top:45px;" />
                        </label>
                        
                        <input style=" display: none;"  id="file-input" type="file" name="file" accept="image/x-png, image/gif, image/jpeg" onchange="this.form.submit();"/>
                    </div> 
                    <%image.createTXT(id);%>
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
	
	<div class="row">
		<div class="large-12 columns">
			<%--a href="#" class="small round button">Bearbeiten</a><br/--%>
                        <form method="post" action="profil_bearbeiten">
                        <input class="small round button" type="submit" value="Bearbeiten" />
                        <input style=" display: none;" type="text" name="id" value="<%=id%>">
                        </form>
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
