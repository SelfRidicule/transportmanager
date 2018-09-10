package com.model;

import java.util.Date;

/**
 * 车辆json
 */
public class CheLiangJsonModel {
	/**
	 * 构造方法
	 */
	public CheLiangJsonModel() {
		super();
	}

	public CheLiangJsonModel(String id, String chepaihao, String jiayayuan,
			String chexing, String cheliangleixing, String zhuceriqi,
			String zhuangtai, String beizhu, String caozuoyuan,
			String chezhuxingming, String shoujihao, String pingpaixinghao,
			String shibiedaihao, String fadongjihao, String zongzhiliang,
			String zhengbeizhiliang, String hedingzhaizhiliang,
			String zhunqianyingzongzhiliang, String waikuochicun,
			String cheliangdaoluyunshuzhenghao, String nianshenriqi,
			String erjiweihuriqi, String daoluyunshuzhengnianshenriqi,
			String yonghumiaoshu, String jingyingfanwei,
			String dengjipingdingriqi, String guantijianceriqi) {
		super();
		this.id = id;
		this.chepaihao = chepaihao;
		this.jiayayuan = jiayayuan;
		this.chexing = chexing;
		this.cheliangleixing = cheliangleixing;
		this.zhuceriqi = zhuceriqi;
		this.zhuangtai = zhuangtai;
		this.beizhu = beizhu;
		this.caozuoyuan = caozuoyuan;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.pingpaixinghao = pingpaixinghao;
		this.shibiedaihao = shibiedaihao;
		this.fadongjihao = fadongjihao;
		this.zongzhiliang = zongzhiliang;
		this.zhengbeizhiliang = zhengbeizhiliang;
		this.hedingzhaizhiliang = hedingzhaizhiliang;
		this.zhunqianyingzongzhiliang = zhunqianyingzongzhiliang;
		this.waikuochicun = waikuochicun;
		this.cheliangdaoluyunshuzhenghao = cheliangdaoluyunshuzhenghao;
		this.nianshenriqi = nianshenriqi;
		this.erjiweihuriqi = erjiweihuriqi;
		this.daoluyunshuzhengnianshenriqi = daoluyunshuzhengnianshenriqi;
		this.yonghumiaoshu = yonghumiaoshu;
		this.jingyingfanwei = jingyingfanwei;
		this.dengjipingdingriqi = dengjipingdingriqi;
		this.guantijianceriqi = guantijianceriqi;
	}

	public CheLiangJsonModel(String shenfenzhenghao, String zhengshubianhao,
			String cheshenyanse, String fadongjixinghao,
			String ranliaozhonglei, String pailiang, String gonglv,
			String changjiamingcheng, String lunju, String luntaishu,
			String luntaiguige, String gangbantanhuangpianshu, String zhouju,
			String zhoushu, String huoxiang, String cheliangfenzu) {
		super();
		this.shenfenzhenghao = shenfenzhenghao;
		this.zhengshubianhao = zhengshubianhao;
		this.cheshenyanse = cheshenyanse;
		this.fadongjixinghao = fadongjixinghao;
		this.ranliaozhonglei = ranliaozhonglei;
		this.pailiang = pailiang;
		this.gonglv = gonglv;
		this.changjiamingcheng = changjiamingcheng;
		this.lunju = lunju;
		this.luntaishu = luntaishu;
		this.luntaiguige = luntaiguige;
		this.gangbantanhuangpianshu = gangbantanhuangpianshu;
		this.zhouju = zhouju;
		this.zhoushu = zhoushu;
		this.huoxiang = huoxiang;
		this.cheliangfenzu = cheliangfenzu;
	}

	/**
	 * 属性
	 */
	private String id;
	private String chepaihao;
	private String jiayayuan;
	private String chexing;
	private String cheliangleixing;
	private String zhuceriqi;
	private String zhuangtai;
	private String beizhu;
	private String caozuoyuan;
	
	private String  chezhuxingming; //车主姓名
	private String  shoujihao ; //手机号
	private String  pingpaixinghao ; //品牌型号
	private String  shibiedaihao ;  //识别代号
	private String  fadongjihao ;  //发动机号
	private String  zongzhiliang ; //总质量  
	private String  zhengbeizhiliang ; //整备质量
	private String  hedingzhaizhiliang ; //核定载质量
	private String  zhunqianyingzongzhiliang ; //准牵引总质量
	private String  waikuochicun ; //外扩尺寸
	private String  cheliangdaoluyunshuzhenghao; //车辆道路运输证号
	private String    nianshenriqi ; //年审日期
	private String    erjiweihuriqi ; //二级维护日期
	private String    daoluyunshuzhengnianshenriqi; //道路运输证年审日期
	private String  yonghumiaoshu;   //用户描述
	private String  jingyingfanwei ;   //经营范围
	
	private String 	dengjipingdingriqi;	//等级评定日期
	private String 	guantijianceriqi;	//罐体检测日期
	
