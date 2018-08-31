<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="jooy" uri="/tlds/pagination"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />" />
<title>MVC2 게시판 리스트</title>
</head>
<body>

	<div class="board_wrap">
		<select name="perPage">
			<option>5</option>
			<option>10</option>
			<option>15</option>
			<option>20</option>
		</select>
		<table>
			<tr>
				<td>No.</td>
				<td>제목</td>
				<td>이름</td>
				<td>작성일</td>
			</tr>
			<c:forEach var="articles" items="${articles }">
				<tr>
					<td><c:out value="${articles.idx}" /></td>
					<td><a href="<c:url value="/article/${articles.idx}"/>"><c:out value="${articles.title}" /></a></td>
					<td><c:out value="${articles.userName}" /></td>
					<td><fmt:formatDate value="${articles.created }" pattern="yyyy-MM-dd HH:mm" /></td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<a href="<c:url value="/article/save"/>">글쓰기</a>
		</div>

		<div id="page-box">
			<jooy:paging selectPageNum="${param.page }"
				totalPostCount="${totalPostCount}"
				countPostPerPage="5" />
		</div>

	</div>
	
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script src="<c:url value="/resources/js/article.js"/>"></script>
</body>
</html>