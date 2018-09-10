package com.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CaiLiaoZhengLi;
import com.entity.FeiYongJieSuan;
import com.entity.JinDu;
import com.entity.Users;
import com.model.CaiLiaoZhengLiModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianChuDanService;
import com.service.CaiLiaoZhengLiService;
import com.service.FeiYongJieSuanService;
import com.service.GouZhiShuiService;
import com.service.JinDuService;
import com.service.XinCheService;
import com.service.YingYunZhengService;

import net.sf.json.JSONArray;

/**
 *  材料整理 控制层 ( 材料整理、档案建立 )
 */
public class CaiLiaoZhengLiController extends ActionSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public CaiLiaoZhengLiController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private XinCheService xinCheService;
	
	private CaiLiaoZhengLiService caiLiaoZhengLiService;
	
	private JinDuService jinDuService;
	
	private GouZhiShuiService  gouZhiShuiService;
	
	private YingYunZhengService  yingYunZhengService;
	
	private BaoXianChuDanService  baoXianChuDanService;
	
	private FeiYongJieSuanService feiYongJieSuanService;
	
	
//	集合对象
	private static List<CaiLiaoZhengLi> cailiaozhenglilist;
//	单一对象
	private static CaiLiaoZhengLi singlecailiaozhengli;
	
	/**
	 * 属性
	 */
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String banlizhuangtai;	//办理状态
	
	private String  yicheyidang ;	//一车一档
	private String  yirenyidang;	//一人一档
	private String  fapiaojiaojie;	//发票交接	
	private String  fapiaojieshouren;	//发票接收人
	private String  dianzilujieshouren;	//电子路接收人
	private String  hetongqianding;	// 合同签订
	
	/**
	 *  跳转-材料整理 
	 */
	public String jumpCaiLiaoZhengLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-材料整理 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		 cailiaozhenglilist = caiLiaoZhengLiService.queryCaiLiaoZhengLiWeiBanLi();
		request.setAttribute("cailiaozhenglilist", cailiaozhenglilist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchCaiLiaoZhengLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		cailiaozhenglilist = caiLiaoZhengLiService.vagueSearchCaiLiaoZhengLi(bianhao, chepaihao, banlizhuangtai);
		request.setAttribute("cailiaozhenglilist", cailiaozhenglilist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  材料整理json
	 */
	public void caiLiaoZhengLiJson(){
		System.out.println(" 材料整理json ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(cailiaozhenglilist == null){
			return ;
		}
		
		List<CaiLiaoZhengLiModel> cailiaozhenglimodellist = CaiLiaoZhengLiModel.getCaiLiaoZhengLiModelList(cailiaozhenglilist);
		
		JSONArray ja = JSONArray.fromObject(cailiaozhenglimodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-添加材料整理
	 */
	public String jumpAddCaiLiaoZhengLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-添加材料整理 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 singlecailiaozhengli = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(chepaihao);
		request.setAttribute("singlecailiaozhengli", singlecailiaozhengli);
		
		return "success";
	}
	
	/**
	 *  添加材料整理 
	 */
	public String addCaiLiaoZhengLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 添加材料整理 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		得到材料整理业务对象
		
//		得到进度业务对象
		
		
//		得到session传递的参数
		Users users = (Users) session.getAttribute("users");
		
//		初始化必须值
		String chepaihao = singlecailiaozhengli.getChepaihao();
		String bianhao = singlecailiaozhengli.getBianhao();
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		Date   banliriqi = new Date();
		
//		修改材料整理对象
		singlecailiaozhengli.setCaiLiaoZhengLi( bianhao,  chepaihao,  banliriqi,
				 caozuoyuan, caozuoriqi, "已办理",
				 yicheyidang,  yirenyidang,  fapiaojiaojie,
				 fapiaojieshouren,  dianzilujieshouren,
				 hetongqianding);
//		添加材料整理对象
		caiLiaoZhengLiService.updateCaiLiaoZhengLi(singlecailiaozhengli);
		
		
//		修改进度
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
		jindu.setDangqianjindu("材料整理档案建立");
		jinDuService.updateJinDu(jindu);
		
//		判断是否全部办理
		
		
		
		
		String gouzhishuizhuangtai = gouZhiShuiService.queryGouZhiShuiChePaiHao(chepaihao).getBanlizhuangtai();
		String yingyunzhengzhuangtai = yingYunZhengService.queryYingYunZhengChePaiHao(chepaihao).getBanlizhuangtai();
		String baoxianchudanzhuangtai = baoXianChuDanService.queryBaoXianChuDanChePaiHao(chepaihao).getBanlizhuangtai();
		
//		全部办理 就添加 费用结算
		if("已办理".equals(gouzhishuizhuangtai) && "已办理".equals(yingyunzhengzhuangtai) && "已办理".equals(baoxianchudanzhuangtai) ){
			
			
			FeiYongJieSuan feiyongjiesuan = new FeiYongJieSuan();
			feiyongjiesuan.setFeiYongJieSuanXiangGuanXinXi( bianhao,  chepaihao,  new Date(),
					 "未办理",  caozuoyuan,  caozuoriqi);
			feiYongJieSuanService.addFeiYongJieSuan(feiyongjiesuan);
		}
		
		cailiaozhenglilist = caiLiaoZhengLiService.queryCaiLiaoZhengLiWeiBanLi();
		request.setAttribute("cailiaozhenglilist", cailiaozhenglilist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  跳转-修改材料整理
	 */
	public String jumpUpdateCaiLiaoZhengLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-修改材料整理 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		 singlecailiaozhengli = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(chepaihao);
		request.setAttribute("singlecailiaozhengli", singlecailiaozhengli);
		
		return "success";
	}
	
	/**
	 * 修改材料整理
	 */
	public String updateCaiLiaoZhengLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-修改材料整理 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
//		得到session传递的参数
		Users users = (Users) session.getAttribute("users");
		
//		初始化
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
//		赋值
		singlecailiaozhengli.setCaiLiaoZhengLiValue( caozuoyuan,  caozuoriqi, yicheyidang,  yirenyidang,  
												fapiaojiaojie, fapiaojieshouren,  dianzilujieshouren,hetongqianding);
//		修改材料整理
		caiLiaoZhengLiService.updateCaiLiaoZhengLi(singlecailiaozhengli);
		
		cailiaozhenglilist = caiLiaoZhengLiService.queryCaiLiaoZhengLiWeiBanLi();
		request.setAttribute("cailiaozhenglilist", cailiaozhenglilist);
		
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

	public String getYicheyidang() {
		return yicheyidang;
	}

	public void setYicheyidang(String yicheyidang) {
		this.yicheyidang = yicheyidang;
	}

	public String getYirenyidang() {
		return yirenyidang;
	}

	public void setYirenyidang(String yirenyidang) {
		this.yirenyidang = yirenyidang;
	}

	public String getFapiaojiaojie() {
		return fapiaojiaojie;
	}

	public void setFapiaojiaojie(String fapiaojiaojie) {
		this.fapiaojiaojie = fapiaojiaojie;
	}

	public String getFapiaojieshouren() {
		return fapiaojieshouren;
	}

	public void setFapiaojieshouren(String fapiaojieshouren) {
		this.fapiaojieshouren = fapiaojieshouren;
	}

	public String getDianzilujieshouren() {
		return dianzilujieshouren;
	}

	public void setDianzilujieshouren(String dianzilujieshouren) {
		this.dianzilujieshouren = dianzilujieshouren;
	}

	public String getHetongqianding() {
		return hetongqianding;
	}

	public void setHetongqianding(String hetongqianding) {
		this.hetongqianding = hetongqianding;
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

	public CaiLiaoZhengLiService getCaiLiaoZhengLiService() {
		return caiLiaoZhengLiService;
	}

	public void setCaiLiaoZhengLiService(CaiLiaoZhengLiService caiLiaoZhengLiService) {
		this.caiLiaoZhengLiService = caiLiaoZhengLiService;
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

	public FeiYongJieSuanService getFeiYongJieSuanService() {
		return feiYongJieSuanService;
	}

	public void setFeiYongJieSuanService(FeiYongJieSuanService feiYongJieSuanService) {
		this.feiYongJieSuanService = feiYongJieSuanService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
