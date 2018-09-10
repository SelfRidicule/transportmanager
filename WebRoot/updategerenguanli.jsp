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
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script type="text/javascript" src="laydate/laydate.js" ></script>
	<script type="text/javascript">
		var smalltime = {
		  format: 'YYYY-MM-DD hh:mm:ss',
		  istime: true,
		};
	</script>
	
	<style type="text/css">
		
		div label{
			font-weight:normal;
		}
		
	</style>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">修改个人显示</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加保险 -->
				<form name="myform" action="${pageContext.request.contextPath}/updateGeRenGuanLi" onsubmit="" method="post">	
					
					<div class="form-group" style="width: 60%; float: left; margin-left: 20%">
						<button type="button" name="allselect"    class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 25px">全选</button>
						<button type="button" name="cancelselect" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 25px">取消全选</button>
					</div>				
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>新车入户</label>
						<c:if test="${singlegerenguanli.xincheruhu == '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="xincheruhu" value="1" checked="checked" >显示</label></div>
						</c:if>
						<c:if test="${singlegerenguanli.xincheruhu != '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="xincheruhu" value="1" >显示</label></div>
						</c:if>
					</div>					
					
					<%-- <!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>证件管理</label>
						<c:if test="${singlegerenguanli.zhengjianguanli == '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="zhengjianguanli" value="1" checked="checked" >显示</label></div>
						</c:if>
						<c:if test="${singlegerenguanli.zhengjianguanli != '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="zhengjianguanli" value="1" >显示</label></div>
						</c:if>
					</div>			 --%>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>当前运单</label>
						<c:if test="${singlegerenguanli.dangqianyundan == '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="dangqianyundan" value="1" checked="checked" >显示</label></div>
						</c:if>
						<c:if test="${singlegerenguanli.dangqianyundan != '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="dangqianyundan" value="1" >显示</label></div>
						</c:if>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员审核</label>
						<c:if test="${singlegerenguanli.jiashiyuanshenhe == '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="jiashiyuanshenhe" value="1" checked="checked" >显示</label></div>
						</c:if>
						<c:if test="${singlegerenguanli.jiashiyuanshenhe != '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="jiashiyuanshenhe" value="1" >显示</label></div>
						</c:if>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>保险提醒</label>
						<c:if test="${singlegerenguanli.baoxiantixing == '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="baoxiantixing" value="1" checked="checked" >显示</label></div>
						</c:if>
						<c:if test="${singlegerenguanli.baoxiantixing != '1' }">
							<div style="float:right ; margin-right: 85%"><label><input type="checkbox" name="baoxiantixing" value="1" >显示</label></div>
						</c:if>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<br/><br/>
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->
	
	<script type="text/javascript">

		$(function(){
			
			$("button[name='allselect']").click(function(){
				
				$('input:checkbox').prop('checked', true);
					
			});
			
			$("button[name='cancelselect']").click(function(){
				
				$('input:checkbox').prop('checked', false);
					
			});
			
			
		});
		
	</script>	
</body>

</html>
