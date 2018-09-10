<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<title>保险详细</title>
	
	<script type="text/javascript">
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">保险详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号 : <span style="font-weight:normal;">${singlebaoxian.chepaihao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>保险类型 : <span style="font-weight:normal;">${singlebaoxian.baoxianleixing}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>保险公司 : <span style="font-weight:normal;">${singlebaoxian.baoxiangongsi }</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>保险费用 : <span style="font-weight:normal;">${singlebaoxian.toubaojine}</span></label>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>到期日期 : <span style="font-weight:normal;"><fmt:formatDate value="${singlebaoxian.daoqiriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>保单号 : <span style="font-weight:normal;">${singlebaoxian.baodanhao}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>					
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>保险金额 : <span style="font-weight:normal;">${singlebaoxian.baoxianzhonglei}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>办理日期 : <span style="font-weight:normal;"> <fmt:formatDate value="${singlebaoxian.banliriqi}" pattern="yyyy-MM-dd"/> </span></label>
					</div>							
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>保险代理公司 : <span style="font-weight:normal;">${singlebaoxian.baoxiandailigongsi}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>代理费 : <span style="font-weight:normal;">${singlebaoxian.baofei}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					
					<a href="${pageContext.request.contextPath}/jumpBaoXian"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
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
