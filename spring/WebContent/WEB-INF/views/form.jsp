<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/common.css"/>
<title>MVC2 게시판 쓰기,수정 폼</title>
</head>
<body>
	<div class="write_wrap">
		<input type="hidden" name="isNew" value="${param.isNew }">
		<input type="hidden" name="idx" value="${param.idx }">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" value="${articleUpdate.userName }"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="title" value="${articleUpdate.title }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">
					<textarea cols="50" rows="20" name="content">${articleUpdate.content }</textarea>
				</td>
			</tr>
		</table>
		
		<div id="btn-box">
			<input type="button" value="취소" name="btn-cancel">
			<input type="button" value="확인" name="btn-submit">
		</div>
		
	</div>
	
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/article.js"></script>
</body>
</html>