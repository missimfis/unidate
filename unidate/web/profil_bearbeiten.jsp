<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/>  
<% String name = userinfo.getDBName(1);%>
<% String department = userinfo.getDBDepartment(1);%>
<% String studium = userinfo.getDBStudium(1);%>
<% String about = userinfo.getDBAbout(1);%>


<!doctype html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Foundation | Welcome</title>
    <link rel="stylesheet" href="css/foundation.css" />
	<link rel="stylesheet" href="css/main.css" />
    <script src="js/vendor/modernizr.js"></script>
  </head>

  <body>
    <div class="line">&nbsp;
	</div>
	
    <div class="row">
      <div class="large-4 medium-4 small-4 columns">
		<div class="logo">
			<img src="img/logo_v2_1.jpg" alt="Unidate">
		</div>
	  </div>
	  <div class="large-8 medium-8 small-8 columns">
		
		<div class="littlepicture right">
			<img src="img/Bild1.png" alt="profile">
			<div class="white_little_circle">
			</div>
			<div class="blue_little_circle">
			</div>
			<div class="littleline">&nbsp;
			</div>
		</div>
		<div class="messages right">
			<img src="icons/comments16.svg" alt="messages">
		</div>
	  </div>
    </div>
    
    <div class="row">
      <div class="large-12 columns">
	        <h2>Profil</h2>
	        <p>Herzlich Willkommen auf unidate. Die Registration ist abgeschlossen, bevor jedoch begonnen werden kann. Bitten Wir dich ein paar Einstellungen zu machen. Damit wir dir erste Vorschläge senden können.</p>
      </div>
    </div>
	
	<div class="row">
      <div class="large-4 medium-4 columns">
		<div class="bigpicture">
			<img src="img/Bild1.png" alt="profile">
			<div class="white_big_circle">
			</div>
			<div class="blue_big_circle">
			</div>
		</div>
	  </div>
	  <div class="large-8 medium-8 columns">
		<form method="post" action="profilCheck.jsp">
			<div class="row">
					<div class="large-12 columns">
					<label>Name</label>
					  <h3 class="blue"><input type="text" value="<%=name %>" name="name" /></h3>
					</div>
				</div>
				<div class="row">
					<div class="large-12 medium-12 columns">
					  <label>Department</label>
					  <select class="radius" name="department">
						<option value="Angewandte Linguistik">Angewandte Linguistik</option>
						<option value="Angewandte Psychologie">Angewandte Psychologie</option>
						<option value="rchitektur, Gestaltung und Bauinginieurwesen">Architektur, Gestaltung und Bauinginieurwesen</option>
						<option value="Gesundheit">Gesundheit</option>
						<option value="School of Engineering">School of Engineering</option>
						<option value="Life Sciences und Facility Management">Life Sciences und Facility Management</option>
						<option value="Soziale Arbeit">Soziale Arbeit</option>
						<option value="School of Management and Law">School of Management and Law</option>
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
					  <label>�ber Dich</label>
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
	  </div>
	</div>   
	
	<div class="row">
      <div class="large-2 medium-2 columns">
	    <div class="mediumpicture">
			<img src="img/surfen.jpg" alt="profile">
			<div class="white_medium_circle">
			</div>
			<div class="blue_medium_circle">
			</div>
		</div>
      </div>
	  <div class="large-2 medium-2 columns">
	     <div class="mediumepicture right">
			<img src="icons/plus13.svg" alt="profile">
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
  </body>
</html>
