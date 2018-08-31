<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />"/>
<title>MVC2 게시판 쓰기,수정 폼</title>
</head>
<body>
	<div class="write_wrap">
		<form:form id="articleForm" method="post" modelAttribute="article">
			<form:input path="idx"/>
			<table>
				<tr>
					<td>이름</td>
					<td>
						<form:input path="userName" />
					</td>
					<td>비밀번호</td>
					<td><form:password path="password"/></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3"><form:input path="title"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">
						<form:textarea path="content" rows="20" cols="50" />
					</td>
				</tr>
			</table>
		</form:form>
		<div id="btn-box">
			<input type="button" value="취소" name="btn-cancel">
			<input type="button" value="확인" name="btn-submit">
		</div>
	</div>
	
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script src="<c:url value="/resources/js/article.js"/>"></script>

</body>
</html>