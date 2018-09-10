package com.model;

import java.util.ArrayList;
import java.util.List;

import com.entity.WeiXianPin;
import com.entity.YunDan;
import com.myutils.FileManager;
import com.service.WeiXianPinService;

/**
 *  运单移动端模版类
 */
public class YunDanModelAndroid {
	/**
	 * 构造方法
	 */
	public YunDanModelAndroid() {
		super();
	}
	
	public YunDanModelAndroid(String id, String dingdanhao, String chepaihao,
			String kehudanwei, String qidian, String zhongdian, String dizhi,
			String lianxiren, String baochouleixing, String baochoujine,
			String huowumingcheng, String yujidunwei, String anquanka,
			String yunshushijian, String caozuoyuan, String caozuoriqi,
			String yundanzhuangtai, String beizhu) {
		super();
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.dizhi = dizhi;
		this.lianxiren = lianxiren;
		this.baochouleixing = baochouleixing;
		this.baochoujine = baochoujine;
		this.huowumingcheng = huowumingcheng;
		this.yujidunwei = yujidunwei;
		this.anquanka = anquanka;
		this.yunshushijian = yunshushijian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yundanzhuangtai = yundanzhuangtai;
		this.beizhu = beizhu;
	}

	/**
	 * 属性
	 */
	private String id;	//id
	private String dingdanhao;	//订单号
	private String chepaihao;	//车牌号
	private String kehudanwei;	//客户单位
	private String qidian;	//起点	
	private String zhongdian;	//终点
	private String dizhi;	//地址
	private String lianxiren;	//联系人
	private String baochouleixing;	//报酬类型
	private String baochoujine;	//报酬金额
	private String huowumingcheng;	//货物名称
	private String yujidunwei;	//预计吨位
	private String anquanka;	//安全卡
	private String yunshushijian;	//运输时间
	private String caozuoyuan;	//操作员
	private String caozuoriqi;	//操作日期
	private String yundanzhuangtai;	//运单状态
	private String beizhu;	//备注
	private String dianhua;	//电话
	private String anquankapath;	//安全卡path
	
	/**
	 *  得到运单模版实体类 移动端
	 */
	public static YunDanModelAndroid  getYunDanModelAndroid(YunDan yundan , WeiXianPinService weiXianPinService){
//		加载applicationContext.xml文件
		
		
		
		
		
		 String id = String.valueOf(yundan.getId());	
		 String dingdanhao = yundan.getDingdanhao();	
		 String chepaihao = yundan.getChepaihao();	
		 String kehudanwei = yundan.getKehudanwei();	
		 String qidian = yundan.getQidian();
		 String zhongdian = yundan.getZhongdian();
		 String dizhi = yundan.getDizhi();	
		 String lianxiren = yundan.getLianxiren();	
		 String baochouleixing = yundan.getBaochouleixing();	
		 String baochoujine = yundan.getBaochoujine();	
		 String huowumingcheng = yundan.getHuowumingcheng();	
		 String yujidunwei = yundan.getYujidunwei();
		 String anquanka = yundan.getAnquanka();	
		 String yunshushijian = yundan.getYunshushijian().toString();	
		 String caozuoyuan = yundan.getCaozuoyuan();	
		 String caozuoriqi = yundan.getCaozuoriqi().toString();	
		 String yundanzhuangtai = yundan.getYundanzhuangtai();	
		 String beizhu = yundan.getBeizhu();	
		 String dianhua = yundan.getDianhua();
		 
		 
		 YunDanModelAndroid yunDanModelAndroid = new YunDanModelAndroid();
		 
		 yunDanModelAndroid.setYunDanModelAndroid(id, dingdanhao, chepaihao, kehudanwei,
				 									qidian, zhongdian, dizhi, lianxiren, 
				 									baochouleixing, baochoujine, huowumingcheng,
				 									yujidunwei, anquanka, yunshushijian, caozuoyuan,
				 									caozuoriqi, yundanzhuangtai, beizhu,dianhua);
		 
		 WeiXianPin singleweixianpin = weiXianPinService.queryWeiXianPinInAnQuanKaMingCheng(anquanka);
			
		 if(singleweixianpin != null){
			String anquankapath = singleweixianpin.getAnquanka();
			anquankapath = FileManager.formatFilePath(anquankapath);
			
			yunDanModelAndroid.setAnquankapath(anquankapath);
		 }
		 
		 return yunDanModelAndroid;
	}
	
