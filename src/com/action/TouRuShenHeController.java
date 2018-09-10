package com.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXianChuDan;
import com.entity.CaiLiaoZhengLi;
import com.entity.GouZhiShui;
import com.entity.JinDu;
import com.entity.TouRuShenHe;
import com.entity.Users;
import com.entity.YingYunZheng;
import com.model.TouRuShenHeModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianChuDanService;
import com.service.CaiLiaoZhengLiService;
import com.service.GouZhiShuiService;
import com.service.JinDuService;
import com.service.TouRuShenHeService;
import com.service.XinCheService;
import com.service.YingYunZhengService;

import net.sf.json.JSONArray;

/**
 *  投入审核 控制层
 */
public class TouRuShenHeController extends  ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	/**
	 * 构造方法
	 */
	public TouRuShenHeController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private XinCheService xinCheService;
	
	private TouRuShenHeService touRuShenHeService;
	
	private JinDuService jinDuService;
	
	private GouZhiShuiService gouZhiShuiService;
	
	private YingYunZhengService yingYunZhengService;
	
	private BaoXianChuDanService baoXianChuDanService;
	
	private CaiLiaoZhengLiService caiLiaoZhengLiService;
	
	
//	集合对象
	private static List<TouRuShenHe> tourushenhelist;
//	单一对象
	private static TouRuShenHe singletourushenhe;
	
	/**
	 * 属性
	 */
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String banlizhuangtai;	//办理状态
	
	private String shenhejiaodai;	//审核交代
	private Date   shenpishijian;	//审批时间
	private String zhongduanxinghao;//终端型号
	private String zerenren;	//责任人
	
	
	
	
	/**
	 *  跳转-投入审核
	 */
	public String jumpTouRuShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-投入审核");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		tourushenhelist = touRuShenHeService.queryTouRuShenHeWeiBanLi();
		
		request.setAttribute("tourushenhelist", tourushenhelist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}

	/**
	 *  模糊查询
	 */
	public String vagueSearchTouRuShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);			

		
		tourushenhelist = touRuShenHeService.vagueSearchTouRuShenHe(bianhao, chepaihao, banlizhuangtai);
		
		request.setAttribute("tourushenhelist", tourushenhelist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  投入审核json
	 */
	public void touRuShenHeJson(){
		System.out.println("投入审核json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(tourushenhelist == null){
			return ;
		}
		
		List<TouRuShenHeModel> touRuShenHeModelList = TouRuShenHeModel.getTouRuShenHeModelList(tourushenhelist);
		
		JSONArray ja = JSONArray.fromObject(touRuShenHeModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-添加投入审核
	 */
	public String jumpAddTouRuShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加投入审核");
//		设置字符格式
		FontFormat.setFontFormat(response);			

		

		 singletourushenhe = touRuShenHeService.queryTouRuShenHeChePaiHao(chepaihao);
		request.setAttribute("singletourushenhe", singletourushenhe);
		
		return "success";
	}
	
	/**
	 *  添加投入审核
	 */
	public String addTouRuShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加投入审核");
//		设置字符格式
		FontFormat.setFontFormat(response);		


		
		
		
		TouRuShenHe tourushenhe = singletourushenhe;
		
		Users users = (Users) session.getAttribute("users");
		
		String chepaihao = tourushenhe.getChepaihao();
		String bianhao = tourushenhe.getBianhao();
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		
		tourushenhe.setTouRuShenHe(chepaihao, bianhao, shenhejiaodai,
								zhongduanxinghao, shenpishijian, "已办理", 
									caozuoyuan, caozuoriqi);
		tourushenhe.setZerenren(zerenren);
		
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
		jindu.setDangqianjindu("投入审核和申请");
		
		
		touRuShenHeService.updateTouRuShenHe(tourushenhe);
		jinDuService.updateJinDu(jindu);
		
//		添加 购置税 (车管业务)
		
		GouZhiShui mygouzhishui = new GouZhiShui();
		mygouzhishui.setGouZhiShuiXiangGuanXinXi( chepaihao,  bianhao,  caozuoyuan,
				 caozuoriqi,  caozuoriqi ,"未办理");
		gouZhiShuiService.addGouZhiShui(mygouzhishui);
		
//		营运证(运管业务)
		
		YingYunZheng yingyunzheng = new YingYunZheng(); 
		yingyunzheng.setYingYunZhengXiangGuanXinXi( chepaihao,  bianhao,
				 "未办理",  caozuoyuan,  caozuoriqi);
		yingYunZhengService.addYingYunZheng(yingyunzheng);
		
//		保险出单 业务
		
		BaoXianChuDan baoxianchudan = new BaoXianChuDan();
		baoxianchudan.setBaoXianChuDanXiangGuanXinXi( bianhao,  chepaihao,
				 "未办理",  caozuoriqi,  caozuoyuan,
				 caozuoriqi) ;
		baoXianChuDanService.addBaoXianChuDan(baoxianchudan);
		
//		材料整理 业务
		
		CaiLiaoZhengLi cailiaozhengli = new CaiLiaoZhengLi();
		cailiaozhengli.setCaiLiaoZhengLiXiangGuanXinXi( bianhao,  chepaihao,  caozuoriqi,
				 caozuoyuan,  caozuoriqi,  "未办理");
		caiLiaoZhengLiService.addCaiLiaoZhengLi(cailiaozhengli);
		
		 tourushenhelist =  touRuShenHeService.queryTouRuShenHeWeiBanLi();
		request.setAttribute("tourushenhelist", tourushenhelist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  跳转-修改投入审核
	 */
	public String jumpUpdateTouRuShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改投入审核");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		

		 singletourushenhe = touRuShenHeService.queryTouRuShenHeChePaiHao(chepaihao);
		request.setAttribute("singletourushenhe", singletourushenhe);
		
		return "success";
	}
	
	/**
	 *  修改投入审核
	 */
	public String updateTouRuShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改投入审核");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
	
		Users users =  (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		
		singletourushenhe.updateTouRuShenHe(shenhejiaodai, zhongduanxinghao, shenpishijian, caozuoyuan, caozuoriqi);
		singletourushenhe.setZerenren(zerenren);
		
		touRuShenHeService.updateTouRuShenHe(singletourushenhe);
		
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

	public String getShenhejiaodai() {
		return shenhejiaodai;
	}

	public void setShenhejiaodai(String shenhejiaodai) {
		this.shenhejiaodai = shenhejiaodai;
	}

	public Date getShenpishijian() {
		return shenpishijian;
	}

	public void setShenpishijian(Date shenpishijian) {
		this.shenpishijian = shenpishijian;
	}

	public String getZhongduanxinghao() {
		return zhongduanxinghao;
	}

	public void setZhongduanxinghao(String zhongduanxinghao) {
		this.zhongduanxinghao = zhongduanxinghao;
	}

	public String getZerenren() {
		return zerenren;
	}

	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
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

	public TouRuShenHeService getTouRuShenHeService() {
		return touRuShenHeService;
	}

	public void setTouRuShenHeService(TouRuShenHeService touRuShenHeService) {
		this.touRuShenHeService = touRuShenHeService;
	}

	public JinDuService getJinDuService() {
		return jinDuService;
	}

	public void setJinDuService(JinDuService jinDuService) {
		this.jinDuService = jinDuService;
	}

	public GouZhiShuiService getGouZhiShuiService() {
		return gouZhiShuiService;
	}

	public void setGouZhiShuiService(GouZhiShuiService gouZhiShuiService) {
		this.gouZhiShuiService = gouZhiShuiService;
	}

	public YingYunZhengService getYingYunZhengService() {
		return yingYunZhengService;
	}

	public void setYingYunZhengService(YingYunZhengService yingYunZhengService) {
		this.yingYunZhengService = yingYunZhengService;
	}

	public BaoXianChuDanService getBaoXianChuDanService() {
		return baoXianChuDanService;
	}

	public void setBaoXianChuDanService(BaoXianChuDanService baoXianChuDanService) {
		this.baoXianChuDanService = baoXianChuDanService;
	}

	public CaiLiaoZhengLiService getCaiLiaoZhengLiService() {
		return caiLiaoZhengLiService;
	}

	public void setCaiLiaoZhengLiService(CaiLiaoZhengLiService caiLiaoZhengLiService) {
		this.caiLiaoZhengLiService = caiLiaoZhengLiService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
