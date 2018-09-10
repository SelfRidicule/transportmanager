package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.CheLiangGuanLi;

/**
 *  车辆管理dao层
 */
public class CheLiangGuanLiDao extends Dao<CheLiangGuanLi>{
	/**
	 * 构造方法
	 */
	public CheLiangGuanLiDao() {
		super();
	}

	
	/**
	 *  查询所有车辆管理
	 */
	public List<CheLiangGuanLi> queryCheLiangGuanLi(){
		StringBuffer sf = new StringBuffer("from CheLiangGuanLi");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定id的车辆管理对象
	 */
	public CheLiangGuanLi queryCheLiangGuanLiId(Integer id){
		StringBuffer sf = new StringBuffer("from CheLiangGuanLi where id = :id");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setInteger("id", id);
		return (CheLiangGuanLi) query.uniqueResult();
	}
	
	/**
	 *  查询指定名称
	 */
	public List<CheLiangGuanLi> queryCheLiangGuanLiName(String shijileixing){
		StringBuffer sf = new StringBuffer("from CheLiangGuanLi where shijileixing = :shijileixing");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("shijileixing", shijileixing);
		return query.list();
	}
	
	/**
	 *  查询指定类型的集合对象
	 */
	public List<CheLiangGuanLi> queryCheLiangGuanLiType(String type){
		StringBuffer sf = new StringBuffer("from CheLiangGuanLi where type = :type");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("type", type);
		return query.list();
	}
	
	
	/**
	 *  修改车辆管理
	 */
	public void updateCheLiangGuanLi(CheLiangGuanLi cheliangguanli){
		update(cheliangguanli);
	}
	
	/**
	 *  查询指定字段不重复数据(无作用)
	 */
	public List<String> queryCheLiangGuanLiZiDuan(String ziduan){
		StringBuffer sf = new StringBuffer("select distinct "+ziduan+" from CheLiangGuanLi");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	
}
