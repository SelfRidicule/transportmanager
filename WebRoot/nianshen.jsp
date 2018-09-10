<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<link href="css/bootstrap-select.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/jedate.css" rel="stylesheet">
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
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
			
		function updatenianshen(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateNianShen";
		}
		
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
				<li class="active">年审</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchNianShen" method="post" onsubmit="">
						<div style="">
						
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="chepaihao" class="show-tick form-control">
						           <option value="">车牌号码</option>
							        <c:forEach items="${chelianglist}" var="cheliang">
										<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
							        </c:forEach>
						        </select>
							</div> 
							
							<select class="form-control" name="nianshenzhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">年审状态</option>
								<option value="预警">预警</option>
								<option value="报警">报警</option>
								<option value="过期">过期</option>
								<option value="正常">正常</option>
							</select>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearnianshen" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							<input id="riqi1" class="form-control"    placeholder="查询小于到期日期" name="chaxunxiaoyudaoqiriqi"  value=""  style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							<input id="riqi2" class="form-control"    placeholder="查询大于到期日期" name="chaxundayudaoqiriqi"    value=""  style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
					
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '年审管理' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="updatenianshen()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">年审到期处理</button>
							</c:if>
				        </c:forEach>
					
						<button type="button" onclick="exportExcel()" class="btn btn-success" style="float: left ; margin-top: 10px ; margin-left: 10px;">导出Excel</button>
					
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/nianShenJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="chepaihao"  data-sortable="true">车牌号码</th>
						        <th data-field="nianshenzhuangtai" data-sortable="true">年审状态</th>
						        <th data-field="chezhuxingming" data-sortable="true">车主姓名</th>
						        <th data-field="shoujihao" data-sortable="true">手机号</th>
						       <!--  <th data-field="nianshenriqi" data-sortable="true">年审日期</th> -->
						        <th data-field="daoqiriqi" data-sortable="true">行驶证年审到期日期</th>
						        <th data-field="daoluriqi" data-sortable="true">道路运输证年审到期日期</th>
						        <th data-field="erjiriqi" data-sortable="true">二级维护到期日期</th>
						        <th data-field="dengjiriqi" data-sortable="true">等级评定到期日期</th>
						        <th data-field="guantidaoqiriqi" data-sortable="true">罐体到期日期</th>
						        <th data-field="caozuoyuan" data-sortable="true">操作员</th>
						        <th data-field="caozuoriqi" data-sortable="true">操作日期</th>
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
		
			$("#clearnianshen").click(function(){
			
				$("input[name='chaxunxiaoyudaoqiriqi']").val("");
				$("input[name='chaxundayudaoqiriqi']").val("");
				$("option").removeAttr("selected");		
			});
			
			$('#special2').on('click', function () {
		      mySelect.find('option:disabled').prop('disabled', false);
		      mySelect.selectpicker('refresh');
		    });
		
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
		    });
		
		});
	
		function exportExcel(){
		
			$.ajax({
	             type: "POST",
	             url: "${pageContext.request.contextPath}/exportNianShen",
	             data: {  },
	             dataType: "json",
	             success: function(data){
	             
	             	var option={};

			        option.fileName = '年审Excel' 	//excel 文件名
			        option.datas=[
			          {
			          	sheetHeader:["编号","车牌号码","年审状态","车主姓名","手机号",
			          				 "行驶证年审到期日期","道路运输证年审到期日期","二级维护到期日期","等级评定到期日期","罐体到期日期",
			          				 "操作员","操作日期"
			          				],	//第一行 数据
			            sheetData:data, //数据
			            sheetName:'sheet', //sheet 名称
			            sheetFilter:['id','chepaihao','nianshenzhuangtai','chezhuxingming','shoujihao',
			            			 'daoqiriqi','daoluriqi','erjiriqi','dengjiriqi','guantidaoqiriqi',
			            			 'caozuoyuan','caozuoriqi'
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
