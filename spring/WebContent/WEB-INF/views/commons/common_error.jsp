<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<h1>ERROR</h1>
	<h2>${exception.getClass().getSimpleName()} </h2>
	<p>${exception.getMessage() }</p><br>
	<c:forEach items="${exception.getStackTrace() }" var="stack">
		${stack.toString() }
	</c:forEach>
</body>
</html>