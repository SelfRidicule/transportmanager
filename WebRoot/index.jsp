<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!-- 让滚动条透明 -->
	<style type="text/css">
		::-webkit-scrollbar{
		  display:none;
		}
	</style>
	
	<script type="text/javascript">
		
		function gongzuomenhu(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpGongZuoMenHu";
		}
		
		function dept(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpDept";
		}
		
		function users(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpUsers";
		}
		
		function customer(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpCustomer";
		}
		
		function cheliang(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpCheLiang";			
		}
		
		function cheliangguanli(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpCheLiangGuanLi";			
		}
		
		function baoxian(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpBaoXian";			
		}
		
		function zhengjian(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpZhengJian";			
		}
		
		function cheliangguanxi(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpCheLiangGuanXi";			
		}

		function nianshen(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpNianShen";			
		}
		
		function jiashiyuan(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpJiaShiYuan";			
		}
		
		function jiashiyuanshenhe(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpJiaShiYuanShenHe";			
		}
		
		function jiashiyuannianshen(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpJiaShiYuanNianShen";			
		}
		
		function yundan(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpYunDan";			
		}
		
		function yundanshenhe(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpYunDanShenHe";			
		}

		function xinche(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpXinChe";			
		}
		
		function tourushenhe(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpTouRuShenHe";			
		}
		
		function gouzhishui(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpGouZhiShui";
		}
		
		function yingyunzheng(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpYingYunZheng";
		}
		
		function baoxianchudan(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpBaoXianChuDan";
		}

		function cailiaozhengli(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpCaiLiaoZhengLi";
		}

		function feiyongjiesuan(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpFeiYongJieSuan";
		}
		
		function zerenren(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpZeRenRen";
		}
		
		function fenguanlingdao(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpFenGuanLingDao";
		}
		
		function weixianpin(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpWeiXianPin";
		}

		function yingshoukuan(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpYingShouKuan";
		}

		function kaipiao(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpKaiPiao";
		}
		
		function jiesuandan(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpJieSuanDan";
		}

		function quanxian(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpQuanXian";
		}

		function updatepassword(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/updateuserspassword.jsp";
		}
		
		function gerenguanli(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/updategerenguanli.jsp";
		}

		function congyezige(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpCongYeZiGe";
		}

		function kaipiaoshenqing(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpKaiPiaoShenQing";
		}
		
		function fenguankaipiaoshenhe(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpFenGuanKaiPiaoShenHe";
		}

		function zongjinglikaipiaoshenhe(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpZongJingLiKaiPiaoShenHe";
		}
		
		function yingshoukuankaipiao(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpYingShouKuanKaiPiao";
		}

		function jiesuanshenqing(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpJieSuanShenQing";
		}
		
		function zongjinglijiesuanshenhe(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpZongJingLiJieSuanShenHe";
		}
		
		function dongshizhangjiesuanshenhe(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpDongShiZhangJieSuanShenHe";
		}
		
		function yingshoukuanjiesuan(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpYingShouKuanJieSuan";
		}

		function feiyongshouqu(){
			document.getElementById("myiframe").src="${pageContext.request.contextPath}"+"/jumpFeiYongShouQu";
		}

	</script>

</head>

