<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<link href="css/lightbox.css" rel="stylesheet">
	
	<title>驾驶员审核详细</title>
	
	<script type="text/javascript">
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">驾驶员审核详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶员姓名 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.jiashiyuanxingming }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶车辆 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.jiashicheliang}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>所属部门 : <span style="font-weight:normal;">
											<c:forEach items="${deptlist}" var="dept">
												<c:if test="${dept.deptid == singlejiashiyuanshenhe.bumen}">${dept.deptname}</c:if>
											</c:forEach>
										</span>
						</label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶员类型 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.jiashiyuanleixing}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>出生日期 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuanshenhe.chushengriqi,0,10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>籍贯 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.jiguan}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>身份证号 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.shenfenzhenghao}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>电话 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.dianhua}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>地址 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.dizhi}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>准驾车型 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.zhunjiachexing}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>初次领证日期 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuanshenhe.chucilingzhengriqi,0,10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶证年审日期 : <span style="font-weight:normal;">${fn:substring(singlejiashiyuanshenhe.jiashizhengnianshenriqi,0,10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>密码 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.mima}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>从业资格证号 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.congyezigezhenghao}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>从业资格类别 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.congyezigeleibie}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>从业资格继续教育时间: <span style="font-weight:normal;">${fn:substring(singlejiashiyuanshenhe.congyezigejixujiaoyushijian,0,10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>从业资格诚信考核时间: <span style="font-weight:normal;">${fn:substring(singlejiashiyuanshenhe.congyezigechengxinkaoheshijian,0,10)}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>证件有效日期: <span style="font-weight:normal;">${fn:substring(singlejiashiyuanshenhe.zhengjianyouxiaoriqi,0,10)}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>档案编号 : <span style="font-weight:normal;">${singlejiashiyuanshenhe.danganbianhao}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 60%; float: left; margin-left: 30px">
						<label>备注: <span style="font-weight:normal;">${singlejiashiyuanshenhe.beizhu}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>审核状态: <span style="font-weight:normal;">${singlejiashiyuanshenhe.shenhezhuangtai}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶员图片</label>
					</div>	
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div style="margin-left: 20px;width: 100%;">
						<c:forEach items="${jiashiyuantupianlist}" var="jiashiyuantupian">
							<div style="margin-left: 10px;margin-top: 10px;float: left;">
								 <a class="example-image-link" href="${jiashiyuantupian}" data-lightbox="example-set" >
								 	<img class="example-image" src="${jiashiyuantupian}" width="300px" height="200px"/>
								 </a>
							</div>
				        </c:forEach>					
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶证图片</label>
					</div>	
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div style="margin-left: 20px;width: 100%;">
						<c:forEach items="${jiashizhengtupianlist}" var="jiashizhengtupian">
							<div style="margin-left: 10px;margin-top: 10px;float: left;">
								 <a class="example-image-link" href="${jiashizhengtupian}" data-lightbox="example-set" >
								 	<img class="example-image" src="${jiashizhengtupian}" width="300px" height="200px"/>
								 </a>
							</div>
				        </c:forEach>					
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>从业资格证图片</label>
					</div>	
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div style="margin-left: 20px;width: 100%;">
						<c:forEach items="${congyezigezhengtupianlist}" var="congyezigezhengtupian">
							<div style="margin-left: 10px;margin-top: 10px;float: left;">
								 <a class="example-image-link" href="${congyezigezhengtupian}" data-lightbox="example-set" >
								 	<img class="example-image" src="${congyezigezhengtupian}" width="300px" height="200px"/>
								 </a>
							</div>
				        </c:forEach>					
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>身份证图片</label>
					</div>	
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div style="margin-left: 20px;width: 100%;">
						<c:forEach items="${shenfenzhengtupianlist}" var="shenfenzhengtupian">
							<div style="margin-left: 10px;margin-top: 10px;float: left;">
								 <a class="example-image-link" href="${shenfenzhengtupian}" data-lightbox="example-set" >
								 	<img class="example-image" src="${shenfenzhengtupian}" width="300px" height="200px"/>
								 </a>
							</div>
				        </c:forEach>					
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					<br/>	
										
					<a href="${pageContext.request.contextPath}/jumpJiaShiYuanShenHe"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
					<br/><br/>
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
	<script src="js/lightbox-plus-jquery.js"></script>
	
</body>

</html>
