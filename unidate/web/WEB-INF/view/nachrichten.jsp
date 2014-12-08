<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student" scope="session"/>
<jsp:useBean id="message" class="bean.Message" scope="session"/>
<jsp:setProperty property="*" name="student"/>  
<%@ page import="java.util.*" %>

<%Image image = new Image(); %>
<%  
    int id = userinfo.getId();
    ArrayList<MatchedStudent> matchedStudent = userinfo.checkMatchedStudent(id);

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
