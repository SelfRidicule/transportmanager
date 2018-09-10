package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.YingYunZheng;

/**
 *  营运证 dao层
 */
public class YingYunZhengDao extends Dao<YingYunZheng>{
	/**
	 * 构造方法
	 */
	public YingYunZhengDao() {
		super();
	}

	/**
	 *  查询所有营运证
	 */
	public List<YingYunZheng> queryYingYunZheng(){
		StringBuffer sf = new StringBuffer("from YingYunZheng");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的营运证
	 */
	public List<YingYunZheng> queryYingYunZhengWeiBanLi(){
		StringBuffer sf = new StringBuffer(" from YingYunZheng where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的营运证数量
	 */
	public int getYingYunZhengJinDu(){
		StringBuffer sf = new StringBuffer(" from YingYunZheng where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询指定车牌号的营运证
	 */
	public YingYunZheng queryYingYunZhengChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" from YingYunZheng where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (YingYunZheng) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的营运证
	 */
	public void deleteYingYunZhengChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" delete from YingYunZheng where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
