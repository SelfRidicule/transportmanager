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
	
	<script type="text/javascript">
		
		function update(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateFeiYongShouQu";
		}
		
		function dele(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteFeiYongShouQu";
		}
		
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">费用收取</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchFeiYongShouQu" method="post" onsubmit="" >
						<div style="">

							<input class="form-control" placeholder="车辆合作人" name="chelianghezuoren"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="myclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					<div class="panel-body">
						
						<button type="submit" onclick="update()" class="btn btn-warning" style="float: left ; margin-top: 10px; margin-left: 10px">修改</button>
				        
				        <button type="submit" onclick="dele()" class="btn btn-danger" style="float: left ; margin-top: 10px; margin-left: 10px">删除</button>
				        
						<div style="float: left ; margin-top: 10px; margin-left: 10px;color: red;line-height:30px;font-size: 16px">${yingshoukuanerr}</div>
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/feiYongShouQuJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="chelianghezuoren" data-sortable="true">车辆合作人</th>
						        <th data-field="gouchefei" data-sortable="true">够车费</th>
						        <th data-field="luntaifei" data-sortable="true">轮胎费</th>
						        <th data-field="weixiufei" data-sortable="true">维修费</th>
						        <th data-field="jiayoufei" data-sortable="true">加油费</th>
						        <th data-field="qitafeiyong" data-sortable="true">其他费用</th>
						        <th data-field="kaipiaoheji" data-sortable="true">开票合计</th>
						        <th data-field="bili" data-sortable="true"  data-visible="true">比例</th>
						        <th data-field="baoxianfei" data-sortable="true"  data-visible="true">保险费</th>
						        <th data-field="chezaihefuwufeiyong" data-sortable="true"  data-visible="true">车载和服务费用</th>
						        <th data-field="anquanxuexibaozhengjin" data-sortable="true"  data-visible="true">安全学习保证金</th>
						        <th data-field="guanlifeiyong" data-sortable="true"  data-visible="true">管理费用</th>
						        <th data-field="yujiaobaoxianfeiyong" data-sortable="true"  data-visible="true">预交保险费用</th>
						        <th data-field="jiashiyuanbaoxian" data-sortable="true"  data-visible="true">驾驶员保险</th>
						        <th data-field="heji" data-sortable="true"  data-visible="true">合计</th>
						    </tr>
						    </thead>
						</table>
					</div>
					</form>
					<!-- 查询 修改 表单 !-->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script src="js/spin.min.js"></script>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>

	<script type="text/javascript">
		
		$(function(){
		
			$("#myclear").click(function(){
				$("input[name='chepaihao']").val("");
				$("input[name='banlizhuangtai']").val("");
				$("option").removeAttr("selected");
			});
			
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
		    });
		    
		});
	
	</script>
	
</body>

</html>
