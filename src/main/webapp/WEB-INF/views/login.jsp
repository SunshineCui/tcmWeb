<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@include file="/resources/common/common-base.jsp" %>

<!DOCTYPE html>
<html style="background: url(${imgPath}/bg.jpg) no-repeat center center;background-size:cover">
<head>
	<meta charset="UTF-8">
	<title>登录到 中医药</title>
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<%--<meta name="renderer" content="webkit|ie-comp|ie-stand">--%>
	<link href="${cssPath}/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${cssPath}/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="${cssPath}/AdminLTE.css" rel="stylesheet" type="text/css" />

	<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	<style>
		body{
			background: none;
		}
		.yzm {
			height: 35px;
			margin-bottom: 5px;
			outline: none;
			border-radius: 5px;
			font-size: 12px;
			color: #a9a9a9;
			width: 100px;
		}
		.vcode {
			vertical-align: middle;
			margin: 0 5px;
		}
		.font-w{
			font-weight: bold;
			color: #333333;
		}
	</style>
</head>
<body>

<div class="form-box" id="login-box">
	<div class="header" style="background-color: rgba(0,0,0,0.2)">官网管理后台 | Sign in</div>
	<form action="${ctxPath}/w/user/login" method="post" id="ljform">
		<div class="body" style="background-color: rgba(0,0,0,0.2)">
			<div class="form-group">
				<input type="text" name="userName" id="userName" class="account form-control" placeholder="请输入用户名"/>
			</div>
			<div class="form-group">
				<input type="password" name="password" id="password" class="pwd form-control" placeholder="请输入密码"/>
			</div>
			<div class="form-group">
				<input type="text" placeholder="请输入验证码" name="vcode" class="yzm form-control" style="display: inline"/>
				<img class="vcode" src="${ctxPath}/w/getVerifyCodeImage?<%=Math.random()%>" id="verifyCodeImage" width="80px" height="35px" />
				<a href="javascript:;" onclick="reloadVerifyCode();" class="font-w">刷新</a>
			</div>
		</div>
		<div class="footer" style="background-color: rgba(0,0,0,0.2)">
			<button type="submit" class="btn btn-block login" style="background-color:rgba(252, 109, 44, 1);color: #FFFFFF">登录</button>
			<p style="clear: both"><span class="showMsg" id="LoginErrorTip" style="color:red;"></span></p>
		</div>
	</form>
</div>

<script src="${jsPath}/jquery/2.0.2/jquery.min.js"></script>
<script src="${jsPath}/bootstrap/bootstrap.min.js" type="text/javascript"></script>
<script src="${jsPath}/login/login.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		var login = new Login();
		login.submit('.login', 'click', 'liform');
		console.log('${loginerror}');
		<c:if test="${loginerror != null && loginerror!=''}">
		$(".showMsg").html('<span class="errorMsg">${loginerror}</span>');
		</c:if>

		if (!window.applicationCache) {
			alert("你的浏览器不支持HTML5");
			$("#liform").attr("action",window.location.href);
		}
	});
	function reloadVerifyCode(){
		$("#verifyCodeImage").attr('src', '${pageContext.request.contextPath}/w/getVerifyCodeImage?'+Math.random());
	}
</script>
</body>
</html>