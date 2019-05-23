<%@page import="model.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Đăng ký</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
<script src="https://www.google.com/recaptcha/api.js"></script>
<!--===============================================================================================-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<!--===============================================================================================-->
</head>
<body>

	<!--=======================================2.Hiện thị From đăng kí========================================================-->
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
				<form action="RegisterController" method="post"
					class="login100-formvalidate-formflex-sbflex-w">
					<span class="login100-form-title p-b-53"
						style="padding-bottom: 0px;"> Đăng Ký</span>
					<!--===============================3.Nhập thông tin trong form=============================================================-->
					<div class="err" style="color: Red; margin-top: 50px;">
						<%=StringUtil.getString(request.getAttribute("error"))%></div>

					<div class="p-t-31 p-b-9">
						<span class="txt1"> <i class="fas fa-user"></i>
							&nbsp;Username
						</span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Username is required">
						<input class="input100" type="text" name="username"
							value="<%=StringUtil.getString(request.getParameter("username"))%>">
						<span class="focus-input100" required></span>
					</div>
					<div class="p-t-31 p-b-9">
						<span class="txt1"> <i class="fas fa-envelope"></i>
							&nbsp;Email
						</span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Username is required">
						<input class="input100" type="text" name="email"
							value="<%=StringUtil.getString(request.getParameter("email"))%>">
						<span class="focus-input100" required></span>
					</div>

					<div class="p-t-13 p-b-9">
						<span class="txt1"> <i class="fas fa-key"></i>&nbsp;Password
						</span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="pass"
							value="<%=StringUtil.getString(request.getParameter("pass"))%>">
						<span class="focus-input100" required></span>
					</div>
					<div class="p-t-13 p-b-9">
						<span class="txt1"> <i class="fas fa-key"></i>&nbsp;Confirm
							Password
						</span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="repass"
							value="<%=StringUtil.getString(request.getParameter("repass"))%>">
						<span class="focus-input100" required></span>
					</div>
					<br>
					<button type="submit" class="login100-form-btn">Đăng Ký</button>
			</div>

			<div class="w-full text-center p-t-55">
				<span class="txt2"> Nếu đã có tài khoản vui lòng </span> <a
					href="Login.jsp" class="txt2 bo1"> Đăng Nhập </a>
			</div>

			</form>
		</div>
	</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>