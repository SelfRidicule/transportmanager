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
	
	<script type="text/javascript">
		
		function deletezhengjian(){
			document.myform.action="${pageContext.request.contextPath}"+"/deleteZhengJian";
		}
			
		function updatezhengjian(){
			document.myform.action="${pageContext.request.contextPath}"+"/updateZhengJian";
		}	
		
		function addzhengjian(){
			document.myform.action="${pageContext.request.contextPath}"+"/jumpAddZhengJian";
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
				<li class="active">证件管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="myform" action="${pageContext.request.contextPath}/vagueSearchZhengJian" method="post" onsubmit="">
						<div style="">
						
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="chepaihao" class="show-tick form-control">
									<c:forEach items="${chelianglist}" var="cheliang">
										<c:if test="${cheliang.chepaihao == zhengjiansearchmodel.chepaihao }">
											<option value="${cheliang.chepaihao}" selected="selected">${cheliang.chepaihao}</option>
										</c:if>
							        </c:forEach>
							        <option value="">车牌号码</option>
							        <c:forEach items="${chelianglist}" var="cheliang">
										<c:if test="${cheliang.chepaihao != zhengjiansearchmodel.chepaihao }">
											<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
										</c:if>
							        </c:forEach>
								</select>
							</div>
							
							<select class="form-control" name="zhengjianzhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">证件状态</option>
								<option value="预警">预警</option>
								<option value="报警">报警</option>
								<option value="过期">过期</option>
								<option value="正常">正常</option>
							</select>
							<input class="form-control" placeholder="证件类型" name="zhengjianleixing"    value="${zhengjiansearchmodel.zhengjianleixing}" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearzhengjian" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							<input id="riqi1" class="form-control"    placeholder="查询小于到期日期" name="chaxunxiaoyudaoqiriqi"   value='<fmt:formatDate value="${zhengjiansearchmodel.chaxunxiaoyudaoqiriqi}" type='both'/>'  style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							<input id="riqi2" class="form-control"    placeholder="查询大于到期日期" name="chaxundayudaoqiriqi"     value='<fmt:formatDate value="${zhengjiansearchmodel.chaxundayudaoqiriqi}" type='both'/>'  style="width: 200px;  margin-left: 10px; margin-top: 15px; float: left;">
							<input class="form-control" placeholder="操作员" name="caozuoyuan"  value="${zhengjiansearchmodel.caozuoyuan}" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
					
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '证件管理' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addzhengjian()"    class="btn btn-warning" style="float: left ; margin-top: 10px ;">证件登记</button>
							</c:if>
				        </c:forEach>
				        
				        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '证件管理' && usersquanxian.weihu == '1' }"> 
								<button type="submit" onclick="updatezhengjian()" 	class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">证件到期处理</button>
								<!-- <button type="submit" onclick="deletezhengjian()" 	class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">作废</button> -->
							</c:if>
				        </c:forEach>
				        
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/zhengJianJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="zhengjianhaoma" data-sortable="true">证件号码</th>
						        <th data-field="zhengjianzhuangtai" data-sortable="true">证件状态</th>
						        <th data-field="chepaihao"  data-sortable="true">车牌号</th>
						        <th data-field="chezhuxingming" data-sortable="true">车主姓名</th>
						        <th data-field="shoujihao" data-sortable="true">手机号</th>
						        <th data-field="zhengjianleixing" data-sortable="true">证件类型</th>
						        <th data-field="daoqiriqi" data-sortable="true">到期日期</th>
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
		
			$("#clearzhengjian").click(function(){
			
				$("option").removeAttr("selected");
				$("input[name='zhengjianzhuangtai']").val("");
				$("input[name='zhengjianleixing']").val("");
				$("input[name='chaxunxiaoyudaoqiriqi']").val("");
				$("input[name='chaxundayudaoqiriqi']").val("");
				$("input[name='caozuoyuan']").val("");
									
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
	
	</script>
	
</body>

</html>
