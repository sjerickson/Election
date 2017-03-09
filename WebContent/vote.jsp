<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>Vote</title>
</head>
<body>
<%String electionName = (String)request.getAttribute("electionName");
String[] candidates = {(String)request.getAttribute("cand1"),(String)request.getAttribute("cand2"),
		(String)request.getAttribute("cand3")};%>

<h1><%=electionName %> - VOTE</h1> 
<form method="post" action="SubmitVoteOrCancelServlet">
		<table border=1 cellpadding=5>

			<%
				for (int i = 0; i < 3; i++) {
			%>
			<tr>
				<td><input type="radio" name="candidateID" value="<%=i%>"></td>
				<td><%=candidates[i]%></td>
			</tr>
			<%
				}
			%>

		</table>
		<div class="center">
			<input class="button" type="submit" name="doThisToItem"
				value="Vote"> <input class="button" type="submit"
				name="doThisToItem" value="Cancel">
		</div>
		<input type = "hidden" name="election" value = "<%=electionName%>">
	</form>
</body>
</html>