package com.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.entity.FeiYongShouQu;

/**
 * @author Administrator
 * 费用收取model
 */
public class FeiYongShouQuModel {
	/**
	 * 构造方法
	 */
	public FeiYongShouQuModel() {
		super();
	}

	public FeiYongShouQuModel(Integer id, String chelianghezuoren,
			String gouchefei, String luntaifei, String weixiufei,
			String jiayoufei, String qitafeiyong, String kaipiaoheji,
			String bili, String baoxianfei, String chezaihefuwufeiyong,
			String anquanxuexibaozhengjin, String guanlifeiyong,
			String yujiaobaoxianfeiyong, String jiashiyuanbaoxian, String heji) {
		super();
		this.id = id;
		this.chelianghezuoren = chelianghezuoren;
		this.gouchefei = gouchefei;
		this.luntaifei = luntaifei;
		this.weixiufei = weixiufei;
		this.jiayoufei = jiayoufei;
		this.qitafeiyong = qitafeiyong;
		this.kaipiaoheji = kaipiaoheji;
		this.bili = bili;
		this.baoxianfei = baoxianfei;
		this.chezaihefuwufeiyong = chezaihefuwufeiyong;
		this.anquanxuexibaozhengjin = anquanxuexibaozhengjin;
		this.guanlifeiyong = guanlifeiyong;
		this.yujiaobaoxianfeiyong = yujiaobaoxianfeiyong;
		this.jiashiyuanbaoxian = jiashiyuanbaoxian;
		this.heji = heji;
	}



	/**
	 *  property
	 */
	private Integer id ;
	private String chelianghezuoren;	//车辆合作人
	private String gouchefei;	//购车费
	private String luntaifei;	//轮胎费
	private String weixiufei;	//维修费
	private String jiayoufei;	//加油费
	private String qitafeiyong;	//其他费用
	private String kaipiaoheji;	//开票合计
	private String bili;	//比例
	private String baoxianfei;	//保险费
	private String chezaihefuwufeiyong;	//车载和服务费用
	private String anquanxuexibaozhengjin;	//安全学习保证金
	private String guanlifeiyong;	//管理费用
	private String yujiaobaoxianfeiyong;	//预交保险费用
	private String jiashiyuanbaoxian;	//驾驶员保险
	private String heji;	//合计
	
	/**
	 * 得到
	 */
	public static List<FeiYongShouQuModel> getFeiYongShouQuModelList(List<FeiYongShouQu> feiyongshouqulist){
		
		List<FeiYongShouQuModel> feiYongShouQuModelList = new ArrayList<FeiYongShouQuModel>();
		
		for (int i = 0; i < feiyongshouqulist.size(); i++) {
			
			 FeiYongShouQu feiyongshouqu = feiyongshouqulist.get(i);
			
			 Integer id = feiyongshouqu.getId();
			 String chelianghezuoren = feiyongshouqu.getChelianghezuoren();	//车辆合作人
			 String gouchefei = feiyongshouqu.getGouchefei();	//购车费
			 String luntaifei = feiyongshouqu.getLuntaifei();	//轮胎费
			 String weixiufei = feiyongshouqu.getWeixiufei();	//维修费
			 String jiayoufei = feiyongshouqu.getJiayoufei();	//加油费
			 String qitafeiyong = feiyongshouqu.getQitafeiyong();	//其他费用
			 
			 String kaipiaoheji  = "";	//开票合计
			 
			 Double zongkaipiaoheji = StringTfmDouble( feiyongshouqu.getKaipiaoheji() ) + StringTfmDouble( feiyongshouqu.getZiyouyewuheji() );
			 
			 kaipiaoheji = formatDoubleTwo(zongkaipiaoheji);
			 
			 String bili = feiyongshouqu.getBili();	//比例
			 String baoxianfei = feiyongshouqu.getBaoxianfei();	//保险费
			 String chezaihefuwufeiyong = feiyongshouqu.getChezaihefuwufeiyong();	//车载和服务费用
			 String anquanxuexibaozhengjin = feiyongshouqu.getAnquanxuexibaozhengjin();	//安全学习保证金
			 String guanlifeiyong = feiyongshouqu.getGuanlifeiyong();	//管理费用
			 String yujiaobaoxianfeiyong = feiyongshouqu.getYujiaobaoxianfeiyong();	//预交保险费用
			 String jiashiyuanbaoxian = feiyongshouqu.getJiashiyuanbaoxian();	//驾驶员保险
			 String heji = feiyongshouqu.getHeji();	//合计
			
			 FeiYongShouQuModel feiYongShouQuModel = new FeiYongShouQuModel();
			 feiYongShouQuModel.setValueFeiYongShouQuModel(  id,  chelianghezuoren,
															 gouchefei,  luntaifei,  weixiufei,
															 jiayoufei,  qitafeiyong,  kaipiaoheji,
															 bili,  baoxianfei,  chezaihefuwufeiyong,
															 anquanxuexibaozhengjin,  guanlifeiyong,
															 yujiaobaoxianfeiyong,  jiashiyuanbaoxian,  heji);
			 
			 feiYongShouQuModelList.add(feiYongShouQuModel);
		}
		
		
		return feiYongShouQuModelList;
	}
	
	
	public void setValueFeiYongShouQuModel(Integer id, String chelianghezuoren,
			String gouchefei, String luntaifei, String weixiufei,
			String jiayoufei, String qitafeiyong, String kaipiaoheji,
			String bili, String baoxianfei, String chezaihefuwufeiyong,
			String anquanxuexibaozhengjin, String guanlifeiyong,
			String yujiaobaoxianfeiyong, String jiashiyuanbaoxian, String heji) {
		this.id = id;
		this.chelianghezuoren = chelianghezuoren;
		this.gouchefei = gouchefei;
		this.luntaifei = luntaifei;
		this.weixiufei = weixiufei;
		this.jiayoufei = jiayoufei;
		this.qitafeiyong = qitafeiyong;
		this.kaipiaoheji = kaipiaoheji;
		this.bili = bili;
		this.baoxianfei = baoxianfei;
		this.chezaihefuwufeiyong = chezaihefuwufeiyong;
		this.anquanxuexibaozhengjin = anquanxuexibaozhengjin;
		this.guanlifeiyong = guanlifeiyong;
		this.yujiaobaoxianfeiyong = yujiaobaoxianfeiyong;
		this.jiashiyuanbaoxian = jiashiyuanbaoxian;
		this.heji = heji;
	}
	
