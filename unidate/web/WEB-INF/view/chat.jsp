<%@ page import="java.util.*" %>
<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/>  


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
		<form method="post" action="chatSend">
                    <div class="small-9 columns">
			<textarea name="text"></textarea>
                    </div>
                    <div class="small-3 columns">
			<input class="small round button" type="submit" value="Senden" />
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
