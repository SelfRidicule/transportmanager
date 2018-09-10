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
							
							<input type="button" class="btn btn-primary" id="mySearch" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
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
						
						<table id="MyTable">
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
			
				$("input[name='jiashiyuanxingming']").val("");
				$("option").removeAttr("selected");
				$("[name='jiashicheliang']").attr("selected", false);  
				$("[name='jiashicheliang']").selectpicker('refresh');
			});
		
			/* $('#special2').on('click', function () {
		      mySelect.find('option:disabled').prop('disabled', false);
		      mySelect.selectpicker('refresh');
		    }); */
		
			var MyTable;
		 	var rows = 10 ;
		 	
			 //初始化bootstrap-table的内容
			function InitMainTable () {
			    //记录页面bootstrap-table全局变量$table，方便应用
			    $table = $('#MyTable').bootstrapTable({
			        method: 'post',                      //请求方式（*）
			       	dataType:'json',
			       	url : '${pageContext.request.contextPath}/jiaShiYuanJson',//要请求数据的文件路径
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
	                        jiashicheliang : $("[name='jiashicheliang'] option:selected").val(), 
	                        jiashiyuanleixing : $("[name='jiashiyuanleixing'] option:selected").val(), 
	                        cheliangzhuangtai : $("[name='cheliangzhuangtai'] option:selected").val(), 
	                        zhunjiachexing : $("[name='zhunjiachexing'] option:selected").val(), 
	                        jiashiyuanxingming : $("input[name='jiashiyuanxingming']").val(), 
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
						{field: 'jiashiyuanxingming' ,title : '驾驶员姓名'},
						{field: 'xingbie' ,title : '性别'},
						{field: 'chushengriqi' ,title : '出生日期'},
						{field: 'dizhi' ,title : '地址'},
						{field: 'dianhua' ,title : '电话'},
						{field: 'mima' ,title : '密码'},
						{field: 'cheliangzhuangtai' ,title : '车辆状态'},
						
						{field: 'bumen' ,title : '所属部门' , visible : false},
						{field: 'danganbianhao' ,title : '档案编号' , visible : false},
						{field: 'shenfenzhenghao' ,title : '身份证号/驾驶证号' , visible : false},
						{field: 'jiashizhengbianhao' ,title : '驾驶证档案编号' , visible : false},
						{field: 'zhunjiachexing' ,title : '准驾车型' , visible : false},
						{field: 'chucilingzhengriqi' ,title : '初次领证日期' , visible : false},
						{field: 'jiashizhengnianshenriqi' ,title : '驾驶证年审到期日期' , visible : false} ,
						{field: 'zhengjianyouxiaoriqi' ,title : '驾驶证有效日期至' , visible : false},
						{field: 'jiashiyuanleixing' ,title : '驾驶员类型' , visible : false},
						{field: 'congyezigezhenghao' ,title : '从业资格证号' , visible : false},
						{field: 'congyezigeleibie' ,title : '从业资格类别' , visible : false},
						{field: 'congyezigeriqi' ,title : '从业资格证有效期至' , visible : false},
						{field: 'fazhengjiguan' ,title : '发证机关' , visible : false},
						{field: 'congyezigejixujiaoyushijian' ,title : '继续教育有效期起' , visible : false},
						{field: 'congyezigejixujiaoyushijianzhi' ,title : '继续教育有效期止' , visible : false},
						{field: 'congyezigechengxinkaoheshijian' ,title : '诚信考核到期日期' , visible : false},
						{field: 'beizhu' ,title : '备注' , visible : false}
			       		
			       	]
			    });
			};
			
			InitMainTable ();
			
			$("#mySearch").click(function(){
				$("#MyTable").bootstrapTable('refresh');
			});
		
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
