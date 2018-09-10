package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.CongYeZiGe;

/**
 *  从业资格 dao层
 */
public class CongYeZiGeDao extends Dao<CongYeZiGe>{
	/**
	 * 构造方法
	 */
	public CongYeZiGeDao() {
		super();
	}

	/**
	 *  查找所有 
	 */
	public List<CongYeZiGe> queryCongYeZiGeList(){
		StringBuffer sf = new StringBuffer(" from CongYeZiGe ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
		
	}
	
	/**
	 *  删除指定id
	 */
	public void deleteCongYeZiGeId(String id){
		StringBuffer sf = new StringBuffer(" delete from CongYeZiGe where id = :id ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("id", id);
		query.executeUpdate();
	}
	
}
