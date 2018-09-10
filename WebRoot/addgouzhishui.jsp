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
	<link href="${pageContext.request.contextPath}/css/jedate.css" rel="stylesheet">
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="${pageContext.request.contextPath}/js/jedate.js"></script>
	
	<script type="text/javascript">
		$(function(){
		
			$("#riqi1,#riqi2,#riqi3,#riqi4,#riqi5,#riqi6").jeDate({
			    ishmsVal:false,
			    minDate: '1200-12-12',
				
			    format:"YYYY-MM-DD",
			    zIndex:3000,
			});
		
		});	
	</script>
	
	
	<script type="text/javascript">
	
		var mychepaihao = 0;
	
		//判断是否存在相同的车牌号
		function existchepaihao(){
		
			var chepaihao = document.getElementsByName("chepaihao")[0] ;
			
			$.ajax({
	             type: "POST",
	             url: "${pageContext.request.contextPath}/existChePaiHao",
	             data: { 'chepaihao' : chepaihao.value },
	             dataType: "json",
	             success: function(data){
	             	var datas = eval(data);
	             	
	             	if( "err" == datas[0].flag ){
	             		chepaihao.style.borderColor = 'red';
	             		document.getElementById("chepaihaotishi").style.display = 'inline';
	             		
	             		mychepaihao = 0;
	             	}
	             	
	             	if( "success" == datas[0].flag ){
	             		chepaihao.style.borderColor = 'green';
	             		document.getElementById("chepaihaotishi").style.display = 'none';
	             		
	             		mychepaihao = 1;
	             	}
	             }
	             
         	});
			
		}
		
		
		//判断是否提交
		function test(){
			
			if( mychepaihao != 1 ){
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
				<li class="active">材料收集、购置税办理、临牌办理、车辆行驶证办理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/addGouZhiShui" onsubmit="return test()" method="post" enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆一致性证书</label>
						<input type="file" name="yizhixing" >
						<input type="checkbox" value="已收集" name="yizhixingshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆合格证</label>
						<input type="file" name="hegezheng">
						<input type="checkbox" value="已收集" name="hegezhengshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆四联发票</label>
						<input type="file" name="silianfapiao">
						<input type="checkbox" value="已收集" name="silianfapiaoshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆交强险正副本和标贴</label>
						<input type="file" name="jiaoqiangxian">
						<input type="checkbox" value="已收集" name="jiaoqiangxianshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>临时牌证</label>
						<input type="file" name="linshipaizheng">
						<input type="checkbox" value="已收集" name="linshipaizhengshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车载终端型号</label>
						<input type="file" name="zhongduanxinghao">
						<input type="checkbox" value="已收集" name="zhongduanxinghaoshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆购置税证明</label>
						<input type="file" name="gouzhishui">
						<input type="checkbox" value="已收集" name="gouzhishuishouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆行驶证</label>
						<input type="file" name="xingshizheng">
						<input type="checkbox" value="已收集" name="xingshizhengshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆登记证书</label>
						<input type="file" name="dengjizheng">
						<input type="checkbox" value="已收集" name="dengjizhengshouji" >已收集
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶人员安驾证明</label>
						<input type="file" name="anjiazheng">
						<input type="checkbox" value="已收集" name="anjiazhengshouji" >已收集
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆喷图标志</label>
						<input type="file" name="pentubiaozhi">
						<input type="checkbox" value="已收集" name="pentubiaozhishouji" >已收集
					</div>		
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>责任人 <span style="color: red;">*</span></label>
						<input name="zerenren" class="form-control" placeholder="请输入责任人" required="required" style="width: 40%"/>
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号<span style="color: red;">*&nbsp;</span><span id="chepaihaotishi" style="color: red; display: none;">存在相同车牌号</span></label>
						<input name="chepaihao" class="form-control" onblur="existchepaihao()" placeholder="请输入车牌号"  required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">办理</button>
					<a href="${pageContext.request.contextPath}/jumpGouZhiShui"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					<br/>
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	
	<script>
		$('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });
		    
		$('#basic3').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });    
	</script>	
</body>

</html>
