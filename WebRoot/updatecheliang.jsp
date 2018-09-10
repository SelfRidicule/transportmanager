<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<link href="${pageContext.request.contextPath}/css/postbirdAlertBox.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	
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
	<script src="${pageContext.request.contextPath}/js/postbirdAlertBox.js"></script>
	<script src="${pageContext.request.contextPath}/js/fileinput.js" ></script>
    <script src="${pageContext.request.contextPath}/js/zh.js" ></script>
	
	<title>修改车辆</title>
	
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
				<li class="active">修改车辆</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				<!-- 修改车辆 -->
				<form name="myform" action="${pageContext.request.contextPath}/submitUpdateCheLiang" onsubmit="return submitVail()" method="post"  enctype="multipart/form-data">	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车辆合作人姓名<span style="color: red;">*</span></label>
						<input name="chezhuxingming" class="form-control" value="${singlecheliang.chezhuxingming }" placeholder="请输入车辆合作人姓名"  required="required" readonly="readonly"/>
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>手机号码</label>
						<input name="shoujihao" class="form-control" value="${singlecheliang.shoujihao }" placeholder="请输入手机号码" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>身份证号</label>
						<input name="shenfenzhenghao" class="form-control" value="${singlecheliang.shenfenzhenghao }" placeholder="请输入身份证号" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>购车费</label>
						<input name="gouchefei" class="form-control" value="${singlecheliang.gouchefei }" placeholder="请输入购车费" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车牌号 <span style="color: red;">*<span id="chepaihaotishi" style="display: none;">存在相同车牌号</span></span></label>
						<input name="chepaihao" class="form-control" value="${singlecheliang.chepaihao }"  onkeyup="verificationChePaiHao()"  placeholder="请输入车牌号" required="required"/>
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>登记证书编号</label>
						<input name="zhengshubianhao" class="form-control" value="${singlecheliang.zhengshubianhao }" placeholder="请输入登记证书编号 " />
					</div>
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>登记日期<span style="color: red;">*</span></label>
						<input id="riqi1" name="zhuceriqi"  class="form-control" value="<fmt:formatDate value="${singlecheliang.zhuceriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入登记日期" required="required"/>
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>行驶证年审日期</label>
						<input id="riqi2" name="nianshenriqi"  class="form-control" value="<fmt:formatDate value="${singlecheliang.nianshenriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入行驶证年审日期" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车辆类型 &nbsp; <a onclick="cheliangleixing()">添加</a> </label>
						<select id="leixing" class="form-control" name="chexing">
							<option value="">请选择</option>
							<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
								<c:if test="${cheliangguanli.type == '1' && cheliangguanli.id == singlecheliang.chexing}">
									<option value="${cheliangguanli.id}" selected="selected">${cheliangguanli.name}</option>
								</c:if>
								
								<c:if test="${cheliangguanli.type == '1' && cheliangguanli.id != singlecheliang.chexing}">
									<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
								</c:if>
					        </c:forEach>
						</select>
					</div>
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车辆品牌 &nbsp; <a onclick="cheliangpinpai()">添加</a></label>
						<select id="pinpai" class="form-control" name="cheliangleixing">
							<option value="">请选择</option>
							<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
								<c:if test="${cheliangguanli.type == '2' && cheliangguanli.id == singlecheliang.cheliangleixing}">
									<option value="${cheliangguanli.id}" selected="selected">${cheliangguanli.name}</option>
								</c:if>
								
								<c:if test="${cheliangguanli.type == '2' && cheliangguanli.id != singlecheliang.cheliangleixing}">
									<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
								</c:if>
					        </c:forEach>
						</select>					
					</div>
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车辆型号 &nbsp; <a onclick="cheliangxinghao()">添加</a></label>
					
						<select id="xinghao" class="form-control" name="pingpaixinghao">
							<option value="">请选择</option>
							<c:forEach items="${cheliangguanlilist}" var="cheliangguanli">
								<c:if test="${cheliangguanli.type == '3' && cheliangguanli.id == singlecheliang.pingpaixinghao}">
									<option value="${cheliangguanli.id}" selected="selected">${cheliangguanli.name}</option>
								</c:if>
								
								<c:if test="${cheliangguanli.type == '3' && cheliangguanli.id != singlecheliang.pingpaixinghao}">
									<option value="${cheliangguanli.id}">${cheliangguanli.name}</option>
								</c:if>
					        </c:forEach>
						</select>		
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车身颜色</label>
						<input name="cheshenyanse" class="form-control" value="${singlecheliang.cheshenyanse}" placeholder="请输入车身颜色 " />
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车架号</label>
						<input  name="shibiedaihao" class="form-control" value="${singlecheliang.shibiedaihao }" placeholder="请输入车架号" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>发动机号 </label>
						<input name="fadongjihao" class="form-control" value="${singlecheliang.fadongjihao }" placeholder="请输入发动机号" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>发动机型号</label>
						<input name="fadongjixinghao" class="form-control" value="${singlecheliang.fadongjixinghao }" placeholder="请输入发动机型号" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>燃料种类</label>
						<input name="ranliaozhonglei" class="form-control" value="${singlecheliang.ranliaozhonglei }" placeholder="请输入燃料种类" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>排量ML</label>
						<input name="pailiang" class="form-control" value="${singlecheliang.pailiang }" placeholder="请输入排量ML" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>功率KW</label>
						<input name="gonglv" class="form-control" value="${singlecheliang.gonglv }" placeholder="请输入功率KW" />
					</div>	
					<div class="form-group" style="width: 42%; float: left; margin-left: 30px">
						<label>制造厂家名称</label>
						<input name="changjiamingcheng" class="form-control" value="${singlecheliang.changjiamingcheng }" placeholder="请输入制造厂家名称" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 9%; float: left; margin-left: 30px">
						<label>轮距mm(前)</label>
						<input name="lunjuqian" class="form-control" value="${singlecheliang.lunjuqian }" placeholder="请输入轮距前" />
					</div>
					<div class="form-group" style="width: 9%; float: left; margin-left: 2%">
						<label>轮距mm(后)</label>
						<input name="lunjuhou" class="form-control" value="${singlecheliang.lunjuhou }" placeholder="请输入轮距后" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>轮胎数</label>
						<input name="luntaishu" class="form-control" value="${singlecheliang.luntaishu }" placeholder="请输入轮胎数" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>轮胎规格</label>
						<input name="luntaiguige" class="form-control" value="${singlecheliang.luntaiguige }" placeholder="请输入轮胎规格" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>钢板弹簧片数</label>
						<input name="gangbantanhuangpianshu" class="form-control" value="${singlecheliang.gangbantanhuangpianshu }" placeholder="请输入钢板弹簧片数" />
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>轴距mm</label>
						<input name="zhouju" class="form-control" value="${singlecheliang.zhouju }" placeholder="请输入轴距mm" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>轴数</label>
						<input name="zhoushu" class="form-control" value="${singlecheliang.zhoushu }" placeholder="请输入轴数" />
					</div>	
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>外廓尺寸(长宽高)mm</label>
						<div style="clear: both;"></div>
						<input name="chang" class="form-control" value="${chang}" placeholder="请输入长" style="width: 32%;float: left;"/>
						<input name="kuan" class="form-control" value="${kuan}" placeholder="请输入宽" style="width: 32%;float: left; margin-left: 2%;"/>
						<input name="gao" class="form-control" value="${gao}" placeholder="请输入高" style="width: 32%;float: left;margin-left: 2%;"/>
					</div>		
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>货厢内部尺寸(长宽高)mm</label>
						<div style="clear: both;"></div>
						<input name="huoxiangchang" class="form-control" value="${singlecheliang.huoxiangchang }" placeholder="请输入长" style="width: 32%;float: left;"/>
						<input name="huoxiangkuan" class="form-control" value="${singlecheliang.huoxiangkuan }" placeholder="请输入宽" style="width: 32%;float: left; margin-left: 2%;"/>
						<input name="huoxianggao" class="form-control" value="${singlecheliang.huoxianggao }" placeholder="请输入高" style="width: 32%;float: left;margin-left: 2%;"/>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>总质量（kg）</label>
						<input name="zongzhiliang" class="form-control" value="${singlecheliang.zongzhiliang}" placeholder="请输入总质量" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>核定载质量（kg）</label>
						<input name="hedingzhaizhiliang" class="form-control" value="${singlecheliang.hedingzhaizhiliang}" placeholder="请输入核定载质量" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>准牵引总质量（kg）</label>
						<input name="zhunqianyingzongzhiliang" class="form-control" value="${singlecheliang.zhunqianyingzongzhiliang}" placeholder="请输入准牵引总质量" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>整备质量（kg）</label>
						<input name="zhengbeizhiliang" class="form-control" value="${singlecheliang.zhengbeizhiliang}" placeholder="请输入整备质量" />
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车辆道路运输证号</label>
						<input name="cheliangdaoluyunshuzhenghao" class="form-control" value="${singlecheliang.cheliangdaoluyunshuzhenghao}" placeholder="请输入车辆道路运输证号" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>道路运输证年审日期</label>
						<input id="riqi4" name="daoluyunshuzhengnianshenriqi"  class="form-control" value="<fmt:formatDate value="${singlecheliang.daoluyunshuzhengnianshenriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入道路运输证年审日期" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>经营范围  &nbsp; <a onclick="jingyingfanwei()">添加</a> </label>
						<select id="jingyingfanwei"  name="jingyingfanwei" class="show-tick form-control"  multiple>
							<option value="">请选择</option>
							
							<c:forEach items="${selectjingyinglist}" var="selectjingying">
									<option value="${selectjingying.id}" selected="selected">${selectjingying.name}</option>
							 </c:forEach>
							
							<c:forEach items="${jingyinglist}" var="jingying">
									<option value="${jingying.id}" >${jingying.name}</option>
							 </c:forEach>
							
						</select>		
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>罐体检测日期</label>
						<input id="riqi6" name="guantijianceriqi"  class="form-control" value="<fmt:formatDate value="${singlecheliang.guantijianceriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入罐体检测日期" />
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>二级维护日期</label>
						<input id="riqi3" name="erjiweihuriqi"  class="form-control" value="<fmt:formatDate value="${singlecheliang.erjiweihuriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入二级维护日期" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>等级评定日期</label>
						<input id="riqi5" name="dengjipingdingriqi"  class="form-control" value="<fmt:formatDate value="${singlecheliang.dengjipingdingriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入等级评定日期" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>驾押员1</label>
						<select id="basic2" name="jiayayuan1" class="show-tick form-control"  required="required">
					        <option value="请选择">请选择</option>
					        <c:forEach items="${jiashiyuanlist}" var="jiashiyuan">
					        	<c:if test="${fn:trim(jiashiyuan.id) == singlecheliang.jiayayuan1}">
					        		<option value="${jiashiyuan.id}" selected="selected">${jiashiyuan.jiashiyuanxingming}</option>
					        	</c:if>
								
								<c:if test="${fn:trim(jiashiyuan.id) != singlecheliang.jiayayuan1}">
					        		<option value="${jiashiyuan.id}">${jiashiyuan.jiashiyuanxingming}</option>
					        	</c:if>
					        </c:forEach>
						</select>
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>驾押员2</label>
						<select id="basic3" name="jiayayuan2" class="show-tick form-control" required="required">
					        <option value="请选择">请选择</option>
					        <c:forEach items="${jiashiyuanlist}" var="jiashiyuan">
								<c:if test="${fn:trim(jiashiyuan.id) == singlecheliang.jiayayuan2}">
					        		<option value="${jiashiyuan.id}" selected="selected">${jiashiyuan.jiashiyuanxingming}</option>
					        	</c:if>
								
								<c:if test="${fn:trim(jiashiyuan.id) != singlecheliang.jiayayuan2}">
					        		<option value="${jiashiyuan.id}">${jiashiyuan.jiashiyuanxingming}</option>
					        	</c:if>
					        </c:forEach>
						</select>
					</div>					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>	<br/>	
					
					
					<div class="row">
						<ol class="breadcrumb">
							<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
							<li class="active">保险资料</li>
						</ol>
					</div><!--/.row-->
					<br/>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>交强险保单号</label>
						<input name="jiaoqiangxianbaodanhao" class="form-control" value="${singlejiaoqiangxian.baodanhao }" placeholder="请输入交强险保单号" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>交强险保险费用</label>
						<input name="jiaoqiangxianfeiyong" class="form-control" value="${singlejiaoqiangxian.toubaojine }" placeholder="请输入交强险保险费用" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>交强险保险到期时间</label>
						<input id="riqi7" name="jiaoqiangxiandaoqishijian"  class="form-control" value="<fmt:formatDate value="${singlejiaoqiangxian.daoqiriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入交强险保险到期时间" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>交强险公司名称</label>
						<input  name="jiaoqiangxiangongsi"  class="form-control" value="${singlejiaoqiangxian.baoxiangongsi }" placeholder="请输入交强险公司名称" />
					</div>		
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>商业险保单号</label>
						<input name="shangyexianbaodanhao" class="form-control" value="${singleshangyexian.baodanhao }" placeholder="请输入商业险保单号" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>商业险保险费用</label>
						<input name="shangyexianfeiyong" class="form-control" value="${singleshangyexian.toubaojine }" placeholder="请输入商业险保险费用" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>商业险保险到期时间</label>
						<input id="riqi8" name="shangyexiandaoqishijian"  class="form-control" value="<fmt:formatDate value="${singleshangyexian.daoqiriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入商业险保险到期时间" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>商业险公司名称</label>
						<input  name="shangyexiangongsi"  class="form-control" value="${singleshangyexian.baoxiangongsi }" placeholder="请输入商业险公司名称" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>承运人责任险保单号</label>
						<input name="chengyunrenbaodanhao" class="form-control" value="${singlechengyunrenzerenxian.baodanhao }" placeholder="请输入承运人责任险保单号" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>承运人责任险保险费用</label>
						<input name="chengyunrenfeiyong" class="form-control" value="${singlechengyunrenzerenxian.toubaojine }" placeholder="请输入承运人责任险保险费用" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>承运人责任险到期时间</label>
						<input id="riqi9" name="chengyunrendaoqishijian"  class="form-control" value="<fmt:formatDate value="${singlechengyunrenzerenxian.daoqiriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入承运人责任险到期时间" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>承运人责任险公司名称</label>
						<input  name="chengyunrengongsi"  class="form-control" value="${singlechengyunrenzerenxian.baoxiangongsi }" placeholder="请输入承运人责任险公司名称" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>雇主责任险保单号</label>
						<input name="guzhubaodanhao" class="form-control" value="${singleguzhuzerenxian.baodanhao }" placeholder="请输入雇主责任险保单号" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>雇主责任保险费用</label>
						<input name="guzhufeiyong" class="form-control" value="${singleguzhuzerenxian.toubaojine }" placeholder="请输入雇主责任保险费用" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>雇主责任保险到期时间</label>
						<input id="riqi10" name="guzhudaoqishijian"  class="form-control" value="<fmt:formatDate value="${singleguzhuzerenxian.daoqiriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入雇主责任保险到期时间" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>雇主责任险公司名称</label>
						<input  name="guzhugongsi"  class="form-control" value="${singleguzhuzerenxian.baoxiangongsi }" placeholder="请输入雇主责任险公司名称" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>团体意外险保单号</label>
						<input name="tuantixianbaodanhao" class="form-control" value="${singletuantiyiwaixian.baodanhao }" placeholder="请输入团体意外险保单号" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>团体意外险费用</label>
						<input name="tuantixianfeiyong" class="form-control" value="${singletuantiyiwaixian.toubaojine }" placeholder="请输入团体意外险费用" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>团体意外险到期时间</label>
						<input id="riqi11" name="tuantixiandaoqishijian"  class="form-control" value="<fmt:formatDate value="${singletuantiyiwaixian.daoqiriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入团体意外险到期时间" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>团体意外险公司名称</label>
						<input  name="tuantigongsi"  class="form-control" value="${singletuantiyiwaixian.baoxiangongsi }" placeholder="请输入团体意外险公司名称" />
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车船险保单号</label>
						<input name="chechuanxianbaodanhao" class="form-control" value="${singlechechuanxian.baodanhao }" placeholder="请输入车船险保单号" />
					</div>					
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车船险费用</label>
						<input name="chechuanxianfeiyong" class="form-control" value="${singlechechuanxian.toubaojine }" placeholder="请输入车船险费用" />
					</div>		
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车船险到期时间</label>
						<input id="riqi11" name="chechuanxiandaoqishijian"  class="form-control" value="<fmt:formatDate value="${singlechechuanxian.daoqiriqi}" pattern="yyyy-MM-dd"/>"  placeholder="请输入车船险到期时间" />
					</div>	
					<div class="form-group" style="width: 20%; float: left; margin-left: 30px">
						<label>车船险公司名称</label>
						<input  name="chechuanxiangongsi"  class="form-control" value="${singlechechuanxian.baoxiangongsi }" placeholder="请输入车船险公司名称" />
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>	<br/>	
					
					<div class="row">
						<ol class="breadcrumb">
							<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
							<li class="active">其他资料</li>
						</ol>
					</div><!--/.row-->
					<br/>	
					
					<div class="form-group" style="width: 25%; float: left; margin-left: 30px">
						<label>用户描述</label>
						<input name="yonghumiaoshu" class="form-control" value="${singlecheliang.yonghumiaoshu}" placeholder="请输入用户描述" />
					</div>					
					<div class="form-group" style="width: 25%; float: left; margin-left: 30px">
						<label>车辆分组</label>
						<select class="form-control" name="cheliangfenzu">
							<option value="">请选择</option>
							<c:forEach items="${cheliangguanlilist}" var="cheliangfenzu">
								<c:if test="${cheliangfenzu.type == '5' && cheliangfenzu.id == singlecheliang.cheliangfenzu }">
									<option value="${cheliangfenzu.id}" selected="selected">${cheliangfenzu.name}</option>
								</c:if>
								
								<c:if test="${cheliangfenzu.type == '5' && cheliangfenzu.id != singlecheliang.cheliangfenzu }">
									<option value="${cheliangfenzu.id}">${cheliangfenzu.name}</option>
								</c:if>
					        </c:forEach>
						</select>			
					</div>	
					<div class="form-group" style="width: 25%; float: left; margin-left: 30px">
						<label>车辆状态</label>
						<br/>
						<c:if test="${singlecheliang.zhuangtai == '可用' }">
							可用<input name="zhuangtai" type="radio"   value="可用" checked />&nbsp
							禁用<input name="zhuangtai" type="radio"  value="禁用" />
						</c:if>
						
						<c:if test="${singlecheliang.zhuangtai != '可用' }">
							可用<input name="zhuangtai" type="radio"   value="可用" />&nbsp
							禁用<input name="zhuangtai" type="radio"  value="禁用" checked />
						</c:if>
					</div>
					
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<br/>	
					<div class="row">
						<ol class="breadcrumb">
							<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
							<li class="active">相关车辆图片</li>
						</ol>
					</div><!--/.row-->
					<br/>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					<div id="tupiantishi" class="alert bg-warning" role="alert">
					<span class="glyphicon glyphicon-warning-sign"></span> 上传图片的名称请不要带有中文，\ 等一些特殊符号 ( 图片格式：jpg，png，gif ) <a id="guanbitishi" href="#" class="pull-right"><span class="glyphicon glyphicon-remove"></span></a>
					</div>
					
					<div class="form-group">
			            <input id="file-1" name="picture" type="file" multiple class="file-loading" />
			        </div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<button id="mysubmit" type="submit" class="btn btn-primary" style="float: left; margin-left: 30px">修改车辆</button>
					<a href="${pageContext.request.contextPath}/returnCheLiang"> <button type="button"  class="btn btn-info" style="float: left; margin-left: 10px">返回</button></a>
					
					<br/>	<br/>	
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<!-- 上传图片 --> 
	<script type="text/javascript">
		
		$(function(){
			
			$.ajax({
				type : "post",
				url  : '${pageContext.request.contextPath}/cheLiangViewAjax' ,
				dataType : 'json',
				success : function(data){
					var datas = eval(data);	//格式化json数据
					showInitFile(datas);	//调用初始化方法
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
				
					$("#file-1").fileinput({
				    	language: 'zh', //设置语言,还要导入对应的js文件 — —
				    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
				    	//dropZoneEnabled: false,//是否显示拖拽区域 
				        uploadUrl: '${pageContext.request.contextPath}/cheLiangUploadFile', // 多图片必须设置图片上传的url路径 
				        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
				       	//showUploadedThumbs:false  ,  
				       	showUpload: false, //是否显示上传按钮
				       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
						uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
							var cph = document.getElementsByName("chepaihao")[0].value;		       		
			                return {"chepaihao": cph};
			            },
					}).on("filebatchselected", function(event, files) {//选择文件
						  $(this).fileinput("upload"); //上传选中的文件
					}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
							document.getElementById("mysubmit").disabled = true;
			        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
					  	    /* var json = data.response;  //解析数据  因为数据是json格式
					  	    alert(json[0].value);  	//数据是数组格式 */
					  	    document.getElementById("mysubmit").disabled = false;
					});  
					
				}			
			});
			
			function showInitFile(mydata){
				
				var prepicture = new Array();
				for(var i=0; i<mydata.length ;i++){
					prepicture[i]="<img src='"+mydata[i].deletepicture+"' class='file-preview-image' width='300px' height='200px'>";
				}
				
				var preconfig = new Array();
				for(var i=0; i<mydata.length ;i++){
					var tjson = {caption: mydata[i].deletepicture, // 展示的文件名 
									url:'${pageContext.request.contextPath}/cheLiangDeleteFile', // 删除url 
									key: "abc" , // 删除是Ajax向后台传递的参数 
									extra:{"fullpath": mydata[i].fullpath},	//传递删除额外参数
									/* extra: function(){	//该方法不能传递额外参数- -
		              					return {"fullpath": mydata[i].fullpath};
									} , */
								}; 
					preconfig[i]=tjson;			
				} 
					
				$("#file-1").fileinput({
			    	language: 'zh', //设置语言,还要导入对应的js文件 — —
			    	//maxFileCount : 10,//表示允许同时上传的最大文件个数 
			    	//dropZoneEnabled: false,//是否显示拖拽区域 
			        uploadUrl: '${pageContext.request.contextPath}/cheLiangUploadFile', // 多图片必须设置图片上传的url路径 
			        allowedFileExtensions : ['jpg', 'png','gif'], //设置图片格式
			       	//showUploadedThumbs:false  ,  
			       	showUpload: false, //是否显示上传按钮
			       	previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 	//图片上传的小图标
					
					initialPreview: prepicture,	//初始化图片
					/* initialPreviewAsData: true, */
					initialPreviewConfig : preconfig,	//初始化图片格式
					
					uploadExtraData: function() {   //在上传文件之前调用的,额外参数的关键点~这是活的参数
						var cph = document.getElementsByName("chepaihao")[0].value;		       		
		                return {"chepaihao": cph};
		            },
				}).on("filebatchselected", function(event, files) {//选择文件
					  $(this).fileinput("upload"); //上传选中的文件
				}).on("filepreupload", function(event, data, previewId, index) {     //上传文件中
						document.getElementById("mysubmit").disabled = true;
		        }).on("fileuploaded", function (event, data) {//上传完成后  注意:调用的上传文件控制层必须返回json格式的数据不然进不了fileuploaded()
				  	    /* var json = data.response;  //解析数据  因为数据是json格式
				  	    alert(json[0].value);  	//数据是数组格式 */
				  	    document.getElementById("mysubmit").disabled = false;
				}).on("filepredelete", function(event, key) {  
					
				});  
				
			};
			
			
		});
		
		$(function(){
		    
		    $("#guanbitishi").click(function(){
				$("#tupiantishi").hide();		    	
		    });
			
		});
		
	</script>	

	<script>
	
		var chepaihaoFlag = 1 ;
		
		function verificationChePaiHao(){

			var chepaihao =  $("input[name='chepaihao']").val();
			
			$.ajax({
	             type: "POST",
	             url: "${pageContext.request.contextPath}/verificationChePaiHao",
	             data: { 'chepaihao' : chepaihao},
	             dataType: "json",
	             success: function(data){
	             	
	             	if(data[0].flag == 'success'){
	             		$("#chepaihaotishi").hide();
	             		chepaihaoFlag = 1;
	             	}
	             	
	             	if(data[0].flag == 'err'){
	             		$("#chepaihaotishi").show();
	             		chepaihaoFlag = 0;
	             	}
	             	
	             }
         	});
					
		}	
		
		function submitVail(){
			
			if(chepaihaoFlag == 0){
				$("input[name='chepaihao']").focus();
				return false;
			}
		
			if(chepaihaoFlag == 1){
				return true;
			}
		}	
		
			function cheliangleixing() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入车辆类型',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '1', 'shijileixing' : shijileixing },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var leixing = document.getElementById("leixing");
				             	leixing.innerHTML = "<option value='"+datas[0].id+"'>"+datas[0].name+"</option>" + leixing.innerHTML ;
				             	
				             	$('#leixing').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
    		
    		function cheliangpinpai() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入车辆品牌',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            	
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '2' },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var pinpai = document.getElementById("pinpai");
				             	pinpai.innerHTML = "<option value='"+datas[0].id+"'>"+datas[0].name+"</option>" + pinpai.innerHTML ;
				             	
				             	$('#pinpai').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
    		
    		function cheliangxinghao() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入车辆型号',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            	
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '3' },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var xinghao = document.getElementById("xinghao");
				             	xinghao.innerHTML = "<option value='"+datas[0].id+"'>"+datas[0].name+"</option>" + xinghao.innerHTML ;
				             	
				             	$('#xinghao').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
    		
    		function fadongji() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入发动机号',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '4' },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var fadongji = document.getElementById("fadongji");
				             	fadongji.innerHTML = "<option value=\""+datas[0].id+"\">"+datas[0].name+"</option>" + fadongji.innerHTML;
								
								$('#fadongji').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
    		
    		function jingyingfanwei() {
		        PostbirdAlertBox.prompt({
		            'title': '请输入经营范围',
		            'okBtn': '提交',
		            onConfirm: function (data) {
		            
		            	var dataArr =data.split(",");
		            	
		            	data = dataArr[0];
		            	
		            	var shijileixing = dataArr[1];
		            
		            	$.ajax({
				             type: "POST",
				             url: "${pageContext.request.contextPath}/addAjaxCheLiangLeiXing",
				             data: { 'data' : data, 'type' : '6' },
				             dataType: "json",
				             success: function(data){
				             	var datas = eval(data);
				             	
				             	var jingyingfanwei = document.getElementById("jingyingfanwei");
				             	jingyingfanwei.innerHTML = "<option value=\""+datas[0].id+"\">"+datas[0].name+"</option>" + jingyingfanwei.innerHTML;
								
								$('#jingyingfanwei').selectpicker('refresh');
				             }
				             
			         	});
		                
		            },
		            onCancel: function (data) {
		                
		            },
	        	});
    		}
		
		$('#basic2').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });
		    
		$('#basic3').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });    
	    
	    $('#leixing').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#pinpai').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#xinghao').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#fadongji').selectpicker({
		      liveSearch: true,
		      maxOptions: 1
	    });   
	    
	    $('#jingyingfanwei').selectpicker({
		      liveSearch: true,
	    });
	    
	</script>	
</body>

</html>
