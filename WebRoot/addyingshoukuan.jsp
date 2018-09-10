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
				<li class="active">营收款登记</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加车辆 -->
				<form name="myform" action="${pageContext.request.contextPath}/addYingShouKuan" onsubmit="" method="post">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>发票号<span style="color: red;">*</span></label>
						<input name="fapiaohao" class="form-control" value="${singleyingshoukuan.fapiaohao}" placeholder="请输入发票号" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>到账时间<span style="color: red;">*</span></label>
						<input name="daozhangshijian" onfocus="laydate(smalltime)" class="form-control" value="${singleyingshoukuan.daozhangshijian}" placeholder="请输入到账时间" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>税金<span style="color: red;">*</span></label>
						<input name="shuijin" class="form-control" value="${singleyingshoukuan.shuijin}" placeholder="请输入税金" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>开票时间</label>
						<input name="kaipiaoshijian" onfocus="laydate(smalltime)" class="form-control" value="${singleyingshoukuan.kaipiaoshijian}" placeholder="请输入开票时间" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>管理费<span style="color: red;">*</span></label>
						<input name="guanlifei" class="form-control" value="${singleyingshoukuan.guanlifei}" placeholder="请输入管理费" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>实付运费<span style="color: red;">*</span></label>
						<input name="shifuyunfei" class="form-control" value="${singleyingshoukuan.shifuyunfei}" placeholder="请输入实付运费" required="required"/>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>实发吨位<span style="color: red;">*</span></label>
						<input name="shifadunwei" class="form-control" value="${shifadunweistr}" onkeyup="hejijine()" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>单价<span style="color: red;">*</span></label>
						<input name="danjia" class="form-control" value="${danjiastr}" onkeyup="hejijine()" required="required"/>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>营收<span style="color: red;">*</span></label>
						<input name="yingshou" class="form-control" value="${singleyingshoukuan.yingshou}" required="required"/>
					</div>
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>带空桶</label>
						<select class="form-control" name="daikongtong">
							<option value="">不带</option>
							<c:if test="${singleyingshoukuan.daikongtong == '带桶'}">
								<option value="带桶" selected="selected">带桶</option>
							</c:if>
							<c:if test="${singleyingshoukuan.daikongtong != '带桶'}">
								<option value="带桶">带桶</option>
							</c:if>
						</select>
					</div>			
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>领款时间<span style="color: red;">*</span></label>
						<input name="lingkuanshijian" onfocus="laydate(smalltime)" class="form-control" value="${singleyingshoukuan.lingkuanshijian}" placeholder="请输入领款时间"  required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>签收</label>
						<input name="qianshou" class="form-control" value="${singleyingshoukuan.qianshou}" placeholder="请输入签收" />
					</div>						
										
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">登记</button>
					<a href="${pageContext.request.contextPath}/yingshoukuan.jsp"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
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
		
		function hejijine(){
			var shifadunwei = $("input[name='shifadunwei']").val();
			var danjia   = $("input[name='danjia']").val();
			
			if(shifadunwei == ""){
				shifadunwei = 0;
			}
			if(danjia == ""){
				danjia = 0;
			}
			
			var money=0;			
			money = parseFloat(shifadunwei) * parseFloat(danjia); 
			$("input[name='yingshou']").val(money);
		}
		
	</script>	
</body>

</html>
