<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>reg</h1>
<form action="/board/register" method="POST">
    제목 : <input type="text" name="title"><br>
    저자 : <input type="text" name="writer"><br>
    내용 : <textarea name="content" cols="30" rows="10"></textarea><br>
    <button>올리기</button>
    <input type="reset" value="취소">
</form>
</body>
</html>