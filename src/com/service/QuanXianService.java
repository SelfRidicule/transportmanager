package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.QuanXianDao;
import com.entity.BaoXianChuDan;
import com.entity.QuanXian;

/**
 *  权限 业务层
 */
public class QuanXianService {
	/**
	 * 构造方法
	 */
	public QuanXianService() {
		super();
	}

	/**
	 * 属性
	 */
	private QuanXianDao quanXianDao;	//权限dao对象

	/**
	 *  查询所有权限
	 */
	public List<QuanXian> queryQuanXianList(){
		return quanXianDao.queryQuanXianList();
	}
	 
	/**
	 *  查询所有权限名称
	 */
	public List<String> queryQuanXianMingCheng(){
		return quanXianDao.queryQuanXianMingCheng();
	}
	
	/**
	 *  查询指定权限名称的权限集合对象
	 */
	public List<QuanXian> queryQuanXianMingChengList(String quanxianmingcheng){
		return quanXianDao.queryQuanXianMingChengList(quanxianmingcheng);
	}
	
	/**
	 *  查询指定id的权限
	 */
	public QuanXian queryQuanXianId(Integer id){
		return quanXianDao.findById(id);
	}
	
	/**
	 *  查询指定权限名称 和 权限部门的对象
	 */
	public QuanXian queryQuanXianMingChengInBuMen(String quanxianmingcheng,String quanxianbumen){
		return quanXianDao.queryQuanXianMingChengInBuMen(quanxianmingcheng, quanxianbumen);
	}
	
	/**
	 *  模糊查询
	 */
	public List<String> vagueSearchQuanXian(String quanxianmingcheng){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer(" select q.quanxianmingcheng from QuanXian q where quanxianmingcheng like :quanxianmingcheng group by q.quanxianmingcheng ");
//		创建query对象
		Query query = quanXianDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setString("quanxianmingcheng", "%"+quanxianmingcheng+"%");
		return query.list();
	}
	
	/**
	 *  添加权限
	 */
	public void addQuanXian(QuanXian quanxian){
		quanXianDao.save(quanxian);
	}
	
	/**
	 *  删除权限
	 */
	public void deleteQuanXian(Integer id){
		QuanXian quanxian = new QuanXian();
		quanxian.setId(id);
		quanXianDao.delete(quanxian);
	}
	
	/**
	 *  删除指定权限名称的权限对象
	 */
	public void deleteQuanXianMingCheng(String quanxianmingcheng){
		quanXianDao.deleteQuanXianMingCheng(quanxianmingcheng);
	}
	
	/**
	 *  修改权限
	 */
	public void updateQuanXian(QuanXian quanxian){
		quanXianDao.update(quanxian);
	}
	
	/**
	 * 保存或添加
	 */
	public void saveAndUpdateQuanXian( QuanXian quanxian ){
		quanXianDao.saveAndUpdate(quanxian);
	}
	
	
	/**
	 *  get set
	 */
	public QuanXianDao getQuanXianDao() {
		return quanXianDao;
	}

	public void setQuanXianDao(QuanXianDao quanXianDao) {
		this.quanXianDao = quanXianDao;
	}
	
}
