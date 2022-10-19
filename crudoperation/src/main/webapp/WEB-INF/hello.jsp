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
<h1>My table</h1>

<table align="center">
	<tr>
		<th>ID</th>
		<th>Name</th>
	</tr>
 		<c:forEach items="${message}" var="users">
	 		<tr>
				<td>${users.id} </td>
				<td>${users.name} </td>
			</tr>

		</c:forEach>
</table>
</body>
</html>