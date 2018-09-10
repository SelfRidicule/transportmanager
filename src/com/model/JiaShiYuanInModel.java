package com.model;

import com.entity.JiaShiYuan;
import com.service.DeptService;

public class JiaShiYuanInModel {
	/**
	 * 构造方法
	 */
	public JiaShiYuanInModel() {
		super();
	}

	public JiaShiYuanInModel(String jiashiyuanxingming, String jiashicheliang,
			String jiashiyuanleixing, String bumen, String chushengriqi,
			String jiguan, String shenfenzhenghao, String dianhua,
			String dizhi, String zhunjiachexing, String chucilingzhengriqi,
			String jiashizhengnianshenriqi, String danganbianhao,
			String congyezigezhenghao, String congyezigeleibie,
			String congyezigejixujiaoyushijian,
			String congyezigechengxinkaoheshijian, String zhengjianyouxiaoriqi,
			String beizhu, String jiashiyuantupian, String jiashizhengtupian,
			String congyezigezhengtupian, String shenfenzhengtupian,
			String caozuoyuan, String caozuoriqi, String shenhezhuangtai,
			String mima) {
		super();
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
		this.jiashiyuantupian = jiashiyuantupian;
		this.jiashizhengtupian = jiashizhengtupian;
		this.congyezigezhengtupian = congyezigezhengtupian;
		this.shenfenzhengtupian = shenfenzhengtupian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.shenhezhuangtai = shenhezhuangtai;
		this.mima = mima;
	}



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
	private String jiashiyuantupian;	//驾驶员图片
	private String jiashizhengtupian;	//驾驶证图片
	private String congyezigezhengtupian;	//从业资格证图片
	private String shenfenzhengtupian;	//身份证图片
	private String caozuoyuan;	//操作员
	private String caozuoriqi;	//操作日期
	private String shenhezhuangtai;	//审核状态
	private String mima;	//密码
	
