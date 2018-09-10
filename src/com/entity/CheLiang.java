package com.entity;

import java.util.Date;

/**
 * 车辆类
 */
public class CheLiang {
	/**
	 * 构造方法
	 */
	public CheLiang() {
		super();
	}

	public CheLiang(String chepaihao, String chezhuxingming, String shoujihao,
			String jiayayuan1, String jiayayuan2, String chexing,
			String cheliangleixing, String pingpaixinghao, String shibiedaihao,
			String fadongjihao, String zongzhiliang, String zhengbeizhiliang,
			String hedingzhaizhiliang, String zhunqianyingzongzhiliang,
			String waikuochicun, String cheliangdaoluyunshuzhenghao,
			Date zhuceriqi, Date nianshenriqi, Date erjiweihuriqi,
			Date daoluyunshuzhengnianshenriqi, String yonghumiaoshu,
			String jingyingfanwei, String caozuoyuan, Date caozuoriqi) {
		super();
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.jiayayuan1 = jiayayuan1;
		this.jiayayuan2 = jiayayuan2;
		this.chexing = chexing;
		this.cheliangleixing = cheliangleixing;
		this.pingpaixinghao = pingpaixinghao;
		this.shibiedaihao = shibiedaihao;
		this.fadongjihao = fadongjihao;
		this.zongzhiliang = zongzhiliang;
		this.zhengbeizhiliang = zhengbeizhiliang;
		this.hedingzhaizhiliang = hedingzhaizhiliang;
		this.zhunqianyingzongzhiliang = zhunqianyingzongzhiliang;
		this.waikuochicun = waikuochicun;
		this.cheliangdaoluyunshuzhenghao = cheliangdaoluyunshuzhenghao;
		this.zhuceriqi = zhuceriqi;
		this.nianshenriqi = nianshenriqi;
		this.erjiweihuriqi = erjiweihuriqi;
		this.daoluyunshuzhengnianshenriqi = daoluyunshuzhengnianshenriqi;
		this.yonghumiaoshu = yonghumiaoshu;
		this.jingyingfanwei = jingyingfanwei;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}


	/**
	 * 属性
	 */
	private Integer id ; //车辆id
	private String  chepaihao; //车牌号
	private String  chezhuxingming; //车主姓名
	private String  shoujihao ; //手机号
	private String 	jiayayuan1; //驾押员1
	private String 	jiayayuan2; //驾押员2
	private String  chexing ; //车型
	private String 	cheliangleixing ; //车辆类型
	private String  pingpaixinghao ; //品牌型号
	private String  shibiedaihao ;  //识别代号
	private String  fadongjihao ;  //发动机号
	private String  zongzhiliang ; //总质量  
	private String  zhengbeizhiliang ; //整备质量
	private String  hedingzhaizhiliang ; //核定载质量
	private String  zhunqianyingzongzhiliang ; //准牵引总质量
	private String  waikuochicun ; //外扩尺寸
	private String  cheliangdaoluyunshuzhenghao; //车辆道路运输证号
	private Date    zhuceriqi ; //注册日期
	private Date    nianshenriqi ; //年审日期
	private Date    erjiweihuriqi ; //二级维护日期
	private Date    daoluyunshuzhengnianshenriqi; //道路运输证年审日期
	private String  yonghumiaoshu;   //用户描述
	private String  jingyingfanwei ;   //经营范围
	private String  caozuoyuan ;	//操作员
	private Date    caozuoriqi;	//操作日起
	private String  zhuangtai;	//状态
	
	private Date 	dengjipingdingriqi;	//等级评定日期
	private Date 	guantijianceriqi;	//罐体检测日期
	
	
	private String shenfenzhenghao;	//身份证号
	private String shenfenzhengtupian;	//身份证图片
	private String zhengshubianhao;	//证书编号
	private String cheshenyanse;	//车身颜色
	private String fadongjixinghao;	//发动机型号
	private String ranliaozhonglei;	//燃料种类
	private String pailiang;	//排量
	private String gonglv;	//功率
	private String changjiamingcheng;	//厂家名称
	private String lunjuqian;	//轮距前
	private String lunjuhou;	//轮距后
	private String luntaishu;	//轮胎数
	private String luntaiguige;	//轮胎规格
	private String gangbantanhuangpianshu;	//钢板弹簧片数
	private String zhouju;	//轴距
	private String zhoushu;	//轴数
	private String huoxiangchang;	//货箱长
	private String huoxiangkuan;	//货箱宽
	private String huoxianggao;		//货箱高
	private String cheliangfenzu;	//车辆分组
	
