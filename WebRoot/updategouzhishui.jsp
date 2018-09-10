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
	
	
	<script type="text/javascript" src="laydate/laydate.js" ></script>
	<script type="text/javascript">
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
				<li class="active">修改 材料收集、购置税办理、临牌办理、车辆行驶证办理</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/updateGouZhiShui" onsubmit="return test()" method="post" enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆一致性证书
								<c:if test="${singlegouzhishui.yizhixing != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="yizhixing" value="">
						<c:if test="${singlegouzhishui.yizhixingshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="yizhixingshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.yizhixingshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="yizhixingshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆合格证
								<c:if test="${singlegouzhishui.hegezheng != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="hegezheng" value="">
						<c:if test="${singlegouzhishui.hegezhengshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="hegezhengshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.hegezhengshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="hegezhengshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆四联发票
								<c:if test="${singlegouzhishui.silianfapiao != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="silianfapiao" value="">
						<c:if test="${singlegouzhishui.silianfapiaoshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="silianfapiaoshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.silianfapiaoshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="silianfapiaoshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆交强险正副本和标贴
								<c:if test="${singlegouzhishui.jiaoqiangxian != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="jiaoqiangxian" value="">
						<c:if test="${singlegouzhishui.jiaoqiangxianshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="jiaoqiangxianshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.jiaoqiangxianshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="jiaoqiangxianshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>临时牌证
								<c:if test="${singlegouzhishui.linshipaizheng != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="linshipaizheng" value="">
						<c:if test="${singlegouzhishui.linshipaizhengshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="linshipaizhengshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.linshipaizhengshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="linshipaizhengshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车载终端型号
								<c:if test="${singlegouzhishui.zhongduanxinghao != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="zhongduanxinghao" value="">
						<c:if test="${singlegouzhishui.zhongduanxinghaoshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="zhongduanxinghaoshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.zhongduanxinghaoshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="zhongduanxinghaoshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆购置税证明
								<c:if test="${singlegouzhishui.gouzhishui != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="gouzhishui" value="">
						<c:if test="${singlegouzhishui.gouzhishuishouji == '已收集' }">
							<input type="checkbox" value="已收集" name="gouzhishuishouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.gouzhishuishouji != '已收集' }">
							<input type="checkbox" value="已收集" name="gouzhishuishouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆行驶证
								<c:if test="${singlegouzhishui.xingshizheng != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="xingshizheng" value="">
						<c:if test="${singlegouzhishui.xingshizhengshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="xingshizhengshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.xingshizhengshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="xingshizhengshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆登记证书
								<c:if test="${singlegouzhishui.dengjizheng != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="dengjizheng" value="">
						<c:if test="${singlegouzhishui.dengjizhengshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="dengjizhengshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.dengjizhengshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="dengjizhengshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶人员安驾证明
								<c:if test="${singlegouzhishui.anjiazheng != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="anjiazheng" value="">
						<c:if test="${singlegouzhishui.anjiazhengshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="anjiazhengshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.anjiazhengshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="anjiazhengshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆喷图标志
								<c:if test="${singlegouzhishui.pentubiaozhi != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>	
						</label>
						<input type="file" name="pentubiaozhi" value="">
						<c:if test="${singlegouzhishui.pentubiaozhishouji == '已收集' }">
							<input type="checkbox" value="已收集" name="pentubiaozhishouji" checked="checked">已收集
						</c:if>
						<c:if test="${singlegouzhishui.pentubiaozhishouji != '已收集' }">
							<input type="checkbox" value="已收集" name="pentubiaozhishouji" >已收集
						</c:if>
					</div>		
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>责任人 <span style="color: red;">*</span></label>
						<input name="zerenren" class="form-control" value="${singlegouzhishui.zerenren}" placeholder="请输入责任人" required="required" style="width: 40%"/>
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号<span style="color: red;">*&nbsp;</span><span id="chepaihaotishi" style="color: red; display: none;">存在相同车牌号</span></label>
						<input name="chepaihao" class="form-control" value="${singlegouzhishui.chepaihao}" onblur="existchepaihao()" placeholder="请输入车牌号"  required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/jumpGouZhiShui"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					<br/>
				</form>	
				<!-- end -->
					
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
	
	<script type="text/javascript">
	
		var mychepaihao = 1;
	
		//判断是否存在相同的车牌号
		function existchepaihao(){
		
			var chepaihao = document.getElementsByName("chepaihao")[0] ;
			
			$.ajax({
	             type: "POST",
	             url: "${pageContext.request.contextPath}/existChePaiHao",
	             data: { 'chepaihao' : chepaihao.value },
	             dataType: "json",
	             success: function(data){
	             	var datas = eval(data);
	             	
	             	if( "err" == datas[0].flag ){
	             		chepaihao.style.borderColor = 'red';
	             		document.getElementById("chepaihaotishi").style.display = 'inline';
	             		
	             		mychepaihao = 0;
	             	}
	             	
	             	if( "success" == datas[0].flag ){
	             		chepaihao.style.borderColor = 'green';
	             		document.getElementById("chepaihaotishi").style.display = 'none';
	             		
	             		mychepaihao = 1;
	             	}
	             }
	             
         	});
			
		}
		
		
		//判断是否提交
		function test(){
			
			if( mychepaihao != 1 ){
				return false ;
			}
				
		}
		
	</script>
	
</body>

</html>
