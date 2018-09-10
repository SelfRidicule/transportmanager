<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<link href="css/lightbox.css" rel="stylesheet">
	
	<title>驾驶员年审详细</title>
	
	<script type="text/javascript">
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">驾驶员年审详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶员姓名 : <span style="font-weight:normal;">${singlejiashiyuannianshen.jiashiyuanxingming }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶车辆 : <span style="font-weight:normal;">${singlejiashiyuannianshen.jiashicheliang}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶证年审到期日期 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuannianshen.jiashizhengnianshenriqi, 0, 10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶证有效日期至 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuannianshen.zhengjianyouxiaoriqi, 0, 10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>从业资格证有效期至 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuannianshen.congyezigeriqi, 0, 10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>继续教育有效期起 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuannianshen.congyezigejixujiaoyushijian, 0, 10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>继续教育有效期止 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuannianshen.congyezigejixujiaoyushijianzhi, 0, 10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>诚信考核到期日期 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuannianshen.congyezigechengxinkaoheshijian, 0, 10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<br/>	
										
					<a href="${pageContext.request.contextPath}/jumpJiaShiYuanNianShen"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
					<br/><br/>
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