	/**
	 *  得到运单模版实体类集合 移动端
	 */
	public static List<YunDanModelAndroid>  getYunDanModelListAndroid(List<YunDan> yundanlist){
		List<YunDanModelAndroid> yunDanModelAndroidList = new ArrayList<YunDanModelAndroid>();
		
		for (int i = 0; i < yundanlist.size(); i++) {
			 YunDan yundan = yundanlist.get(i);
			 String id = String.valueOf(yundan.getId());	
			 String dingdanhao = yundan.getDingdanhao();	
			 String chepaihao = yundan.getChepaihao();	
			 String kehudanwei = yundan.getKehudanwei();	
			 String qidian = yundan.getQidian();
			 String zhongdian = yundan.getZhongdian();
			 String dizhi = yundan.getDizhi();	
			 String lianxiren = yundan.getLianxiren();	
			 String baochouleixing = yundan.getBaochouleixing();	
			 String baochoujine = yundan.getBaochoujine();	
			 String huowumingcheng = yundan.getHuowumingcheng();	
			 String yujidunwei = yundan.getYujidunwei();
			 String anquanka = yundan.getAnquanka();	
			 String yunshushijian = yundan.getYunshushijian().toString();	
			 String caozuoyuan = yundan.getCaozuoyuan();	
			 String caozuoriqi = yundan.getCaozuoriqi().toString();	
			 String yundanzhuangtai = yundan.getYundanzhuangtai();	
			 String beizhu = yundan.getBeizhu();	
			 String dianhua = yundan.getDianhua();
			
			 YunDanModelAndroid yunDanModelAndroid = new YunDanModelAndroid();
			 
			 yunDanModelAndroid.setYunDanModelAndroid(id, dingdanhao, chepaihao, kehudanwei,
					 									qidian, zhongdian, dizhi, lianxiren, 
					 									baochouleixing, baochoujine, huowumingcheng,
					 									yujidunwei, anquanka, yunshushijian, caozuoyuan,
					 									caozuoriqi, yundanzhuangtai, beizhu,dianhua);
			 yunDanModelAndroidList.add(yunDanModelAndroid);
		}
		
		 return yunDanModelAndroidList;
	}
	
	/**
	 *  赋值方法
	 */
	public void setYunDanModelAndroid(String id, String dingdanhao, String chepaihao,
			String kehudanwei, String qidian, String zhongdian, String dizhi,
			String lianxiren, String baochouleixing, String baochoujine,
			String huowumingcheng, String yujidunwei, String anquanka,
			String yunshushijian, String caozuoyuan, String caozuoriqi,
			String yundanzhuangtai, String beizhu,String dianhua) {
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.dizhi = dizhi;
		this.lianxiren = lianxiren;
		this.baochouleixing = baochouleixing;
		this.baochoujine = baochoujine;
		this.huowumingcheng = huowumingcheng;
		this.yujidunwei = yujidunwei;
		this.anquanka = anquanka;
		this.yunshushijian = yunshushijian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yundanzhuangtai = yundanzhuangtai;
		this.beizhu = beizhu;
		this.dianhua=dianhua;
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
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getBaochouleixing() {
		return baochouleixing;
	}
	public void setBaochouleixing(String baochouleixing) {
		this.baochouleixing = baochouleixing;
	}
	public String getBaochoujine() {
		return baochoujine;
	}
	public void setBaochoujine(String baochoujine) {
		this.baochoujine = baochoujine;
	}
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	public String getYujidunwei() {
		return yujidunwei;
	}
	public void setYujidunwei(String yujidunwei) {
		this.yujidunwei = yujidunwei;
	}
	public String getAnquanka() {
		return anquanka;
	}
	public void setAnquanka(String anquanka) {
		this.anquanka = anquanka;
	}
	public String getYunshushijian() {
		return yunshushijian;
	}
	public void setYunshushijian(String yunshushijian) {
		this.yunshushijian = yunshushijian;
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
	public String getYundanzhuangtai() {
		return yundanzhuangtai;
	}
	public void setYundanzhuangtai(String yundanzhuangtai) {
		this.yundanzhuangtai = yundanzhuangtai;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getAnquankapath() {
		return anquankapath;
	}

	public void setAnquankapath(String anquankapath) {
		this.anquankapath = anquankapath;
	}
	
	
}
