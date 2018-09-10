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
	
	<title>结算单详细</title>
	
	<script type="text/javascript">
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">结算单详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>订单号 : <span style="font-weight:normal;">${singlejiesuandan.dingdanhao}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车牌号 : <span style="font-weight:normal;">${singlejiesuandan.chepaihao}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车主姓名 : <span style="font-weight:normal;">${singlejiesuandan.chezhuxingming}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>客户单位 : <span style="font-weight:normal;">${singlejiesuandan.kehudanwei}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>起点 : <span style="font-weight:normal;">${singlejiesuandan.qidian}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>终点 : <span style="font-weight:normal;">${singlejiesuandan.zhongdian}</span></label>
					</div>				
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>电话 : <span style="font-weight:normal;">${singlejiesuandan.dianhua}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>联系人 : <span style="font-weight:normal;">${singlejiesuandan.lianxiren}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>带空桶 : <span style="font-weight:normal;">${singlejiesuandan.daikongtong}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>发票号 : <span style="font-weight:normal;">${singlejiesuandan.fapiaohao}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>营收 : <span style="font-weight:normal;">${singlejiesuandan.yingshou}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>税金 : <span style="font-weight:normal;">${singlejiesuandan.shuijin}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>到账时间 : <span style="font-weight:normal;">${singlejiesuandan.daozhangshijian}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>开票时间 : <span style="font-weight:normal;">${singlejiesuandan.kaipiaoshijian}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>管理费 : <span style="font-weight:normal;">${singlejiesuandan.guanlifei}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>实付运费 : <span style="font-weight:normal;">${singlejiesuandan.shifuyunfei}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>领款时间 : <span style="font-weight:normal;">${singlejiesuandan.lingkuanshijian}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>运输时间 : <span style="font-weight:normal;">${singlejiesuandan.yunshushijian}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>签收 : <span style="font-weight:normal;">${singlejiesuandan.qianshou}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>代垫费 : <span style="font-weight:normal;">${singlejiesuandan.daidianfei}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>里程 : <span style="font-weight:normal;">${singlejiesuandan.licheng}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>${singlejiesuandan.baochouleixing} : <span style="font-weight:normal;">${singlejiesuandan.baochoujine}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>实收吨位 : <span style="font-weight:normal;">${singlejiesuandan.shishoudunwei}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>实发吨位 : <span style="font-weight:normal;">${singlejiesuandan.shifadunwei}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>预计吨位 : <span style="font-weight:normal;">${singlejiesuandan.yujidunwei}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>地址 : <span style="font-weight:normal;">${singlejiesuandan.dizhi}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>安全卡 : <span style="font-weight:normal;">${singlejiesuandan.anquanka}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>货物名称 : <span style="font-weight:normal;">${singlejiesuandan.huowumingcheng}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>费用描述 : <span style="font-weight:normal;">${singlejiesuandan.feiyongmiaoshu}</span></label>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					
					<a href="${pageContext.request.contextPath}/jiesuandan.jsp"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
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
