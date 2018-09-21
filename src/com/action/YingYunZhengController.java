package com.action;

import java.io.File;
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
import com.entity.YingYunZheng;
import com.model.YingYunZhengModel;
import com.myutils.FileManager;
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
 *  营运证 控制层 (材料收集、营运证办理、安全教育)
 */
public class YingYunZhengController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public YingYunZhengController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
 
	
	private XinCheService xinCheService;
	
	private YingYunZhengService yingYunZhengService;
	
	private JinDuService jinDuService;
	
	private GouZhiShuiService gouZhiShuiService;
	
	private BaoXianChuDanService baoXianChuDanService;
	
	private CaiLiaoZhengLiService caiLiaoZhengLiService;
	
	private FeiYongJieSuanService feiYongJieSuanService;
	
	
//	集合对象
	private static List<YingYunZheng> yingyunzhenglist;
//	单一对象
	private  YingYunZheng singleyingyunzheng;
	
	/**
	 *  属性
	 */
	private String  chepaihao;	//车牌号
	private String  bianhao;	//编号
	private String  banlizhuangtai;	//办理状态
	private String  caozuoyuan;	//操作员
	private Date    caozuoriqi;	//操作日期
	
	private File   guantichanpin;	//罐体产品质量说明书
	private String guantichanpinFileName;	//FileName
	
	private File	erweiyudengjia;	//二维与等评
	private String  erweiyudengjiaFileName;	//FileName
	
	private File   cheliangguan;	//车辆罐检查报告
	private String cheliangguanFileName;	//FileName
	
	private File	yayuncailiao;	//押运人员材料、劳动合同
	private String  yayuncailiaoFileName;	//FileName
	
	private File   chucijiance;	//初次检测设施设备配备情况查验登记表
	private String chucijianceFileName;	//FileName
	
	private File   cheliangzhaopian;	//车辆照片
	private String cheliangzhaopianFileName;	//FileName
	
	private File   ranshaoxiaohao;	//燃料消耗达标车型核查表
	private String ranshaoxiaohaoFileName;	//FileName
	
	private File   chengyunren;	//承运人责任险保单
	private String chengyunrenFileName;	//FileName
	
	private File   zhengchezhuangbei;	//整车装备外观检视及人工测量记录表
	private String zhengchezhuangbeiFileName;	//FileName
	
	private File   gangqiananquan;	//岗前安全教育培训考核
	private String gangqiananquanFileName;	//FileName
	
	private File   anquanka;	//安全卡
	private String anquankaFileName;	//FileName
	
	private File   yingyunzheng;	//车辆营运证
	private String yingyunzhengFileName;	//FileName
	
	private String  guantichanpinshouji;	//罐体产品质量说明书收集
	private String	erweiyudengjiashouji;	//二维与等评收集
	private String  cheliangguanshouji;	//车辆罐检查报告收集
	private String	yayuncailiaoshouji;	//押运人员材料、劳动合同收集
	private String  chucijianceshouji;	//初次检测设施设备配备情况查验登记表收集
	private String  cheliangzhaopianshouji;	//车辆照片收集
	private String  ranshaoxiaohaoshouji;	//燃料消耗达标车型核查表收集
	private String  chengyunrenshouji;	//承运人责任险保单收集
	private String  zhengchezhuangbeishouji;	//整车装备外观检视及人工测量记录表收集
	private String  gangqiananquanshouji;	//岗前安全教育培训考核收集
	private String  anquankashouji;	//安全卡收集
	private String  yingyunzhengshouji;	//车辆营运证收集
	
	private String  zerenren;	//责任人
	
	/**
	 *  跳转-营运证
	 */
	public String jumpYingYunZheng(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-营运证 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		yingyunzhenglist = yingYunZhengService.queryYingYunZhengWeiBanLi();
		request.setAttribute("yingyunzhenglist", yingyunzhenglist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}

	/**
	 *  模糊查询
	 */
	public String vagueSearchYingYunZheng(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
			

		
		
		 yingyunzhenglist = yingYunZhengService.vagueSearchYingYunZheng(bianhao, chepaihao, banlizhuangtai);
		request.setAttribute("yingyunzhenglist", yingyunzhenglist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  营运证 json
	 */
	public void yingYunZhengJson(){
		System.out.println("营运证 json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(yingyunzhenglist == null){
			return ;
		}
		
		List<YingYunZhengModel> yingYunZhengModelList = YingYunZhengModel.getYingYunZhengModelList(yingyunzhenglist);
		
		JSONArray ja = JSONArray.fromObject(yingYunZhengModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-添加营运证
	 */
	public String jumpAddYingYunZheng(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加营运证");
//		设置字符格式
		FontFormat.setFontFormat(response);			

		
		
		 singleyingyunzheng = yingYunZhengService.queryYingYunZhengChePaiHao(chepaihao);
		request.setAttribute("singleyingyunzheng", singleyingyunzheng);
		session.setAttribute("singleyingyunzheng", singleyingyunzheng);
		
		return "success";
	}
	
	/**
	 *  添加营运证
	 */
	public String addYingYunZheng(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加营运证");
//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
	
		singleyingyunzheng = (YingYunZheng) session.getAttribute("singleyingyunzheng");
		
		Users users = (Users) session.getAttribute("users");
		
		String chepaihao = singleyingyunzheng.getChepaihao();
		String bianhao = singleyingyunzheng.getBianhao();
		String caozuoyuan = users.getUsername();
		Date caozuoriqi = new Date();
		
		
//		得到存放图片指定路径
		String path = request.getRealPath("/uploads/yingyunzheng/"+chepaihao);
		Long  currentTime = System.currentTimeMillis();
		
		String guantichanpinPath =FileManager.singleUploadFile(guantichanpin, guantichanpinFileName, path, currentTime);
		guantichanpinPath = FileManager.formatFilePath(guantichanpinPath);
		
		String erweiyudengjiaPath = FileManager.singleUploadFile(erweiyudengjia, erweiyudengjiaFileName, path, currentTime);
		erweiyudengjiaPath = FileManager.formatFilePath(erweiyudengjiaPath);
		
		String cheliangguanPath = FileManager.singleUploadFile(cheliangguan, cheliangguanFileName, path, currentTime);
		cheliangguanPath = FileManager.formatFilePath(cheliangguanPath);
		
		String yayuncailiaoPath = FileManager.singleUploadFile(yayuncailiao, yayuncailiaoFileName, path, currentTime);
		yayuncailiaoPath = FileManager.formatFilePath(yayuncailiaoPath);
		
		String chucijiancePath = FileManager.singleUploadFile(chucijiance, chucijianceFileName, path, currentTime);
		chucijiancePath = FileManager.formatFilePath(chucijiancePath);
		
		String cheliangzhaopianPath = FileManager.singleUploadFile(cheliangzhaopian, cheliangzhaopianFileName, path, currentTime);
		cheliangzhaopianPath = FileManager.formatFilePath(cheliangzhaopianPath);
		
		String ranshaoxiaohaoPath = FileManager.singleUploadFile(ranshaoxiaohao, ranshaoxiaohaoFileName, path, currentTime);
		ranshaoxiaohaoPath = FileManager.formatFilePath(ranshaoxiaohaoPath);
		
		String chengyunrenPath = FileManager.singleUploadFile(chengyunren, chengyunrenFileName, path, currentTime);
		chengyunrenPath = FileManager.formatFilePath(chengyunrenPath);
		
		String zhengchezhuangbeiPath = FileManager.singleUploadFile(zhengchezhuangbei,zhengchezhuangbeiFileName, path, currentTime);
		zhengchezhuangbeiPath = FileManager.formatFilePath(zhengchezhuangbeiPath);
		
		String gangqiananquanPath = FileManager.singleUploadFile(gangqiananquan, gangqiananquanFileName, path, currentTime);
		gangqiananquanPath = FileManager.formatFilePath(gangqiananquanPath);
		
		String anquankaPath = FileManager.singleUploadFile(anquanka, anquankaFileName, path, currentTime);
		anquankaPath = FileManager.formatFilePath(anquankaPath);
		
		String yingyunzhengPath = FileManager.singleUploadFile(yingyunzheng, yingyunzhengFileName, path, currentTime);
		yingyunzhengPath = FileManager.formatFilePath(yingyunzhengPath);
		
//		修改营运证对象
		
		singleyingyunzheng.setYingYunZheng(chepaihao, bianhao, "已办理",
									caozuoyuan, caozuoriqi, guantichanpinPath, 
									erweiyudengjiaPath, cheliangguanPath, yayuncailiaoPath,
									chucijiancePath, cheliangzhaopianPath, ranshaoxiaohaoPath,
									chengyunrenPath, zhengchezhuangbeiPath, gangqiananquanPath, anquankaPath, yingyunzhengPath);
		
		singleyingyunzheng.setYingYunZhengShouJi( guantichanpinshouji,
				 erweiyudengjiashouji,  cheliangguanshouji,
				 yayuncailiaoshouji,  chucijianceshouji,
				 cheliangzhaopianshouji,  ranshaoxiaohaoshouji,
				 chengyunrenshouji,  zhengchezhuangbeishouji,
				 gangqiananquanshouji,  anquankashouji,
				 yingyunzhengshouji);
		
		singleyingyunzheng.setZerenren(zerenren);
		
//		修改营运证
		yingYunZhengService.updateYingYunZheng(singleyingyunzheng);
		
		
//		查询对应车牌号的进度对象
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
//		设置当前进度
		jindu.setDangqianjindu("运管业务");
//		修改进度对象
		jinDuService.updateJinDu(jindu);
		
//		判断是否全部办理
		
		
		
		
		
		String gouzhishuizhuangtai = gouZhiShuiService.queryGouZhiShuiChePaiHao(chepaihao).getBanlizhuangtai();
		String baoxianchudanzhuangtai = baoXianChuDanService.queryBaoXianChuDanChePaiHao(chepaihao).getBanlizhuangtai();
		String cailiaozhenglizhuangtai = caiLiaoZhengLiService.queryCaiLiaoZhengLiChePaiHao(chepaihao).getBanlizhuangtai();
		
//		全部办理 就添加 费用结算
		if("已办理".equals(gouzhishuizhuangtai) && "已办理".equals(baoxianchudanzhuangtai) && "已办理".equals(cailiaozhenglizhuangtai) ){
			
			
			FeiYongJieSuan feiyongjiesuan = new FeiYongJieSuan();
			feiyongjiesuan.setFeiYongJieSuanXiangGuanXinXi( bianhao,  chepaihao,  new Date(),
					 "未办理",  caozuoyuan,  caozuoriqi);
			feiYongJieSuanService.addFeiYongJieSuan(feiyongjiesuan);
		}
		 		
		 yingyunzhenglist =  yingYunZhengService.queryYingYunZhengWeiBanLi();
		request.setAttribute("yingyunzhenglist", yingyunzhenglist);
		
		XinCheController.sendXinChe(xinCheService);
		
		session.removeAttribute("singleyingyunzheng");
		
		return "success";
	}
	
	/**
	 *  跳转-修改营运证
	 */
	public String jumpUpdateYingYunZheng(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-修改营运证");
//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
		
		singleyingyunzheng = yingYunZhengService.queryYingYunZhengChePaiHao(chepaihao);
		request.setAttribute("singleyingyunzheng", singleyingyunzheng);
		session.setAttribute("singleyingyunzheng", singleyingyunzheng);
		
		return "success";
	}
	
	/**
	 *  修改营运证
	 */
	public String updateYingYunZheng(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("修改营运证");
//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
//		得到传递的参数
		Users users = (Users) session.getAttribute("users");
		
		singleyingyunzheng = (YingYunZheng) session.getAttribute("singleyingyunzheng");
		
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		String chepaihao = singleyingyunzheng.getChepaihao();
		
		singleyingyunzheng.setCaozuoyuan(caozuoyuan);
		singleyingyunzheng.setCaozuoriqi(caozuoriqi);
		
//		得到存放图片指定路径
		String path = request.getRealPath("/uploads/yingyunzheng/"+chepaihao);
		Long  currentTime = System.currentTimeMillis();
		
//		罐体产品
		if(guantichanpin != null){
			String guantichanpinPath =FileManager.singleUploadFile(guantichanpin, guantichanpinFileName, path, currentTime);
			guantichanpinPath = FileManager.formatFilePath(guantichanpinPath);
			String str = singleyingyunzheng.getGuantichanpin();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setGuantichanpin(guantichanpinPath);
		}
		
//		二维与等价
		if(erweiyudengjia != null){
			String erweiyudengjiaPath = FileManager.singleUploadFile(erweiyudengjia, erweiyudengjiaFileName, path, currentTime);
			erweiyudengjiaPath = FileManager.formatFilePath(erweiyudengjiaPath);
			String str = singleyingyunzheng.getErweiyudengjia();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setErweiyudengjia(erweiyudengjiaPath);
		}
		
//		车辆罐
		if(cheliangguan != null){
			String cheliangguanPath = FileManager.singleUploadFile(cheliangguan, cheliangguanFileName, path, currentTime);
			cheliangguanPath = FileManager.formatFilePath(cheliangguanPath);
			String str = singleyingyunzheng.getCheliangguan();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setCheliangguan(cheliangguanPath);
		}
		
//		押运材料
		if(yayuncailiao != null){
			String yayuncailiaoPath = FileManager.singleUploadFile(yayuncailiao, yayuncailiaoFileName, path, currentTime);
			yayuncailiaoPath = FileManager.formatFilePath(yayuncailiaoPath);
			String str = singleyingyunzheng.getYayuncailiao();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setYayuncailiao(yayuncailiaoPath);
		}
		
//		初次检测
		if(chucijiance != null){
			String chucijiancePath = FileManager.singleUploadFile(chucijiance, chucijianceFileName, path, currentTime);
			chucijiancePath = FileManager.formatFilePath(chucijiancePath);
			String str = singleyingyunzheng.getChucijiance();
			FileManager.deleteUpLoadFile(str);	
			singleyingyunzheng.setChucijiance(chucijiancePath);
		}
		
//		车辆照片
		if(cheliangzhaopian != null){
			String cheliangzhaopianPath = FileManager.singleUploadFile(cheliangzhaopian, cheliangzhaopianFileName, path, currentTime);
			cheliangzhaopianPath = FileManager.formatFilePath(cheliangzhaopianPath);
			String str = singleyingyunzheng.getCheliangzhaopian();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setCheliangzhaopian(cheliangzhaopianPath);
		}
		
//		燃烧消耗
		if(ranshaoxiaohao != null){
			String ranshaoxiaohaoPath = FileManager.singleUploadFile(ranshaoxiaohao, ranshaoxiaohaoFileName, path, currentTime);
			ranshaoxiaohaoPath = FileManager.formatFilePath(ranshaoxiaohaoPath);
			String str = singleyingyunzheng.getRanshaoxiaohao();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setRanshaoxiaohao(ranshaoxiaohaoPath);
		}
		
//		承运人
		if(chengyunren != null){
			String chengyunrenPath = FileManager.singleUploadFile(chengyunren, chengyunrenFileName, path, currentTime);
			chengyunrenPath = FileManager.formatFilePath(chengyunrenPath);
			String str = singleyingyunzheng.getChengyunren();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setChengyunren(chengyunrenPath);
		}
		
//		整车装备
		if(zhengchezhuangbei != null){
			String zhengchezhuangbeiPath = FileManager.singleUploadFile(zhengchezhuangbei,zhengchezhuangbeiFileName, path, currentTime);
			zhengchezhuangbeiPath = FileManager.formatFilePath(zhengchezhuangbeiPath);
			String str = singleyingyunzheng.getZhengchezhuangbei();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setZhengchezhuangbei(zhengchezhuangbeiPath);
		}
		
//		岗前安全
		if(gangqiananquan != null){
			String gangqiananquanPath = FileManager.singleUploadFile(gangqiananquan, gangqiananquanFileName, path, currentTime);
			gangqiananquanPath = FileManager.formatFilePath(gangqiananquanPath);
			String str = singleyingyunzheng.getGangqiananquan();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setGangqiananquan(gangqiananquanPath);
		}
		
//		安全卡
		if(anquanka != null){
			String anquankaPath = FileManager.singleUploadFile(anquanka, anquankaFileName, path, currentTime);
			anquankaPath = FileManager.formatFilePath(anquankaPath);
			String str = singleyingyunzheng.getAnquanka();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setAnquanka(anquankaPath);
		}
		
//		营运证
		if(yingyunzheng != null){
			String yingyunzhengPath = FileManager.singleUploadFile(yingyunzheng, yingyunzhengFileName, path, currentTime);
			yingyunzhengPath = FileManager.formatFilePath(yingyunzhengPath);
			String str = singleyingyunzheng.getYingyunzheng();
			FileManager.deleteUpLoadFile(str);
			singleyingyunzheng.setYingyunzheng(yingyunzhengPath);
		}
		
		singleyingyunzheng.setYingYunZhengShouJi( guantichanpinshouji,
				 erweiyudengjiashouji,  cheliangguanshouji,
				 yayuncailiaoshouji,  chucijianceshouji,
				 cheliangzhaopianshouji,  ranshaoxiaohaoshouji,
				 chengyunrenshouji,  zhengchezhuangbeishouji,
				 gangqiananquanshouji,  anquankashouji,
				 yingyunzhengshouji);
		
		singleyingyunzheng.setZerenren(zerenren);
		
//		修改
		yingYunZhengService.updateYingYunZheng(singleyingyunzheng);
		
		 yingyunzhenglist =  yingYunZhengService.queryYingYunZhengWeiBanLi();
		request.setAttribute("yingyunzhenglist", yingyunzhenglist);
		
		XinCheController.sendXinChe(xinCheService);
		
		session.removeAttribute("singleyingyunzheng");
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}

	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
	}

	public String getCaozuoyuan() {
		return caozuoyuan;
	}

	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}

	public Date getCaozuoriqi() {
		return caozuoriqi;
	}

	public void setCaozuoriqi(Date caozuoriqi) {
		this.caozuoriqi = caozuoriqi;
	}

	public File getGuantichanpin() {
		return guantichanpin;
	}

	public void setGuantichanpin(File guantichanpin) {
		this.guantichanpin = guantichanpin;
	}

	public File getErweiyudengjia() {
		return erweiyudengjia;
	}

	public void setErweiyudengjia(File erweiyudengjia) {
		this.erweiyudengjia = erweiyudengjia;
	}

	public File getCheliangguan() {
		return cheliangguan;
	}

	public void setCheliangguan(File cheliangguan) {
		this.cheliangguan = cheliangguan;
	}

	public File getYayuncailiao() {
		return yayuncailiao;
	}

	public void setYayuncailiao(File yayuncailiao) {
		this.yayuncailiao = yayuncailiao;
	}

	public File getChucijiance() {
		return chucijiance;
	}

	public void setChucijiance(File chucijiance) {
		this.chucijiance = chucijiance;
	}

	public File getCheliangzhaopian() {
		return cheliangzhaopian;
	}

	public void setCheliangzhaopian(File cheliangzhaopian) {
		this.cheliangzhaopian = cheliangzhaopian;
	}

	public File getRanshaoxiaohao() {
		return ranshaoxiaohao;
	}

	public void setRanshaoxiaohao(File ranshaoxiaohao) {
		this.ranshaoxiaohao = ranshaoxiaohao;
	}

	public File getChengyunren() {
		return chengyunren;
	}

	public void setChengyunren(File chengyunren) {
		this.chengyunren = chengyunren;
	}

	public File getZhengchezhuangbei() {
		return zhengchezhuangbei;
	}

	public void setZhengchezhuangbei(File zhengchezhuangbei) {
		this.zhengchezhuangbei = zhengchezhuangbei;
	}

	public File getGangqiananquan() {
		return gangqiananquan;
	}

	public void setGangqiananquan(File gangqiananquan) {
		this.gangqiananquan = gangqiananquan;
	}

	public File getAnquanka() {
		return anquanka;
	}

	public void setAnquanka(File anquanka) {
		this.anquanka = anquanka;
	}

	public File getYingyunzheng() {
		return yingyunzheng;
	}

	public void setYingyunzheng(File yingyunzheng) {
		this.yingyunzheng = yingyunzheng;
	}

	public String getGuantichanpinFileName() {
		return guantichanpinFileName;
	}

	public void setGuantichanpinFileName(String guantichanpinFileName) {
		this.guantichanpinFileName = guantichanpinFileName;
	}

	public String getErweiyudengjiaFileName() {
		return erweiyudengjiaFileName;
	}

	public void setErweiyudengjiaFileName(String erweiyudengjiaFileName) {
		this.erweiyudengjiaFileName = erweiyudengjiaFileName;
	}

	public String getCheliangguanFileName() {
		return cheliangguanFileName;
	}

	public void setCheliangguanFileName(String cheliangguanFileName) {
		this.cheliangguanFileName = cheliangguanFileName;
	}

	public String getYayuncailiaoFileName() {
		return yayuncailiaoFileName;
	}

	public void setYayuncailiaoFileName(String yayuncailiaoFileName) {
		this.yayuncailiaoFileName = yayuncailiaoFileName;
	}

	public String getChucijianceFileName() {
		return chucijianceFileName;
	}

	public void setChucijianceFileName(String chucijianceFileName) {
		this.chucijianceFileName = chucijianceFileName;
	}

	public String getCheliangzhaopianFileName() {
		return cheliangzhaopianFileName;
	}

	public void setCheliangzhaopianFileName(String cheliangzhaopianFileName) {
		this.cheliangzhaopianFileName = cheliangzhaopianFileName;
	}

	public String getRanshaoxiaohaoFileName() {
		return ranshaoxiaohaoFileName;
	}

	public void setRanshaoxiaohaoFileName(String ranshaoxiaohaoFileName) {
		this.ranshaoxiaohaoFileName = ranshaoxiaohaoFileName;
	}

	public String getChengyunrenFileName() {
		return chengyunrenFileName;
	}

	public void setChengyunrenFileName(String chengyunrenFileName) {
		this.chengyunrenFileName = chengyunrenFileName;
	}

	public String getZhengchezhuangbeiFileName() {
		return zhengchezhuangbeiFileName;
	}

	public void setZhengchezhuangbeiFileName(String zhengchezhuangbeiFileName) {
		this.zhengchezhuangbeiFileName = zhengchezhuangbeiFileName;
	}

	public String getGangqiananquanFileName() {
		return gangqiananquanFileName;
	}

	public void setGangqiananquanFileName(String gangqiananquanFileName) {
		this.gangqiananquanFileName = gangqiananquanFileName;
	}

	public String getAnquankaFileName() {
		return anquankaFileName;
	}

	public void setAnquankaFileName(String anquankaFileName) {
		this.anquankaFileName = anquankaFileName;
	}

	public String getYingyunzhengFileName() {
		return yingyunzhengFileName;
	}

	public void setYingyunzhengFileName(String yingyunzhengFileName) {
		this.yingyunzhengFileName = yingyunzhengFileName;
	}

	public String getGuantichanpinshouji() {
		return guantichanpinshouji;
	}

	public void setGuantichanpinshouji(String guantichanpinshouji) {
		this.guantichanpinshouji = guantichanpinshouji;
	}

	public String getErweiyudengjiashouji() {
		return erweiyudengjiashouji;
	}

	public void setErweiyudengjiashouji(String erweiyudengjiashouji) {
		this.erweiyudengjiashouji = erweiyudengjiashouji;
	}

	public String getCheliangguanshouji() {
		return cheliangguanshouji;
	}

	public void setCheliangguanshouji(String cheliangguanshouji) {
		this.cheliangguanshouji = cheliangguanshouji;
	}

	public String getYayuncailiaoshouji() {
		return yayuncailiaoshouji;
	}

	public void setYayuncailiaoshouji(String yayuncailiaoshouji) {
		this.yayuncailiaoshouji = yayuncailiaoshouji;
	}

	public String getChucijianceshouji() {
		return chucijianceshouji;
	}

	public void setChucijianceshouji(String chucijianceshouji) {
		this.chucijianceshouji = chucijianceshouji;
	}

	public String getCheliangzhaopianshouji() {
		return cheliangzhaopianshouji;
	}

	public void setCheliangzhaopianshouji(String cheliangzhaopianshouji) {
		this.cheliangzhaopianshouji = cheliangzhaopianshouji;
	}

	public String getRanshaoxiaohaoshouji() {
		return ranshaoxiaohaoshouji;
	}

	public void setRanshaoxiaohaoshouji(String ranshaoxiaohaoshouji) {
		this.ranshaoxiaohaoshouji = ranshaoxiaohaoshouji;
	}

	public String getChengyunrenshouji() {
		return chengyunrenshouji;
	}

	public void setChengyunrenshouji(String chengyunrenshouji) {
		this.chengyunrenshouji = chengyunrenshouji;
	}

	public String getZhengchezhuangbeishouji() {
		return zhengchezhuangbeishouji;
	}

	public void setZhengchezhuangbeishouji(String zhengchezhuangbeishouji) {
		this.zhengchezhuangbeishouji = zhengchezhuangbeishouji;
	}

	public String getGangqiananquanshouji() {
		return gangqiananquanshouji;
	}

	public void setGangqiananquanshouji(String gangqiananquanshouji) {
		this.gangqiananquanshouji = gangqiananquanshouji;
	}

	public String getAnquankashouji() {
		return anquankashouji;
	}

	public void setAnquankashouji(String anquankashouji) {
		this.anquankashouji = anquankashouji;
	}

	public String getYingyunzhengshouji() {
		return yingyunzhengshouji;
	}

	public void setYingyunzhengshouji(String yingyunzhengshouji) {
		this.yingyunzhengshouji = yingyunzhengshouji;
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

	public YingYunZhengService getYingYunZhengService() {
		return yingYunZhengService;
	}

	public void setYingYunZhengService(YingYunZhengService yingYunZhengService) {
		this.yingYunZhengService = yingYunZhengService;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
