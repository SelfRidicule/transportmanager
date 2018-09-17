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
					<form name="usersform" action="${pageContext.request.contextPath}/#" method="post" onsubmit="">
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
							
							<input type="button" class="btn btn-primary" id="mySearch" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
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
							
							<select class="form-control" name="caozuoyuan" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">操作员</option>
								<c:forEach items="${userslist}" var="users">
									<option value="${users.usersid}">${users.username}</option>
						        </c:forEach>
							</select>
							
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
				        
						<table id="MyTable">
						   
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
		
		
		 	var MyTable;
		 	var rows = 10 ;
		 	
			 //初始化bootstrap-table的内容
			function InitMainTable () {
			    //记录页面bootstrap-table全局变量$table，方便应用
			    $table = $('#MyTable').bootstrapTable({
			        method: 'post',                      //请求方式（*）
			       	dataType:'json',
			       	url : '${pageContext.request.contextPath}/cheLiangJson',//要请求数据的文件路径
			       	dataField: "row",//这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
        			contentType: "application/x-www-form-urlencoded",
        			selectItemName : "toolbar1",	//设置复选框的name名称
        			idField : "id",	//设置复选框value对应哪个字段的值
			        //toolbar: '#toolbar',              //工具按钮用哪个容器
			        striped: true,                      //是否显示行间隔色
			        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			        pagination: true,                   //是否显示分页（*）
			        sortable: true,                     //是否启用排序
			        sortOrder: "desc",                   //排序方式
			        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
			        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
			        pageSize: rows,                     //每页的记录行数（*）
			        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
			        search: true,                      //是否显示表格搜索
			        strictSearch: true,
			        showColumns: true,                  //是否显示所有的列（选择显示的列）
			        showRefresh: true,                  //是否显示刷新按钮
			        minimumCountColumns: 1,             //最少允许的列数
			        clickToSelect: true,                //是否启用点击选中行
			        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
			        showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
			        cardView: false,                    //是否显示详细视图
			        detailView: false,                  //是否显示父子表
			        
			        //得到查询的参数
	                queryParams : function (params) {
	                	
	                    //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	                    var temp = {   
	                        pageSize : params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        					pageNumber : params.offset/params.limit+1, //当前页面,默认是上面设置的1(pageNumber)
	                        sort: params.sort,      //排序列名  
	                        sortOrder: params.order ,//排位命令（desc，asc） 
	                        chepaihao : $("input[name='chepaihao']").val(), 
	                        chexing : $("[name='chexing'] option:selected").val(), 
	                        cheliangleixing : $("[name='cheliangleixing'] option:selected").val(),
	                        pingpaixinghao : $("[name='pingpaixinghao'] option:selected").val(),
	                        zhuangtai : $("[name='zhuangtai'] option:selected").val(),
	                        caozuoyuan : $("[name='caozuoyuan'] option:selected").val()
	                        
	                    };
	                    return temp;
	                },
	                
	                onLoadSuccess: function () {
	                	
	                },
	                onLoadError: function () {
	                    showTips("数据加载失败！");
	                },
	                onDblClickRow: function (row, $element) {
	                    var id = row.ID;
	                    EditViewById(id, 'view');
	                },
			       	columns: [
			       		{field: 'checkStatus',checkbox: true}, //给复选框添加一个属性
			       		{field: 'id' ,title : '编号'},
						{field: 'chepaihao'  ,title : '车牌号码'},
						{field: 'jiayayuan' ,title : '驾押员'},
						{field: 'chexing' ,title : '车辆类型'},
						{field: 'cheliangleixing' ,title : '车辆品牌'},
						{field: 'zhuceriqi' ,title : '注册日期'},
						{field: 'zhuangtai' ,title : '状态'},
						{field: 'beizhu' ,title : '备注'},
						{field: 'caozuoyuan' ,title : '操作员'},
						
						{field: 'chezhuxingming' ,title : '车辆合作人姓名' , visible : false },
						{field: 'shoujihao' ,title : '手机号' , visible : false },
						{field: 'pingpaixinghao' ,title : '车辆型号' , visible : false },
						{field: 'shibiedaihao' ,title : '识别代号' , visible : false },
						{field: 'fadongjihao' ,title : '发动机号' , visible : false },
						{field: 'zongzhiliang' ,title : '总质量' , visible : false  },
						{field: 'zhengbeizhiliang' ,title : '整备质量' , visible : false },
						{field: 'hedingzhaizhiliang' ,title : '核定载质量' , visible : false },
						{field: 'zhunqianyingzongzhiliang' ,title : '准牵引总质量' , visible : false },
						{field: 'waikuochicun' ,title : '外廓尺寸' , visible : false },
						{field: 'cheliangdaoluyunshuzhenghao' ,title : '车辆道路运输证号' , visible : false },
						{field: 'nianshenriqi' ,title : '年审日期' , visible : false },
						{field: 'erjiweihuriqi' ,title : '二级维护日期' , visible : false },
						{field: 'daoluyunshuzhengnianshenriqi' ,title : '道路运输证年审日期' , visible : false },
						{field: 'yonghumiaoshu' ,title : '用户描述' , visible : false },
						{field: 'jingyingfanwei' ,title : '经营范围' , visible : false },
						{field: 'dengjipingdingriqi' ,title : '等级评定日期' , visible : false },
						{field: 'guantijianceriqi' ,title : '罐体检测日期' , visible : false },
						
						{field: 'shenfenzhenghao' ,title : '身份证号' , visible : false },
						{field: 'zhengshubianhao' ,title : '登记证书编号' , visible : false },
						{field: 'cheshenyanse' ,title : '车身颜色' , visible : false },
						{field: 'fadongjixinghao' ,title : '发动机型号' , visible : false },
						{field: 'ranliaozhonglei' ,title : '燃料种类' , visible : false },
						{field: 'pailiang' ,title : '排量' , visible : false },
						{field: 'gonglv' ,title : '功率' , visible : false },
						{field: 'changjiamingcheng' ,title : '厂家名称' , visible : false },
						{field: 'lunju' ,title : '轮距' , visible : false },
						{field: 'luntaishu' ,title : '轮胎数' , visible : false },
						{field: 'luntaiguige' ,title : '轮胎规格' , visible : false },
						{field: 'gangbantanhuangpianshu' ,title : '钢板弹簧片数' , visible : false },
						{field: 'zhouju' ,title : '轴距' , visible : false },
						{field: 'zhoushu' ,title : '轴数' , visible : false },
						{field: 'huoxiang' ,title : '货箱' , visible : false },	
						{field: 'cheliangfenzu' ,title : '车辆分组' , visible : false }     
			       	]
			    });
			};
			
			InitMainTable ();
			
			$("#mySearch").click(function(){
				$("#MyTable").bootstrapTable('refresh');
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
