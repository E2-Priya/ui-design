<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<body>
	<h2 align="center">UPDATE PAGE</h2>
	<hr>
	<br>
	<div style="width:100% ;display: flex;flex-direction: column;    align-items: center;">
	<div align="center" style=" border:black; border-width:2px; border-style:solid; width:30%; ">
	<br>
	<form action="updateView" method="post">
		<label>Enter student name </label> <input type="text" name="name" value="${updateGetName}">
		<br> <br>
	    <label>Enter student id </label> <input type="text" name="id" value="${updateGetId}"> <br> <br>
		<button type="submit">SUBMIT TO UPDATE</button>
	</form>
	</div>
	<br><br>
	</div>
</body>
</html>
