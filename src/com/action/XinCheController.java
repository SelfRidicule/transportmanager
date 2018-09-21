package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXianChuDan;
import com.entity.CaiLiaoZhengLi;
import com.entity.FeiYongJieSuan;
import com.entity.FenGuanLingDao;
import com.entity.GouZhiShui;
import com.entity.JinDu;
import com.entity.TouRuShenHe;
import com.entity.Users;
import com.entity.XinChe;
import com.entity.YingYunZheng;
import com.entity.ZeRenRen;
import com.model.XinCheModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianChuDanService;
import com.service.CaiLiaoZhengLiService;
import com.service.CheLiangGuanLiService;
import com.service.FeiYongJieSuanService;
import com.service.FenGuanLingDaoService;
import com.service.GouZhiShuiService;
import com.service.JinDuService;
import com.service.TouRuShenHeService;
import com.service.XinCheService;
import com.service.YingYunZhengService;
import com.service.ZeRenRenService;

import net.sf.json.JSONArray;

/**
 *  新车控制层
 */
public class XinCheController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 构造方法
	 */
	public XinCheController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	
	private CheLiangGuanLiService cheLiangGuanLiService;
	
	private XinCheService xinCheService;
	
	private JinDuService jinDuService;
	
	private TouRuShenHeService touRuShenHeService;
	
	private GouZhiShuiService gouZhiShuiService;
	
	private YingYunZhengService yingYunZhengService;
	
	private BaoXianChuDanService baoXianChuDanService;
	
	private CaiLiaoZhengLiService caiLiaoZhengLiService;
	
	private FeiYongJieSuanService feiYongJieSuanService;
	
	private ZeRenRenService zeRenRenService;
	
	private FenGuanLingDaoService fenGuanLingDaoService;
	
	
//	集合对象
	private static List<XinChe> xinchelist;
//	单一对象
	private  XinChe singlexinche;
	
	/**
	 * 属性
	 */
	private Integer id;	//id
	private String lianxiren;	//联系人
	private String lianxidianhua;	//联系电话
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String chexing;		//车型 (车辆型号)
	private String yunshuleibie;	//运输类别
	private String banlizhuangtai;	//办理状态
	private String jindu ;	//进度
	private String zerenren;	//责任人;
	private Date   shijian ;	//时间
	
	private String cheliangleixing;	
	private String pingpaixinghao;
	
	
	/**
	 *  跳转-新车
	 */
	public String jumpXinChe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		 xinchelist = xinCheService.queryXinCheList();
		
		request.setAttribute("xinchelist", xinchelist);
		
		return "success";
	}
	
	public static void sendXinChe(XinCheService xinCheService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
		
		
		List<XinChe> myxinchelist = xinCheService.queryXinCheList();
		
		session.setAttribute("myxinchelist", myxinchelist);
	}
	
	/**
	 *  判断是否存在编号
	 */
	public void existBianHao(){
//		设置字符格式
		FontFormat.setFontFormat(response);				
		
		
		
		int value = xinCheService.queryXinCheBianHaoShuLiang(bianhao);
		List list = new ArrayList();
		
		Map map = new HashMap();
		
//		判断是否存在
		if(value<1){
//			如果小于1返回err
			map.put("flag", "success");
			list.add(map);
		}else{
//			如果不是空返回success
			map.put("flag", "err");
			list.add(map);
		}
		
		JSONArray jo = JSONArray.fromObject(list);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 *  判断是否存在车牌号
	 */
	public void existChePaiHao(){
//		设置字符格式
		FontFormat.setFontFormat(response);			
		
		
		
		int value = xinCheService.queryXinCheChePaiHaoShuLiang(chepaihao);
		
		List list = new ArrayList();
		
		Map map = new HashMap();
		
//		判断是否存在
		if(value<1){
//			如果小于1返回err
			map.put("flag", "success");
			list.add(map);
		}else{
//			如果不是空返回success
			map.put("flag", "err");
			list.add(map);
		}
		
		JSONArray jo = JSONArray.fromObject(list);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  新车json
	 */
	public void xinCheJson(){
		System.out.println("新车json");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		判断是否为null
		if(xinchelist==null){
			return ;
		}
		
		List<XinCheModel> xinchemodellist = XinCheModel.getXinCheModelList(xinchelist, request,session);
		
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
	 *  模糊查询新车
	 */
	public String vagueSearchXinChe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询新车");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		 xinchelist = xinCheService.vagueSearchXinChe(bianhao, chepaihao, banlizhuangtai);
		
		request.setAttribute("xinchelist", xinchelist);
		
		session.setAttribute("dangqianjindu", jindu);
		
		return "success";
	}
	
	
	/**
	 *  跳转-添加新车
	 */
	public String jumpAddXinChe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加新车");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
		return "success";
	}
	
	/**
	 *  添加新车
	 */
	public String addXinChe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加新车");			
//		得到新车业务对象
		
//		得到进度业务对象
		
//		得到用户对象
		Users users = (Users) session.getAttribute("users");
		String caozuoyuan = users.getUsername();
		Date caozuoriqi = new Date();
		
		XinChe xinche = new XinChe();
		
//		因为第一步不能有车牌号  所以用编号代替
		chepaihao = bianhao;
		
		xinche.setXinChe( lianxiren,  lianxidianhua,  bianhao,
				 chepaihao,  chexing,  caozuoyuan,
				 caozuoriqi,  "已办理",  yunshuleibie,
				 shijian ,zerenren);
		
		xinche.setCheliangleixing(cheliangleixing);
		xinche.setPingpaixinghao(pingpaixinghao);
		
		xinCheService.addXinChe(xinche);
		
//		添加投入审核
		
		TouRuShenHe tourushenhe = new TouRuShenHe();
		tourushenhe.setTouRuShenHeXiangGuanXinXi( chepaihao,  bianhao,  "未办理",
				 caozuoyuan,  caozuoriqi , caozuoriqi);
		touRuShenHeService.addTouRuShenHe(tourushenhe);
		
		
		JinDu jindu = new JinDu();
		jindu.setJinDu(chepaihao, "新车管理");
		jinDuService.saveJinDu(jindu);
		
		 xinchelist = xinCheService.queryXinCheList();
		request.setAttribute("xinchelist", xinchelist);
		
		return "success";
	}
	
	/**
	 *  删除新车 TODO
	 */
	public String deleteXinChe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加新车");

		String id[] = request.getParameterValues("toolbar1");
