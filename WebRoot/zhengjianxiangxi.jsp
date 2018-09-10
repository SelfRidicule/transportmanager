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
	<link href="css/lightbox.css" rel="stylesheet">
	
	<title>证件详细</title>
	
	<script type="text/javascript">
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">证件详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号 : <span style="font-weight:normal;">${singlezhengjian.chepaihao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>证件类型 : <span style="font-weight:normal;">${singlezhengjian.zhengjianleixing}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>办理日期 : <span style="font-weight:normal;">${singlezhengjian.banliriqi }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>到期日期 : <span style="font-weight:normal;">${singlezhengjian.daoqiriqi}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>证件号码 : <span style="font-weight:normal;">${singlezhengjian.zhengjianhaoma}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>操作员 : <span style="font-weight:normal;">${singlezhengjian.caozuoyuan}</span></label>
					</div>						
					
						<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>操作日起 : <span style="font-weight:normal;">${singlezhengjian.caozuoriqi}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>附件</label>
					</div>	
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div style="margin-left: 20px;width: 100%;">
						<c:forEach items="${picturelist}" var="picturepaths">
							<div style="margin-left: 10px;margin-top: 10px;float: left;">
								 <a class="example-image-link" href="${picturepaths}" data-lightbox="example-set" >
								 	<img class="example-image" src="${picturepaths}" width="300px" height="200px"/>
								 </a>
							</div>
				        </c:forEach>					
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					<br/>	
										
					<a href="${pageContext.request.contextPath}/jumpZhengJian"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
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
	<script src="js/lightbox-plus-jquery.js"></script>
	
</body>

</html>
