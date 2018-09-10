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
	
	<script type="text/javascript">
		
		function addweixianpin(){
			document.usersform.action="${pageContext.request.contextPath}"+"/addweixianpin.jsp";
		}
		
		function deleteweixianpin(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteWeiXianPin";
		}

	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">危险品管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchWeiXianPin" method="post" onsubmit="">
						<div style="">
							<input class="form-control" placeholder="货物名称" name="huowumingcheng"   value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="weixianpinclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '危险品数据库' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addweixianpin()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">添加</button>
							</c:if>
				        </c:forEach>
				        
				        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '危险品数据库' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="deleteweixianpin()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">删除</button>
							</c:if>
				        </c:forEach>
						
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/weiXianPinJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="huowumingcheng" data-sortable="true">货物名称</th>
						        <th data-field="anquanka" data-sortable="true">安全卡</th>
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
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>

	<script type="text/javascript">
	
		$(function(){
		
			$("#weixianpinclear").click(function(){
				$("input[name='huowumingcheng']").val("");
				$("option").removeAttr("selected");
			});
		
		});
	
	</script>
	
</body>

</html>
