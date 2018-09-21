package com.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.FeiYongJieSuan;
import com.entity.JinDu;
import com.entity.Users;
import com.entity.ZeRenRen;
import com.model.FeiYongJieSuanModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FeiYongJieSuanService;
import com.service.JinDuService;
import com.service.XinCheService;
import com.service.ZeRenRenService;

import net.sf.json.JSONArray;

/**
 *  费用结算 控制层
 */
public class FeiYongJieSuanController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public FeiYongJieSuanController(){
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private XinCheService xinCheService;
	
	private FeiYongJieSuanService feiYongJieSuanService;
	
	private JinDuService jinDuService;
	
	private ZeRenRenService zeRenRenService;
	
	
//	集合对象
	private static List<FeiYongJieSuan> feiyongjiesuanlist;	
//	单一对象
	private  FeiYongJieSuan singlefeiyongjiesuan;
	
	/**
	 * 属性
	 */
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String banlizhuangtai;	//办理状态

	private Integer jiaoqiangxian;	//交强险
	private Date    jiaoqiangxianshijian;	//交强险时间
	private Integer shangyexian;	//	商业险
	private Date    shangyexianshijian;	//商业险时间
	private Integer guzhuhuotuanti;	//雇主或团体
	private Date    guzhuhuotuantishijian;	//雇主或团体时间
	private Integer chengyunren; 	//承运人
	private Date    chengyunrenshijian;	//承运人时间
	private Integer shiyongshui; 	//使用税
	private Date    shiyongshuishijian;	//使用税时间
	private Integer gouzhishui; 	//购置税
	private Date    gouzhishuishijian;	//购置税时间
	private Integer zhongduananzhuang; 	//终端安装
	private Date    zhongduananzhuangshijian;//终端安装时间
	private Integer anquanxuexi; 	//安全学习
	private Date    anquanxuexishijian;	//安全学习时间
	private Integer guanlifeiyong; 	//管理费用
	private Date    guanlifeiyongshijian;	//管理费用时间
	private Integer yujiaobaoxian;	//预交保险
	private Date    yujiaobaoxianshijian;	//预交保险时间
	private Integer jiashiyuan;	//驾驶员
	private Date    jiashiyuanshijian;	//驾驶员时间
	private Integer heji;	//合计
	private String  shoukuanren;	//收款人
	private String  beizhu;	//备注
	
