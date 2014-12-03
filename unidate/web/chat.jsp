<%@ page import="bean.*"%> 
<jsp:setProperty property="*" name="userinfo"/>  
<jsp:useBean id="student" class="bean.Student" scope="session"/> 
<%@ page import="java.util.*" %>

<% int test = student.getId(); %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
    <div class="row">
	<div class="large-2 medium-2 small-2 columns">
	    <div class="mediumpicture">
		<img src="img/bild2.jpg" alt="profile">
		<div class="smallmask">
                    <img alt="imagemask" src="img/bigcircle.png"/>
		</div>
            </div>
        </div>
        <div class="large-8 medium-8 small-8 columns">
	    <div class="row">
		<div class="large-10 medium-10 small-10 columns panel">
                    test
		</div>
		<div class="large-2 medium-2 small-2 columns ">
                </div>
            </div>	
            <div class="row">
		<div class="large-2 medium-2 small-2 columns ">
		</div>
		<div class="large-10 medium-10 small-10 columns panel">
                    test
		</div>
            </div>	
            <div class="row">
		<form method="post" action="\chatsend">
                    <div class="small-9 columns">
			<textarea></textarea>
                    </div>
                    <div class="small-3 columns">
			<span class="button round">Send</span>
                    </div>
		</form>
            </div>	
        </div>
	<div class="large-2 medium-2 small-2 columns">
	    <div class="mediumpicture right">
		<img src="img/Bild1.png" alt="profile">
		<div class="smallmask">
                    <img alt="imagemask" src="img/bigcircle.png"/>
		</div>
            </div>
        </div>
    </div>
	
	
    
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>
