package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXian;
import com.entity.FenGuanLingDao;
import com.entity.JiaShiYuan;
import com.entity.NianShen;
import com.entity.TouRuShenHe;
import com.entity.Users;
import com.entity.XinChe;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.entity.ZhengJian;
import com.model.BaoXianSearchModel;
import com.model.FenGuanLingDaoModel;
import com.model.JiaShiYuanNianShenModel;
import com.model.MenHuJiaShiYuan;
import com.model.MenHuYunDan;
import com.model.MenHuZhengJian;
import com.model.NianShenModel;
import com.model.TouRuShenHeModel;
import com.model.XinCheModel;
import com.model.YingShouKuanModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianChuDanService;
import com.service.BaoXianService;
import com.service.CaiLiaoZhengLiService;
import com.service.CustomerService;
import com.service.FeiYongJieSuanService;
import com.service.FenGuanLingDaoService;
import com.service.GouZhiShuiService;
import com.service.JiaShiYuanService;
import com.service.NianShenService;
import com.service.TouRuShenHeService;
import com.service.XinCheService;
import com.service.YingShouKuanService;
import com.service.YingYunZhengService;
import com.service.YunDanService;
import com.service.ZeRenRenService;
import com.service.ZhengJianService;

import net.sf.json.JSONArray;

/**
 *  工作门户 控制层
 */
