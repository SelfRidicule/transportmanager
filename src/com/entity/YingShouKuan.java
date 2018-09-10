package com.entity;

import java.util.Date;

/**
 *  营收款 实体类
 */
public class YingShouKuan {
	/**
	 * 构造方法
	 */
	public YingShouKuan() {
		super();
	}

	public YingShouKuan(String dingdanhao, String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou,
			String yingshoukuanzhuangtai, String caozuoyuan, Date caozuoriqi) {
		super();
		this.dingdanhao = dingdanhao;
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
		this.yingshoukuanzhuangtai = yingshoukuanzhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}


	public YingShouKuan(String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou) {
		super();
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
	}

	public YingShouKuan(String caozuoyuan, Date caozuoriqi) {
		super();
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}
	
	public YingShouKuan(String dingdanhao, String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou) {
		super();
		this.dingdanhao = dingdanhao;
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String 	dingdanhao;	//订单号
	private String 	daikongtong;	//带空桶
	private String yingshou;	//营收
	private Date 	daozhangshijian;	//到账时间
	private String  fapiaohao;	//发票号
	private Date	kaipiaoshijian;	//开票时间
	private String shuijin;	//税金
	private String guanlifei;	//管理费
	private String shifuyunfei;	//实付运费
	private Date	lingkuanshijian;	//领款时间
	private String  qianshou;	//签收
	private String  yingshoukuanzhuangtai;	//营收款状态
	
	private String caozuoyuan;	//操作员
	private Date   caozuoriqi;	//操作日期
	
	private String jiesuanzhuangtai;	//结算状态
	private String kehudanwei;	//客户单位
	
	private String zuchefei;	//租车费
	private String yewufei;	//业务费
	
	private String kaipiaoshenqing;//
	private String kaipiaoshenqingren;//

	private String fenguankaipiaoshenhe;//
	private String fenguankaipiaoshenheren;//
	
	private String zongjinglikaipiaoshenhe;//
	private String zongjinglikaipiaoshenheren;//
	
	private String jiesuanshenqing;//
	private String jiesuanshenqingren;//

	private String zongjinglijiesuanshenhe;//
	private String zongjinglijiesuanshenheren;//
	
	private String dongshizhangjiesuanshenhe;//
	private String dongshizhangjiesuanshenheren;//
	
	private String danjia;
	
	private String beizhu;
	
	private String zhenshichezhu;
	
	private String zhuanzhangzhuangtai;
	
	/**
	 * 	赋值方法 
	 */
	public void setYingShouKuan(String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou) {
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
	}
	
	public void setYingShouKuan(String caozuoyuan, Date caozuoriqi) {
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}
	
	public void setYingShouKuan(String dingdanhao, String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou,
			String yingshoukuanzhuangtai, String caozuoyuan, Date caozuoriqi) {
		this.dingdanhao = dingdanhao;
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
		this.yingshoukuanzhuangtai = yingshoukuanzhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}
	
	public void setExcelYingShouKuan(String dingdanhao, String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou) {
		this.dingdanhao = dingdanhao;
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
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

	public String getDingdanhao() {
		return dingdanhao;
	}

	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}

	public String getDaikongtong() {
		return daikongtong;
	}

	public void setDaikongtong(String daikongtong) {
		this.daikongtong = daikongtong;
	}

	public String getYingshou() {
		return yingshou;
	}

	public void setYingshou(String yingshou) {
		this.yingshou = yingshou;
	}

	public Date getDaozhangshijian() {
		return daozhangshijian;
	}

	public void setDaozhangshijian(Date daozhangshijian) {
		this.daozhangshijian = daozhangshijian;
	}

	public String getFapiaohao() {
		return fapiaohao;
	}

	public void setFapiaohao(String fapiaohao) {
		this.fapiaohao = fapiaohao;
	}

	public Date getKaipiaoshijian() {
		return kaipiaoshijian;
	}

	public void setKaipiaoshijian(Date kaipiaoshijian) {
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

	public String getShifuyunfei() {
		return shifuyunfei;
	}

	public void setShifuyunfei(String shifuyunfei) {
		this.shifuyunfei = shifuyunfei;
	}

	public Date getLingkuanshijian() {
		return lingkuanshijian;
	}

	public void setLingkuanshijian(Date lingkuanshijian) {
		this.lingkuanshijian = lingkuanshijian;
	}

	public String getQianshou() {
		return qianshou;
	}

	public void setQianshou(String qianshou) {
		this.qianshou = qianshou;
	}

	public String getYingshoukuanzhuangtai() {
		return yingshoukuanzhuangtai;
	}

	public void setYingshoukuanzhuangtai(String yingshoukuanzhuangtai) {
		this.yingshoukuanzhuangtai = yingshoukuanzhuangtai;
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

	public String getKaipiaoshenqing() {
		return kaipiaoshenqing;
	}

	public void setKaipiaoshenqing(String kaipiaoshenqing) {
		this.kaipiaoshenqing = kaipiaoshenqing;
	}

	public String getKaipiaoshenqingren() {
		return kaipiaoshenqingren;
	}

	public void setKaipiaoshenqingren(String kaipiaoshenqingren) {
		this.kaipiaoshenqingren = kaipiaoshenqingren;
	}

	public String getFenguankaipiaoshenhe() {
		return fenguankaipiaoshenhe;
	}

	public void setFenguankaipiaoshenhe(String fenguankaipiaoshenhe) {
		this.fenguankaipiaoshenhe = fenguankaipiaoshenhe;
	}

	public String getFenguankaipiaoshenheren() {
		return fenguankaipiaoshenheren;
	}

	public void setFenguankaipiaoshenheren(String fenguankaipiaoshenheren) {
		this.fenguankaipiaoshenheren = fenguankaipiaoshenheren;
	}

	public String getZongjinglikaipiaoshenhe() {
		return zongjinglikaipiaoshenhe;
	}

	public void setZongjinglikaipiaoshenhe(String zongjinglikaipiaoshenhe) {
		this.zongjinglikaipiaoshenhe = zongjinglikaipiaoshenhe;
	}

	public String getZongjinglikaipiaoshenheren() {
		return zongjinglikaipiaoshenheren;
	}

	public void setZongjinglikaipiaoshenheren(String zongjinglikaipiaoshenheren) {
		this.zongjinglikaipiaoshenheren = zongjinglikaipiaoshenheren;
	}

	public String getJiesuanshenqing() {
		return jiesuanshenqing;
	}

	public void setJiesuanshenqing(String jiesuanshenqing) {
		this.jiesuanshenqing = jiesuanshenqing;
	}

	public String getJiesuanshenqingren() {
		return jiesuanshenqingren;
	}

	public void setJiesuanshenqingren(String jiesuanshenqingren) {
		this.jiesuanshenqingren = jiesuanshenqingren;
	}

	public String getZongjinglijiesuanshenhe() {
		return zongjinglijiesuanshenhe;
	}

	public void setZongjinglijiesuanshenhe(String zongjinglijiesuanshenhe) {
		this.zongjinglijiesuanshenhe = zongjinglijiesuanshenhe;
	}

	public String getZongjinglijiesuanshenheren() {
		return zongjinglijiesuanshenheren;
	}

	public void setZongjinglijiesuanshenheren(String zongjinglijiesuanshenheren) {
		this.zongjinglijiesuanshenheren = zongjinglijiesuanshenheren;
	}

	public String getDongshizhangjiesuanshenhe() {
		return dongshizhangjiesuanshenhe;
	}

	public void setDongshizhangjiesuanshenhe(String dongshizhangjiesuanshenhe) {
		this.dongshizhangjiesuanshenhe = dongshizhangjiesuanshenhe;
	}

	public String getDongshizhangjiesuanshenheren() {
		return dongshizhangjiesuanshenheren;
	}

	public void setDongshizhangjiesuanshenheren(String dongshizhangjiesuanshenheren) {
		this.dongshizhangjiesuanshenheren = dongshizhangjiesuanshenheren;
	}

	public String getDanjia() {
		return danjia;
	}

	public void setDanjia(String danjia) {
		this.danjia = danjia;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getZhenshichezhu() {
		return zhenshichezhu;
	}

	public void setZhenshichezhu(String zhenshichezhu) {
		this.zhenshichezhu = zhenshichezhu;
	}

	public String getZhuanzhangzhuangtai() {
		return zhuanzhangzhuangtai;
	}

	public void setZhuanzhangzhuangtai(String zhuanzhangzhuangtai) {
		this.zhuanzhangzhuangtai = zhuanzhangzhuangtai;
	}
	
	
}
