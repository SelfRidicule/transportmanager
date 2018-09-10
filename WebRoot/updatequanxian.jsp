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
				<li class="active">修改权限</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加保险 -->
				<form name="myform" action="${pageContext.request.contextPath}/submitUpdateQuanXian" onsubmit="" method="post">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>权限名称 <span style="color: red;">*</span></label>
						<input name="quanxianmingcheng" class="form-control" value="${singlequanxianmingcheng}"  readonly="readonly"/>
					</div>		
					<div class="form-group" style="width: 60%; float: left; margin-left: 30px">
						<button type="button" name="allselect"    class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 25px">全选</button>
						<button type="button" name="cancelselect" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 25px">取消全选</button>
					</div>				
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>工作门户</label>
						<c:if test="${singlemenhu.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanmenhu" value="1" checked="checked" >查看</label></div>
						</c:if>
						<c:if test="${singlemenhu.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanmenhu" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlemenhu.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihumenhu" value="1" checked="checked" >维护</label></div>
						</c:if>
						<c:if test="${singlemenhu.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihumenhu" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlemenhu.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengmenhu" value="1" checked="checked" >新增</label></div>
						</c:if>
						<c:if test="${singlemenhu.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengmenhu" value="1" >新增</label></div>
						</c:if>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>用户管理</label>
						<c:if test="${singleyonghu.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyonghu" value="1" checked="checked" >查看</label></div>
						</c:if>
						<c:if test="${singleyonghu.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyonghu" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleyonghu.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyonghu" value="1" checked="checked" >维护</label></div>
						</c:if>
						<c:if test="${singleyonghu.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyonghu" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleyonghu.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyonghu" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleyonghu.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyonghu" value="1" >新增</label></div>
						</c:if>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>权限设置</label>
						<c:if test="${singlequanxian.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanquanxian" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlequanxian.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanquanxian" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlequanxian.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuquanxian" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlequanxian.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuquanxian" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlequanxian.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengquanxian" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlequanxian.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengquanxian" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>部门管理</label>
						<c:if test="${singlebumenguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbumen" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlebumenguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbumen" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlebumenguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubumen" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlebumenguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubumen" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlebumenguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbumen" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlebumenguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbumen" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>安全管理</label>
						<c:if test="${singleanquanguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakananquanguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleanquanguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakananquanguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleanquanguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuanquanguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleanquanguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuanquanguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleanquanguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzenganquanguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleanquanguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzenganquanguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>				
								
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>车辆管理</label>
						<c:if test="${singlecheliangguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancheliang" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlecheliangguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancheliang" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlecheliangguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucheliang" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlecheliangguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucheliang" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlecheliangguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcheliang" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlecheliangguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcheliang" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>关系建立</label>
						<c:if test="${singleguanxijianli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanguanxijianli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleguanxijianli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanguanxijianli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleguanxijianli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuguanxijianli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleguanxijianli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuguanxijianli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleguanxijianli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengguanxijianli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleguanxijianli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengguanxijianli" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>保险管理</label>
						<c:if test="${singlebaoxianguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbaoxianguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlebaoxianguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbaoxianguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlebaoxianguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubaoxianguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlebaoxianguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubaoxianguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlebaoxianguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbaoxianguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlebaoxianguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbaoxianguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>证件管理</label>
						<c:if test="${singlezhengjianguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzhengjian" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlezhengjianguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzhengjian" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlezhengjianguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzhengjian" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlezhengjianguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzhengjian" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlezhengjianguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzhengjian" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlezhengjianguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzhengjian" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>年审管理</label>
						
						<div style="float:right ; margin-right: 30%"><label><input type="checkbox" name="chakansuoyounianshen" value="1"  <c:if test="${singlenianshenguanli.chakansuoyou == '1' }">checked="checked"</c:if> >查看所有</label></div>
						
						<c:if test="${singlenianshenguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakannianshen" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlenianshenguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakannianshen" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlenianshenguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihunianshen" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlenianshenguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihunianshen" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlenianshenguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengnianshen" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlenianshenguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengnianshen" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员管理</label>
						<c:if test="${singlejiashiyuanguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuanguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuanguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员资料</label>
						<c:if test="${singlejiashiyuanziliao.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanziliao" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanziliao.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanziliao" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuanziliao.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanziliao" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanziliao.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanziliao" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuanziliao.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanziliao" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanziliao.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanziliao" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员审核</label>
						<c:if test="${singlejiashiyuanshenhe.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanshenhe" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanshenhe.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiashiyuanshenhe" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuanshenhe.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanshenhe" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanshenhe.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuanshenhe" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuanshenhe.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanshenhe" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlejiashiyuanshenhe.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuanshenhe" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>驾驶员年审</label>
						
						<div style="float:right ; margin-right: 30%"><label><input type="checkbox" name="chakansuoyoujiashiyuannianshen" value="1"  <c:if test="${singlejiashiyuannianshen.chakansuoyou == '1' }">checked="checked"</c:if> >查看所有</label></div>
						
						<c:if test="${singlejiashiyuannianshen.chakan == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakanjiashiyuannianshen" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlejiashiyuannianshen.chakan != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakanjiashiyuannianshen" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuannianshen.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuannianshen" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlejiashiyuannianshen.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiashiyuannianshen" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlejiashiyuannianshen.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuannianshen" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlejiashiyuannianshen.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiashiyuannianshen" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>新车入户</label>
						<c:if test="${singlexincheruhu.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanxincheruhu" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlexincheruhu.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanxincheruhu" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlexincheruhu.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuxincheruhu" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlexincheruhu.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuxincheruhu" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlexincheruhu.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengxincheruhu" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlexincheruhu.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengxincheruhu" value="1" >新增</label></div>
						</c:if>
						
					</div>							
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>新车管理</label>
						<c:if test="${singlexincheguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanxinche" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlexincheguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanxinche" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlexincheguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuxinche" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlexincheguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuxinche" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlexincheguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengxinche" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlexincheguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengxinche" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>投入审核和申请</label>
						<c:if test="${singletourushenhe.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakantourushenhe" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singletourushenhe.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakantourushenhe" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singletourushenhe.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihutourushenhe" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singletourushenhe.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihutourushenhe" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singletourushenhe.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengtourushenhe" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singletourushenhe.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengtourushenhe" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>车管业务</label>
						<c:if test="${singlecheguanyewu.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancheguanyewu" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlecheguanyewu.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancheguanyewu" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlecheguanyewu.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucheguanyewu" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlecheguanyewu.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucheguanyewu" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlecheguanyewu.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcheguanyewu" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlecheguanyewu.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcheguanyewu" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>运管业务</label>
						<c:if test="${singleyunguanyewu.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyunguanyewu" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleyunguanyewu.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyunguanyewu" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleyunguanyewu.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyunguanyewu" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleyunguanyewu.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyunguanyewu" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleyunguanyewu.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyunguanyewu" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleyunguanyewu.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyunguanyewu" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>保险出单</label>
						<c:if test="${singlebaoxianchudan.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbaoxianchudan" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlebaoxianchudan.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanbaoxianchudan" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlebaoxianchudan.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubaoxianchudan" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlebaoxianchudan.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihubaoxianchudan" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlebaoxianchudan.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbaoxianchudan" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlebaoxianchudan.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengbaoxianchudan" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>材料整理档案建立</label>
						<c:if test="${singlecailiaozhengli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancailiaozhengli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlecailiaozhengli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancailiaozhengli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlecailiaozhengli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucailiaozhengli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlecailiaozhengli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucailiaozhengli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlecailiaozhengli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcailiaozhengli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlecailiaozhengli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcailiaozhengli" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>费用结算</label>
						<c:if test="${singlefeiyongjiesuan.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfeiyongjiesuan" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlefeiyongjiesuan.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfeiyongjiesuan" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlefeiyongjiesuan.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufeiyongjiesuan" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlefeiyongjiesuan.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufeiyongjiesuan" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlefeiyongjiesuan.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfeiyongjiesuan" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlefeiyongjiesuan.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfeiyongjiesuan" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>责任人签字</label>
						<c:if test="${singlezerenrenqianzi.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzerenrenqianzi" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlezerenrenqianzi.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzerenrenqianzi" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlezerenrenqianzi.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzerenrenqianzi" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlezerenrenqianzi.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzerenrenqianzi" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlezerenrenqianzi.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzerenrenqianzi" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlezerenrenqianzi.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzerenrenqianzi" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>分管领导意见</label>
						<c:if test="${singlefenguanlingdaoyijian.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfenguanlingdaoyijian" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlefenguanlingdaoyijian.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfenguanlingdaoyijian" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlefenguanlingdaoyijian.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufenguanlingdaoyijian" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlefenguanlingdaoyijian.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufenguanlingdaoyijian" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlefenguanlingdaoyijian.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfenguanlingdaoyijian" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlefenguanlingdaoyijian.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfenguanlingdaoyijian" value="1" >新增</label></div>
						</c:if>
						
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>业务管理</label>
						<c:if test="${singleyewuguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyewuguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleyewuguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyewuguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleyewuguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyewuguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleyewuguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyewuguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleyewuguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyewuguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleyewuguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyewuguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>									
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>客户管理</label>
						<c:if test="${singlekehuguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankehuguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlekehuguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankehuguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlekehuguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukehuguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlekehuguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukehuguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlekehuguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkehuguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlekehuguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkehuguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>运单管理</label>
						
						<div style="float:right ; margin-right: 30%">
							<label>
								<input type="checkbox" name="chakansuoyouyundanguanli" value="1"   <c:if test="${singleyundanguanli.chakansuoyou == '1' }">checked="checked"</c:if> />
								查看所有
							</label>
						</div>
						
						<c:if test="${singleyundanguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakanyundanguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleyundanguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="chakanyundanguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleyundanguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyundanguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleyundanguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyundanguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleyundanguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyundanguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleyundanguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyundanguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>运单审核</label>
						<c:if test="${singleyundanshenhe.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyundanshenhe" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleyundanshenhe.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyundanshenhe" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleyundanshenhe.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyundanshenhe" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleyundanshenhe.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyundanshenhe" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleyundanshenhe.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyundanshenhe" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleyundanshenhe.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyundanshenhe" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>财务管理</label>
						<c:if test="${singlecaiwuguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancaiwuguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlecaiwuguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakancaiwuguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlecaiwuguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucaiwuguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlecaiwuguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihucaiwuguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlecaiwuguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcaiwuguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlecaiwuguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengcaiwuguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>费用收取</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfeiyongshouqu" value="1"  <c:if test="${singlefeiyongshouqu.chakan == '1' }">checked="checked"</c:if> > 查看 </label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufeiyongshouqu"  value="1"  <c:if test="${singlefeiyongshouqu.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfeiyongshouqu" value="1"  <c:if test="${singlefeiyongshouqu.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>		
								
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>营收款管理</label>
						<c:if test="${singleyingshoukuanguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyingshoukuanguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleyingshoukuanguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanyingshoukuanguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleyingshoukuanguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyingshoukuanguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleyingshoukuanguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuyingshoukuanguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleyingshoukuanguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyingshoukuanguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleyingshoukuanguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengyingshoukuanguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票申请</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankaipiaoshenqing" value="1"  <c:if test="${singlekaipiaoshenqing.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukaipiaoshenqing" value="1"  <c:if test="${singlekaipiaoshenqing.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkaipiaoshenqing" value="1"  <c:if test="${singlekaipiaoshenqing.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票审核(分管负责人)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanfenguankaipiaoshenhe" value="1"  <c:if test="${singlefenguankaipiaoshenhe.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihufenguankaipiaoshenhe" value="1"  <c:if test="${singlefenguankaipiaoshenhe.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengfenguankaipiaoshenhe" value="1"  <c:if test="${singlefenguankaipiaoshenhe.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票审核(总经理)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzongjinglikaipiaoshenhe" value="1"  <c:if test="${singlezongjinglikaipiaoshenhe.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzongjinglikaipiaoshenhe" value="1"  <c:if test="${singlezongjinglikaipiaoshenhe.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzongjinglikaipiaoshenhe" value="1"  <c:if test="${singlezongjinglikaipiaoshenhe.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankaipiao" value="1"  <c:if test="${singlekaipiao.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukaipiao" value="1"  <c:if test="${singlekaipiao.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkaipiao" value="1"  <c:if test="${singlekaipiao.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>开票管理</label>
						<c:if test="${singlekaipiaoguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankaipiaoguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlekaipiaoguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakankaipiaoguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlekaipiaoguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukaipiaoguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlekaipiaoguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihukaipiaoguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlekaipiaoguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkaipiaoguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlekaipiaoguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengkaipiaoguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算申请</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiesuanshenqing" value="1"  <c:if test="${singlejiesuanshenqing.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiesuanshenqing" value="1"  <c:if test="${singlejiesuanshenqing.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiesuanshenqing" value="1"  <c:if test="${singlejiesuanshenqing.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算审核(总经理)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanzongjinglijiesuanshenhe" value="1"  <c:if test="${singlezongjinglijiesuanshenhe.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuzongjinglijiesuanshenhe" value="1"  <c:if test="${singlezongjinglijiesuanshenhe.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengzongjinglijiesuanshenhe" value="1"  <c:if test="${singlezongjinglijiesuanshenhe.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算审核(董事长)</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakandongshizhangjiesuanshenhe" value="1"  <c:if test="${singledongshizhangjiesuanshenhe.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihudongshizhangjiesuanshenhe" value="1"  <c:if test="${singledongshizhangjiesuanshenhe.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengdongshizhangjiesuanshenhe" value="1"  <c:if test="${singledongshizhangjiesuanshenhe.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算</label>
						<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiesuan" value="1"  <c:if test="${singlejiesuan.chakan == '1' }">checked="checked"</c:if> >查看</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiesuan" value="1"  <c:if test="${singlejiesuan.weihu == '1' }">checked="checked"</c:if> >维护</label></div>
						<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiesuan" value="1"  <c:if test="${singlejiesuan.xinzeng == '1' }">checked="checked"</c:if> >新增</label></div>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>结算单管理</label>
						<c:if test="${singlejiesuandanguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiesuandanguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singlejiesuandanguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanjiesuandanguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singlejiesuandanguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiesuandanguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singlejiesuandanguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihujiesuandanguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singlejiesuandanguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiesuandanguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singlejiesuandanguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengjiesuandanguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>危险品数据库</label>
						<c:if test="${singleweixianpin.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanweixianpin" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleweixianpin.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanweixianpin" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleweixianpin.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuweixianpin" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleweixianpin.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuweixianpin" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleweixianpin.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengweixianpin" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleweixianpin.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengweixianpin" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 85%; float: left; margin-left: 30px">
						<label>管理</label>
						<c:if test="${singleguanli.chakan == '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanguanli" value="1" checked="checked">查看</label></div>
						</c:if>
						<c:if test="${singleguanli.chakan != '1' }">
							<div style="float:right ; margin-right: 45%"><label><input type="checkbox" name="chakanguanli" value="1" >查看</label></div>
						</c:if>
						
						<c:if test="${singleguanli.weihu == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuguanli" value="1" checked="checked">维护</label></div>
						</c:if>
						<c:if test="${singleguanli.weihu != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="weihuguanli" value="1" >维护</label></div>
						</c:if>
						
						<c:if test="${singleguanli.xinzeng == '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengguanli" value="1" checked="checked">新增</label></div>
						</c:if>
						<c:if test="${singleguanli.xinzeng != '1' }">
							<div style="float:right ; margin-right: 10%"><label><input type="checkbox" name="xinzengguanli" value="1" >新增</label></div>
						</c:if>
						
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
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