<body>
	<jsp:include page="/title.jsp"></jsp:include>
	
	<!--
		左边菜单栏
    -->	
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		
		<ul class="nav menu">
			<!--  class="active" 代表被选中  -->
			
			
			<c:forEach items="${usersquanxianlist}" var="usersquanxian">
				<c:if test="${usersquanxian.quanxianbumen == '工作门户' && usersquanxian.chakan == '1' }">
					<li onclick="gongzuomenhu()"><a href="#"><span class="glyphicon glyphicon-user"/> 工作门户</a></li>
				</c:if>
	        </c:forEach>
			
			
			<c:forEach items="${usersquanxianlist}" var="usersquanxian">
				<c:if test="${usersquanxian.quanxianbumen == '用户管理' && usersquanxian.chakan == '1' }">
					<li onclick="users()"><a href="#"><span class="glyphicon glyphicon-user"/> 用户管理</a></li>
				</c:if>
	        </c:forEach>
			
			<c:forEach items="${usersquanxianlist}" var="usersquanxian">
				<c:if test="${usersquanxian.quanxianbumen == '权限设置' && usersquanxian.chakan == '1' }">
					<li onclick="quanxian()"><a href="#"><span class="glyphicon glyphicon-stats"/> 权限设置</a></li>
				</c:if>
	        </c:forEach>
	        
	        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
				<c:if test="${usersquanxian.quanxianbumen == '部门管理' && usersquanxian.chakan == '1' }">
					<li onclick="dept()"><a href="#"><span class="glyphicon glyphicon-list-alt"/> 部门管理</a></li>
				</c:if>
	        </c:forEach>
	        
			
			<li class="parent">
				
				<c:forEach items="${usersquanxianlist}" var="usersquanxian">
					<c:if test="${usersquanxian.quanxianbumen == '安全管理' && usersquanxian.chakan == '1' }">
						<a href="#" id="menu1">
							<span  class="glyphicon glyphicon-list"></span> 安全管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><span class="glyphicon glyphicon-resize-full"/> 
						</a>
					</c:if>
	        	</c:forEach>
				
				<ul class="children collapse" id="sub-item-1">
					 
					 <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '车辆管理' && usersquanxian.chakan == '1' }">
							<li onclick="cheliang()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 车辆管理
								</a>
							</li>
						</c:if>
			         </c:forEach>
			         
			         <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '关系建立' && usersquanxian.chakan == '1' }">
							<li onclick="cheliangguanxi()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 关系建立
								</a>
							</li>
						</c:if>
			         </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '保险管理' && usersquanxian.chakan == '1' }">
							<li onclick="baoxian()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 保险管理
								</a>
							</li>	
						</c:if>
			        </c:forEach>
					
					<%-- <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '证件管理' && usersquanxian.chakan == '1' }">
							<li onclick="zhengjian()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 证件管理
								</a>
							</li>
						</c:if>
			        </c:forEach> --%>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '年审管理' && usersquanxian.chakan == '1' }">
							<li onclick="nianshen()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 年审管理
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
				</ul>
			</li>
			
			<li class="parent ">
			
				<c:forEach items="${usersquanxianlist}" var="usersquanxian">
					<c:if test="${usersquanxian.quanxianbumen == '驾驶员管理' && usersquanxian.chakan == '1' }">
						<a href="#" id="menu2">
							<span class="glyphicon glyphicon-list"></span> 驾驶员管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><span class="glyphicon glyphicon-resize-full"></span></span> 
						</a>
					</c:if>
	        	</c:forEach>
				
				<ul class="children collapse" id="sub-item-2">
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '驾驶员资料' && usersquanxian.chakan == '1' }">
							<li onclick="jiashiyuan()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 驾驶员资料
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '驾驶员审核' && usersquanxian.chakan == '1' }">
							<li onclick="jiashiyuanshenhe()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 驾驶员审核
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '驾驶员年审' && usersquanxian.chakan == '1' }">
							<li onclick="jiashiyuannianshen()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 驾驶员年审
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
				</ul>
			</li>
			
			<li class="parent ">
				
				<c:forEach items="${usersquanxianlist}" var="usersquanxian">
					<c:if test="${usersquanxian.quanxianbumen == '新车入户' && usersquanxian.chakan == '1' }">
						<a href="#" id="menu3">
							<span class="glyphicon glyphicon-list"></span> 新车入户 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><span class="glyphicon glyphicon-resize-full"></span></span> 
						</a>
					</c:if>
	        	</c:forEach>
				
				<ul class="children collapse" id="sub-item-3">
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '新车管理' && usersquanxian.chakan == '1' }">
							<li onclick="xinche()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 新车管理
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '投入审核和申请' && usersquanxian.chakan == '1' }">
							<li onclick="tourushenhe()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 投入审核和申请
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '车管业务' && usersquanxian.chakan == '1' }">
							<li onclick="gouzhishui()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 车管业务
								</a>
							</li>
						</c:if>
			        </c:forEach>
			        
			        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '运管业务' && usersquanxian.chakan == '1' }">
							<li onclick="yingyunzheng()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 运管业务
								</a>
							</li>	
						</c:if>
			        </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '保险出单' && usersquanxian.chakan == '1' }">
							<li onclick="baoxianchudan()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 保险出单
								</a>
							</li>
						</c:if>
			        </c:forEach>
			        
			        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '材料整理档案建立' && usersquanxian.chakan == '1' }">
							<li onclick="cailiaozhengli()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 材料整理档案建立
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '费用结算' && usersquanxian.chakan == '1' }">
							<li onclick="feiyongjiesuan()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 费用结算
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '责任人签字' && usersquanxian.chakan == '1' }">
							<li onclick="zerenren()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 责任人签字
								</a>
							</li>
						</c:if>
			        </c:forEach>
			        
			        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '分管领导意见' && usersquanxian.chakan == '1' }">
							<li onclick="fenguanlingdao()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 分管领导意见
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					
					<!-- <li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"/> 财务收款
						</a>
					</li> -->
				</ul>
			</li>
			
			<li class="parent ">
			
				<c:forEach items="${usersquanxianlist}" var="usersquanxian">
					<c:if test="${usersquanxian.quanxianbumen == '业务管理' && usersquanxian.chakan == '1' }">
						<a href="#" id="menu4">
							<span class="glyphicon glyphicon-list"></span> 业务管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><span class="glyphicon glyphicon-resize-full"></span></span> 
						</a>
					</c:if>
	        	</c:forEach>
				
				<ul class="children collapse" id="sub-item-4">
				
					 <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '客户管理' && usersquanxian.chakan == '1' }">
							<li onclick="customer()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 客户管理
								</a>
							</li>
						</c:if>
			        </c:forEach>
			        
			         <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '运单管理' && usersquanxian.chakan == '1' }">
							<li onclick="yundan()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 运单管理
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					 <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '运单审核' && usersquanxian.chakan == '1' }">
							<li onclick="yundanshenhe()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 运单审核
								</a>
							</li>
						</c:if>
			        </c:forEach>
			        
			        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '营收款管理' && usersquanxian.chakan == '1' }">
							<li onclick="yingshoukuan()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 营收款管理
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<!--     水平线       -->
					<li role="presentation" class="divider"></li>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '开票申请' && usersquanxian.chakan == '1' }">
							<li onclick="kaipiaoshenqing()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 开票申请
								</a>
							</li>
						</c:if>
			        </c:forEach>		
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '分管开票审核' && usersquanxian.chakan == '1' }">		
							<li onclick="fenguankaipiaoshenhe()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 开票审核(分管负责人)
								</a>
							</li>
						</c:if>
			        </c:forEach>			
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '总经理开票审核' && usersquanxian.chakan == '1' }">	
							<li onclick="zongjinglikaipiaoshenhe()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 开票审核(总经理)
								</a>
							</li>
						</c:if>
			        </c:forEach>		
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '开票' && usersquanxian.chakan == '1' }">	
							<li onclick="yingshoukuankaipiao()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 开票
								</a>
							</li>
						</c:if>
			        </c:forEach>	
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '开票管理' && usersquanxian.chakan == '1' }">
							<li onclick="kaipiao()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 开票管理
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<!--     水平线       -->
					<li role="presentation" class="divider"></li>
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '结算申请' && usersquanxian.chakan == '1' }">	
							<li onclick="jiesuanshenqing()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 结算申请
								</a>
							</li>
						</c:if>
			        </c:forEach>	
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '总经理结算审核' && usersquanxian.chakan == '1' }">	
							<li onclick="zongjinglijiesuanshenhe()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 结算审核(总经理)
								</a>
							</li>
						</c:if>
			        </c:forEach>	
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '董事长结算审核' && usersquanxian.chakan == '1' }">	
							<li onclick="dongshizhangjiesuanshenhe()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 结算审核(董事长)
								</a>
							</li>
						</c:if>
			        </c:forEach>		
					
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '结算' && usersquanxian.chakan == '1' }">	
							<li onclick="yingshoukuanjiesuan()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 结算
								</a>
							</li>
						</c:if>
			        </c:forEach>	
					
			        <c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '结算单管理' && usersquanxian.chakan == '1' }">
							<li onclick="jiesuandan()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 结算单管理
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
					<!--     水平线       -->
					<li role="presentation" class="divider"></li>
					
				</ul>
			</li>	
			
			<li class="parent ">
			
				<c:forEach items="${usersquanxianlist}" var="usersquanxian">
					<c:if test="${usersquanxian.quanxianbumen == '财务管理' && usersquanxian.chakan == '1' }">
						<a href="#" id="menu5">
							<span class="glyphicon glyphicon-list"></span> 财务管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><span class="glyphicon glyphicon-resize-full"></span></span> 
						</a>
					</c:if>
	        	</c:forEach>
				
				<ul class="children collapse" id="sub-item-5">
				
					<c:forEach items="${usersquanxianlist}" var="usersquanxian">
						<c:if test="${usersquanxian.quanxianbumen == '费用收取' && usersquanxian.chakan == '1' }">	
							<li onclick="feiyongshouqu()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 费用收取
								</a>
							</li>
						</c:if>
			        </c:forEach>
					
				</ul>
			</li>
			
			<c:forEach items="${usersquanxianlist}" var="usersquanxian">
				<c:if test="${usersquanxian.quanxianbumen == '危险品数据库' && usersquanxian.chakan == '1' }">
					<li onclick="weixianpin()"><a href="#"><span class="glyphicon glyphicon-info-sign"/> 危险品数据库</a></li>
				</c:if>
	        </c:forEach>
			
				
			<!-- <li><a href="#"><span class="glyphicon glyphicon-info-sign"/> 查询统计</a></li> -->

			<!--     水平线       -->
			<li role="presentation" class="divider"></li>
			
			<li class="parent ">
				<c:forEach items="${usersquanxianlist}" var="usersquanxian">
					<c:if test="${usersquanxian.quanxianbumen == '管理' && usersquanxian.chakan == '1' }">
						<a href="#" id="menu6">
							<span class="glyphicon glyphicon-list"></span> 管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><span class="glyphicon glyphicon-resize-full"></span></span> 
						</a>
						<ul class="children collapse" id="sub-item-6">
							<li onclick="cheliangguanli()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 车辆管理
								</a>
							</li>
							<li onclick="congyezige()">
								<a class="" href="#">
									<span class="glyphicon glyphicon-share-alt"/> 从业资格类别
								</a>
							</li>
						</ul>
					</c:if>
		        </c:forEach>
			</li>
			
			<!--     水平线       -->
			<li role="presentation" class="divider"></li>
			
			<c:if test="${ not empty users }">
				<li onclick="updatepassword()"><a href="#"><span class="glyphicon glyphicon-user"> 修改密码 </span></a></li>
				<!-- <li onclick="gerenguanli()"><a href="#"><span class="glyphicon glyphicon-user"> 个人管理 </span></a></li> -->
			</c:if>
			
			<li><a href="${pageContext.request.contextPath}/login.jsp"><span class="glyphicon glyphicon-user"> 切换登录 </span></a></li>
			
			<!--     水平线       -->
			<li role="presentation" class="divider"></li>
		</ul>
	</div><!--/.sidebar-->
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<!-- <script src="js/bootstrap.min.js"></script> -->
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	
	<script>
		$('#calendar').datepicker({
		});

		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		});
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		});
	</script>	
	<script>
		$("#menu1").click(function(){
 			 $("#sub-item-1").slideToggle();
		});
		$("#menu2").click(function(){
 			 $("#sub-item-2").slideToggle();
		});
		$("#menu3").click(function(){
 			 $("#sub-item-3").slideToggle();
		});
		$("#menu4").click(function(){
 			 $("#sub-item-4").slideToggle();
		});
		$("#menu5").click(function(){
 			 $("#sub-item-5").slideToggle();
		});
		$("#menu6").click(function(){
 			 $("#sub-item-6").slideToggle();
		});
	</script>		
	
	<!-- 内容 -->
	<c:forEach items="${usersquanxianlist}" var="usersquanxian">
		<c:if test="${usersquanxian.quanxianbumen == '工作门户' && usersquanxian.chakan == '1' }">
			
			<iframe  id="myiframe"  onload="iFrameHeight()" src="${pageContext.request.contextPath}/jumpGongZuoMenHu"  width="100%"  style="float: right; margin-top:-50px;"  scrolling="yes" frameborder="0">
			</iframe>
		
		</c:if>
		
		<c:if test="${usersquanxian.quanxianbumen == '工作门户' && usersquanxian.chakan != '1' }">
			
			<iframe  id="myiframe"  onload="iFrameHeight()" src="${pageContext.request.contextPath}/kongbai.jsp"  width="100%"  style="float: right; margin-top:-50px;"  scrolling="yes" frameborder="0">
			</iframe>
		
		</c:if>
    </c:forEach>
    
	
	<script type="text/javascript">
		
		function iFrameHeight() {
	        var ifm= document.getElementById("myiframe");
            ifm.height = document.documentElement.clientHeight+150;
   		}
			
	</script>
	
	
</body>
</html>