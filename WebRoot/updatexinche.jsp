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
	<link href="${pageContext.request.contextPath}/css/postbirdAlertBox.css" rel="stylesheet">
	
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
	<script src="${pageContext.request.contextPath}/js/postbirdAlertBox.js"></script>
	
	<script type="text/javascript">
		
		$(function(){
		
			$("#riqi1,#riqi2,#riqi3,#riqi4,#riqi5,#riqi6").jeDate({
			    ishmsVal:false,
			    minDate: '1200-12-12',
				
			    format:"YYYY-MM-DD",
			    zIndex:3000,
			});
		
		});	
		
		var myleng = 1 ;
		var mychepaihao = 1 ;
		
		// 判断电话长度
		function dianhualeng(){
		
			var dianhua = document.getElementsByName("lianxidianhua")[0] ;
			
			var value = dianhua.value ;
			
			if(value.length != 11){
				dianhua.style.borderColor = 'red';
           		document.getElementById("dianhuatishi").style.display = 'inline';
           		
           		myleng = 0;	
			}
			
			
			if(value.length == 11){
				dianhua.style.borderColor = 'green';
           		document.getElementById("dianhuatishi").style.display = 'none';
           		
           		myleng = 1;
			}
		}
		
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
			
			if(myleng != 1 || mychepaihao != 1){
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
				<li class="active">修改新车</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/updateXinChe" onsubmit="return test()" method="post">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>编号<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="bianhao" class="form-control" value="${singlexinche.bianhao}"  placeholder="请输入编号" required="required" readonly="readonly"/>
					</div>					
					
					<%-- <div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车牌号 <span style="color: red;">*&nbsp;</span><span id="chepaihaotishi" style="color: red; display: none;">存在相同车牌号</span></label>
						<input name="chepaihao" class="form-control" value="${singlexinche.chepaihao}" onblur="existchepaihao()" placeholder="请输入车牌号" required="required"/>
					</div>	 --%>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>运输类别<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="yunshuleibie" class="form-control" value="${singlexinche.yunshuleibie}" placeholder="请输入运输类别" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆类型 &nbsp; <a onclick="cheliangleixing()">添加</a> </label>
						<select id="leixing" class="form-control" name="chexing">
							<option value="">请选择</option>
							<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
								<c:if test="${cheliangguanli.type == '1' && cheliangguanli.id == singlexinche.chexing}">
									<option value="${cheliangguanli.id}" selected="selected">${cheliangguanli.name}</option>
								</c:if>
								
								<c:if test="${cheliangguanli.type == '1' && cheliangguanli.id != singlexinche.chexing}">
									<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
								</c:if>
					        </c:forEach>
						</select>
					</div>
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆品牌 &nbsp; <a onclick="cheliangpinpai()">添加</a></label>
						<select id="pinpai" class="form-control" name="cheliangleixing">
							<option value="">请选择</option>
							<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
								<c:if test="${cheliangguanli.type == '2' && cheliangguanli.id == singlexinche.cheliangleixing}">
									<option value="${cheliangguanli.id}" selected="selected">${cheliangguanli.name}</option>
								</c:if>
								
								<c:if test="${cheliangguanli.type == '2' && cheliangguanli.id != singlexinche.cheliangleixing}">
									<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
								</c:if>
					        </c:forEach>
						</select>					
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆型号 &nbsp; <a onclick="cheliangxinghao()">添加</a></label>
					
						<select id="xinghao" class="form-control" name="pingpaixinghao">
							<option value="">请选择</option>
							<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
								<c:if test="${cheliangguanli.type == '3' && cheliangguanli.id == singlexinche.pingpaixinghao}">
									<option value="${cheliangguanli.id}" selected="selected">${cheliangguanli.name}</option>
								</c:if>
								
								<c:if test="${cheliangguanli.type == '3' && cheliangguanli.id != singlexinche.pingpaixinghao}">
									<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
								</c:if>
					        </c:forEach>
						</select>		
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>联系人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="lianxiren" class="form-control"  value="${singlexinche.lianxiren}" placeholder="请输入联系人" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>联系电话<span style="color: red;  padding-top: 10px">*&nbsp;</span><span id="dianhuatishi" style="color: red; display: none;">电话格式不规范</span> </label>
						<input name="lianxidianhua" class="form-control" value="${singlexinche.lianxidianhua}" onblur="dianhualeng()" placeholder="请输入联系电话" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>时间<span style="color: red;  padding-top: 10px">*</span></label>
						<input id="riqi1" name="shijian" class="form-control"  value="${singlexinche.shijian}" placeholder="请输入时间" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>责任人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="zerenren" class="form-control" value="${singlexinche.zerenren}" placeholder="请输入责任人" required="required"/>
					</div>	
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/jumpXinChe"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					<br/>
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	
	<script>
		
			function cheliangleixing() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入车辆类型',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '1', 'shijileixing' : shijileixing },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var leixing = document.getElementById("leixing");
				             	leixing.innerHTML = "<option value='"+datas[0].id+"'>"+datas[0].name+"</option>" + leixing.innerHTML ;
				             	
				             	$('#leixing').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
    		
    		function cheliangpinpai() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入车辆品牌',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            	
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '2' },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var pinpai = document.getElementById("pinpai");
				             	pinpai.innerHTML = "<option value='"+datas[0].id+"'>"+datas[0].name+"</option>" + pinpai.innerHTML ;
				             	
				             	$('#pinpai').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
    		
    		function cheliangxinghao() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入车辆型号',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            	
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '3' },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var xinghao = document.getElementById("xinghao");
				             	xinghao.innerHTML = "<option value='"+datas[0].id+"'>"+datas[0].name+"</option>" + xinghao.innerHTML ;
				             	
				             	$('#xinghao').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
    		
		$('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });
		    
		$('#basic3').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });    
	    
	    $('#leixing').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#pinpai').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#xinghao').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#fadongji').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#jingyingfanwei').selectpicker({
		      liveSearch: true,
	    });
		    
	</script>	
</body>

</html>