	private String gouchefei;	//够车费
	
	/**
	 *  赋值方法
	 */
	public void setCheLiang(String chepaihao, String chezhuxingming, String shoujihao,
			String jiayayuan1, String jiayayuan2, String chexing,
			String cheliangleixing, String pingpaixinghao, String shibiedaihao,
			String fadongjihao, String zongzhiliang, String zhengbeizhiliang,
			String hedingzhaizhiliang, String zhunqianyingzongzhiliang,
			String waikuochicun, String cheliangdaoluyunshuzhenghao,
			Date zhuceriqi, Date nianshenriqi, Date erjiweihuriqi,
			Date daoluyunshuzhengnianshenriqi, String yonghumiaoshu,
			String jingyingfanwei, String caozuoyuan, Date caozuoriqi,String zhuangtai) {
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.jiayayuan1 = jiayayuan1;
		this.jiayayuan2 = jiayayuan2;
		this.chexing = chexing;
		this.cheliangleixing = cheliangleixing;
		this.pingpaixinghao = pingpaixinghao;
		this.shibiedaihao = shibiedaihao;
		this.fadongjihao = fadongjihao;
		this.zongzhiliang = zongzhiliang;
		this.zhengbeizhiliang = zhengbeizhiliang;
		this.hedingzhaizhiliang = hedingzhaizhiliang;
		this.zhunqianyingzongzhiliang = zhunqianyingzongzhiliang;
		this.waikuochicun = waikuochicun;
		this.cheliangdaoluyunshuzhenghao = cheliangdaoluyunshuzhenghao;
		this.zhuceriqi = zhuceriqi;
		this.nianshenriqi = nianshenriqi;
		this.erjiweihuriqi = erjiweihuriqi;
		this.daoluyunshuzhengnianshenriqi = daoluyunshuzhengnianshenriqi;
		this.yonghumiaoshu = yonghumiaoshu;
		this.jingyingfanwei = jingyingfanwei;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.zhuangtai=zhuangtai;
	}
	
	public void setCheLiangTwo(String shenfenzhenghao, String shenfenzhengtupian,
			String zhengshubianhao, String cheshenyanse,
			String fadongjixinghao, String ranliaozhonglei, String pailiang,
			String gonglv, String changjiamingcheng, String lunjuqian,
			String lunjuhou, String luntaishu, String luntaiguige,
			String gangbantanhuangpianshu, String zhouju, String zhoushu,
			String huoxiangchang, String huoxiangkuan, String huoxianggao,
			String cheliangfenzu) {
		this.shenfenzhenghao = shenfenzhenghao;
		this.shenfenzhengtupian = shenfenzhengtupian;
		this.zhengshubianhao = zhengshubianhao;
		this.cheshenyanse = cheshenyanse;
		this.fadongjixinghao = fadongjixinghao;
		this.ranliaozhonglei = ranliaozhonglei;
		this.pailiang = pailiang;
		this.gonglv = gonglv;
		this.changjiamingcheng = changjiamingcheng;
		this.lunjuqian = lunjuqian;
		this.lunjuhou = lunjuhou;
		this.luntaishu = luntaishu;
		this.luntaiguige = luntaiguige;
		this.gangbantanhuangpianshu = gangbantanhuangpianshu;
		this.zhouju = zhouju;
		this.zhoushu = zhoushu;
		this.huoxiangchang = huoxiangchang;
		this.huoxiangkuan = huoxiangkuan;
		this.huoxianggao = huoxianggao;
		this.cheliangfenzu = cheliangfenzu;
	}
	
