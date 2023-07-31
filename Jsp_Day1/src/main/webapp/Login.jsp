<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<style type="text/css">
.container {
	margin-top: 100px;
	height: 500px;
	width: 50%;
}
.p-3 mb-2 bg-danger text-white{
color: red;

}
</style>
</head>
<body>
	<div class="container">
		<form action="EmpLogin" method="post">
			<div class="mb-3">
				<%
				String s = (String) request.getAttribute("message"); 
				if (s != null) {
				%>
				<h3 color="p-3 mb-2 bg-danger text-white"><%=request.getAttribute("message")%></h3>
				<%
				}
				%>
			</div>
			<div class="mb-3">

				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" name="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" name="password" class="form-control"
					id="exampleInputPassword1">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>