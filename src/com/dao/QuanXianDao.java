package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.QuanXian;

/**
 *  权限dao层
 */
public class QuanXianDao extends Dao<QuanXian>{
	/**
	 * 构造方法
	 */
	public QuanXianDao() {
		super();
	}

	/**
	 *  查询所有权限
	 */
	public List<QuanXian> queryQuanXianList(){
		StringBuffer sf = new StringBuffer(" from QuanXian ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	 
	/**
	 *  查询所有权限名称
	 */
	public List<String> queryQuanXianMingCheng(){
		StringBuffer sf = new StringBuffer(" select q.quanxianmingcheng  from QuanXian q group by q.quanxianmingcheng  ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定权限名称的权限集合对象
	 */
	public List<QuanXian> queryQuanXianMingChengList(String quanxianmingcheng){
		StringBuffer sf = new StringBuffer(" from QuanXian where quanxianmingcheng = :quanxianmingcheng ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("quanxianmingcheng", quanxianmingcheng);
		return query.list();
	}
	
	/**
	 *  删除指定权限名称的权限对象
	 */
	public void deleteQuanXianMingCheng(String quanxianmingcheng){
		StringBuffer sf = new StringBuffer(" delete from QuanXian where quanxianmingcheng = :quanxianmingcheng ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("quanxianmingcheng", quanxianmingcheng);
		query.executeUpdate();
	}
	
	/**
	 *  查询指定权限名称 和 权限部门的对象
	 */
	public QuanXian queryQuanXianMingChengInBuMen(String quanxianmingcheng,String quanxianbumen){
		StringBuffer sf = new StringBuffer(" from QuanXian where quanxianmingcheng = :quanxianmingcheng and quanxianbumen = :quanxianbumen ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("quanxianmingcheng", quanxianmingcheng);
		query.setString("quanxianbumen", quanxianbumen);
		
		return (QuanXian) query.uniqueResult();
	}
	
}
