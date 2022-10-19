<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center" >STUDENTS TABLE</h3>
<table align="center" border="1" width="50%">
	<tr>
		<th>ID</th>
		<th>Name</th>
	</tr>
 		<c:forEach items="${message}" var="users">
	 		<tr>
				<td align="center" >${users.id} </td>
				<td align="center" >${users.name} </td>
			</tr>

		</c:forEach>
</table>
<br>
<br>
<div align="center">
<a href="http://localhost:8080/FormSpring/"><button align="center">ADD NEW STUDENT</button></a>
</div>
</body>
</html>