package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.entity.JiaShiYuan;
import com.entity.Users;
import com.service.UsersService;

/**
 *  驾驶员审核模版类
 */
public class JiaShiYuanShenHeModel {
	/**
	 * 构造方法
	 */
	public JiaShiYuanShenHeModel() {
		super();
	}

	public JiaShiYuanShenHeModel(String id, String jiashiyuanxingming,
			String jiashicheliang, String shenhezhuangtai,
			String shenfenzhenghao, String zhunjiachexing, String caozuoyuan) {
		super();
		this.id = id;
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.jiashicheliang = jiashicheliang;
		this.shenhezhuangtai = shenhezhuangtai;
		this.shenfenzhenghao = shenfenzhenghao;
		this.zhunjiachexing = zhunjiachexing;
		this.caozuoyuan = caozuoyuan;
	}

	/**
	 * 属性
	 */
	private String id;	//id
	private String jiashiyuanxingming;	//驾驶员姓名
	private String jiashicheliang;	//驾驶车辆
	private String shenhezhuangtai;	//审核状态
	private String shenfenzhenghao;	//身份证号
	private String zhunjiachexing;	//准驾车型
	private String caozuoyuan;	//操作员
	
	/**
	 *  赋值方法
	 */
	public void setJiaShiYuanShenHeModel(String id, String jiashiyuanxingming,
			String jiashicheliang, String shenhezhuangtai,
			String shenfenzhenghao, String zhunjiachexing, String caozuoyuan) {
		this.id = id;
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.jiashicheliang = jiashicheliang;
		this.shenhezhuangtai = shenhezhuangtai;
		this.shenfenzhenghao = shenfenzhenghao;
		this.zhunjiachexing = zhunjiachexing;
		this.caozuoyuan = caozuoyuan;
	}
	
	/**
	 *  放入驾驶员集合得到驾驶员审核模版集合
	 */
	public static List<JiaShiYuanShenHeModel> getJiaShiYuanShenHeModelList(List<JiaShiYuan> jiashiyuanshenhelist, HttpServletRequest request ,UsersService usersService){
//		创建驾驶员审核模版集合对象
		List<JiaShiYuanShenHeModel> jiashiyuanshenhemodellist = new ArrayList<JiaShiYuanShenHeModel>();
		
//		加载applicationContext.xml文件
			
//		创建用户业务对象
		
		
		for (int i = 0; i < jiashiyuanshenhelist.size(); i++) {
			JiaShiYuan jiashiyuan = jiashiyuanshenhelist.get(i);
			
			String id = String.valueOf(jiashiyuan.getId());
			
			String path =request.getContextPath()+"/"+"jiaShiYuanShenHeXiangXi?id="+id;
			String jiashiyuanxingming = "<a href=\""+path+"\">"+jiashiyuan.getJiashiyuanxingming()+"</a>";
			
			String jiashicheliang = jiashiyuan.getJiashicheliang();
			String shenhezhuangtai = jiashiyuan.getShenhezhuangtai();
			String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();
			String zhunjiachexing = jiashiyuan.getZhunjiachexing();
			String caozuoyuan = "";
			
			try {
				Users users = usersService.queryId( Integer.valueOf(jiashiyuan.getCaozuoyuan()) );
				caozuoyuan = users.getUsername();
			} catch (Exception e) {
			}
			
//			创建驾驶员审核模版对象
			JiaShiYuanShenHeModel jiashiyuanshenhemodel = new JiaShiYuanShenHeModel();
			jiashiyuanshenhemodel.setJiaShiYuanShenHeModel(id, jiashiyuanxingming, jiashicheliang,
															shenhezhuangtai, shenfenzhenghao, zhunjiachexing,
															caozuoyuan);
			jiashiyuanshenhemodellist.add(jiashiyuanshenhemodel);
		}
		
		return jiashiyuanshenhemodellist;
	}
	
	public static List<JiaShiYuanShenHeModel> getJiaShiYuanShenHeModelListExcel(List<JiaShiYuan> jiashiyuanshenhelist, HttpServletRequest request){
//		创建驾驶员审核模版集合对象
		List<JiaShiYuanShenHeModel> jiashiyuanshenhemodellist = new ArrayList<JiaShiYuanShenHeModel>();
		
		for (int i = 0; i < jiashiyuanshenhelist.size(); i++) {
			JiaShiYuan jiashiyuan = jiashiyuanshenhelist.get(i);
			
			String id = String.valueOf(jiashiyuan.getId());
			
			String jiashiyuanxingming = jiashiyuan.getJiashiyuanxingming();
			
			String jiashicheliang = jiashiyuan.getJiashicheliang();
			String shenhezhuangtai = jiashiyuan.getShenhezhuangtai();
			String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();
			String zhunjiachexing = jiashiyuan.getZhunjiachexing();
			String caozuoyuan = jiashiyuan.getCaozuoyuan();
			
//			创建驾驶员审核模版对象
			JiaShiYuanShenHeModel jiashiyuanshenhemodel = new JiaShiYuanShenHeModel();
			jiashiyuanshenhemodel.setJiaShiYuanShenHeModel(id, jiashiyuanxingming, jiashicheliang,
															shenhezhuangtai, shenfenzhenghao, zhunjiachexing,
															caozuoyuan);
			jiashiyuanshenhemodellist.add(jiashiyuanshenhemodel);
		}
		
		return jiashiyuanshenhemodellist;
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
	public String getShenhezhuangtai() {
		return shenhezhuangtai;
	}
	public void setShenhezhuangtai(String shenhezhuangtai) {
		this.shenhezhuangtai = shenhezhuangtai;
	}
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}
	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
	public String getZhunjiachexing() {
		return zhunjiachexing;
	}
	public void setZhunjiachexing(String zhunjiachexing) {
		this.zhunjiachexing = zhunjiachexing;
	}
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}

}
