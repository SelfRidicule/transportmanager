package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.JiaShiYuan;
import com.entity.YunDan;
import com.myutils.FontFormat;
import com.service.YunDanService;

/**
 *  驾驶员模版类
 */
public class JiaShiYuanModel {
	/**
	 * 构造方法
	 */
	public JiaShiYuanModel() {
		super();
	}

	public JiaShiYuanModel(String id, String jiashiyuanxingming,
			String jiashicheliang, String jiashiyuanleixing, String bumen,
			String chushengriqi, String jiguan, String shenfenzhenghao,
			String dianhua, String dizhi, String zhunjiachexing,
			String chucilingzhengriqi, String jiashizhengnianshenriqi,
			String danganbianhao, String congyezigezhenghao,
			String congyezigeleibie, String congyezigejixujiaoyushijian,
			String congyezigechengxinkaoheshijian, String zhengjianyouxiaoriqi,
			String beizhu, String shenhezhuangtai, String mima, String xingbie,
			String jiashizhengbianhao, String congyezigeriqi,
			String fazhengjiguan, String congyezigejixujiaoyushijianzhi,
			String cheliangzhuangtai) {
		super();
		this.id = id;
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.jiashicheliang = jiashicheliang;
		this.jiashiyuanleixing = jiashiyuanleixing;
		this.bumen = bumen;
		this.chushengriqi = chushengriqi;
		this.jiguan = jiguan;
		this.shenfenzhenghao = shenfenzhenghao;
		this.dianhua = dianhua;
		this.dizhi = dizhi;
		this.zhunjiachexing = zhunjiachexing;
		this.chucilingzhengriqi = chucilingzhengriqi;
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
		this.danganbianhao = danganbianhao;
		this.congyezigezhenghao = congyezigezhenghao;
		this.congyezigeleibie = congyezigeleibie;
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
		this.beizhu = beizhu;
		this.shenhezhuangtai = shenhezhuangtai;
		this.mima = mima;
		this.xingbie = xingbie;
		this.jiashizhengbianhao = jiashizhengbianhao;
		this.congyezigeriqi = congyezigeriqi;
		this.fazhengjiguan = fazhengjiguan;
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
		this.cheliangzhuangtai = cheliangzhuangtai;
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
 


	/**
	 * 属性
	 */
	private String id ;	//id
	private String jiashiyuanxingming;	//驾驶员姓名	
	private String jiashicheliang;	//驾驶车辆
	private String jiashiyuanleixing;	//驾驶员类型
	private String bumen;	//部门
	private String chushengriqi;	//出生日期
	private String jiguan;	//籍贯
	private String shenfenzhenghao;	//身份证号
	private String dianhua;	//电话
	private String dizhi;	//地址
	private String zhunjiachexing;	//准驾车型
	private String chucilingzhengriqi;	//初次领证日期
	private String jiashizhengnianshenriqi;	//驾驶证年审日期
	private String danganbianhao;	//档案编号
	private String congyezigezhenghao;	//从业资格证号
	private String congyezigeleibie;	//从业资格类别
	private String congyezigejixujiaoyushijian;	//从业资格继续教育时间
	private String congyezigechengxinkaoheshijian;	//从业资格诚信考核时间
	private String zhengjianyouxiaoriqi;	//证件有效日期
	private String beizhu;	//备注
	
	private String shenhezhuangtai;	//审核状态
	private String mima;	//密码
	
	private String xingbie;	//性别;
	private String jiashizhengbianhao;	//驾驶证档案编号
	private String   congyezigeriqi;	//从业资格证有效期至
	private String fazhengjiguan;	//发证机关
	private String congyezigejixujiaoyushijianzhi;	//从业资格继续教育时间止
	
	private String cheliangzhuangtai;	//车辆状态
	
	
	public static List<JiaShiYuanModel> getJiaShiYuanModelList( List<JiaShiYuan> jiashiyuanlist , YunDanService yunDanService ){
		
		if(jiashiyuanlist == null){
			return null;
		}
		
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		 
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
//		创建驾驶员模版集合对象
		List<JiaShiYuanModel> jiashiyuanmodellist = new ArrayList<JiaShiYuanModel>();
		
		for (int i = 0; i < jiashiyuanlist.size(); i++) {
			JiaShiYuan jiashiyuan = jiashiyuanlist.get(i);
			
			String id = String.valueOf(jiashiyuan.getId());
			
			String path =request.getContextPath()+"/"+"jiaShiYuanXiangXi?id="+id;
			String jiashiyuanxingming = "<a href=\""+path+"\">"+jiashiyuan.getJiashiyuanxingming()+"</a>";
			
			String jiashicheliang = jiashiyuan.getJiashicheliang();
			String jiashiyuanleixing = jiashiyuan.getJiashiyuanleixing();
			
			String cheliangzhuangtai = "空闲";
			
			List<YunDan> yundanlist = yunDanService.queryYunDanChePaiHao(jiashicheliang);
			
			
			if(yundanlist != null && yundanlist.size()>0){
				YunDan yundan =  yundanlist.get(0);
				String yundanzhuangtai = yundan.getYundanzhuangtai();
				if("已接单".equals(yundanzhuangtai)){
					cheliangzhuangtai="已接单";
				}
			}
			
			 String bumen = jiashiyuan.getBumen();	//部门
			 
			 String chushengriqi = "";	//出生日期
			 if(jiashiyuan.getChushengriqi() != null){
				 chushengriqi = sdf.format( jiashiyuan.getChushengriqi() );
			 }
			 
			 String jiguan = jiashiyuan.getJiguan();	//籍贯
			 
			 String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();	//身份证号
			 
			 String dianhua = jiashiyuan.getDianhua();	//电话
			 
			 String dizhi = jiashiyuan.getDizhi();	//地址
			 
			 String zhunjiachexing = jiashiyuan.getZhunjiachexing();	//准驾车型
			 
			 String chucilingzhengriqi = "";	//初次领证日期
			 if(jiashiyuan.getChucilingzhengriqi() != null){
				 chucilingzhengriqi = sdf.format( jiashiyuan.getChucilingzhengriqi() );
			 }
			 
			 String jiashizhengnianshenriqi = "";	//驾驶证年审日期
			 if(jiashiyuan.getJiashizhengnianshenriqi() != null){
				 jiashizhengnianshenriqi = sdf.format(jiashiyuan.getJiashizhengnianshenriqi());
			 }
			 
			 String danganbianhao = jiashiyuan.getDanganbianhao();	//档案编号
			 
			 String congyezigezhenghao = jiashiyuan.getCongyezigezhenghao();	//从业资格证号
			 
			 String congyezigeleibie = jiashiyuan.getCongyezigeleibie();	//从业资格类别
			 
			 String congyezigejixujiaoyushijian = "";	//从业资格继续教育时间
			 if(jiashiyuan.getCongyezigejixujiaoyushijian() != null){
				 congyezigejixujiaoyushijian = sdf.format( jiashiyuan.getCongyezigejixujiaoyushijian() );
			 }
			 
			 String congyezigechengxinkaoheshijian = "";	//从业资格诚信考核时间
			 if(jiashiyuan.getCongyezigechengxinkaoheshijian() != null){
				 congyezigechengxinkaoheshijian = sdf.format( jiashiyuan.getCongyezigechengxinkaoheshijian() );
			 }
			 
			 String zhengjianyouxiaoriqi = "";	//证件有效日期
			 if(jiashiyuan.getZhengjianyouxiaoriqi() != null){
				 zhengjianyouxiaoriqi = sdf.format( jiashiyuan.getZhengjianyouxiaoriqi() );
			 }
			 
			 String beizhu = jiashiyuan.getBeizhu();	//备注
			
			 String shenhezhuangtai = jiashiyuan.getShenhezhuangtai();	//审核状态
			 
			 String mima = jiashiyuan.getMima();	//密码
			
			 String xingbie = jiashiyuan.getXingbie();	//性别;
			 
			 String jiashizhengbianhao = jiashiyuan.getJiashizhengbianhao();	//驾驶证档案编号
			 
			 String   congyezigeriqi = "";	//从业资格证有效期至
			 if(jiashiyuan.getCongyezigeriqi() != null){
				 congyezigeriqi = sdf.format( jiashiyuan.getCongyezigeriqi() );
			 }
			 
			 String fazhengjiguan = jiashiyuan.getFazhengjiguan();	//发证机关
			 
			 String congyezigejixujiaoyushijianzhi = "";	//从业资格继续教育时间止
			 if(jiashiyuan.getCongyezigejixujiaoyushijianzhi() != null){
				 congyezigejixujiaoyushijianzhi = sdf.format( jiashiyuan.getCongyezigejixujiaoyushijianzhi() );
			 }
			
			
			JiaShiYuanModel jiashiyuanmodel = new JiaShiYuanModel();
			
			jiashiyuanmodel.setJiaShiYuanModel( id,  jiashiyuanxingming,
					 jiashicheliang,  jiashiyuanleixing,  bumen,
					 chushengriqi,  jiguan,  shenfenzhenghao,
					 dianhua,  dizhi,  zhunjiachexing,
					 chucilingzhengriqi,  jiashizhengnianshenriqi,
					 danganbianhao,  congyezigezhenghao,
					 congyezigeleibie,  congyezigejixujiaoyushijian,
					 congyezigechengxinkaoheshijian,  zhengjianyouxiaoriqi,
					 beizhu,  shenhezhuangtai,  mima,  xingbie,
					 jiashizhengbianhao,  congyezigeriqi,
					 fazhengjiguan,  congyezigejixujiaoyushijianzhi,
					 cheliangzhuangtai);
			
			jiashiyuanmodellist.add(jiashiyuanmodel);
		}
		
		return jiashiyuanmodellist;
	}
	
	
	public static List<JiaShiYuanModel> getJiaShiYuanModelListExcel( List<JiaShiYuan> jiashiyuanlist ,YunDanService yunDanService){
		
		if(jiashiyuanlist == null){
			return null;
		}
		
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		 
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
//		创建驾驶员模版集合对象
		List<JiaShiYuanModel> jiashiyuanmodellist = new ArrayList<JiaShiYuanModel>();
		
		for (int i = 0; i < jiashiyuanlist.size(); i++) {
			JiaShiYuan jiashiyuan = jiashiyuanlist.get(i);
			
			String id = String.valueOf(jiashiyuan.getId());
			
			String jiashiyuanxingming = jiashiyuan.getJiashiyuanxingming();
			
			String jiashicheliang = jiashiyuan.getJiashicheliang();
			String jiashiyuanleixing = jiashiyuan.getJiashiyuanleixing();
			
			String cheliangzhuangtai = "空闲";
			
			List<YunDan> yundanlist = yunDanService.queryYunDanChePaiHao(jiashicheliang);
			
			
			if(yundanlist != null && yundanlist.size()>0){
				YunDan yundan =  yundanlist.get(0);
				String yundanzhuangtai = yundan.getYundanzhuangtai();
				if("已接单".equals(yundanzhuangtai)){
					cheliangzhuangtai="已接单";
				}
			}
			
			 String bumen = jiashiyuan.getBumen();	//部门
			 
			 String chushengriqi = "";	//出生日期
			 if(jiashiyuan.getChushengriqi() != null){
				 chushengriqi = sdf.format( jiashiyuan.getChushengriqi() );
			 }
			 
			 String jiguan = jiashiyuan.getJiguan();	//籍贯
			 
			 String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();	//身份证号
			 
			 String dianhua = jiashiyuan.getDianhua();	//电话
			 
			 String dizhi = jiashiyuan.getDizhi();	//地址
			 
			 String zhunjiachexing = jiashiyuan.getZhunjiachexing();	//准驾车型
			 
			 String chucilingzhengriqi = "";	//初次领证日期
			 if(jiashiyuan.getChucilingzhengriqi() != null){
				 chucilingzhengriqi = sdf.format( jiashiyuan.getChucilingzhengriqi() );
			 }
			 
			 String jiashizhengnianshenriqi = "";	//驾驶证年审日期
			 if(jiashiyuan.getJiashizhengnianshenriqi() != null){
				 jiashizhengnianshenriqi = sdf.format(jiashiyuan.getJiashizhengnianshenriqi());
			 }
			 
			 String danganbianhao = jiashiyuan.getDanganbianhao();	//档案编号
			 
			 String congyezigezhenghao = jiashiyuan.getCongyezigezhenghao();	//从业资格证号
			 
			 String congyezigeleibie = jiashiyuan.getCongyezigeleibie();	//从业资格类别
			 
			 String congyezigejixujiaoyushijian = "";	//从业资格继续教育时间
			 if(jiashiyuan.getCongyezigejixujiaoyushijian() != null){
				 congyezigejixujiaoyushijian = sdf.format( jiashiyuan.getCongyezigejixujiaoyushijian() );
			 }
			 
			 String congyezigechengxinkaoheshijian = "";	//从业资格诚信考核时间
			 if(jiashiyuan.getCongyezigechengxinkaoheshijian() != null){
				 congyezigechengxinkaoheshijian = sdf.format( jiashiyuan.getCongyezigechengxinkaoheshijian() );
			 }
			 
			 String zhengjianyouxiaoriqi = "";	//证件有效日期
			 if(jiashiyuan.getZhengjianyouxiaoriqi() != null){
				 zhengjianyouxiaoriqi = sdf.format( jiashiyuan.getZhengjianyouxiaoriqi() );
			 }
			 
			 String beizhu = jiashiyuan.getBeizhu();	//备注
			
			 String shenhezhuangtai = jiashiyuan.getShenhezhuangtai();	//审核状态
			 
			 String mima = jiashiyuan.getMima();	//密码
			
			 String xingbie = jiashiyuan.getXingbie();	//性别;
			 
			 String jiashizhengbianhao = jiashiyuan.getJiashizhengbianhao();	//驾驶证档案编号
			 
			 String   congyezigeriqi = "";	//从业资格证有效期至
			 if(jiashiyuan.getCongyezigeriqi() != null){
				 congyezigeriqi = sdf.format( jiashiyuan.getCongyezigeriqi() );
			 }
			 
			 String fazhengjiguan = jiashiyuan.getFazhengjiguan();	//发证机关
			 
			 String congyezigejixujiaoyushijianzhi = "";	//从业资格继续教育时间止
			 if(jiashiyuan.getCongyezigejixujiaoyushijianzhi() != null){
				 congyezigejixujiaoyushijianzhi = sdf.format( jiashiyuan.getCongyezigejixujiaoyushijianzhi() );
			 }
			
			
			JiaShiYuanModel jiashiyuanmodel = new JiaShiYuanModel();
			
			jiashiyuanmodel.setJiaShiYuanModel( id,  jiashiyuanxingming,
					 jiashicheliang,  jiashiyuanleixing,  bumen,
					 chushengriqi,  jiguan,  shenfenzhenghao,
					 dianhua,  dizhi,  zhunjiachexing,
					 chucilingzhengriqi,  jiashizhengnianshenriqi,
					 danganbianhao,  congyezigezhenghao,
					 congyezigeleibie,  congyezigejixujiaoyushijian,
					 congyezigechengxinkaoheshijian,  zhengjianyouxiaoriqi,
					 beizhu,  shenhezhuangtai,  mima,  xingbie,
					 jiashizhengbianhao,  congyezigeriqi,
					 fazhengjiguan,  congyezigejixujiaoyushijianzhi,
					 cheliangzhuangtai);
			
			jiashiyuanmodellist.add(jiashiyuanmodel);
		}
		
		return jiashiyuanmodellist;
	}
	
	/**
	 *  赋值方法
	 */
	public void  setJiaShiYuanModel(String id, String jiashiyuanxingming,
			String jiashicheliang, String jiashiyuanleixing, String bumen,
			String chushengriqi, String jiguan, String shenfenzhenghao,
			String dianhua, String dizhi, String zhunjiachexing,
			String chucilingzhengriqi, String jiashizhengnianshenriqi,
			String danganbianhao, String congyezigezhenghao,
			String congyezigeleibie, String congyezigejixujiaoyushijian,
			String congyezigechengxinkaoheshijian, String zhengjianyouxiaoriqi,
			String beizhu, String shenhezhuangtai, String mima, String xingbie,
			String jiashizhengbianhao, String congyezigeriqi,
			String fazhengjiguan, String congyezigejixujiaoyushijianzhi,
			String cheliangzhuangtai) {
		this.id = id;
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.jiashicheliang = jiashicheliang;
		this.jiashiyuanleixing = jiashiyuanleixing;
		this.bumen = bumen;
		this.chushengriqi = chushengriqi;
		this.jiguan = jiguan;
		this.shenfenzhenghao = shenfenzhenghao;
		this.dianhua = dianhua;
		this.dizhi = dizhi;
		this.zhunjiachexing = zhunjiachexing;
		this.chucilingzhengriqi = chucilingzhengriqi;
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
		this.danganbianhao = danganbianhao;
		this.congyezigezhenghao = congyezigezhenghao;
		this.congyezigeleibie = congyezigeleibie;
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
		this.beizhu = beizhu;
		this.shenhezhuangtai = shenhezhuangtai;
		this.mima = mima;
		this.xingbie = xingbie;
		this.jiashizhengbianhao = jiashizhengbianhao;
		this.congyezigeriqi = congyezigeriqi;
		this.fazhengjiguan = fazhengjiguan;
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
		this.cheliangzhuangtai = cheliangzhuangtai;
	}
	
	/**
	 *  get set
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJiashiyuanxingming() {
		return jiashiyuanxingming;
	}
	public void setJiashiyuanxingming(String jiashiyuanxingming) {
		this.jiashiyuanxingming = jiashiyuanxingming;
	}
	public String getJiashicheliang() {
		return jiashicheliang;
	}
	public void setJiashicheliang(String jiashicheliang) {
		this.jiashicheliang = jiashicheliang;
	}
	public String getJiashiyuanleixing() {
		return jiashiyuanleixing;
	}
	public void setJiashiyuanleixing(String jiashiyuanleixing) {
		this.jiashiyuanleixing = jiashiyuanleixing;
	}
	public String getCheliangzhuangtai() {
		return cheliangzhuangtai;
	}
	public void setCheliangzhuangtai(String cheliangzhuangtai) {
		this.cheliangzhuangtai = cheliangzhuangtai;
	}
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}
	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
	public String getZhunjiachexing() {
		return zhunjiachexing;
	}
	public void setZhunjiachexing(String zhunjiachexing) {
		this.zhunjiachexing = zhunjiachexing;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getBumen() {
		return bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	public String getChushengriqi() {
		return chushengriqi;
	}

	public void setChushengriqi(String chushengriqi) {
		this.chushengriqi = chushengriqi;
	}

	public String getJiguan() {
		return jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getChucilingzhengriqi() {
		return chucilingzhengriqi;
	}

	public void setChucilingzhengriqi(String chucilingzhengriqi) {
		this.chucilingzhengriqi = chucilingzhengriqi;
	}

	public String getJiashizhengnianshenriqi() {
		return jiashizhengnianshenriqi;
	}

	public void setJiashizhengnianshenriqi(String jiashizhengnianshenriqi) {
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
	}

	public String getDanganbianhao() {
		return danganbianhao;
	}

	public void setDanganbianhao(String danganbianhao) {
		this.danganbianhao = danganbianhao;
	}

	public String getCongyezigezhenghao() {
		return congyezigezhenghao;
	}

	public void setCongyezigezhenghao(String congyezigezhenghao) {
		this.congyezigezhenghao = congyezigezhenghao;
	}

	public String getCongyezigeleibie() {
		return congyezigeleibie;
	}

	public void setCongyezigeleibie(String congyezigeleibie) {
		this.congyezigeleibie = congyezigeleibie;
	}

	public String getCongyezigejixujiaoyushijian() {
		return congyezigejixujiaoyushijian;
	}

	public void setCongyezigejixujiaoyushijian(String congyezigejixujiaoyushijian) {
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
	}

	public String getCongyezigechengxinkaoheshijian() {
		return congyezigechengxinkaoheshijian;
	}

	public void setCongyezigechengxinkaoheshijian(
			String congyezigechengxinkaoheshijian) {
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
	}

	public String getZhengjianyouxiaoriqi() {
		return zhengjianyouxiaoriqi;
	}

	public void setZhengjianyouxiaoriqi(String zhengjianyouxiaoriqi) {
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getShenhezhuangtai() {
		return shenhezhuangtai;
	}

	public void setShenhezhuangtai(String shenhezhuangtai) {
		this.shenhezhuangtai = shenhezhuangtai;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getJiashizhengbianhao() {
		return jiashizhengbianhao;
	}

	public void setJiashizhengbianhao(String jiashizhengbianhao) {
		this.jiashizhengbianhao = jiashizhengbianhao;
	}

	public String getCongyezigeriqi() {
		return congyezigeriqi;
	}

	public void setCongyezigeriqi(String congyezigeriqi) {
		this.congyezigeriqi = congyezigeriqi;
	}

	public String getFazhengjiguan() {
		return fazhengjiguan;
	}

	public void setFazhengjiguan(String fazhengjiguan) {
		this.fazhengjiguan = fazhengjiguan;
	}

	public String getCongyezigejixujiaoyushijianzhi() {
		return congyezigejixujiaoyushijianzhi;
	}

	public void setCongyezigejixujiaoyushijianzhi(
			String congyezigejixujiaoyushijianzhi) {
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
	}
	
}
