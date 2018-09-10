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
	
	<title>添加客户</title>
	
	<script type="text/javascript">
			
		var myleng = 0 ;
		
		// 判断电话长度
		function dianhualeng(){
		
			var dianhua = document.getElementsByName("phonenumber")[0] ;
			
			var value = dianhua.value ;
			
			if(value.length != 11){
				dianhua.style.borderColor = 'red';
           		document.getElementById("dianhuatishi").style.display = 'inline';
           		
           		myleng = 0;	
			}
			
			
			if(value.length == 11){
				dianhua.style.borderColor = 'green';
           		document.getElementById("dianhuatishi").style.display = 'none';
           		
           		myleng = 1;
			}
		}
		
		//判断是否提交
		function test(){
			
			if(myleng != 1){
				return false ;
			}
				
		}
	
	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">添加客户</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加用户 -->
				<form name="myform" action="${pageContext.request.contextPath}/addCustomer" onsubmit="" method="post">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>客户全称 <span style="color: red;  padding-top: 10px">*</span></label>
						<input name="customername" class="form-control" placeholder="请输入客户全称" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>客户单位简称<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="shortname" class="form-control" placeholder="请输入客户单位简称" required="required"/>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>联系地址<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="contactaddress" class="form-control" placeholder="请输入联系地址" required="required"/>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>客户单位<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="kehudanwei" class="form-control" placeholder="请输入客户单位" required="required"/>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>纳税人识别号<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="identifynumber" class="form-control" placeholder="请输入纳税人识别号" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>开户行<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="bankaccount" class="form-control" placeholder="请输入开户行" required="required"/>
					</div>	
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>帐号<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="account" class="form-control" placeholder="请输入帐号" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>联系人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="contactperson" class="form-control" placeholder="请输入联系人" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>联系电话<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="contactnumber" class="form-control" placeholder="请输入联系电话" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>手机号码<span style="color: red;  padding-top: 10px">*&nbsp;</span><span id="dianhuatishi" style="display: none; color: red;">格式不规范</span> </label>
						<input name="phonenumber" class="form-control"  placeholder="请输入手机号码" required="required"/>
					</div>		
					
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 80%; float: left; margin-left: 30px">
						<label>客户备注<span id="comment" style="color: red;"></span></label>
						<textarea class="form-control" rows="5" name="comment"></textarea>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">添加</button>
					<a href="${pageContext.request.contextPath}/customer.jsp"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
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
	
	<script>
		
	</script>	
</body>

</html>
