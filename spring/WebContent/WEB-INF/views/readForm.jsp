<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<title>MVC2 게시판 글 상세</title>
</head>
<body>
	<div id="read_wrap">
		<input type="hidden" name="idx" value="${param.idx }">
		<table>
			<tr>
				<td>이름</td>
				<td><c:out value="${articleRead.userName }"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><c:out value="${articleRead.title }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content_area" readonly>${articleRead.content }</textarea></td>
			</tr>
		</table>
		
		<div id="btn-box-read">
			<input type="password" name="re-password" placeholder="수정/삭제 비밀번호 입력">
			<input type="button" name="btn-modify" value="수정">
			<input type="button" name="btn-delete" value="삭제">
			<input type="button" name="btn-cancel" value="목록으로">
		</div>
	</div>
	
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/article.js"></script>
</body>
</html>