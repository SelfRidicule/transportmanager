package com.dao;


import java.util.List;

import org.hibernate.Query;

import com.entity.JieSuanDan;

/**
 * 	结算单dao层
 */
public class JieSuanDanDao extends Dao<JieSuanDan>{
	/**
	 * 构造方法
	 */
	public JieSuanDanDao() {
		super();
	}

	
	/**
	 * 查询结算单 以id降序查询
	 */
	public List<JieSuanDan> queryJieSuanDanListOrderById(){
		
		StringBuffer sf = new StringBuffer(" from JieSuanDan order by id desc ");
		Query query = getSessionFactory().getCurrentSession().createQuery( sf.toString() );
		return query.list();
	}
	
	/**
	 * 	删除指定id的结算单
	 */
	public void deleteJieSuanDanId( String id ){
		
		StringBuffer sf = new StringBuffer(" delete from  jiesuandan where id = " + id );
		Query query = getSessionFactory().getCurrentSession().createSQLQuery( sf.toString() ) ;
		query.executeUpdate();
	}
	
}
