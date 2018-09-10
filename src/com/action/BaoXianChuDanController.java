package com.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXianChuDan;
import com.entity.FeiYongJieSuan;
import com.entity.JinDu;
import com.entity.Users;
import com.model.BaoXianChuDanModel;
import com.myutils.FileManager;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianChuDanService;
import com.service.CaiLiaoZhengLiService;
import com.service.CheLiangService;
import com.service.FeiYongJieSuanService;
import com.service.GouZhiShuiService;
import com.service.JinDuService;
import com.service.YingYunZhengService;

import net.sf.json.JSONArray;

/**
 *  保险出单 控制层 (保险出单、材料扫描、电子档案建立、劳动防护用品配备)
 */
public class BaoXianChuDanController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public BaoXianChuDanController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private CheLiangService cheLiangService;
	
	private BaoXianChuDanService baoXianChuDanService;
	
	private JinDuService jinDuService;
	
	private GouZhiShuiService gouZhiShuiService ;
	
	private CaiLiaoZhengLiService  caiLiaoZhengLiService;
	
	private YingYunZhengService  yingYunZhengService;
	
	private FeiYongJieSuanService feiYongJieSuanService;
	
	
	
//	集合对象
	private static List<BaoXianChuDan> baoxianchudanlist;
//	单一对象
	private static BaoXianChuDan singlebaoxianchudan;
	
	/**
	 * 属性
	 */
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String banlizhuangtai;	//办理状态

	private File   shangyexian;	//商业险
	private String shangyexianFileName;	//FileName
	
	private File   guzhuzeren;	//雇主责任
	private String guzhuzerenFileName;	//FileName
	
	private File   tuantixian;	//团体险
	private String tuantixianFileName;	//FileName
	
	private String shangyexianshouji;	//商业险收集
	private String guzhuzerenshouji;	//雇主责任收集
	private String tuantixianshouji;	//团体险收集
	
	/**
	 *  跳转-保险出单
	 */
	public String jumpBaoXianChuDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-保险出单 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		baoxianchudanlist = baoXianChuDanService.queryBaoXianChuDanWeiBanLi();
		request.setAttribute("baoxianchudanlist", baoxianchudanlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchBaoXianChuDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		 baoxianchudanlist = baoXianChuDanService.vagueSearchBaoXianChuDan(bianhao, chepaihao, banlizhuangtai);
		request.setAttribute("baoxianchudanlist", baoxianchudanlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	/**
	 *  保险出单json
	 */
	public void	baoXianChuDanJson(){
		System.out.println("保险出单json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		if(baoxianchudanlist == null){
			return ;
		}
		
		List<BaoXianChuDanModel> baoxianchudanmodellist =  BaoXianChuDanModel.getBaoXianChuDanModel(baoxianchudanlist);
		
		JSONArray ja = JSONArray.fromObject(baoxianchudanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	
	/**
	 *  跳转-添加保险出单
	 */
	public String jumpAddBaoXianChuDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-添加保险出单");
//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
		
		singlebaoxianchudan =  baoXianChuDanService.queryBaoXianChuDanChePaiHao(chepaihao);
		request.setAttribute("singlebaoxianchudan", singlebaoxianchudan);
		
		return "success";
	}
	
	/**
	 *  添加保险出单
	 */
	public String addBaoXianChuDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("添加保险出单");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		
		Users users = (Users) session.getAttribute("users");
		
//		获得必须值
		String chepaihao = singlebaoxianchudan.getChepaihao();
		String bianhao = singlebaoxianchudan.getBianhao();
		String caozuoyuan = users.getUsername();
		Date banliriqi = new Date();
		Date caozuoriqi = new Date();
		
		
//		得到存放图片指定路径
		String path = request.getRealPath("/uploads/baoxianchudan/"+chepaihao);
		Long  currentTime = System.currentTimeMillis();
		
		String shangyexianPath = FileManager.singleUploadFile(shangyexian, shangyexianFileName, path, currentTime);
		shangyexianPath = FileManager.formatFilePath(shangyexianPath);
		
		String guzhuzerenPath = FileManager.singleUploadFile(guzhuzeren, guzhuzerenFileName, path, currentTime);
		guzhuzerenPath = FileManager.formatFilePath(guzhuzerenPath);
		
		String tuantixianPath = FileManager.singleUploadFile(tuantixian,tuantixianFileName, path, currentTime);
		tuantixianPath = FileManager.formatFilePath(tuantixianPath);
		
		
		singlebaoxianchudan.setBaoXianChuDan(bianhao, chepaihao, "已办理", 
										banliriqi, caozuoyuan, caozuoriqi,
										shangyexianPath, guzhuzerenPath, tuantixianPath);
		
		singlebaoxianchudan.setBaoXianChuDanShouJi( shangyexianshouji,  guzhuzerenshouji, tuantixianshouji);
		
//		修改保险出单
		baoXianChuDanService.updateBaoXianChuDan(singlebaoxianchudan);
		
		
//		修改对应车牌号的进度
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
		jindu.setDangqianjindu("保险出单");
		jinDuService.updateJinDu(jindu);
		
		
//		判断是否全部办理
		
		
		
		
		String yingyunzhengzhuangtai = yingYunZhengService.queryYingYunZhengChePaiHao(chepaihao).getBanlizhuangtai();
		String gouzhishuizhuangtai = gouZhiShuiService.queryGouZhiShuiChePaiHao(chepaihao).getBanlizhuangtai();
		String cailiaozhenglizhuangtai = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(chepaihao).getBanlizhuangtai();
		
//		全部办理 就添加 费用结算
		if("已办理".equals(gouzhishuizhuangtai) && "已办理".equals(yingyunzhengzhuangtai) && "已办理".equals(cailiaozhenglizhuangtai) ){
			
			
			FeiYongJieSuan feiyongjiesuan = new FeiYongJieSuan();
			feiyongjiesuan.setFeiYongJieSuanXiangGuanXinXi( bianhao,  chepaihao,  new Date(),
					 "未办理",  caozuoyuan,  caozuoriqi);
			feiYongJieSuanService.addFeiYongJieSuan(feiyongjiesuan);
		}
		
		 baoxianchudanlist =  baoXianChuDanService.queryBaoXianChuDanWeiBanLi();
		request.setAttribute("baoxianchudanlist", baoxianchudanlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  跳转-修改保险出单
	 */
	public String jumpUpdateBaoXianChuDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-修改保险出单");
//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
		
		 singlebaoxianchudan = baoXianChuDanService.queryBaoXianChuDanChePaiHao(chepaihao);
		request.setAttribute("singlebaoxianchudan", singlebaoxianchudan);
		
		return "success";
	}
	
	/**
	 *  修改保险出单
	 */
	public String updateBaoXianChuDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("修改保险出单");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		String chepaihao = singlebaoxianchudan.getChepaihao();
		
//		得到存放图片指定路径
		String path = request.getRealPath("/uploads/baoxianchudan/"+chepaihao);
		Long  currentTime = System.currentTimeMillis();
		
//		商业险
		if(shangyexian != null){
			String shangyexianPath = FileManager.singleUploadFile(shangyexian, shangyexianFileName, path, currentTime);
			shangyexianPath = FileManager.formatFilePath(shangyexianPath);
			String str = singlebaoxianchudan.getShangyexian();
			FileManager.deleteUpLoadFile(str);
			singlebaoxianchudan.setShangyexian(shangyexianPath);
		}
		
//		雇主责任
		if(guzhuzeren != null){
			String guzhuzerenPath = FileManager.singleUploadFile(guzhuzeren, guzhuzerenFileName, path, currentTime);
			guzhuzerenPath = FileManager.formatFilePath(guzhuzerenPath);
			String str = singlebaoxianchudan.getGuzhuzeren();
			FileManager.deleteUpLoadFile(str);
			singlebaoxianchudan.setGuzhuzeren(guzhuzerenPath);
		}
		
//		团体险
		if(tuantixian != null){
			String tuantixianPath = FileManager.singleUploadFile(tuantixian,tuantixianFileName, path, currentTime);
			tuantixianPath = FileManager.formatFilePath(tuantixianPath);
			String str = singlebaoxianchudan.getTuantixian();
			FileManager.deleteUpLoadFile(str);
			singlebaoxianchudan.setTuantixian(tuantixianPath);
		}
		
//		修改保险出单
		singlebaoxianchudan.setCaozuoyuan(caozuoyuan);
		singlebaoxianchudan.setCaozuoriqi(caozuoriqi);
		singlebaoxianchudan.setBaoXianChuDanShouJi( shangyexianshouji,  guzhuzerenshouji, tuantixianshouji);
		baoXianChuDanService.updateBaoXianChuDan(singlebaoxianchudan);
		
		baoxianchudanlist =  baoXianChuDanService.queryBaoXianChuDanWeiBanLi();
		request.setAttribute("baoxianchudanlist", baoxianchudanlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
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

	public File getShangyexian() {
		return shangyexian;
	}

	public void setShangyexian(File shangyexian) {
		this.shangyexian = shangyexian;
	}

	public String getShangyexianFileName() {
		return shangyexianFileName;
	}

	public void setShangyexianFileName(String shangyexianFileName) {
		this.shangyexianFileName = shangyexianFileName;
	}

	public File getGuzhuzeren() {
		return guzhuzeren;
	}

	public void setGuzhuzeren(File guzhuzeren) {
		this.guzhuzeren = guzhuzeren;
	}

	public String getGuzhuzerenFileName() {
		return guzhuzerenFileName;
	}

	public void setGuzhuzerenFileName(String guzhuzerenFileName) {
		this.guzhuzerenFileName = guzhuzerenFileName;
	}

	public File getTuantixian() {
		return tuantixian;
	}

	public void setTuantixian(File tuantixian) {
		this.tuantixian = tuantixian;
	}

	public String getTuantixianFileName() {
		return tuantixianFileName;
	}

	public void setTuantixianFileName(String tuantixianFileName) {
		this.tuantixianFileName = tuantixianFileName;
	}

	public String getShangyexianshouji() {
		return shangyexianshouji;
	}

	public void setShangyexianshouji(String shangyexianshouji) {
		this.shangyexianshouji = shangyexianshouji;
	}

	public String getGuzhuzerenshouji() {
		return guzhuzerenshouji;
	}

	public void setGuzhuzerenshouji(String guzhuzerenshouji) {
		this.guzhuzerenshouji = guzhuzerenshouji;
	}

	public String getTuantixianshouji() {
		return tuantixianshouji;
	}

	public void setTuantixianshouji(String tuantixianshouji) {
		this.tuantixianshouji = tuantixianshouji;
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

	public CheLiangService getCheLiangService() {
		return cheLiangService;
	}

	public void setCheLiangService(CheLiangService cheLiangService) {
		this.cheLiangService = cheLiangService;
	}

	public BaoXianChuDanService getBaoXianChuDanService() {
		return baoXianChuDanService;
	}

	public void setBaoXianChuDanService(BaoXianChuDanService baoXianChuDanService) {
		this.baoXianChuDanService = baoXianChuDanService;
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

	public CaiLiaoZhengLiService getCaiLiaoZhengLiService() {
		return caiLiaoZhengLiService;
	}

	public void setCaiLiaoZhengLiService(CaiLiaoZhengLiService caiLiaoZhengLiService) {
		this.caiLiaoZhengLiService = caiLiaoZhengLiService;
	}

	public YingYunZhengService getYingYunZhengService() {
		return yingYunZhengService;
	}

	public void setYingYunZhengService(YingYunZhengService yingYunZhengService) {
		this.yingYunZhengService = yingYunZhengService;
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
