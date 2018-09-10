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
		$(function(){
		
			$("#riqi1,#riqi2,#riqi3,#riqi4,#riqi5,#riqi6,#riqi7,#riqi8,#riqi9,#riqi10,#riqi11").jeDate({
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
				<li class="active">费用结算，费用及到期时间填写规范</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/addFeiYongJieSuan" onsubmit="" method="post" enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>交强险费用</label>
						<input name="jiaoqiangxian" class="form-control" placeholder="请输入交强险费用"  onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>交强险到期日期</label>
						<input id="riqi1" name="jiaoqiangxianshijian"  class="form-control" placeholder="请输入交强险到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>商业险费用</label>
						<input name="shangyexian" class="form-control" placeholder="请输入商业险费用" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>商业险到期日期</label>
						<input id="riqi2" name="shangyexianshijian"  class="form-control" placeholder="请输入商业险到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>雇主责任或团体险</label>
						<input name="guzhuhuotuanti" class="form-control" placeholder="请输入雇主责任或团体险" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>雇主责任或团体险到期日期</label>
						<input id="riqi3" name="guzhuhuotuantishijian"  class="form-control" placeholder="请输入雇主或团体到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>承运人保险</label>
						<input name="chengyunren" class="form-control" placeholder="请输入承运人保险" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>承运人保险到期日期</label>
						<input id="riqi4" name="chengyunrenshijian"  class="form-control" placeholder="请输入承运人保险到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆使用税</label>
						<input name="shiyongshui" class="form-control" placeholder="请输入车辆使用税" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆使用税到期日期</label>
						<input id="riqi5" name="shiyongshuishijian"  class="form-control" placeholder="请输入车辆使用税到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆购置税</label>
						<input name="gouzhishui" class="form-control" placeholder="请输入车辆购置税" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆购置税到期日期</label>
						<input id="riqi6" name="gouzhishuishijian"  class="form-control" placeholder="请输入车辆购置税到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车载终端安装和服务费用</label>
						<input name="zhongduananzhuang" class="form-control" placeholder="请输入车载终端安装和服务费用" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车载终端安装和服务费用到期日期</label>
						<input id="riqi7" name="zhongduananzhuangshijian"  class="form-control" placeholder="请输入车载终端安装到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>安全学习保证金</label>
						<input name="anquanxuexi" class="form-control" placeholder="请输入安全学习保证金" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>安全学习保证金到期日期</label>
						<input id="riqi8" name="anquanxuexishijian"  class="form-control" placeholder="请输入安全学习保证金到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>管理费用</label>
						<input name="guanlifeiyong" class="form-control" placeholder="请输入管理费用" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>管理费用到期日期</label>
						<input id="riqi9" name="guanlifeiyongshijian"  class="form-control" placeholder="请输入管理费用到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>预交保险费用</label>
						<input name="yujiaobaoxian" class="form-control" placeholder="请输入预交保险费用" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>预交保险费用到期日期</label>
						<input id="riqi10" name="yujiaobaoxianshijian"  class="form-control" placeholder="请输入预交保险费用到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>驾驶员保险</label>
						<input name="jiashiyuan" class="form-control" placeholder="请输入驾驶员保险" onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾驶员保险到期日期</label>
						<input id="riqi11" name="jiashiyuanshijian"  class="form-control" placeholder="请输入驾驶员保险到期日期"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>合计<span style="color: red;">*</span></label>
						<input name="heji" class="form-control" placeholder="自动合计"  required="required" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>财务收款人<span style="color: red;">*</span></label>
						<input name="shoukuanren" class="form-control" placeholder="请输入财务收款人" required="required"/>
					</div>			
					
						<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 70%; float: left; margin-left: 30px">
						<label>备注</label>
						<textarea class="form-control" rows="5" name="beizhu"></textarea>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">办理</button>
					<a href="${pageContext.request.contextPath}/jumpFeiYongJieSuan"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					<br/>
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	
	
	<script type="text/javascript">
		
		function hejijine(){
			var jiaoqiangxian = $("input[name='jiaoqiangxian']").val();
			var shangyexian   = $("input[name='shangyexian']").val();
			var guzhuhuotuanti = $("input[name='guzhuhuotuanti']").val();
			var chengyunren = $("input[name='chengyunren']").val();
			var shiyongshui = $("input[name='shiyongshui']").val();
			var gouzhishui = $("input[name='gouzhishui']").val();
			var zhongduananzhuang = $("input[name='zhongduananzhuang']").val();
			var anquanxuexi = $("input[name='anquanxuexi']").val();
			var guanlifeiyong = $("input[name='guanlifeiyong']").val();
			var yujiaobaoxian = $("input[name='yujiaobaoxian']").val();
			var jiashiyuan = $("input[name='jiashiyuan']").val();
			
			if(jiaoqiangxian == ""){
				jiaoqiangxian = 0;
			}
			if(shangyexian == ""){
				shangyexian = 0;
			}
			if(guzhuhuotuanti == ""){
				guzhuhuotuanti = 0;
			}
			if(chengyunren == ""){
				chengyunren = 0;
			}
			if(shiyongshui == ""){
				shiyongshui = 0;
			}
			if(gouzhishui == ""){
				gouzhishui = 0;
			}
			if(zhongduananzhuang == ""){
				zhongduananzhuang = 0;
			}
			if(anquanxuexi == ""){
				anquanxuexi = 0;
			}
			if(guanlifeiyong == ""){
				guanlifeiyong = 0;
			}
			if(yujiaobaoxian == ""){
				yujiaobaoxian = 0;
			}
			if(jiashiyuan == ""){
				jiashiyuan = 0;
			}
			
			var money=0;			
			money = parseFloat(jiaoqiangxian)+parseFloat(shangyexian)+parseFloat(guzhuhuotuanti)+ parseFloat(chengyunren)+ parseFloat(shiyongshui)+ parseFloat(gouzhishui)+ parseFloat(zhongduananzhuang)+ parseFloat(anquanxuexi) +parseFloat(guanlifeiyong)+ parseFloat(yujiaobaoxian)+  parseFloat(jiashiyuan); 
			$("input[name='heji']").val(money);
		}
		
	</script>
		
</body>

</html>
