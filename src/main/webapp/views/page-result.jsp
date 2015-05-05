<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC REST Example</title>
</head>
<body>
	<h1>${msg}</h1>
	<h2>${url}</h2>
    <h2>Links on this page:</h2>
	<table>
		<c:forEach items="${links}" var="link">
			<tr>
				<td><c:out value="${link}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>