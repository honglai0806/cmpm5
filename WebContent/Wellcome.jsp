<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="abc" style="margin-left: 500px;margin-top: 100px;">
		<%
			Users users = (Users) session.getAttribute("user");
			if (users != null) {
		%>
		<div class="a" style="font-size: 30px;">
			Đăng nhập thành công, xin chào
			<div class="s" style="color: blue; font-size: 100px; margin-left: 100px;]"><%=users.getUsername()%></div>
		</div>
		<a href="LogoutController" style="color: red;"><i
			class="fas fa-sign-out-alt"></i> Đăng Xuất</a>
		<%
			}
		%>
	</div>
</body>
</html>