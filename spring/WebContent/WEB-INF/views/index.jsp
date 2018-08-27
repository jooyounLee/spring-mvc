<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="jooy" uri="/tlds/pagination"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/common.css"/>
<title>MVC2 게시판 리스트</title>
</head>
<body>

	<div class="board_wrap">
		<table>
			<tr>
				<td>No.</td>
				<td>제목</td>
				<td>이름</td>
				<td>작성일</td>
			</tr>
			<c:forEach var="list" items="${articles }">
				<tr>
					<td><c:out value="${list.idx}"/></td>
					<td><a href="${contextPath}/get_article_detail?idx=${list.idx}"><c:out value="${list.title}"/></a></td>
					<td><c:out value="${list.userName}"/></td>
					<td><fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd HH:mm"/></td>
				</tr>
			</c:forEach>	
		</table>
		
		<div>
			<a href="${contextPath}/form?idx:isnull=true&isNew=true">글쓰기</a>
		</div>
		
		<div id="page-box">
			<jooy:paging selectPageNum = "${selectPageNum}" 
						 totalPostCount = "${totalPostCount}"
						 countPostPerPage = "${countPostPerPage}"
						 />
		</div>
		
		
		
	</div>
</body>
</html>