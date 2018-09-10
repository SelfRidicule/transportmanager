<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<script src="js/JsonExportExcel.min.js"></script>
	
	<script type="text/javascript">
		
		function myUpdate(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateJiaShiYuanNianShen";
		}	
		
		$(function(){
		
			$("#riqi1,#riqi2,#riqi3,#riqi4,#riqi5,#riqi6").jeDate({
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
				<li class="active">驾驶员年审管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchJiaShiYuanNianShen" method="post" onsubmit="">
						<div style="">
							
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="jiashiyuanxingming" class="show-tick form-control">
							        <option value="">驾驶员姓名</option>
							        <c:forEach items="${jiashiyuannianshenlist}" var="jiashiyuannianshen">
										<option value="${jiashiyuannianshen.jiashiyuanxingming}">${jiashiyuannianshen.jiashiyuanxingming}</option>
							        </c:forEach>
								</select>
							</div>
							
							<input class="form-control" placeholder="请输入身份证号" name="shenfenzhenghao"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<select class="form-control" name="nianshenzhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">年审状态</option>
								<option value="超期">超期</option>
								<option value="预警">预警</option>
								<option value="报警">报警</option>
							</select>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearjiashiyuanshenhe" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							
							<div style="clear: both;"></div>
							
							<input id="riqi1" class="form-control"  name="xiaoyuriqi"  placeholder="查询小于年审到期日期" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input id="riqi2" class="form-control"  name="dayuriqi"  placeholder="查询大于年审到期日期" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
														
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '驾驶员年审' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="myUpdate()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">驾驶员年审</button>
							</c:if>
				        </c:forEach>	
						
				        
				        <button type="button" onclick="exportExcel()" class="btn btn-success" style="float: left ; margin-top: 10px ; margin-left: 10px;">导出Excel</button>
				        
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/JiaShiYuanNianShenJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						    
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="jiashiyuanxingming" data-sortable="true">驾驶员姓名</th>
						        <th data-field="nianshenzhuangtai"  data-sortable="true">年审状态</th>
						        
						        <th data-field="chepaihao" data-sortable="true">驾驶车辆</th>
						        
						        <th data-field="congyezigeleibie" data-sortable="true" >从业资格类别</th>
						        <th data-field="shenfenzhenghao" data-sortable="true" >身份证号</th>
						        
						        <th data-field="zhunjiachexing" data-sortable="true" >准驾车型</th>
						         
						        <th data-field="jiashizhengnianshenriqi" data-sortable="true" >驾驶证年审到期日期 </th>
						          
						        <th data-field="zhengjianyouxiaoriqi" data-sortable="true" >驾驶证有效日期至</th>  
						        
						        <th data-field="congyezigeriqi" data-sortable="true" >从业资格证有效期至</th>
						        
						        <th data-field="congyezigejixujiaoyushijian" data-sortable="true" >继续教育有效期起</th>
						        <th data-field="congyezigejixujiaoyushijianzhi" data-sortable="true" >继续教育有效期止</th>
						        
						        <th data-field="congyezigechengxinkaoheshijian" data-sortable="true" >诚信考核到期日期</th>
						         
						    </tr>
						    </thead>
						</table>
					</div>
					</form>
					<!-- 查询 修改 表单 !-->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->


	<script type="text/javascript">
	
		$(function(){
		
			$("#clearjiashiyuanshenhe").click(function(){
			
				$("input[name='chaxunxiaoyudaoqiriqi']").val("");
				$("input[name='chaxundayudaoqiriqi']").val("");
				$("option").removeAttr("selected");		
			});
		
		
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
		    });
		    
			 $('#basic3').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
		    });		    
			
		});
	
		function exportExcel(){
		
			$.ajax({
	             type: "POST",
	             url: "${pageContext.request.contextPath}/exportJiaShiYuanNianShen",
	             data: {  },
	             dataType: "json",
	             success: function(data){
	             
	             	var option={};

			        option.fileName = '驾驶员年审Excel' 	//excel 文件名
			        option.datas=[
			          {
			          	sheetHeader:["编号","驾驶员姓名","年审状态","驾驶车辆","从业资格类别","身份证号",
			          				 "准驾车型","驾驶证年审到期日期","驾驶证有效日期至","从业资格证有效期至",
			          				 "继续教育有效期起","继续教育有效期止","诚信考核到期日期"
			          				],	//第一行 数据
			            sheetData:data, //数据
			            sheetName:'sheet', //sheet 名称
			            sheetFilter:['id','jiashiyuanxingming','nianshenzhuangtai','chepaihao','congyezigeleibie','shenfenzhenghao',
			            			 'zhunjiachexing','jiashizhengnianshenriqi','zhengjianyouxiaoriqi','congyezigeriqi',
			            			 'congyezigejixujiaoyushijian','congyezigejixujiaoyushijianzhi','congyezigechengxinkaoheshijian'
			            			],	//过滤数据
			          }
			        ];
			        var toExcel=new ExportJsonExcel(option);
			        toExcel.saveExcel();
			        
	             }
	             
         	});
			
		}
	
	</script>
	
</body>

</html>