//		判断是否选中
		if(id==null || id.length<1){
			return "success";
		}
	
//		得到新车业务对象
		
//		得到进度业务对象
		
//		得到投入审核业务对象 
		
//		车管业务对象
		
//		运管业务对象
		
//		保险出单业务对象
		
//		材料整理业务对象
		
//		费用结算业务对象
		
//		责任人业务对象
		
//		分管领导业务对象
		
		
		
		for (int i = 0; i < id.length; i++) {
			
			XinChe xinche = xinCheService.queryXinCheId(Integer.valueOf(id[i]));
			String chepaihao = xinche.getChepaihao();
			
			xinCheService.deleteXinCheId(Integer.valueOf(id[i]));
			
			JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
			if(jindu != null){
				jinDuService.deleteJinDu(jindu);
			}
			
//			投入审核
			touRuShenHeService.deleteTouRuShenHeChePaiHao(chepaihao);
//			车管业务
			gouZhiShuiService.deleteGouZhiShuiChePaiHao(chepaihao);
//			运管业务
			yingYunZhengService.deleteYingYunZhengChePaiHao(chepaihao);
//			保险出单
			baoXianChuDanService.deleteBaoXianChuDanChePaiHao(chepaihao);
//			材料整理
			caiLiaoZhengLiService.deleteCaiLiaoZhengLiChePaiHao(chepaihao);
//			费用结算
			feiYongJieSuanService.deleteFeiYongJieSuanChePaiHao(chepaihao);
//			责任人
			zeRenRenService.deleteZeRenRenChePaiHao(chepaihao);
//			分管领导
			fenGuanLingDaoService.deleteFenGuanLingDaoChePaiHao(chepaihao);
			
		}
		
		 xinchelist = xinCheService.queryXinCheList();
		request.setAttribute("xinchelist", xinchelist);
		
		return "success";
	}
	
	/**
	 *  新车详细 TODO
	 */
	public String xinCheXiangXi(){
		System.out.println("跳转-新车详细");
	
//		车辆管理业务
		
//		得到新车业务对象
		
//		得到投入审核业务对象 
		
//		车管业务对象
		
//		运管业务对象
		
//		保险出单业务对象
		
//		材料整理业务对象
		
//		费用结算业务对象
		
//		责任人业务对象
		
//		分管领导业务对象
		
		
//		新车
		XinChe singlexinche = xinCheService.queryXinCheChePaiHao(chepaihao);
		if(singlexinche == null){
			return "success";
		}
		
		String chexing = "" ;
		String cheliangleixing = "";
		String pingpaixinghao = "";
		
		try {
			Integer chexingid = Integer.valueOf(singlexinche.getChexing()) ;
			chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(chexingid).getName();
			
			Integer cheliangleixingid = Integer.valueOf(singlexinche.getCheliangleixing()) ;
			cheliangleixing = cheLiangGuanLiService.queryCheLiangGuanLiId(cheliangleixingid).getName();
			
			Integer pingpaixinghaoid = Integer.valueOf(singlexinche.getPingpaixinghao()) ;
			pingpaixinghao = cheLiangGuanLiService.queryCheLiangGuanLiId(pingpaixinghaoid).getName();
			
		} catch (Exception e) {
		}
		
		singlexinche.setChexing(chexing);
		singlexinche.setCheliangleixing(cheliangleixing);
		singlexinche.setPingpaixinghao(pingpaixinghao);
		
//		投入审核
		TouRuShenHe singletourushenhe = touRuShenHeService.queryTouRuShenHeChePaiHao(chepaihao);
//		购置税
		GouZhiShui singlegouzhishui = gouZhiShuiService.queryGouZhiShuiChePaiHao(chepaihao);
//		营运证
		YingYunZheng singleyingyunzheng = yingYunZhengService.queryYingYunZhengChePaiHao(chepaihao); 
//		保险出单
		BaoXianChuDan singlebaoxianchudan = baoXianChuDanService.queryBaoXianChuDanChePaiHao(chepaihao);
//		材料整理
		CaiLiaoZhengLi singlecailiaozhengli = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(chepaihao);
//		费用结算
		FeiYongJieSuan singlefeiyongjiesuan = feiYongJieSuanService.queryFeiYongJieSuanChePaiHao(chepaihao);
//		责任人
		ZeRenRen singlezerenren = zeRenRenService.queryZeRenRenChePaiHao(chepaihao);
//		分管领导
		FenGuanLingDao singlefenguanlingdao = fenGuanLingDaoService.queryFenGuanLingDaoChePaiHao(chepaihao);
		
//		------传递对象-------
		
//		新车
		request.setAttribute("singlexinche", singlexinche);
//		投入审核
		request.setAttribute("singletourushenhe", singletourushenhe);
//		购置税
		request.setAttribute("singlegouzhishui", singlegouzhishui);
//		营运证
		request.setAttribute("singleyingyunzheng",singleyingyunzheng );
//		保险出单
		request.setAttribute("singlebaoxianchudan", singlebaoxianchudan);
//		材料整理
		request.setAttribute("singlecailiaozhengli", singlecailiaozhengli );
//		费用结算
		request.setAttribute("singlefeiyongjiesuan", singlefeiyongjiesuan );
//		责任人
		request.setAttribute("singlezerenren", singlezerenren);
//		分管领导
		request.setAttribute("singlefenguanlingdao", singlefenguanlingdao);

		
		return "success";
	}
	
	/**
	 *  跳转-修改新车
	 */
	public String jumpUpdateXinChe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改新车");
