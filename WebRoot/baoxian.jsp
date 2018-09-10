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
		
		function deletebaoxian(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteBaoXian";
		}
			
		function updatebaoxianchuli(){
			document.usersform.action="${pageContext.request.contextPath}"+"/updateBaoXianChuLi";
		}
		
		function updatebaoxian(){
			document.usersform.action="${pageContext.request.contextPath}"+"/updateBaoXian";
		}	
		
		function addbaoxian(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpAddBaoXian";
		}
		
		function shenxu(){
			document.usersform.action="${pageContext.request.contextPath}"+"/baoXianShengXu";
		}	
		
		function jiangxu(){
			document.usersform.action="${pageContext.request.contextPath}"+"/vagueSearchBaoXian";
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
				<li class="active">保险管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchBaoXian" method="post" onsubmit="">
						<div style="">
							
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="chepaihao" class="show-tick form-control">
									<c:forEach items="${chelianglist}" var="cheliang">
										<c:if test="${cheliang.chepaihao == baoxianparamodel.chepaihao }">
											<option value="${cheliang.chepaihao}" selected="selected">${cheliang.chepaihao}</option>
										</c:if>
							        </c:forEach>
							        <option value="">车牌号码</option>
							        <c:forEach items="${chelianglist}" var="cheliang">
										<c:if test="${cheliang.chepaihao != baoxianparamodel.chepaihao }">
											<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
										</c:if>
							        </c:forEach>
								</select>
							</div>
						
							<input class="form-control" placeholder="保单号" name="baodanhao" value="${baoxianparamodel.baodanhao}" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<select class="form-control" name="baoxianzhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">保险状态</option>
								<option value="预警">预警</option>
								<option value="报警">报警</option>
								<option value="过期">过期</option>
								<option value="正常">正常</option>
							</select>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearbaoxian" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							<input id="riqi1" class="form-control"    placeholder="查询小于到期日期" name="chaxunxiaoyudaoqiriqi"  value='<fmt:formatDate value="${baoxianparamodel.chaxunxiaoyudaoqiriqi}" type='both'/>'  style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							<input id="riqi2" class="form-control"    placeholder="查询大于到期日期" name="chaxundayudaoqiriqi"    value='<fmt:formatDate value="${baoxianparamodel.chaxundayudaoqiriqi}" type='both'/>' style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							
							<select class="form-control" name="baoxianleixing" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">保险类型</option>
								<option value="交强险">交强险</option>
								<option value="商业险">商业险</option>
								<option value="承运人责任险">承运人责任险</option>
								<option value="雇主责任险">雇主责任险</option>
								<option value="团体意外险">团体意外险</option>
								<option value="车船险">车船险</option>
							</select>
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '保险管理' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addbaoxian()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">保险登记</button>
							</c:if>
				        </c:forEach>
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '保险管理' && usersquanxian.weihu == '1' }">
								<!-- <button type="submit" onclick="updatebaoxianchuli()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">保险到期处理</button> -->
								<button type="submit" onclick="updatebaoxian()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">编辑</button>
								<button type="submit" onclick="deletebaoxian()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">作废</button>
								<button type="submit" onclick="shenxu()" class="btn btn-danger" style="float: left ; margin-top: 10px ; margin-left: 10px;">升序</button>
								<button type="submit" onclick="jiangxu()" class="btn btn-danger" style="float: left ; margin-top: 10px ; margin-left: 10px;">降序</button>
							</c:if>
				        </c:forEach>
				        
				         <button type="button" onclick="exportExcel()" class="btn btn-success" style="float: left ; margin-top: 10px ; margin-left: 10px;">导出Excel</button>
				        
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/baoxianJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true"  data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="baodanhao" data-sortable="true">保单号</th>
						        <th data-field="chepaihao"  data-sortable="true">车牌号码</th>
						        <th data-field="baoxianzhuangtai" data-sortable="true">保险状态</th>
						        <th data-field="chezhuxingming" data-sortable="true">车辆合作人姓名</th>
						        <th data-field="chexing" data-sortable="true">车型</th>
						        <th data-field="leixing" data-sortable="true">保险类型</th>
						        <th data-field="toubaojine" data-sortable="true">保险费用</th>
						        <th data-field="daoqiriqi" data-sortable="true">到期日期</th>
						        <th data-field="baoxiangongsi" data-sortable="true">保险公司</th>
						        <th data-field="baoxianjine" data-sortable="true">保险金额</th>
						        <th data-field="banliriqi" data-sortable="true">办理日期</th>
						        <th data-field="dailigongsi" data-sortable="true">保险代理公司</th>
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
		
			$("#clearbaoxian").click(function(){
			
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
	             url: "${pageContext.request.contextPath}/exportBaoXian",
	             data: {  },
	             dataType: "json",
	             success: function(data){
	             
	             	var option={};

			        option.fileName = '保险Excel' 	//excel 文件名
			        option.datas=[
			          {
			          	sheetHeader:["编号","保单号","车牌号码","保险状态","车主姓名","车型",
			          				 "保险类型","保险费用","到期日期","保险公司","保险金额","办理日期","保险代理公司"
			          				],	//第一行 数据
			            sheetData:data, //数据
			            sheetName:'sheet', //sheet 名称
			            sheetFilter:['id','baodanhao','chepaihao','baoxianzhuangtai','chezhuxingming','chexing',
			            			 'leixing','toubaojine','daoqiriqi','baoxiangongsi','baoxianjine','banliriqi','dailigongsi'
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
