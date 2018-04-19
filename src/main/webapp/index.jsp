<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src=static/jquery/jquery-3.1.0.js></script>
<link href="static/css/bootstrap.css.map" rel="stylesheet" />
<script src=static/script/bootstrap.js></script>
<script type="text/javascript" src="static/script/Vcode.js"></script>
<script type="text/javascript" src="static/script/SecKill.js"></script>
</head>
<body>
	<jsp:useBean id="user" class="com.luoaijun.redis.bean.User"
		scope="request"></jsp:useBean>
	<div class="container">
		<div class="row">
			<div id="alertdiv" class="col-md-12">
				<form:form class="navbar-form navbar-left" role="search"
					id="codeform" modelAttribute="user">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="填写手机号"
							name="phone_no">
						<button type="button" class="btn btn-default" id="sendCode">发送验证码</button>
						<br> <font id="countdown" color="red"></font> <br> <input
							type="text" class="form-control" placeholder="填写验证码"
							name="verify_code">
						<button type="button" class="btn btn-default" id="verifyCode">确定</button>
						<font id="result" color="green"></font> <font id="error"
							color="red"></font>
					</div>
					<center>
						<input type="hidden" id="prodid" name="prodid" value="0101">
						<input type="button" id="miaosha_btn" name="seckill_btn"
							value="秒杀点我" />
					</center>
				</form:form>

			</div>

		</div>
	</div>
</body>
</html>