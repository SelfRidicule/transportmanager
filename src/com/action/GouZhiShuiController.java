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
import com.model.GouZhiShuiModel;
import com.myutils.FileManager;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianChuDanService;
import com.service.CaiLiaoZhengLiService;
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
 *  购置税 控制层（2、材料收集，购置税办理，临牌办理，车辆行驶证办理）
 */
public class GouZhiShuiController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * 构造方法
	 */
	public GouZhiShuiController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	
	private XinCheService xinCheService;
	
	private GouZhiShuiService gouZhiShuiService;
	
	private JinDuService jinDuService;
	
	private TouRuShenHeService touRuShenHeService;
	
	private YingYunZhengService yingYunZhengService;
	
	private BaoXianChuDanService baoXianChuDanService;
	
	private CaiLiaoZhengLiService caiLiaoZhengLiService;
	
	private FeiYongJieSuanService feiYongJieSuanService;
	
	private ZeRenRenService zeRenRenService;
	
	private FenGuanLingDaoService fenGuanLingDaoService;
	
	
//	集合对象
	private static List<GouZhiShui> gouzhishuilist;
//	单一对象
	private  GouZhiShui singlegouzhishui;
	
	/**
	 * 属性
	 */
	private String bianhao;
	private String chepaihao;
	private String banlizhuangtai;
	private String zerenren;
	
	private File   yizhixing;	//一致性
	private String yizhixingFileName;//FileName
	
	private File   hegezheng;	//合格证
	private String hegezhengFileName;//FileName
	
	private File   silianfapiao;	//四联发票
	private String silianfapiaoFileName;//FileName
	
	private File   jiaoqiangxian;	//交强险
	private String jiaoqiangxianFileName;//FileName
	
	private File   linshipaizheng;	//临时牌证
	private String linshipaizhengFileName;//FileName
	
	private File   zhongduanxinghao;	//终端型号
	private String zhongduanxinghaoFileName;//FileName
	
	private File   gouzhishui;	//购置税
	private String gouzhishuiFileName;//FileName
	
	private File   xingshizheng;	//行驶证
	private String xingshizhengFileName;//FileName
	
	private File   dengjizheng;	//登记证
	private String dengjizhengFileName;//FileName
	
	private File   anjiazheng;	//安驾证
	private String anjiazhengFileName;//FileName
	
	private File   pentubiaozhi;	//喷图标志
	private String pentubiaozhiFileName;//FileName
	
	private String yizhixingshouji;	//一致性收集
	private String hegezhengshouji;	//合格证收集
	private String silianfapiaoshouji;	//四联发票收集
	private String jiaoqiangxianshouji;	//交强险收集
	private String linshipaizhengshouji;	//	临时牌证收集
	private String zhongduanxinghaoshouji;	//终端型号收集
	private String gouzhishuishouji;	//购置税收集
	private String xingshizhengshouji;	//行驶证收集
	private String dengjizhengshouji;	//登记证收集
	private String anjiazhengshouji;	//安驾证收集
	private String pentubiaozhishouji;	//喷图标志收集
	
	
	
	public void testgouzhishui(){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		System.out.println(request.getRealPath("/"));
	}
	
	/**
	 *  跳转-购置税
	 */
	public String jumpGouZhiShui(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-购置税");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 gouzhishuilist = gouZhiShuiService.queryGouZhiShuiWeiBanLi();
		request.setAttribute("gouzhishuilist", gouzhishuilist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchGouZhiShui(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		gouzhishuilist = gouZhiShuiService.vagueSearchGouZhiShui(bianhao, chepaihao, banlizhuangtai);
		request.setAttribute("gouzhishuilist", gouzhishuilist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}

	/**
	 *  购置税 json
	 */
	public void gouZhiShuiJson(){
		System.out.println("购置税 json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(gouzhishuilist == null){
			return ;
		}
		
		List<GouZhiShuiModel> gouZhiShuiModelList = GouZhiShuiModel.getGouZhiShuiModelList(gouzhishuilist);
		
		JSONArray ja = JSONArray.fromObject(gouZhiShuiModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-添加购置税
	 */
	public String jumpAddGouZhiShui(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加购置税");
//		设置字符格式
		FontFormat.setFontFormat(response);			

		
		
		 singlegouzhishui = gouZhiShuiService.queryGouZhiShuiChePaiHao(chepaihao);
		request.setAttribute("singlegouzhishui", singlegouzhishui);
		
		session.setAttribute("singlegouzhishui", singlegouzhishui);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  添加购置税
	 * @throws Exception 
	 */
	public String addGouZhiShui() throws Exception{
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加购置税");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		singlegouzhishui = (GouZhiShui) session.getAttribute("singlegouzhishui");
		
		
		Users users = (Users) session.getAttribute("users");
		
		String bianhao = singlegouzhishui.getBianhao();
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		Date   banliriqi = new Date();
		
		
		//开始同步
		String oldChepaihao = singlegouzhishui.getChepaihao();
		
//		修改新车
		XinChe xinche = xinCheService.queryXinCheChePaiHao(oldChepaihao);
		xinche.setChepaihao(chepaihao);
		xinCheService.updateXinChe(xinche);
		
//		修改投入审核
		
		TouRuShenHe tourushenhe = touRuShenHeService.queryTouRuShenHeChePaiHao(oldChepaihao);
		if(tourushenhe != null){
			tourushenhe.setChepaihao(chepaihao);
			touRuShenHeService.updateTouRuShenHe(tourushenhe);
		}
		
//		修改营运证
		
		YingYunZheng yingyunzheng = yingYunZhengService.queryYingYunZhengChePaiHao(oldChepaihao);
		if(yingyunzheng != null){
			yingyunzheng.setChepaihao(chepaihao);
			yingYunZhengService.updateYingYunZheng(yingyunzheng);
		}
		
//		修改保险出单
		
		BaoXianChuDan baoxianchudan = baoXianChuDanService.queryBaoXianChuDanChePaiHao(oldChepaihao);
		if(baoxianchudan != null){
			baoxianchudan.setChepaihao(chepaihao);
			baoXianChuDanService.updateBaoXianChuDan(baoxianchudan);
		}
		
//		修改材料整理
		
		CaiLiaoZhengLi cailiaozhengli = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(oldChepaihao);
		if(cailiaozhengli != null){
			cailiaozhengli.setChepaihao(chepaihao);
			caiLiaoZhengLiService.updateCaiLiaoZhengLi(cailiaozhengli);
		}
		
//		修改费用结算
		
		FeiYongJieSuan feiYongJieSuan = feiYongJieSuanService.queryFeiYongJieSuanChePaiHao(oldChepaihao);
		if(feiYongJieSuan != null){
			feiYongJieSuan.setChepaihao(chepaihao);
			feiYongJieSuanService.updateFeiYongJieSuan(feiYongJieSuan);
		}
		
//		修改责任人
		
		ZeRenRen zeRenRen = zeRenRenService.queryZeRenRenChePaiHao(oldChepaihao);
		if(zeRenRen != null){
			zeRenRen.setChepaihao(chepaihao);
			zeRenRenService.updateZeRenRen(zeRenRen);
		}
		
//		修改分管领导
		
		FenGuanLingDao fenguanlingdao = fenGuanLingDaoService.queryFenGuanLingDaoChePaiHao(oldChepaihao);
		if(fenguanlingdao != null){
			fenguanlingdao.setChepaihao(chepaihao);
			fenGuanLingDaoService.updateFenGuanLingDao(fenguanlingdao);
		}
		
//		修改进度
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(oldChepaihao);
		if(jindu != null){
			jindu.setChepaihao(chepaihao);
			jinDuService.updateJinDu(jindu);
		}
		
		
		
//		得到存放图片指定路径
		String path = request.getRealPath("/uploads/gouzhishui/"+chepaihao);
		Long  currentTime = System.currentTimeMillis();
		
//		一致性
		String yizhixingPath = FileManager.singleUploadFile(yizhixing, yizhixingFileName, path, currentTime);
		yizhixingPath = FileManager.formatFilePath(yizhixingPath);
		
//		合格证
		String hegezhengPath = FileManager.singleUploadFile(hegezheng, hegezhengFileName, path, currentTime);
		hegezhengPath = FileManager.formatFilePath(hegezhengPath);
		
//		四联发票
		String silianfapiaoPath = FileManager.singleUploadFile(silianfapiao, silianfapiaoFileName, path, currentTime);
		silianfapiaoPath =  FileManager.formatFilePath(silianfapiaoPath);
		
//		交强险
		String jiaoqiangxianPath = FileManager.singleUploadFile(jiaoqiangxian, jiaoqiangxianFileName, path, currentTime);
		jiaoqiangxianPath = FileManager.formatFilePath(jiaoqiangxianPath);
		
//		临时牌证
		String linshipaizhengPath = FileManager.singleUploadFile(linshipaizheng, linshipaizhengFileName, path, currentTime);
		linshipaizhengPath = FileManager.formatFilePath(linshipaizhengPath);
		
//		终端型号
		String zhongduanxinghaoPath = FileManager.singleUploadFile(zhongduanxinghao, zhongduanxinghaoFileName, path, currentTime);
		zhongduanxinghaoPath = FileManager.formatFilePath(zhongduanxinghaoPath);
		
//		购置税
		String gouzhishuiPath = FileManager.singleUploadFile(gouzhishui, gouzhishuiFileName, path, currentTime);
		gouzhishuiPath = FileManager.formatFilePath(gouzhishuiPath);
		
//		行驶证 
		String xingshizhengPath = FileManager.singleUploadFile(xingshizheng, xingshizhengFileName, path, currentTime);
		xingshizhengPath = FileManager.formatFilePath(xingshizhengPath);
		
//		登记证 
		String dengjizhengPath = FileManager.singleUploadFile(dengjizheng, dengjizhengFileName, path, currentTime);
		dengjizhengPath = FileManager.formatFilePath(dengjizhengPath);
		
//		安驾证
		String anjiazhengPath = FileManager.singleUploadFile(anjiazheng, anjiazhengFileName, path, currentTime);
		anjiazhengPath =FileManager.formatFilePath(anjiazhengPath);
		
//		喷图标志 
		String pentubiaozhiPath = FileManager.singleUploadFile(pentubiaozhi, pentubiaozhiFileName, anjiazhengPath, currentTime);
		pentubiaozhiPath = FileManager.formatFilePath(pentubiaozhiPath);
		
		
		singlegouzhishui.setGouZhiShui( chepaihao,  bianhao,  caozuoyuan,
				 caozuoriqi,  banliriqi,  "已办理",
				 yizhixingPath,  hegezhengPath,  silianfapiaoPath,
				 jiaoqiangxianPath,  linshipaizhengPath,
				 zhongduanxinghaoPath,  gouzhishuiPath,  xingshizhengPath,
				 dengjizhengPath,  anjiazhengPath, pentubiaozhiPath);
		
		singlegouzhishui.setZerenren(zerenren);
		
		singlegouzhishui.setGouZhiShuiShouJi( yizhixingshouji,  hegezhengshouji,
				 silianfapiaoshouji,  jiaoqiangxianshouji,
				 linshipaizhengshouji,  zhongduanxinghaoshouji,
				 gouzhishuishouji,  xingshizhengshouji,
				 dengjizhengshouji,  anjiazhengshouji,
				 pentubiaozhishouji);
		
//		修改购置税
		gouZhiShuiService.updateGouZhiShui(singlegouzhishui);
		
//		修改当前进度		
		JinDu singlejindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
		singlejindu.setDangqianjindu("车管业务");
		jinDuService.updateJinDu(singlejindu);
		
//		判断是否全部办理
		
		String yingyunzhengzhuangtai =  yingYunZhengService.queryYingYunZhengChePaiHao(chepaihao).getBanlizhuangtai();
		String baoxianchudanzhuangtai = baoXianChuDanService.queryBaoXianChuDanChePaiHao(chepaihao).getBanlizhuangtai();
		String cailiaozhenglizhuangtai = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(chepaihao).getBanlizhuangtai();
		
//		全部办理 就添加 费用结算
		if("已办理".equals(yingyunzhengzhuangtai) && "已办理".equals(baoxianchudanzhuangtai) && "已办理".equals(cailiaozhenglizhuangtai) ){
			
			FeiYongJieSuan feiyongjiesuan = new FeiYongJieSuan();
			feiyongjiesuan.setFeiYongJieSuanXiangGuanXinXi( bianhao,  chepaihao,  banliriqi,
					 "未办理",  caozuoyuan,  caozuoriqi);
			feiYongJieSuanService.addFeiYongJieSuan(feiyongjiesuan);
		}
		
		
		 gouzhishuilist = gouZhiShuiService.queryGouZhiShuiWeiBanLi();
		request.setAttribute("gouzhishuilist", gouzhishuilist);
		
		XinCheController.sendXinChe(xinCheService);
		
		session.removeAttribute("singlegouzhishui");
		
		return "success";
	}
	
	/**
	 *  跳转-修改购置税
	 */
	public String jumpUpdateGouZhiShui(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改购置税");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		

		 singlegouzhishui = gouZhiShuiService.queryGouZhiShuiChePaiHao(chepaihao);
		request.setAttribute("singlegouzhishui", singlegouzhishui);
		
		session.setAttribute("singlegouzhishui", singlegouzhishui);
		
		return "success";
	}
	
	/**
	 *  修改购置税
	 */
	public String updateGouZhiShui(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改购置税");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlegouzhishui = (GouZhiShui) session.getAttribute("singlegouzhishui");
		
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		
		singlegouzhishui.setCaozuoyuan(caozuoyuan);
		singlegouzhishui.setCaozuoriqi(caozuoriqi);
		
		//开始同步
		String oldChepaihao = singlegouzhishui.getChepaihao();
		
//		修改新车
		
		XinChe xinche = xinCheService.queryXinCheChePaiHao(oldChepaihao);
		if(xinche != null){
			xinche.setChepaihao(chepaihao);
			xinCheService.updateXinChe(xinche);
		}
		
//				修改投入审核
		
		TouRuShenHe tourushenhe = touRuShenHeService.queryTouRuShenHeChePaiHao(oldChepaihao);
		if(tourushenhe != null){
			tourushenhe.setChepaihao(chepaihao);
			touRuShenHeService.updateTouRuShenHe(tourushenhe);
		}
		
//				修改营运证
		
		YingYunZheng yingyunzheng = yingYunZhengService.queryYingYunZhengChePaiHao(oldChepaihao);
		if(yingyunzheng != null){
			yingyunzheng.setChepaihao(chepaihao);
			yingYunZhengService.updateYingYunZheng(yingyunzheng);
		}
		
//				修改保险出单
		
		BaoXianChuDan baoxianchudan = baoXianChuDanService.queryBaoXianChuDanChePaiHao(oldChepaihao);
		if(baoxianchudan != null){
			baoxianchudan.setChepaihao(chepaihao);
			baoXianChuDanService.updateBaoXianChuDan(baoxianchudan);
		}
		
//				修改材料整理
		
		CaiLiaoZhengLi cailiaozhengli = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(oldChepaihao);
		if(cailiaozhengli != null){
			cailiaozhengli.setChepaihao(chepaihao);
			caiLiaoZhengLiService.updateCaiLiaoZhengLi(cailiaozhengli);
		}
		
//				修改费用结算
		
		FeiYongJieSuan feiYongJieSuan = feiYongJieSuanService.queryFeiYongJieSuanChePaiHao(oldChepaihao);
		if(feiYongJieSuan != null){
			feiYongJieSuan.setChepaihao(chepaihao);
			feiYongJieSuanService.updateFeiYongJieSuan(feiYongJieSuan);
		}
		
//				修改责任人
		
		ZeRenRen zeRenRen = zeRenRenService.queryZeRenRenChePaiHao(oldChepaihao);
		if(zeRenRen != null){
			zeRenRen.setChepaihao(chepaihao);
			zeRenRenService.updateZeRenRen(zeRenRen);
		}
		
//				修改分管领导
		
		FenGuanLingDao fenguanlingdao = fenGuanLingDaoService.queryFenGuanLingDaoChePaiHao(oldChepaihao);
		if(fenguanlingdao != null){
			fenguanlingdao.setChepaihao(chepaihao);
			fenGuanLingDaoService.updateFenGuanLingDao(fenguanlingdao);
		}
		
//		修改进度
		
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(oldChepaihao);
		if(jindu != null){
			jindu.setChepaihao(chepaihao);
			jinDuService.updateJinDu(jindu);
		}
		
		
//		得到存放图片指定路径
		String path = request.getRealPath("/uploads/gouzhishui/"+singlegouzhishui.getChepaihao());
		Long  currentTime = System.currentTimeMillis();
		
//		一致性
		if(yizhixing != null){
			String yizhixingPath = FileManager.singleUploadFile(yizhixing, yizhixingFileName, path, currentTime);
			yizhixingPath = FileManager.formatFilePath(yizhixingPath);
			String str = singlegouzhishui.getYizhixing();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setYizhixing(yizhixingPath);
		}
		
//		合格证
		if(hegezheng != null){
			String hegezhengPath = FileManager.singleUploadFile(hegezheng, hegezhengFileName, path, currentTime);
			hegezhengPath = FileManager.formatFilePath(hegezhengPath);
			String str = singlegouzhishui.getHegezheng();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setHegezheng(hegezhengPath);
		}
		
//		四联发票
		if(silianfapiao != null){
			String silianfapiaoPath = FileManager.singleUploadFile(silianfapiao, silianfapiaoFileName, path, currentTime);
			silianfapiaoPath = FileManager.formatFilePath(silianfapiaoPath);
			String str = singlegouzhishui.getSilianfapiao();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setSilianfapiao(silianfapiaoPath);
		}
		
//		交强险
		if(jiaoqiangxian != null){
			String jiaoqiangxianPath = FileManager.singleUploadFile(jiaoqiangxian, jiaoqiangxianFileName, path, currentTime);
			jiaoqiangxianPath = FileManager.formatFilePath(jiaoqiangxianPath);
			String str = singlegouzhishui.getJiaoqiangxian();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setJiaoqiangxian(jiaoqiangxianPath);
		}
		
//		临时牌证
		if(linshipaizheng != null){
			String linshipaizhengPath = FileManager.singleUploadFile(linshipaizheng, linshipaizhengFileName, path, currentTime);
			linshipaizhengPath = FileManager.formatFilePath(linshipaizhengPath);
			String str = singlegouzhishui.getLinshipaizheng();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setLinshipaizheng(linshipaizhengPath);
		}
		
//		终端型号
		if(zhongduanxinghao != null){
			String zhongduanxinghaoPath = FileManager.singleUploadFile(zhongduanxinghao, zhongduanxinghaoFileName, path, currentTime);
			zhongduanxinghaoPath = FileManager.formatFilePath(zhongduanxinghaoPath);
			String str = singlegouzhishui.getZhongduanxinghao();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setZhongduanxinghao(zhongduanxinghaoPath);
		}
		
//		购置税
		if(gouzhishui != null){
			String gouzhishuiPath = FileManager.singleUploadFile(gouzhishui, gouzhishuiFileName, path, currentTime);
			gouzhishuiPath = FileManager.formatFilePath(gouzhishuiPath);
			String str = singlegouzhishui.getGouzhishui();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setGouzhishui(gouzhishuiPath);
		}
		
//		行驶证 
		if(xingshizheng != null){
			String xingshizhengPath = FileManager.singleUploadFile(xingshizheng, xingshizhengFileName, path, currentTime);
			xingshizhengPath = FileManager.formatFilePath(xingshizhengPath);
			String str = singlegouzhishui.getXingshizheng();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setXingshizheng(xingshizhengPath);
		}
		
//		登记证 
		if(dengjizheng != null){
			String dengjizhengPath = FileManager.singleUploadFile(dengjizheng, dengjizhengFileName, path, currentTime);
			dengjizhengPath = FileManager.formatFilePath(dengjizhengPath);
			String str = singlegouzhishui.getDengjizheng();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setDengjizheng(dengjizhengPath);
		}
		
//		安驾证
		if(anjiazheng != null){
			String anjiazhengPath = FileManager.singleUploadFile(anjiazheng, anjiazhengFileName, path, currentTime);
			anjiazhengPath = FileManager.formatFilePath(anjiazhengPath);
			String str = singlegouzhishui.getAnjiazheng();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setAnjiazheng(anjiazhengPath);
		}
		
//		喷图标志 
		if(pentubiaozhi != null){
			String pentubiaozhiPath = FileManager.singleUploadFile(pentubiaozhi, pentubiaozhiFileName, path, currentTime);
			pentubiaozhiPath = FileManager.formatFilePath(pentubiaozhiPath);
			String str = singlegouzhishui.getPentubiaozhi();
			FileManager.deleteUpLoadFile(str);
			singlegouzhishui.setPentubiaozhi(pentubiaozhiPath);
		}
		
		singlegouzhishui.setGouZhiShuiShouJi( yizhixingshouji,  hegezhengshouji,
				 silianfapiaoshouji,  jiaoqiangxianshouji,
				 linshipaizhengshouji,  zhongduanxinghaoshouji,
				 gouzhishuishouji,  xingshizhengshouji,
				 dengjizhengshouji,  anjiazhengshouji,
				 pentubiaozhishouji);
		
		singlegouzhishui.setZerenren(zerenren);
		
		singlegouzhishui.setChepaihao(chepaihao);
		
		gouZhiShuiService.updateGouZhiShui(singlegouzhishui);
		
		 gouzhishuilist = gouZhiShuiService.queryGouZhiShuiWeiBanLi();
		request.setAttribute("gouzhishuilist", gouzhishuilist);
		
		XinCheController.sendXinChe(xinCheService);
		
		session.removeAttribute("singlegouzhishui");
		
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

	public File getYizhixing() {
		return yizhixing;
	}

	public void setYizhixing(File yizhixing) {
		this.yizhixing = yizhixing;
	}

	public String getYizhixingFileName() {
		return yizhixingFileName;
	}

	public void setYizhixingFileName(String yizhixingFileName) {
		this.yizhixingFileName = yizhixingFileName;
	}

	public File getHegezheng() {
		return hegezheng;
	}

	public void setHegezheng(File hegezheng) {
		this.hegezheng = hegezheng;
	}

	public String getHegezhengFileName() {
		return hegezhengFileName;
	}

	public void setHegezhengFileName(String hegezhengFileName) {
		this.hegezhengFileName = hegezhengFileName;
	}

	public File getSilianfapiao() {
		return silianfapiao;
	}

	public void setSilianfapiao(File silianfapiao) {
		this.silianfapiao = silianfapiao;
	}

	public String getSilianfapiaoFileName() {
		return silianfapiaoFileName;
	}

	public void setSilianfapiaoFileName(String silianfapiaoFileName) {
		this.silianfapiaoFileName = silianfapiaoFileName;
	}

	public File getJiaoqiangxian() {
		return jiaoqiangxian;
	}

	public void setJiaoqiangxian(File jiaoqiangxian) {
		this.jiaoqiangxian = jiaoqiangxian;
	}

	public String getJiaoqiangxianFileName() {
		return jiaoqiangxianFileName;
	}

	public void setJiaoqiangxianFileName(String jiaoqiangxianFileName) {
		this.jiaoqiangxianFileName = jiaoqiangxianFileName;
	}

	public File getLinshipaizheng() {
		return linshipaizheng;
	}

	public void setLinshipaizheng(File linshipaizheng) {
		this.linshipaizheng = linshipaizheng;
	}

	public String getLinshipaizhengFileName() {
		return linshipaizhengFileName;
	}

	public void setLinshipaizhengFileName(String linshipaizhengFileName) {
		this.linshipaizhengFileName = linshipaizhengFileName;
	}

	public File getZhongduanxinghao() {
		return zhongduanxinghao;
	}

	public void setZhongduanxinghao(File zhongduanxinghao) {
		this.zhongduanxinghao = zhongduanxinghao;
	}

	public String getZhongduanxinghaoFileName() {
		return zhongduanxinghaoFileName;
	}

	public void setZhongduanxinghaoFileName(String zhongduanxinghaoFileName) {
		this.zhongduanxinghaoFileName = zhongduanxinghaoFileName;
	}

	public File getGouzhishui() {
		return gouzhishui;
	}

	public void setGouzhishui(File gouzhishui) {
		this.gouzhishui = gouzhishui;
	}

	public String getGouzhishuiFileName() {
		return gouzhishuiFileName;
	}

	public void setGouzhishuiFileName(String gouzhishuiFileName) {
		this.gouzhishuiFileName = gouzhishuiFileName;
	}

	public File getXingshizheng() {
		return xingshizheng;
	}

	public void setXingshizheng(File xingshizheng) {
		this.xingshizheng = xingshizheng;
	}

	public String getXingshizhengFileName() {
		return xingshizhengFileName;
	}

	public void setXingshizhengFileName(String xingshizhengFileName) {
		this.xingshizhengFileName = xingshizhengFileName;
	}

	public File getDengjizheng() {
		return dengjizheng;
	}

	public void setDengjizheng(File dengjizheng) {
		this.dengjizheng = dengjizheng;
	}

	public String getDengjizhengFileName() {
		return dengjizhengFileName;
	}

	public void setDengjizhengFileName(String dengjizhengFileName) {
		this.dengjizhengFileName = dengjizhengFileName;
	}

	public File getAnjiazheng() {
		return anjiazheng;
	}

	public void setAnjiazheng(File anjiazheng) {
		this.anjiazheng = anjiazheng;
	}

	public String getAnjiazhengFileName() {
		return anjiazhengFileName;
	}

	public void setAnjiazhengFileName(String anjiazhengFileName) {
		this.anjiazhengFileName = anjiazhengFileName;
	}

	public File getPentubiaozhi() {
		return pentubiaozhi;
	}

	public void setPentubiaozhi(File pentubiaozhi) {
		this.pentubiaozhi = pentubiaozhi;
	}

	public String getPentubiaozhiFileName() {
		return pentubiaozhiFileName;
	}

	public void setPentubiaozhiFileName(String pentubiaozhiFileName) {
		this.pentubiaozhiFileName = pentubiaozhiFileName;
	}

	public String getYizhixingshouji() {
		return yizhixingshouji;
	}

	public void setYizhixingshouji(String yizhixingshouji) {
		this.yizhixingshouji = yizhixingshouji;
	}

	public String getHegezhengshouji() {
		return hegezhengshouji;
	}

	public void setHegezhengshouji(String hegezhengshouji) {
		this.hegezhengshouji = hegezhengshouji;
	}

	public String getSilianfapiaoshouji() {
		return silianfapiaoshouji;
	}

	public void setSilianfapiaoshouji(String silianfapiaoshouji) {
		this.silianfapiaoshouji = silianfapiaoshouji;
	}

	public String getJiaoqiangxianshouji() {
		return jiaoqiangxianshouji;
	}

	public void setJiaoqiangxianshouji(String jiaoqiangxianshouji) {
		this.jiaoqiangxianshouji = jiaoqiangxianshouji;
	}

	public String getLinshipaizhengshouji() {
		return linshipaizhengshouji;
	}

	public void setLinshipaizhengshouji(String linshipaizhengshouji) {
		this.linshipaizhengshouji = linshipaizhengshouji;
	}

	public String getZhongduanxinghaoshouji() {
		return zhongduanxinghaoshouji;
	}

	public void setZhongduanxinghaoshouji(String zhongduanxinghaoshouji) {
		this.zhongduanxinghaoshouji = zhongduanxinghaoshouji;
	}

	public String getGouzhishuishouji() {
		return gouzhishuishouji;
	}

	public void setGouzhishuishouji(String gouzhishuishouji) {
		this.gouzhishuishouji = gouzhishuishouji;
	}

	public String getXingshizhengshouji() {
		return xingshizhengshouji;
	}

	public void setXingshizhengshouji(String xingshizhengshouji) {
		this.xingshizhengshouji = xingshizhengshouji;
	}

	public String getDengjizhengshouji() {
		return dengjizhengshouji;
	}

	public void setDengjizhengshouji(String dengjizhengshouji) {
		this.dengjizhengshouji = dengjizhengshouji;
	}

	public String getAnjiazhengshouji() {
		return anjiazhengshouji;
	}

	public void setAnjiazhengshouji(String anjiazhengshouji) {
		this.anjiazhengshouji = anjiazhengshouji;
	}

	public String getPentubiaozhishouji() {
		return pentubiaozhishouji;
	}

	public void setPentubiaozhishouji(String pentubiaozhishouji) {
		this.pentubiaozhishouji = pentubiaozhishouji;
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

	public GouZhiShuiService getGouZhiShuiService() {
		return gouZhiShuiService;
	}

	public void setGouZhiShuiService(GouZhiShuiService gouZhiShuiService) {
		this.gouZhiShuiService = gouZhiShuiService;
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

