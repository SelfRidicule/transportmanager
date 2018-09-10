package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.KaiPiao;

/**
 *  开票 模版类
 */
public class KaiPiaoModel {
	/**
	 * 构造方法
	 */
	public KaiPiaoModel() {
		super();
	}
	
	public KaiPiaoModel(String id, String kehudanwei, String chengyunren,
			String huowumingcheng, String lingkuanshijian, String xiangxi) {
		super();
		this.id = id;
		this.kehudanwei = kehudanwei;
		this.chengyunren = chengyunren;
		this.huowumingcheng = huowumingcheng;
		this.lingkuanshijian = lingkuanshijian;
		this.xiangxi = xiangxi;
	}

	/**
	 * 属性
	 */
	private String id;	//id
	private String kehudanwei;	//客户单位
	private String chengyunren;	//承运人
	private String huowumingcheng;	//货物名称
	private String lingkuanshijian;	//领款时间
	private String xiangxi;	//详细
	private String kaipiaoshijian ;	//开票时间
	
	/**
	 *  得到开票模版集合对象
	 */
	public static List<KaiPiaoModel> getKaiPiaoModelList(List<KaiPiao> kaipiaolist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		List<KaiPiaoModel> kaipiaomodellist = new ArrayList<KaiPiaoModel>();
		
		for (int i = 0; i < kaipiaolist.size(); i++) {
			KaiPiao kaipiao = kaipiaolist.get(i);
			
			String id = String.valueOf(kaipiao.getId()) ;
			
			String kehudanwei = kaipiao.getKehudanwei();
			String path =request.getContextPath()+"/"+"jumpKaiPiaoXiangXi?id="+id;
			kehudanwei =  "<a href=\""+path+"\">"+kehudanwei+"</a>";
			
			String chengyunren = kaipiao.getChengyunren();
			String huowumingcheng = kaipiao.getHuowumingcheng();
			
			String lingkuanshijian = "";
			Date date = kaipiao.getLingkuanshijian();
			if(date != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				lingkuanshijian = sdf.format(date);
			}
			
			String kaipiaoshijian = "";
			if(kaipiao.getKaipiaoshijian() != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				kaipiaoshijian = sdf.format(kaipiao.getKaipiaoshijian());
			}
			
			
			String xiangxi = "详细";
			
			KaiPiaoModel kaipiaomodel = new KaiPiaoModel();
			kaipiaomodel.setKaiPiaoModel( id,  kehudanwei,  chengyunren,
			 huowumingcheng,  lingkuanshijian,  xiangxi);
			kaipiaomodel.setKaipiaoshijian(kaipiaoshijian);
			
			kaipiaomodellist.add(kaipiaomodel);
		}
		
		return kaipiaomodellist;
	}
	
	/**
	 *  赋值方法
	 */
	public void setKaiPiaoModel(String id, String kehudanwei, String chengyunren,
			String huowumingcheng, String lingkuanshijian, String xiangxi) {
		this.id = id;
		this.kehudanwei = kehudanwei;
		this.chengyunren = chengyunren;
		this.huowumingcheng = huowumingcheng;
		this.lingkuanshijian = lingkuanshijian;
		this.xiangxi = xiangxi;
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

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}

	public String getChengyunren() {
		return chengyunren;
	}

	public void setChengyunren(String chengyunren) {
		this.chengyunren = chengyunren;
	}

	public String getHuowumingcheng() {
		return huowumingcheng;
	}

	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}

	public String getLingkuanshijian() {
		return lingkuanshijian;
	}

	public void setLingkuanshijian(String lingkuanshijian) {
		this.lingkuanshijian = lingkuanshijian;
	}

	public String getXiangxi() {
		return xiangxi;
	}

	public void setXiangxi(String xiangxi) {
		this.xiangxi = xiangxi;
	}

	public String getKaipiaoshijian() {
		return kaipiaoshijian;
	}

	public void setKaipiaoshijian(String kaipiaoshijian) {
		this.kaipiaoshijian = kaipiaoshijian;
	}
	
	
}
