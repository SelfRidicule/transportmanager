package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.CaiLiaoZhengLi;

/**
 *  材料整理dao层  ( 材料整理、档案建立 )
 */
public class CaiLiaoZhengLiDao extends Dao<CaiLiaoZhengLi>{
	/**
	 * 构造方法
	 */
	public CaiLiaoZhengLiDao() {
		super();
	}

	/**
	 *  查询所有 材料整理
	 */
	public List<CaiLiaoZhengLi> queryCaiLiaoZhengLiList(){
		StringBuffer sf = new StringBuffer(" from CaiLiaoZhengLi ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的 材料整理
	 */
	public List<CaiLiaoZhengLi> queryCaiLiaoZhengLiWeiBanLi(){
		StringBuffer sf = new StringBuffer(" from CaiLiaoZhengLi where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的 材料整理数量
	 */
	public int getCaiLiaoZhengLiJinDu(){
		StringBuffer sf = new StringBuffer(" from CaiLiaoZhengLi where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询指定车牌号的材料整理
	 */
	public CaiLiaoZhengLi queryCaiLiaoZhengLiChePaiHao( String chepaihao ){
		StringBuffer sf = new StringBuffer(" from CaiLiaoZhengLi where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (CaiLiaoZhengLi) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的材料整理
	 */
	public void deleteCaiLiaoZhengLiChePaiHao( String chepaihao ){
		StringBuffer sf = new StringBuffer(" delete from CaiLiaoZhengLi where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
	
}
