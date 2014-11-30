<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/>  
<%@ page import="java.util.*" %>

<%Image image = new Image(); %>
<%--  userinfo.createNewMatch(1, 1);
    userinfo.createNewMatch(1, 2);
    ArrayList<MatchedStudent> matchedStudent = userinfo.checkMatchedStudent(); 
    
 --%>   
<%    
    Student student = new Student();
    student.init();
    student.createNewMatch(1, 1);
    student.createNewMatch(1, 2); 
    student.createNewMatch(1, 3);
    student.createNewMatch(1, 10);
    ArrayList<MatchedStudent> matchedStudent = student.checkMatchedStudent();

%>


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
			<div class="littlemask">
				<img alt="design mask" src="img/littlecircle.png"/>
                                
			</div>
			<div class="littleline">&nbsp;
			</div>
		</div>
		<div class="messages comment right">
			<img src="icons/comments16.png" alt="messages">
		</div>
	  </div>
    </div>
    
    <div class="row">
		<div class="large-12 columns">
                        <%   
                        for (MatchedStudent match : matchedStudent) {                       
                            int matchid = match.getCandidateID();
                            image.resetOutput();
                            image.displayMessage(matchid); 
                            
                            if(image.getOutput()!=null){
                                
                                out.println(image.getOutput());
                            }                            
                        }                      
                        %>   		
		</div>	  
    </div>
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>
