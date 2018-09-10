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
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jedate.css" rel="stylesheet">
    
    <script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/zh.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jedate.js"></script>
    
	<script type="text/javascript">
		$(function(){
		
			$("#riqi1,#riqi2").jeDate({
			    ishmsVal:false,
			    minDate: '1200-12-12',
				
			    format:"YYYY-MM-DD",
			    zIndex:3000,
			});
		
		});	
	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">添加证件</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加证件 -->
				<form id="forms" action="${pageContext.request.contextPath}/addZhengJian" onsubmit=""  method="post" enctype="multipart/form-data">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号<span style="color: red;">*</span> </label>
						<select id="basic2" name="chepaihao" class="show-tick form-control">
					        <c:forEach items="${chelianglist}" var="cheliang">
									<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
					        </c:forEach>
						</select>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>证件类型<span style="color: red;">*</span><span style="color: red">:${existzhengjianleixing}</span></label>
						<input name="zhengjianleixing" class="form-control" placeholder="请输入证件类型" required="required"/>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>办理日期<span style="color: red;">*</span></label>
						<input id="riqi1" name="banliriqi"  class="form-control" placeholder="请输入办理日期" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>到期日期<span style="color: red;">*</span></label>
						<input id="riqi2" name="daoqiriqi"  class="form-control" placeholder="请输入到期日期" required="required"/>
					</div>	
										
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>证件号码<span style="color: red;">*</span></label>
						<input name="zhengjianhaoma" class="form-control" placeholder="请输入证件号码" required="required"/>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<div id="tupiantishi" class="alert bg-warning" role="alert">
					<span class="glyphicon glyphicon-warning-sign"></span> 上传图片的名称请不要带有中文，\ 等一些特殊符号 ( 图片格式：jpg，png，gif ) <a id="guanbitishi" href="#" class="pull-right"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
					
					<div class="form-group">
			            <input id="file-1" name="picture" type="file" multiple class="file" />
			        </div>
			        
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button id="mysubmit"  type="submit" onclick=""  class="btn btn-primary"  style="float: left; margin-left: 30px">证件登记</button>
					<a href="${pageContext.request.contextPath}/jumpZhengJian"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	
	<script>
		$("#file-1").fileinput({
	    	language: 'zh', //设置语言,还要导入对应的js文件 — —
	    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
	    	//dropZoneEnabled: false,//是否显示拖拽区域 
	        uploadUrl: '${pageContext.request.contextPath}/zhengJianUploadFile', // 多图片必须设置图片上传的url路径 
	        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
	       	//showUploadedThumbs:false  ,  
	       	showUpload: false, //是否显示上传按钮
	       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
	       /* 	uploadExtraData:{chepaihao: 'abc'},	//在上传文件之前调用的,额外参数的关键点~这是死的参数 */
	       	uploadExtraData: function(chepaihao, id) {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
				var cph = document.getElementsByName("chepaihao")[0].value;		       		
                return {"chepaihao": cph};
            },
		}).on("filebatchselected", function(event, files) {//选择文件
			  $(this).fileinput("upload"); //上传选中的文件
		}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
				document.getElementById("mysubmit").disabled = true;
        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
		  	    /* var json = data.response;  //解析数据  因为数据是json格式
		  	    alert(json[0].value);  	//数据是数组格式 */
		  	    document.getElementById("mysubmit").disabled = false;
		   });
		
		$(function(){
		
			$('#special2').on('click', function () {
		      mySelect.find('option:disabled').prop('disabled', false);
		      mySelect.selectpicker('refresh');
		    });
		
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
		    });
		    
		    $("#guanbitishi").click(function(){
				$("#tupiantishi").hide();		    	
		    });
			
		});
				
	</script>	
</body>

</html>
