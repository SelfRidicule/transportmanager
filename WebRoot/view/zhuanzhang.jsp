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
	<link href="css/bootstrap-select.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/jedate.css" rel="stylesheet">
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="${pageContext.request.contextPath}/js/jedate.js"></script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">转账</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加 -->
				<form name="myform" action="${pageContext.request.contextPath}/zhuanZhangJieSuanDan" onsubmit="" method="post">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>订单号<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="dingdanhao" class="form-control" value="${singleyingshoukuan.dingdanhao}" readonly="readonly"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>真实车主 </label>
						<select id="basic2" name="zhenshichezhu" class="show-tick form-control">
					        <c:forEach items="${chelianglist}" var="cheliang">
									<option value="${cheliang.chezhuxingming}">${cheliang.chezhuxingming}</option>
					        </c:forEach>
						</select>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">转账</button>
					<a href="${pageContext.request.contextPath}/jumpYingShouKuan"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->
	
	<script type="text/javascript">
		
		$(function(){
		
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      size: 10 ,//点击 展示多少选项
		      maxOptions: 1
		    });
		    
		});
		
	</script>	
</body>

</html>
