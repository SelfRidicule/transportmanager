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
	<link href="css/bootstrap-select.css" rel="stylesheet">
	<link href="css/datouwang.css" type="text/css" rel="stylesheet"  />
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	
	<script src="js/bootstrap/bootstrap-table.min.js"></script>
	<script src="js/bootstrap/bootstrap-table-mobile.min.js"></script>
	<script src="js/bootstrap/bootstrap-table-zh-CN.min.js"></script>
	
	<script type="text/javascript">
	
		var myId = "";
		var columnName = "";
	
		$(function () {
		    //1.初始化Table
		    var oTable = new TableInit();
		    oTable.Init();
		});
		
		var TableInit = function () {
    		var oTableInit = new Object();
		    //初始化Table
		    oTableInit.Init = function () {
		        $('#mytable').bootstrapTable({
		        	method: 'post',                      //请求方式（*）
		        	contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//这里我就加了个utf-8
		          	url: '${pageContext.request.contextPath}/yingShouKuanJsonAll',        		 //请求后台的URL（*）
		            dataType: "json", 					//数据类型
		           // toolbar: 'aaa',                //工具按钮用哪个容器
		           	selectItemName:'toolbar1',
		            idField: "id",  					//标识哪个字段为id主键  
		            striped: true,                      //是否显示行间隔色
		            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		            pagination: true,                   //是否显示分页（*）
		            sortable: true,                     //是否启用排序
		            sortOrder: "asc",                   //排序方式
		            queryParams: oTableInit.queryParams,//传递参数（*）
		            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
		            pageNumber:1,                       //初始化加载第一页，默认第一页
		            pageSize: 10,                       //每页的记录行数（*）
		            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
		            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		            strictSearch: true,
		            showColumns: true,                  //是否显示所有的列
		            showRefresh: true,                  //是否显示刷新按钮
		            minimumCountColumns: 1,             //最少允许的列数
		            clickToSelect: false,                //是否启用点击选中行
		          //  height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度
		            //uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
		            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		            cardView: false,                    //是否显示详细视图
		            detailView: false,                   //是否显示父子表
					columns: [
						{
							checkbox: true
						},
						{
							field: 'id',
							title: '序列'
						}, 
						{
							field: 'dingdanhao',
							title: '订单号'
						}, 
						{
							field: 'yunshushijian',
							title: '运输时间'
						}, 
						{
							field: 'chepaihao',
							title: '车牌号'
						}, 
						{
							field: 'chezhuxingming',
							title: '属地'
						}, 
						{
							field: 'fahuodanwei',
							title: '发货单位'
						}, 
						{
							field: 'huowumingcheng',
							title: '货物名称'
						}, 
						{
							field: 'shishoudunwei',
							title: '实收吨位'
						}, 
						{
							field: 'shifadunwei',
							title: '实发吨位'
						}, 
						{
							field: 'licheng',
							title: '里程'
						},
						{
							field: 'danjia',
							title: '单价'
						},
						{
							field: 'daikongtong',
							title: '带空桶'
						},
						{
							field: 'qidian',
							title: '起点'
						},
						{
							field: 'zhongdian',
							title: '终点'
						},
						{
							field: 'yingshou',
							title: '营收'
						},
						{
							field: 'daozhangshijian',
							title: '到账时间'
						},
						{
							field: 'fapiaohao',
							title: '发票号'
						},
						{
							field: 'kaipiaoshijian',
							title: '开票时间'
						},
						{
							field: 'shuijin',
							title: '税金'
						},
						{
							field: 'guanlifei',
							title: '管理费'
						},
						{
							field: 'daidianfei',
							title: '代垫费'
						},
						{
							field: 'shifuyunfei',
							title: '实付运费'
						},
						{
							field: 'zuchefei',
							title: '租车费'
						},
						{
							field: 'yewufei',
							title: '业务费'
						},
						{
							field: 'lingkuanshijian',
							title: '领款时间'
						},
						{
							field: 'kaipiaozhuangtai',
							title: '开票状态'
						},
						{
							field: 'jiesuanzhuangtai',
							title: '结算状态'
						},
						/* {
							field: 'kehudanwei',
							title: '客户单位'
						}, */
						{
							field: 'beizhu',
							title: '备注'
						}
					],
					formatLoadingMessage: function () {  
				    	return "请稍等，正在加载中...";  
				 	},  
					formatNoMatches: function () {  //没有匹配的结果  
					    return '无符合条件的记录';  
					},  
				    onLoadError: function (data) {  
				   		$('#reportTable').bootstrapTable('removeAll');  
				    },  
				  	onClickRow: function (row) {  
				   		
				 	},
				 	onClickCell: function (field, value, row, $element) {  
				 		
				 		if( "yingshou" == field 
				 		|| "daozhangshijian" == field 
				 		|| "fapiaohao" == field 
				 		|| "shuijin" == field 
				 		|| "guanlifei" == field 
				 		|| "kaipiaoshijian" == field 
				 		|| "lingkuanshijian" == field 
				 		|| "zuchefei" == field 
				 		|| "yewufei" == field 
				 		|| "shifuyunfei" == field 
				 		|| "shishoudunwei" == field 
				 		|| "shifadunwei" == field 
				 		|| "licheng" == field 
				 		|| "danjia" == field 
				 		|| "daikongtong" == field 
				 		|| "qidian" == field 
				 		|| "zhongdian" == field 
				 		|| "daidianfei" == field ){
				 		
				 			var shishoudunwei = row.shishoudunwei;
							(shishoudunwei == "") ? shishoudunwei="0" : shishoudunwei;
							document.getElementById('myshishoudunwei').value = shishoudunwei;
							
							var shifadunwei = row.shifadunwei;
							(shifadunwei == "") ? shifadunwei="0" : shifadunwei;
							document.getElementById('myshifadunwei').value = shifadunwei;
							
							var licheng = row.licheng;
							(licheng == "") ? licheng="0" : licheng;
							document.getElementById('mylicheng').value = licheng;
							
							var danjia = row.danjia;
							(danjia == "") ? danjia="0" : danjia;
							document.getElementById('mydanjia').value = danjia;
							
							var yingshou = row.yingshou;
							(yingshou == "") ? yingshou="0" : yingshou;
							document.getElementById('myyingshou').value = yingshou;
							
							var shuijin = row.shuijin;
							(shuijin == "") ? shuijin="0" : shuijin;
							document.getElementById('myshuijin').value = shuijin;
							
							var guanlifei = row.guanlifei ;
							(guanlifei == "") ? guanlifei="0" : guanlifei;
							document.getElementById('myguanlifei').value = guanlifei;
							
							var daidianfei = row.daidianfei;
							(daidianfei == "") ? daidianfei="0" : daidianfei;
							document.getElementById('mydaidianfei').value = daidianfei;
							
							var shifuyunfei = row.shifuyunfei;
							(shifuyunfei == "") ? shifuyunfei="0" : shifuyunfei;
							document.getElementById('myshifuyunfei').value = shifuyunfei;
							
							myId = row.id ;
							columnName = field ;
							
							document.getElementById('calculator').style.display="block" ;
				 		}
										 		
				 	} 
		        });
		    };
		
		    //得到查询的参数
		    oTableInit.queryParams = function (params) {
		        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		            limit: params.limit,   //页面大小
		            offset: params.offset,  //页码
		            departmentname: $("#txt_search_departmentname").val(),
		            statu: $("#txt_search_statu").val()
		        };
		        return temp;
		    };
		    return oTableInit;
		};
		
		/**
	 	 *	 确认
	 	 */
		function queren(){
	 		
	 		var value =  document.getElementById('myTxt').value; 
	 		
	 		if(value == ""){
	 			value = "0" ;
	 		}
	 		
	 		$(function(){
         		$.ajax({
		             type: "POST",
		             url: "${pageContext.request.contextPath}/ajaxUpdateYingShouKuan",
		             data: { "value" : value , "myId" : myId , "columnName" : columnName },
		             dataType: "json",
		             success: function(data){
		             	 $('#mytable').bootstrapTable('refresh');
	         		 }
         		});
    		});
	 		
	 		document.getElementById('calculator').style.display="none";
	 		
	 		document.getElementById('myTxt').value="";
	 		document.getElementById('myHistory').value="";
	 	}
		
	</script>
	
	<script type="text/javascript">
 	
	 	var myTxt  ;//计算字符	
	 	var myHistory  ;	//计算历史
	 	
	 	/**
	 	 * 初始化
	 	 */
	 	function init(){
	 		myTxt = document.getElementById('myTxt') ;
	 		myHistory = document.getElementById('myHistory');
	 	}
	 	
	 	/**
	 	 *	 全部清除
	 	 */
	 	function allClear(){
	 		myTxt.value='';
	 		myHistory.value='';
	 	}
	 	
	 	
	 	/**
	 	 *  带有数字的按钮
	 	 */
	 	function jisuan( value ){
	 		
	 		myTxt.value= myTxt.value+""+value;
	 		myHistory.value= myHistory.value+""+value;
	 		
	 	}
	 	
	 	/**
	 	 *  带有名称的按钮
	 	 */
	 	function aliasValue(myid,aliasName){
	 		
	 		var value = document.getElementById(myid).value;
	 		
	 		myTxt.value= myTxt.value+""+value;
	 		
	 		myHistory.value= myHistory.value+""+aliasName;
	 		
	 	}
	 	
	 	
	 	/**
	 	 * 运算符
	 	 */
	 	function operator(str,operatorStr){
	 		
	 		myTxt.value= myTxt.value+""+str;
	 		myHistory.value= myHistory.value+""+operatorStr;
	 		
	 	}
	 	
	 	
	 	/**
	 	 *  结果
	 	 */
	 	function result(){
	 		
	 		var value = eval('('+myTxt.value+')');
	 	
	 		value = value.toFixed(2);
	 		
	 		myTxt.value= value+"";
	 		myHistory.value= '结果' ;
	 		
	 	}
	 	
	 	function  myCancel(){
	 		document.getElementById('calculator').style.display="none" ;
	 	}
 	
 	</script>
	
