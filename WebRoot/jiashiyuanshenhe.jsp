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
		
		function updatejiashiyuanshenhe(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateJiaShiYuanShenHe";
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
				<li class="active">驾驶员审核管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchJiaShiYuanShenHe" method="post" onsubmit="">
						<div style="">
							
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="jiashiyuanxingming" class="show-tick form-control">
							        <option value="">驾驶员姓名</option>
							        <c:forEach items="${jiashiyuanshenhelist}" var="jiashiyuanshenhe">
										<option value="${jiashiyuanshenhe.jiashiyuanxingming}">${jiashiyuanshenhe.jiashiyuanxingming}</option>
							        </c:forEach>
								</select>
							</div>
							
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic3" name="jiashicheliang" class="show-tick form-control">
							        <option value="">驾驶车辆</option>
							        <c:forEach items="${chelianglist}" var="cheliang">
										<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
							        </c:forEach>
								</select>
							</div>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearjiashiyuanshenhe" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							<select class="form-control" name="zhunjiachexing" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">准驾车型</option>
								<option value="大车">大车</option>
								<option value="小车">小车</option>
							</select>
							
							<select class="form-control" name="shenhezhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">审核状态</option>
								<option value="未审核">未审核</option>
								<option value="审核通过">审核通过</option>
								<option value="审核失败">审核失败</option>
							</select>
							
														
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '驾驶员审核' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="updatejiashiyuanshenhe()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">驾驶员审核</button>
							</c:if>
				        </c:forEach>
				        
				        <button type="button" onclick="exportExcel()" class="btn btn-success" style="float: left ; margin-top: 10px ; margin-left: 10px;">导出Excel</button>
					
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/jiaShiYuanShenHeJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="jiashiyuanxingming" data-sortable="true">驾驶员姓名</th>
						        <th data-field="jiashicheliang"  data-sortable="true">驾驶车辆</th>
						        <th data-field="shenhezhuangtai" data-sortable="true">审核状态</th>
						        <th data-field="shenfenzhenghao" data-sortable="true">身份证号</th>
						        <th data-field="zhunjiachexing" data-sortable="true">准驾车型</th>
						        <th data-field="caozuoyuan" data-sortable="true">操作员</th>
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
	             url: "${pageContext.request.contextPath}/exportJiaShiYuanShenHe",
	             data: {  },
	             dataType: "json",
	             success: function(data){
	             
	             	var option={};

			        option.fileName = '驾驶员审核Excel' 	//excel 文件名
			        option.datas=[
			          {
			          	sheetHeader:["编号","驾驶员姓名","驾驶车辆","审核状态","身份证号","准驾车型","操作员"
			          				],	//第一行 数据
			            sheetData:data, //数据
			            sheetName:'sheet', //sheet 名称
			            sheetFilter:['id','jiashiyuanxingming','jiashicheliang','shenhezhuangtai','shenfenzhenghao','zhunjiachexing','caozuoyuan'
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
