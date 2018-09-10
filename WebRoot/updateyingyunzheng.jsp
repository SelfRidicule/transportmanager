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
				<li class="active">修改材料收集、营运证办理、安全教育</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/updateYingYunZheng" onsubmit="" method="post" enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>罐体产品质量说明书
								<c:if test="${singleyingyunzheng.guantichanpin != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="guantichanpin">
						<c:if test="${singleyingyunzheng.guantichanpinshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="guantichanpinshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.guantichanpinshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="guantichanpinshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>二维与等评
								<c:if test="${singleyingyunzheng.erweiyudengjia != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="erweiyudengjia">
						<c:if test="${singleyingyunzheng.erweiyudengjiashouji == '已收集' }">
							<input type="checkbox" value="已收集" name="erweiyudengjiashouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.erweiyudengjiashouji != '已收集' }">
							<input type="checkbox" value="已收集" name="erweiyudengjiashouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆罐检查报告
								<c:if test="${singleyingyunzheng.cheliangguan != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="cheliangguan">
						<c:if test="${singleyingyunzheng.cheliangguanshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="cheliangguanshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.cheliangguanshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="cheliangguanshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>押运人员材料、劳动合同
								<c:if test="${singleyingyunzheng.yayuncailiao != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="yayuncailiao">
						<c:if test="${singleyingyunzheng.yayuncailiaoshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="yayuncailiaoshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.yayuncailiaoshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="yayuncailiaoshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>初次检测设施设备配备情况查验登记表
								<c:if test="${singleyingyunzheng.chucijiance != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="chucijiance">
						<c:if test="${singleyingyunzheng.chucijianceshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="chucijianceshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.chucijianceshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="chucijianceshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆照片
								<c:if test="${singleyingyunzheng.cheliangzhaopian != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="cheliangzhaopian">
						<c:if test="${singleyingyunzheng.cheliangzhaopianshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="cheliangzhaopianshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.cheliangzhaopianshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="cheliangzhaopianshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>燃料消耗达标车型核查表
								<c:if test="${singleyingyunzheng.ranshaoxiaohao != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="ranshaoxiaohao">
						<c:if test="${singleyingyunzheng.ranshaoxiaohaoshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="ranshaoxiaohaoshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.ranshaoxiaohaoshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="ranshaoxiaohaoshouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>承运人责任险保单
								<c:if test="${singleyingyunzheng.chengyunren != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="chengyunren">
						<c:if test="${singleyingyunzheng.chengyunrenshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="chengyunrenshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.chengyunrenshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="chengyunrenshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>整车装备外观检视及人工测量记录表
								<c:if test="${singleyingyunzheng.zhengchezhuangbei != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="zhengchezhuangbei">
						<c:if test="${singleyingyunzheng.zhengchezhuangbeishouji == '已收集' }">
							<input type="checkbox" value="已收集" name="zhengchezhuangbeishouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.zhengchezhuangbeishouji != '已收集' }">
							<input type="checkbox" value="已收集" name="zhengchezhuangbeishouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>岗前安全教育培训考核
								<c:if test="${singleyingyunzheng.gangqiananquan != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="gangqiananquan">
						<c:if test="${singleyingyunzheng.gangqiananquanshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="gangqiananquanshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.gangqiananquanshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="gangqiananquanshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>安全卡
								<c:if test="${singleyingyunzheng.anquanka != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="anquanka">
						<c:if test="${singleyingyunzheng.anquankashouji == '已收集' }">
							<input type="checkbox" value="已收集" name="anquankashouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.anquankashouji != '已收集' }">
							<input type="checkbox" value="已收集" name="anquankashouji" >已收集
						</c:if>
					</div>		
								
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆营运证
								<c:if test="${singleyingyunzheng.yingyunzheng != '#' }">
									<span style="color: red;">:已存在</span>
								</c:if>
						</label>
						<input type="file" name="yingyunzheng">
						<c:if test="${singleyingyunzheng.yingyunzhengshouji == '已收集' }">
							<input type="checkbox" value="已收集" name="yingyunzhengshouji" checked="checked">已收集
						</c:if>
						<c:if test="${singleyingyunzheng.yingyunzhengshouji != '已收集' }">
							<input type="checkbox" value="已收集" name="yingyunzhengshouji" >已收集
						</c:if>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>责任人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="zerenren" class="form-control" value="${singleyingyunzheng.zerenren}" placeholder="请输入责任人" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/jumpYingYunZheng"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
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
	
	<script>
		$('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });
		    
		$('#basic3').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });    
	</script>	
</body>

</html>
