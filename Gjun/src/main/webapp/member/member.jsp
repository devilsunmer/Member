<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../style.css">
</head>
<body>
<div id="title"><jsp:include page="/title.jsp"/></div><!-- 「/」java指的是到ｗｅｂａｐｐ查找相關檔案 -->
<div id="content">
<h3>會員管理</h3>
<a href="../LogoutController">登出</a>
</div>
<div id="footer"><jsp:include page="/footer.jsp"/></div>

</body>
</html>