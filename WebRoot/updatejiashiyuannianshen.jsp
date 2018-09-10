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
	<link href="${pageContext.request.contextPath}/css/jedate.css" rel="stylesheet">
	
	<title>修改驾驶员年审</title>
	
	
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">修改驾驶员年审</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加保险 -->
				<form name="myform" action="${pageContext.request.contextPath}/updateJiaShiYuanNianShen" onsubmit="" method="post">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶车辆 <span style="color: red;">*</span> </label>
						<input  value="${singlejiashiyuannianshen.jiashicheliang}" class="form-control"  readonly="readonly"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶员姓名 <span style="color: red;">*</span> </label>
						<input  value="${singlejiashiyuannianshen.jiashiyuanxingming}" class="form-control"  readonly="readonly"/>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶证年审到期日期</label>
						<input id="riqi1" name="jiashizhengnianshenriqi" value="${fn:substring(singlejiashiyuannianshen.jiashizhengnianshenriqi, 0, 10)}" class="form-control" placeholder="请输入驾驶证年审到期日期" />
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶证有效日期至</label>
						<input id="riqi2" name="zhengjianyouxiaoriqi" value="${fn:substring(singlejiashiyuannianshen.zhengjianyouxiaoriqi, 0, 10)}" class="form-control" placeholder="请输入驾驶证有效日期至" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>从业资格证有效期至</label>
						<input id="riqi3" name="congyezigeriqi" value="${fn:substring(singlejiashiyuannianshen.congyezigeriqi, 0, 10)}" class="form-control" placeholder="请输入从业资格证有效期至" />
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>继续教育有效期起</label>
						<input id="riqi4" name="congyezigejixujiaoyushijian" value="${fn:substring(singlejiashiyuannianshen.congyezigejixujiaoyushijian, 0, 10)}" class="form-control" placeholder="请输入继续教育有效期起" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>继续教育有效期止</label>
						<input id="riqi5" name="congyezigejixujiaoyushijianzhi" value="${fn:substring(singlejiashiyuannianshen.congyezigejixujiaoyushijianzhi, 0, 10)}" class="form-control" placeholder="请输入继续教育有效期止" />
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>诚信考核到期日期</label>
						<input id="riqi6" name="congyezigechengxinkaoheshijian" value="${fn:substring(singlejiashiyuannianshen.congyezigechengxinkaoheshijian, 0, 10)}" class="form-control" placeholder="请输入诚信考核到期日期" />
					</div>	
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/jumpJiaShiYuanNianShen"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
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
	<script src="${pageContext.request.contextPath}/js/jedate.js"></script>
	
	<script type="text/javascript">
			
		$(function(){
		
			$("#riqi1,#riqi2,#riqi3,#riqi4,#riqi5,#riqi6").jeDate({
			    ishmsVal:false,
			    minDate: '1200-12-12',
				
			    format:"YYYY-MM-DD",
			    zIndex:3000,
			});
		
		});	
			
	</script>	
</body>

</html>
