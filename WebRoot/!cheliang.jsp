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
	
	<script type="text/javascript">
		
		function addcheliang(){
			document.usersform.action="${pageContext.request.contextPath}"+"/jumpAddCheLiang";
		}
			
		function deletecheliang(){
			document.usersform.action="${pageContext.request.contextPath}"+"/deleteCheLiang";
		}	
		
		function updatecheliang(){
			document.usersform.action="${pageContext.request.contextPath}"+"/updateCheLiang";
		}
		
		function weiguidengji(){
			document.usersform.action="${pageContext.request.contextPath}"+"/weiguidengji";
		}
		
		function weiguichexiao(){
			document.usersform.action="${pageContext.request.contextPath}"+"/weiguichexiao";
		}
		
		
	</script>

</head>

<body>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">车辆管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchCheLiang" method="post" onsubmit="">
						<div style="">
							<input class="form-control" placeholder="车牌号码" name="chepaihao"   value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<select class="form-control" name="chexing" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">车辆类型</option>
								<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
									<c:if test="${cheliangguanli.type == '1' }">
										<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
									</c:if>
						        </c:forEach>
							</select>
							
							<select class="form-control" name="cheliangleixing" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">车辆品牌</option>
								<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
									<c:if test="${cheliangguanli.type == '2' }">
										<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
									</c:if>
						        </c:forEach>
							</select>
							
							<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="cheliangclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							<select class="form-control" name="pingpaixinghao" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">车辆型号</option>
								<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
									<c:if test="${cheliangguanli.type == '3' }">
										<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
									</c:if>
						        </c:forEach>
							</select>
							
							<select class="form-control" name="zhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">状态</option>
								<option value="可用">可用</option>
								<option value="禁用">禁用</option>
							</select>
							
							<input class="form-control" placeholder="操作员" name="caozuoyuan"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '车辆管理' && usersquanxian.xinzeng == '1' }">
								<button type="submit" onclick="addcheliang()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">车辆登记</button>
							</c:if>
				        </c:forEach>
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '车辆管理' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="updatecheliang()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">车辆修改</button>
								<button type="submit" onclick="deletecheliang()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">车辆注销</button>
								<button type="submit" onclick="weiguidengji()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">违规登记</button>
								<button type="submit" onclick="weiguichexiao()" class="btn btn-warning" style="float: left ; margin-top: 10px ; margin-left: 10px;">违规撤销</button>
							</c:if>
				        </c:forEach>
				        
				        <button type="button" onclick="exportExcel()" class="btn btn-success" style="float: left ; margin-top: 10px ; margin-left: 10px;">导出Excel</button>
				        
						<table data-toggle="table" data-url="${pageContext.request.contextPath}/cheLiangJson"  data-id-field="id"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" data-click-to-select="true">
						    <thead>
						    <tr>
						   		<th data-field="state" data-checkbox="true" >checkbox</th>
						        <th data-field="id" data-sortable="true">编号</th>
						        <th data-field="chepaihao"  data-sortable="true">车牌号码</th>
						        <th data-field="jiayayuan" data-sortable="true">驾押员</th>
						        <th data-field="chexing" data-sortable="true">车辆类型</th>
						        <th data-field="cheliangleixing" data-sortable="true">车辆品牌</th>
						        <th data-field="zhuceriqi" data-sortable="true">注册日期</th>
						        <th data-field="zhuangtai" data-sortable="true">状态</th>
						        <th data-field="beizhu" data-sortable="true">备注</th>
						        <th data-field="caozuoyuan" data-sortable="true">操作员</th>
						        
						         <th data-field="chezhuxingming" data-sortable="true" data-visible="false">车辆合作人姓名</th>
						         <th data-field="shoujihao" data-sortable="true" data-visible="false">手机号</th>
						         <th data-field="pingpaixinghao" data-sortable="true" data-visible="false">车辆型号</th>
						         <th data-field="shibiedaihao" data-sortable="true" data-visible="false">识别代号</th>
						         <th data-field="fadongjihao" data-sortable="true" data-visible="false">发动机号</th>
						         <th data-field="zongzhiliang" data-sortable="true" data-visible="false">总质量 </th>
						         <th data-field="zhengbeizhiliang" data-sortable="true" data-visible="false">整备质量</th>
						         <th data-field="hedingzhaizhiliang" data-sortable="true" data-visible="false">核定载质量</th>
						         <th data-field="zhunqianyingzongzhiliang" data-sortable="true" data-visible="false">准牵引总质量</th>
						         <th data-field="waikuochicun" data-sortable="true" data-visible="false">外廓尺寸</th>
						         <th data-field="cheliangdaoluyunshuzhenghao" data-sortable="true" data-visible="false">车辆道路运输证号</th>
						         <th data-field="nianshenriqi" data-sortable="true" data-visible="false">年审日期</th>
						         <th data-field="erjiweihuriqi" data-sortable="true" data-visible="false">二级维护日期</th>
						         <th data-field="daoluyunshuzhengnianshenriqi" data-sortable="true" data-visible="false">道路运输证年审日期</th>
						         <th data-field="yonghumiaoshu" data-sortable="true" data-visible="false">用户描述</th>
						         <th data-field="jingyingfanwei" data-sortable="true" data-visible="false">经营范围</th>
						         <th data-field="dengjipingdingriqi" data-sortable="true" data-visible="false">等级评定日期</th>
						         <th data-field="guantijianceriqi" data-sortable="true" data-visible="false">罐体检测日期</th>
						         
						         <th data-field="shenfenzhenghao" data-sortable="true" data-visible="false">身份证号</th>
						         <th data-field="zhengshubianhao" data-sortable="true" data-visible="false">登记证书编号</th>
						         <th data-field="cheshenyanse" data-sortable="true" data-visible="false">车身颜色</th>
						         <th data-field="fadongjixinghao" data-sortable="true" data-visible="false">发动机型号</th>
						         <th data-field="ranliaozhonglei" data-sortable="true" data-visible="false">燃料种类</th>
						         <th data-field="pailiang" data-sortable="true" data-visible="false">排量</th>
						         <th data-field="gonglv" data-sortable="true" data-visible="false">功率</th>
						         <th data-field="changjiamingcheng" data-sortable="true" data-visible="false">厂家名称</th>
						         <th data-field="lunju" data-sortable="true" data-visible="false">轮距</th>
						         <th data-field="luntaishu" data-sortable="true" data-visible="false">轮胎数</th>
						         <th data-field="luntaiguige" data-sortable="true" data-visible="false">轮胎规格</th>
						         <th data-field="gangbantanhuangpianshu" data-sortable="true" data-visible="false">钢板弹簧片数</th>
						         <th data-field="zhouju" data-sortable="true" data-visible="false">轴距</th>
						         <th data-field="zhoushu" data-sortable="true" data-visible="false">轴数</th>
						         <th data-field="huoxiang" data-sortable="true" data-visible="false">货箱</th>	
						         <th data-field="cheliangfenzu" data-sortable="true" data-visible="false">车辆分组</th>     
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

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="js/JsonExportExcel.min.js"></script>

	<script type="text/javascript">
	
		$(function(){
		
			$("#cheliangclear").click(function(){
			
				$("input[name='chepaihao']").val("");
				$("input[name='caozuoyuan']").val("");
				$("option").removeAttr("selected");
			});
		
		});
		
		
		function exportExcel(){
		
			$.ajax({
	             type: "POST",
	             url: "${pageContext.request.contextPath}/exportCheLiang",
	             data: {  },
	             dataType: "json",
	             success: function(data){
	             	//var dataArr = eval(data);
	             	
	             	var option={};

			        option.fileName = '车辆Excel' 	//excel 文件名
			        option.datas=[
			          {
			          	sheetHeader:["编号","车牌号","驾押员","车辆类型","车辆品牌","注册日期","状态","备注","操作员",
			          				 "车主姓名","手机号","车辆型号","识别代号","发动机号","总质量","整备质量","核定载质量",	
			          				 "准牵引总质量","外廓尺寸","车辆道路运输证号","年审日期","二级维护日期","道路运输证年审日期",
			          				 "用户描述","经营范围","等级评定日期","罐体检测日期",
			          				 "身份证号","登记证书编号","车身颜色","发动机型号","燃料种类","排量","功率","厂家名称",
			          				 "轮距","轮胎数","轮胎规格","钢板弹簧片数","轴距","轴数","货箱","车辆分组"
			          				],	//第一行 数据
			            sheetData:data, //数据
			            sheetName:'sheet', //sheet 名称
			            sheetFilter:['id','chepaihao','jiayayuan','chexing','cheliangleixing','zhuceriqi','zhuangtai','beizhu','caozuoyuan',
			            			 'chezhuxingming','shoujihao','pingpaixinghao','shibiedaihao','fadongjihao','zongzhiliang','zhengbeizhiliang','hedingzhaizhiliang',
			            			 'zhunqianyingzongzhiliang','waikuochicun','cheliangdaoluyunshuzhenghao','nianshenriqi','erjiweihuriqi','daoluyunshuzhengnianshenriqi',
			            			 'yonghumiaoshu','jingyingfanwei','dengjipingdingriqi','guantijianceriqi',
			            			 'shenfenzhenghao','zhengshubianhao','cheshenyanse','fadongjixinghao','ranliaozhonglei','pailiang','gonglv','changjiamingcheng',
			            			 'lunju','luntaishu','luntaiguige','gangbantanhuangpianshu','zhouju','zhoushu','huoxiang','cheliangfenzu'
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
