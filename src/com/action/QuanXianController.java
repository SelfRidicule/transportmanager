package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.QuanXian;
import com.model.QuanXianModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.QuanXianService;
import com.service.UsersService;

import net.sf.json.JSONArray;

/**
 *  权限 控制层
 */
public class QuanXianController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public QuanXianController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

//	权限集合对象
	private static List<String> quanxianlist ;
//	权限名称
	private static String singlequanxianmingcheng ;
	
	
	private QuanXianService quanXianService ;
	
	private UsersService usersService;
	
	/**
	 * 属性
	 */
	private String quanxianmingcheng;	//权限名称
	
	private String chakanmenhu;		//查看工作门户
	private String weihumenhu;		//维护工作门户
	private String xinzengmenhu;	//新增工作门户
	
	private String chakanyonghu;	//查看用户管理
	private String weihuyonghu;		//维护用户管理
	private String xinzengyonghu;	//新增用户管理
	
	private String chakanquanxian;	//查看权限设置
	private String weihuquanxian;	//维护权限设置
	private String xinzengquanxian;	//新增权限设置
	
	private String chakanbumen;		//查看部门管理
	private String weihubumen;		//维护部门管理
	private String xinzengbumen;	//新增部门管理

	private String chakananquanguanli;	//查看安全管理
	private String weihuanquanguanli;	//维护安全管理
	private String xinzenganquanguanli;	//新增安全管理	
	
	private String chakancheliang;	//查看车辆管理
	private String weihucheliang;	//维护车辆管理
	private String xinzengcheliang;	//新增车辆管理
	
	private String chakanguanxijianli;	//查看关系建立
	private String weihuguanxijianli;	//维护关系建立
	private String xinzengguanxijianli;	//新增关系建立
	
	private String chakanbaoxianguanli;	//查看保险管理
	private String weihubaoxianguanli;	//维护保险管理
	private String xinzengbaoxianguanli;//新增保险管理
	
	private String chakanzhengjian;		//查看证件管理
	private String weihuzhengjian;		//维护证件管理
	private String xinzengzhengjian;	//新增证件管理
	
	private String chakansuoyounianshen;	//查看所有年审
	private String chakannianshen;		//查看年审管理
	private String weihunianshen;		//维护年审管理
	private String xinzengnianshen;		//新增年审管理
	
	private String chakanjiashiyuanguanli;	//查看驾驶员管理
	private String weihujiashiyuanguanli;	//维护驾驶员管理
	private String xinzengjiashiyuanguanli;	//新增驾驶员管理
	
	
	private String chakanjiashiyuanziliao;	//查看驾驶员资料
	private String weihujiashiyuanziliao;	//维护驾驶员资料
	private String xinzengjiashiyuanziliao;	//新增驾驶员资料
	
	private String chakanjiashiyuanshenhe;	//查看驾驶员审核
	private String weihujiashiyuanshenhe;	//维护驾驶员审核
	private String xinzengjiashiyuanshenhe;	//新增驾驶员审核
	
	private String chakansuoyoujiashiyuannianshen;	//查看所有驾驶员年审
	private String chakanjiashiyuannianshen;	//查看驾驶员年审
	private String weihujiashiyuannianshen;		//维护驾驶员年审
	private String xinzengjiashiyuannianshen;	//新增驾驶员年审
	
	
	private String chakanxincheruhu;	//查看新车入户
	private String weihuxincheruhu;		//维护新车入户
	private String xinzengxincheruhu;	//新增新车入户
	
	
	private String chakanxinche;		//查看新车管理
	private String weihuxinche;			//维护新车管理
	private String xinzengxinche;		//新增新车管理
	
	private String chakantourushenhe;	//查看投入审核和申请
	private String weihutourushenhe;	//维护投入审核和申请
	private String xinzengtourushenhe;	//新增投入审核和申请
	
	private String chakancheguanyewu;	//查看车管业务
	private String weihucheguanyewu;	//维护车管业务
	private String xinzengcheguanyewu;	//新增车管业务
	
	private String chakanyunguanyewu;	//查看运管业务
	private String weihuyunguanyewu;	//维护运管业务
	private String xinzengyunguanyewu;	//新增运管业务
	
	private String chakanbaoxianchudan;	//查看保险出单
	private String weihubaoxianchudan;	//维护保险出单
	private String xinzengbaoxianchudan;//新增保险出单
	
	private String chakancailiaozhengli;//查看材料整理档案建立
	private String weihucailiaozhengli;	//维护材料整理档案建立
	private String xinzengcailiaozhengli;//新增材料整理档案建立
	
	private String chakanfeiyongjiesuan;	//查看费用结算
	private String weihufeiyongjiesuan;		//维护费用结算
	private String xinzengfeiyongjiesuan;	//新增费用结算
	
	private String chakanzerenrenqianzi;	//查看责任人签字
	private String weihuzerenrenqianzi;		//维护责任人签字
	private String xinzengzerenrenqianzi;	//新增责任人签字
	
	private String chakanfenguanlingdaoyijian;	//查看分管领导意见
	private String weihufenguanlingdaoyijian;	//维护分管领导意见
	private String xinzengfenguanlingdaoyijian;	//新增分管领导意见
	
	private String chakanyewuguanli;	//查看业务管理
	private String weihuyewuguanli;		//维护业务管理
	private String xinzengyewuguanli;	//新增业务管理
	
	
	private String chakankehuguanli;	//查看客户管理
	private String weihukehuguanli;		//维护客户管理
	private String xinzengkehuguanli;	//新增客户管理
	
	private String chakanyundanguanli;	//查看运单管理
	private String chakansuoyouyundanguanli;	//查看所有运单管理
	private String weihuyundanguanli;	//维护运单管理
	private String xinzengyundanguanli;	//新增运单管理
	
	private String chakanyundanshenhe;	//查看运单审核
	private String weihuyundanshenhe;	//维护运单审核
	private String xinzengyundanshenhe;	//新增运单审核
	
	private String chakancaiwuguanli;	//查看财务管理
	private String weihucaiwuguanli;	//维护财务管理
	private String xinzengcaiwuguanli;	//新增财务管理
	
	private String chakankaipiaoguanli;	//查看开票管理
	private String weihukaipiaoguanli;	//维护开票管理
	private String xinzengkaipiaoguanli;//新增开票管理
	
	private String chakanyingshoukuanguanli;	//查看营收款管理
	private String weihuyingshoukuanguanli;		//维护营收款管理
	private String xinzengyingshoukuanguanli;	//新增营收款管理
	
	private String chakanjiesuandanguanli;	//查看结算单管理
	private String weihujiesuandanguanli;	//维护结算单管理
	private String xinzengjiesuandanguanli;	//新增结算单管理
	
	private String chakanweixianpin;	//查看危险品数据库
	private String weihuweixianpin;		//维护危险品数据库
	private String xinzengweixianpin;	//新增危险品数据库
	
	private String chakanguanli;	//查看管理
	private String weihuguanli;		//维护管理
	private String xinzengguanli;	//新增管理
	
	private String chakanfeiyongshouqu;	//查看费用收取
	private String weihufeiyongshouqu;	//维护费用收取
	private String xinzengfeiyongshouqu;	//新增费用收取
	
	private String chakankaipiaoshenqing;	//查看开票申请
	private String weihukaipiaoshenqing;	//维护开票申请
	private String xinzengkaipiaoshenqing;	//新增开票申请
	
	private String chakanfenguankaipiaoshenhe;	//查看分管开票审核
	private String weihufenguankaipiaoshenhe;	//维护分管开票审核
	private String xinzengfenguankaipiaoshenhe;	//新增分管开票审核
	
	private String chakanzongjinglikaipiaoshenhe;	//查看总经理开票审核
	private String weihuzongjinglikaipiaoshenhe;	//维护总经理开票审核
	private String xinzengzongjinglikaipiaoshenhe;	//新增总经理开票审核
	
	private String chakankaipiao;	//查看开票
	private String weihukaipiao;	//维护开票
	private String xinzengkaipiao;	//新增开票
	
	private String chakanjiesuanshenqing;	//查看结算申请
	private String weihujiesuanshenqing;	//维护结算申请
	private String xinzengjiesuanshenqing;	//新增结算申请
	
	private String chakanzongjinglijiesuanshenhe;	//查看总经理结算审核
	private String weihuzongjinglijiesuanshenhe;	//维护总经理结算审核
	private String xinzengzongjinglijiesuanshenhe;	//新增总经理结算审核
	
	private String chakandongshizhangjiesuanshenhe;	//查看董事长结算审核
	private String weihudongshizhangjiesuanshenhe;	//维护董事长结算审核
	private String xinzengdongshizhangjiesuanshenhe;//新增董事长结算审核
	
	private String chakanjiesuan;	//查看结算
	private String weihujiesuan;	//维护结算
	private String xinzengjiesuan;	//新增结算
	
	/**
	 *  发送权限名称集合对象
	 */
	public static void sendQuanXianMingCheng(QuanXianService quanXianService){
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();

		 
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		List<String> quanxianmingchenglist = quanXianService.queryQuanXianMingCheng();
		request.setAttribute("quanxianmingchenglist", quanxianmingchenglist);
		
	}
	
	/**
	 *  跳转-权限
	 */
	public String jumpQuanXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		quanxianlist = quanXianService.queryQuanXianMingCheng();
		
		
		return "success";
	}
	
	/**
	 *  返回-权限
	 */
	public String returnQuanXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		quanxianlist = quanXianService.queryQuanXianMingCheng();
		
		return "success";
	}
	
	
	/**
	 *  权限json
	 */
	public void quanXianJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(quanxianlist == null){
			return ;
		}
		
		List<QuanXianModel> quanxianmodellist = QuanXianModel.getQuanXianModelList(quanxianlist);
		
		JSONArray ja = JSONArray.fromObject(quanxianmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 *  模糊查询 
	 */
	public String vagueSearchQuanXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

//		判断是否为null
		if(quanxianmingcheng == null){
			quanxianmingcheng = "";
		}
		
		 quanxianlist = quanXianService.vagueSearchQuanXian(quanxianmingcheng);
		
		return "success";
	}
	
	/**
	 *  添加权限
	 */
	public String addQuanXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
//		工作门户
		QuanXian gongzuomenhu = new QuanXian();
		gongzuomenhu.setQuanXian(quanxianmingcheng, "工作门户", xinzengmenhu, weihumenhu, chakanmenhu);
//		用户管理
		QuanXian yonghuguanli = new QuanXian();
		yonghuguanli.setQuanXian(quanxianmingcheng, "用户管理", xinzengyonghu, weihuyonghu, chakanyonghu);
