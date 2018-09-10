package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.JiaShiYuan;
import com.entity.YunDan;
import com.myutils.FontFormat;
import com.service.JiaShiYuanService;

/**
 *  运单审核模版类
 */
public class YunDanShenHeModel {
	/**
	 * 构造方法
	 */
	public YunDanShenHeModel() {
		super();
	}

	public YunDanShenHeModel(String id, String dingdanhao,
			String yundanzhuangtai, String jiashiyuan, String chepaihao,
			String kehudanwei, String qidian, String zhongdian,
			String yunshushijian, String huowumingcheng) {
		super();
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.yundanzhuangtai = yundanzhuangtai;
		this.jiashiyuan = jiashiyuan;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.yunshushijian = yunshushijian;
		this.huowumingcheng = huowumingcheng;
	}

	/**
	 * 属性
	 */
	private String id ;	//id
	private String dingdanhao;	//订单号
	private String yundanzhuangtai;	//运单状态
	private String jiashiyuan;	//驾驶员
	private String chepaihao;	//车牌号
	private String kehudanwei;	//客户单位
	private String qidian;	//起点	
	private String zhongdian;	//终点
	private String yunshushijian;	//运输时间
	private String huowumingcheng;	//货物名称
	
	
	/**
	 *  得到运单审核模版集合对象
	 */
	public static List<YunDanShenHeModel> getYunDanShenHeModelList(List<YunDan> yundanlist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");		
//		得到驾驶员业务对象
		JiaShiYuanService jsys = (JiaShiYuanService) ac.getBean("jiaShiYuanService");
		
		List<YunDanShenHeModel> yundanshenhemodellist = new ArrayList<YunDanShenHeModel>();
		
		for (int i = 0; i < yundanlist.size(); i++) {
			
			YunDan yundan = yundanlist.get(i);
			
			String id = String.valueOf(yundan.getId());
			
			String path =request.getContextPath()+"/"+"yunDanShenHeXiangXi?id="+id;
			String dingdanhao = "<a href=\""+path+"\">"+yundan.getDingdanhao()+"</a>";
			
			String yundanzhuangtai = yundan.getYundanzhuangtai();
			String jiashiyuan = "";	
			String chepaihao = yundan.getChepaihao();	
			String kehudanwei = yundan.getKehudanwei();	
			String qidian = yundan.getQidian();	
			String zhongdian = yundan.getZhongdian();	
			String yunshushijian = yundan.getYunshushijian().toString();	
			String huowumingcheng = yundan.getHuowumingcheng();	
			
			List<JiaShiYuan> jiashiyuanlist = jsys.queryJiaShiYuanChePaiHao(chepaihao);
			for (int j = 0; j < jiashiyuanlist.size(); j++) {
				JiaShiYuan jiashiyuanobj = jiashiyuanlist.get(j);
				jiashiyuan=jiashiyuan + jiashiyuanobj.getJiashiyuanxingming()+",";
			}
			
			YunDanShenHeModel yundanshenhemodel = new YunDanShenHeModel();
			yundanshenhemodel.setYunDanShenHeModel(id, dingdanhao, yundanzhuangtai, 
												jiashiyuan, chepaihao, kehudanwei, 
												qidian, zhongdian, yunshushijian, huowumingcheng);
			yundanshenhemodellist.add(yundanshenhemodel);
		}
		
		return yundanshenhemodellist;
	}
	
	/**
	 *  赋值方法
	 */
	public void setYunDanShenHeModel(String id, String dingdanhao,
			String yundanzhuangtai, String jiashiyuan, String chepaihao,
			String kehudanwei, String qidian, String zhongdian,
			String yunshushijian, String huowumingcheng) {
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.yundanzhuangtai = yundanzhuangtai;
		this.jiashiyuan = jiashiyuan;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.yunshushijian = yunshushijian;
		this.huowumingcheng = huowumingcheng;
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
	public String getYundanzhuangtai() {
		return yundanzhuangtai;
	}
	public void setYundanzhuangtai(String yundanzhuangtai) {
		this.yundanzhuangtai = yundanzhuangtai;
	}
	public String getJiashiyuan() {
		return jiashiyuan;
	}
	public void setJiashiyuan(String jiashiyuan) {
		this.jiashiyuan = jiashiyuan;
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
	public String getYunshushijian() {
		return yunshushijian;
	}
	public void setYunshushijian(String yunshushijian) {
		this.yunshushijian = yunshushijian;
	}
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	
}
