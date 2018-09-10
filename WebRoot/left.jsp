<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
	
</head>

<body>
		
	<!--
		左边菜单栏
    -->	
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		
		<ul class="nav menu">
			<!--  class="active" 代表被选中  -->
			<li><a href="index.html"><span class="glyphicon glyphicon-user"/> 工作用户</a></li>
			<li><a href="widgets.html"><span class="glyphicon glyphicon-user"/> 用户管理</a></li>
			<li><a href="charts.html"><span class="glyphicon glyphicon-stats"/> 权限设置</a></li>
			<li onclick="dept()"><a href="#"><span class="glyphicon glyphicon-list-alt"/> 部门管理</a></li>
			<li><a href="forms.html"><span class="glyphicon glyphicon-pencil"/> 客户管理</a></li>
			
			<li class="parent">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 安全管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus" id="menu1"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 车辆管理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 保险管理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 证件管理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 年审管理
						</a>
					</li>
				</ul>
			</li>
			
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 驾驶员管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus" id="menu2"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 驾驶员资料
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 待审核驾驶员
						</a>
					</li>
				</ul>
			</li>
			
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 新车入户 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus" id="menu3"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 新车管理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 投入审核和申请
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 购置税办理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 营运证办理
						</a>
					</li>		
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 保险出单
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 材料整理档案建立
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 费用结算
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 责任人签字
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 分管领导意见
						</a>
					</li>
				</ul>
			</li>
			
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 业务管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus" id="menu4"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-4">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 运单管理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 运单审核
						</a>
					</li>
				</ul>
			</li>	
			
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 财务管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus" id="menu5"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-5">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 各车辆费用管理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 开票
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 开票管理
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 营收款管理
						</a>
					</li>
				</ul>
			</li>
			
			<!--     水平线       -->
			<li role="presentation" class="divider"></li>
			
			<li><a href="panels.html"><span class="glyphicon glyphicon-info-sign"/> 危险品数据库</a></li>
			
			<li><a href="panels.html"><span class="glyphicon glyphicon-info-sign"/> 查询统计</a></li>

			<!--     水平线       -->
			<li role="presentation" class="divider"></li>
			
			<li><a href="login.html"><span class="glyphicon glyphicon-user"></span> Login Page</a></li>
		</ul>
	</div><!--/.sidebar-->
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<!-- <script src="js/bootstrap.min.js"></script> -->
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	
	<script>
		$('#calendar').datepicker({
		});

		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		});
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		});
	</script>	
	<script>
		$("#menu1").click(function(){
 			 $("#sub-item-1").slideToggle();
		});
		$("#menu2").click(function(){
 			 $("#sub-item-2").slideToggle();
		});
		$("#menu3").click(function(){
 			 $("#sub-item-3").slideToggle();
		});
		$("#menu4").click(function(){
 			 $("#sub-item-4").slideToggle();
		});
		$("#menu5").click(function(){
 			 $("#sub-item-5").slideToggle();
		});
	</script>	
</body>

</html>
