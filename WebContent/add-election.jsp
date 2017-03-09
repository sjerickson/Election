<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>Add New Election</title>
</head>
<body>
	<div id="newElectionForm">
		<form method="post" action="InsertElectionServlet">
			<label for="election">Election Name</label> <input type="text"
				name="election" id="election"><br/> <label for="cand1">Candidate</label>
			<input type="text" name="cand1" id="cand1"><br/> <label
				for="cand2">Candidate</label> <input type="text" name="cand2"
				id="cand2"><br/> <label for="cand3">Candidate</label> <input
				type="text" name="cand3" id="cand3">

			<div class="center">
				<input class="button" type="submit" name="doThisToItem" value="ADD">
				<input class="button" type="submit" name="doThisToItem"
					value="Cancel">
			</div>
		</form>
	</div>
</body>
</html>