<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trainees</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<a href="LogoutController">logout</a>
welcome ${trainee.trainee_name}! <br/>
<table>
	<thead>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>branch</th>
			<th>percentage</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${trainees}" var="trainee">
			<tr>
				<td>${trainee.trainee_id}</td>
				<td>${trainee.trainee_name}</td>
				<td>${trainee.branch}</td>
				<td>${trainee.percentage}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>