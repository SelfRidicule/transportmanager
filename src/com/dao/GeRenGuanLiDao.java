package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.GeRenGuanLi;

/**
 *  个人管理  dao层
 */
public class GeRenGuanLiDao extends Dao<GeRenGuanLi>{
	/**
	 * 构造方法
	 */
	public GeRenGuanLiDao() {
		super();
	}

	/**
	 *  查询所有个人管理
	 */
	public List<GeRenGuanLi> queryGeRenGuanLiList(){
		StringBuffer sf = new StringBuffer(" from GeRenGuanLi ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString()); 
		return query.list();
	}
	
	/**
	 *  删除指定id的个人管理
	 */
	public void deleteGeRenGuanLiId(String id){
		StringBuffer sf = new StringBuffer(" delete from GeRenGuanLi where id = :id ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString()); 
		query.setString("id", id);
		query.executeUpdate();
	}
	
}