	/**
	 *  跳转-费用结算
	 */
	public String jumpFeiYongJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-费用结算");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 feiyongjiesuanlist = feiYongJieSuanService.queryFeiYongJieSuanWeiBanLi();
		request.setAttribute("feiyongjiesuanlist", feiyongjiesuanlist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchFeiYongJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 feiyongjiesuanlist = feiYongJieSuanService.vagueSearchFeiYongJieSuan(bianhao, chepaihao, banlizhuangtai);
		request.setAttribute("feiyongjiesuanlist", feiyongjiesuanlist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  费用结算json
	 */
	public void feiYongJieSuanJson(){
		System.out.println("费用结算json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(feiyongjiesuanlist == null){
			return ;
		}
		
		List<FeiYongJieSuanModel> feiYongJieSuanModelList = FeiYongJieSuanModel.getFeiYongJieSuanModelList(feiyongjiesuanlist);
		
		JSONArray ja = JSONArray.fromObject(feiYongJieSuanModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-添加费用结算
	 */
	public String jumpAddFeiYongJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加费用结算");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		singlefeiyongjiesuan = feiYongJieSuanService.queryFeiYongJieSuanChePaiHao(chepaihao);
		request.setAttribute("singlefeiyongjiesuan", singlefeiyongjiesuan);
		
		session.setAttribute("singlefeiyongjiesuan", singlefeiyongjiesuan);
		
		return "success";
	}
	
	/**
	 *  添加费用结算
	 */
	public String addFeiYongJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加费用结算");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		singlefeiyongjiesuan = (FeiYongJieSuan) session.getAttribute("singlefeiyongjiesuan");
		
		Users users = (Users) session.getAttribute("users");
		
//		初始化
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		Date   banliriqi = new Date();
		String bianhao = singlefeiyongjiesuan.getBianhao();
		String chepaihao = singlefeiyongjiesuan.getChepaihao();
		
//		创建费用结算对象
		singlefeiyongjiesuan.setFeiYongJieSuanCaoZuo(bianhao, chepaihao, banliriqi, "已办理", caozuoyuan, caozuoriqi);
		singlefeiyongjiesuan.setFeiYongJieSuanFuZhi( jiaoqiangxian,  jiaoqiangxianshijian,shangyexian,  shangyexianshijian,
										guzhuhuotuanti,  guzhuhuotuantishijian,chengyunren,  chengyunrenshijian,  
										shiyongshui,shiyongshuishijian, gouzhishui,gouzhishuishijian, 
										zhongduananzhuang,zhongduananzhuangshijian,  anquanxuexi,anquanxuexishijian, 
										guanlifeiyong,guanlifeiyongshijian,  yujiaobaoxian,yujiaobaoxianshijian,  
										jiashiyuan,jiashiyuanshijian,  heji,  shoukuanren, beizhu);
//		修改费用结算
		feiYongJieSuanService.updateFeiYongJieSuan(singlefeiyongjiesuan);
		
		
//		修改进度
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
		jindu.setDangqianjindu("费用结算");
		jinDuService.updateJinDu(jindu);
		
//		添加责任人签字
		ZeRenRen zerenren = new ZeRenRen();
		zerenren.setZeRenRenXiangGuanXinXi( bianhao,  chepaihao,  caozuoyuan,
				 caozuoriqi,  "未办理",  banliriqi);
		zeRenRenService.addZeRenRen(zerenren);
		
//		
		feiyongjiesuanlist = feiYongJieSuanService.queryFeiYongJieSuanWeiBanLi();
		request.setAttribute("feiyongjiesuanlist", feiyongjiesuanlist);
		
		XinCheController.sendXinChe(xinCheService);
		
		session.removeAttribute("singlefeiyongjiesuan");
		
		return "success";
	}
	
	/**
	 *  跳转-修改费用结算
	 */
	public String jumpUpdateFeiYongJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改费用结算");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		singlefeiyongjiesuan = feiYongJieSuanService.queryFeiYongJieSuanChePaiHao(chepaihao);
		request.setAttribute("singlefeiyongjiesuan", singlefeiyongjiesuan);
		
		session.setAttribute("singlefeiyongjiesuan", singlefeiyongjiesuan);
		
		return "success";
	}
	
	/**
	 *  修改费用结算
	 */
	public String updateFeiYongJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改费用结算");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlefeiyongjiesuan = (FeiYongJieSuan) session.getAttribute("singlefeiyongjiesuan");
		
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsername();
		Date  caozuoriqi = new Date();
		
		singlefeiyongjiesuan.setCaozuoyuan(caozuoyuan);
		singlefeiyongjiesuan.setCaozuoriqi(caozuoriqi);
		
		singlefeiyongjiesuan.setFeiYongJieSuanFuZhi( jiaoqiangxian,  jiaoqiangxianshijian,shangyexian,  shangyexianshijian,
				guzhuhuotuanti,  guzhuhuotuantishijian,chengyunren,  chengyunrenshijian,  
				shiyongshui,shiyongshuishijian, gouzhishui,gouzhishuishijian, 
				zhongduananzhuang,zhongduananzhuangshijian,  anquanxuexi,anquanxuexishijian, 
				guanlifeiyong,guanlifeiyongshijian,  yujiaobaoxian,yujiaobaoxianshijian,  
				jiashiyuan,jiashiyuanshijian,  heji,  shoukuanren, beizhu);
		
		feiYongJieSuanService.updateFeiYongJieSuan(singlefeiyongjiesuan);
		
//		send
		feiyongjiesuanlist = feiYongJieSuanService.queryFeiYongJieSuanWeiBanLi();
		request.setAttribute("feiyongjiesuanlist", feiyongjiesuanlist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}

	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
	}

	public Integer getJiaoqiangxian() {
		return jiaoqiangxian;
	}

	public void setJiaoqiangxian(Integer jiaoqiangxian) {
		this.jiaoqiangxian = jiaoqiangxian;
	}

	public Date getJiaoqiangxianshijian() {
		return jiaoqiangxianshijian;
	}

	public void setJiaoqiangxianshijian(Date jiaoqiangxianshijian) {
		this.jiaoqiangxianshijian = jiaoqiangxianshijian;
	}

	public Integer getShangyexian() {
		return shangyexian;
	}

	public void setShangyexian(Integer shangyexian) {
		this.shangyexian = shangyexian;
	}

	public Date getShangyexianshijian() {
		return shangyexianshijian;
	}

	public void setShangyexianshijian(Date shangyexianshijian) {
		this.shangyexianshijian = shangyexianshijian;
	}

	public Integer getGuzhuhuotuanti() {
		return guzhuhuotuanti;
	}

	public void setGuzhuhuotuanti(Integer guzhuhuotuanti) {
		this.guzhuhuotuanti = guzhuhuotuanti;
	}

	public Date getGuzhuhuotuantishijian() {
		return guzhuhuotuantishijian;
	}

	public void setGuzhuhuotuantishijian(Date guzhuhuotuantishijian) {
		this.guzhuhuotuantishijian = guzhuhuotuantishijian;
	}

