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
		
		function addcongyezige(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpAddCongYeZiGe";
		}
			
		function deletecongyezige(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteCongYeZiGe";
		}	
		
		function updatecongyezige(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateCongYeZiGe";
		}
		
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">从业资格类别</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchCongYeZiGe" method="post" onsubmit="">
						<div style="">
							
							<input class="form-control" placeholder="请输入类别名称" name="leibiemingcheng"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="myclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '管理' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addcongyezige()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">添加</button>
							</c:if>
				        </c:forEach>
				        
				        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '管理' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="updatecongyezige()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">修改</button>
								<button type="submit" onclick="deletecongyezige()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">删除</button>
							</c:if>
				        </c:forEach>
						
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/congYeZiGeJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="id" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">序号</th>
						        <th data-field="leibiemingcheng"  data-sortable="true">类别名称</th>
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
			
			$("#myclear").click(function(){
				$("input[name=leibiemingcheng]").val("")  ;		
			});
		
		});
	
	</script>
	
</body>

</html>
