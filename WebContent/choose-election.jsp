<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.ArrayList, model.ElectionList"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>Select Election</title>
</head>
<body>
	<%
		ArrayList<ElectionList> allElections = (ArrayList<ElectionList>) request.getAttribute("AllElections");
	%>
	<form method="post" action="MasterControllerServlet">
		<table border=1 cellpadding=5>
			<tr>
				<th>Select</th>
				<th>Election Name</th>
			</tr>

			<%
				for (int i = 0; i < allElections.size(); i++) {
			%>
			<tr>
				<td><input type="radio" name="id" value="<%=i%>"></td>
				<td><%=allElections.get(i).getElectionName()%></td>
			</tr>
			<%
				}
			%>

		</table>
		<div class="center">
			<input class="button" type="submit" name="doThisToItem"
				value="Vote Now"> <input class="button" type="submit"
				name="doThisToItem" value="Display Results">
		</div>
	</form>
</body>
</html>