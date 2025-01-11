<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../style.css"><!--「../」使用的是html語法，也是讀取上一層資料夾的意思 -->
</head>
<body>
<div id="title"><jsp:include page="/title.jsp"/></div><!-- 「/」java指的是到ｗｅｂａｐｐ查找相關檔案 -->
<div id="content">
<h3>~登入成功~</h3>
<a href ="member.jsp">進入會員管理</a>
<br>
<h3>${Member.getName() }歡迎</h3>
以下為您的基本資料<br>
姓名：${Member.getName() }<br>
帳號:${Member.getUsername() }<br>
地址:${Member.getAddress() }<br>
電話:${Member.getPhone() }<br>
行動:${Member.getMobile() }<br>
<br>
<a href="../LogoutController">登出</a>
<button name="submit" type="submit" value="../LogoutController">登出</button>
</div>
<div id="footer"><jsp:include page="/footer.jsp"/></div>
</body>
</html>