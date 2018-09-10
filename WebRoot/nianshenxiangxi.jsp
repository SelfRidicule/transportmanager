<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<title>年审详细</title>
	
	<script type="text/javascript">
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">年审详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号 : <span style="font-weight:normal;">${singlenianshen.chepaihao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车主姓名 : <span style="font-weight:normal;">${singlenianshen.chezhuxingming}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>手机号 : <span style="font-weight:normal;">${singlenianshen.shoujihao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>行驶证年审日期 : <span style="font-weight:normal;">${fn:substring(singlenianshen.nianshenriqi, 0, 10)}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>行驶证年审到期日期 : <span style="font-weight:normal;">${fn:substring(singlenianshen.daoqiriqi, 0, 10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>道路运输证年审到期日期 : <span style="font-weight:normal;">${fn:substring(singlenianshen.daoludaoqiriqi, 0, 10)}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>二级维护到期日期 : <span style="font-weight:normal;">${fn:substring(singlenianshen.erjidaoqiriqi, 0, 10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>等级评定到期日期 : <span style="font-weight:normal;">${fn:substring(singlenianshen.dengjidaoqiriqi, 0, 10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>罐体到期日期 : <span style="font-weight:normal;">${fn:substring(singlenianshen.guantidaoqiriqi, 0, 10)}</span></label>
					</div>				
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>			
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>操作员 : <span style="font-weight:normal;">${singlenianshen.caozuoyuan}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>操作日期 : <span style="font-weight:normal;">${fn:substring(singlenianshen.caozuoriqi, 0, 10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>		
					
					<a href="${pageContext.request.contextPath}/jumpNianShen"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
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