//		权限设置
		QuanXian quanxianshezhi = new QuanXian();
		quanxianshezhi.setQuanXian(quanxianmingcheng, "权限设置", xinzengquanxian, weihuquanxian, chakanquanxian);
//		部门管理
		QuanXian bumenguanli = new QuanXian();
		bumenguanli.setQuanXian(quanxianmingcheng, "部门管理", xinzengbumen, weihubumen, chakanbumen);
//		安全管理
		QuanXian anquanguanli = new QuanXian();
		anquanguanli.setQuanXian(quanxianmingcheng, "安全管理", xinzenganquanguanli, weihuanquanguanli, chakananquanguanli);
//		车辆管理
		QuanXian cheliangguanli = new QuanXian();
		cheliangguanli.setQuanXian(quanxianmingcheng, "车辆管理", xinzengcheliang, weihucheliang, chakancheliang);
//		关系建立
		QuanXian guanxijianli = new QuanXian();
		guanxijianli.setQuanXian(quanxianmingcheng, "关系建立", xinzengguanxijianli, weihuguanxijianli, chakanguanxijianli);
//		保险管理
		QuanXian baoxianguanli = new QuanXian();
		baoxianguanli.setQuanXian(quanxianmingcheng, "保险管理", xinzengbaoxianguanli, weihubaoxianguanli, chakanbaoxianguanli);
//		证件管理
		QuanXian zhengjianguanli = new QuanXian();
		zhengjianguanli.setQuanXian(quanxianmingcheng, "证件管理", xinzengzhengjian, weihuzhengjian, chakanzhengjian);
//		年审管理
		QuanXian nianshenguanli = new QuanXian();
		nianshenguanli.setQuanXian(quanxianmingcheng, "年审管理", xinzengnianshen, weihunianshen, chakannianshen);		
		nianshenguanli.setChakansuoyou(chakansuoyounianshen);
//		驾驶员管理
		QuanXian jiashiyuanguanli = new QuanXian();
		jiashiyuanguanli.setQuanXian(quanxianmingcheng, "驾驶员管理", xinzengjiashiyuanguanli, weihujiashiyuanguanli, chakanjiashiyuanguanli);				
//		驾驶员资料
		QuanXian jiashiyuanziliao = new QuanXian();
		jiashiyuanziliao.setQuanXian(quanxianmingcheng, "驾驶员资料", xinzengjiashiyuanziliao, weihujiashiyuanziliao, chakanjiashiyuanziliao);
//		驾驶员审核
		QuanXian jiashiyuanshenhe = new QuanXian();
		jiashiyuanshenhe.setQuanXian(quanxianmingcheng, "驾驶员审核", xinzengjiashiyuanshenhe, weihujiashiyuanshenhe, chakanjiashiyuanshenhe);
//		驾驶员年审
		QuanXian jiashiyuannianshen = new QuanXian();
		jiashiyuannianshen.setQuanXian(quanxianmingcheng, "驾驶员年审", xinzengjiashiyuannianshen, weihujiashiyuannianshen, chakanjiashiyuannianshen);
		jiashiyuannianshen.setChakansuoyou(chakansuoyoujiashiyuannianshen);
//		新车入户
		QuanXian xincheruhu = new QuanXian();
		xincheruhu.setQuanXian(quanxianmingcheng, "新车入户", xinzengxincheruhu, weihuxincheruhu, chakanxincheruhu);
//		新车管理
		QuanXian xincheguanli = new QuanXian();
		xincheguanli.setQuanXian(quanxianmingcheng, "新车管理", xinzengxinche, weihuxinche, chakanxinche);
//		投入审核和申请
		QuanXian tourushenhe = new QuanXian();
		tourushenhe.setQuanXian(quanxianmingcheng, "投入审核和申请", xinzengtourushenhe, weihutourushenhe, chakantourushenhe);
//		车管业务
		QuanXian cheguanyewu = new QuanXian();
		cheguanyewu.setQuanXian(quanxianmingcheng, "车管业务", xinzengcheguanyewu, weihucheguanyewu, chakancheguanyewu);
//		运管业务
		QuanXian yunguanyewu = new QuanXian();
		yunguanyewu.setQuanXian(quanxianmingcheng, "运管业务", xinzengyunguanyewu, weihuyunguanyewu, chakanyunguanyewu);
//		保险出单
		QuanXian baoxianchudan = new QuanXian();
		baoxianchudan.setQuanXian(quanxianmingcheng, "保险出单", xinzengbaoxianchudan, weihubaoxianchudan, chakanbaoxianchudan);
//		材料整理档案建立
		QuanXian cailiaozhengli = new QuanXian();
		cailiaozhengli.setQuanXian(quanxianmingcheng, "材料整理档案建立", xinzengcailiaozhengli, weihucailiaozhengli, chakancailiaozhengli);
//		费用结算
		QuanXian feiyongjiesuan = new QuanXian();
		feiyongjiesuan.setQuanXian(quanxianmingcheng, "费用结算", xinzengfeiyongjiesuan, weihufeiyongjiesuan, chakanfeiyongjiesuan);
//		责任人签字
		QuanXian zerenrenqianzi = new QuanXian();
		zerenrenqianzi.setQuanXian(quanxianmingcheng, "责任人签字", xinzengzerenrenqianzi, weihuzerenrenqianzi, chakanzerenrenqianzi);
//		分管领导意见
		QuanXian fenguanlingdaoyijian = new QuanXian();
		fenguanlingdaoyijian.setQuanXian(quanxianmingcheng, "分管领导意见", xinzengfenguanlingdaoyijian, weihufenguanlingdaoyijian, chakanfenguanlingdaoyijian);
//		业务管理
		QuanXian yewuguanli = new QuanXian();
		yewuguanli.setQuanXian(quanxianmingcheng, "业务管理", xinzengyewuguanli, weihuyewuguanli, chakanyewuguanli);
//		客户管理
		QuanXian kehuguanli = new QuanXian();
		kehuguanli.setQuanXian(quanxianmingcheng, "客户管理", xinzengkehuguanli, weihukehuguanli, chakankehuguanli);
//		运单管理
		QuanXian yundanguanli = new QuanXian();
		yundanguanli.setQuanXian(quanxianmingcheng, "运单管理", xinzengyundanguanli, weihuyundanguanli, chakanyundanguanli);
		yundanguanli.setChakansuoyou(chakansuoyouyundanguanli);
//		运单审核
		QuanXian yundanshenhe = new QuanXian();
		yundanshenhe.setQuanXian(quanxianmingcheng, "运单审核", xinzengyundanshenhe, weihuyundanshenhe, chakanyundanshenhe);
//		财务管理
		QuanXian caiwuguanli = new QuanXian();
		caiwuguanli.setQuanXian(quanxianmingcheng, "财务管理", xinzengcaiwuguanli, weihucaiwuguanli, chakancaiwuguanli);
//		开票管理
		QuanXian kaipiaoguanli = new QuanXian();
		kaipiaoguanli.setQuanXian(quanxianmingcheng, "开票管理", xinzengkaipiaoguanli, weihukaipiaoguanli, chakankaipiaoguanli);
//		营收款管理
		QuanXian yingshoukuanguanli = new QuanXian();
		yingshoukuanguanli.setQuanXian(quanxianmingcheng, "营收款管理", xinzengyingshoukuanguanli, weihuyingshoukuanguanli, chakanyingshoukuanguanli);
//		结算单管理
		QuanXian jiesuandanguanli = new QuanXian();
		jiesuandanguanli.setQuanXian(quanxianmingcheng, "结算单管理", xinzengjiesuandanguanli, weihujiesuandanguanli, chakanjiesuandanguanli);
//		危险品数据库
		QuanXian weixianpin = new QuanXian();
		weixianpin.setQuanXian(quanxianmingcheng, "危险品数据库", xinzengweixianpin, weihuweixianpin, chakanweixianpin);
//		管理
		QuanXian guanli = new QuanXian();
		guanli.setQuanXian(quanxianmingcheng, "管理", xinzengguanli, weihuguanli, chakanguanli);
		
//		费用收取 
		QuanXian feiyongshouqu = new QuanXian();
		feiyongshouqu.setQuanXian(quanxianmingcheng, "费用收取", xinzengfeiyongshouqu, weihufeiyongshouqu, chakanfeiyongshouqu);
		
//		开票申请
		QuanXian kaipiaoshenqing = new QuanXian();
		kaipiaoshenqing.setQuanXian(quanxianmingcheng, "开票申请", xinzengkaipiaoshenqing, weihukaipiaoshenqing, chakankaipiaoshenqing);
//		开票审核(分管)
		QuanXian fenguankaipiaoshenhe = new QuanXian();
		fenguankaipiaoshenhe.setQuanXian(quanxianmingcheng, "分管开票审核", xinzengfenguankaipiaoshenhe, weihufenguankaipiaoshenhe, chakanfenguankaipiaoshenhe);
//		开票审核(总经理)
		QuanXian zongjinglikaipiaoshenhe = new QuanXian();
		zongjinglikaipiaoshenhe.setQuanXian(quanxianmingcheng, "总经理开票审核", xinzengzongjinglikaipiaoshenhe, weihuzongjinglikaipiaoshenhe, chakanzongjinglikaipiaoshenhe);
//		开票
		QuanXian kaipiao = new QuanXian();
		kaipiao.setQuanXian(quanxianmingcheng, "开票", xinzengkaipiao, weihukaipiao, chakankaipiao);
		
//		结算申请 
		QuanXian jiesuanshenqing = new QuanXian();
		jiesuanshenqing.setQuanXian(quanxianmingcheng, "结算申请", xinzengjiesuanshenqing, weihujiesuanshenqing, chakanjiesuanshenqing);
//		结算审核(总经理)
		QuanXian zongjinglijiesuanshenhe = new QuanXian();
		zongjinglijiesuanshenhe.setQuanXian(quanxianmingcheng, "总经理结算审核", xinzengzongjinglijiesuanshenhe, weihuzongjinglijiesuanshenhe, chakanzongjinglijiesuanshenhe);
//		结算审核(董事长)
		QuanXian dongshizhangjiesuanshenhe = new QuanXian();
		dongshizhangjiesuanshenhe.setQuanXian(quanxianmingcheng, "董事长结算审核", xinzengdongshizhangjiesuanshenhe, weihudongshizhangjiesuanshenhe, chakandongshizhangjiesuanshenhe);
//		结算
		QuanXian jiesuan = new QuanXian();
		jiesuan.setQuanXian(quanxianmingcheng, "结算", xinzengjiesuan, weihujiesuan, chakanjiesuan);
		
