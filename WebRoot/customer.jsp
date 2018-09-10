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
		
		function deletecustomer(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteCustomer";
		}
			
		function updatecustomer(){
			document.usersform.action="${pageContext.request.contextPath}"+"/updateCustomer";
		}	
		
		function addcustomer(){
			document.usersform.action="${pageContext.request.contextPath}"+"/addcustomer.jsp";
		}
		
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">客户管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchCustomer" method="post" onsubmit="">
						<div style="">
							<input class="form-control" placeholder="客户单位简称" name="shortname"   value="${customersearch.shortname}" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							<input class="form-control" placeholder="联系人" name="contactperson" value="${customersearch.contactperson}" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							<input class="form-control" placeholder="地址" name="contactaddress"  value="${customersearch.contactaddress}" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearcustomer" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '客户管理' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addcustomer()"    class="btn btn-warning" style="float: left ; margin-top: 10px ;">新增</button>
							</c:if>
				        </c:forEach>
				        
				        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '客户管理' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="deletecustomer()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">删除</button>
								<button type="submit" onclick="updatecustomer()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">修改</button><span style="color: red; margin-top: 15px; margin-left:80px ;float: left; font-size: 20px">${existcustomer}</span>
							</c:if>
				        </c:forEach>
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/customerJson"  data-id-field="customerid"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="customerid" data-sortable="true">编号</th>
						        <th data-field="shortname"  data-sortable="true">客户单位简称</th>
						        <th data-field="contactperson" data-sortable="true">联系人</th>
						        <th data-field="contactnumber" data-sortable="true">联系电话</th>
						        <th data-field="phonenumber" data-sortable="true">手机号码</th>
						        <th data-field="contactaddress" data-sortable="true">地址</th>
						        <th data-field="comment" data-sortable="true">客户备注</th>
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
		
			$("#clearcustomer").click(function(){
			
				$("input[name='shortname']").val("");
				$("input[name='contactperson']").val("");
				$("input[name='contactaddress']").val("");
				
			});
		
		});
	
	</script>
	
</body>

</html>
