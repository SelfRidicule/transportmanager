<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/bootstrap-table.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<link href="css/lightbox.css" rel="stylesheet">
	
	<title>车辆详细</title>
	
	<script type="text/javascript">
			

	</script>
	
</head>

<body>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">车辆详细</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default" style="background-color: #f1f4f7;">
				
				<!-- start -->
				<br/>
				
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆合作人姓名 : <span style="font-weight:normal;">${singlecheliang.chezhuxingming }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>手机号码 : <span style="font-weight:normal;">${singlecheliang.shoujihao}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>身份证号 : <span style="font-weight:normal;">${singlecheliang.shenfenzhenghao }</span></label>
					</div>					
					<%-- <div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>身份证文件 : 
							<c:if test="${ singlecheliang.shenfenzhengtupian != '' && not empty singlecheliang.shenfenzhengtupian }">
								<a href="${singlecheliang.shenfenzhengtupian}" target="_Blank" class="no-print">查看</a>
							</c:if>
						</label>
					</div>			 --%>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车牌号 : <span style="font-weight:normal;">${singlecheliang.chepaihao }</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>登记证书编号 : <span style="font-weight:normal;">${singlecheliang.zhengshubianhao}</span></label>
					</div>						
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>登记日期 : <span style="font-weight:normal;"><fmt:formatDate value="${singlecheliang.zhuceriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>行驶证年审日期 : <span style="font-weight:normal;"><fmt:formatDate value="${singlecheliang.nianshenriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆类型 : <span style="font-weight:normal;">${singlecheliang.chexing}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车辆品牌 : <span style="font-weight:normal;">${singlecheliang.cheliangleixing}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆型号 : <span style="font-weight:normal;">${singlecheliang.pingpaixinghao}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>车身颜色 : <span style="font-weight:normal;">${singlecheliang.cheshenyanse}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车架号 : <span style="font-weight:normal;">${singlecheliang.shibiedaihao}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>发动机号 : <span style="font-weight:normal;">${singlecheliang.fadongjihao}</span></label>
					</div>							
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>发动机型号 : <span style="font-weight:normal;">${singlecheliang.fadongjixinghao}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>燃料种类 : <span style="font-weight:normal;">${singlecheliang.ranliaozhonglei}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>排量ML : <span style="font-weight:normal;">${singlecheliang.pailiang}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>功率KW : <span style="font-weight:normal;">${singlecheliang.gonglv}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>制造厂家名称 : <span style="font-weight:normal;">${singlecheliang.changjiamingcheng}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>轮距mm(前后) : <span style="font-weight:normal;">
												<c:if test="${singlecheliang.lunjuqian != '' && not empty singlecheliang.lunjuqian}">
													${singlecheliang.lunjuqian} /
												</c:if>
												 ${singlecheliang.lunjuhou}
											</span>
						</label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>轮胎数 : <span style="font-weight:normal;">${singlecheliang.luntaishu}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>轮胎规格 : <span style="font-weight:normal;">${singlecheliang.luntaiguige}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>钢板弹簧片数 : <span style="font-weight:normal;">${singlecheliang.gangbantanhuangpianshu}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>轴距mm : <span style="font-weight:normal;">${singlecheliang.zhouju}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>轴数 : <span style="font-weight:normal;">${singlecheliang.zhoushu}</span></label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>外廓尺寸(长宽高)mm : <span style="font-weight:normal;">${singlecheliang.waikuochicun}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>货厢内部尺寸(长宽高)mm : <span style="font-weight:normal;">
													 		<c:if test="${singlecheliang.huoxiangchang != '' && not empty singlecheliang.huoxiangchang}">
																${singlecheliang.huoxiangchang} /
															</c:if>
															<c:if test="${singlecheliang.huoxiangkuan != '' && not empty singlecheliang.huoxiangkuan}">
																${singlecheliang.huoxiangkuan} /
															</c:if>
															 ${singlecheliang.huoxianggao}
													  </span>
						</label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>总质量（kg） : <span style="font-weight:normal;">${singlecheliang.zongzhiliang}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>核定载质量（kg） : <span style="font-weight:normal;">${singlecheliang.hedingzhaizhiliang}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>准牵引总质量（kg） : <span style="font-weight:normal;">${singlecheliang.zhunqianyingzongzhiliang}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>整备质量（kg） : <span style="font-weight:normal;">${singlecheliang.zhengbeizhiliang}</span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆道路运输证号 : <span style="font-weight:normal;">${singlecheliang.cheliangdaoluyunshuzhenghao}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>道路运输证年审日期 : <span style="font-weight:normal;"><fmt:formatDate value="${singlecheliang.daoluyunshuzhengnianshenriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>经营范围 : <span style="font-weight:normal;">${jingyingfanweiStr}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>罐体检测日期 : <span style="font-weight:normal;"><fmt:formatDate value="${singlecheliang.guantijianceriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>二级维护日期 : <span style="font-weight:normal;"><fmt:formatDate value="${singlecheliang.erjiweihuriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>等级评定日期 : <span style="font-weight:normal;"><fmt:formatDate value="${singlecheliang.dengjipingdingriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>购车费 : <span style="font-weight:normal;">${singlecheliang.gouchefei}</span></label>
					</div>			
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
		        		<label>驾押员1 : 
		        						<span style="font-weight:normal;">
		        							${jiashiyuan1}
		        						</span>
		        		</label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>驾押员2 : 
		        						<span style="font-weight:normal;">
        									${jiashiyuan2}
		        						</span>
		        		</label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>操作员 : <span style="font-weight:normal;">${singlecheliang.caozuoyuan}</span></label>
					</div>					
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>操作日期  : <span style="font-weight:normal;"><fmt:formatDate value="${singlecheliang.caozuoriqi}" pattern="yyyy-MM-dd"/></span></label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>用户描述 : <span style="font-weight:normal;">${singlecheliang.yonghumiaoshu}</span></label>
					</div>	
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>关联车辆  : 
							<span style="font-weight:normal;">
								 <c:forEach items="${guanlianchelianglist}" var="guanliancheliang">
									<a href="${pageContext.request.contextPath}/cheLiangXiangXi?id=${guanliancheliang.id}">${guanliancheliang.chepaihao}，</a>									 
					       		 </c:forEach>	
							</span>
						</label>
					</div>		
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>	
					
					<div class="form-group" style="width: 30%; float: left; margin-left: 30px">
						<label>车辆状态  : <span style="font-weight:normal;">${singlecheliang.zhuangtai}</span></label>
					</div>		
					<div class="form-group" style="width: 30%; float: left; margin-left: 10%">
						<label>更多信息  : 
							
							<a href="${pageContext.request.contextPath}/xinCheXiangXi?chepaihao=${singlecheliang.chepaihao}" target="_blank" >点击查看</a> 
						
						</label>
					</div>	
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<div style="margin-left: 20px;width: 100%;">
						<c:forEach items="${picturelist}" var="picturepaths">
							<div style="margin-left: 10px;margin-top: 10px;float: left;">
								 <a class="example-image-link" href="${picturepaths}" data-lightbox="example-set" >
								 	<img class="example-image" src="${picturepaths}" width="300px" height="200px"/>
								 </a>
							</div>
				        </c:forEach>					
					</div>
					
					<!-- 清楚浮动 -->
					<div style="clear: both;"></div>
					
					<br/>
					
					<a href="${pageContext.request.contextPath}/returnCheLiang"> <button type="button"  class="btn btn-success" style="float: left; margin-left: 30px">返回</button></a>
					
					<br/>
					<br/>
					<br/>
											
				</form>	
				<!-- end -->
					
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="js/lightbox-plus-jquery.js"></script>
	
	<script>
		
	</script>	
</body>

</html>
