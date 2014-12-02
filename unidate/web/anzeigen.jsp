<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/> 
<jsp:useBean id="student" class="bean.Student" scope="session"/>
<%out.println(student.getId());%>
<%out.println(request.getParameter("rating"));%>
<% int id = 1;%>
<%@ page import="java.util.*" %>
<% 
    String rating = request.getParameter("rating");
    if(rating=="like"){
        //student.like(request.getParameter("id"));
    }
    else if(rating=="dislike"){
       //student.dislike(request.getParameter("id"));
    }
    //checkNewCandidates();
    //createCandidateList();
    //ArrayList<Candidate> candidateList = getcandidateList();
    ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
    candidateList.add(new Candidate(1, "asd", "asd","asd", "asd", "asd", true));
    candidateList.add(new Candidate(2, "asd", "asd","asd", "asd", "asd", true));
    %>
<!doctype html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Anzeigen</title>
    <link rel="stylesheet" href="css/foundation.css" />
	<link rel="stylesheet" href="css/main.css" />
    <script src="js/vendor/modernizr.js"></script>
    <script type="text/javascript">
    function SwapContent( nextDiv, currentDiv ) {
	document.getElementById(currentDiv).style.display = 'none';
	document.getElementById(nextDiv).style.display = 'block';
    }
    </script>
  </head>
    <%Image image = new Image(); %>
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
                        <%  //waiting for method 
                            image.prepareHTML(id);
                            if(image.getOutput()!=null){
                                //out.println(image.getOutput());
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
    <% 
        if(candidateList.size()==0)out.println("es konnten keine potenzielle Kandidatengefunden werden.");
        for (int i=0;i<candidateList.size();i++){
        //for (Candidate candidate:candidateList){
        id=candidateList.get(i).getId();
        int nextID=candidateList.get(0).getId();
        int preID=candidateList.get(candidateList.size()-1).getId();
        if(i+1<candidateList.size()){
            nextID = candidateList.get(i+1).getId();
        }
        if(i!=0){
            preID = candidateList.get(i-1).getId();
        }
            
    %>
    <div class="row" style="display:none; <% if(i==0)out.println("display:block;");%>" id="candidate_<% out.println(id); %>">
      <div class="large-3 medium-3 small-3 columns">
	     <div class="icons">
			<img src="icons/left17.png" alt="profile"  onclick="SwapContent('candidate_<%=preID%>','candidate_<%=id%>');" style="cursor:pointer">
		 </div>
      </div>
	  <div class="large-6 medium-6 small-6 columns">
		<div class="bigpicture">
			<img src="img/Bild1.png" alt="profile">
                        <%   
                            //waiting for method!!!!!!
                            image.displayMessage(id);
                            if(image.getOutput()!=null){
                                //out.println(image.getOutput());
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
                                                            <form action="anzeigen.jsp" method="post" name="like" >
                                                                <input style=" display: none;" type="text" name="id" value="<%=id%>">
                                                                <input style=" display: none;" type="text" name="rating" value="like">
                                                                <img src="icons/checkmark2.png" alt="dislike" onclick="document.like.submit();" style="cursor:pointer">
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
                                                            <form action="anzeigen.jsp" method="post" name="dislike" >
                                                                <input style=" display: none;" type="text" name="id" value="<%=id%>">
                                                                <input style=" display: none;" type="text" name="rating" value="dislike">
                                                                <img src="icons/cross5.png" alt="dislike" onclick="document.dislike.submit();" style="cursor:pointer">
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
				<img src="icons/arrow73.png" alt="profile" onclick="SwapContent('candidate_<%=nextID%>','candidate_<%=id%>');" style="cursor:pointer">
		   </div>
      </div>
    </div>
    <% } %>

    
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>
