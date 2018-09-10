<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<script type="text/javascript">
		
		function deleteusers(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteUsers";
		}
			
		function updateusers(){
			document.usersform.action="${pageContext.request.contextPath}"+"/updateUsers";
		}	
		
		function addusers(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpAddUsers";
		}
		
	</script>
	

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">用户管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/usersVagueSearch" method="post" onsubmit="">
						<div style="">
							<input class="form-control" placeholder="帐号" name="account" value="${userssearchmodel.account}" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							<select class="form-control" 				   name="deptid" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
												<option value="">全部</option>
												<c:forEach items="${deptlist}" var="dept">
													<c:if test="${userssearchmodel.deptid == dept.deptid }">
														<option selected="selected" value="${dept.deptid}">${dept.deptname}</option>
													</c:if>
													<c:if test="${userssearchmodel.deptid != dept.deptid }">
														<option  value="${dept.deptid}">${dept.deptname}</option>
													</c:if>
												</c:forEach>
							</select>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-top: 15px; margin-left: 10px ;width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearusers" style="float: left; margin-top: 15px; margin-left: 10px ;width: 70px;" value="清空"/>
							
							<div style="clear: both;"></div>	<br />					
							<input class="form-control" placeholder="邮箱" name="email" value="${userssearchmodel.email}" style="width: 200px; margin-left: 10px; margin-top: -10px; float: left;">
							<select class="form-control" 				   name="quanxianmingcheng" style="width: 200px; margin-left: 10px; margin-top: -10px; float: left;">
								<option value="">所有权限</option>
								<c:forEach items="${quanxianmingchenglist}" var="quanxianmingcheng">
									<c:if test="${userssearchmodel.quanxianmingcheng == quanxianmingcheng }">
										<option value="${quanxianmingcheng}" selected="selected">${quanxianmingcheng}</option>
									</c:if>
									<c:if test="${userssearchmodel.quanxianmingcheng != quanxianmingcheng }">
										<option value="${quanxianmingcheng}">${quanxianmingcheng}</option>
									</c:if>
						        </c:forEach>
							</select>
							
							<div style="clear: both;"></div>
						</div>
					
					<!-- 水平线 -->
					<!-- <div style="background-color: #67B168; width: 100%; height: 1px;"></div> -->
					
					<div class="panel-body">
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '用户管理' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addusers()"    class="btn btn-warning" style="float: left ; margin-top: 10px ;">新增</button>
							</c:if>
				        </c:forEach>
				        
				        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '用户管理' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="deleteusers()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">删除</button>
								<button type="submit" onclick="updateusers()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">修改</button>
							</c:if>
				        </c:forEach>
						
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/usersJson"  data-id-field="usersid"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="usersid" data-sortable="true">编号</th>
						        <th data-field="account"  data-sortable="true">帐号</th>
						        <th data-field="username" data-sortable="true">姓名</th>
						        <th data-field="password" data-sortable="true">密码</th>
						        <th data-field="sex" data-sortable="true">性别</th>
						        <th data-field="email" data-sortable="true">邮箱</th>
						        <th data-field="quanxianmingcheng" data-sortable="true">权限</th>
						        <th data-field="deptname" data-sortable="true">部门/科室</th>
						        <th data-field="comment" data-sortable="true">用户备注</th>
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
		
			$("#clearusers").click(function(){
				$("option").removeAttr("selected");
				$("input[name='account']").val("");
				$("input[name='email']").val("");
			});
		
		});
		
	</script>
	
</body>

</html>
