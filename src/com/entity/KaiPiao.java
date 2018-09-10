package com.entity;

import java.util.Date;

/**
 *  开票 实体类
 */
public class KaiPiao {
	/**
	 * 构造方法
	 */
	public KaiPiao() {
		super();
	}

	public KaiPiao(Integer id, String dingdanhao, String chepaihao,
			String kehudanwei, Date kaipiaoshijian, String kaipiaodanwei,
			String shibiehao, String dizhi, String dianhua, String kaihuhang,
			String zhanghao, String chengyunren, String kaipiaojine,
			String shuijin, String guanlifei, String shifuyunfei,
			String daidianfei, String beizhu, String caozuoyuan, Date caozuoriqi) {
		super();
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.kaipiaoshijian = kaipiaoshijian;
		this.kaipiaodanwei = kaipiaodanwei;
		this.shibiehao = shibiehao;
		this.dizhi = dizhi;
		this.dianhua = dianhua;
		this.kaihuhang = kaihuhang;
		this.zhanghao = zhanghao;
		this.chengyunren = chengyunren;
		this.kaipiaojine = kaipiaojine;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.daidianfei = daidianfei;
		this.beizhu = beizhu;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	public KaiPiao(String shudi, String fahuodanwei, String huowumingcheng,
			String shishoudunwei, String shifadunwei, String licheng,
			String danjia, String daikongtong, String qidian, String zhongdian,
			String yingshou, Date daozhangshijian, String fapiaohao,
			Date lingkuanshijian, String qianshou) {
		super();
		this.shudi = shudi;
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
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
	}


	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String dingdanhao;	//订单号
	private String chepaihao;	//车牌号
	private String kehudanwei;	//客户单位
	private Date   kaipiaoshijian;	//开票时间
	private String kaipiaodanwei;	//开票单位
	private String shibiehao;	//识别号
	private String dizhi;	//地址
	private String dianhua;	//电话
	private String kaihuhang;	//开户行
	private String zhanghao;	//帐号
	private String chengyunren;	//承运人
	private String kaipiaojine;	//开票金额
	private String shuijin;	//税金
	private String guanlifei;	//管理费
	private String shifuyunfei;	//实付运费
	private String daidianfei;	//代垫费
	private String beizhu;	//备注
	private String caozuoyuan;	//操作员
	private Date   caozuoriqi;	//操作日期
	private String kaipiaozhuangtai;	//开票状态
	
	private String shudi;	//属地
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
	private Date   daozhangshijian;	//到账时间 
	private String fapiaohao;	//发票号
	private Date   lingkuanshijian;	//领款时间
	private String qianshou;	//签收
	
	private String shishouyunfei;	//实收运费
	
	private String zuchefei;	//租车费
	private String yewufei;	//业务费
	
	/**
	 *  赋值方法 
	 */
	public void setKaiPiao( String dingdanhao, String chepaihao,
			String kehudanwei, Date kaipiaoshijian, String kaipiaodanwei,
			String shibiehao, String dizhi, String dianhua, String kaihuhang,
			String zhanghao, String chengyunren, String kaipiaojine,
			String shuijin, String guanlifei, String shifuyunfei,
			String daidianfei, String beizhu, String caozuoyuan, Date caozuoriqi) {
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.kaipiaoshijian = kaipiaoshijian;
		this.kaipiaodanwei = kaipiaodanwei;
		this.shibiehao = shibiehao;
		this.dizhi = dizhi;
		this.dianhua = dianhua;
		this.kaihuhang = kaihuhang;
		this.zhanghao = zhanghao;
		this.chengyunren = chengyunren;
		this.kaipiaojine = kaipiaojine;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.daidianfei = daidianfei;
		this.beizhu = beizhu;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}
	
	public void setKaiPiaoExcel(String shudi, String fahuodanwei, String huowumingcheng,
			String shishoudunwei, String shifadunwei, String licheng,
			String danjia, String daikongtong, String qidian, String zhongdian,
			String yingshou, Date daozhangshijian, String fapiaohao,
			Date lingkuanshijian, String qianshou) {
		this.shudi = shudi;
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

	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}

	public Date getKaipiaoshijian() {
		return kaipiaoshijian;
	}

	public void setKaipiaoshijian(Date kaipiaoshijian) {
		this.kaipiaoshijian = kaipiaoshijian;
	}

	public String getKaipiaodanwei() {
		return kaipiaodanwei;
	}

	public void setKaipiaodanwei(String kaipiaodanwei) {
		this.kaipiaodanwei = kaipiaodanwei;
	}

	public String getShibiehao() {
		return shibiehao;
	}

	public void setShibiehao(String shibiehao) {
		this.shibiehao = shibiehao;
	}

	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getKaihuhang() {
		return kaihuhang;
	}

	public void setKaihuhang(String kaihuhang) {
		this.kaihuhang = kaihuhang;
	}

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getChengyunren() {
		return chengyunren;
	}

	public void setChengyunren(String chengyunren) {
		this.chengyunren = chengyunren;
	}

	public String getKaipiaojine() {
		return kaipiaojine;
	}

	public void setKaipiaojine(String kaipiaojine) {
		this.kaipiaojine = kaipiaojine;
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

	public String getDaidianfei() {
		return daidianfei;
	}

	public void setDaidianfei(String daidianfei) {
		this.daidianfei = daidianfei;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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

	public String getShudi() {
		return shudi;
	}

	public void setShudi(String shudi) {
		this.shudi = shudi;
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

	public String getKaipiaozhuangtai() {
		return kaipiaozhuangtai;
	}

	public void setKaipiaozhuangtai(String kaipiaozhuangtai) {
		this.kaipiaozhuangtai = kaipiaozhuangtai;
	}

	public String getShishouyunfei() {
		return shishouyunfei;
	}

	public void setShishouyunfei(String shishouyunfei) {
		this.shishouyunfei = shishouyunfei;
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

	
}
