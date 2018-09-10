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
		  format: 'YYYY-MM-DD',
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
				<li class="active">添加权限</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加保险 -->
				<form name="myform" action="${pageContext.request.contextPath}/addQuanXian" onsubmit="" method="post">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>权限名称 <span style="color: red;">*</span></label>
						<input name="quanxianmingcheng" class="form-control" placeholder="请输入权限名称" required="required"/>
					</div>		
					<div class="form-group" style="width: 60%; float: left; margin-left: 30px">
						<button type="button" name="allselect"    class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 25px">全选</button>
						<button type="button" name="cancelselect" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 25px">取消全选</button>
					</div>				
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px; ">
						<label>工作门户</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanmenhu" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihumenhu" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengmenhu" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>用户管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyonghu" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyonghu" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyonghu" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>权限设置</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanquanxian" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuquanxian" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengquanxian" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>部门管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbumen" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubumen" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbumen" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>安全管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakananquanguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuanquanguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzenganquanguanli" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>车辆管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancheliang" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucheliang" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcheliang" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>关系建立</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanguanxijianli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuguanxijianli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengguanxijianli" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>保险管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbaoxianguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubaoxianguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbaoxianguanli" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>证件管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzhengjian" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzhengjian" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzhengjian" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>年审管理</label>
						<div style="float:right ; margin-right: 30%"><label><input type="checkbox" name="chakansuoyounianshen" value="1" >查看所有</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakannianshen" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihunianshen" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengnianshen" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanguanli" value="1" >新增</label></div>
					</div>		
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员资料</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanziliao" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanziliao" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanziliao" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员审核</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanshenhe" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanshenhe" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanshenhe" value="1" >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员年审</label>
						<div style="float:right ; margin-right: 30%"><label><input type="checkbox" name="chakansuoyoujiashiyuannianshen" value="1" >查看所有</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakanjiashiyuannianshen" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuannianshen" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuannianshen" value="1" >新增</label></div>
					</div>				
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>新车入户</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanxincheruhu" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuxincheruhu" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengxincheruhu" value="1" >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>新车管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanxinche" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuxinche" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengxinche" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>投入审核和申请</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakantourushenhe" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihutourushenhe" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengtourushenhe" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>车管业务</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancheguanyewu" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucheguanyewu" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcheguanyewu" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>运管业务</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyunguanyewu" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyunguanyewu" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyunguanyewu" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>保险出单</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbaoxianchudan" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubaoxianchudan" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbaoxianchudan" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>材料整理档案建立</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancailiaozhengli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucailiaozhengli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcailiaozhengli" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>费用结算</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfeiyongjiesuan" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufeiyongjiesuan" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfeiyongjiesuan" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>责任人签字</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzerenrenqianzi" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzerenrenqianzi" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzerenrenqianzi" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>分管领导意见</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfenguanlingdaoyijian" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufenguanlingdaoyijian" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfenguanlingdaoyijian" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>业务管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyewuguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyewuguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyewuguanli" value="1" >新增</label></div>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>客户管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankehuguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukehuguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkehuguanli" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>运单管理</label>
						<div style="float:right ; margin-right: 30%"><label><input type="checkbox" name="chakansuoyouyundanguanli" value="1" >查看所有</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakanyundanguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyundanguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyundanguanli" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>运单审核</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyundanshenhe" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyundanshenhe" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyundanshenhe" value="1" >新增</label></div>
					</div>					
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>财务管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancaiwuguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucaiwuguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcaiwuguanli" value="1" >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>费用收取</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfeiyongshouqu" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufeiyongshouqu" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfeiyongshouqu" value="1" >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>营收款管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyingshoukuanguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyingshoukuanguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyingshoukuanguanli" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票申请</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankaipiaoshenqing" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukaipiaoshenqing" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkaipiaoshenqing" value="1" >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票审核(分管负责人)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfenguankaipiaoshenhe" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufenguankaipiaoshenhe" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfenguankaipiaoshenhe" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票审核(总经理)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzongjinglikaipiaoshenhe" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzongjinglikaipiaoshenhe" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzongjinglikaipiaoshenhe" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankaipiao" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukaipiao" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkaipiao" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankaipiaoguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukaipiaoguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkaipiaoguanli" value="1" >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算申请</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiesuanshenqing" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiesuanshenqing" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiesuanshenqing" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算审核(总经理)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzongjinglijiesuanshenhe" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzongjinglijiesuanshenhe" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzongjinglijiesuanshenhe" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算审核(董事长)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakandongshizhangjiesuanshenhe" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihudongshizhangjiesuanshenhe" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengdongshizhangjiesuanshenhe" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiesuan" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiesuan" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiesuan" value="1" >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算单管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiesuandanguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiesuandanguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiesuandanguanli" value="1" >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>危险品数据库</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanweixianpin" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuweixianpin" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengweixianpin" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>管理</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanguanli" value="1" >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuguanli" value="1" >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengguanli" value="1" >新增</label></div>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">添加</button>
					<a href="${pageContext.request.contextPath}/returnQuanXian"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
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
