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
	
	<script type="text/javascript">
		
		function updateyundanshenhe(){
			document.usersform.action="${pageContext.request.contextPath}"+"/updateYunDanShenHe";
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
				<li class="active">运单审核管理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
					
					<!-- 查询 修改 表单 -->
					<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchYunDanShenHe" method="post" onsubmit="">
						<div style="">

							<input class="form-control" placeholder="请输入订单号" name="dingdanhao" value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<select class="form-control" name="yundanzhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<option value="">运单状态</option>
								<option value="未分配">未分配</option>
								<option value="已分配">已分配</option>
								<option value="审批中">审批中</option>
								<option value="未通过">未通过</option>
								<option value="待接单">待接单</option>
								<option value="已接单">已接单</option>
								<option value="拒接接单">拒接接单</option>
								<option value="运输结束">运输结束</option>
								<option value="运单完成">运单完成</option>
							</select>
							
							<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
								<select id="basic2" name="chepaihao" class="show-tick form-control">
							        <option value="">车牌号</option>
							        <c:forEach items="${chelianglist}" var="cheliang">
										<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
							        </c:forEach>
								</select>
							</div>
							
							<input type="button" class="btn btn-primary" id="mySearch" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
							<input type="button" class="btn btn-info" id="clearbaoxian" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
							<div style="clear: both;"></div>
							
							<input class="form-control" placeholder="请输入起点" name="qidian" value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input class="form-control" placeholder="请输入终点" name="zhongdian" value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<input class="form-control" placeholder="请输入货物名称" name="huowumingcheng" value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
							
							<div style="clear: both;"></div>
							
						</div>
					
					<!-- 水平线 -->
					
					<div class="panel-body">
						
						<c:forEach items="${usersquanxianlist}" var="usersquanxian">
							<c:if test="${usersquanxian.quanxianbumen == '运单审核' && usersquanxian.weihu == '1' }">
								<button type="submit" onclick="updateyundanshenhe()" class="btn btn-warning" style="float: left ; margin-top: 10px ;">运单审核</button>
							</c:if>
				        </c:forEach>
				        <div style="float: left ; margin-top: 10px; margin-left: 10px;color: red;line-height:30px;font-size: 16px">${yundanshenheerr}</div>
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
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script type="text/javascript" src="laydate/laydate.js" ></script>

	<script type="text/javascript">
	
		$(function(){
		
			$("#clearbaoxian").click(function(){
				$("input[name='dingdanhao']").val("");
				$("input[name='qidian']").val("");
				$("input[name='zhongdian']").val("");
				$("input[name='huowumingcheng']").val("");
				$("option").removeAttr("selected");
				$("[name='chepaihao']").attr("selected", false);  
				$("[name='chepaihao']").selectpicker('refresh');
			});
		
		
			var MyTable;
		 	var rows = 10 ;
		 	
			 //初始化bootstrap-table的内容
			function InitMainTable () {
			    //记录页面bootstrap-table全局变量$table，方便应用
			    $table = $('#MyTable').bootstrapTable({
			        method: 'post',                      //请求方式（*）
			       	dataType:'json',
			       	url : '${pageContext.request.contextPath}/YunDanShenHeJson',//要请求数据的文件路径
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
	                        
	                        dingdanhao : $("input[name='dingdanhao']").val(), 
	                        yundanzhuangtai : $("[name='yundanzhuangtai'] option:selected").val(), 
	                        chepaihao : $("[name='chepaihao'] option:selected").val(), 
	                        qidian : $("input[name='qidian']").val(),
	                        zhongdian : $("input[name='zhongdian']").val(),
	                        huowumingcheng : $("input[name='huowumingcheng']").val(),
	                        
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
						{field: 'dingdanhao' ,title : '订单号'},
						{field: 'yundanzhuangtai' ,title : '运单状态'},
						{field: 'jiashiyuan' ,title : '驾驶员'},
						{field: 'chepaihao' ,title : '车牌号'},
						{field: 'kehudanwei' ,title : '客户单位'},
						{field: 'qidian' ,title : '起点'},
						{field: 'zhongdian' ,title : '终点'},
						{field: 'yunshushijian' ,title : '运输时间'},
						{field: 'huowumingcheng' ,title : '货物名称'}
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
	
	</script>
	
</body>

</html>
