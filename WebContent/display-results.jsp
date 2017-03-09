<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>Display Results</title>
</head>
<body>
	<%
		String electionName = (String) request.getAttribute("electionName");
		electionName = electionName.toUpperCase();
		String[] candidates = { (String) request.getAttribute("cand1"), (String) request.getAttribute("cand2"),
				(String) request.getAttribute("cand3") };
		int[] tallies = { (int) request.getAttribute("cand1tally"), (int) request.getAttribute("cand2tally"),
				(int) request.getAttribute("cand3tally") };
	%>
	<h1><%=electionName%>
		- Current Tallies
	</h1>
	<%
		for (int i = 0; i < 3; i++) {
	%>
	<h3><%=candidates[i].toUpperCase()%>
		-
		<%=tallies[i]%></h3>
	<%
		}
	%>
	<div class="center">
		<form method="post" action="ChooseElectionServlet">
			<input type="submit" class="button" value="Back to Elections List">
		</form>
	</div>
</body>
</html>