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