	/**
	 *  String转换Double
	 */
	public static Double StringTfmDouble(String str){
		//初始化值
		Double value = 0.0;
		
		if(str == null){
			return value;
		}
		
		try {
			value = Double.valueOf(str);
		} catch (Exception e) {
		}
		
		return value;
	}
	
	/**
	 *  format Double Two
	 */
	public static String formatDoubleTwo(double value){
		String str = "";
		
		DecimalFormat  df  = new DecimalFormat("######0.00"); 
		try {
			str = df.format(value);
		} catch (Exception e) {
		}
		
		return str;
	}
	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChelianghezuoren() {
		return chelianghezuoren;
	}
	public void setChelianghezuoren(String chelianghezuoren) {
		this.chelianghezuoren = chelianghezuoren;
	}
	public String getGouchefei() {
		return gouchefei;
	}
	public void setGouchefei(String gouchefei) {
		this.gouchefei = gouchefei;
	}
	public String getLuntaifei() {
		return luntaifei;
	}
	public void setLuntaifei(String luntaifei) {
		this.luntaifei = luntaifei;
	}
	public String getWeixiufei() {
		return weixiufei;
	}
	public void setWeixiufei(String weixiufei) {
		this.weixiufei = weixiufei;
	}
	public String getJiayoufei() {
		return jiayoufei;
	}
	public void setJiayoufei(String jiayoufei) {
		this.jiayoufei = jiayoufei;
	}
	public String getQitafeiyong() {
		return qitafeiyong;
	}
	public void setQitafeiyong(String qitafeiyong) {
		this.qitafeiyong = qitafeiyong;
	}
	public String getKaipiaoheji() {
		return kaipiaoheji;
	}
	public void setKaipiaoheji(String kaipiaoheji) {
		this.kaipiaoheji = kaipiaoheji;
	}
	public String getBili() {
		return bili;
	}
	public void setBili(String bili) {
		this.bili = bili;
	}
	public String getBaoxianfei() {
		return baoxianfei;
	}
	public void setBaoxianfei(String baoxianfei) {
		this.baoxianfei = baoxianfei;
	}
	public String getChezaihefuwufeiyong() {
		return chezaihefuwufeiyong;
	}
	public void setChezaihefuwufeiyong(String chezaihefuwufeiyong) {
		this.chezaihefuwufeiyong = chezaihefuwufeiyong;
	}
	public String getAnquanxuexibaozhengjin() {
		return anquanxuexibaozhengjin;
	}
	public void setAnquanxuexibaozhengjin(String anquanxuexibaozhengjin) {
		this.anquanxuexibaozhengjin = anquanxuexibaozhengjin;
	}
	public String getGuanlifeiyong() {
		return guanlifeiyong;
	}
	public void setGuanlifeiyong(String guanlifeiyong) {
		this.guanlifeiyong = guanlifeiyong;
	}
	public String getYujiaobaoxianfeiyong() {
		return yujiaobaoxianfeiyong;
	}
	public void setYujiaobaoxianfeiyong(String yujiaobaoxianfeiyong) {
		this.yujiaobaoxianfeiyong = yujiaobaoxianfeiyong;
	}
	public String getJiashiyuanbaoxian() {
		return jiashiyuanbaoxian;
	}
	public void setJiashiyuanbaoxian(String jiashiyuanbaoxian) {
		this.jiashiyuanbaoxian = jiashiyuanbaoxian;
	}
	public String getHeji() {
		return heji;
	}
	public void setHeji(String heji) {
		this.heji = heji;
	}
	
	
}
