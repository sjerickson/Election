<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>Thank you</title>
</head>
<body>
<%
		String sender = (String) request.getAttribute("sender");
	%>
<h1>Thank You!</h1>
<%if(sender.equals("newVote")){ %>
<h3>Thank you for your vote.</h3>
<%}else if(sender.equals("newElection")){
	String electionName = (String) request.getAttribute("election");
	%>
<h3>You have added a new election for <%=electionName %>.</h3>
<%} %>
	<div class="center">
		<form method="post" action="ChooseElectionServlet">
			<input type="submit" class="button" value="Back to Elections List">
		</form>
	</div>
</body>
</html>