	public Integer getChengyunren() {
		return chengyunren;
	}

	public void setChengyunren(Integer chengyunren) {
		this.chengyunren = chengyunren;
	}

	public Date getChengyunrenshijian() {
		return chengyunrenshijian;
	}

	public void setChengyunrenshijian(Date chengyunrenshijian) {
		this.chengyunrenshijian = chengyunrenshijian;
	}

	public Integer getShiyongshui() {
		return shiyongshui;
	}

	public void setShiyongshui(Integer shiyongshui) {
		this.shiyongshui = shiyongshui;
	}

	public Date getShiyongshuishijian() {
		return shiyongshuishijian;
	}

	public void setShiyongshuishijian(Date shiyongshuishijian) {
		this.shiyongshuishijian = shiyongshuishijian;
	}

	public Integer getGouzhishui() {
		return gouzhishui;
	}

	public void setGouzhishui(Integer gouzhishui) {
		this.gouzhishui = gouzhishui;
	}

	public Date getGouzhishuishijian() {
		return gouzhishuishijian;
	}

	public void setGouzhishuishijian(Date gouzhishuishijian) {
		this.gouzhishuishijian = gouzhishuishijian;
	}

	public Integer getZhongduananzhuang() {
		return zhongduananzhuang;
	}

	public void setZhongduananzhuang(Integer zhongduananzhuang) {
		this.zhongduananzhuang = zhongduananzhuang;
	}

	public Date getZhongduananzhuangshijian() {
		return zhongduananzhuangshijian;
	}

	public void setZhongduananzhuangshijian(Date zhongduananzhuangshijian) {
		this.zhongduananzhuangshijian = zhongduananzhuangshijian;
	}

	public Integer getAnquanxuexi() {
		return anquanxuexi;
	}

	public void setAnquanxuexi(Integer anquanxuexi) {
		this.anquanxuexi = anquanxuexi;
	}

	public Date getAnquanxuexishijian() {
		return anquanxuexishijian;
	}

	public void setAnquanxuexishijian(Date anquanxuexishijian) {
		this.anquanxuexishijian = anquanxuexishijian;
	}

	public Integer getGuanlifeiyong() {
		return guanlifeiyong;
	}

	public void setGuanlifeiyong(Integer guanlifeiyong) {
		this.guanlifeiyong = guanlifeiyong;
	}

	public Date getGuanlifeiyongshijian() {
		return guanlifeiyongshijian;
	}

	public void setGuanlifeiyongshijian(Date guanlifeiyongshijian) {
		this.guanlifeiyongshijian = guanlifeiyongshijian;
	}

	public Integer getYujiaobaoxian() {
		return yujiaobaoxian;
	}

	public void setYujiaobaoxian(Integer yujiaobaoxian) {
		this.yujiaobaoxian = yujiaobaoxian;
	}

	public Date getYujiaobaoxianshijian() {
		return yujiaobaoxianshijian;
	}

	public void setYujiaobaoxianshijian(Date yujiaobaoxianshijian) {
		this.yujiaobaoxianshijian = yujiaobaoxianshijian;
	}

	public Integer getJiashiyuan() {
		return jiashiyuan;
	}

	public void setJiashiyuan(Integer jiashiyuan) {
		this.jiashiyuan = jiashiyuan;
	}

	public Date getJiashiyuanshijian() {
		return jiashiyuanshijian;
	}

	public void setJiashiyuanshijian(Date jiashiyuanshijian) {
		this.jiashiyuanshijian = jiashiyuanshijian;
	}

	public Integer getHeji() {
		return heji;
	}

	public void setHeji(Integer heji) {
		this.heji = heji;
	}

	public String getShoukuanren() {
		return shoukuanren;
	}

	public void setShoukuanren(String shoukuanren) {
		this.shoukuanren = shoukuanren;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HttpServletResponse getResponse() {
		return response;
	}


	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}


	public XinCheService getXinCheService() {
		return xinCheService;
	}


	public void setXinCheService(XinCheService xinCheService) {
		this.xinCheService = xinCheService;
	}


	public FeiYongJieSuanService getFeiYongJieSuanService() {
		return feiYongJieSuanService;
	}


	public void setFeiYongJieSuanService(FeiYongJieSuanService feiYongJieSuanService) {
		this.feiYongJieSuanService = feiYongJieSuanService;
	}


	public JinDuService getJinDuService() {
		return jinDuService;
	}


	public void setJinDuService(JinDuService jinDuService) {
		this.jinDuService = jinDuService;
	}


	public ZeRenRenService getZeRenRenService() {
		return zeRenRenService;
	}


	public void setZeRenRenService(ZeRenRenService zeRenRenService) {
		this.zeRenRenService = zeRenRenService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
