<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/>  
<%@ page import="java.util.*" %>

<%Image image = new Image(); %>
<%  
    int id = 1;
    userinfo.init();
    userinfo.createNewMatch(id);
    ArrayList<MatchedStudent> matchedStudent = userinfo.checkMatchedStudent();

%>

	
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
                    <form method="post" action="nachrichten.jsp">
                        <input type="image" src="icons/comments16.png" alt="messages" name="image" style="margin-top:10px; margin-right: 10px;" width="75">  
                    </form>
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