//		得到新车业务对象
		
		
		 singlexinche = xinCheService.queryXinCheChePaiHao(chepaihao);
		request.setAttribute("singlexinche", singlexinche);
		session.setAttribute("singlexinche", singlexinche);
		
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
		return "success";
	}
	
	/**
	 *  修改新车
	 */
	public String updateXinChe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改新车");	
//		得到新车业务对象
		
//		得到传递的对象
		Users users = (Users) session.getAttribute("users");
		
		singlexinche = (XinChe) session.getAttribute("singlexinche");
		
//		初始化
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
//		得到车牌号
		String mychepaihao = singlexinche.getChepaihao();
		
//		因为第一步不能有车牌号  所以用编号代替
		chepaihao = bianhao;
		
//		赋值
		singlexinche.setXinCheValue( lianxiren,  lianxidianhua,  bianhao,
				chepaihao,  chexing,  caozuoyuan,
				 caozuoriqi,  yunshuleibie,  zerenren , shijian);
		
		singlexinche.setCheliangleixing(cheliangleixing);
		singlexinche.setPingpaixinghao(pingpaixinghao);
//		修改
		xinCheService.updateXinChe(singlexinche);
		
		
//		得到进度业务对象
		
		JinDu myjindu = jinDuService.queryJinDuInChePaiHao(mychepaihao);
		if(myjindu != null){
			myjindu.setChepaihao(chepaihao);
			jinDuService.updateJinDu(myjindu);
		}
		
