<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/datepicker3.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	
	
	<script type="text/javascript" src="laydate/laydate.js" ></script>
	<script type="text/javascript">
		var smalltime = {
		  format: 'YYYY-MM-DD hh:mm:ss',
		  istime: true,
		};
	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">添加车辆管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加车辆管理 -->
				
				<form name="myform" action="${pageContext.request.contextPath}/addCheLianGuanLi" onsubmit="" method="post">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 3%">
						<label>请选择对应的类别</label>
						<select class="form-control" name="type">
								<option value="1">车辆类型</option>
								<option value="2">车辆品牌</option>
								<option value="3">车辆型号</option>
								<option value="5">车辆分组</option>
								<option value="6">经营范围</option>
						</select>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 3%">
						<label>请输出名称<span id="leader" style="color: red;"></span></label>
						<input name="name" class="form-control" placeholder="请输出名称" required="required"/>
					</div>						
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 3%">
						<label>请选择实际类型</label>
						<select class="form-control" name="shijileixing">
								<option value="">请选择</option>
								<option value="单头车">单头车</option>
								<option value="挂车">挂车</option>
								<option value="牵引车">牵引车</option>
						</select>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 3%">添加</button>
					<a href="${pageContext.request.contextPath}/manager/cheliangguanli/cheliangguanli.jsp"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>
				
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart-data.js"></script>
	<script src="${pageContext.request.contextPath}/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/js/easypiechart-data.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
	
	<script>
		
	</script>	
</body>

</html>