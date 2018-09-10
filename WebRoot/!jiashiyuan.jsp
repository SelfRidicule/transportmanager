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
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="js/JsonExportExcel.min.js"></script>

	
	<script type="text/javascript">
		
		function deletejiashiyuan(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteJiaShiYuan";
		}
			
		function updatejiashiyuan(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpUpdateJiaShiYuan";
		}	
		
		function jumpaddbaoxian(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpAddJiaShiYuan";
		}
		
		var smalltime = {
		  format: 'YYYY-MM-DD hh:mm:ss',
		  istime: true,
		};
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">驾驶员管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchJiaShiYuan" method="post" onsubmit="">
						<div style="">
							
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="jiashicheliang" class="show-tick form-control">
							        <option value="">驾驶车辆</option>
							        <c:forEach items="${chelianglist}" var="cheliang">
										<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
							        </c:forEach>
								</select>
							</div>
						
							<input class="form-control" placeholder="请输入驾驶员姓名" name="jiashiyuanxingming" value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<select class="form-control" name="jiashiyuanleixing" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">驾驶员类型</option>
								<option value="驾驶员">驾驶员</option>
								<option value="押运员">押运员</option>
								<option value="驾押员">驾押员</option>
							</select>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearbaoxian" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							<select class="form-control" name="cheliangzhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">车辆状态</option>
								<option value="已接单">已接单</option>
								<option value="空闲">空闲</option>
							</select>
							
							<select class="form-control" name="zhunjiachexing" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">准驾车型</option>
								<option value="大车">大车</option>
								<option value="小车">小车</option>
							</select>
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
					
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '驾驶员资料' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="jumpaddbaoxian()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">驾驶员登记</button>
							</c:if>
				        </c:forEach>
				        
				        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '驾驶员资料' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="updatejiashiyuan()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">编辑</button>
								<button type="submit" onclick="deletejiashiyuan()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">作废</button>
							</c:if>
				        </c:forEach>
				        
				        <button type="button" onclick="exportExcel()" class="btn btn-success" style="float: left ; margin-top: 10px ; margin-left: 10px;">导出Excel</button>
						
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/jiaShiYuanJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="jiashiyuanxingming" data-sortable="true">驾驶员姓名</th>
						        <th data-field="xingbie"  data-sortable="true">性别</th>
						        <th data-field="chushengriqi" data-sortable="true">出生日期</th>
						        <th data-field="dizhi" data-sortable="true">地址</th>
						        <th data-field="dianhua" data-sortable="true">电话</th>
						        <th data-field="mima" data-sortable="true">密码</th>
						        <th data-field="cheliangzhuangtai" data-sortable="true">车辆状态</th>
						        
						         <th data-field="bumen" data-sortable="true" data-visible="false">所属部门</th>
						         <th data-field="danganbianhao" data-sortable="true" data-visible="false">档案编号</th>
						         <th data-field="shenfenzhenghao" data-sortable="true" data-visible="false">身份证号/驾驶证号</th>
						         <th data-field="jiashizhengbianhao" data-sortable="true" data-visible="false">驾驶证档案编号</th>
						         <th data-field="zhunjiachexing" data-sortable="true" data-visible="false">准驾车型</th>
						         <th data-field="chucilingzhengriqi" data-sortable="true" data-visible="false">初次领证日期</th>
						         <th data-field="jiashizhengnianshenriqi" data-sortable="true" data-visible="false">驾驶证年审到期日期 </th>
						         <th data-field="zhengjianyouxiaoriqi" data-sortable="true" data-visible="false">驾驶证有效日期至</th>
						         <th data-field="jiashiyuanleixing" data-sortable="true" data-visible="false">驾驶员类型</th>
						         <th data-field="congyezigezhenghao" data-sortable="true" data-visible="false">从业资格证号</th>
						         <th data-field="congyezigeleibie" data-sortable="true" data-visible="false">从业资格类别</th>
						         <th data-field="congyezigeriqi" data-sortable="true" data-visible="false">从业资格证有效期至</th>
						         <th data-field="fazhengjiguan" data-sortable="true" data-visible="false">发证机关</th>
						         <th data-field="congyezigejixujiaoyushijian" data-sortable="true" data-visible="false">继续教育有效期起</th>
						         <th data-field="congyezigejixujiaoyushijianzhi" data-sortable="true" data-visible="false">继续教育有效期止</th>
						         <th data-field="congyezigechengxinkaoheshijian" data-sortable="true" data-visible="false">诚信考核到期日期</th>
						         <th data-field="beizhu" data-sortable="true" data-visible="false">备注</th>
						         
						         
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
		
			/* $('#special2').on('click', function () {
		      mySelect.find('option:disabled').prop('disabled', false);
		      mySelect.selectpicker('refresh');
		    }); */
		
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
		    });
			
		});
	
	
		function exportExcel(){
		
			$.ajax({
	             type: "POST",
	             url: "${pageContext.request.contextPath}/exportJiaShiYuan",
	             data: {  },
	             dataType: "json",
	             success: function(data){
	             
	             	var option={};

			        option.fileName = '驾驶员Excel' 	//excel 文件名
			        option.datas=[
			          {
			          	sheetHeader:["编号","驾驶员姓名","性别","出生日期","地址","电话","密码","车辆状态",
			          				 "所属部门","档案编号","身份证号/驾驶证号","驾驶证档案编号","准驾车型","初次领证日期","驾驶证年审到期日期","驾驶证有效日期至",
			          				 "驾驶员类型","从业资格证号","从业资格类别","从业资格证有效期至","发证机关","继续教育有效期起","继续教育有效期止","诚信考核到期日期","备注"
			          				],	//第一行 数据
			            sheetData:data, //数据
			            sheetName:'sheet', //sheet 名称
			            sheetFilter:['id','jiashiyuanxingming','xingbie','chushengriqi','dizhi','dianhua','mima','cheliangzhuangtai',
			            			 'bumen','danganbianhao','shenfenzhenghao','jiashizhengbianhao','zhunjiachexing','chucilingzhengriqi','jiashizhengnianshenriqi','zhengjianyouxiaoriqi',
			            			 'jiashiyuanleixing','congyezigezhenghao','congyezigeleibie','congyezigeriqi','fazhengjiguan','congyezigejixujiaoyushijian','congyezigejixujiaoyushijianzhi','congyezigechengxinkaoheshijian','beizhu'
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