	private String shenfenzhenghao;	//身份证号
	private String zhengshubianhao;	//证书编号
	private String cheshenyanse;	//车身颜色
	private String fadongjixinghao;	//发动机型号
	private String ranliaozhonglei;	//燃料种类
	private String pailiang;	//排量
	private String gonglv;	//功率
	private String changjiamingcheng;	//厂家名称
	private String lunju;	//轮距前
	private String luntaishu;	//轮胎数
	private String luntaiguige;	//轮胎规格
	private String gangbantanhuangpianshu;	//钢板弹簧片数
	private String zhouju;	//轴距
	private String zhoushu;	//轴数
	private String huoxiang;	//货箱
	private String cheliangfenzu;	//车辆分组
	private String gouchefei;	//够车费
	
	
	/**
	 * 赋值方法
	 */
	public void setCheLiangJsonModel(String id, String chepaihao, String jiayayuan,
			String chexing, String cheliangleixing, String zhuceriqi,
			String zhuangtai, String beizhu, String caozuoyuan,
			String chezhuxingming, String shoujihao, String pingpaixinghao,
			String shibiedaihao, String fadongjihao, String zongzhiliang,
			String zhengbeizhiliang, String hedingzhaizhiliang,
			String zhunqianyingzongzhiliang, String waikuochicun,
			String cheliangdaoluyunshuzhenghao, String nianshenriqi,
			String erjiweihuriqi, String daoluyunshuzhengnianshenriqi,
			String yonghumiaoshu, String jingyingfanwei,
			String dengjipingdingriqi, String guantijianceriqi) {
		this.id = id;
		this.chepaihao = chepaihao;
		this.jiayayuan = jiayayuan;
		this.chexing = chexing;
		this.cheliangleixing = cheliangleixing;
		this.zhuceriqi = zhuceriqi;
		this.zhuangtai = zhuangtai;
		this.beizhu = beizhu;
		this.caozuoyuan = caozuoyuan;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.pingpaixinghao = pingpaixinghao;
		this.shibiedaihao = shibiedaihao;
		this.fadongjihao = fadongjihao;
		this.zongzhiliang = zongzhiliang;
		this.zhengbeizhiliang = zhengbeizhiliang;
		this.hedingzhaizhiliang = hedingzhaizhiliang;
		this.zhunqianyingzongzhiliang = zhunqianyingzongzhiliang;
		this.waikuochicun = waikuochicun;
		this.cheliangdaoluyunshuzhenghao = cheliangdaoluyunshuzhenghao;
		this.nianshenriqi = nianshenriqi;
		this.erjiweihuriqi = erjiweihuriqi;
		this.daoluyunshuzhengnianshenriqi = daoluyunshuzhengnianshenriqi;
		this.yonghumiaoshu = yonghumiaoshu;
		this.jingyingfanwei = jingyingfanwei;
		this.dengjipingdingriqi = dengjipingdingriqi;
		this.guantijianceriqi = guantijianceriqi;
	}

	public void setCheLiangJsonModelValue(String shenfenzhenghao, String zhengshubianhao,
			String cheshenyanse, String fadongjixinghao,
			String ranliaozhonglei, String pailiang, String gonglv,
			String changjiamingcheng, String lunju, String luntaishu,
			String luntaiguige, String gangbantanhuangpianshu, String zhouju,
			String zhoushu, String huoxiang, String cheliangfenzu) {
		this.shenfenzhenghao = shenfenzhenghao;
		this.zhengshubianhao = zhengshubianhao;
		this.cheshenyanse = cheshenyanse;
		this.fadongjixinghao = fadongjixinghao;
		this.ranliaozhonglei = ranliaozhonglei;
		this.pailiang = pailiang;
		this.gonglv = gonglv;
		this.changjiamingcheng = changjiamingcheng;
		this.lunju = lunju;
		this.luntaishu = luntaishu;
		this.luntaiguige = luntaiguige;
		this.gangbantanhuangpianshu = gangbantanhuangpianshu;
		this.zhouju = zhouju;
		this.zhoushu = zhoushu;
		this.huoxiang = huoxiang;
		this.cheliangfenzu = cheliangfenzu;
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
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getJiayayuan() {
		return jiayayuan;
	}
	public void setJiayayuan(String jiayayuan) {
		this.jiayayuan = jiayayuan;
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
	public String getZhuceriqi() {
		return zhuceriqi;
	}
	public void setZhuceriqi(String zhuceriqi) {
		this.zhuceriqi = zhuceriqi;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
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

	public String getNianshenriqi() {
		return nianshenriqi;
	}

	public void setNianshenriqi(String nianshenriqi) {
		this.nianshenriqi = nianshenriqi;
	}

	public String getErjiweihuriqi() {
		return erjiweihuriqi;
	}

	public void setErjiweihuriqi(String erjiweihuriqi) {
		this.erjiweihuriqi = erjiweihuriqi;
	}

	public String getDaoluyunshuzhengnianshenriqi() {
		return daoluyunshuzhengnianshenriqi;
	}

	public void setDaoluyunshuzhengnianshenriqi(String daoluyunshuzhengnianshenriqi) {
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

	public String getDengjipingdingriqi() {
		return dengjipingdingriqi;
	}

	public void setDengjipingdingriqi(String dengjipingdingriqi) {
		this.dengjipingdingriqi = dengjipingdingriqi;
	}

	public String getGuantijianceriqi() {
		return guantijianceriqi;
	}

	public void setGuantijianceriqi(String guantijianceriqi) {
		this.guantijianceriqi = guantijianceriqi;
	}

	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}

	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
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

	

	public String getLunju() {
		return lunju;
	}

	public void setLunju(String lunju) {
		this.lunju = lunju;
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

	

	public String getHuoxiang() {
		return huoxiang;
	}

	public void setHuoxiang(String huoxiang) {
		this.huoxiang = huoxiang;
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
