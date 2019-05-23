<%@page import="model.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Đăng nhập</title>
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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<!--===============================================================================================-->
</head>
</head>
<body>
	<!-- 1.click vao login -->
	<!-- 2.Hiển thị from login  -->
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
				<form action="LoginController"
					class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-53"> Đăng nhập</span> <a
						href="https://www.facebook.com/dialog/oauth?client_id=2333204793575897&redirect_uri=https://nmcnpmgr5.azurewebsites.net/login-facebook"
						class="btn-face m-b-20"> <i class="fab fa-facebook-square"></i>
						Facebook
					</a> <a href="#" class="btn-google m-b-20"> <img
						src="images/icons/icon-google.png" alt="GOOGLE"> Google
					</a>

					<div class="p-t-31 p-b-9">
						<span class="txt1"> <i class="fas fa-user"></i>
							&nbsp;Username
						</span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Username is required">
						<input class="input100" type="text" name="username"> <span
							class="focus-input100"></span>
					</div>

					<div class="p-t-13 p-b-9">
						<span class="txt1"> <i class="fas fa-key"></i>&nbsp;Password
						</span> <a href="#" class="txt2 bo1 m-l-5"> Quên mật khẩu? </a>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="pass"> <span
							class="focus-input100"> </span>
					</div>
					<div class="s" style="color: red; margin-top: 20px;"><%=StringUtil.getString(session.getAttribute("error"))%>
					</div>
					<div class="container-login100-form-btn m-t-17">
						<button type="submit" class="login100-form-btn">Login</button>
					</div>
					<!--====================================1.Chọn đăng ký tài khoản ===========================================================-->
					<div class="w-full text-center p-t-55">
						<span class="txt2"> Nếu chưa có tài khoản vui lòng </span> <a
							href="Register.jsp" class="txt2 bo1"> Đăng kí </a>
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