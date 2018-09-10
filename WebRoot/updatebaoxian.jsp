<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/jedate.css" rel="stylesheet">
	
	<title>修改保险</title>
	
	
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">修改保险</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加保险 -->
				<form name="myform" action="${pageContext.request.contextPath}/submitUpdateBaoXian" onsubmit="" method="post">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号 <span style="color: red;">*</span> </label>
						<input name="chepaihao" value="${singlebaoxian.chepaihao}" class="form-control" placeholder="请输入车牌号" readonly="readonly"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>保险类型 <span style="color: red;">*</span> </label>
						<input name="baoxianleixing" value="${singlebaoxian.baoxianleixing}" class="form-control" placeholder="请输入保险类型" readonly="readonly"/>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>保险公司</label>
						<input name="baoxiangongsi" value="${singlebaoxian.baoxiangongsi}" class="form-control" placeholder="请输入保险公司" />
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>保险费用</label>
						<input name="toubaojine" value="${singlebaoxian.toubaojine}" class="form-control" placeholder="请输入保险费用" />
					</div>	
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>到期日期 <span style="color: red;">*</span> </label>
						<input id="riqi2" name="daoqiriqi" value="<fmt:formatDate value="${singlebaoxian.daoqiriqi}" pattern="yyyy-MM-dd"/>"   class="form-control" placeholder="请输入到期日期" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>保单号 <span style="color: red;">*</span> </label>
						<input name="baodanhao" value="${singlebaoxian.baodanhao}" class="form-control" placeholder="请输入保单号" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>保险金额</label>
						<input name="baoxianzhonglei" value="${singlebaoxian.baoxianzhonglei}" class="form-control" placeholder="请输入保险金额" />
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>办理日期 </label>
						<input id="riqi1" name="banliriqi" value="<fmt:formatDate value="${singlebaoxian.banliriqi}" pattern="yyyy-MM-dd"/>"  class="form-control" placeholder="请输入办理日期" />
					</div>		
					
					<!-- 清楚浮动 -->
					<%-- <div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>联系人</label>
						<input name="lianxiren" value="${singlebaoxian.lianxiren}" class="form-control" placeholder="请输入联系人" />
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>联系电话</label>
						<input name="lianxidianhua" value="${singlebaoxian.lianxidianhua}" class="form-control" placeholder="请输入联系电话" />
					</div> --%>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>保险代理公司</label>
						<input name="baoxiandailigongsi" value="${singlebaoxian.baoxiandailigongsi}" class="form-control" placeholder="请输入保险代理公司" />
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>代理费</label>
						<input name="baofei" value="${singlebaoxian.baofei}" class="form-control" placeholder="请输入代理费" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/jumpBaoXian"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>	
				<!-- end -->
					
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
	<script src="${pageContext.request.contextPath}/js/jedate.js"></script>
	
	<script type="text/javascript">
			
		$(function(){
		
			$("#riqi1,#riqi2").jeDate({
			    ishmsVal:false,
			    minDate: '1200-12-12',
				
			    format:"YYYY-MM-DD",
			    zIndex:3000,
			});
		
		});	
			
	</script>	
</body>

</html>
