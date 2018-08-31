<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
<title>MVC2 게시판 글 상세</title>
</head>
<body>
	<div id="read_wrap">
		<form:form id="article" method="post" modelAttribute="article">
			<form:hidden path="idx"/>
			<table>
				<tr>
					<td>이름</td>
					<td>
						<form:input path="userName" />
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3"><form:input path="title"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">
						<form:textarea path="content" rows="20" cols="50" readonly="true"/>
					</td>
				</tr>
			</table>
		</form:form>
		<div id="btn-box-read">
			<input type="password" name="re-password" placeholder="수정/삭제 비밀번호 입력">
			<input type="button" name="btn-modify" value="수정">
			<input type="button" name="btn-delete" value="삭제">
			<input type="button" name="btn-cancel" value="목록으로">
		</div>
	</div>
	
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script src="<c:url value="/resources/js/article.js"/>"></script>
</body>
</html>