//		-------------
//		添加权限
		quanXianService.addQuanXian(gongzuomenhu);		//工作部门
		quanXianService.addQuanXian(yonghuguanli);		//用户管理
		quanXianService.addQuanXian(quanxianshezhi);	//权限设置
		quanXianService.addQuanXian(bumenguanli);		//部门管理
		quanXianService.addQuanXian(anquanguanli);		//安全管理
		quanXianService.addQuanXian(cheliangguanli);	//车辆管理
		quanXianService.addQuanXian(guanxijianli);		//关系建立
		quanXianService.addQuanXian(baoxianguanli);		//保险管理
		quanXianService.addQuanXian(zhengjianguanli);	//证件管理
		quanXianService.addQuanXian(nianshenguanli);	//年审管理
		quanXianService.addQuanXian(jiashiyuanguanli);	//驾驶员管理
		quanXianService.addQuanXian(jiashiyuanziliao);	//驾驶员资料
		quanXianService.addQuanXian(jiashiyuanshenhe);	//驾驶员审核
		quanXianService.addQuanXian(jiashiyuannianshen);	//驾驶员年审
		quanXianService.addQuanXian(xincheruhu);		//新车入户
		quanXianService.addQuanXian(xincheguanli);		//新车管理
		quanXianService.addQuanXian(tourushenhe);		//投入审核和申请
		quanXianService.addQuanXian(cheguanyewu);		//车管业务
		quanXianService.addQuanXian(yunguanyewu);		//运管业务
		quanXianService.addQuanXian(baoxianchudan);		//保险出单
		quanXianService.addQuanXian(cailiaozhengli);	//材料整理
		quanXianService.addQuanXian(feiyongjiesuan);	//费用结算
		quanXianService.addQuanXian(zerenrenqianzi);	//责任人签字
		quanXianService.addQuanXian(fenguanlingdaoyijian);	//分管领导意见
		quanXianService.addQuanXian(yewuguanli);		//业务管理
		quanXianService.addQuanXian(kehuguanli);		//客户管理
		quanXianService.addQuanXian(yundanguanli);		//运单管理
		quanXianService.addQuanXian(yundanshenhe);		//运单审核
		quanXianService.addQuanXian(caiwuguanli);		//财务管理
		quanXianService.addQuanXian(kaipiaoguanli);		//开票管理
		quanXianService.addQuanXian(yingshoukuanguanli);//营收款管理
		quanXianService.addQuanXian(jiesuandanguanli);	//结算单管理
		quanXianService.addQuanXian(weixianpin);		//危险品数据库
		quanXianService.addQuanXian(guanli);			//管理
		
		quanXianService.addQuanXian(feiyongshouqu);		//费用收取
		
		quanXianService.addQuanXian(kaipiaoshenqing);	//开票申请
		quanXianService.addQuanXian(fenguankaipiaoshenhe);//分管开票审核
		quanXianService.addQuanXian(zongjinglikaipiaoshenhe);//总经理开票审核
		quanXianService.addQuanXian(kaipiao);			//开票
		
		quanXianService.addQuanXian(jiesuanshenqing);	//结算申请
		quanXianService.addQuanXian(zongjinglijiesuanshenhe);//总经理结算审核
		quanXianService.addQuanXian(dongshizhangjiesuanshenhe);	//董事长结算审核
		quanXianService.addQuanXian(jiesuan);			//结算
		
		 quanxianlist = quanXianService.queryQuanXianMingCheng();
		
		return "success";
	}
	
	/**
	 *  删除权限
	 */
	public String deleteQuanXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
//		得到权限名称
		String quanxianmingcheng[] = request.getParameterValues("toolbar1");
		if(quanxianmingcheng ==null || quanxianmingcheng.length<1 ){
			request.setAttribute("quanxianerr", "请选择再删除");
		}
		
		for (int i = 0; i < quanxianmingcheng.length; i++) {
			quanXianService.deleteQuanXianMingCheng(quanxianmingcheng[i]);
			usersService.updateUsersQuanXianMingCheng(quanxianmingcheng[i]);
		}
		
		 quanxianlist = quanXianService.queryQuanXianMingCheng();
		
		return "success";
	}
	
	/**
	 *  跳转-修改权限
	 */
	public String jumpUpdateQuanXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		得到权限名称
		String quanxianmingcheng[] = request.getParameterValues("toolbar1");
		if(quanxianmingcheng ==null || quanxianmingcheng.length<1 || quanxianmingcheng.length>1){
			request.setAttribute("quanxianerr", "请选择单个进行修改");
			return "err";
		}
		

		
//		工作门户
		QuanXian singlemenhu = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "工作门户");
//		用户管理
		QuanXian singleyonghu = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "用户管理");
//		权限设置
		QuanXian singlequanxian = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "权限设置");
//		部门管理
		QuanXian singlebumenguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "部门管理");
//		安全管理 
		QuanXian singleanquanguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "安全管理");
//		车辆管理
		QuanXian singlecheliangguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "车辆管理");
//		关系建立
		QuanXian singleguanxijianli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "关系建立");
//		保险管理
		QuanXian singlebaoxianguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "保险管理");
//		证件管理
		QuanXian singlezhengjianguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "证件管理");
//		年审管理
		QuanXian singlenianshenguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "年审管理");
//		驾驶员管理
		QuanXian singlejiashiyuanguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "驾驶员管理");
//		驾驶员资料
		QuanXian singlejiashiyuanziliao = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "驾驶员资料");
//		驾驶员审核
		QuanXian singlejiashiyuanshenhe = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "驾驶员审核");
//		驾驶员年审
		QuanXian singlejiashiyuannianshen = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "驾驶员年审");
//		新车入户
		QuanXian singlexincheruhu = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "新车入户");
//		新车管理
		QuanXian singlexincheguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "新车管理");
//		投入审核和申请
		QuanXian singletourushenhe = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "投入审核和申请");
//		车管业务
		QuanXian singlecheguanyewu = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "车管业务");
//		运管业务
		QuanXian singleyunguanyewu = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "运管业务");
//		保险出单
		QuanXian singlebaoxianchudan = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "保险出单");
//		材料整理档案建立
		QuanXian singlecailiaozhengli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "材料整理档案建立");
//		费用结算
		QuanXian singlefeiyongjiesuan = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "费用结算");
//		责任人签字
		QuanXian singlezerenrenqianzi = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "责任人签字");
//		分管领导意见
		QuanXian singlefenguanlingdaoyijian = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "分管领导意见");
//		业务管理
		QuanXian singleyewuguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "业务管理");
//		客户管理
		QuanXian singlekehuguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "客户管理");
//		运单管理
		QuanXian singleyundanguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "运单管理");
//		运单审核
		QuanXian singleyundanshenhe = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "运单审核");
//		财务管理
		QuanXian singlecaiwuguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "财务管理");
//		开票管理
		QuanXian singlekaipiaoguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "开票管理");
//		营收款管理
		QuanXian singleyingshoukuanguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "营收款管理");
//		结算单管理
		QuanXian singlejiesuandanguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "结算单管理");
//		危险品数据库
		QuanXian singleweixianpin = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "危险品数据库");
//		管理
		QuanXian singleguanli = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "管理");
		
		
//		费用收取 
		QuanXian singlefeiyongshouqu = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "费用收取");
		
//		开票申请
		QuanXian singlekaipiaoshenqing = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "开票申请");
//		开票审核(分管)
		QuanXian singlefenguankaipiaoshenhe = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "分管开票审核");
//		开票审核(总经理)
		QuanXian singlezongjinglikaipiaoshenhe = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "总经理开票审核");
//		开票
		QuanXian singlekaipiao = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "开票");
		
//		结算申请 
		QuanXian singlejiesuanshenqing = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "结算申请");
//		结算审核(总经理)
		QuanXian singlezongjinglijiesuanshenhe = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "总经理结算审核");
//		结算审核(董事长)
		QuanXian singledongshizhangjiesuanshenhe = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "董事长结算审核");
//		结算
		QuanXian singlejiesuan = quanXianService.queryQuanXianMingChengInBuMen(quanxianmingcheng[0], "结算");
		
		
//		权限名称
		 singlequanxianmingcheng = quanxianmingcheng[0];
		 request.setAttribute("singlequanxianmingcheng", singlequanxianmingcheng);
		
		request.setAttribute("singlemenhu", singlemenhu);
		request.setAttribute("singleyonghu", singleyonghu);
		request.setAttribute("singlequanxian",singlequanxian );
		request.setAttribute("singlebumenguanli",singlebumenguanli );
		request.setAttribute("singleanquanguanli", singleanquanguanli);
		request.setAttribute("singlecheliangguanli", singlecheliangguanli);
		request.setAttribute("singleguanxijianli",singleguanxijianli );
		request.setAttribute("singlebaoxianguanli",singlebaoxianguanli );
		request.setAttribute("singlezhengjianguanli", singlezhengjianguanli);
		request.setAttribute("singlenianshenguanli",singlenianshenguanli );
		request.setAttribute("singlejiashiyuanguanli", singlejiashiyuanguanli);
		request.setAttribute("singlejiashiyuanziliao",singlejiashiyuanziliao );
		request.setAttribute("singlejiashiyuanshenhe", singlejiashiyuanshenhe);
		request.setAttribute("singlejiashiyuannianshen", singlejiashiyuannianshen);
		request.setAttribute("singlexincheruhu", singlexincheruhu);
		request.setAttribute("singlexincheguanli",singlexincheguanli );
		request.setAttribute("singletourushenhe", singletourushenhe);
		request.setAttribute("singlecheguanyewu",singlecheguanyewu );
		request.setAttribute("singleyunguanyewu", singleyunguanyewu);
		request.setAttribute("singlebaoxianchudan", singlebaoxianchudan);
		request.setAttribute("singlecailiaozhengli", singlecailiaozhengli);
		request.setAttribute("singlefeiyongjiesuan", singlefeiyongjiesuan);
		request.setAttribute("singlezerenrenqianzi",singlezerenrenqianzi );
		request.setAttribute("singlefenguanlingdaoyijian",singlefenguanlingdaoyijian );
		request.setAttribute("singleyewuguanli", singleyewuguanli);
		request.setAttribute("singlekehuguanli", singlekehuguanli);
		request.setAttribute("singleyundanguanli",singleyundanguanli );
		request.setAttribute("singleyundanshenhe",singleyundanshenhe );
		request.setAttribute("singlecaiwuguanli", singlecaiwuguanli);
		request.setAttribute("singlekaipiaoguanli",singlekaipiaoguanli );
		request.setAttribute("singleyingshoukuanguanli",singleyingshoukuanguanli );
		request.setAttribute("singlejiesuandanguanli",singlejiesuandanguanli );
		request.setAttribute("singleweixianpin",singleweixianpin );
		request.setAttribute("singleguanli", singleguanli);
		
		request.setAttribute("singlefeiyongshouqu", singlefeiyongshouqu);
		
		request.setAttribute("singlekaipiaoshenqing", singlekaipiaoshenqing);
		request.setAttribute("singlefenguankaipiaoshenhe", singlefenguankaipiaoshenhe);
		request.setAttribute("singlezongjinglikaipiaoshenhe", singlezongjinglikaipiaoshenhe);
		request.setAttribute("singlekaipiao", singlekaipiao);
		
		request.setAttribute("singlejiesuanshenqing", singlejiesuanshenqing);
		request.setAttribute("singlezongjinglijiesuanshenhe", singlezongjinglijiesuanshenhe);
		request.setAttribute("singledongshizhangjiesuanshenhe", singledongshizhangjiesuanshenhe);
		request.setAttribute("singlejiesuan", singlejiesuan);
		
		return "success";
	}
	
	/**
	 *  提交-修改权限
	 */
	public String submitUpdateQuanXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		



		
