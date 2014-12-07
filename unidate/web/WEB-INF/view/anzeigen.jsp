<%@ page import="bean.*"%> 
<jsp:useBean id="userinfo" class="bean.Student"/>
<jsp:setProperty property="*" name="userinfo"/> 
<jsp:useBean id="student" class="bean.Student" scope="session"/>
<% int id = student.getId();%>
<%@ page import="java.util.*" %>
<% 
    student.createCandidateList();
    ArrayList<Candidate> candidateList = student.getCandidateList();
    %>
    <script type="text/javascript">
    function SwapContent( nextDiv, currentDiv ) {
	document.getElementById(currentDiv).style.display = 'none';
	document.getElementById(nextDiv).style.display = 'block';
    }
    </script>
   <div>
    <% 
        if(candidateList.size()==0)out.println("es konnten keine potenzielle Kandidaten gefunden werden.");
        for (int i=0;i<candidateList.size();i++){
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
    <div class="row" style="display:none; <% if(i==0)out.println("display:block;");%>" id="candidate_<%=id%>">
      <div class="large-3 medium-3 small-3 columns">
	     <div class="icons">
			<img src="icons/left17.png" alt="profile"  onclick="SwapContent('candidate_<%=preID%>','candidate_<%=id%>');" style="cursor:pointer">
		 </div>
      </div>
	  <div class="large-6 medium-6 small-6 columns">
		<div class="bigpicture">
			<!--<img src="img/Bild1.png" alt="profile">--> 
                        <%Image image = new Image(); %>
                        <%   
                            //waiting for method!!!!!!
                            image.setProfilePic(id);
                            if(image.getProfilePic()!=null){
                                out.println(image.getProfilePic());
                            } else{%>
                        <img src="img/Bild1.png" alt="profile">
                        <%  }
                        %>
			<div class="mask">
				<img src="img/bigcircle.png"/>
			</div>
			<div class="row">
				<div class="large-6 medium-6 small-6 columns">
					<div class="littlepicture left">
						<div class="circle left">
							<div class="icon">
                                                            <form action="bewertung" method="post" name="like<%=id%>" >
                                                                <input style=" display: none;" type="text" name="id" value="<%=id%>">
                                                                <input style=" display: none;" type="text" name="rating" value="like">
                                                                <img src="icons/checkmark2.png" alt="dislike" onclick="document.like<%=id%>.submit();" style="cursor:pointer">
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
                                                            <form action="bewertung" method="post" name="dislike<%=id%>" >
                                                                <input style=" display: none;" type="text" name="id" value="<%=id%>">
                                                                <input style=" display: none;" type="text" name="rating" value="dislike">
                                                                <img src="icons/cross5.png" alt="dislike" onclick="document.dislike<%=id%>.submit();" style="cursor:pointer">
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

