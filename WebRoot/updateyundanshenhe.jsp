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
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">运单审核</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>订单号 : <span style="font-weight:normal;">${singleyundanshenhe.dingdanhao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车牌号 : <span style="font-weight:normal;">${singleyundanshenhe.chepaihao}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>客户单位 : <span style="font-weight:normal;">${singleyundanshenhe.kehudanwei }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>运输时间: <span style="font-weight:normal;">${singleyundanshenhe.yunshushijian}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>起点 : <span style="font-weight:normal;">${singleyundanshenhe.qidian }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>终点 : <span style="font-weight:normal;">${singleyundanshenhe.zhongdian}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>地址 : <span style="font-weight:normal;">${singleyundanshenhe.dizhi }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>联系人: <span style="font-weight:normal;">${singleyundanshenhe.lianxiren}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>${singleyundanshenhe.baochouleixing}运费: <span style="font-weight:normal;">${singleyundanshenhe.baochoujine}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>${singleyundanshenhe.shishouleixing}实收运费: <span style="font-weight:normal;">${singleyundanshenhe.shishouyunfei}</span></label>
					</div>							
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>预计吨位: <span style="font-weight:normal;">${singleyundanshenhe.yujidunwei}</span></label>
					</div>		
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>安全卡 : <span style="font-weight:normal;">${singleyundanshenhe.anquanka}</span></label>
					</div>				
						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶员姓名: <span style="font-weight:normal;">${jiashiyuanxingming}</span></label>
					</div>			
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>货物名称: <span style="font-weight:normal;">${singleyundanshenhe.huowumingcheng}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="float: left; margin-left: 30px; width: 70%; ">
						<label>备注: <span style="font-weight:normal;">${singleyundanshenhe.beizhu}</span></label>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 70%; float: left; margin-left: 30px">
						<label>运单备注: <span style="font-weight:normal;">${singleyundanshenhe.yundanbeizhu}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
				<form name="usersform" action="" onsubmit="" method="post">
					<div class="form-group" style="float: left; margin-left: 30px ; width: 60%">
						<label>原因</label>
						<textarea class="form-control" rows="5" name="beizhu"></textarea>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<a href="${pageContext.request.contextPath}/jumpYunDanShenHe"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					<button type="submit" onclick="shenhetongguo()" class="btn btn-info" style="float: left; margin-left: 10px">审核通过</button>
					<button type="submit" onclick="shenhebutongguo()" class="btn btn-danger" style="float: left; margin-left: 10px">未通过</button>
					
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
		function shenhetongguo(){
			document.usersform.action="${pageContext.request.contextPath}"+"/submitUpdateYunDanShenHe?yundanzhuangtai=待接单";
		}
		
		function shenhebutongguo(){
			document.usersform.action="${pageContext.request.contextPath}"+"/submitUpdateYunDanShenHe?yundanzhuangtai=未通过";
		}
	</script>	
</body>

</html>