	/**
	 *  得到驾驶员in模版
	 */
	public static JiaShiYuanInModel getJiaShiYuanInModel(JiaShiYuan jiashiyuan , DeptService deptService){
		JiaShiYuanInModel jiashiyuaninmodel = new JiaShiYuanInModel();
		
//		加载applicationContext.xml文件
		
//		得到部门业务对象
		
		
		 String id = String.valueOf(jiashiyuan.getId());	
		 String jiashiyuanxingming = jiashiyuan.getJiashiyuanxingming();	
		 String jiashicheliang = jiashiyuan.getJiashicheliang();	
		 String jiashiyuanleixing = jiashiyuan.getJiashiyuanleixing();	
		 String bumen = deptService.getDeptId(Integer.valueOf(jiashiyuan.getBumen())).getDeptname();	
		 
		 String chushengriqi = "";
		 if(jiashiyuan.getChushengriqi() != null){
			 chushengriqi = jiashiyuan.getChushengriqi().toString();
		 }
		 
		 String jiguan = jiashiyuan.getJiguan();
		 String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();	
		 String dianhua = jiashiyuan.getDianhua();	
		 String dizhi = jiashiyuan.getDizhi();	
		 String zhunjiachexing = jiashiyuan.getZhunjiachexing();	
		 
		 String chucilingzhengriqi = "";
		 if(jiashiyuan.getChucilingzhengriqi() != null){
			 chucilingzhengriqi = jiashiyuan.getChucilingzhengriqi().toString();	
		 }
		 
		 String jiashizhengnianshenriqi = "";
		 if(jiashiyuan.getJiashizhengnianshenriqi() != null){
			 jiashizhengnianshenriqi = jiashiyuan.getJiashizhengnianshenriqi().toString();	
		 }
		 
		 String danganbianhao = jiashiyuan.getDanganbianhao();	
		 String congyezigezhenghao = jiashiyuan.getCongyezigezhenghao();	
		 String congyezigeleibie = jiashiyuan.getCongyezigeleibie();	
//		 TODO
		 String congyezigejixujiaoyushijian = "";
		 if(jiashiyuan.getCongyezigejixujiaoyushijian() != null){
			 congyezigejixujiaoyushijian = jiashiyuan.getCongyezigejixujiaoyushijian().toString();
		 }
		 
		 String congyezigechengxinkaoheshijian = "";
		 if(jiashiyuan.getCongyezigechengxinkaoheshijian() != null){
			 congyezigechengxinkaoheshijian = jiashiyuan.getCongyezigechengxinkaoheshijian().toString();
		 }
		 
		 String zhengjianyouxiaoriqi = "";
		 if(jiashiyuan.getZhengjianyouxiaoriqi() != null){
			 zhengjianyouxiaoriqi = jiashiyuan.getZhengjianyouxiaoriqi().toString();
		 }
		 
		 String beizhu = jiashiyuan.getBeizhu();
		 String jiashiyuantupian = jiashiyuan.getJiashiyuantupian();	
		 String jiashizhengtupian = jiashiyuan.getJiashizhengtupian();	
		 String congyezigezhengtupian = jiashiyuan.getCongyezigezhengtupian();	
		 String shenfenzhengtupian = jiashiyuan.getShenfenzhengtupian();	
		 String caozuoyuan = jiashiyuan.getCaozuoyuan(); 	
		 String caozuoriqi = jiashiyuan.getCaozuoriqi().toString();	
		 String shenhezhuangtai = jiashiyuan.getShenhezhuangtai();	
		 String mima = jiashiyuan.getMima();	
		
		 jiashiyuaninmodel.setJiaShiYuanInModel(jiashiyuanxingming, jiashicheliang, jiashiyuanleixing,
				 									bumen, chushengriqi, jiguan,
				 									shenfenzhenghao, dianhua, dizhi, 
				 								zhunjiachexing, chucilingzhengriqi, jiashizhengnianshenriqi,
				 								danganbianhao, congyezigezhenghao, congyezigeleibie,
				 								congyezigejixujiaoyushijian, congyezigechengxinkaoheshijian, 
				 								zhengjianyouxiaoriqi, beizhu, jiashiyuantupian, jiashizhengtupian,
				 								congyezigezhengtupian, shenfenzhengtupian, caozuoyuan,
				 								caozuoriqi, shenhezhuangtai, mima);
		 jiashiyuaninmodel.setId(id);
		 
		return jiashiyuaninmodel;
	}
	
	
	/**
	 *  赋值方法
	 */
	public void setJiaShiYuanInModel(String jiashiyuanxingming, String jiashicheliang,
			String jiashiyuanleixing, String bumen, String chushengriqi,
			String jiguan, String shenfenzhenghao, String dianhua,
			String dizhi, String zhunjiachexing, String chucilingzhengriqi,
			String jiashizhengnianshenriqi, String danganbianhao,
			String congyezigezhenghao, String congyezigeleibie,
			String congyezigejixujiaoyushijian,
			String congyezigechengxinkaoheshijian, String zhengjianyouxiaoriqi,
			String beizhu, String jiashiyuantupian, String jiashizhengtupian,
			String congyezigezhengtupian, String shenfenzhengtupian,
			String caozuoyuan, String caozuoriqi, String shenhezhuangtai,
			String mima) {
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
		this.jiashiyuantupian = jiashiyuantupian;
		this.jiashizhengtupian = jiashizhengtupian;
		this.congyezigezhengtupian = congyezigezhengtupian;
		this.shenfenzhengtupian = shenfenzhengtupian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.shenhezhuangtai = shenhezhuangtai;
		this.mima = mima;
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
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}
	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getZhunjiachexing() {
		return zhunjiachexing;
	}
	public void setZhunjiachexing(String zhunjiachexing) {
		this.zhunjiachexing = zhunjiachexing;
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
	public String getJiashiyuantupian() {
		return jiashiyuantupian;
	}
	public void setJiashiyuantupian(String jiashiyuantupian) {
		this.jiashiyuantupian = jiashiyuantupian;
	}
	public String getJiashizhengtupian() {
		return jiashizhengtupian;
	}
	public void setJiashizhengtupian(String jiashizhengtupian) {
		this.jiashizhengtupian = jiashizhengtupian;
	}
	public String getCongyezigezhengtupian() {
		return congyezigezhengtupian;
	}
	public void setCongyezigezhengtupian(String congyezigezhengtupian) {
		this.congyezigezhengtupian = congyezigezhengtupian;
	}
	public String getShenfenzhengtupian() {
		return shenfenzhengtupian;
	}
	public void setShenfenzhengtupian(String shenfenzhengtupian) {
		this.shenfenzhengtupian = shenfenzhengtupian;
	}
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}
	public String getCaozuoriqi() {
		return caozuoriqi;
	}
	public void setCaozuoriqi(String caozuoriqi) {
		this.caozuoriqi = caozuoriqi;
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
	
}
