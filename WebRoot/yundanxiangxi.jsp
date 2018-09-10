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
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">运单详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>订单号 : <span style="font-weight:normal;">${singleyundan.dingdanhao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车牌号 : <span style="font-weight:normal;">${singleyundan.chepaihao}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>客户单位 : <span style="font-weight:normal;">${singleyundan.kehudanwei }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>运输时间: <span style="font-weight:normal;">${singleyundan.yunshushijian}</span></label>
					</div>							
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>起点 : <span style="font-weight:normal;">${singleyundan.qidian }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>终点 : <span style="font-weight:normal;">${singleyundan.zhongdian}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>电话 : <span style="font-weight:normal;">${singleyundan.dianhua }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>联系人: <span style="font-weight:normal;">${singleyundan.lianxiren}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>${singleyundan.baochouleixing}运费: <span style="font-weight:normal;">${singleyundan.baochoujine}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>${singleyundan.shishouleixing}实收运费: <span style="font-weight:normal;">${singleyundan.shishouyunfei}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>预计吨位: <span style="font-weight:normal;">${singleyundan.yujidunwei}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>货物名称: <span style="font-weight:normal;">${singleyundan.huowumingcheng}</span></label>
					</div>
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>安全卡 : <span style="font-weight:normal;">${singleyundan.anquanka}</span>
							<c:if test="${ ! empty singleweixianpin }">
								<a href="${singleweixianpin.anquanka}" target="_Blank" >下载</a>	
							</c:if>
						</label>
					</div>		
						
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>实发吨位: <span style="font-weight:normal;">${singleyundan.shifadunwei}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>实收吨位: <span style="font-weight:normal;">${singleyundan.shishoudunwei}</span></label>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>里程: <span style="font-weight:normal;">${singleyundan.licheng}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>代垫费: <span style="font-weight:normal;">${singleyundan.daidianfei}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>地址 : <span style="font-weight:normal;">${singleyundan.dizhi }</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="float: left; margin-left: 30px">
						<label>费用描述: <span style="font-weight:normal;">${singleyundan.feiyongmiaoshu}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="float: left; margin-left: 30px">
						<label>运单审核备注: <span style="font-weight:normal;">${singleyundan.beizhu}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="float: left; margin-left: 30px">
						<label>运单备注: <span style="font-weight:normal;">${singleyundan.yundanbeizhu}</span></label>
					</div>				
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<a href="${pageContext.request.contextPath}/jumpYunDan"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
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