//		工作门户
		QuanXian singlemenhu = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "工作门户");
		if(singlemenhu == null){
			singlemenhu = new QuanXian(singlequanxianmingcheng, "工作门户");
		}
		singlemenhu.setQuanXian(xinzengmenhu, weihumenhu, chakanmenhu);
//		用户管理
		QuanXian singleyonghu = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "用户管理");
		if(singleyonghu == null){
			singleyonghu = new QuanXian(singlequanxianmingcheng, "用户管理");
		}
		singleyonghu.setQuanXian(xinzengyonghu, weihuyonghu, chakanyonghu);
//		权限设置
		QuanXian singlequanxian = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "权限设置");
		if(singlequanxian == null){
			singlequanxian = new QuanXian(singlequanxianmingcheng, "权限设置");
		}
		singlequanxian.setQuanXian(xinzengquanxian, weihuquanxian, chakanquanxian);
//		部门管理
		QuanXian singlebumenguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "部门管理");
		if(singlebumenguanli == null){
			singlebumenguanli = new QuanXian(singlequanxianmingcheng, "部门管理");
		}
		singlebumenguanli.setQuanXian(xinzengbumen, weihubumen, chakanbumen);
//		安全管理
		QuanXian singleanquanguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "安全管理");
		if(singleanquanguanli == null){
			singleanquanguanli = new QuanXian(singlequanxianmingcheng, "安全管理");
		}
		singleanquanguanli.setQuanXian(xinzenganquanguanli, weihuanquanguanli, chakananquanguanli);
//		车辆管理
		QuanXian singlecheliangguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "车辆管理");
		if(singlecheliangguanli == null){
			singlecheliangguanli = new QuanXian(singlequanxianmingcheng, "车辆管理");
		}
		singlecheliangguanli.setQuanXian(xinzengcheliang, weihucheliang, chakancheliang);
//		关系建立
		QuanXian singleguanxijianli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "关系建立");
		if(singleguanxijianli == null){
			singleguanxijianli = new QuanXian(singlequanxianmingcheng, "关系建立");
		}
		singleguanxijianli.setQuanXian(xinzengguanxijianli, weihuguanxijianli, chakanguanxijianli);
//		保险管理
		QuanXian singlebaoxianguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "保险管理");
		if(singlebaoxianguanli == null){
			singlebaoxianguanli = new QuanXian(singlequanxianmingcheng, "保险管理");
		}
		singlebaoxianguanli.setQuanXian(xinzengbaoxianguanli, weihubaoxianguanli, chakanbaoxianguanli);
//		证件管理
		QuanXian singlezhengjianguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "证件管理");
		if(singlezhengjianguanli == null){
			singlezhengjianguanli = new QuanXian(singlequanxianmingcheng, "证件管理");
		}
		singlezhengjianguanli.setQuanXian(xinzengzhengjian, weihuzhengjian, chakanzhengjian);
//		年审管理
		QuanXian singlenianshenguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "年审管理");
		if(singlenianshenguanli == null){
			singlenianshenguanli = new QuanXian(singlequanxianmingcheng, "年审管理");
		}
		singlenianshenguanli.setQuanXian(xinzengnianshen, weihunianshen, chakannianshen);
		singlenianshenguanli.setChakansuoyou(chakansuoyounianshen);
//		驾驶员管理
		QuanXian singlejiashiyuanguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "驾驶员管理");
		if(singlejiashiyuanguanli == null){
			singlejiashiyuanguanli = new QuanXian(singlequanxianmingcheng, "驾驶员管理");
		}
		singlejiashiyuanguanli.setQuanXian(xinzengjiashiyuanguanli, weihujiashiyuanguanli, chakanjiashiyuanguanli);
//		驾驶员资料
		QuanXian singlejiashiyuanziliao = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "驾驶员资料");
		if(singlejiashiyuanziliao == null){
			singlejiashiyuanziliao = new QuanXian(singlequanxianmingcheng, "驾驶员资料");
		}
		singlejiashiyuanziliao.setQuanXian(xinzengjiashiyuanziliao, weihujiashiyuanziliao, chakanjiashiyuanziliao);
//		驾驶员审核
		QuanXian singlejiashiyuanshenhe = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "驾驶员审核");
		if(singlejiashiyuanshenhe == null){
			singlejiashiyuanshenhe = new QuanXian(singlequanxianmingcheng, "驾驶员审核");
		}
		singlejiashiyuanshenhe.setQuanXian(xinzengjiashiyuanshenhe, weihujiashiyuanshenhe, chakanjiashiyuanshenhe);
//		驾驶员年审
		QuanXian singlejiashiyuannianshen = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "驾驶员年审");
		if(singlejiashiyuannianshen == null){
			singlejiashiyuannianshen = new QuanXian(singlequanxianmingcheng, "驾驶员年审");
		}
		singlejiashiyuannianshen.setQuanXian(xinzengjiashiyuannianshen, weihujiashiyuannianshen, chakanjiashiyuannianshen);
		singlejiashiyuannianshen.setChakansuoyou(chakansuoyoujiashiyuannianshen);
//		新车入户
		QuanXian singlexincheruhu = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "新车入户");
		if(singlexincheruhu == null){
			singlexincheruhu = new QuanXian(singlequanxianmingcheng, "新车入户");
		}
		singlexincheruhu.setQuanXian(xinzengxincheruhu, weihuxincheruhu, chakanxincheruhu);
//		新车管理
		QuanXian singlexincheguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "新车管理");
		if(singlexincheguanli == null){
			singlexincheguanli = new QuanXian(singlequanxianmingcheng, "新车管理");
		}
		singlexincheguanli.setQuanXian(xinzengxinche, weihuxinche, chakanxinche);
//		投入审核和申请
		QuanXian singletourushenhe = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "投入审核和申请");
		if(singletourushenhe == null){
			singletourushenhe = new QuanXian(singlequanxianmingcheng, "投入审核和申请");
		}
		singletourushenhe.setQuanXian(xinzengtourushenhe, weihutourushenhe, chakantourushenhe);
//		车管业务
		QuanXian singlecheguanyewu = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "车管业务");
		if(singlecheguanyewu == null){
			singlecheguanyewu = new QuanXian(singlequanxianmingcheng, "车管业务");
		}
		singlecheguanyewu.setQuanXian(xinzengcheguanyewu, weihucheguanyewu, chakancheguanyewu);
//		运管业务
		QuanXian singleyunguanyewu = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "运管业务");
		if(singleyunguanyewu == null){
			singleyunguanyewu = new QuanXian(singlequanxianmingcheng, "运管业务");
		}
		singleyunguanyewu.setQuanXian(xinzengyunguanyewu, weihuyunguanyewu, chakanyunguanyewu);
//		保险出单
		QuanXian singlebaoxianchudan = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "保险出单");
		if(singlebaoxianchudan == null){
			singlebaoxianchudan = new QuanXian(singlequanxianmingcheng, "保险出单");
		}
		singlebaoxianchudan.setQuanXian(xinzengbaoxianchudan, weihubaoxianchudan, chakanbaoxianchudan);
//		材料整理档案建立
		QuanXian singlecailiaozhengli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "材料整理档案建立");
		if(singlecailiaozhengli == null){
			singlecailiaozhengli = new QuanXian(singlequanxianmingcheng, "材料整理档案建立");
		}
		singlecailiaozhengli.setQuanXian(xinzengcailiaozhengli, weihucailiaozhengli, chakancailiaozhengli);
//		费用结算
		QuanXian singlefeiyongjiesuan = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "费用结算");
		if(singlefeiyongjiesuan == null){
			singlefeiyongjiesuan = new QuanXian(singlequanxianmingcheng, "费用结算");
		}
		singlefeiyongjiesuan.setQuanXian(xinzengfeiyongjiesuan, weihufeiyongjiesuan, chakanfeiyongjiesuan);
//		责任人签字
		QuanXian singlezerenrenqianzi = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "责任人签字");
		if(singlezerenrenqianzi == null){
			singlezerenrenqianzi = new QuanXian(singlequanxianmingcheng, "责任人签字");
		}
		singlezerenrenqianzi.setQuanXian(xinzengzerenrenqianzi, weihuzerenrenqianzi, chakanzerenrenqianzi);
//		分管领导意见
		QuanXian singlefenguanlingdaoyijian = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "分管领导意见");
		if(singlefenguanlingdaoyijian == null){
			singlefenguanlingdaoyijian = new QuanXian(singlequanxianmingcheng, "分管领导意见");
		}
		singlefenguanlingdaoyijian.setQuanXian(xinzengfenguanlingdaoyijian, weihufenguanlingdaoyijian, chakanfenguanlingdaoyijian);
//		业务管理
		QuanXian singleyewuguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "业务管理");
		if(singleyewuguanli == null){
			singleyewuguanli = new QuanXian(singlequanxianmingcheng, "业务管理");
		}
		singleyewuguanli.setQuanXian(xinzengyewuguanli, weihuyewuguanli, chakanyewuguanli);
//		客户管理
		QuanXian singlekehuguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "客户管理");
		if(singlekehuguanli == null){
			singlekehuguanli = new QuanXian(singlequanxianmingcheng, "客户管理");
		}
		singlekehuguanli.setQuanXian(xinzengkehuguanli, weihukehuguanli, chakankehuguanli);
//		运单管理
		QuanXian singleyundanguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "运单管理");
		if(singleyundanguanli == null){
			singleyundanguanli = new QuanXian(singlequanxianmingcheng, "运单管理");
		}
		singleyundanguanli.setQuanXian(xinzengyundanguanli, weihuyundanguanli, chakanyundanguanli);
		singleyundanguanli.setChakansuoyou(chakansuoyouyundanguanli);
