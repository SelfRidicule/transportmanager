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
				<li class="active">办理材料整理、档案建立</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/addCaiLiaoZhengLi" onsubmit="" method="post" enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>建立一车一档<span style="color: red;  padding-top: 10px">*</span></label><br/>
						完成<input name="yicheyidang" type="radio"   value="完成" />&nbsp
					    未完成<input name="yicheyidang" type="radio"   value="未完成" checked />
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
							<label>建立一人一档<span style="color: red;  padding-top: 10px">*</span></label><br/>
						完成<input name="yirenyidang" type="radio"   value="完成" />&nbsp
					    未完成<input name="yirenyidang" type="radio"   value="未完成" checked />
					</div>		
								
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>发票交接<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="fapiaojiaojie" class="form-control" placeholder="请输入发票交接" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>发票接收人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="fapiaojieshouren" class="form-control" placeholder="请输入发票接收人" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>电子路单工作交接-接收人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="dianzilujieshouren" class="form-control" placeholder="请输入电子路接收人" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>合同签订<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="hetongqianding" class="form-control" placeholder="请输入合同签订" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<br/>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">办理</button>
					<a href="${pageContext.request.contextPath}/jumpCaiLiaoZhengLi"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
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
