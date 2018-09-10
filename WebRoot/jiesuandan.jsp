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
	<link href="${pageContext.request.contextPath}/css/jedate.css" rel="stylesheet">
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="${pageContext.request.contextPath}/js/jedate.js"></script>
	
	<script type="text/javascript">
		
		$(function(){
		
			$("#riqi1,#riqi2,#riqi3,#riqi4,#riqi5,#riqi6,#riqi7,#riqi8,#riqi9").jeDate({
			    ishmsVal:false,
			    minDate: '1200-12-12',
				
			    format:"YYYY-MM-DD",
			    zIndex:3000,
			});
		
		});
		
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">结算单查询</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchJieSuanDan" method="post" onsubmit="">
						<div style="">

							<input class="form-control" placeholder="订单号" name="dingdanhao"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">

							<input class="form-control" placeholder="承运人" name="chezhuxingming"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input class="form-control" placeholder="货物名称" name="huowumingcheng"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="myclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							
							<div style="clear: both;"></div>
							
							<input id="riqi1" class="form-control"    placeholder="查询小于领款时间" name="chaxunxiaoyulingkuanshijian"    style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							
							<input id="riqi2" class="form-control"    placeholder="查询大于领款时间" name="chaxundayulingkuanshijian"   style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							
							<input class="form-control" placeholder="客户单位" name="kehudanwei"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<div style="clear: both;"></div>							
						</div>
					
					<!-- 水平线 -->
					<div class="panel-body">
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/jieSuanDanJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						   		<!-- <th data-field="id" data-sortable="true">编号</th> -->
						   		<th data-field="dingdanhao" data-sortable="true">订单号</th>
						        <th data-field="chezhuxingming" data-sortable="true">承运人</th>
						        <th data-field="huowumingcheng" data-sortable="true">货物名称</th>
						        <th data-field="lingkuanshijian" data-sortable="true">领款时间</th>
						        <th data-field="kehudanwei" data-sortable="true">客户单位</th>
						        <!-- <th data-field="xiangxi" data-sortable="true">详细</th> -->
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

	
	<script type="text/javascript">
	
		$(function(){
		
			$("#myclear").click(function(){
				$("input[name='dingdanhao']").val("");
				$("input[name='chezhuxingming']").val("");
				$("input[name='huowumingcheng']").val("");
				$("input[name='chaxunxiaoyulingkuanshijian']").val("");
				$("input[name='chaxundayulingkuanshijian']").val("");
				$("input[name='kehudanwei']").val("");
				$("option").removeAttr("selected");
			});
			
		});
	
	</script>
	
</body>

</html>
