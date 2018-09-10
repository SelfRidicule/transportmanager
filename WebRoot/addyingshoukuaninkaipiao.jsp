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
				<li class="active">开票</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: white;">
				
				<!-- start -->
				<br/>
				<!-- 添加车辆 -->
				<form id="myform" name="myform" action="${pageContext.request.contextPath}/submitYingShouKuanInkaiPiao" onsubmit="" method="post">	
					<div style=" text-align:center; margin:0 auto; margin-top: 15px">
						<span style="font-size: 18px;font-weight: bold;">淮安交运危货运输有限公司</span>
						<button type="button" class="print-link no-print" style="float: left; margin-left: 30px" onclick="jQuery('#myform').print()">打印</button>
					</div>
					
					<div style=" text-align:center; margin:0 auto; margin-top: 5px">
						<span style="font-size: 18px;">营运开票分账表</span>
						<!-- <button type="button" class="print-link no-print" style="float: left; margin-left: 30px" onclick="jQuery.print()">打印</button> -->
					</div>
						
					<table border="" cellspacing="" cellpadding="" width="90%" style="border-collapse: collapse; border-color: black; margin-left: 5%">
						<tr>
						  <td width="25%" height="40" align="center"  >客户单位</td>
						  <td width="25%" align="center"  >${singlecustomer.kehudanwei}</td>
						  <td width="25%" align="center"  >开票时间</td>
						  <td width="25%" align="center"  >${kaipiaoshijian}</td>
					    </tr>
						<tr>
						  <td width="25%" height="40" align="center"  >开票单位</td>
						  <td width="25%" align="center"  >${singlecustomer.kehudanwei}</td>
						  <td width="25%" align="center"  >纳税人识别号</td>
						  <td width="25%" align="center"  >${singlecustomer.identifynumber}</td>
				      </tr>
						<tr>
						  <td width="25%" height="40" align="center"  >地址</td>
						  <td width="25%" align="center"  >${singlecustomer.contactaddress}</td>
						  <td width="25%" align="center"  >电话</td>
						  <td width="25%" align="center"  >${singlecustomer.contactnumber}</td>
				      </tr>
					   <tr>
						  <td width="25%" height="40" align="center"  >开户行</td>
						  <td width="25%" align="center"  >${singlecustomer.bankaccount}</td>
						  <td width="25%" align="center"  >账号</td>
						  <td width="25%" align="center"  >${singlecustomer.account}</td>
				      </tr>
					</table>
			        
			        <br/>
			        
			        <table border="" cellspacing="" cellpadding="" width="90%" style="border-collapse: collapse; border-color: black;  margin-left: 5%;">
						 <tr>
						  <td width="10%" height="35" align="center"  >序号</td>
						  <td width="10%" align="center"  >承运人</td>
						  <td width="10%" align="center"  >开票金额</td>
						  <td width="10%" align="center"  >税金</td>
						  <td width="10%" align="center"  >管理费</td>
						  <td width="10%" align="center"  >实付运费</td>
						  <td width="10%" align="center"  >代垫费</td>
						  <td width="10%" align="center"  >租车费</td>
						  <td width="10%" align="center"  >业务费</td>
						  <td width="10%" align="center"  >备注</td>
				      </tr>
					  
					  <c:forEach items="${yingshoukuaninkaipiaolist}" var="yingshoukuaninkaipiao">
			         	 <tr>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.xuhao}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.chengyunren}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.kaipiaojine}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.shuijin}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.guanlifei}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.shifuyunfei}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.daidianfei}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.zuchefei}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.yewufei}</td>
						   <td height="35" align="center"  >${yingshoukuaninkaipiao.beizhu}</td>
			         	 </tr>
			          </c:forEach>
						
					  <tr>
						   <td height="35" align="center"  colspan="2" style="font-weight:bold;">总计：</td>
						   <td height="35" align="center"  style="font-weight:bold;">${sumkaipiaojine}</td>
						   <td height="35" align="center"  style="font-weight:bold;">${sumshuijin}</td>
						   <td height="35" align="center"  style="font-weight:bold;">${sumguanlifei}</td>
						   <td height="35" align="center"  style="font-weight:bold;">${sumshifuyunfei}</td>
						   <td height="35" align="center"  style="font-weight:bold;">${sumdaidianfei}</td>
						   <td height="35" align="center"  style="font-weight:bold;">${sumzuchefei}</td>
						   <td height="35" align="center"  style="font-weight:bold;">${sumyewufei}</td>
						   <td height="35" align="center"  style="font-weight:bold;"></td>
			          </tr>
						
					</table>					
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					<div align="center" style="width: 100%;">
							制表人：${users.username} &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
							分管经理：&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
						 	总经理：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					
				</form>	
					<button type="button" class="btn btn-primary" onclick="submitform()" style="float: left; margin-left: 41%">开票</button>
					<a href="${pageContext.request.contextPath}/jumpYingShouKuanKaiPiao"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/jQuery.print.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	
	<script>
		
		function submitform(){
			document.getElementById("myform").submit();
		}
		
	</script>	
</body>

</html>
