package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.JiaShiYuan;

/**
 *  驾驶员dao层
 */
public class JiaShiYuanDao extends Dao<JiaShiYuan>{
	/**
	 * 构造方法
	 */
	public JiaShiYuanDao() {
		super();
	}
	
	/**
	 *  查询所有驾驶员
	 */
	public List<JiaShiYuan> queryJiaShiYuan(){
		StringBuffer sf = new StringBuffer("from JiaShiYuan");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定驾驶员姓名的驾驶员
	 */
	public JiaShiYuan queryJiaShiYuanName(String jiashiyuanxingming){
		StringBuffer sf = new StringBuffer("from JiaShiYuan where jiashiyuanxingming = :jiashiyuanxingming");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("jiashiyuanxingming", jiashiyuanxingming);
		return (JiaShiYuan) query.uniqueResult();
	}
	
	/**
	 *  查询指定车牌号的驾驶员集合
	 */
	public List<JiaShiYuan> queryJiaShiYuanChePaiHao(String jiashicheliang){
		StringBuffer sf = new StringBuffer("from JiaShiYuan where jiashicheliang = :jiashicheliang");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("jiashicheliang", jiashicheliang);
		return query.list();
	}
	
	/**
	 *  查询指定电话的驾驶员
	 */
	public List<JiaShiYuan> queryJiaShiYuanDianHua(String dianhua ){
		StringBuffer sf = new StringBuffer("from JiaShiYuan where dianhua = :dianhua");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("dianhua", dianhua);
		return query.list();
	}
	
	/**
	 *  查询指定身份证的驾驶员
	 */
	public List<JiaShiYuan> queryJiaShiYuanShenFenZheng(String shenfenzhenghao ){
		StringBuffer sf = new StringBuffer("from JiaShiYuan where shenfenzhenghao = :shenfenzhenghao");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("shenfenzhenghao", shenfenzhenghao);
		return query.list();
	}
	
	
	/**
	 *  查询未审核的驾驶员 
	 */
	public List<JiaShiYuan> queryJiaShiYuanWeiShenHe(){
		StringBuffer sf = new StringBuffer(" from JiaShiYuan where shenhezhuangtai = '未审核' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询审核通过的驾驶员 
	 */
	public List<JiaShiYuan> queryJiaShiYuanShenHeTongGuo(){
		StringBuffer sf = new StringBuffer(" from JiaShiYuan where shenhezhuangtai = '审核通过' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
}
