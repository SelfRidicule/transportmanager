package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.Customer;
import com.entity.QuanXian;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.service.CustomerService;
import com.service.YingShouKuanService;

/**
 *  运单-工作门户
 */
public class MenHuYunDan {
	/**
	 * 构造方法
	 */
	public MenHuYunDan() {
		super();
	}

	public MenHuYunDan(String dingdanhao, String yundanzhuangtai,
			String lianxiren) {
		super();
		this.dingdanhao = dingdanhao;
		this.yundanzhuangtai = yundanzhuangtai;
		this.lianxiren = lianxiren;
	}

	/**
	 * 属性
	 */
	private String dingdanhao;	
	private String yundanzhuangtai;
	private String lianxiren ;
	private String kaipiaozhuangtai;	//开票状态
	private String jiesuanzhuangtai;	//结算状态
	private String kehudanweijiancheng;	//客户单位简称
	
	/**
	 *  赋值方法  
	 */
	public void setMenHuYunDan(String dingdanhao, String yundanzhuangtai,
			String lianxiren) {
		this.dingdanhao = dingdanhao;
		this.yundanzhuangtai = yundanzhuangtai;
		this.lianxiren = lianxiren;
	}
	
	/**
	 *  得到 运单-工作门户 集合对象
	 */
	public static List<MenHuYunDan> getMenHuYunDanList( List<YunDan> yundanmenhulist ,CustomerService customerService,YingShouKuanService yingShouKuanService){
		List<MenHuYunDan> menhuyundanlist = new ArrayList<MenHuYunDan>();
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		加载applicationContext.xml文件
		 
//		得到 CustomerService 对象
				
//		营收款 业务对象
		
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("运单管理".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getChakan()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		if(!flag){
			return null;
		}
		
		for (int i = 0; i < yundanmenhulist.size(); i++) {
			
			YunDan yundan = yundanmenhulist.get(i);
			
			String dingdanhao = yundan.getDingdanhao();
			
			String path =request.getContextPath()+"/jumpYunDan";
			
			
			String yundanzhuangtai = "";
			if(yundan.getYundanzhuangtai() != null){
				yundanzhuangtai = yundan.getYundanzhuangtai();
			}
			
			String lianxiren = "";
			if(yundan.getLianxiren() != null){
				lianxiren = yundan.getLianxiren();
			}
			
			String kehudanwei = yundan.getKehudanwei();
			
			String kehudanweijiancheng = "";
			
			Customer customer = customerService.queryCustomerKeHuDanWei(kehudanwei);
			if(customer != null){
				kehudanweijiancheng = customer.getShortname();
			}
			
			String kaipiaozhuangtai = "";	//开票状态
			String jiesuanzhuangtai = "";	//结算状态
			
			YingShouKuan yingShouKuan =  yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
			if(yingShouKuan != null){
				kaipiaozhuangtai = yingShouKuan.getYingshoukuanzhuangtai();	//开票状态
				jiesuanzhuangtai = yingShouKuan.getJiesuanzhuangtai();	//结算状态
			}
			
			dingdanhao =  "<a href=\""+path+"\">"+ dingdanhao +"</a>";
			
			if("已开票".equals(kaipiaozhuangtai) && "已结算".equals(jiesuanzhuangtai)){
				continue;
			}
			
			MenHuYunDan menhuyundan = new MenHuYunDan();
			menhuyundan.setMenHuYunDan(dingdanhao, yundanzhuangtai, lianxiren);
			menhuyundan.setKehudanweijiancheng(kehudanweijiancheng);
			menhuyundan.setKaipiaozhuangtai(kaipiaozhuangtai);
			menhuyundan.setJiesuanzhuangtai(jiesuanzhuangtai);
			
			menhuyundanlist.add(menhuyundan);
			
		}
		
		if(menhuyundanlist.size()>5){
			for (int i = 5; i < menhuyundanlist.size(); i++) {
				menhuyundanlist.remove(i);
				--i;
			}
		}
		
		return menhuyundanlist;
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
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getKaipiaozhuangtai() {
		return kaipiaozhuangtai;
	}

	public void setKaipiaozhuangtai(String kaipiaozhuangtai) {
		this.kaipiaozhuangtai = kaipiaozhuangtai;
	}

	public String getJiesuanzhuangtai() {
		return jiesuanzhuangtai;
	}

	public void setJiesuanzhuangtai(String jiesuanzhuangtai) {
		this.jiesuanzhuangtai = jiesuanzhuangtai;
	}

	public String getKehudanweijiancheng() {
		return kehudanweijiancheng;
	}

	public void setKehudanweijiancheng(String kehudanweijiancheng) {
		this.kehudanweijiancheng = kehudanweijiancheng;
	}
	
}
