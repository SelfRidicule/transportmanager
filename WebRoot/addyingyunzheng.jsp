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
				<li class="active">材料收集、营运证办理、安全教育</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/addYingYunZheng" onsubmit="" method="post" enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>罐体产品质量说明书</label>
						<input type="file" name="guantichanpin">
						<input type="checkbox" value="已收集" name="guantichanpinshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>二维与等评</label>
						<input type="file" name="erweiyudengjia">
						<input type="checkbox" value="已收集" name="erweiyudengjiashouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆罐检查报告</label>
						<input type="file" name="cheliangguan">
						<input type="checkbox" value="已收集" name="cheliangguanshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>押运人员材料、劳动合同</label>
						<input type="file" name="yayuncailiao">
						<input type="checkbox" value="已收集" name="yayuncailiaoshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>初次检测设施设备配备情况查验登记表</label>
						<input type="file" name="chucijiance">
						<input type="checkbox" value="已收集" name="chucijianceshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆照片</label>
						<input type="file" name="cheliangzhaopian">
						<input type="checkbox" value="已收集" name="cheliangzhaopianshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>燃料消耗达标车型核查表</label>
						<input type="file" name="ranshaoxiaohao">
						<input type="checkbox" value="已收集" name="ranshaoxiaohaoshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>承运人责任险保单</label>
						<input type="file" name="chengyunren">
						<input type="checkbox" value="已收集" name="chengyunrenshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>整车装备外观检视及人工测量记录表</label>
						<input type="file" name="zhengchezhuangbei">
						<input type="checkbox" value="已收集" name="zhengchezhuangbeishouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>岗前安全教育培训考核</label>
						<input type="file" name="gangqiananquan">
						<input type="checkbox" value="已收集" name="gangqiananquanshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>安全卡</label>
						<input type="file" name="anquanka">
						<input type="checkbox" value="已收集" name="anquankashouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆营运证</label>
						<input type="file" name="yingyunzheng">
						<input type="checkbox" value="已收集" name="yingyunzhengshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>责任人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="zerenren" class="form-control" placeholder="请输入责任人" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">办理</button>
					<a href="${pageContext.request.contextPath}/jumpYingYunZheng"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					<br/>
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	
	<script>
		$('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });
		    
		$('#basic3').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });    
	</script>	
</body>

</html>
