<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/jQuery.print.js"></script>
	
	<style type="text/css">
			body{
				font-family: "微软雅黑";
			}
	</style>
	
</head>

<body style="margin:0 auto;">
	<div style=" text-align:center; margin:0 auto; margin-top: 25px">
		<span style="font-size: 18px;font-weight: bold;">淮安交运危货运输有限公司新车入户流程表</span>
		<button type="button" class="print-link no-print" style="float: left; margin-left: 30px" onclick="jQuery.print()">打印</button>
	</div>
	<br/>
	<div style="float: left; margin-left: 15px;font-size: 16px">编号：${singlexinche.bianhao}</div>
	<div style="float: right; margin-right:20px;font-size: 16px">时间：${fn:substring(singlexinche.shijian,0,10)}</div>
	<table border="" cellspacing="" cellpadding="" width="130%" style="border-collapse: collapse; border-color: black;">
			<tr>
			  <td colspan="2" rowspan="2" align="center" valign="middle">投入车辆信息</td>
			  <td width="14%" height="36" align="center" valign="middle">车型类型 / 车辆品牌 / 车辆型号</td>
			  <td colspan="2" align="center" valign="middle">运输类别</td>
			  <td width="9%" align="center" valign="middle">联系人及联系电话</td>
			  <td colspan="2" align="center" valign="middle">责任人</td>
			  <td width="11%" rowspan="2" align="center" valign="middle">1、投入审核和申请</td>
			  <td width="15%" align="center" valign="middle">新车符合性初审及购车交代</td>
			  <td width="12%" align="center" valign="middle">运管审批时间</td>
			  <td width="12%" colspan="1" align="center" valign="middle">拟安装终端型号</td>
			  <td colspan="1" align="center" valign="middle">责任人</td>
		    </tr>
			<tr>
			  <td height="56" align="center">${singlexinche.chexing} / ${singlexinche.cheliangleixing} / ${singlexinche.pingpaixinghao}</td>
			  <td colspan="2" align="center">${singlexinche.yunshuleibie}</td>
			  <td align="center">${singlexinche.lianxiren}:${singlexinche.lianxidianhua}</td>
			  <td colspan="2" align="center">${singlexinche.zerenren}</td>
			  <td align="center">${singletourushenhe.shenhejiaodai}</td>
			  <td align="center">${fn:substring(singletourushenhe.shenpishijian,0,10)}</td>
			  <td colspan="1" align="center">${singletourushenhe.zhongduanxinghao}</td>
			  <td colspan="1" align="center">${singletourushenhe.zerenren}</td>
		  </tr>
			<tr>
			  <td height="42" colspan="3">2、材料收集、购置税办理、临牌办理、车辆行驶证办理</td>
			  <td colspan="3">3、材料收集、营运证办理、安全教育</td>
			  <td colspan="4">4、保险出单、材料扫描、电子档案建立、劳动防护用品配备</td>
			  <td colspan="3">6、费用结算，费用及到期时间填写规范</td>
		  </tr>
			<tr>
			  <td width="1%" rowspan="13" align="center">详细工作和需收集资料</td>
			  <td height="44" colspan="2">车辆一致性证书
			  		<c:if test="${ singlegouzhishui.yizhixingshouji == '已收集' }">
			  			<span>：已收集</span>
					</c:if>
		  			<c:if test="${ singlegouzhishui.yizhixing != '#' && not empty singlegouzhishui.yizhixing }">
						<a href="${singlegouzhishui.yizhixing}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td width="1%" rowspan="13" align="center">详细工作和需收集资料</td>
			  <td colspan="2">罐体产品质量说明书
			  		<c:if test="${ singleyingyunzheng.guantichanpinshouji == '已收集' }">
						<span>：已收集</span>
					</c:if>
			  		<c:if test="${ singleyingyunzheng.guantichanpin != '#' && not empty singleyingyunzheng.guantichanpin }">
						 <a href="${singleyingyunzheng.guantichanpin}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td rowspan="6" align="center">详细工作和需收集资料</td>
			  <td colspan="3">商业险保单
			 		 <c:if test="${ singlebaoxianchudan.shangyexianshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlebaoxianchudan.shangyexian != '#' && not empty singlebaoxianchudan.shangyexian }">
						<a href="${singlebaoxianchudan.shangyexian}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td align="center">交强险费用：</td>
			  <td align="center" width="8%">${singlefeiyongjiesuan.jiaoqiangxian}</td>
			  <td width="15%">到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.jiaoqiangxianshijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="42" colspan="2">车辆合格证
			  		<c:if test="${ singlegouzhishui.hegezhengshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlegouzhishui.hegezheng != '#' && not empty singlegouzhishui.hegezheng }">
						<a href="${singlegouzhishui.hegezheng}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">车辆罐检验报告
			  		<c:if test="${ singleyingyunzheng.cheliangguanshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.cheliangguan != '#' && not empty singleyingyunzheng.cheliangguan }">
						<a href="${singleyingyunzheng.cheliangguan}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="3">雇主责任
			  		<c:if test="${ singlebaoxianchudan.guzhuzerenshouji == '已收集' }">
						<span>：已收集</span>
					</c:if> 
			 		<c:if test="${ singlebaoxianchudan.guzhuzeren != '#' && not empty singlebaoxianchudan.guzhuzeren }">
						<a href="${singlebaoxianchudan.guzhuzeren}" target="_Blank" class="no-print">查看</a>
					</c:if> 
			  		或团体险保单
			  		<c:if test="${ singlebaoxianchudan.tuantixianshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlebaoxianchudan.tuantixian != '#' && not empty singlebaoxianchudan.tuantixian }">
						 <a href="${singlebaoxianchudan.tuantixian}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td align="center">商业险费用：</td>
			  <td align="center">${singlefeiyongjiesuan.shangyexian}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.shangyexianshijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="50" colspan="2">车辆四联发票
			  		<c:if test="${ singlegouzhishui.silianfapiaoshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlegouzhishui.silianfapiao != '#' && not empty singlegouzhishui.silianfapiao }">
						<a href="${singlegouzhishui.silianfapiao}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">初次检测设施设备配备情况查验登记表
			  		<c:if test="${ singleyingyunzheng.chucijianceshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.chucijiance != '#' && not empty singleyingyunzheng.chucijiance }">
						<a href="${singleyingyunzheng.chucijiance}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="3">防护用品配备（自留）</td>
			  <td align="center">雇主责任险或团体险费用：</td>
			  <td align="center">${singlefeiyongjiesuan.guzhuhuotuanti} </td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.guzhuhuotuantishijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="45" colspan="2">车辆交强险正副本和标贴
			  		<c:if test="${ singlegouzhishui.jiaoqiangxianshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlegouzhishui.jiaoqiangxian != '#' && not empty singlegouzhishui.jiaoqiangxian }">
						<a href="${singlegouzhishui.jiaoqiangxian}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">燃料消耗达标车型核查表
			  		<c:if test="${ singleyingyunzheng.ranshaoxiaohaoshouji == '已收集' }">
						<span>：已收集</span>
					</c:if>
			  		<c:if test="${ singleyingyunzheng.ranshaoxiaohao != '#' && not empty singleyingyunzheng.ranshaoxiaohao }">
						<a href="${singleyingyunzheng.ranshaoxiaohao}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="3">所有资料扫描（自留）</td>
			  <td align="center">承运人保险：</td>
			  <td align="center">${singlefeiyongjiesuan.chengyunren}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.chengyunrenshijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="42" colspan="2">临时牌证
			  		<c:if test="${ singlegouzhishui.linshipaizhengshouji == '已收集' }">
						<span>：已收集</span>
					</c:if>
			  		<c:if test="${ singlegouzhishui.linshipaizheng != '#' && not empty singlegouzhishui.linshipaizheng }">
						<a href="${singlegouzhishui.linshipaizheng}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">整车装备外观检视及人工测量记录表
			  		<c:if test="${ singleyingyunzheng.zhengchezhuangbeishouji == '已收集'} ">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.zhengchezhuangbei != '#' && not empty singleyingyunzheng.zhengchezhuangbei }">
						 <a href="${singleyingyunzheng.zhengchezhuangbei}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="3">建立电子档案存档（自留）</td>
			  <td align="center">车辆使用税：</td>
			  <td align="center">${singlefeiyongjiesuan.shiyongshui}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.shiyongshuishijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="31" colspan="2">车载终端型号
			  		<c:if test="${ singlegouzhishui.zhongduanxinghaoshouji == '已收集'}">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlegouzhishui.zhongduanxinghao != '#' && not empty singlegouzhishui.zhongduanxinghao }">
						 <a href="${singlegouzhishui.zhongduanxinghao}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">安全卡
			  		<c:if test="${ singleyingyunzheng.anquankashouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.anquanka != '#' && not empty singleyingyunzheng.anquanka }">
						<a href="${singleyingyunzheng.anquanka}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="3">&nbsp;</td>
			  <td align="center">车辆购置税：</td>
			  <td align="center">${singlefeiyongjiesuan.gouzhishui}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.gouzhishuishijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="41" colspan="2">车辆购置税证明
			  		<c:if test="${ singlegouzhishui.gouzhishuishouji == '已收集' }">
						<span>：已收集</span>
					</c:if>
			  		<c:if test="${ singlegouzhishui.gouzhishui != '#' && not empty singlegouzhishui.gouzhishui }">
						<a href="${singlegouzhishui.gouzhishui}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">二维与等评
			  		<c:if test="${ singleyingyunzheng.erweiyudengjiashouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.erweiyudengjia != '#' && not empty singleyingyunzheng.erweiyudengjia }">
						<a href="${singleyingyunzheng.erweiyudengjia}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="4">5、材料整理、档案建立</td>
			  <td align="center">车载终端安装和服务费用：</td>
			  <td align="center">${singlefeiyongjiesuan.zhongduananzhuang}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.zhongduananzhuangshijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="52" colspan="2">车辆行驶证
			  		<c:if test="${ singlegouzhishui.xingshizhengshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlegouzhishui.xingshizheng != '#' && not empty singlegouzhishui.xingshizheng }">
						<a href="${singlegouzhishui.xingshizheng}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">驾押人员材料、劳动合同
			  		<c:if test="${ singleyingyunzheng.yayuncailiaoshouji == '已收集' }">
						<span>：已收集</span>
					</c:if>
			  		<c:if test="${ singleyingyunzheng.yayuncailiao != '#' && not empty singleyingyunzheng.yayuncailiao }">
						<a href="${singleyingyunzheng.yayuncailiao}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td width="1%" rowspan="5" align="center">详细工作和需收集资料</td>
			  <td colspan="3">建立一车一档 ：${singlecailiaozhengli.yicheyidang}</td>
			  <td align="center">安全学习保证金：</td>
			  <td align="center">${singlefeiyongjiesuan.anquanxuexi}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.anquanxuexishijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="36" colspan="2">车辆登记证书
			  		<c:if test="${ singlegouzhishui.dengjizhengshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlegouzhishui.dengjizheng != '#' && not empty singlegouzhishui.dengjizheng }">
						<a href="${singlegouzhishui.dengjizheng}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">车辆照片
			  		<c:if test="${ singleyingyunzheng.cheliangzhaopianshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.cheliangzhaopian != '#' && not empty singleyingyunzheng.cheliangzhaopian }">
						<a href="${singleyingyunzheng.cheliangzhaopian}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="3">建立一人一档 ：${singlecailiaozhengli.yirenyidang}</td>
			  <td align="center">管理费用：</td>
			  <td align="center">${singlefeiyongjiesuan.guanlifeiyong}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.guanlifeiyongshijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="63" colspan="2">驾驶人员安驾证明
			  		<c:if test="${ singlegouzhishui.anjiazhengshouji == '已收集'}">
						<span>：已收集</span>
					</c:if>
			  		<c:if test="${ singlegouzhishui.anjiazheng != '#' && not empty singlegouzhishui.anjiazheng }">
						 <a href="${singlegouzhishui.anjiazheng}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">承运人责任险保单
			  		<c:if test="${ singleyingyunzheng.chengyunrenshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.chengyunren != '#' && not empty singleyingyunzheng.chengyunren }">
						 <a href="${singleyingyunzheng.chengyunren}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="3" valign="top"><p>发票交接：${singlecailiaozhengli.fapiaojiaojie}</p>
		      <p>接收人：${singlecailiaozhengli.fapiaojieshouren}</p></td>
			  <td align="center">预交保险费用：</td>
			  <td align="center">${singlefeiyongjiesuan.yujiaobaoxian}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.yujiaobaoxianshijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="38" colspan="2">车辆喷图标志
			  		<c:if test="${ singlegouzhishui.pentubiaozhishouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singlegouzhishui.pentubiaozhi != '#' && not empty singlegouzhishui.pentubiaozhi }">
						 <a href="${singlegouzhishui.pentubiaozhi}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2">岗前安全教育培训考核
			  		<c:if test="${ singleyingyunzheng.gangqiananquanshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.gangqiananquan != '#' && not empty singleyingyunzheng.gangqiananquan }">
						 <a href="${singleyingyunzheng.gangqiananquan}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2" align="center" valign="middle">电子路单工作交接</td>
			  <td width="15%" align="center" valign="middle">接收人：${singlecailiaozhengli.dianzilujieshouren}</td>
			  <td align="center">驾驶员保险：</td>
			  <td align="center">${singlefeiyongjiesuan.jiashiyuan}</td>
			  <td>到期日期：<fmt:formatDate value="${singlefeiyongjiesuan.jiashiyuanshijian}" type="date"/></td>
	      </tr>
			<tr>
			  <td height="39" colspan="2">
			  	
			    	车牌号
			    	<c:if test="${ singlegouzhishui.banlizhuangtai == '已办理' }">
						: ${singlegouzhishui.chepaihao }
					</c:if>
			    	
			  </td>
			  
			  <td colspan="2">车辆营运证
			  		<c:if test="${ singleyingyunzheng.yingyunzhengshouji == '已收集' }">
						<span>：已收集</span> 
					</c:if>
			  		<c:if test="${ singleyingyunzheng.yingyunzheng != '#' && not empty singleyingyunzheng.yingyunzheng }">
						<a href="${singleyingyunzheng.yingyunzheng}" target="_Blank" class="no-print">查看</a>
					</c:if>
			  </td>
			  <td colspan="2" align="center" valign="middle">合同签订：</td>
			  <td align="center" valign="middle">${singlecailiaozhengli.hetongqianding}</td>
			  <td align="center">合计：</td>
			  <td align="center">${singlefeiyongjiesuan.heji}</td>
			  <td>&nbsp;</td>
	      </tr>
			<tr>
			  <td height="37" colspan="2">
			  	责任人 
		  		  <c:if test="${ singlegouzhishui.zerenren != '' && not empty singlegouzhishui.zerenren }">
				  	:	${singlegouzhishui.zerenren}
				  </c:if>
			  </td>
			  <td colspan="2">
			  		责任人
		  		  <c:if test="${ singleyingyunzheng.zerenren != '' && not empty singleyingyunzheng.zerenren }">
				  	:	${singleyingyunzheng.zerenren}
				  </c:if>
			  
			  </td>
			  <td colspan="4">&nbsp;</td>
			  <td align="center">财务收款人：</td>
			  <td align="center">${singlefeiyongjiesuan.shoukuanren}</td>
			  <td>&nbsp;</td>
	      </tr>
			<tr>
			  <td height="50" colspan="5">以上流程及资料全部整理完成。责任人签名：${singlezerenren.zerenrenqianming}</td>
			  <td colspan="5">分管领导意见：${singlefenguanlingdao.fenguanlingdaoyijian}</td>
			  <td align="center">证件领取人：</td>
			  <td colspan="2">&nbsp;</td>
		  </tr>
	</table>
		
		<p>&nbsp;</p>
		
</body>
</html>