//		得到投入审核业务对象 
		
		TouRuShenHe mytourushenhe = touRuShenHeService.queryTouRuShenHeChePaiHao(mychepaihao);
		if(mytourushenhe != null){
			mytourushenhe.setChepaihao(chepaihao);
			touRuShenHeService.updateTouRuShenHe(mytourushenhe);
		}
		
//		车管业务对象
		
		GouZhiShui mygouzhishui = gouZhiShuiService.queryGouZhiShuiChePaiHao(mychepaihao);
		if(mygouzhishui != null){
			mygouzhishui.setChepaihao(chepaihao);
			gouZhiShuiService.updateGouZhiShui(mygouzhishui);
		}
		
//		运管业务对象
		
		YingYunZheng myyingyunzheng = yingYunZhengService.queryYingYunZhengChePaiHao(mychepaihao);
		if(myyingyunzheng != null){
			myyingyunzheng.setChepaihao(chepaihao);
			yingYunZhengService.updateYingYunZheng(myyingyunzheng);
		}
		
//		保险出单业务对象
		
		BaoXianChuDan mybaoxianchudan = baoXianChuDanService.queryBaoXianChuDanChePaiHao(mychepaihao);
		if(mybaoxianchudan != null){
			mybaoxianchudan.setChepaihao(chepaihao);
			baoXianChuDanService.updateBaoXianChuDan(mybaoxianchudan);
		}
		
//		材料整理业务对象
		
		CaiLiaoZhengLi mycailiaozhengli = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(mychepaihao); 
		if(mycailiaozhengli != null ){
			mycailiaozhengli.setChepaihao(chepaihao);
			caiLiaoZhengLiService.updateCaiLiaoZhengLi(mycailiaozhengli);
		}
		
//		费用结算业务对象
		
		FeiYongJieSuan myfeiyongjiesuan = feiYongJieSuanService.queryFeiYongJieSuanChePaiHao(mychepaihao);
		if(myfeiyongjiesuan != null){
			myfeiyongjiesuan.setChepaihao(chepaihao);
			feiYongJieSuanService.updateFeiYongJieSuan(myfeiyongjiesuan);
		}
		
//		责任人业务对象
		
		ZeRenRen myzerenren = zeRenRenService.queryZeRenRenChePaiHao(mychepaihao);
		if(myzerenren != null){
			myzerenren.setChepaihao(chepaihao);
			zeRenRenService.updateZeRenRen(myzerenren);
		}
		
//		分管领导业务对象
		
		FenGuanLingDao myfenguanlingdao = fenGuanLingDaoService.queryFenGuanLingDaoChePaiHao(mychepaihao);
		if(myfenguanlingdao != null){
			myfenguanlingdao.setChepaihao(chepaihao);
			fenGuanLingDaoService.updateFenGuanLingDao(myfenguanlingdao);
		}
		
		 xinchelist = xinCheService.queryXinCheList();
		request.setAttribute("xinchelist", xinchelist);
		
		session.removeAttribute("singlexinche");
		
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getLianxidianhua() {
		return lianxidianhua;
	}

	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}

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

	public String getChexing() {
		return chexing;
	}

	public void setChexing(String chexing) {
		this.chexing = chexing;
	}

	public String getYunshuleibie() {
		return yunshuleibie;
	}

	public void setYunshuleibie(String yunshuleibie) {
		this.yunshuleibie = yunshuleibie;
	}


	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}

	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
	}

	public String getJindu() {
		return jindu;
	}

	public void setJindu(String jindu) {
		this.jindu = jindu;
	}

	public String getZerenren() {
		return zerenren;
	}

	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
	}

	public Date getShijian() {
		return shijian;
	}

	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}

	public String getCheliangleixing() {
		return cheliangleixing;
	}

	public void setCheliangleixing(String cheliangleixing) {
		this.cheliangleixing = cheliangleixing;
	}

	public String getPingpaixinghao() {
		return pingpaixinghao;
	}

	public void setPingpaixinghao(String pingpaixinghao) {
		this.pingpaixinghao = pingpaixinghao;
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

	public CheLiangGuanLiService getCheLiangGuanLiService() {
		return cheLiangGuanLiService;
	}

	public void setCheLiangGuanLiService(CheLiangGuanLiService cheLiangGuanLiService) {
		this.cheLiangGuanLiService = cheLiangGuanLiService;
	}

	public XinCheService getXinCheService() {
		return xinCheService;
	}

	public void setXinCheService(XinCheService xinCheService) {
		this.xinCheService = xinCheService;
	}

	public JinDuService getJinDuService() {
		return jinDuService;
	}

	public void setJinDuService(JinDuService jinDuService) {
		this.jinDuService = jinDuService;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
