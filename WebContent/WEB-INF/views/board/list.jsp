<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>list</h1>
<c:forEach var="vo" items="${list}">
	${vo.bno}
    <a href="/board/post?bno=${vo.bno}"><c:out value="${vo.title}" /></a>
    ${vo.writer}
    ${vo.updatedate}
    <br>

</c:forEach>
<a href="/board/register">등록</a>



<script>

</script>

</body>
</html>