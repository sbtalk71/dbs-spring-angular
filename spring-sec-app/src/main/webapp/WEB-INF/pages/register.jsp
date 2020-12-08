<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Registration Form</title>
</head>
<body>
	<h1 align="center">Emp Registration Form</h1>
	<hr>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empId"></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>

	</form>
	<a href="logout">Logout</a>
</body>
</html>