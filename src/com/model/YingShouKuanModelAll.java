package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.Customer;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.myutils.FontFormat;
import com.myutils.FormatValueClass;
import com.service.CheLiangService;
import com.service.CustomerService;
import com.service.YunDanService;

/**
 *  营收款模版类  （全部）
 */
public class YingShouKuanModelAll {
	/**
	 * 构造方法
	 */
	public YingShouKuanModelAll() {
		super();
	}
	
	public YingShouKuanModelAll(String dingdanhao, String yunshushijian,
			String chepaihao, String chezhuxingming, String fahuodanwei,
			String huowumingcheng, String shishoudunwei, String shifadunwei,
			String licheng, String danjia, String daikongtong, String qidian,
			String zhongdian, String yingshou, String daozhangshijian,
			String fapiaohao, String kaipiaoshijian, String shuijin,
			String guanlifei, String daidianfei, String shifuyunfei,
			String lingkuanshijian, String kaipiaozhuangtai) {
		super();
		this.dingdanhao = dingdanhao;
		this.yunshushijian = yunshushijian;
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.fahuodanwei = fahuodanwei;
		this.huowumingcheng = huowumingcheng;
		this.shishoudunwei = shishoudunwei;
		this.shifadunwei = shifadunwei;
		this.licheng = licheng;
		this.danjia = danjia;
		this.daikongtong = daikongtong;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.daidianfei = daidianfei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.kaipiaozhuangtai = kaipiaozhuangtai;
	}

	/**
	 * 属性
	 */
	private String id ;		//id
	private String dingdanhao;	//订单号
	private String yunshushijian;	//运输时间
	private String chepaihao;	//车牌号
	private String chezhuxingming;	//车主姓名
	private String fahuodanwei;	//发货单位
	private String huowumingcheng;	//货物名称
	private String shishoudunwei;	//实收吨位
	private String shifadunwei;	//实发吨位
	private String licheng;	//里程
	private String danjia;	//单价
	private String daikongtong;	//带空桶
	private String qidian;	//起点
	private String zhongdian;	//终点
	private String yingshou;	//营收
	private String daozhangshijian;	//到账时间
	private String fapiaohao;	//发票号
	private String kaipiaoshijian;	//开票时间
	private String shuijin;	//税金
	private String guanlifei;	//管理费
	private String daidianfei;	//代垫费
	private String shifuyunfei;	//实付运费
	private String lingkuanshijian;	//领款时间
	private String kaipiaozhuangtai;	//开票状态
	
	private String jiesuanzhuangtai;	//结算状态
	
	private String kehudanwei;	//客户单位
	
	private String zuchefei;	//租车费
	private String yewufei;	//业务费
	
	private String beizhu ;	//备注
	