//		运单审核
		QuanXian singleyundanshenhe = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "运单审核");
		if(singleyundanshenhe == null){
			singleyundanshenhe = new QuanXian(singlequanxianmingcheng, "运单审核");
		}
		singleyundanshenhe.setQuanXian(xinzengyundanshenhe, weihuyundanshenhe, chakanyundanshenhe);
//		财务管理
		QuanXian singlecaiwuguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "财务管理");
		if(singlecaiwuguanli == null){
			singlecaiwuguanli = new QuanXian(singlequanxianmingcheng, "财务管理");
		}
		singlecaiwuguanli.setQuanXian(xinzengcaiwuguanli, weihucaiwuguanli, chakancaiwuguanli);
//		开票管理
		QuanXian singlekaipiaoguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "开票管理");
		if(singlekaipiaoguanli == null){
			singlekaipiaoguanli = new QuanXian(singlequanxianmingcheng, "开票管理");
		}
		singlekaipiaoguanli.setQuanXian(xinzengkaipiaoguanli, weihukaipiaoguanli, chakankaipiaoguanli);
//		营收款管理
		QuanXian singleyingshoukuanguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "营收款管理");
		if(singleyingshoukuanguanli == null){
			singleyingshoukuanguanli = new QuanXian(singlequanxianmingcheng, "营收款管理");
		}
		singleyingshoukuanguanli.setQuanXian(xinzengyingshoukuanguanli, weihuyingshoukuanguanli, chakanyingshoukuanguanli);
//		结算单管理
		QuanXian singlejiesuandanguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "结算单管理");
		if(singlejiesuandanguanli == null){
			singlejiesuandanguanli = new QuanXian(singlequanxianmingcheng, "结算单管理");
		}
		singlejiesuandanguanli.setQuanXian(xinzengjiesuandanguanli, weihujiesuandanguanli, chakanjiesuandanguanli);
//		危险品数据库
		QuanXian singleweixianpin = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "危险品数据库");
		if(singleweixianpin == null){
			singleweixianpin = new QuanXian(singlequanxianmingcheng, "危险品数据库");
		}
		singleweixianpin.setQuanXian(xinzengweixianpin, weihuweixianpin, chakanweixianpin);
//		管理
		QuanXian singleguanli = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "管理");
		if(singleguanli == null){
			singleguanli = new QuanXian(singlequanxianmingcheng, "管理");
		}
		singleguanli.setQuanXian(xinzengguanli, weihuguanli, chakanguanli);
		
		
//		费用收取 
		QuanXian singlefeiyongshouqu = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "费用收取");
		if(singlefeiyongshouqu == null){
			singlefeiyongshouqu = new QuanXian(singlequanxianmingcheng, "费用收取");
		}
		singlefeiyongshouqu.setQuanXian(xinzengfeiyongshouqu, weihufeiyongshouqu, chakanfeiyongshouqu);
		 
//		开票申请
		QuanXian singlekaipiaoshenqing = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "开票申请");
		if(singlekaipiaoshenqing == null){
			singlekaipiaoshenqing = new QuanXian(singlequanxianmingcheng, "开票申请");
		}
		singlekaipiaoshenqing.setQuanXian(xinzengkaipiaoshenqing, weihukaipiaoshenqing, chakankaipiaoshenqing);
		
//		开票审核(分管)
		QuanXian singlefenguankaipiaoshenhe = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "分管开票审核");
		if(singlefenguankaipiaoshenhe == null){
			singlefenguankaipiaoshenhe = new QuanXian(singlequanxianmingcheng, "分管开票审核");
		}
		singlefenguankaipiaoshenhe.setQuanXian(xinzengfenguankaipiaoshenhe, weihufenguankaipiaoshenhe, chakanfenguankaipiaoshenhe);
		
//		开票审核(总经理)
		QuanXian singlezongjinglikaipiaoshenhe = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "总经理开票审核");
		if(singlezongjinglikaipiaoshenhe == null){
			singlezongjinglikaipiaoshenhe = new QuanXian(singlequanxianmingcheng, "总经理开票审核");
		}
		singlezongjinglikaipiaoshenhe.setQuanXian(xinzengzongjinglikaipiaoshenhe, weihuzongjinglikaipiaoshenhe, chakanzongjinglikaipiaoshenhe);
		
//		开票
		QuanXian singlekaipiao = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "开票");
		if(singlekaipiao == null){
			singlekaipiao = new QuanXian(singlequanxianmingcheng, "开票");
		}
		singlekaipiao.setQuanXian(xinzengkaipiao, weihukaipiao, chakankaipiao);
		
//		结算申请 
		QuanXian singlejiesuanshenqing = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "结算申请");
		if(singlejiesuanshenqing == null){
			singlejiesuanshenqing = new QuanXian(singlequanxianmingcheng, "结算申请");
		}
		singlejiesuanshenqing.setQuanXian(xinzengjiesuanshenqing, weihujiesuanshenqing, chakanjiesuanshenqing);
		
//		结算审核(总经理)
		QuanXian singlezongjinglijiesuanshenhe = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "总经理结算审核");
		if(singlezongjinglijiesuanshenhe == null){
			singlezongjinglijiesuanshenhe = new QuanXian(singlequanxianmingcheng, "总经理结算审核");
		}
		singlezongjinglijiesuanshenhe.setQuanXian(xinzengzongjinglijiesuanshenhe, weihuzongjinglijiesuanshenhe, chakanzongjinglijiesuanshenhe);
		
//		结算审核(董事长)
		QuanXian singledongshizhangjiesuanshenhe = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "董事长结算审核");
		if(singledongshizhangjiesuanshenhe == null){
			singledongshizhangjiesuanshenhe = new QuanXian(singlequanxianmingcheng, "董事长结算审核");
		}
		singledongshizhangjiesuanshenhe.setQuanXian(xinzengdongshizhangjiesuanshenhe, weihudongshizhangjiesuanshenhe, chakandongshizhangjiesuanshenhe);
		
//		结算
		QuanXian singlejiesuan = quanXianService.queryQuanXianMingChengInBuMen(singlequanxianmingcheng, "结算");
		if(singlejiesuan == null){
			singlejiesuan = new QuanXian(singlequanxianmingcheng, "结算");
		}
		singlejiesuan.setQuanXian(xinzengjiesuan, weihujiesuan, chakanjiesuan);
		
