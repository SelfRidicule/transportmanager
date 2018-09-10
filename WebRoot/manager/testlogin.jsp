<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

</head>

<body>
	
	<img alt="" src="${pageContext.request.contextPath}/manager/shoutu.jpg" style="position: absolute; width: 100%; height: 100%;">
	
	<!--
    	标题
    -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>淮安交运</span>信息管理系统</a>
				
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	
	<!-- 登录窗口 -->
	<div class="row" style="margin-top: 30px;">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">登录界面 <span style="color: red">${loginstate}</span></div>
				<div class="panel-body">
					<form role="form" action="${pageContext.request.contextPath}/login" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="帐号" name="account" type="text" value="" required="required"/>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="密码" name="password" type="password" value="" required="required"/>
							</div>
							<input type="submit" class="btn btn-primary" value="登录"/>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	
		

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
</body>

</html>