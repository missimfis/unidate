<%-- This page opens when clicked on the footer and 
shows details of the team behind the project --%>
<%@page import="bean.TextFileReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
		<div class="medium-12 columns">
                    <%= TextFileReader.parse("webapps/lemas/txt/SDM2TextDE.txt")%>
		</div>
	</div>
