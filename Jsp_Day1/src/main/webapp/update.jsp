<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DTOs.Emp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

input[type="number"] {
	border: none;
}

.container {
	margin-top: 100px;
	height: 500px;
	width: 50%;
}

.p-3 mb-2 bg-danger text-white {
	color: red;
}
</style>
<body>
	<div class="container">
		<%
		Emp p = (Emp) request.getAttribute("emp");
		%>

		<%
		if (request.getAttribute("msg") != null) {
		%>
		<h3 class="p-3 mb-2 bg-danger text-white">
			<%=request.getAttribute("msg")%></h3>
		<%
		}
		%>
		<table align="center" cellpadding="5px" border="">
			<form action="afterUpdate" method="post">
				<tr>
					<th>Emp Number</th>
					<td><input type="number" name="number"
						value="<%=p.getNumber()%>"></td>
					<br>
				</tr>
				<tr>
					<th>Emp Name</th>
					<td><input type="text" name="name" value="<%=p.getName()%>"></td>
					<br>
				</tr>
				<tr>
					<th>Emp Address</th>
					<td><input type="text" name="address"
						value=" <%=p.getAddress()%>"></td>
				</tr>
				<tr>

					<th>Emp Email</th>
					<td><input type="email" name="email" value="<%=p.getEmail()%>"></td>
				</tr>
				<br>
				<tr>
					<th>Enter Old password</th>
					<td><input type="password" name="password"
						placeholder="Enter Old password"></td>
				<tr>
				<tr>
					<th>Enter New password</th>
					<td><input type="password" name="passwordnew"
						placeholder="Enter new password"></td>
				</tr>
				<tr>
					<th><input type="submit"></th>

				</tr>

			</form>

		</table>
	</div>
</body>
</html>