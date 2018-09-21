<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
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
		
			$("#riqi1,#riqi2,#riqi3,#riqi4,#riqi5,#riqi6").jeDate({
			    ishmsVal:false,
			    minDate: '1200-12-12',
				
			    format:"YYYY-MM-DD",
			    zIndex:3000,
			});
		
		});	
		
		var myboolean = 1 ;
		var shenfenBoolean = 1 ;
		
		function existdianhua(){
		
			var dianhua = document.getElementsByName("dianhua")[0] ;		
			
			
			var value = dianhua.value;
			
			$.ajax({
			
	             type: "POST",
	             url: "${pageContext.request.contextPath}/jiaShiYuanExistDianHua",
	             data: { 'dianhua' : value },
	             dataType: "json",
	             success: function(data){
	             	var datas = eval(data);
	             	
	             	if( "err" == datas[0].flag || value.length != 11 ){
	             		dianhua.style.borderColor = 'red';
	             		document.getElementById("dianhuatishi").style.display = 'inline';
	             		
	             		myboolean = 0;
	             	}
	             	
	             	if( "success" == datas[0].flag && value.length == 11 ){
	             		dianhua.style.borderColor = 'green';
	             		document.getElementById("dianhuatishi").style.display = 'none';
	             		
	             		myboolean = 1;
	             	}
	             }
	             
         	});
		}
		
		
		function test(){
			
			if(myboolean != 1){
				document.getElementsByName("dianhua")[0].focus();
				return false;
			}
			
			if(shenfenBoolean != 1){
				document.getElementsByName("shenfenzhenghao")[0].focus();
				return false;
			}
			
		}
		
		function autoShenFen(){
		
			var shenfenzhengObj = document.getElementsByName("shenfenzhenghao")[0];
			var shenfenzhenghao = document.getElementsByName("shenfenzhenghao")[0].value ;	

			if(shenfenzhenghao.length == 18){
				
				/* var value = shenfenzhenghao.substring(6,14);
				
				var nian = value.substring(0,4);
				var yue = value.substring(4,6);
				var ri  = value.substring(6,8);
				
				document.getElementsByName("chushengriqi")[0].value = nian + "-" + yue + "-" + ri; */
				
				$.ajax({
			
		             type: "POST",
		             url: "${pageContext.request.contextPath}/jiaShiYuanExistShenFenZheng",
		             data: { 'shenfenzhenghao' : shenfenzhenghao },
		             dataType: "json",
		             success: function(data){
		             	var datas = eval(data);
		             	
		             	if( "err" == datas[0].flag ){
		             		shenfenzhengObj.style.borderColor = 'red';
		             		document.getElementById("shenfentishi").style.display = 'inline';
		             		
		             		shenfenBoolean = 0;
		             	}
		             	
		             	if( "success" == datas[0].flag ){
		             		shenfenzhengObj.style.borderColor = 'green';
		             		
		             		document.getElementById("shenfentishi").style.display = 'none';
		             		
		             		shenfenBoolean = 1;
		             	}
		             }
		             
	         	});
				
			}else{
				document.getElementById("shenfentishi").style.display = 'inline';
				shenfenBoolean = 0 ;
			}
			
		}
		
	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">修改驾驶员</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加证件 -->
				<form id="forms" action="${pageContext.request.contextPath}/submitUpdateJianShiYuan"  onsubmit="return test()"  method="post" enctype="multipart/form-data">	
				
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>驾驶员姓名 <span style="color: red;">*</span></label>
						<input name="jiashiyuanxingming" class="form-control" value="${singlejiashiyuan.jiashiyuanxingming}" placeholder="请输入驾驶员姓名" readonly="readonly" />
					</div>		
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>性别</label>
						<input name="xingbie" class="form-control" value="${singlejiashiyuan.xingbie}" placeholder="请输入性别" />
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>出生日期 <span style="color: red;">*</span></label>
						<input id="riqi1" name="chushengriqi"  class="form-control" value="${fn:substring(singlejiashiyuan.chushengriqi, 0, 10)}" placeholder="请输入出生日期" required="required"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>地址</label>
						<input name="dizhi" class="form-control" value="${singlejiashiyuan.dizhi}" placeholder="请输入地址" />
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>电话 <span style="color: red;">*&nbsp;</span> <span id="dianhuatishi" style="color: red; display: none;">格式或电话重复</span></label>
						<input name="dianhua" class="form-control" value="${singlejiashiyuan.dianhua}" onblur="existdianhua()"  placeholder="请输入电话" required="required"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>密码 <span style="color: red;">*</span></label>
						<input name="mima" class="form-control" placeholder="请输入密码" value="${singlejiashiyuan.mima}" required="required"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>所属部门 <span style="color: red;">*</span></label>
						<select class="form-control" name="bumen" required="required">
							<c:forEach items="${deptlist}" var="dept">
								<c:if test="${dept.deptid == singlejiashiyuan.bumen }">
									<option value="${dept.deptid}" selected="selected">${dept.deptname}</option>
								</c:if>
								
								<c:if test="${dept.deptid != singlejiashiyuan.bumen }">
									<option value="${dept.deptid}">${dept.deptname}</option>
								</c:if>
					        </c:forEach>
						</select>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>档案编号</label>
						<input name="danganbianhao" class="form-control" placeholder="请输入档案编号" value="${singlejiashiyuan.danganbianhao}" />
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>身份证号/驾驶证号 <span style="color: red;">*<span id="shenfentishi" style="display: none;">请输入18位或身份证重复</span></span></label>
						<input name="shenfenzhenghao" class="form-control" value="${singlejiashiyuan.shenfenzhenghao}" onblur="autoShenFen()" placeholder="请输入身份证号" required="required"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>驾驶证档案编号</label>
						<input name="jiashizhengbianhao" class="form-control" value="${singlejiashiyuan.jiashizhengbianhao}"  placeholder="请输入驾驶证档案编号" />
					</div>		
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>准驾车型 </label>
						<select name="zhunjiachexing" id="basic3" class="show-tick form-control"  multiple >
						
							<c:forEach items="${selectZhunJia}" var="selectzhunjia" >
								<option value="${selectzhunjia}" selected="selected">${selectzhunjia}</option>
					        </c:forEach>
							
							<c:forEach items="${zhunjialist}" var="zhunjia" >
								<option value="${zhunjia}" >${zhunjia}</option>
					        </c:forEach>
						</select>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>初次领证日期 </label>
						<input id="riqi2" name="chucilingzhengriqi"   class="form-control"  value="${fn:substring(singlejiashiyuan.chucilingzhengriqi, 0, 10)}" placeholder="请输入初次领证日期" />
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>驾驶证年审到期日期 </label>
						<input id="riqi3" name="jiashizhengnianshenriqi"  class="form-control" value="${fn:substring(singlejiashiyuan.jiashizhengnianshenriqi, 0, 10)}" placeholder="请输入驾驶证年审到期日期" />
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>驾驶证有效日期至</label>
						<input id="riqi6" name="zhengjianyouxiaoriqi"  class="form-control" value="${fn:substring(singlejiashiyuan.zhengjianyouxiaoriqi, 0, 10)}" placeholder="请输入驾驶证有效日期至" />					
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>驾驶员类型  <span style="color: red;">*</span></label>
						<select class="form-control" name="jiashiyuanleixing" required="required">
							<c:if test="${singlejiashiyuan.jiashiyuanleixing == '驾驶员' }">
								<option value="驾驶员" selected="selected">驾驶员</option>
							</c:if>
							<c:if test="${singlejiashiyuan.jiashiyuanleixing != '驾驶员' }">
								<option value="驾驶员">驾驶员</option>
							</c:if>
							
							<c:if test="${singlejiashiyuan.jiashiyuanleixing == '押运员' }">
								<option value="押运员" selected="selected">押运员</option>
							</c:if>
							<c:if test="${singlejiashiyuan.jiashiyuanleixing != '押运员' }">
								<option value="押运员">押运员</option>
							</c:if>
							
							<c:if test="${singlejiashiyuan.jiashiyuanleixing == '驾押员' }">
								<option value="驾押员" selected="selected">驾押员</option>
							</c:if>
							<c:if test="${singlejiashiyuan.jiashiyuanleixing != '驾押员' }">
							<option value="驾押员">驾押员</option>
							</c:if>
							
						</select>
					</div>						
								
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>从业资格证号</label>
						<input name="congyezigezhenghao" class="form-control" placeholder="请输入从业资格证号" value="${singlejiashiyuan.congyezigezhenghao}"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>从业资格类别</label>
						<br/>
						<select name="congyezigeleibie" id="basic2" class="show-tick form-control"  multiple >
					    	<c:forEach items="${selectCongYeZiGeStr}" var="selectCongYeZiGe" >
								<option value="${selectCongYeZiGe}" selected="selected">${selectCongYeZiGe}</option>
					        </c:forEach>
					        
					    	<c:forEach items="${congyezigelist}" var="congyezige" >
								<option value="${congyezige.leibiemingcheng}" >${congyezige.leibiemingcheng}</option>
					        </c:forEach>
						</select>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>从业资格证有效期至</label>
						<input id="riqi5" name="congyezigeriqi"  class="form-control" value="${fn:substring(singlejiashiyuan.congyezigeriqi, 0, 10)}" placeholder="请输入从业资格证有效期至" />					
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>发证机关</label>
						<input name="fazhengjiguan" class="form-control" value="${singlejiashiyuan.fazhengjiguan}" placeholder="请输入发证机关" />	
					</div>				
						
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>		
								
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>继续教育有效期起</label>
						<input id="riqi5" name="congyezigejixujiaoyushijian"  class="form-control" value="${fn:substring(singlejiashiyuan.congyezigejixujiaoyushijian, 0, 10)}"  placeholder="请输入继续教育有效期起" />					
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>继续教育有效期止</label>
						<input id="riqi6" name="congyezigejixujiaoyushijianzhi"  class="form-control" value="${fn:substring(singlejiashiyuan.congyezigejixujiaoyushijianzhi, 0, 10)}" placeholder="请输入继续教育有效期止" />					
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>诚信考核到期日期</label>
						<input id="riqi6" name="congyezigechengxinkaoheshijian"   class="form-control" value="${fn:substring(singlejiashiyuan.congyezigechengxinkaoheshijian, 0, 10)}" placeholder="请输入从业资格诚信考核时间"  />
					</div>		
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>备注</label>
						<input name="beizhu" class="form-control" placeholder="请输入备注" value="${singlejiashiyuan.beizhu}"/>
					</div>	
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div	>
					<div id="tupiantishi" class="alert bg-warning" role="alert">
					<span class="glyphicon glyphicon-warning-sign"></span> 上传图片的名称请不要带有中文，\ 等一些特殊符号 ( 图片格式：jpg，png，gif ) <a id="guanbitishi" href="#" class="pull-right"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
					
					<div class="form-group">
						<label style="margin-left: 30px;">驾驶员图片</label>
			            <input id="jiashiyuantupian" name="jiashiyuantupian" type="file" multiple class="file-loading" />
			        </div>
			        
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group">
						<label style="margin-left: 30px;">驾驶证图片</label>
			            <input id="jiashizhengtupian" name="jiashizhengtupian" type="file" multiple class="file-loading" />
			        </div>
			        
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group">
						<label style="margin-left: 30px;">从业资格证图片</label>
			            <input id="congyezigezhengtupian" name="congyezigezhengtupian" type="file" multiple class="file-loading" />
			        </div>
			        
			        <!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group">
						<label style="margin-left: 30px;">身份证图片</label>
			            <input id="shenfenzhengtupian" name="shenfenzhengtupian" type="file" multiple class="file-loading" />
			        </div>
			        
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button id="mysubmit"  type="submit" onclick=""  class="btn btn-primary"  style="float: left; margin-left: 30px">驾驶员修改</button>
					<a href="${pageContext.request.contextPath}/jumpJiaShiYuan"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
					<br/><br/>
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script>
		
		$(function(){
			
			$.ajax({
				type : "post",
				url  : '${pageContext.request.contextPath}/jiashiyuantupianAjax' ,
				dataType : 'json',
				success : function(data){
					var datas = eval(data);	//格式化json数据
					showInitjiashiyuantupian(datas);	//调用初始化方法
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					//没有图片初始化
					$("#jiashiyuantupian").fileinput({
				    	language: 'zh', //设置语言,还要导入对应的js文件 — —
				        uploadUrl: '${pageContext.request.contextPath}/jiashiyuantupianFileUpLoad', // 多图片必须设置图片上传的url路径 
				        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
				       	//showUploadedThumbs:false  ,  
				       	showUpload: false, //是否显示上传按钮
				       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
						uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
							var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
	               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "jiashiyuantupian"};
			            },
					}).on("filebatchselected", function(event, files) {//选择文件
						  $(this).fileinput("upload"); //上传选中的文件
					}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
							document.getElementById("mysubmit").disabled = true;
			        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
					  	    document.getElementById("mysubmit").disabled = false;
					});  
					
				}			
			});
			
			function showInitjiashiyuantupian(mydata){
				
				var prepicture = new Array();
				for(var i=0; i<mydata.length ;i++){
					prepicture[i]="<img src='"+mydata[i].deletepicture+"' class='file-preview-image' width='300px' height='200px'>";
				}
				
				var preconfig = new Array();
				for(var i=0; i<mydata.length ;i++){
					var tjson = {caption: mydata[i].deletepicture, // 展示的文件名 
									url:'${pageContext.request.contextPath}/jiashiyuantupianDeleteFile', // 删除url 
									key: "key" , // 删除是Ajax向后台传递的参数 
									extra:{"fullpath": mydata[i].fullpath},	//传递删除额外参数
								}; 
					preconfig[i]=tjson;			
				} 
					
				$("#jiashiyuantupian").fileinput({
			    	language: 'zh', //设置语言,还要导入对应的js文件 — —
			    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
			    	//dropZoneEnabled: false,//是否显示拖拽区域 
			        uploadUrl: '${pageContext.request.contextPath}/jiashiyuantupianFileUpLoad', // 多图片必须设置图片上传的url路径 
			        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
			       	//showUploadedThumbs:false  ,  
			       	showUpload: false, //是否显示上传按钮
			       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
					
					initialPreview: prepicture,	//初始化图片
					/* initialPreviewAsData: true, */
					initialPreviewConfig : preconfig,	//初始化图片格式
					
					uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
						var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "jiashiyuantupian"};
		            },
				}).on("filebatchselected", function(event, files) {//选择文件
					  $(this).fileinput("upload"); //上传选中的文件
				}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
						document.getElementById("mysubmit").disabled = true;
		        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
				  	    /* var json = data.response;  //解析数据  因为数据是json格式
				  	    alert(json[0].value);  	//数据是数组格式 */
				  	    document.getElementById("mysubmit").disabled = false;
				}).on("filepredelete", function(event, key) {  //删除文件中
					
				});  
				
			};
			
			
			$.ajax({
				type : "post",
				url  : '${pageContext.request.contextPath}/jiashizhengtupianAjax' ,
				dataType : 'json',
				success : function(data){
					var datas = eval(data);	//格式化json数据
					showInitjiashizhengtupian(datas);	//调用初始化方法
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					//没有图片初始化
					$("#jiashizhengtupian").fileinput({
				    	language: 'zh', //设置语言,还要导入对应的js文件 — —
				    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
				    	//dropZoneEnabled: false,//是否显示拖拽区域 
				        uploadUrl: '${pageContext.request.contextPath}/jiashizhengtupianFileUpLoad', // 多图片必须设置图片上传的url路径 
				        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
				       	//showUploadedThumbs:false  ,  
				       	showUpload: false, //是否显示上传按钮
				       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
						uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
							var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
	               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "jiashizhengtupian"};
			            },
					}).on("filebatchselected", function(event, files) {//选择文件
						  $(this).fileinput("upload"); //上传选中的文件
					}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
							document.getElementById("mysubmit").disabled = true;
			        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
					  	    document.getElementById("mysubmit").disabled = false;
					});  
					
					
				}			
			});
			
			function showInitjiashizhengtupian(mydata){
				
				var prepicture = new Array();
				for(var i=0; i<mydata.length ;i++){
					prepicture[i]="<img src='"+mydata[i].deletepicture+"' class='file-preview-image' width='300px' height='200px'>";
				}
				
				var preconfig = new Array();
				for(var i=0; i<mydata.length ;i++){
					var tjson = {caption: mydata[i].deletepicture, // 展示的文件名 
									url:'${pageContext.request.contextPath}/jiashizhengtupianDeleteFile', // 删除url 
									key: "key" , // 删除是Ajax向后台传递的参数 
									extra:{"fullpath": mydata[i].fullpath},	//传递删除额外参数
								}; 
					preconfig[i]=tjson;			
				} 
					
				$("#jiashizhengtupian").fileinput({
			    	language: 'zh', //设置语言,还要导入对应的js文件 — —
			    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
			    	//dropZoneEnabled: false,//是否显示拖拽区域 
			        uploadUrl: '${pageContext.request.contextPath}/jiashizhengtupianFileUpLoad', // 多图片必须设置图片上传的url路径 
			        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
			       	//showUploadedThumbs:false  ,  
			       	showUpload: false, //是否显示上传按钮
			       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
					
					initialPreview: prepicture,	//初始化图片
					/* initialPreviewAsData: true, */
					initialPreviewConfig : preconfig,	//初始化图片格式
					
					uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
						var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "jiashizhengtupian"};
		            },
				}).on("filebatchselected", function(event, files) {//选择文件
					  $(this).fileinput("upload"); //上传选中的文件
				}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
						document.getElementById("mysubmit").disabled = true;
		        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
				  	    /* var json = data.response;  //解析数据  因为数据是json格式
				  	    alert(json[0].value);  	//数据是数组格式 */
				  	    document.getElementById("mysubmit").disabled = false;
				}).on("filepredelete", function(event, key) {  //删除文件中
					
				});  
				
			};
			
			
			$.ajax({
				type : "post",
				url  : '${pageContext.request.contextPath}/congyezigezhengtupianAjax' ,
				dataType : 'json',
				success : function(data){
					var datas = eval(data);	//格式化json数据
					showInitcongyezigezhengtupian(datas);	//调用初始化方法
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					//没有图片初始化
					$("#congyezigezhengtupian").fileinput({
				    	language: 'zh', //设置语言,还要导入对应的js文件 — —
				    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
				    	//dropZoneEnabled: false,//是否显示拖拽区域 
				        uploadUrl: '${pageContext.request.contextPath}/congyezigezhengtupianFileUpLoad', // 多图片必须设置图片上传的url路径 
				        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
				       	//showUploadedThumbs:false  ,  
				       	showUpload: false, //是否显示上传按钮
				       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
						uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
							var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
	               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "congyezigezhengtupian"};
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
										
				}	
			});
			
			function showInitcongyezigezhengtupian(mydata){
				
				var prepicture = new Array();
				for(var i=0; i<mydata.length ;i++){
					prepicture[i]="<img src='"+mydata[i].deletepicture+"' class='file-preview-image' width='300px' height='200px'>";
				}
				
				var preconfig = new Array();
				for(var i=0; i<mydata.length ;i++){
					var tjson = {caption: mydata[i].deletepicture, // 展示的文件名 
									url:'${pageContext.request.contextPath}/congyezigezhengtupianDeleteFile', // 删除url 
									key: "key" , // 删除是Ajax向后台传递的参数 
									extra:{"fullpath": mydata[i].fullpath},	//传递删除额外参数
								}; 
					preconfig[i]=tjson;			
				} 
					
				$("#congyezigezhengtupian").fileinput({
			    	language: 'zh', //设置语言,还要导入对应的js文件 — —
			    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
			    	//dropZoneEnabled: false,//是否显示拖拽区域 
			        uploadUrl: '${pageContext.request.contextPath}/congyezigezhengtupianFileUpLoad', // 多图片必须设置图片上传的url路径 
			        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
			       	//showUploadedThumbs:false  ,  
			       	showUpload: false, //是否显示上传按钮
			       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
					
					initialPreview: prepicture,	//初始化图片
					/* initialPreviewAsData: true, */
					initialPreviewConfig : preconfig,	//初始化图片格式
					
					uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
						var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "congyezigezhengtupian"};
		            },
				}).on("filebatchselected", function(event, files) {//选择文件
					  $(this).fileinput("upload"); //上传选中的文件
				}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
						document.getElementById("mysubmit").disabled = true;
		        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
				  	    /* var json = data.response;  //解析数据  因为数据是json格式
				  	    alert(json[0].value);  	//数据是数组格式 */
				  	    document.getElementById("mysubmit").disabled = false;
				}).on("filepredelete", function(event, key) {  //删除文件中
					
				});  
				
			};
			
			$.ajax({
				type : "post",
				url  : '${pageContext.request.contextPath}/shenfenzhengtupianAjax' ,
				dataType : 'json',
				success : function(data){
					var datas = eval(data);	//格式化json数据
					showInitshenfenzhengtupian(datas);	//调用初始化方法
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					//没有图片初始化
					$("#shenfenzhengtupian").fileinput({
				    	language: 'zh', //设置语言,还要导入对应的js文件 — —
				    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
				    	//dropZoneEnabled: false,//是否显示拖拽区域 
				        uploadUrl: '${pageContext.request.contextPath}/shenfenzhengtupianFileUpLoad', // 多图片必须设置图片上传的url路径 
				        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
				       	//showUploadedThumbs:false  ,  
				       	showUpload: false, //是否显示上传按钮
				       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
						uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
							var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
	               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "shenfenzhengtupian"};
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
					
				}			
			});
			
			function showInitshenfenzhengtupian(mydata){
				
				var prepicture = new Array();
				for(var i=0; i<mydata.length ;i++){
					prepicture[i]="<img src='"+mydata[i].deletepicture+"' class='file-preview-image' width='300px' height='200px'>";
				}
				
				var preconfig = new Array();
				for(var i=0; i<mydata.length ;i++){
					var tjson = {caption: mydata[i].deletepicture, // 展示的文件名 
									url:'${pageContext.request.contextPath}/shenfenzhengtupianDeleteFile', // 删除url 
									key: "key" , // 删除是Ajax向后台传递的参数 
									extra:{"fullpath": mydata[i].fullpath},	//传递删除额外参数
								}; 
					preconfig[i]=tjson;			
				} 
					
				$("#shenfenzhengtupian").fileinput({
			    	language: 'zh', //设置语言,还要导入对应的js文件 — —
			    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
			    	//dropZoneEnabled: false,//是否显示拖拽区域 
			        uploadUrl: '${pageContext.request.contextPath}/shenfenzhengtupianFileUpLoad', // 多图片必须设置图片上传的url路径 
			        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
			       	//showUploadedThumbs:false  ,  
			       	showUpload: false, //是否显示上传按钮
			       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
					
					initialPreview: prepicture,	//初始化图片
					/* initialPreviewAsData: true, */
					initialPreviewConfig : preconfig,	//初始化图片格式
					
					uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
						var jsyxm = document.getElementsByName("jiashiyuanxingming")[0].value;		       		
               			return {"jiashiyuanxingming": jsyxm , "tupianleixing" : "shenfenzhengtupian"};
		            },
				}).on("filebatchselected", function(event, files) {//选择文件
					  $(this).fileinput("upload"); //上传选中的文件
				}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
						document.getElementById("mysubmit").disabled = true;
		        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
				  	    /* var json = data.response;  //解析数据  因为数据是json格式
				  	    alert(json[0].value);  	//数据是数组格式 */
				  	    document.getElementById("mysubmit").disabled = false;
				}).on("filepredelete", function(event, key) {  //删除文件中
					
				});  
				
			};
			
		});
	
		
		$(function(){
		
		    $('#basic2').selectpicker({
		      liveSearch: true,
		    });
		    
		    $('#basic3').selectpicker({
		      liveSearch: true,
		    });
			
			$("#guanbitishi").click(function(){
				$("#tupiantishi").hide();		    	
		    });
			
		});
				
	</script>	
</body>

</html>