	/**
	 *  得到营收款模版集合对象全部
	 */
	public static List<YingShouKuanModelAll> getYingShouKuanModelAllList( List<YingShouKuan> yingshoukuanlistall ,YunDanService yunDanService
																			,CheLiangService cheLiangService ,	CustomerService customerService
																		){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		加载applicationContext.xml文件
		
		
		
				
		
		List<YingShouKuanModelAll> yingshoukuanmodelalllist = new ArrayList<YingShouKuanModelAll>();
		
		String yingshoukuanchepaihaoall = (String) session.getAttribute("yingshoukuanchepaihaoall");
		String yingshoukuanhuowumingchengall = (String) session.getAttribute("yingshoukuanhuowumingchengall");
		
		for (int i = 0; i < yingshoukuanlistall.size(); i++) {
			
			 YingShouKuan yingshoukuan = yingshoukuanlistall.get(i);
			
			 String dingdanhao = yingshoukuan.getDingdanhao();	//订单号
			 
			 YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
			 
			 String id = String.valueOf( yingshoukuan.getId() ) ;
			 
			 String yunshushijian = "";	//运输时间
			 
			 String chepaihao = "";
			 if(yundan != null){
				 chepaihao = yundan.getChepaihao();	//车牌号
			 }

			 CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);	
			 		
			 String chezhuxingming = "";	//车主姓名
			 if(cheliang != null){
				 chezhuxingming = cheliang.getChezhuxingming();	//车主姓名
			 }
			 
			 String fahuodanwei = "";	//发货单位
			 String huowumingcheng = "";	//货物名称
			 String shishoudunwei = "";	//实收吨位
			 String shifadunwei = "";	//实发吨位
			 String licheng = "";	//里程
			 String danjia = "";	//单价
			 String daikongtong = FormatValueClass.getFormatValueClass(yingshoukuan.getDaikongtong());	//带空桶
			 String qidian = "";	//起点
			 String zhongdian = "";	//终点
			 String yingshou = FormatValueClass.getFormatValueClass(yingshoukuan.getYingshou());	//营收
			 String daozhangshijian = FormatValueClass.getFormatValueClass(yingshoukuan.getDaozhangshijian());	//到账时间
			 String fapiaohao = FormatValueClass.getFormatValueClass(yingshoukuan.getFapiaohao());	//发票号
			 String kaipiaoshijian = FormatValueClass.getFormatValueClass(yingshoukuan.getKaipiaoshijian());	//开票时间
			 String shuijin = FormatValueClass.getFormatValueClass(yingshoukuan.getShuijin());	//税金
			 String guanlifei = FormatValueClass.getFormatValueClass(yingshoukuan.getGuanlifei());	//管理费
			 String daidianfei = "";	//代垫费
			 String shifuyunfei = FormatValueClass.getFormatValueClass(yingshoukuan.getShifuyunfei());	//实付运费
			 String zuchefei = FormatValueClass.getFormatValueClass(yingshoukuan.getZuchefei());	//租车费
			 String yewufei = FormatValueClass.getFormatValueClass(yingshoukuan.getYewufei());	//业务费
			 String lingkuanshijian = FormatValueClass.getFormatValueClass(yingshoukuan.getLingkuanshijian());	//领款时间
			 String kaipiaozhuangtai = yingshoukuan.getYingshoukuanzhuangtai();	//开票状态
			 String jiesuanzhuangtai = yingshoukuan.getJiesuanzhuangtai();
			 String kehudanwei = yingshoukuan.getKehudanwei();
			
			 String beizhu = yingshoukuan.getBeizhu();	//备注
			 
			 if(yundan != null){
				 if(yundan.getYunshushijian() != null){
					 yunshushijian = FormatValueClass.getFormatValueClass(yundan.getYunshushijian());	//运输时间
				 }
				 
				 chepaihao = yundan.getChepaihao();	//车牌号
				 
				 try {
					 Customer customer = customerService.queryKehudanwei(FormatValueClass.getFormatValueClass(yundan.getKehudanwei()));
					 if(customer != null){
						 fahuodanwei = customer.getShortname();
					 }
				} catch (Exception e) {
				}
				 
				 
				 huowumingcheng = FormatValueClass.getFormatValueClass(yundan.getHuowumingcheng());	//货物名称
				 shishoudunwei = FormatValueClass.getFormatValueClass(yundan.getShishoudunwei());	//实收吨位
				 shifadunwei = FormatValueClass.getFormatValueClass(yundan.getShifadunwei());	//实发吨位
				 licheng = FormatValueClass.getFormatValueClass(yundan.getLicheng());	//里程
				 danjia = FormatValueClass.getFormatValueClass(yingshoukuan.getDanjia());	//单价
				 
				 qidian = FormatValueClass.getFormatValueClass(yundan.getQidian());	//起点
				 zhongdian = FormatValueClass.getFormatValueClass(yundan.getZhongdian());	//终点
				 
				 daidianfei = FormatValueClass.getFormatValueClass(yundan.getDaidianfei());	//代垫费
				 
			 }
			 
			 YingShouKuanModelAll yingshoukuanmodelall = new YingShouKuanModelAll();
			 yingshoukuanmodelall.setYingShouKuanModelAll( id, dingdanhao,  yunshushijian,
						 chepaihao,  chezhuxingming,  fahuodanwei,
						 huowumingcheng,  shishoudunwei,  shifadunwei,
						 licheng,  danjia,  daikongtong,  qidian,
						 zhongdian,  yingshou,  daozhangshijian,
						 fapiaohao,  kaipiaoshijian,  shuijin,
						 guanlifei,  daidianfei,  shifuyunfei,
						 lingkuanshijian,  kaipiaozhuangtai , jiesuanzhuangtai , kehudanwei);
			 yingshoukuanmodelall.setZuchefei(zuchefei);
			 yingshoukuanmodelall.setYewufei(yewufei);
			 yingshoukuanmodelall.setBeizhu(beizhu);
			 
			 yingshoukuanmodelalllist.add(yingshoukuanmodelall);
		}
		
		if(yingshoukuanchepaihaoall == null || "".equals(yingshoukuanchepaihaoall)){
		}else{
			
			for (int i = 0; i < yingshoukuanmodelalllist.size(); i++) {
				YingShouKuanModelAll yingshoukuanmodelall = yingshoukuanmodelalllist.get(i);
				
				if(!yingshoukuanchepaihaoall.equals(yingshoukuanmodelall.getChepaihao())){
					yingshoukuanmodelalllist.remove(i);
					--i;
				}
				
			}
			
		}
		
		if(yingshoukuanhuowumingchengall == null || "".equals(yingshoukuanhuowumingchengall)){
		}else{
			
			for (int i = 0; i < yingshoukuanmodelalllist.size(); i++) {
				YingShouKuanModelAll yingshoukuanmodelall = yingshoukuanmodelalllist.get(i);
				
				if(!yingshoukuanhuowumingchengall.equals(yingshoukuanmodelall.getHuowumingcheng())){
					yingshoukuanmodelalllist.remove(i);
					--i;
				}
				
			}
			
		}
		
		session.removeAttribute("yingshoukuanchepaihaoall");
		session.removeAttribute("yingshoukuanhuowumingchengall");
		
