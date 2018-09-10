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
				<li class="active">工作门户</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7; padding-top: 15px" >
				
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '新车入户' && usersquanxian.chakan == '1' }">	
					
						<div style="width: 60%; float: left; margin-left: 1%; ">
							<span style="font-size: 16px;font-weight: bold;">新车入户</span>
							<div style="clear: both;"></div>
							<img alt="" src="${pageContext.request.contextPath}/manager/qiche.jpg" usemap="#Map" style="float: left;">
							<map name="Map" id="Map">
							  <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '投入审核和申请' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="27,10,126,96"    href="${pageContext.request.contextPath}/jumpTouRuShenHe" alt="投入审核和申请"/>
									</c:if>
						      </c:forEach>
						      <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '车管业务' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="183,9,270,99"    href="${pageContext.request.contextPath}/jumpGouZhiShui" alt="车管业务"/>
									</c:if>
						      </c:forEach>
						      <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '运管业务' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="339,10,422,95"   href="${pageContext.request.contextPath}/jumpYingYunZheng" alt="运管业务"/>
									</c:if>
						      </c:forEach>
						      <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '保险出单' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="494,7,570,95"    href="${pageContext.request.contextPath}/jumpBaoXianChuDan" alt="保险出单"/>
									</c:if>
						      </c:forEach>
						      <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '材料整理档案建立' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="475,137,590,224" href="${pageContext.request.contextPath}/jumpCaiLiaoZhengLi" alt="材料整理档案建立"/>
									</c:if>
						      </c:forEach>
						       <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '费用结算' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="336,136,418,225" href="${pageContext.request.contextPath}/jumpFeiYongJieSuan" alt="费用结算"/>
									</c:if>
						      </c:forEach>
						      <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '责任人签字' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="189,139,268,224" href="${pageContext.request.contextPath}/jumpZeRenRen" alt="责任人签字"/>
									</c:if>
						      </c:forEach>
						      <c:forEach items="${usersquanxianlist}" var="usersquanxian">
									<c:if test="${usersquanxian.quanxianbumen == '分管领导意见' && usersquanxian.chakan == '1' }">
									  <area shape="rect" coords="28,138,126,223"  href="${pageContext.request.contextPath}/jumpFenGuanLingDao" alt="分管领导意见"/>
									</c:if>
						      </c:forEach>
							</map>
						</div>
						
						<!-- 显示还有几条数据 -->
						<c:if test="${ tourushenhejindu != '0' }">
							<div style="position: absolute; margin-left: 120px; margin-top: 20px; color: red;font-size: 16px;">${tourushenhejindu}</div>
						</c:if>
						
						<c:if test="${ cheguanyewujindu != '0' }">
							<div style="position: absolute; margin-left: 270px; margin-top: 20px; color: red;font-size: 16px;">${cheguanyewujindu}</div>
						</c:if>
						
						<c:if test="${ yunguanyewujindu != '0' }">
							<div style="position: absolute; margin-left: 420px; margin-top: 20px; color: red;font-size: 16px;">${yunguanyewujindu}</div>
						</c:if>
						
						<c:if test="${ baoxianchudanjindu != '0' }">
							<div style="position: absolute; margin-left: 570px; margin-top: 20px; color: red;font-size: 16px;">${baoxianchudanjindu}</div>
						</c:if>
						
						<c:if test="${ fenguanlingdaojindu != '0' }">
							<div style="position: absolute; margin-left: 120px; margin-top: 150px; color: red;font-size: 16px;">${fenguanlingdaojindu}</div>
						</c:if>
						
						<c:if test="${ zerenrenqianzijindu != '0' }">
							<div style="position: absolute; margin-left: 270px; margin-top: 150px; color: red;font-size: 16px;">${zerenrenqianzijindu}</div>
						</c:if>
						
						<c:if test="${ feiyongjiesuanjindu != '0' }">
							<div style="position: absolute; margin-left: 420px; margin-top: 150px; color: red;font-size: 16px;">${feiyongjiesuanjindu}</div>
						</c:if>
						
						<c:if test="${ cailiaozhenglijindu != '0' }">
							<div style="position: absolute; margin-left: 570px; margin-top: 150px; color: red;font-size: 16px;">${cailiaozhenglijindu}</div>
						</c:if>
						
					</c:if>
	        	</c:forEach>
					
					
					
					<%-- <c:if test="${singlegerenguanli.zhengjianguanli == '1' }">		
						<!-- 证件管理 -->
						<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
							<table data-toggle="table" data-url="${pageContext.request.contextPath}/zhengJianMenHuJson"  >
							    <span style="font-size: 16px;font-weight: bold;">证件管理</span>
							    <thead>
							    <tr>
							        <th data-field="chepaihao" data-sortable="true">车牌号</th>
							        <th data-field="zhengjianleixing" data-sortable="true">证件类型</th>
							        <th data-field="daoqiriqi" data-sortable="true">到期日期</th>
							    </tr>
							    </thead>
							</table>
						</div>
					</c:if>	 --%>	
						
					 <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '运单管理' && usersquanxian.chakan == '1' }">
						<!-- 当前运单 -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table  data-toggle="table" data-url="${pageContext.request.contextPath}/yunDanMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">当前运单</span>
								    <thead>
								    <tr>
								        <th data-field="dingdanhao" data-sortable="true">订单号</th>
								        <th data-field="yundanzhuangtai" data-sortable="true">运单状态</th>
								        <th data-field="kehudanweijiancheng" data-sortable="true">发货单位</th>
								        <th data-field="kaipiaozhuangtai" data-sortable="true">开票状态</th>
								        <th data-field="jiesuanzhuangtai" data-sortable="true">结算状态</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>	
					 </c:forEach>	
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '驾驶员审核' && usersquanxian.chakan == '1' }">			
							<!-- 驾驶员审核 -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/jiaShiYuanMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">驾驶员审核</span>
								    <thead>
								    <tr>
								        <th data-field="jiashiyuanxingming" data-sortable="true">驾驶员姓名</th>
								        <th data-field="shenqingcheliang" data-sortable="true">申请车辆</th>
								        <th data-field="shenqingshijian" data-sortable="true">申请时间</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>	
					</c:forEach>		
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '保险管理' && usersquanxian.chakan == '1' }">		
							<!-- 保险提醒 -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/baoXianMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">保险提醒</span>
								    <thead>
								    <tr>
								        <th data-field="baodanhao" data-sortable="true">保单号</th>
								        <th data-field="chepaihao" data-sortable="true">车牌号</th>
								        <!-- <th data-field="leixing" data-sortable="true">保险类型</th> -->
								        <th data-field="daoqiriqi" data-sortable="true">到期日期</th>
								        <th data-field="baoxianzhuangtai" data-sortable="true">保险状态</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>		
					
					<!--  -->
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '年审管理' && usersquanxian.chakan == '1' }">		
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/nianShenGuanLiMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">年审管理</span>
								    <thead>
								    <tr>
								        <th data-field="chepaihao" data-sortable="true">车牌号</th>
								        <th data-field="chezhuxingming" data-sortable="true">车主姓名</th>
								        <th data-field="shoujihao" data-sortable="true">手机号</th>
								        <th data-field="nianshenriqi" data-sortable="true">年审日期</th>
								        <th data-field="nianshenzhuangtai" data-sortable="true">年审状态</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>					
						
					
					<!-- 驾驶员年审 -->
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '驾驶员年审' && usersquanxian.chakan == '1' }">		
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/jiaShiYuanNianShenMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">驾驶员年审</span>
								    <thead>
								    <tr>
								        <th data-field="jiashiyuanxingming" data-sortable="true">驾驶员姓名</th>
								        <th data-field="nianshenzhuangtai" data-sortable="true">年审状态</th>
								        <th data-field="chepaihao" data-sortable="true">车牌号</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>					
					
					<!-- 新车管理 -->
					<%-- <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '新车管理' && usersquanxian.chakan == '1' }">		
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/xinCheMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">新车管理</span>
								    <thead>
								    <tr>
								        <th data-field="bianhao" data-sortable="true">编号</th>
								        <th data-field="caozuoyuan" data-sortable="true">操作员</th>
								        <th data-field="jindu" data-sortable="true">进度</th>
								        <th data-field="banlizhuangtai" data-sortable="true">办理状态</th>
								        <th data-field="zhuceriqi" data-sortable="true">注册日期</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach> --%>			
					
					<!-- 投入审核和申请 -->
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '投入审核和申请' && usersquanxian.chakan == '1' }">		
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/tourushenheMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">投入审核和申请</span>
								    <thead>
								    <tr>
								        <th data-field="bianhao" data-sortable="true">编号</th>
								        <th data-field="zhuceriqi" data-sortable="true">注册日期</th>
								        <th data-field="caozuoyuan" data-sortable="true">操作员</th>
								        <th data-field="caozuo" data-sortable="true">操作</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>			
					
					<!--  -->
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '分管领导意见' && usersquanxian.chakan == '1' }">		
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/fenGuanLingDaoMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">分管领导意见</span>
								    <thead>
								    <tr>
								    	<th data-field="bianhao" data-sortable="true">编号</th>
								        <th data-field="chepaihao"  data-sortable="true">车牌号码</th>
								        <th data-field="banliriqi" data-sortable="true">办理日期</th>
								        <th data-field="caozuoyuan" data-sortable="true">操作员</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>			
						
						
					<!--  -->
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '分管开票审核' && usersquanxian.chakan == '1' }">	
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/kaiPiaoShenHeFenGuanMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">开票审核(分管负责人)</span>
								    <thead>
								    <tr>
								    	<th data-field="dingdanhao" data-sortable="true">订单号</th>
								        <th data-field="fenguankaipiaoshenhe" data-sortable="true">分管开票审核</th>
								        <th data-field="yingshoukuanzhuangtai" data-sortable="true">开票状态</th>
								        <th data-field="jiesuanzhuangtai" data-sortable="true">结算状态</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>			
						
						
					<!--  -->	
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '总经理开票审核' && usersquanxian.chakan == '1' }">	
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/kaiPiaoShenHeZongJingLiMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">开票审核(总经理)</span>
								    <thead>
								    <tr>
								    	<th data-field="dingdanhao" data-sortable="true">订单号</th>
								        <th data-field="zongjinglikaipiaoshenhe" data-sortable="true">总经理开票审核</th>
								        <th data-field="yingshoukuanzhuangtai" data-sortable="true">开票状态</th>
								        <th data-field="jiesuanzhuangtai" data-sortable="true">结算状态</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>			
						
					<!--  -->	
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '总经理结算审核' && usersquanxian.chakan == '1' }">	
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/jieSuanShenHeZongJingLiMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">结算审核(总经理)</span>
								    <thead>
								    <tr>
								    	<th data-field="dingdanhao" data-sortable="true">订单号</th>
								        <th data-field="zongjinglijiesuanshenhe" data-sortable="true">总经理结算审核</th>
								        <th data-field="yingshoukuanzhuangtai" data-sortable="true">开票状态</th>
								        <th data-field="jiesuanzhuangtai" data-sortable="true">结算状态</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>		
					
					<!--  -->	
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '董事长结算审核' && usersquanxian.chakan == '1' }">		
							<!--  -->
							<div style="width: 30%; height:300px ; float: left; margin-left: 1%">
								<table data-toggle="table" data-url="${pageContext.request.contextPath}/jieSuanShenHeDongShiZhangMenHuJson"  >
								    <span style="font-size: 16px;font-weight: bold;">结算审核(董事长)</span>
								    <thead>
								    <tr>
								    	<th data-field="dingdanhao" data-sortable="true">订单号</th>
								        <th data-field="dongshizhangjiesuanshenhe" data-sortable="true">董事长结算审核</th>
								        <th data-field="yingshoukuanzhuangtai" data-sortable="true">开票状态</th>
								        <th data-field="jiesuanzhuangtai" data-sortable="true">结算状态</th>
								    </tr>
								    </thead>
								</table>
							</div>
						</c:if>		
					</c:forEach>		
						
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
		
		
		});
	
	</script>
	
</body>

</html>
