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
		
		function anquan(value){
			
			$.ajax({
			
	             type: "POST",
	             url: "${pageContext.request.contextPath}/getWeiXianPinHuoWuMingCheng",
	             data: { 'anquankamingcheng' : value },
	             dataType: "json",
	             success: function(data){
	             	var datas = eval(data);
	             	
	             	document.getElementsByName("huowumingcheng")[0].value=datas[0].huowumingcheng;
	             }
	             
         	});
			
		}
		
		// 定义变量
		var dingdanhaoBoolean = 1 ;
		var dianhuaBoolean = 1 ;
		
		//判断是否存在相同订单号
		function existdingdanhao(){
			
			var dingdanhaoObj = document.getElementsByName("dingdanhao")[0]
			
			$.ajax({
			
	             type: "POST",
	             url: "${pageContext.request.contextPath}/existYunDanDingDaoHao",
	             data: { 'dingdanhao' : dingdanhaoObj.value },
	             dataType: "json",
	             
	             success: function(data){
	             	var datas = eval(data);
											
					if( "err" == datas[0].flag ){
	             		dingdanhaoObj.style.borderColor = 'red';
	             		document.getElementById("dingdanhaotishi").style.display = 'inline';
	             		
	             		dingdanhaoBoolean = 0;
	             	}
	             	
	             	if( "success" == datas[0].flag ){
	             		dingdanhaoObj.style.borderColor = 'green';
	             		document.getElementById("dingdanhaotishi").style.display = 'none';
	             		
	             		dingdanhaoBoolean = 1;
	             	}            	
	             }
	             
         	});
					
		}		
		
		//判断电话长度是否规范
		function existdianhua(){
		
			var dianhuaObj = document.getElementsByName("dianhua")[0] ;
			
			var value = dianhuaObj.value ;	
			
			if(value.length == 11){
				dianhuaObj.style.borderColor = 'green';
           		document.getElementById("dianhuatishi").style.display = 'none';
				dianhuaBoolean = 1 ;
			}
			
			if(value.length != 11){
				dianhuaObj.style.borderColor = 'red';
           		document.getElementById("dianhuatishi").style.display = 'inline';
				dianhuaBoolean = 0 ;
			}
			
		}
		
		//判断是否可以提交
		function test(){
			
			if( dingdanhaoBoolean != 1 || dianhuaBoolean != 1 ){
				return false;
			}
			
		}
		
	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">运单调换</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 添加 -->
				<form name="myform" action="${pageContext.request.contextPath}/yunDanDiaoHuan" onsubmit="return test()" method="post">	
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>订单号<span style="color: red;  padding-top: 10px">*&nbsp;</span><span id="dingdanhaotishi" style="display: none; color: red;">存在相同的订单号</span></label>
						<input name="dingdanhao" class="form-control" value="${singleyundan.dingdanhao}" onblur="existdingdanhao()" placeholder="请输入订单号"  required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车牌号 </label>
						<select id="basic2" name="chepaihao" class="show-tick form-control">
							<option value="未分配">未分配</option>
					        <c:forEach items="${chelianglist}" var="cheliang">
					        	<c:if test="${cheliang.chepaihao == singleyundan.chepaihao }">
									<option value="${cheliang.chepaihao}" selected="selected">${cheliang.chepaihao}</option>
								</c:if>
								
								<c:if test="${cheliang.chepaihao != singleyundan.chepaihao }">
									<option value="${cheliang.chepaihao}">${cheliang.chepaihao}</option>
								</c:if>
					        </c:forEach>
						</select>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>客户单位<span style="color: red;  padding-top: 10px">*</span></label>
						<select id="basic4" name="kehudanwei" class="show-tick form-control">
							<option value="${singleyundan.kehudanwei}" selected="selected">${singleyundan.kehudanwei}</option>
					        <c:forEach items="${customerlist}" var="customer">
					        	<c:if test="${singleyundan.kehudanwei != customer.kehudanwei }">
									<option value="${customer.kehudanwei}">${customer.kehudanwei}</option>
								</c:if>
					        </c:forEach>
						</select>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>运输时间<span style="color: red;  padding-top: 10px">*</span></label>
						<input id="riqi1" name="yunshushijian"  class="form-control" value="${singleyundan.yunshushijian}" placeholder="请输入运输时间" required="required"/>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>起点<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="qidian" class="form-control" value="${singleyundan.qidian}" placeholder="请输入起点" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>终点<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="zhongdian" class="form-control" value="${singleyundan.zhongdian}" placeholder="请输入终点" required="required"/>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>电话<span style="color: red;  padding-top: 10px">*&nbsp;</span><span id="dianhuatishi" style="display: none; color: red;">格式不规范</span></label>
						<input name="dianhua" class="form-control" value="${singleyundan.dianhua}" onblur="existdianhua()" placeholder="请输入电话" required="required"/>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>联系人<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="lianxiren" class="form-control" value="${singleyundan.lianxiren}" placeholder="请输入联系人" required="required"/>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>运费</label>
						<div style="clear: both;"></div>
						<input name="baochoujine" class="form-control" value="${singleyundan.baochoujine}" placeholder="请输入运费金额"  style="width: 48%; float: left; "/>
						<select class="form-control" name="baochouleixing" style="width: 48%; float: left; margin-left: 10px;">
							<c:if test="${singleyundan.baochouleixing == '元每车' }">
								<option value="元每车" selected="selected">元每车</option>
							</c:if>
							<c:if test="${singleyundan.baochouleixing != '元每车' }">
								<option value="元每车">元每车</option>
							</c:if>
								
							<c:if test="${singleyundan.baochouleixing == '元每吨' }">
								<option value="元每吨" selected="selected">元每吨</option>
							</c:if>
							<c:if test="${singleyundan.baochouleixing != '元每吨' }">
								<option value="元每吨">元每吨</option>
							</c:if>	
						</select>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>实收运费</label>
						<div style="clear: both;"></div>
						<input name="shishouyunfei" class="form-control" value="${singleyundan.shishouyunfei}" placeholder="请输入实收运费"  style="width: 48%; float: left; "/>
						<select class="form-control" name="shishouleixing" style="width: 48%; float: left; margin-left: 10px;" style="width: 48%; float: left; margin-left: 10px;">
							
								<option value="元每车"  <c:if test="${singleyundan.shishouleixing == '元每车' }">selected="selected"</c:if> >元每车</option>
							
								<option value="元每吨"  <c:if test="${singleyundan.shishouleixing == '元每吨' }">selected="selected"</c:if> >元每吨</option>
							
						</select>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>预计吨位<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="yujidunwei" class="form-control" value="${singleyundan.yujidunwei}" placeholder="请输入预计吨位" required="required"/>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>安全卡</label>
						<select id="basic3" name="anquanka" class="show-tick form-control" onchange="anquan(this.value)">
							
							<c:if test="${singleyundan.anquanka == ''}">
								<option value="${singleyundan.anquanka}">未选择</option>
							</c:if>
							<c:if test="${singleyundan.anquanka != ''}">
								<option value="${singleyundan.anquanka}">${singleyundan.anquanka}</option>
							</c:if>
							
					        <c:forEach items="${weixianpinlist}" var="weixianpin">
					        	<c:if test="${weixianpin.anquankamingcheng != singleyundan.anquanka }">
									<option value="${weixianpin.anquankamingcheng}">${weixianpin.anquankamingcheng}</option>
								</c:if>
					        </c:forEach>
						</select>
					</div>		
									
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>地址<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="dizhi" class="form-control" value="${singleyundan.dizhi}" placeholder="请输入地址" required="required"/>
					</div>		
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>货物名称<span style="color: red;  padding-top: 10px">*</span></label>
						<input name="huowumingcheng" class="form-control" value="${singleyundan.huowumingcheng}" required="required"/>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 70%; float: left; margin-left: 30px">
						<label>运单备注</label>
						<textarea class="form-control" rows="3" name="yundanbeizhu">${singleyundan.yundanbeizhu}</textarea>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>
					<button type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改</button>
					<a href="${pageContext.request.contextPath}/jumpYunDan"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->
	
	<script type="text/javascript">
		
		$(function(){
		
		    $('#basic2').selectpicker({
		      liveSearch: true,
		      size: 10 ,//点击 展示多少选项
		      maxOptions: 1
		    });
			
			$('#basic3').selectpicker({
		      liveSearch: true,
		      size: 10 ,//点击 展示多少选项
		      maxOptions: 1
		    });
		    
		    $('#basic4').selectpicker({
		      liveSearch: true,
		      size: 10 ,//点击 展示多少选项
		      maxOptions: 1
		    });
		    
		});
		
	</script>	
</body>

</html>
