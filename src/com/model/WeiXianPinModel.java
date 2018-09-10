package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.WeiXianPin;

/**
 *  危险品 模版类
 */
public class WeiXianPinModel {
	/**
	 * 构造方法
	 */
	public WeiXianPinModel() {
		super();
	}
	
	public WeiXianPinModel(Integer id, String huowumingcheng, String anquanka,
			String caozuo) {
		super();
		this.id = id;
		this.huowumingcheng = huowumingcheng;
		this.anquanka = anquanka;
		this.caozuo = caozuo;
	}

	/**
	 * 属性
	 */
	private Integer id ;
	private String huowumingcheng;
	private String anquanka;
	private String caozuo;
	
	
	public void setWeiXianPinModel(Integer id, String huowumingcheng, String anquanka,
			String caozuo) {
		this.id = id;
		this.huowumingcheng = huowumingcheng;
		this.anquanka = anquanka;
		this.caozuo = caozuo;
	}
	
	/**
	 *  得到危险品模版类集合
	 */
	public static List<WeiXianPinModel> getWeiXianPinModelList(List<WeiXianPin> weixianpinlist){
		List<WeiXianPinModel> weixianpinmodellist = new ArrayList<WeiXianPinModel>();
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		
		for (int i = 0; i < weixianpinlist.size(); i++) {
			
			WeiXianPin weixianpin = weixianpinlist.get(i);
			
			Integer id = weixianpin.getId();
			
			String huowumingcheng = weixianpin.getHuowumingcheng();
			String huowumingchengPath = request.getContextPath()+"/"+"weiXianPinXiangXi?id="+id;
			huowumingcheng= "<a href=\""+huowumingchengPath+"\">"+huowumingcheng+"</a>";
			
			String anquanka = weixianpin.getAnquankamingcheng();
			
			String caozuo =request.getContextPath()+"/"+"jumpUpdateWeiXianPin?id="+id;
			caozuo =  "<a href=\""+caozuo+"\">修改</a>";
			
			WeiXianPinModel weixianpinmodel = new WeiXianPinModel();
			weixianpinmodel.setWeiXianPinModel(id, huowumingcheng, anquanka, caozuo);
			
			weixianpinmodellist.add(weixianpinmodel);
		}
		
		return weixianpinmodellist;
	}
	
	
	/**
	 *   get set
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	public String getAnquanka() {
		return anquanka;
	}
	public void setAnquanka(String anquanka) {
		this.anquanka = anquanka;
	}
	public String getCaozuo() {
		return caozuo;
	}
	public void setCaozuo(String caozuo) {
		this.caozuo = caozuo;
	}
	
}
