<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>            
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/datepicker3.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-duallistbox.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" />
	
	<script type="text/javascript" src="laydate/laydate.js" ></script>
	<script type="text/javascript">
		var smalltime = {
		  format: 'YYYY-MM-DD hh:mm:ss',
		  istime: true,
		};
	</script>
	
</head>

<body>
		
	<br/><br/><br/>	
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active" >添加车辆关系</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加车辆关系 -->
				<div id="dialogBg"></div>
				<div id="dialog" class="animated" style="width: 800px; height: 310px; margin-top:-230px;margin-left:-300px">
					<div id="myselect" style="margin-top: 40px; margin-left:24px ; width: 750px; height: 300px;">
						<select multiple="multiple" size="10" name="duallistbox_demo1[]">
							 <c:forEach items="${guachelist}" var="guache">
									<option value="${guache.chepaihao}">${guache.chepaihao}</option>
					         </c:forEach>
					    </select>
						<button id="endpage" class="btn btn-info" type="button" style="margin-left: 45%; margin-top: 10px">确定</button>
					</div>
				</div>
					
				<form name="myform" action="${pageContext.request.contextPath}/addCheLiangGuanXi" onsubmit="return panduan()" method="post">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>牵引车 </label>
						<select class="form-control" name="qianyinche" required="required">
					        <c:forEach items="${qianyinchelist}" var="qianyinche">
									<option value="${qianyinche.chepaihao}">${qianyinche.chepaihao}</option>
					        </c:forEach>
						</select>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>挂车<span id="message" style="display: none; color: red;">: 请选择挂车</span></label>
						<input name="guache"  class="form-control" placeholder="请选择挂车" readonly="readonly" />
					</div>	
					<a href="javascript:;" class="bounceInDown"><button  class="btn btn-info" type="button" style="float: left; margin-left: 10px; margin-top: 25px">选择</button></a>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 80%; float: left; margin-left: 30px">
						<label>备注</label>
						<textarea class="form-control" rows="5" name="beizhu" ></textarea>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">添加</button>
					<a href="${pageContext.request.contextPath}/cheliangguanxi.jsp"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>
				
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.bootstrap-duallistbox.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart-data.js"></script>
	<script src="${pageContext.request.contextPath}/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/js/easypiechart-data.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
	
	<script>
		 var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox();
		 
		/*  $("#abc").click(function() {
	        var value =$('[name="duallistbox_demo1[]"]').val();
	        $('[name="guache"]').val(value);
	     	$("#myselect").hide();
	     	$('[name="myform"]').show();
	     });
	     
	      $("#selectpara").click(function() {
	      	$('[name="myform"]').hide();
	     	$("#myselect").show();
	     }); */
	     
	       var w,h,className;
		
		//这是黑屏的区域
		function getSrceenWH(){
			w = $(window).width();
			h = $(window).height();
			$('#dialogBg').width(w).height(h);
		}
	
		window.onresize = function(){  
			getSrceenWH();
		};  
		
		$(window).resize();  
	
		$(function(){
			getSrceenWH();
			
			$('.bounceInDown').click(function(){
				className = $(this).attr('class');
				$('#dialogBg').fadeIn(300);
				$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
			});
			
			$('#endpage').click(function(){
				$('#dialogBg').fadeOut(300,function(){
					$('#dialog').addClass('bounceOutUp').fadeOut();
				});
				
				var value =$('[name="duallistbox_demo1[]"]').val();
	       		$('[name="guache"]').val(value);
			});
			
		});
	     
	     function panduan(){
	     	var guache = document.getElementsByName("guache");
	     	var value = guache[0].value;
	     	if(value==null || value==""){
	     		$("#message").show();
	     		return false;
	     	}else{
	     		return true;
	     	}
	     }
	     
	</script>	
</body>

</html>