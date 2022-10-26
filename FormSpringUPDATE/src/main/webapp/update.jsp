<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<body>
	<h2></h2>
	<form action="updateView" method="post">
		<label>Enter student name </label> <input type="text" name="name" value="${updateGetName}">
		<br> <br>
	    <label>Enter student id </label> <input type="text" name="id" value="${updateGetId}"> <br> <br>
		<button type="submit">SUBMIT</button>
	</form>
</body>
</html>