public class GongZuoMenHuController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public GongZuoMenHuController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	
//	业务对象
	private TouRuShenHeService touRuShenHeService;
	
	private GouZhiShuiService gouZhiShuiService;
	
	private YingYunZhengService yingYunZhengService;
	
	private BaoXianChuDanService baoXianChuDanService;
	
	private CaiLiaoZhengLiService caiLiaoZhengLiService;
	
	private FeiYongJieSuanService feiYongJieSuanService;
	
	private ZeRenRenService zeRenRenService;
	
	private FenGuanLingDaoService fenGuanLingDaoService;
	
	private ZhengJianService zhengJianService;
	
	private YunDanService yunDanService;
	
	private JiaShiYuanService jiaShiYuanService;
			
	private BaoXianService baoXianService;
	
	private NianShenService nianShenService;
			
	private XinCheService xinCheService;
	
	private YingShouKuanService yingShouKuanService;
	
	private CustomerService customerService;
	
	/**
	 *  跳转-工作门户  
	 */
	public String jumpGongZuoMenHu(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
//		对应进度的数量
		
		int tourushenhejindu = touRuShenHeService.getTouRuShenHeJinDu();
		
		int cheguanyewujindu = gouZhiShuiService.getGouZhiShuiJinDu();
		
		int yunguanyewujindu = yingYunZhengService.getYingYunZhengJinDu();
		
		int baoxianchudanjindu = baoXianChuDanService.getBaoXianChuDanJinDu();
		
		int cailiaozhenglijindu = caiLiaoZhengLiService.getCaiLiaoZhengLiJinDu();
		
		int feiyongjiesuanjindu = feiYongJieSuanService.getFeiYongJieSuanJinDu();
		
		int zerenrenqianzijindu = zeRenRenService.getZeRenRenJinDu();
		
		int fenguanlingdaojindu = fenGuanLingDaoService.getFenGuanLingDaoJinDu();
		
//		发送对象
		request.setAttribute("tourushenhejindu",tourushenhejindu );
		request.setAttribute("cheguanyewujindu", cheguanyewujindu);
		request.setAttribute("yunguanyewujindu",yunguanyewujindu );
		request.setAttribute("baoxianchudanjindu", baoxianchudanjindu);
		request.setAttribute("cailiaozhenglijindu", cailiaozhenglijindu);
		request.setAttribute("feiyongjiesuanjindu", feiyongjiesuanjindu);
		request.setAttribute("zerenrenqianzijindu", zerenrenqianzijindu);
		request.setAttribute("fenguanlingdaojindu", fenguanlingdaojindu);
		
		return "success";
	}
	
	/**
	 *  证件-工作门户json
	 */
	public void zhengJianMenHuJson(){

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
//		查询排序后的证件集合对象
		List<ZhengJian> zhengjianmenhulist = zhengJianService.queryZhengJianOrderByList();
		
		List<MenHuZhengJian> menhuzhengjianlist = MenHuZhengJian.getMenHuZhengJianList(zhengjianmenhulist);
		
		if(menhuzhengjianlist == null){
			return;
		}
		
		JSONArray ja = JSONArray.fromObject(menhuzhengjianlist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  运单-工作门户json
	 */
	public void yunDanMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		得到传递的用户对象
		Users users = (Users) session.getAttribute("users");
//		判断是否为null
		if(users == null){
			return ;
		}
		
		String caozuoyuan = users.getUsersid().toString();
		
//		查询排序后的运单集合对象
		List<YunDan> yundanmenhulist = yunDanService.queryYunDanCaoZuoYuanOrderByList(caozuoyuan , session);
		
		List<MenHuYunDan> menhuyundanlist = MenHuYunDan.getMenHuYunDanList(yundanmenhulist, customerService, yingShouKuanService);
		
		if(menhuyundanlist == null){
			return ;
		}
		
		JSONArray ja = JSONArray.fromObject(menhuyundanlist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  驾驶员审核-工作门户json
	 */
	public void jiaShiYuanMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
//		查询未审核的驾驶员集合对象	
		List<JiaShiYuan> jiashiyuanmenhulist = jiaShiYuanService.queryJiaShiYuanWeiShenHe();
		
		
		List<MenHuJiaShiYuan> menhujiashiyuanlist = MenHuJiaShiYuan.getMenHuJiaShiYuanList(jiashiyuanmenhulist);
		
		if(menhujiashiyuanlist == null){
			return ;
		}
		
		JSONArray ja = JSONArray.fromObject(menhujiashiyuanlist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  保险-工作门户json
	 */
	public void baoXianMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		查询排序后的保险集合对象
		List<BaoXian> baoxianmenhulist = baoXianService.queryBaoxianOrderByList();
		
		List<BaoXianSearchModel>  list = new BaoXianController().returnMenHubaoxianJson(baoxianmenhulist);
		
		if(list == null){
			return ;
		}
		
		JSONArray ja = JSONArray.fromObject(list);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  年审管理-工作门户json 
	 */
	public void nianShenGuanLiMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
//		得到传递的用户对象
		Users users = (Users) session.getAttribute("users");
//		判断是否为null
		if(users == null){
			return ;
		}
		
		List<NianShen> nianshenlist = nianShenService.queryCaoZuoYuan(users.getUsersid().toString());
		
		if(nianshenlist == null){
			return ;
		}
		
		List<NianShenModel> list = new NianShenController().returnMenHuNianShen(nianshenlist);
		
		JSONArray ja = JSONArray.fromObject(list);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	
	/**
	 *  驾驶员年审-工作门户json 
	 */
	public void jiaShiYuanNianShenMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
//		得到传递的用户对象
		Users users = (Users) session.getAttribute("users");
//		判断是否为null
		if(users == null){
			return ;
		}
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryCaoZuoYuan(users.getUsersid().toString());
		
		if(jiashiyuanlist == null){
			return ;
		}
		
		List<JiaShiYuanNianShenModel> jiaShiYuanNianShenModelList = JiaShiYuanNianShenModel.getMenHuJiaShiYuanNianShenModelList(jiashiyuanlist);
		
		
		JSONArray ja = JSONArray.fromObject(jiaShiYuanNianShenModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	

	/**
	 *  新车-工作门户json 
	 */
	public void xinCheMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		List<XinChe> xinchelist = xinCheService.queryXinCheList();
		
		List<XinCheModel> xinchemodellist = XinCheModel.getMenHuXinCheModelList(xinchelist, request,session);
		
		JSONArray ja = JSONArray.fromObject(xinchemodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  投入审核-工作门户json
	 */
	public void tourushenheMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		List<TouRuShenHe> tourushenhelist = touRuShenHeService.queryTouRuShenHeWeiBanLi();
		
		List<TouRuShenHeModel> touRuShenHeModelList = TouRuShenHeModel.getMenHuTouRuShenHeModelList(tourushenhelist);
		
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
	 *  分管领导-工作门户 json
	 */
	public void fenGuanLingDaoMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		List<FenGuanLingDao> fenguanlingdaoList = fenGuanLingDaoService.queryFenGuanLingDaoWeiBanLi();
		
		List<FenGuanLingDaoModel> fenGuanLingDaoModelList = FenGuanLingDaoModel.getMenHuFenGuanLingDaoModelList(fenguanlingdaoList);
		
		JSONArray ja = JSONArray.fromObject(fenGuanLingDaoModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  开票审核(分管负责人)-工作门户json
	 */
	public void kaiPiaoShenHeFenGuanMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		String Condition[]  = {"kaipiaoshenqing" ,"fenguankaipiaoshenhe"};
		String value[] = {"已申请", "未审核"};
		
		List<YingShouKuan> fenguankaipiaoshenhelist =  yingShouKuanService.queryYingShouKuanByConditionArrList(Condition, value);
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMenHuMethodNameList(fenguankaipiaoshenhelist, "jumpFenGuanKaiPiaoShenHe",yunDanService);
			
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  开票审核(总经理)-工作门户json
	 */
	public void kaiPiaoShenHeZongJingLiMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		String Condition[]  = {"fenguankaipiaoshenhe" ,"zongjinglikaipiaoshenhe"};
		String value[] = {"审核通过", "未审核"};
		
		List<YingShouKuan> zongjinglikaipiaoshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionArrList(Condition, value);
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMenHuMethodNameList(zongjinglikaipiaoshenhelist, "jumpZongJingLiKaiPiaoShenHe" ,yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	
	/**
	 * 结算审核(总经理)-工作门户json
	 */
	public void jieSuanShenHeZongJingLiMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		

		String Condition[]  = {"jiesuanshenqing" ,"zongjinglijiesuanshenhe"};
		String value[] = {"已申请", "未审核"};
		
		List<YingShouKuan> zongjinglijiesuanshenhelist =  yingShouKuanService.queryYingShouKuanByConditionArrList(Condition, value);
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMenHuMethodNameList(zongjinglijiesuanshenhelist, "jumpZongJingLiJieSuanShenHe",yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  结算审核(董事长)-工作门户json
	 */
	public void jieSuanShenHeDongShiZhangMenHuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		String Condition[]  = {"zongjinglijiesuanshenhe" ,"dongshizhangjiesuanshenhe"};
		String value[] = {"审核通过", "未审核"};
		
		List<YingShouKuan> dongshizhangjiesuanshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionArrList(Condition, value);
		
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMenHuMethodNameList(dongshizhangjiesuanshenhelist, "jumpDongShiZhangJieSuanShenHe",yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}

	/**
	 * get set
	 */
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

	public TouRuShenHeService getTouRuShenHeService() {
		return touRuShenHeService;
	}

	public void setTouRuShenHeService(TouRuShenHeService touRuShenHeService) {
		this.touRuShenHeService = touRuShenHeService;
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

	public FeiYongJieSuanService getFeiYongJieSuanService() {
		return feiYongJieSuanService;
	}

	public void setFeiYongJieSuanService(FeiYongJieSuanService feiYongJieSuanService) {
		this.feiYongJieSuanService = feiYongJieSuanService;
	}

	public ZeRenRenService getZeRenRenService() {
		return zeRenRenService;
	}

	public void setZeRenRenService(ZeRenRenService zeRenRenService) {
		this.zeRenRenService = zeRenRenService;
	}

	public FenGuanLingDaoService getFenGuanLingDaoService() {
		return fenGuanLingDaoService;
	}

	public void setFenGuanLingDaoService(FenGuanLingDaoService fenGuanLingDaoService) {
		this.fenGuanLingDaoService = fenGuanLingDaoService;
	}

	public ZhengJianService getZhengJianService() {
		return zhengJianService;
	}

	public void setZhengJianService(ZhengJianService zhengJianService) {
		this.zhengJianService = zhengJianService;
	}

	public YunDanService getYunDanService() {
		return yunDanService;
	}

	public void setYunDanService(YunDanService yunDanService) {
		this.yunDanService = yunDanService;
	}

	public JiaShiYuanService getJiaShiYuanService() {
		return jiaShiYuanService;
	}

	public void setJiaShiYuanService(JiaShiYuanService jiaShiYuanService) {
		this.jiaShiYuanService = jiaShiYuanService;
	}

	public BaoXianService getBaoXianService() {
		return baoXianService;
	}

	public void setBaoXianService(BaoXianService baoXianService) {
		this.baoXianService = baoXianService;
	}

	public NianShenService getNianShenService() {
		return nianShenService;
	}

	public void setNianShenService(NianShenService nianShenService) {
		this.nianShenService = nianShenService;
	}

	public XinCheService getXinCheService() {
		return xinCheService;
	}

	public void setXinCheService(XinCheService xinCheService) {
		this.xinCheService = xinCheService;
	}

	public YingShouKuanService getYingShouKuanService() {
		return yingShouKuanService;
	}

	public void setYingShouKuanService(YingShouKuanService yingShouKuanService) {
		this.yingShouKuanService = yingShouKuanService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	
	
}
