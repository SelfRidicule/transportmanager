package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.YingShouKuan;

/**
 * 	营收款dao层
 */
public class YingShouKuanDao extends Dao<YingShouKuan>{
	/**
	 * 构造方法
	 */
	public YingShouKuanDao() {
		super();
	}

	/**
	 *  查询所有营收款
	 */
	public List<YingShouKuan> queryYingShouKuanList(){
		StringBuffer sf = new StringBuffer(" from YingShouKuan ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的营收款
	 */
	public List<YingShouKuan> queryYingShouKuanWeiDengJi(){
		StringBuffer sf = new StringBuffer(" from YingShouKuan where yingshoukuanzhuangtai = '未登记' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  指定订单号的营收款
	 */
	public YingShouKuan queryYingShouKuanDingDanHao(String dingdanhao){
		StringBuffer sf = new StringBuffer(" from YingShouKuan where dingdanhao = :dingdanhao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("dingdanhao", dingdanhao);
		return (YingShouKuan) query.uniqueResult();
	}
	
	
	/**
	 *  修改营收款指定列的值
	 */
	public void updateYingShouKuanColumnNameValue( String value, String myId , String columnName ){
		
		StringBuffer sf = new StringBuffer(" update yingshoukuan set " +columnName+ " = '"+value+"' where id = "+myId);
		Query query = getSessionFactory().getCurrentSession().createSQLQuery(sf.toString());
		query.executeUpdate();
		
	}
	
}