		return yingshoukuanmodelalllist;
	}
	
	/**
	 *  赋值方法
	 */
	public void setYingShouKuanModelAll(String id, String dingdanhao, String yunshushijian,
			String chepaihao, String chezhuxingming, String fahuodanwei,
			String huowumingcheng, String shishoudunwei, String shifadunwei,
			String licheng, String danjia, String daikongtong, String qidian,
			String zhongdian, String yingshou, String daozhangshijian,
			String fapiaohao, String kaipiaoshijian, String shuijin,
			String guanlifei, String daidianfei, String shifuyunfei,
			String lingkuanshijian, String kaipiaozhuangtai ,String jiesuanzhuangtai ,String kehudanwei) {
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.yunshushijian = yunshushijian;
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.fahuodanwei = fahuodanwei;
		this.huowumingcheng = huowumingcheng;
		this.shishoudunwei = shishoudunwei;
		this.shifadunwei = shifadunwei;
		this.licheng = licheng;
		this.danjia = danjia;
		this.daikongtong = daikongtong;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.daidianfei = daidianfei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.kaipiaozhuangtai = kaipiaozhuangtai;
		this.jiesuanzhuangtai = jiesuanzhuangtai;
		this.kehudanwei = kehudanwei;
	}
	
	/**
	 *  get set
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}
	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}
	public String getYunshushijian() {
		return yunshushijian;
	}
	public void setYunshushijian(String yunshushijian) {
		this.yunshushijian = yunshushijian;
	}
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getChezhuxingming() {
		return chezhuxingming;
	}
	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}
	public String getFahuodanwei() {
		return fahuodanwei;
	}
	public void setFahuodanwei(String fahuodanwei) {
		this.fahuodanwei = fahuodanwei;
	}
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	public String getShishoudunwei() {
		return shishoudunwei;
	}
	public void setShishoudunwei(String shishoudunwei) {
		this.shishoudunwei = shishoudunwei;
	}
	public String getShifadunwei() {
		return shifadunwei;
	}
	public void setShifadunwei(String shifadunwei) {
		this.shifadunwei = shifadunwei;
	}
	public String getLicheng() {
		return licheng;
	}
	public void setLicheng(String licheng) {
		this.licheng = licheng;
	}
	public String getDanjia() {
		return danjia;
	}
	public void setDanjia(String danjia) {
		this.danjia = danjia;
	}
	public String getDaikongtong() {
		return daikongtong;
	}
	public void setDaikongtong(String daikongtong) {
		this.daikongtong = daikongtong;
	}
	public String getQidian() {
		return qidian;
	}
	public void setQidian(String qidian) {
		this.qidian = qidian;
	}
	public String getZhongdian() {
		return zhongdian;
	}
	public void setZhongdian(String zhongdian) {
		this.zhongdian = zhongdian;
	}
	public String getYingshou() {
		return yingshou;
	}
	public void setYingshou(String yingshou) {
		this.yingshou = yingshou;
	}
	public String getDaozhangshijian() {
		return daozhangshijian;
	}
	public void setDaozhangshijian(String daozhangshijian) {
		this.daozhangshijian = daozhangshijian;
	}
	public String getFapiaohao() {
		return fapiaohao;
	}
	public void setFapiaohao(String fapiaohao) {
		this.fapiaohao = fapiaohao;
	}
	public String getKaipiaoshijian() {
		return kaipiaoshijian;
	}
	public void setKaipiaoshijian(String kaipiaoshijian) {
		this.kaipiaoshijian = kaipiaoshijian;
	}
	public String getShuijin() {
		return shuijin;
	}
	public void setShuijin(String shuijin) {
		this.shuijin = shuijin;
	}
	public String getGuanlifei() {
		return guanlifei;
	}
	public void setGuanlifei(String guanlifei) {
		this.guanlifei = guanlifei;
	}
	public String getDaidianfei() {
		return daidianfei;
	}
	public void setDaidianfei(String daidianfei) {
		this.daidianfei = daidianfei;
	}
	public String getShifuyunfei() {
		return shifuyunfei;
	}
	public void setShifuyunfei(String shifuyunfei) {
		this.shifuyunfei = shifuyunfei;
	}
	public String getLingkuanshijian() {
		return lingkuanshijian;
	}
	public void setLingkuanshijian(String lingkuanshijian) {
		this.lingkuanshijian = lingkuanshijian;
	}
	public String getKaipiaozhuangtai() {
		return kaipiaozhuangtai;
	}
	public void setKaipiaozhuangtai(String kaipiaozhuangtai) {
		this.kaipiaozhuangtai = kaipiaozhuangtai;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJiesuanzhuangtai() {
		return jiesuanzhuangtai;
	}

	public void setJiesuanzhuangtai(String jiesuanzhuangtai) {
		this.jiesuanzhuangtai = jiesuanzhuangtai;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}

	public String getZuchefei() {
		return zuchefei;
	}

	public void setZuchefei(String zuchefei) {
		this.zuchefei = zuchefei;
	}

	public String getYewufei() {
		return yewufei;
	}

	public void setYewufei(String yewufei) {
		this.yewufei = yewufei;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	
}
