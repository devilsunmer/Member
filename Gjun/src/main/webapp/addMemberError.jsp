<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>
<div id="title"><jsp:include page="title.jsp"/></div>
<div id="content">
<h2>！註冊失敗！</h2>
請查明是否有重複註冊帳號？<br>
<a href="addMember.jsp" method="post">請重新註冊。</a>

</div>
<div id="footer"><jsp:include page="footer.jsp"/></div>
</body>
</html>