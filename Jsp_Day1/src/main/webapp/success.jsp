<%@page import="DTOs.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

input[type="number"] {
	border: none;
}
</style>
<body>
	<%!List<Emp> li;%>
	<table align="center" cellpadding="5px" border="">
		<tr>
			<th>Emp Name</th>
			<th>Emp Number</th>
			<th>Emp Address</th>
			<th>Emp Email</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<%
		li = (List) request.getAttribute("List");
		%>
		<%
		for (Emp p : li) {
		%>
		<form action="Update" method="post">
			<tr>
				<td><%=p.getName()%></td>
				<td><input type="number" name="id" value="<%=p.getNumber()%>"></td>
				<td><%=p.getAddress()%></td>
				<td><%=p.getEmail()%></td>
				<td> <a href="Update?id=<%= p.getNumber() %>"  > <input type="submit" name="Update" value="update"></a>
				</td>
				<td><a href="Update?id=<%= p.getNumber() %>"  ><input type="submit" name="Update" value="delete"> </a> </td>

			</tr>
		</form>
		<%
		}
		%>
	</table>


</body>
</html>