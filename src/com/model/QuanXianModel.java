package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Users;
import com.myutils.FontFormat;
import com.service.QuanXianService;
import com.service.UsersService;

/**
 *  权限 模版类
 */
public class QuanXianModel {
	/**
	 * 构造方法
	 */
	public QuanXianModel() {
		super();
	}

	public QuanXianModel(String id, String quanxianmingcheng, String yonghu) {
		super();
		this.id = id;
		this.quanxianmingcheng = quanxianmingcheng;
		this.yonghu = yonghu;
	}

	/**
	 * 属性
	 */
	private String id ;	//id
	private String quanxianmingcheng;	//权限名称
	private String yonghu;	//用户
	
	/**
	 *  赋值方法  
	 */
	public void setQuanXianModel(String id, String quanxianmingcheng, String yonghu) {
		this.id = id;
		this.quanxianmingcheng = quanxianmingcheng;
		this.yonghu = yonghu;
	}
	
	/**
	 *  得到权限模版集合对象
	 */
	public static List<QuanXianModel> getQuanXianModelList(List<String> quanxianlist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		得到用户对象
		UsersService us = (UsersService) ac.getBean("usersService");
		
		List<QuanXianModel> quanxianmodellist = new ArrayList<QuanXianModel>();
		
		for (int i = 0; i < quanxianlist.size(); i++) {
			String id = String.valueOf(i+1);
			String quanxianmingcheng = quanxianlist.get(i);
			String yonghu = "";
			List<Users> userslist = us.queryUsersQuanXianMingCheng(quanxianmingcheng);
			for (int j = 0; j < userslist.size(); j++) {
				Users users = userslist.get(j);
				yonghu = yonghu + users.getUsername()+",";
			}
			
			QuanXianModel quanxianmodel = new QuanXianModel();
			quanxianmodel.setQuanXianModel(id, quanxianmingcheng, yonghu);
			quanxianmodellist.add(quanxianmodel);
		}
		
		return quanxianmodellist;
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

	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}

	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}

	public String getYonghu() {
		return yonghu;
	}

	public void setYonghu(String yonghu) {
		this.yonghu = yonghu;
	}
	
}
