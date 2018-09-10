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
	
	
	<script type="text/javascript" src="laydate/laydate.js" ></script>
	<script type="text/javascript">
		var smalltime = {
		  format: 'YYYY-MM-DD hh:mm:ss',
		  istime: true,
		};
	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">修改车辆管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加车辆管理 -->
				
				<form name="myform" action="${pageContext.request.contextPath}/submitUpdateCheLiangGuanLi" onsubmit="" method="post">	
				
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>类别</label>
						<c:if test="${singlecheliangguanli.type == '1' }">
							<input class="form-control" value="车辆类型" readonly="readonly"/>
						</c:if>
						<c:if test="${singlecheliangguanli.type == '2' }">
							<input class="form-control" value="车辆品牌" readonly="readonly"/>
						</c:if>
						<c:if test="${singlecheliangguanli.type == '3' }">
							<input class="form-control" value="车辆型号" readonly="readonly"/>
						</c:if>
						<c:if test="${singlecheliangguanli.type == '5' }">
							<input class="form-control" value="车辆分组" readonly="readonly"/>
						</c:if>
						<c:if test="${singlecheliangguanli.type == '6' }">
							<input class="form-control" value="经营范围" readonly="readonly"/>
						</c:if>
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>原来名称<span id="leader" style="color: red;"></span></label>
						<input  class="form-control" value="${singlecheliangguanli.name}" readonly="readonly"/>
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>修改后的名称<span id="leader" style="color: red;"></span></label>
						<input name="name" class="form-control" placeholder="请输出名称" required="required"/>
					</div>					
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>实际类型</label>
						<select class="form-control" name="shijileixing">
								<option value="">请选择</option>
								<option value="单头车" <c:if test="${singlecheliangguanli.shijileixing == '单头车' }">selected="selected"</c:if> >单头车</option>
								<option value="挂车" <c:if test="${singlecheliangguanli.shijileixing == '挂车' }">selected="selected"</c:if> >挂车</option>
								<option value="牵引车" <c:if test="${singlecheliangguanli.shijileixing == '牵引车' }">selected="selected"</c:if> >牵引车</option>
						</select>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/manager/cheliangguanli/cheliangguanli.jsp"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>
				
				<!-- end -->
					
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
	
	<script>
		
	</script>	
</body>

</html>