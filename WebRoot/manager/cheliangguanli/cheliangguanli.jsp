<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/datepicker3.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	
	<script type="text/javascript">
		
		function addcheliangguanli(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpAddCheLianGuanLi";
		}
			
		function deletecheliangguanli(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteCheLiangGuanLi";
		}	
		
		function updatecheliangguanli(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateCheLiangGuanLi";
		}
		
		
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">车辆管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchCheLiangGuanLi" method="post" onsubmit="">
						<div style="">
							
							<select class="form-control" name="type" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">全部</option>
								<option value="1">车辆类型</option>
								<option value="2">车辆品牌</option>
								<option value="3">车辆型号</option>
								<option value="5">车辆分组</option>
							</select>
							
							<input class="form-control" placeholder="名称" name="name"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '管理' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addcheliangguanli()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">添加</button>
							</c:if>
				        </c:forEach>
				        
				        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '管理' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="updatecheliangguanli()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">修改</button>
								<button type="submit" onclick="deletecheliangguanli()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">删除</button>
							</c:if>
				        </c:forEach>
						
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/CheLiangGuanLiJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="id" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">id</th>
						        <th data-field="type"  data-sortable="true">类型</th>
						        <th data-field="name"  data-sortable="true">名称</th>
						        <th data-field="shijileixing"  data-sortable="true">实际类型</th>
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

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart-data.js"></script>
	<script src="${pageContext.request.contextPath}/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/js/easypiechart-data.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>

	<script type="text/javascript">
	
		$(function(){
		
			$("#sss").click(function(){
			
				$("input[name='shortname']").val("");
				$("input[name='contactperson']").val("");
				$("input[name='contactaddress']").val("");
				
			});
		
		});
	
	</script>
	
</body>

</html>
