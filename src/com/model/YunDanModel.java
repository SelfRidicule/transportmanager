package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.entity.YunDan;

/**
 *  运单模版类TODO
 */
public class YunDanModel {
	/**
	 * 构造方法
	 */
	public YunDanModel() {
		super();
	}
	
	/**
	 * 属性
	 */
	private String id ;	//id
	private String dingdanhao;	//订单号
	private String yundanzhuangtai;	//运单状态
	private String chepaihao;	//车牌号
	private String kehudanwei;	//客户单位
	private String qidian;	//起点	
	private String zhongdian;	//终点
	private String yunshushijian;	//运输时间
	private String huowumingcheng;	//货物名称
	
	/**
	 *  得到运单模版集合对象TODO
	 */
	public static List<YunDanModel> getYunDanModel(List<YunDan> yundanlist , HttpServletRequest request){
//		创建运单模版集合对象
		List<YunDanModel> yundanmodellist = new ArrayList<YunDanModel>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < yundanlist.size(); i++) {
			
			try {
			
				YunDan yundan = yundanlist.get(i);
				
				String id = String.valueOf(yundan.getId());
				
				String path =request.getContextPath()+"/"+"yunDanXiangXi?id="+id;
				String dingdanhao ="<a href=\""+path+"\">"+yundan.getDingdanhao()+"</a>";
				
				String yundanzhuangtai = yundan.getYundanzhuangtai();	
				String chepaihao = yundan.getChepaihao();
				String kehudanwei = yundan.getKehudanwei();
				String qidian = yundan.getQidian();		
				String zhongdian = yundan.getZhongdian();	
				
				Date yunshushijian = yundan.getYunshushijian();
				String yunshushijianStr = "";
				if(yunshushijian != null){
					yunshushijianStr = sdf.format(yunshushijian);
				}
				
				
				String huowumingcheng = yundan.getHuowumingcheng();	
				
				YunDanModel yundanmodel = new YunDanModel();
				yundanmodel.setYunDanModel(id, dingdanhao, yundanzhuangtai, 
											chepaihao, kehudanwei, qidian, 
											zhongdian, yunshushijianStr, huowumingcheng);
				yundanmodellist.add(yundanmodel);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return yundanmodellist;
	}
	
	/**
	 *  赋值方法
	 */
	public void setYunDanModel(String id, String dingdanhao, String yundanzhuangtai,
			String chepaihao, String kehudanwei, String qidian,
			String zhongdian, String yunshushijian, String huowumingcheng) {
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.yundanzhuangtai = yundanzhuangtai;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.yunshushijian = yunshushijian.toString();
		this.huowumingcheng = huowumingcheng;
	}
	
	
	/**
	 *  get set
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}
	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}
	public String getYundanzhuangtai() {
		return yundanzhuangtai;
	}
	public void setYundanzhuangtai(String yundanzhuangtai) {
		this.yundanzhuangtai = yundanzhuangtai;
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
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYunshushijian() {
		return yunshushijian;
	}
	public void setYunshushijian(String yunshushijian) {
		this.yunshushijian = yunshushijian;
	}
	
}
