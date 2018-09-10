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
				<li class="active">修改费用收取</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
				<form name="myform" action="${pageContext.request.contextPath}/updateFeiYongShouQu" onsubmit="" method="post" enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label></label>
						<input  class="form-control" value="${singlefeiyongshouqu.chelianghezuoren}"   readonly="readonly"/>
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>购车费</label>
						<input name="gouchefei" class="form-control" value="${singlefeiyongshouqu.gouchefei}" placeholder="购车费"  onkeyup="mybili()"/>
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>轮胎费</label>
						<input name="luntaifei" class="form-control" value="${singlefeiyongshouqu.luntaifei}" placeholder="轮胎费"  onkeyup="mybili()"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>维修费</label>
						<input name="weixiufei" class="form-control" value="${singlefeiyongshouqu.weixiufei}" placeholder="维修费"  onkeyup="mybili()"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>加油费</label>
						<input name="jiayoufei" class="form-control" value="${singlefeiyongshouqu.jiayoufei}" placeholder="加油费"  onkeyup="mybili()"/>
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>其他费用</label>
						<input name="qitafeiyong" class="form-control" value="${singlefeiyongshouqu.qitafeiyong}" placeholder="其他费用"  onkeyup="mybili()"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>开票合计</label>
						<input name="zongkaipiaoheji" class="form-control" value="${zongkaipiaoheji}" placeholder="开票合计"  onkeyup="mybili()"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>比例</label>
						<input name="bili" class="form-control" value="${singlefeiyongshouqu.bili}" placeholder="比例"  />
					</div>			
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>公司业务开票合计</label>
						<input name="kaipiaoheji" class="form-control" value="${singlefeiyongshouqu.kaipiaoheji}" placeholder="公司业务开票合计"  onkeyup="zongHeJi()"/>
					</div>		
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>自有业务开票合计</label>
						<input name="ziyouyewuheji" class="form-control" value="${singlefeiyongshouqu.ziyouyewuheji}" placeholder="自有业务开票合计"  onkeyup="zongHeJi()"/>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>保险费</label>
						<input name="baoxianfei" class="form-control" value="${singlefeiyongshouqu.baoxianfei}" placeholder="保险费"  onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>车载安装和服务费用</label>
						<input name="chezaihefuwufeiyong" class="form-control" value="${singlefeiyongshouqu.chezaihefuwufeiyong}" placeholder="车载安装和服务费用"  onkeyup="hejijine()"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>安全学习保证金</label>
						<input name="anquanxuexibaozhengjin" class="form-control" value="${singlefeiyongshouqu.anquanxuexibaozhengjin}" placeholder="安全学习保证金"  onkeyup="hejijine()"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>管理费用</label>
						<input name="guanlifeiyong" class="form-control" value="${singlefeiyongshouqu.guanlifeiyong}" placeholder="管理费用"  onkeyup="hejijine()"/>
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>预交保险费用</label>
						<input name="yujiaobaoxianfeiyong" class="form-control" value="${singlefeiyongshouqu.yujiaobaoxianfeiyong}" placeholder="预交保险费用"  onkeyup="hejijine()"/>
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 10%">
						<label>驾驶员保险</label>
						<input name="jiashiyuanbaoxian" class="form-control" value="${singlefeiyongshouqu.jiashiyuanbaoxian}" placeholder="驾驶员保险"  onkeyup="hejijine()"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>合计<span style="color: red;">*</span></label>
						<input name="heji" class="form-control" value="${singlefeiyongshouqu.heji}"  placeholder="自动合计" required="required" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/jumpFeiYongShouQu"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					<br/>
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	
	<script type="text/javascript">
		
		function zongHeJi(){
		
			var kaipiaoheji = $("input[name='kaipiaoheji']").val();
			if(kaipiaoheji == ""){
				kaipiaoheji = 0;
			}
			
			var ziyouyewuheji = $("input[name='ziyouyewuheji']").val();
			if(ziyouyewuheji == ""){
				ziyouyewuheji = 0;
			}
			
			var zonghe = parseFloat(kaipiaoheji) + parseFloat(ziyouyewuheji);
		
			$("input[name='zongkaipiaoheji']").val( zonghe );
			
			//调用比例更新
			mybili();
		}
		
		
		function mybili(){
			
			var gouchefei = $("input[name='gouchefei']").val();
			if(gouchefei == ""){
				gouchefei = 0;
			}
			
			var luntaifei = $("input[name='luntaifei']").val();
			if(luntaifei == ""){
				luntaifei = 0;
			}
			
			var weixiufei = $("input[name='weixiufei']").val();
			if(weixiufei == ""){
				weixiufei = 0;
			}
			
			var jiayoufei = $("input[name='jiayoufei']").val();
			if(jiayoufei == ""){
				jiayoufei = 0;
			}
			
			var qitafeiyong = $("input[name='qitafeiyong']").val();
			if(qitafeiyong == ""){
				qitafeiyong = 0;
			}
			
			var zongkaipiaoheji = $("input[name='zongkaipiaoheji']").val();
			if(zongkaipiaoheji == ""){
				zongkaipiaoheji = 0;
			}
			
			var money=0;			
			money =( parseFloat(gouchefei)+parseFloat(luntaifei)+parseFloat(weixiufei)+parseFloat(jiayoufei)+parseFloat(qitafeiyong) ) / zongkaipiaoheji ;
			money = Math.floor(money * 100) / 100 ;
			$("input[name='bili']").val(money);
		}
		
		
		//--------合计
		function hejijine(){
		
			var baoxianfei = $("input[name='baoxianfei']").val();
			if(baoxianfei == ""){
				baoxianfei = 0;
			}
			
			var chezaihefuwufeiyong = $("input[name='chezaihefuwufeiyong']").val();
			if(chezaihefuwufeiyong == ""){
				chezaihefuwufeiyong = 0;
			}
			
			var anquanxuexibaozhengjin = $("input[name='anquanxuexibaozhengjin']").val();
			if(anquanxuexibaozhengjin == ""){
				anquanxuexibaozhengjin = 0;
			}
			
			var guanlifeiyong = $("input[name='guanlifeiyong']").val();
			if(guanlifeiyong == ""){
				guanlifeiyong = 0;
			}
			
			var yujiaobaoxianfeiyong = $("input[name='yujiaobaoxianfeiyong']").val();
			if(yujiaobaoxianfeiyong == ""){
				yujiaobaoxianfeiyong = 0;
			}
			
			var jiashiyuanbaoxian = $("input[name='jiashiyuanbaoxian']").val();
			if(jiashiyuanbaoxian == ""){
				jiashiyuanbaoxian = 0;
			}
			
			var money=0;			
			money = parseFloat(baoxianfei)+parseFloat(chezaihefuwufeiyong)+parseFloat(anquanxuexibaozhengjin)+parseFloat(guanlifeiyong)+parseFloat(yujiaobaoxianfeiyong)+parseFloat(jiashiyuanbaoxian); 
			$("input[name='heji']").val(money);
		}
		
	</script>
		
</body>

</html>
