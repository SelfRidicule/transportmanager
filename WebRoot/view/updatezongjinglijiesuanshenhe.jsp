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
				<li class="active">结算审核(总经理)</li>
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
						<label>运输时间 : <span style="font-weight:normal;">${singleyundan.yunshushijian}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号 : <span style="font-weight:normal;">${singleyundan.chepaihao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>属地 : <span style="font-weight:normal;">${singlecheliang.chezhuxingming }</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>发货单位 : <span style="font-weight:normal;">${singleyundan.kehudanwei }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>货物名称 : <span style="font-weight:normal;">${singleyundan.huowumingcheng}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>实收吨位 : <span style="font-weight:normal;">${singleyundan.shishoudunwei }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>实发吨位 : <span style="font-weight:normal;">${singleyundan.shifadunwei}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>里程 : <span style="font-weight:normal;">${singleyundan.licheng }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>${singleyundan.baochouleixing}: <span style="font-weight:normal;">${singleyundan.baochoujine}</span></label>
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
						<label>带空桶 : <span style="font-weight:normal;">${singleyingshoukuan.daikongtong }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>营收 : <span style="font-weight:normal;">${singleyingshoukuan.yingshou}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>到账时间 : <span style="font-weight:normal;">${singleyingshoukuan.daozhangshijian }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>发票号 : <span style="font-weight:normal;">${singleyingshoukuan.fapiaohao}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>开票时间 : <span style="font-weight:normal;">${singleyingshoukuan.kaipiaoshijian }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>税金 : <span style="font-weight:normal;">${singleyingshoukuan.shuijin}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>管理费 : <span style="font-weight:normal;">${singleyingshoukuan.guanlifei }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>代垫费 : <span style="font-weight:normal;">${singleyundan.daidianfei}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>实付运费 : <span style="font-weight:normal;">${singleyingshoukuan.shifuyunfei }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>实收运费 : <span style="font-weight:normal;">${singleyundan.shishouyunfei}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>签收 : <span style="font-weight:normal;">${singleyingshoukuan.qianshou }</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>领款时间 : <span style="font-weight:normal;">${singleyingshoukuan.lingkuanshijian}</span></label>
					</div>	
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>开票状态 : <span style="font-weight:normal;">${singleyingshoukuan.yingshoukuanzhuangtai}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>结算状态 : <span style="font-weight:normal;">${singleyingshoukuan.jiesuanzhuangtai}</span></label>
					</div>	
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 60%; float: left; margin-left: 30px">
						<label>备注 : <span style="font-weight:normal;">${singleyundan.beizhu }</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>开票申请 : <span style="font-weight:normal;">${singleyingshoukuan.kaipiaoshenqing}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>开票申请人 : <span style="font-weight:normal;">${singleyingshoukuan.kaipiaoshenqingren}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>分管开票审核 : <span style="font-weight:normal;">${singleyingshoukuan.fenguankaipiaoshenhe}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>分管开票审核人 : <span style="font-weight:normal;">${singleyingshoukuan.fenguankaipiaoshenheren}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>总经理开票审核 : <span style="font-weight:normal;">${singleyingshoukuan.zongjinglikaipiaoshenhe}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>总经理开票审核人 : <span style="font-weight:normal;">${singleyingshoukuan.zongjinglikaipiaoshenheren}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>结算申请 : <span style="font-weight:normal;">${singleyingshoukuan.jiesuanshenqing}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>结算申请人 : <span style="font-weight:normal;">${singleyingshoukuan.jiesuanshenqingren}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>总经理结算审核 : <span style="font-weight:normal;">${singleyingshoukuan.zongjinglijiesuanshenhe}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>总经理结算审核人 : <span style="font-weight:normal;">${singleyingshoukuan.zongjinglijiesuanshenheren}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>董事长结算审核 : <span style="font-weight:normal;">${singleyingshoukuan.dongshizhangjiesuanshenhe}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>董事长结算审核人 : <span style="font-weight:normal;">${singleyingshoukuan.dongshizhangjiesuanshenheren}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<a href="${pageContext.request.contextPath}/jumpZongJingLiJieSuanShenHe"><button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
					<a href="${pageContext.request.contextPath}/updateZongJingLiJieSuanShenHe?flag=审核通过&id=${singleyingshoukuan.id}"><button type="button"  class="btn btn-primary" style="float: left; margin-left: 30px">审核通过</button></a>
					<a href="${pageContext.request.contextPath}/updateZongJingLiJieSuanShenHe?flag=未通过&id=${singleyingshoukuan.id}"><button type="button"  class="btn btn-danger" style="float: left; margin-left: 30px">未通过</button></a>
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
