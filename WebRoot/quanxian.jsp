<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		function addquanxian(){
			document.usersform.action="${pageContext.request.contextPath}"+"/addquanxian.jsp";
		}
		
		function deletequanxian(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteQuanXian";
		}

		function jumpupdatequanxian(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateQuanXian";
		}

	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">权限管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchQuanXian" method="post" onsubmit="">
						<div style="">
							
							<input class="form-control" placeholder="权限名称" name="quanxianmingcheng" value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="myclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '权限设置' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addquanxian()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">添加</button>
							</c:if>
				        </c:forEach>
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '权限设置' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="jumpupdatequanxian()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">修改</button>
								<button type="submit" onclick="deletequanxian()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">删除</button>
							</c:if>
				        </c:forEach>
				        
						<div style="float: left ; margin-top: 10px; margin-left: 10px;color: red;line-height:30px;font-size: 16px">${quanxianerr}</div>
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/quanXianJson"  data-id-field="quanxianmingcheng"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="quanxianmingcheng" data-sortable="true">权限名称</th>
						        <th data-field="yonghu" data-sortable="true">用户</th>
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
			
				$("input[name='chaxunxiaoyudaoqiriqi']").val("");
				$("input[name='chaxundayudaoqiriqi']").val("");
				$("option").removeAttr("selected");		
			});
			
		});
	
	</script>
	
</body>

</html>