	/**
	 * 输出所有属性
	 */
	@Override
	public String toString() {
		return "CheLiang [id=" + id + ", chepaihao=" + chepaihao
				+ ", chezhuxingming=" + chezhuxingming + ", shoujihao="
				+ shoujihao + ", jiayayuan1=" + jiayayuan1 + ", jiayayuan2="
				+ jiayayuan2 + ", chexing=" + chexing + ", cheliangleixing="
				+ cheliangleixing + ", pingpaixinghao=" + pingpaixinghao
				+ ", shibiedaihao=" + shibiedaihao + ", fadongjihao="
				+ fadongjihao + ", zongzhiliang=" + zongzhiliang
				+ ", zhengbeizhiliang=" + zhengbeizhiliang
				+ ", hedingzhaizhiliang=" + hedingzhaizhiliang
				+ ", zhunqianyingzongzhiliang=" + zhunqianyingzongzhiliang
				+ ", waikuochicun=" + waikuochicun
				+ ", cheliangdaoluyunshuzhenghao="
				+ cheliangdaoluyunshuzhenghao + ", zhuceriqi=" + zhuceriqi
				+ ", nianshenriqi=" + nianshenriqi + ", erjiweihuriqi="
				+ erjiweihuriqi + ", daoluyunshuzhengnianshenriqi="
				+ daoluyunshuzhengnianshenriqi + ", yonghumiaoshu="
				+ yonghumiaoshu + ", jingyingfanwei=" + jingyingfanwei
				+ ", caozuoyuan=" + caozuoyuan + ", caozuoriqi=" + caozuoriqi
				+ "]";
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
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getJiayayuan1() {
		return jiayayuan1;
	}
	public void setJiayayuan1(String jiayayuan1) {
		this.jiayayuan1 = jiayayuan1;
	}
	public String getJiayayuan2() {
		return jiayayuan2;
	}
	public void setJiayayuan2(String jiayayuan2) {
		this.jiayayuan2 = jiayayuan2;
	}
	public String getChexing() {
		return chexing;
	}
	public void setChexing(String chexing) {
		this.chexing = chexing;
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
	public String getShibiedaihao() {
		return shibiedaihao;
	}
	public void setShibiedaihao(String shibiedaihao) {
		this.shibiedaihao = shibiedaihao;
	}
	public String getFadongjihao() {
		return fadongjihao;
	}
	public void setFadongjihao(String fadongjihao) {
		this.fadongjihao = fadongjihao;
	}
	public String getZongzhiliang() {
		return zongzhiliang;
	}
	public void setZongzhiliang(String zongzhiliang) {
		this.zongzhiliang = zongzhiliang;
	}
	public String getZhengbeizhiliang() {
		return zhengbeizhiliang;
	}
	public void setZhengbeizhiliang(String zhengbeizhiliang) {
		this.zhengbeizhiliang = zhengbeizhiliang;
	}
	public String getHedingzhaizhiliang() {
		return hedingzhaizhiliang;
	}
	public void setHedingzhaizhiliang(String hedingzhaizhiliang) {
		this.hedingzhaizhiliang = hedingzhaizhiliang;
	}
	public String getZhunqianyingzongzhiliang() {
		return zhunqianyingzongzhiliang;
	}
	public void setZhunqianyingzongzhiliang(String zhunqianyingzongzhiliang) {
		this.zhunqianyingzongzhiliang = zhunqianyingzongzhiliang;
	}
	public String getWaikuochicun() {
		return waikuochicun;
	}
	public void setWaikuochicun(String waikuochicun) {
		this.waikuochicun = waikuochicun;
	}
	public String getCheliangdaoluyunshuzhenghao() {
		return cheliangdaoluyunshuzhenghao;
	}
	public void setCheliangdaoluyunshuzhenghao(String cheliangdaoluyunshuzhenghao) {
		this.cheliangdaoluyunshuzhenghao = cheliangdaoluyunshuzhenghao;
	}
	public Date getZhuceriqi() {
		return zhuceriqi;
	}
	public void setZhuceriqi(Date zhuceriqi) {
		this.zhuceriqi = zhuceriqi;
	}
	public Date getNianshenriqi() {
		return nianshenriqi;
	}
	public void setNianshenriqi(Date nianshenriqi) {
		this.nianshenriqi = nianshenriqi;
	}
	public Date getErjiweihuriqi() {
		return erjiweihuriqi;
	}
	public void setErjiweihuriqi(Date erjiweihuriqi) {
		this.erjiweihuriqi = erjiweihuriqi;
	}
	public Date getDaoluyunshuzhengnianshenriqi() {
		return daoluyunshuzhengnianshenriqi;
	}
	public void setDaoluyunshuzhengnianshenriqi(Date daoluyunshuzhengnianshenriqi) {
		this.daoluyunshuzhengnianshenriqi = daoluyunshuzhengnianshenriqi;
	}
	public String getYonghumiaoshu() {
		return yonghumiaoshu;
	}
	public void setYonghumiaoshu(String yonghumiaoshu) {
		this.yonghumiaoshu = yonghumiaoshu;
	}
	public String getJingyingfanwei() {
		return jingyingfanwei;
	}
	public void setJingyingfanwei(String jingyingfanwei) {
		this.jingyingfanwei = jingyingfanwei;
	}
	public String getChezhuxingming() {
		return chezhuxingming;
	}
	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}
	public String getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
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

	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public Date getDengjipingdingriqi() {
		return dengjipingdingriqi;
	}

	public void setDengjipingdingriqi(Date dengjipingdingriqi) {
		this.dengjipingdingriqi = dengjipingdingriqi;
	}

	public Date getGuantijianceriqi() {
		return guantijianceriqi;
	}

	public void setGuantijianceriqi(Date guantijianceriqi) {
		this.guantijianceriqi = guantijianceriqi;
	}

	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}

	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}

	public String getShenfenzhengtupian() {
		return shenfenzhengtupian;
	}

	public void setShenfenzhengtupian(String shenfenzhengtupian) {
		this.shenfenzhengtupian = shenfenzhengtupian;
	}

	public String getZhengshubianhao() {
		return zhengshubianhao;
	}

	public void setZhengshubianhao(String zhengshubianhao) {
		this.zhengshubianhao = zhengshubianhao;
	}

	public String getCheshenyanse() {
		return cheshenyanse;
	}

	public void setCheshenyanse(String cheshenyanse) {
		this.cheshenyanse = cheshenyanse;
	}

	public String getFadongjixinghao() {
		return fadongjixinghao;
	}

	public void setFadongjixinghao(String fadongjixinghao) {
		this.fadongjixinghao = fadongjixinghao;
	}

	public String getRanliaozhonglei() {
		return ranliaozhonglei;
	}

	public void setRanliaozhonglei(String ranliaozhonglei) {
		this.ranliaozhonglei = ranliaozhonglei;
	}

	public String getPailiang() {
		return pailiang;
	}

	public void setPailiang(String pailiang) {
		this.pailiang = pailiang;
	}

	public String getGonglv() {
		return gonglv;
	}

	public void setGonglv(String gonglv) {
		this.gonglv = gonglv;
	}

	public String getChangjiamingcheng() {
		return changjiamingcheng;
	}

	public void setChangjiamingcheng(String changjiamingcheng) {
		this.changjiamingcheng = changjiamingcheng;
	}

	public String getLunjuqian() {
		return lunjuqian;
	}

	public void setLunjuqian(String lunjuqian) {
		this.lunjuqian = lunjuqian;
	}

	public String getLunjuhou() {
		return lunjuhou;
	}

	public void setLunjuhou(String lunjuhou) {
		this.lunjuhou = lunjuhou;
	}

	public String getLuntaishu() {
		return luntaishu;
	}

	public void setLuntaishu(String luntaishu) {
		this.luntaishu = luntaishu;
	}

	public String getLuntaiguige() {
		return luntaiguige;
	}

	public void setLuntaiguige(String luntaiguige) {
		this.luntaiguige = luntaiguige;
	}

	public String getGangbantanhuangpianshu() {
		return gangbantanhuangpianshu;
	}

	public void setGangbantanhuangpianshu(String gangbantanhuangpianshu) {
		this.gangbantanhuangpianshu = gangbantanhuangpianshu;
	}

	public String getZhouju() {
		return zhouju;
	}

	public void setZhouju(String zhouju) {
		this.zhouju = zhouju;
	}

	public String getZhoushu() {
		return zhoushu;
	}

	public void setZhoushu(String zhoushu) {
		this.zhoushu = zhoushu;
	}

	public String getHuoxiangchang() {
		return huoxiangchang;
	}

	public void setHuoxiangchang(String huoxiangchang) {
		this.huoxiangchang = huoxiangchang;
	}

	public String getHuoxiangkuan() {
		return huoxiangkuan;
	}

	public void setHuoxiangkuan(String huoxiangkuan) {
		this.huoxiangkuan = huoxiangkuan;
	}

	public String getHuoxianggao() {
		return huoxianggao;
	}

	public void setHuoxianggao(String huoxianggao) {
		this.huoxianggao = huoxianggao;
	}

	public String getCheliangfenzu() {
		return cheliangfenzu;
	}

	public void setCheliangfenzu(String cheliangfenzu) {
		this.cheliangfenzu = cheliangfenzu;
	}

	public String getGouchefei() {
		return gouchefei;
	}

	public void setGouchefei(String gouchefei) {
		this.gouchefei = gouchefei;
	}


}
