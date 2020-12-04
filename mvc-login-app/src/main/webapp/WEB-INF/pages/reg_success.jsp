<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reg Success Page</title>
</head>
<body>
<h1>Employee Registered Successfully with the given details:</h1>
<hr>
<table>
<tr><td>Emp Id</td><td>${emp.empid}</td></tr>
<tr><td>Emp Name</td><td>${emp.empName}</td></tr>
<tr><td>City</td><td>${emp.city}</td></tr>
<tr><td>Salary</td><td>${emp.salary}</td></tr>
</table>
</body>
</html>