</head>

<body onload="init()">
		
		<!-- 查询 修改 表单 -->
		<form name="usersform" action="${pageContext.request.contextPath}/vagueSearchYingShouKuanAll" method="post" onsubmit="" enctype="multipart/form-data">
			<div style="">
	
				<input class="form-control" placeholder="订单号" name="dingdanhao"  value="" style="width: 200px; margin-left: 30px; margin-top: 15px; float: left;">
				
				<div style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
					<select id="basic2" name="chepaihao" class="show-tick form-control">
				        <option value="">车牌号</option>
				        <c:forEach items="${chelianglist}" var="cheliang">
							<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
				        </c:forEach>
					</select>
				</div>						
				
				<input class="form-control" placeholder="货物名称" name="huowumingcheng"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
				
				<input type="submit" class="btn btn-primary" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="查找"/>
				<input type="button" class="btn btn-info" id="myclear" style="float: left; margin-left: 10px; margin-top: 15px; width: 70px;" value="清空"/>
				
				<div style="clear: both;"></div>
				
				<select class="form-control" name="yingshoukuanzhuangtai" style="width: 200px; margin-left: 30px; margin-top: 15px; float: left;">
			        <option value="">所有开票</option>
			        <option value="未开票">未开票</option>
			        <option value="已开票">已开票</option>
				</select>
				
				<select class="form-control" name="jiesuanzhuangtai" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
			        <option value="">所有结算</option>
			        <option value="未结算">未结算</option>
			        <option value="已结算">已结算</option>
				</select>
				
				<input class="form-control" placeholder="客户单位" name="kehudanwei"  value="" style="width: 200px; margin-left: 10px; margin-top: 15px; float: left;">
				
				<div style="clear: both;"></div>							
			</div>
		
		<!-- 水平线 -->
		<div class="panel-body">
			
			<!-- 计算框 -->
			<div id="calculator" style=" position:absolute ; position:fixed; margin-left: 30% ; display:none ; z-index: 10" >
		
				<!-- Screen and clear key -->
			
				<div class="top">
					
					<span class="clear" onclick="allClear()">C</span>
					
					<!-- 输入框 -->
					<!--<div class="screen"></div>-->
					<input id="myTxt" class="screen" />
			
				</div>
			
				<div class="keys">
			
					<!-- operators and other keys -->
			
					<span onclick="aliasValue('myshishoudunwei','实收吨位')">实收吨位</span>
			
					<span onclick="aliasValue('myshifadunwei','实发吨位')">实发吨位</span>
			
					<span onclick="aliasValue('mylicheng','里程')">里程</span>
			
					<span onclick="aliasValue('mydanjia','单价')">单价</span>
			
					<span onclick="aliasValue('myyingshou','营收')">营收</span>
			
					<span onclick="aliasValue('myshuijin','税金')">税金</span>
			
					<span onclick="aliasValue('myguanlifei','管理费')">管理费</span>
			
					<span onclick="aliasValue('mydaidianfei','代垫费')">代垫费</span>
			
					<span onclick="aliasValue('myshifuyunfei','实付运费')">实付运费</span>
					
					<div style="clear: both;"></div>
					
					<span onclick="jisuan(1)">1</span>
					<span onclick="jisuan(2)">2</span>
					<span onclick="jisuan(3)">3</span>
					<span onclick="jisuan(4)">4</span>
					<span onclick="jisuan(5)">5</span>
					<span class="operator" onclick="jisuan('(')">(</span>
					
					<div style="clear: both;"></div>
					
					<span onclick="jisuan(6)">6</span>
					<span onclick="jisuan(7)">7</span>
					<span onclick="jisuan(8)">8</span>
					<span onclick="jisuan(9)">9</span>
					<span onclick="jisuan(0)">0</span>
					<span class="operator" onclick="jisuan(')')">)</span>
					
					<div style="clear: both;"></div>
					
					<span onclick="jisuan('.')">.</span>
					
					<span class="operator" style="font-size: 20px;" onclick="operator('+','+')">+</span>
					<span class="operator" style="font-size: 14px;" onclick="operator('-','-')">—</span>
					<span class="operator" style="font-size: 20px;" onclick="operator('*','x')">x</span>
					<span class="operator" style="font-size: 20px;" onclick="operator('/','÷')">÷</span>
					
					<span class="eval"     style="font-size: 20px;" onclick="result()">=</span>
					
					<input id="myshishoudunwei" value="0" style="display: none;"/>
					<input id="myshifadunwei"  	value="0" style="display: none;"/>
					<input id="mylicheng" 		value="0" style="display: none;"/>
					<input id="mydanjia" 		value="0" style="display: none;"/>
					<input id="myyingshou" 		value="0" style="display: none;"/>
					<input id="myshuijin" 		value="0" style="display: none;"/>
					<input id="myguanlifei" 	value="0" style="display: none;"/>
					<input id="mydaidianfei" 	value="0" style="display: none;"/>
					<input id="myshifuyunfei" 	value="0" style="display: none;"/>
					
					
					<div style="clear: both;"></div>
					<label style="">操作记录</label>
					<div style="clear: both;"></div>
					
					<input id="myHistory" class="history"  value="" />
					
					<span style="margin-left: 6px; background-color:#1a1a1a;" onclick="queren()">确认</span>
					
					<div style="clear: both;"></div>
					
					<span class="clear" onclick="myCancel()" style="float: right;" >取消</span>
					
				</div>
		
			</div>
			
			<table id="mytable">
			
			</table>
			
			
		</div>
		
		</form>
		<!-- 查询 修改 表单 !-->


	

	<script type="text/javascript">
		
		$(function(){
		
			$("#myclear").click(function(){
				$("input[name='dingdanhao']").val("");
				$("input[name='huowumingcheng']").val("");
				$("option").removeAttr("selected");
			});
			
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
		    });
		    
		});
		
	
	</script>
	
</body>

</html>