//		-----------------------
//		进行修改
		quanXianService.saveAndUpdateQuanXian(singlemenhu);	//工作门户
		quanXianService.saveAndUpdateQuanXian(singleyonghu);	//用户管理
		quanXianService.saveAndUpdateQuanXian(singlequanxian);	//权限设置
		quanXianService.saveAndUpdateQuanXian(singlebumenguanli);	//部门管理
		quanXianService.saveAndUpdateQuanXian(singleanquanguanli);	//安全管理
		quanXianService.saveAndUpdateQuanXian(singlecheliangguanli);	//车辆管理
		quanXianService.saveAndUpdateQuanXian(singleguanxijianli);	//关系建立
		quanXianService.saveAndUpdateQuanXian(singlebaoxianguanli);	//保险管理
		quanXianService.saveAndUpdateQuanXian(singlezhengjianguanli);	//证件管理
		quanXianService.saveAndUpdateQuanXian(singlenianshenguanli);	//年审管理
		quanXianService.saveAndUpdateQuanXian(singlejiashiyuanguanli);	//驾驶员管理
		quanXianService.saveAndUpdateQuanXian(singlejiashiyuanziliao);	//驾驶员资料
		quanXianService.saveAndUpdateQuanXian(singlejiashiyuanshenhe);	//驾驶员审核
		quanXianService.saveAndUpdateQuanXian(singlejiashiyuannianshen);	//驾驶员年审
		quanXianService.saveAndUpdateQuanXian(singlexincheruhu);	//新车入户
		quanXianService.saveAndUpdateQuanXian(singlexincheguanli);	//新车管理
		quanXianService.saveAndUpdateQuanXian(singletourushenhe);	//投入审核和申请
		quanXianService.saveAndUpdateQuanXian(singlecheguanyewu);	//车管业务
		quanXianService.saveAndUpdateQuanXian(singleyunguanyewu);	//运管业务
		quanXianService.saveAndUpdateQuanXian(singlebaoxianchudan);	//保险出单
		quanXianService.saveAndUpdateQuanXian(singlecailiaozhengli);	//材料整理和档案建立
		quanXianService.saveAndUpdateQuanXian(singlefeiyongjiesuan);	//费用结算
		quanXianService.saveAndUpdateQuanXian(singlezerenrenqianzi);	//责任人签字
		quanXianService.saveAndUpdateQuanXian(singlefenguanlingdaoyijian);	//分管领导意见
		quanXianService.saveAndUpdateQuanXian(singleyewuguanli);	//业务管理
		quanXianService.saveAndUpdateQuanXian(singlekehuguanli);	//客户管理
		quanXianService.saveAndUpdateQuanXian(singleyundanguanli);	//运单管理
		quanXianService.saveAndUpdateQuanXian(singleyundanshenhe);	//运单审核
		quanXianService.saveAndUpdateQuanXian(singlecaiwuguanli);	//财务管理
		quanXianService.saveAndUpdateQuanXian(singlekaipiaoguanli);	//开票管理
		quanXianService.saveAndUpdateQuanXian(singleyingshoukuanguanli);	//营收款管理
		quanXianService.saveAndUpdateQuanXian(singlejiesuandanguanli);	//结算单管理
		quanXianService.saveAndUpdateQuanXian(singleweixianpin);	//危险品数据库
		quanXianService.saveAndUpdateQuanXian(singleguanli);	//管理
			
		quanXianService.saveAndUpdateQuanXian(singlefeiyongshouqu);	//费用收取

		quanXianService.saveAndUpdateQuanXian(singlekaipiaoshenqing);	//开票申请
		quanXianService.saveAndUpdateQuanXian(singlefenguankaipiaoshenhe);	//开票审核(分管)
		quanXianService.saveAndUpdateQuanXian(singlezongjinglikaipiaoshenhe);	//开票审核(总经理)
		quanXianService.saveAndUpdateQuanXian(singlekaipiao);	//开票
		
		quanXianService.saveAndUpdateQuanXian(singlejiesuanshenqing);	//结算申请
		quanXianService.saveAndUpdateQuanXian(singlezongjinglijiesuanshenhe);	//结算审核(总经理)
		quanXianService.saveAndUpdateQuanXian(singledongshizhangjiesuanshenhe);	//结算审核(董事长)
		quanXianService.saveAndUpdateQuanXian(singlejiesuan);	//结算
		
		quanxianlist = quanXianService.queryQuanXianMingCheng();
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}

	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}

	public String getChakanmenhu() {
		return chakanmenhu;
	}

	public void setChakanmenhu(String chakanmenhu) {
		this.chakanmenhu = chakanmenhu;
	}

	public String getWeihumenhu() {
		return weihumenhu;
	}

	public void setWeihumenhu(String weihumenhu) {
		this.weihumenhu = weihumenhu;
	}

	public String getXinzengmenhu() {
		return xinzengmenhu;
	}

	public void setXinzengmenhu(String xinzengmenhu) {
		this.xinzengmenhu = xinzengmenhu;
	}

	public String getChakanyonghu() {
		return chakanyonghu;
	}

	public void setChakanyonghu(String chakanyonghu) {
		this.chakanyonghu = chakanyonghu;
	}

	public String getWeihuyonghu() {
		return weihuyonghu;
	}

	public void setWeihuyonghu(String weihuyonghu) {
		this.weihuyonghu = weihuyonghu;
	}

	public String getXinzengyonghu() {
		return xinzengyonghu;
	}

	public void setXinzengyonghu(String xinzengyonghu) {
		this.xinzengyonghu = xinzengyonghu;
	}

	public String getChakanquanxian() {
		return chakanquanxian;
	}

	public void setChakanquanxian(String chakanquanxian) {
		this.chakanquanxian = chakanquanxian;
	}

	public String getWeihuquanxian() {
		return weihuquanxian;
	}

	public void setWeihuquanxian(String weihuquanxian) {
		this.weihuquanxian = weihuquanxian;
	}

	public String getXinzengquanxian() {
		return xinzengquanxian;
	}

	public void setXinzengquanxian(String xinzengquanxian) {
		this.xinzengquanxian = xinzengquanxian;
	}

	public String getChakanbumen() {
		return chakanbumen;
	}

	public void setChakanbumen(String chakanbumen) {
		this.chakanbumen = chakanbumen;
	}

	public String getWeihubumen() {
		return weihubumen;
	}

	public void setWeihubumen(String weihubumen) {
		this.weihubumen = weihubumen;
	}

	public String getXinzengbumen() {
		return xinzengbumen;
	}

	public void setXinzengbumen(String xinzengbumen) {
		this.xinzengbumen = xinzengbumen;
	}

	public String getChakancheliang() {
		return chakancheliang;
	}

	public void setChakancheliang(String chakancheliang) {
		this.chakancheliang = chakancheliang;
	}

	public String getWeihucheliang() {
		return weihucheliang;
	}

	public void setWeihucheliang(String weihucheliang) {
		this.weihucheliang = weihucheliang;
	}

	public String getXinzengcheliang() {
		return xinzengcheliang;
	}

	public void setXinzengcheliang(String xinzengcheliang) {
		this.xinzengcheliang = xinzengcheliang;
	}

	public String getChakanguanxijianli() {
		return chakanguanxijianli;
	}

	public void setChakanguanxijianli(String chakanguanxijianli) {
		this.chakanguanxijianli = chakanguanxijianli;
	}

	public String getWeihuguanxijianli() {
		return weihuguanxijianli;
	}

	public void setWeihuguanxijianli(String weihuguanxijianli) {
		this.weihuguanxijianli = weihuguanxijianli;
	}

	public String getXinzengguanxijianli() {
		return xinzengguanxijianli;
	}

	public void setXinzengguanxijianli(String xinzengguanxijianli) {
		this.xinzengguanxijianli = xinzengguanxijianli;
	}

	public String getChakanbaoxianguanli() {
		return chakanbaoxianguanli;
	}

	public void setChakanbaoxianguanli(String chakanbaoxianguanli) {
		this.chakanbaoxianguanli = chakanbaoxianguanli;
	}

	public String getWeihubaoxianguanli() {
		return weihubaoxianguanli;
	}

	public void setWeihubaoxianguanli(String weihubaoxianguanli) {
		this.weihubaoxianguanli = weihubaoxianguanli;
	}

	public String getXinzengbaoxianguanli() {
		return xinzengbaoxianguanli;
	}

	public void setXinzengbaoxianguanli(String xinzengbaoxianguanli) {
		this.xinzengbaoxianguanli = xinzengbaoxianguanli;
	}

	public String getChakanzhengjian() {
		return chakanzhengjian;
	}

	public void setChakanzhengjian(String chakanzhengjian) {
		this.chakanzhengjian = chakanzhengjian;
	}

	public String getWeihuzhengjian() {
		return weihuzhengjian;
	}

	public void setWeihuzhengjian(String weihuzhengjian) {
		this.weihuzhengjian = weihuzhengjian;
	}

	public String getXinzengzhengjian() {
		return xinzengzhengjian;
	}

	public void setXinzengzhengjian(String xinzengzhengjian) {
		this.xinzengzhengjian = xinzengzhengjian;
	}

	public String getChakannianshen() {
		return chakannianshen;
	}

	public void setChakannianshen(String chakannianshen) {
		this.chakannianshen = chakannianshen;
	}

	public String getWeihunianshen() {
		return weihunianshen;
	}

	public void setWeihunianshen(String weihunianshen) {
		this.weihunianshen = weihunianshen;
	}

	public String getXinzengnianshen() {
		return xinzengnianshen;
	}

	public void setXinzengnianshen(String xinzengnianshen) {
		this.xinzengnianshen = xinzengnianshen;
	}

	public String getChakanjiashiyuanziliao() {
		return chakanjiashiyuanziliao;
	}

	public void setChakanjiashiyuanziliao(String chakanjiashiyuanziliao) {
		this.chakanjiashiyuanziliao = chakanjiashiyuanziliao;
	}

	public String getWeihujiashiyuanziliao() {
		return weihujiashiyuanziliao;
	}

	public void setWeihujiashiyuanziliao(String weihujiashiyuanziliao) {
		this.weihujiashiyuanziliao = weihujiashiyuanziliao;
	}

	public String getXinzengjiashiyuanziliao() {
		return xinzengjiashiyuanziliao;
	}

	public void setXinzengjiashiyuanziliao(String xinzengjiashiyuanziliao) {
		this.xinzengjiashiyuanziliao = xinzengjiashiyuanziliao;
	}

	public String getChakanjiashiyuanshenhe() {
		return chakanjiashiyuanshenhe;
	}

	public void setChakanjiashiyuanshenhe(String chakanjiashiyuanshenhe) {
		this.chakanjiashiyuanshenhe = chakanjiashiyuanshenhe;
	}

	public String getWeihujiashiyuanshenhe() {
		return weihujiashiyuanshenhe;
	}

	public void setWeihujiashiyuanshenhe(String weihujiashiyuanshenhe) {
		this.weihujiashiyuanshenhe = weihujiashiyuanshenhe;
	}

	public String getXinzengjiashiyuanshenhe() {
		return xinzengjiashiyuanshenhe;
	}

	public void setXinzengjiashiyuanshenhe(String xinzengjiashiyuanshenhe) {
		this.xinzengjiashiyuanshenhe = xinzengjiashiyuanshenhe;
	}

	public String getChakanxinche() {
		return chakanxinche;
	}

	public void setChakanxinche(String chakanxinche) {
		this.chakanxinche = chakanxinche;
	}

	public String getWeihuxinche() {
		return weihuxinche;
	}

	public void setWeihuxinche(String weihuxinche) {
		this.weihuxinche = weihuxinche;
	}

	public String getXinzengxinche() {
		return xinzengxinche;
	}

	public void setXinzengxinche(String xinzengxinche) {
		this.xinzengxinche = xinzengxinche;
	}

	public String getChakantourushenhe() {
		return chakantourushenhe;
	}

	public void setChakantourushenhe(String chakantourushenhe) {
		this.chakantourushenhe = chakantourushenhe;
	}

	public String getWeihutourushenhe() {
		return weihutourushenhe;
	}

	public void setWeihutourushenhe(String weihutourushenhe) {
		this.weihutourushenhe = weihutourushenhe;
	}

	public String getXinzengtourushenhe() {
		return xinzengtourushenhe;
	}

	public void setXinzengtourushenhe(String xinzengtourushenhe) {
		this.xinzengtourushenhe = xinzengtourushenhe;
	}

	public String getChakancheguanyewu() {
		return chakancheguanyewu;
	}

	public void setChakancheguanyewu(String chakancheguanyewu) {
		this.chakancheguanyewu = chakancheguanyewu;
	}

	public String getWeihucheguanyewu() {
		return weihucheguanyewu;
	}

	public void setWeihucheguanyewu(String weihucheguanyewu) {
		this.weihucheguanyewu = weihucheguanyewu;
	}

	public String getXinzengcheguanyewu() {
		return xinzengcheguanyewu;
	}

	public void setXinzengcheguanyewu(String xinzengcheguanyewu) {
		this.xinzengcheguanyewu = xinzengcheguanyewu;
	}

	public String getChakanyunguanyewu() {
		return chakanyunguanyewu;
	}

	public void setChakanyunguanyewu(String chakanyunguanyewu) {
		this.chakanyunguanyewu = chakanyunguanyewu;
	}

	public String getWeihuyunguanyewu() {
		return weihuyunguanyewu;
	}

	public void setWeihuyunguanyewu(String weihuyunguanyewu) {
		this.weihuyunguanyewu = weihuyunguanyewu;
	}

	public String getXinzengyunguanyewu() {
		return xinzengyunguanyewu;
	}

	public void setXinzengyunguanyewu(String xinzengyunguanyewu) {
		this.xinzengyunguanyewu = xinzengyunguanyewu;
	}

	public String getChakanbaoxianchudan() {
		return chakanbaoxianchudan;
	}

	public void setChakanbaoxianchudan(String chakanbaoxianchudan) {
		this.chakanbaoxianchudan = chakanbaoxianchudan;
	}

	public String getWeihubaoxianchudan() {
		return weihubaoxianchudan;
	}

	public void setWeihubaoxianchudan(String weihubaoxianchudan) {
		this.weihubaoxianchudan = weihubaoxianchudan;
	}

	public String getXinzengbaoxianchudan() {
		return xinzengbaoxianchudan;
	}

	public void setXinzengbaoxianchudan(String xinzengbaoxianchudan) {
		this.xinzengbaoxianchudan = xinzengbaoxianchudan;
	}

	public String getChakancailiaozhengli() {
		return chakancailiaozhengli;
	}

	public void setChakancailiaozhengli(String chakancailiaozhengli) {
		this.chakancailiaozhengli = chakancailiaozhengli;
	}

	public String getWeihucailiaozhengli() {
		return weihucailiaozhengli;
	}

	public void setWeihucailiaozhengli(String weihucailiaozhengli) {
		this.weihucailiaozhengli = weihucailiaozhengli;
	}

	public String getXinzengcailiaozhengli() {
		return xinzengcailiaozhengli;
	}

	public void setXinzengcailiaozhengli(String xinzengcailiaozhengli) {
		this.xinzengcailiaozhengli = xinzengcailiaozhengli;
	}

	public String getChakanfeiyongjiesuan() {
		return chakanfeiyongjiesuan;
	}

	public void setChakanfeiyongjiesuan(String chakanfeiyongjiesuan) {
		this.chakanfeiyongjiesuan = chakanfeiyongjiesuan;
	}

	public String getWeihufeiyongjiesuan() {
		return weihufeiyongjiesuan;
	}

	public void setWeihufeiyongjiesuan(String weihufeiyongjiesuan) {
		this.weihufeiyongjiesuan = weihufeiyongjiesuan;
	}

	public String getXinzengfeiyongjiesuan() {
		return xinzengfeiyongjiesuan;
	}

	public void setXinzengfeiyongjiesuan(String xinzengfeiyongjiesuan) {
		this.xinzengfeiyongjiesuan = xinzengfeiyongjiesuan;
	}

	public String getChakanzerenrenqianzi() {
		return chakanzerenrenqianzi;
	}

	public void setChakanzerenrenqianzi(String chakanzerenrenqianzi) {
		this.chakanzerenrenqianzi = chakanzerenrenqianzi;
	}

	public String getWeihuzerenrenqianzi() {
		return weihuzerenrenqianzi;
	}

	public void setWeihuzerenrenqianzi(String weihuzerenrenqianzi) {
		this.weihuzerenrenqianzi = weihuzerenrenqianzi;
	}

	public String getXinzengzerenrenqianzi() {
		return xinzengzerenrenqianzi;
	}

	public void setXinzengzerenrenqianzi(String xinzengzerenrenqianzi) {
		this.xinzengzerenrenqianzi = xinzengzerenrenqianzi;
	}

	public String getChakanfenguanlingdaoyijian() {
		return chakanfenguanlingdaoyijian;
	}

	public void setChakanfenguanlingdaoyijian(String chakanfenguanlingdaoyijian) {
		this.chakanfenguanlingdaoyijian = chakanfenguanlingdaoyijian;
	}

	public String getWeihufenguanlingdaoyijian() {
		return weihufenguanlingdaoyijian;
	}

	public void setWeihufenguanlingdaoyijian(String weihufenguanlingdaoyijian) {
		this.weihufenguanlingdaoyijian = weihufenguanlingdaoyijian;
	}

	public String getXinzengfenguanlingdaoyijian() {
		return xinzengfenguanlingdaoyijian;
	}

	public void setXinzengfenguanlingdaoyijian(String xinzengfenguanlingdaoyijian) {
		this.xinzengfenguanlingdaoyijian = xinzengfenguanlingdaoyijian;
	}

	public String getChakankehuguanli() {
		return chakankehuguanli;
	}

	public void setChakankehuguanli(String chakankehuguanli) {
		this.chakankehuguanli = chakankehuguanli;
	}

	public String getWeihukehuguanli() {
		return weihukehuguanli;
	}

	public void setWeihukehuguanli(String weihukehuguanli) {
		this.weihukehuguanli = weihukehuguanli;
	}

	public String getXinzengkehuguanli() {
		return xinzengkehuguanli;
	}

	public void setXinzengkehuguanli(String xinzengkehuguanli) {
		this.xinzengkehuguanli = xinzengkehuguanli;
	}

	public String getChakanyundanguanli() {
		return chakanyundanguanli;
	}

	public void setChakanyundanguanli(String chakanyundanguanli) {
		this.chakanyundanguanli = chakanyundanguanli;
	}

	public String getWeihuyundanguanli() {
		return weihuyundanguanli;
	}

	public void setWeihuyundanguanli(String weihuyundanguanli) {
		this.weihuyundanguanli = weihuyundanguanli;
	}

	public String getXinzengyundanguanli() {
		return xinzengyundanguanli;
	}

	public void setXinzengyundanguanli(String xinzengyundanguanli) {
		this.xinzengyundanguanli = xinzengyundanguanli;
	}

	public String getChakanyundanshenhe() {
		return chakanyundanshenhe;
	}

	public void setChakanyundanshenhe(String chakanyundanshenhe) {
		this.chakanyundanshenhe = chakanyundanshenhe;
	}

	public String getWeihuyundanshenhe() {
		return weihuyundanshenhe;
	}

	public void setWeihuyundanshenhe(String weihuyundanshenhe) {
		this.weihuyundanshenhe = weihuyundanshenhe;
	}

	public String getXinzengyundanshenhe() {
		return xinzengyundanshenhe;
	}

	public void setXinzengyundanshenhe(String xinzengyundanshenhe) {
		this.xinzengyundanshenhe = xinzengyundanshenhe;
	}

	public String getChakankaipiaoguanli() {
		return chakankaipiaoguanli;
	}

	public void setChakankaipiaoguanli(String chakankaipiaoguanli) {
		this.chakankaipiaoguanli = chakankaipiaoguanli;
	}

	public String getWeihukaipiaoguanli() {
		return weihukaipiaoguanli;
	}

	public void setWeihukaipiaoguanli(String weihukaipiaoguanli) {
		this.weihukaipiaoguanli = weihukaipiaoguanli;
	}

	public String getXinzengkaipiaoguanli() {
		return xinzengkaipiaoguanli;
	}

	public void setXinzengkaipiaoguanli(String xinzengkaipiaoguanli) {
		this.xinzengkaipiaoguanli = xinzengkaipiaoguanli;
	}

	public String getChakanyingshoukuanguanli() {
		return chakanyingshoukuanguanli;
	}

	public void setChakanyingshoukuanguanli(String chakanyingshoukuanguanli) {
		this.chakanyingshoukuanguanli = chakanyingshoukuanguanli;
	}

	public String getWeihuyingshoukuanguanli() {
		return weihuyingshoukuanguanli;
	}

	public void setWeihuyingshoukuanguanli(String weihuyingshoukuanguanli) {
		this.weihuyingshoukuanguanli = weihuyingshoukuanguanli;
	}

	public String getXinzengyingshoukuanguanli() {
		return xinzengyingshoukuanguanli;
	}

	public void setXinzengyingshoukuanguanli(String xinzengyingshoukuanguanli) {
		this.xinzengyingshoukuanguanli = xinzengyingshoukuanguanli;
	}

	public String getChakanweixianpin() {
		return chakanweixianpin;
	}

	public void setChakanweixianpin(String chakanweixianpin) {
		this.chakanweixianpin = chakanweixianpin;
	}

	public String getWeihuweixianpin() {
		return weihuweixianpin;
	}

	public void setWeihuweixianpin(String weihuweixianpin) {
		this.weihuweixianpin = weihuweixianpin;
	}

	public String getXinzengweixianpin() {
		return xinzengweixianpin;
	}

	public void setXinzengweixianpin(String xinzengweixianpin) {
		this.xinzengweixianpin = xinzengweixianpin;
	}

	public String getChakanguanli() {
		return chakanguanli;
	}

	public void setChakanguanli(String chakanguanli) {
		this.chakanguanli = chakanguanli;
	}

	public String getWeihuguanli() {
		return weihuguanli;
	}

	public void setWeihuguanli(String weihuguanli) {
		this.weihuguanli = weihuguanli;
	}

	public String getXinzengguanli() {
		return xinzengguanli;
	}

	public void setXinzengguanli(String xinzengguanli) {
		this.xinzengguanli = xinzengguanli;
	}

	public String getChakananquanguanli() {
		return chakananquanguanli;
	}

	public void setChakananquanguanli(String chakananquanguanli) {
		this.chakananquanguanli = chakananquanguanli;
	}

	public String getWeihuanquanguanli() {
		return weihuanquanguanli;
	}

	public void setWeihuanquanguanli(String weihuanquanguanli) {
		this.weihuanquanguanli = weihuanquanguanli;
	}

	public String getXinzenganquanguanli() {
		return xinzenganquanguanli;
	}

	public void setXinzenganquanguanli(String xinzenganquanguanli) {
		this.xinzenganquanguanli = xinzenganquanguanli;
	}

	public String getChakanjiashiyuanguanli() {
		return chakanjiashiyuanguanli;
	}

	public void setChakanjiashiyuanguanli(String chakanjiashiyuanguanli) {
		this.chakanjiashiyuanguanli = chakanjiashiyuanguanli;
	}

	public String getWeihujiashiyuanguanli() {
		return weihujiashiyuanguanli;
	}

	public void setWeihujiashiyuanguanli(String weihujiashiyuanguanli) {
		this.weihujiashiyuanguanli = weihujiashiyuanguanli;
	}

	public String getXinzengjiashiyuanguanli() {
		return xinzengjiashiyuanguanli;
	}

	public void setXinzengjiashiyuanguanli(String xinzengjiashiyuanguanli) {
		this.xinzengjiashiyuanguanli = xinzengjiashiyuanguanli;
	}

	public String getChakanxincheruhu() {
		return chakanxincheruhu;
	}

	public void setChakanxincheruhu(String chakanxincheruhu) {
		this.chakanxincheruhu = chakanxincheruhu;
	}

	public String getWeihuxincheruhu() {
		return weihuxincheruhu;
	}

	public void setWeihuxincheruhu(String weihuxincheruhu) {
		this.weihuxincheruhu = weihuxincheruhu;
	}

	public String getXinzengxincheruhu() {
		return xinzengxincheruhu;
	}

	public void setXinzengxincheruhu(String xinzengxincheruhu) {
		this.xinzengxincheruhu = xinzengxincheruhu;
	}

	public String getChakanyewuguanli() {
		return chakanyewuguanli;
	}

	public void setChakanyewuguanli(String chakanyewuguanli) {
		this.chakanyewuguanli = chakanyewuguanli;
	}

	public String getWeihuyewuguanli() {
		return weihuyewuguanli;
	}

	public void setWeihuyewuguanli(String weihuyewuguanli) {
		this.weihuyewuguanli = weihuyewuguanli;
	}

	public String getXinzengyewuguanli() {
		return xinzengyewuguanli;
	}

	public void setXinzengyewuguanli(String xinzengyewuguanli) {
		this.xinzengyewuguanli = xinzengyewuguanli;
	}

	public String getChakancaiwuguanli() {
		return chakancaiwuguanli;
	}

	public void setChakancaiwuguanli(String chakancaiwuguanli) {
		this.chakancaiwuguanli = chakancaiwuguanli;
	}

	public String getWeihucaiwuguanli() {
		return weihucaiwuguanli;
	}

	public void setWeihucaiwuguanli(String weihucaiwuguanli) {
		this.weihucaiwuguanli = weihucaiwuguanli;
	}

	public String getXinzengcaiwuguanli() {
		return xinzengcaiwuguanli;
	}

	public void setXinzengcaiwuguanli(String xinzengcaiwuguanli) {
		this.xinzengcaiwuguanli = xinzengcaiwuguanli;
	}

	public String getChakanjiesuandanguanli() {
		return chakanjiesuandanguanli;
	}

	public void setChakanjiesuandanguanli(String chakanjiesuandanguanli) {
		this.chakanjiesuandanguanli = chakanjiesuandanguanli;
	}

	public String getWeihujiesuandanguanli() {
		return weihujiesuandanguanli;
	}

	public void setWeihujiesuandanguanli(String weihujiesuandanguanli) {
		this.weihujiesuandanguanli = weihujiesuandanguanli;
	}

	public String getXinzengjiesuandanguanli() {
		return xinzengjiesuandanguanli;
	}

	public void setXinzengjiesuandanguanli(String xinzengjiesuandanguanli) {
		this.xinzengjiesuandanguanli = xinzengjiesuandanguanli;
	}

	public String getChakanjiashiyuannianshen() {
		return chakanjiashiyuannianshen;
	}

	public void setChakanjiashiyuannianshen(String chakanjiashiyuannianshen) {
		this.chakanjiashiyuannianshen = chakanjiashiyuannianshen;
	}

	public String getWeihujiashiyuannianshen() {
		return weihujiashiyuannianshen;
	}

	public void setWeihujiashiyuannianshen(String weihujiashiyuannianshen) {
		this.weihujiashiyuannianshen = weihujiashiyuannianshen;
	}

	public String getXinzengjiashiyuannianshen() {
		return xinzengjiashiyuannianshen;
	}

	public void setXinzengjiashiyuannianshen(String xinzengjiashiyuannianshen) {
		this.xinzengjiashiyuannianshen = xinzengjiashiyuannianshen;
	}

	public String getChakansuoyouyundanguanli() {
		return chakansuoyouyundanguanli;
	}

	public void setChakansuoyouyundanguanli(String chakansuoyouyundanguanli) {
		this.chakansuoyouyundanguanli = chakansuoyouyundanguanli;
	}

	public String getChakanfeiyongshouqu() {
		return chakanfeiyongshouqu;
	}

	public void setChakanfeiyongshouqu(String chakanfeiyongshouqu) {
		this.chakanfeiyongshouqu = chakanfeiyongshouqu;
	}

	public String getWeihufeiyongshouqu() {
		return weihufeiyongshouqu;
	}

	public void setWeihufeiyongshouqu(String weihufeiyongshouqu) {
		this.weihufeiyongshouqu = weihufeiyongshouqu;
	}

	public String getXinzengfeiyongshouqu() {
		return xinzengfeiyongshouqu;
	}

	public void setXinzengfeiyongshouqu(String xinzengfeiyongshouqu) {
		this.xinzengfeiyongshouqu = xinzengfeiyongshouqu;
	}

	public String getChakankaipiaoshenqing() {
		return chakankaipiaoshenqing;
	}

	public void setChakankaipiaoshenqing(String chakankaipiaoshenqing) {
		this.chakankaipiaoshenqing = chakankaipiaoshenqing;
	}

	public String getWeihukaipiaoshenqing() {
		return weihukaipiaoshenqing;
	}

	public void setWeihukaipiaoshenqing(String weihukaipiaoshenqing) {
		this.weihukaipiaoshenqing = weihukaipiaoshenqing;
	}

	public String getXinzengkaipiaoshenqing() {
		return xinzengkaipiaoshenqing;
	}

	public void setXinzengkaipiaoshenqing(String xinzengkaipiaoshenqing) {
		this.xinzengkaipiaoshenqing = xinzengkaipiaoshenqing;
	}

	public String getChakanfenguankaipiaoshenhe() {
		return chakanfenguankaipiaoshenhe;
	}

	public void setChakanfenguankaipiaoshenhe(String chakanfenguankaipiaoshenhe) {
		this.chakanfenguankaipiaoshenhe = chakanfenguankaipiaoshenhe;
	}

	public String getWeihufenguankaipiaoshenhe() {
		return weihufenguankaipiaoshenhe;
	}

	public void setWeihufenguankaipiaoshenhe(String weihufenguankaipiaoshenhe) {
		this.weihufenguankaipiaoshenhe = weihufenguankaipiaoshenhe;
	}

	public String getXinzengfenguankaipiaoshenhe() {
		return xinzengfenguankaipiaoshenhe;
	}

	public void setXinzengfenguankaipiaoshenhe(String xinzengfenguankaipiaoshenhe) {
		this.xinzengfenguankaipiaoshenhe = xinzengfenguankaipiaoshenhe;
	}

	public String getChakanzongjinglikaipiaoshenhe() {
		return chakanzongjinglikaipiaoshenhe;
	}

	public void setChakanzongjinglikaipiaoshenhe(
			String chakanzongjinglikaipiaoshenhe) {
		this.chakanzongjinglikaipiaoshenhe = chakanzongjinglikaipiaoshenhe;
	}

	public String getWeihuzongjinglikaipiaoshenhe() {
		return weihuzongjinglikaipiaoshenhe;
	}

	public void setWeihuzongjinglikaipiaoshenhe(String weihuzongjinglikaipiaoshenhe) {
		this.weihuzongjinglikaipiaoshenhe = weihuzongjinglikaipiaoshenhe;
	}

	public String getXinzengzongjinglikaipiaoshenhe() {
		return xinzengzongjinglikaipiaoshenhe;
	}

	public void setXinzengzongjinglikaipiaoshenhe(
			String xinzengzongjinglikaipiaoshenhe) {
		this.xinzengzongjinglikaipiaoshenhe = xinzengzongjinglikaipiaoshenhe;
	}

	public String getChakankaipiao() {
		return chakankaipiao;
	}

	public void setChakankaipiao(String chakankaipiao) {
		this.chakankaipiao = chakankaipiao;
	}

	public String getWeihukaipiao() {
		return weihukaipiao;
	}

	public void setWeihukaipiao(String weihukaipiao) {
		this.weihukaipiao = weihukaipiao;
	}

	public String getXinzengkaipiao() {
		return xinzengkaipiao;
	}

	public void setXinzengkaipiao(String xinzengkaipiao) {
		this.xinzengkaipiao = xinzengkaipiao;
	}

	public String getChakanjiesuanshenqing() {
		return chakanjiesuanshenqing;
	}

	public void setChakanjiesuanshenqing(String chakanjiesuanshenqing) {
		this.chakanjiesuanshenqing = chakanjiesuanshenqing;
	}

	public String getWeihujiesuanshenqing() {
		return weihujiesuanshenqing;
	}

	public void setWeihujiesuanshenqing(String weihujiesuanshenqing) {
		this.weihujiesuanshenqing = weihujiesuanshenqing;
	}

	public String getXinzengjiesuanshenqing() {
		return xinzengjiesuanshenqing;
	}

	public void setXinzengjiesuanshenqing(String xinzengjiesuanshenqing) {
		this.xinzengjiesuanshenqing = xinzengjiesuanshenqing;
	}

	public String getChakanzongjinglijiesuanshenhe() {
		return chakanzongjinglijiesuanshenhe;
	}

	public void setChakanzongjinglijiesuanshenhe(
			String chakanzongjinglijiesuanshenhe) {
		this.chakanzongjinglijiesuanshenhe = chakanzongjinglijiesuanshenhe;
	}

	public String getWeihuzongjinglijiesuanshenhe() {
		return weihuzongjinglijiesuanshenhe;
	}

	public void setWeihuzongjinglijiesuanshenhe(String weihuzongjinglijiesuanshenhe) {
		this.weihuzongjinglijiesuanshenhe = weihuzongjinglijiesuanshenhe;
	}

	public String getXinzengzongjinglijiesuanshenhe() {
		return xinzengzongjinglijiesuanshenhe;
	}

	public void setXinzengzongjinglijiesuanshenhe(
			String xinzengzongjinglijiesuanshenhe) {
		this.xinzengzongjinglijiesuanshenhe = xinzengzongjinglijiesuanshenhe;
	}

	public String getChakandongshizhangjiesuanshenhe() {
		return chakandongshizhangjiesuanshenhe;
	}

	public void setChakandongshizhangjiesuanshenhe(
			String chakandongshizhangjiesuanshenhe) {
		this.chakandongshizhangjiesuanshenhe = chakandongshizhangjiesuanshenhe;
	}

	public String getWeihudongshizhangjiesuanshenhe() {
		return weihudongshizhangjiesuanshenhe;
	}

	public void setWeihudongshizhangjiesuanshenhe(
			String weihudongshizhangjiesuanshenhe) {
		this.weihudongshizhangjiesuanshenhe = weihudongshizhangjiesuanshenhe;
	}

	public String getXinzengdongshizhangjiesuanshenhe() {
		return xinzengdongshizhangjiesuanshenhe;
	}

	public void setXinzengdongshizhangjiesuanshenhe(
			String xinzengdongshizhangjiesuanshenhe) {
		this.xinzengdongshizhangjiesuanshenhe = xinzengdongshizhangjiesuanshenhe;
	}

	public String getChakanjiesuan() {
		return chakanjiesuan;
	}

	public void setChakanjiesuan(String chakanjiesuan) {
		this.chakanjiesuan = chakanjiesuan;
	}

	public String getWeihujiesuan() {
		return weihujiesuan;
	}

	public void setWeihujiesuan(String weihujiesuan) {
		this.weihujiesuan = weihujiesuan;
	}

	public String getXinzengjiesuan() {
		return xinzengjiesuan;
	}

	public void setXinzengjiesuan(String xinzengjiesuan) {
		this.xinzengjiesuan = xinzengjiesuan;
	}

	public String getChakansuoyounianshen() {
		return chakansuoyounianshen;
	}

	public void setChakansuoyounianshen(String chakansuoyounianshen) {
		this.chakansuoyounianshen = chakansuoyounianshen;
	}

	public String getChakansuoyoujiashiyuannianshen() {
		return chakansuoyoujiashiyuannianshen;
	}

	public void setChakansuoyoujiashiyuannianshen(
			String chakansuoyoujiashiyuannianshen) {
		this.chakansuoyoujiashiyuannianshen = chakansuoyoujiashiyuannianshen;
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

	public QuanXianService getQuanXianService() {
		return quanXianService;
	}

	public void setQuanXianService(QuanXianService quanXianService) {
		this.quanXianService = quanXianService;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
