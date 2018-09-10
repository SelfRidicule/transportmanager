package com.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.FenGuanLingDao;
import com.entity.JinDu;
import com.entity.Users;
import com.entity.XinChe;
import com.model.FenGuanLingDaoModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheLiangService;
import com.service.FenGuanLingDaoService;
import com.service.JinDuService;
import com.service.XinCheService;

import net.sf.json.JSONArray;

/**
 *  分管领导 控制层（分管领导意见）
 */
public class FenGuanLingDaoController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public FenGuanLingDaoController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private XinCheService xinCheService;
	
	private FenGuanLingDaoService fenGuanLingDaoService;
	
	private JinDuService jinDuService;
	
	private CheLiangService cheLiangService;		
	
	
//	集合对象
	private static List<FenGuanLingDao> fenguanlingdaolist;
//	单一对象
	private static FenGuanLingDao singlefenguanlingdao;
	
	
	/**
	 * 属性
	 */
	private String  bianhao;
	private String  chepaihao;
	private String  banlizhuangtai;
	
	private String fenguanlingdaoyijian;

	/**
	 *  跳转-分管领导
	 */
	public String jumpFenGuanLingDao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-分管领导");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		fenguanlingdaolist = fenGuanLingDaoService.queryFenGuanLingDaoWeiBanLi();
		
		request.setAttribute("fenguanlingdaolist", fenguanlingdaolist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchFenGuanLingDao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		fenguanlingdaolist = fenGuanLingDaoService.vagueSearchFenGuanLingDao(bianhao, chepaihao, banlizhuangtai);
		
		request.setAttribute("fenguanlingdaolist", fenguanlingdaolist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  分管领导 json
	 */
	public void fenGuanLingDaoJson(){
		System.out.println(" 分管领导 json ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(fenguanlingdaolist == null ){
			return ;
		}
		
		List<FenGuanLingDaoModel> fenGuanLingDaoModelList = FenGuanLingDaoModel.getFenGuanLingDaoModelList(fenguanlingdaolist);
		
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
	 *  跳转-添加分管领导
	 */
	public String jumpAddFenGuanLingDao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-添加分管领导 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 singlefenguanlingdao = fenGuanLingDaoService.queryFenGuanLingDaoChePaiHao(chepaihao);
		request.setAttribute("singlefenguanlingdao", singlefenguanlingdao);
		
		return "success";
	}
	
	/**
	 *  添加分管领导
	 */
	public String addFenGuanLingDao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 添加分管领导 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
				
		
//		得到传递的对象
		Users users = (Users) session.getAttribute("users");
		
//		初始化
		String bianhao = singlefenguanlingdao.getBianhao();
		String chepaihao = singlefenguanlingdao.getChepaihao();
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		Date   banliriqi = new Date();
		
		XinChe xinche = xinCheService.queryXinCheChePaiHao(chepaihao);
		
		Date   zhuceriqi = xinche.getShijian();
		
//		修改分管领导
		singlefenguanlingdao.setFenGuanLingDao(bianhao, chepaihao, caozuoyuan, caozuoriqi,
										"已办理", banliriqi, fenguanlingdaoyijian);
		fenGuanLingDaoService.updateFenGuanLingDao(singlefenguanlingdao);
		
//		修改 进度
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
		jindu.setDangqianjindu("分管领导意见");
		jinDuService.updateJinDu(jindu);
		
//		添加车辆----------
		
		CheLiang cheliang = new CheLiang();
		cheliang.setCheLiang( chepaihao, "", "" ,
				"请选择", "请选择" , "" ,
				 "", "" , "" ,
				"" , "" , "" ,
				"", "",
				"", "",
				 zhuceriqi, null, null,
				null, "" ,
				"" , caozuoyuan, caozuoriqi, "可用" );
		
		String chexing = xinche.getChexing();
		String cheliangleixing = xinche.getCheliangleixing();
		String pingpaixinghao = xinche.getPingpaixinghao();
		
		cheliang.setChexing(chexing);
		cheliang.setCheliangleixing(cheliangleixing);
		cheliang.setPingpaixinghao(pingpaixinghao);
		
		cheLiangService.addCheLiang(cheliang);
		
//		发送集合
		fenguanlingdaolist = fenGuanLingDaoService.queryFenGuanLingDaoWeiBanLi();
		request.setAttribute("fenguanlingdaolist", fenguanlingdaolist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  跳转-修改分管领导
	 */
	public String jumpUpdateFenGuanLingDao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-修改分管领导 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		 singlefenguanlingdao =  fenGuanLingDaoService.queryFenGuanLingDaoChePaiHao(chepaihao);
		request.setAttribute("singlefenguanlingdao", singlefenguanlingdao);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  修改分管领导
	 */
	public String updateFenGuanLingDao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 修改分管领导 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
//		得到传递的对象
		Users users = (Users) session.getAttribute("users");
//		初始化
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
//		修改
		singlefenguanlingdao.setFenGuanLingDaoValue( caozuoyuan,  caozuoriqi, fenguanlingdaoyijian);
		fenGuanLingDaoService.updateFenGuanLingDao(singlefenguanlingdao);
		
//		发送集合
		fenguanlingdaolist = fenGuanLingDaoService.queryFenGuanLingDaoWeiBanLi();
		request.setAttribute("fenguanlingdaolist", fenguanlingdaolist);
		
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

	public String getFenguanlingdaoyijian() {
		return fenguanlingdaoyijian;
	}

	public void setFenguanlingdaoyijian(String fenguanlingdaoyijian) {
		this.fenguanlingdaoyijian = fenguanlingdaoyijian;
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

	public FenGuanLingDaoService getFenGuanLingDaoService() {
		return fenGuanLingDaoService;
	}

	public void setFenGuanLingDaoService(FenGuanLingDaoService fenGuanLingDaoService) {
		this.fenGuanLingDaoService = fenGuanLingDaoService;
	}

	public JinDuService getJinDuService() {
		return jinDuService;
	}

	public void setJinDuService(JinDuService jinDuService) {
		this.jinDuService = jinDuService;
	}

	public CheLiangService getCheLiangService() {
		return cheLiangService;
	}

	public void setCheLiangService(CheLiangService cheLiangService) {
		this.cheLiangService = cheLiangService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
