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
		
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">车管业务</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchGouZhiShui" method="post" onsubmit="">
						<div style="">

							<input class="form-control" placeholder="编号" name="bianhao"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
						
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="chepaihao" class="show-tick form-control">
							        <option value="">车牌号</option>
							        <c:forEach items="${myxinchelist}" var="myxinche">
										<option value="${myxinche.chepaihao}">${myxinche.chepaihao}</option>
							        </c:forEach>
								</select>
							</div>
							
							<select class="form-control" name="banlizhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="未办理">未办理</option>
								<option value="已办理">已办理</option>
								<option value="">办理状态</option>
							</select>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="myclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/gouZhiShuiJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="bianhao" data-sortable="true">编号</th>
						       <!--  <th data-field="chepaihao"  data-sortable="true">车牌号码</th> -->
						        <th data-field="banliriqi" data-sortable="true">办理日期</th>
						        <th data-field="caozuoyuan" data-sortable="true">操作员</th>
						        <th data-field="caozuo" data-sortable="true">操作</th>
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
				$("input[name='bianhao']").val("");
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
