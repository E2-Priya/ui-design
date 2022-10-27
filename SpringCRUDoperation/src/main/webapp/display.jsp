<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">STUDENTS TABLE</h2>
	<hr>
	<br>
	<br>
	<table align="center" border="1" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${message}" var="users">
			<tr>
				<td align="center">${users.id}</td>
				<td align="center">${users.name}</td>
				<!--  <td align="center" ><button >DELETE</button></td>  -->
			</tr>

		</c:forEach>
	</table>
	<br>
	<br>
	<div align="left">
		<a href="http://localhost:8080/FormSpring/"><button align="left">ADD
				NEW STUDENT</button></a>
	</div>
	<br>
	<br>
	<div>
		<form action="delete" method="post">
			<label>Enter student id </label> <input type="text" name="deleteId"></input>
			<button type="submit">SUBMIT TO DELETE</button>
		</form>
	</div>
	<br>
	<br>
	<div>
		<form action="update" method="post">
			<label>Enter student id </label> <input type="text" name="updateId"></input>
			<button type="submit">SUBMIT TO UPDATE</button>
		</form>
	</div>
</body>
</html>