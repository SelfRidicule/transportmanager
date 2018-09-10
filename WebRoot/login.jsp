<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  	<link href="css/logincss/bootstrap.min.css" rel="stylesheet">
    <link href="css/logincss/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/logincss/animate.css" rel="stylesheet">
    <link href="css/logincss/style.css" rel="stylesheet">
    <link href="css/logincss/login.css" rel="stylesheet">


</head>

<body class="signin" style="background-image: url('img/login-background.jpg');">

	<div class="signinpanel" style="float: right; margin-right: 200px; ">
        <div class="row" >
            <div class="col-sm-12" >
                <form method="post" action="${pageContext.request.contextPath}/login"  style="background-color: #f0f0f0 ;">
                    <h3 class="no-margins" style="color: #0c141d;">欢迎登录：<span style="color: red">${loginstate}</span></h3>
                    <input type="text" name="account" class="form-control uname" placeholder="帐号" required="required"/>
                    <input type="password" name="password" class="form-control pword m-b" placeholder="密码" required="required"/>
                    <a href="javascript:void;">关于我们</a>
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
    </div>
	
	<div style="font-size: 40px; margin-left: 30px; margin-top: 40px;">淮安交运危货运输有限公司信息化管理系统</div>
		
</body>

</html>