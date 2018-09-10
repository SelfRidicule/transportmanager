<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<title>用户资料</title>
	
	<script type="text/javascript">
			
	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">添加用户</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加用户 -->
				<form name="myform" action="${pageContext.request.contextPath}/addUsers" onsubmit="" method="post">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>帐号 <span style="color: red;">*</span></label>
						<input name="account" class="form-control" placeholder="请输入帐号" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>姓名<span style="color: red;">*</span></label>
						<input name="username" class="form-control" placeholder="请输入姓名" required="required"/>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>密码<span style="color: red;">*</span></label>
						<input name="password" type="text" class="form-control" placeholder="请出入密码" required="required"/>
					</div>
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>邮箱<span id="email" style="color: red;"></span></label>
						<input name="email" class="form-control" placeholder="请输邮箱"/>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
						
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>部门/科室<span style="color: red;">*</span></label>
						<select class="form-control" name="deptid">
							<c:forEach items="${deptlist}" var="dept">
								<option value="${dept.deptid}">${dept.deptname}</option>
					        </c:forEach>
						</select>
					</div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>权限<span style="color: red;">*</span></label>
						<select class="form-control" name="quanxianmingcheng" required="required">
							<c:forEach items="${quanxianmingchenglist}" var="quanxianmingcheng">
								<option value="${quanxianmingcheng}">${quanxianmingcheng}</option>
					        </c:forEach>							
						</select>
					</div>
						
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>性别 </label><br/>						
						男<input name="sex" type="radio" name="sex"  value="男" checked />&nbsp
						女<input name="sex" type="radio" name="sex"  value="女" />
					</div>
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>用户备注<span id="comment" style="color: red;"></span></label>
						<textarea class="form-control" rows="3" name="comment"></textarea>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">注册</button>
					<a href="${pageContext.request.contextPath}/returnUsers"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	
	<script>
		
	</script>	
</body>

</html>
