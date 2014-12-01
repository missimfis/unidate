<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/> 
<jsp:useBean id="student" class="bean.Student" scope="session"/>
<%out.println(student.getId());%>
<%out.println(request.getParameter("rating"));%>
<% int id = 1;%>
<%@ page import="java.util.*" %>
<% String firstname = userinfo.getFirstname(id);%>
<% String lastname = userinfo.getLastname(id);%>
<% String department = userinfo.getDepartment(id);%>
<% String studium = userinfo.getStudium(id);%>
<% String about = userinfo.getAbout(id);%>
<!doctype html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Anzeigen</title>
    <link rel="stylesheet" href="css/foundation.css" />
	<link rel="stylesheet" href="css/main.css" />
    <script src="js/vendor/modernizr.js"></script>
  </head>
    <%Image image = new Image(); %>


                    <%//image.createTXT(id);%><%//=id*/%>
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
			<img src="img/Bild1.png" alt="profilexx">
                        <%   
                            image.prepareHTML(id);
                            out.println(id);
                            if(image.getOutput()!=null){
                                out.println(image.getOutput());
                            }
                 
                        %>
			<div class="littlemask">
				<img src="img/littlecircle.png"/>
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
      <div class="large-3 medium-3 small-3 columns">
	     <div class="icons">
			<img src="icons/left17.png" alt="profile">
		 </div>
      </div>
	  <div class="large-6 medium-6 small-6 columns">
		<div class="bigpicture">
			<img src="img/Bild1.png" alt="profile">
                        <%   
                            image.prepareHTML(id);
                            out.println(id);
                            if(image.getOutput()!=null){
                                out.println(image.getOutput());
                            }
                 
                        %>
			<div class="mask">
				<img src="img/bigcircle.png"/>
			</div>
			<div class="row">
				<div class="large-6 medium-6 small-6 columns">
					<div class="littlepicture left">
						<div class="circle left">
							<div class="icon">
                                                            <!--<img src="icons/checkmark2.png" alt="dislike">-->
                                                            <form method="post" action="anzeigen.jsp">
                                                                <input style=" display: none;" type="text" name="id" value="<%=id%>">
                                                                <input style=" display: none;" type="text" name="rating" value="like">
                                                                <input type="image" src="icons/checkmark2.png" alt="dislike" />
                                                            </form>
                                                        </div>
						</div>
					</div>
                                    
				</div>
				<div class="large-6 medium-6 small-6 columns">
					<div class="littlepicture right">
						<div class="circle circle2 right">
							<div class="icon">
                                                            <!--<img src="icons/cross5.png" alt="dislike">-->
                                                            <form method="post" action="anzeigen.jsp">
                                                                <input style=" display: none;" type="text" name="id" value="<%=id%>">
                                                                <input style=" display: none;" type="text" name="rating" value="dislike">
                                                                <input type="image" src="icons/checkmark2.png" alt="dislike" />
                                                            </form>
                                                        </div>
						</div>
					</div>
				</div>
			</div>
		</div>
      </div>
	  <div class="large-3 medium-3 small-3 columns">
	       <div class="iconsright">
				<img src="icons/arrow73.png" alt="profile">
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
