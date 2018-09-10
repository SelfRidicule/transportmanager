package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.BaoXianChuDan;

/**
 *  保险出单  dao层
 */
public class BaoXianChuDanDao extends Dao<BaoXianChuDan>{
	/**
	 * 构造方法
	 */
	public BaoXianChuDanDao() {
		super();
	}

	/**
	 *  查询所有保险出单
	 */
	public List<BaoXianChuDan> queryBaoXianChuDanList(){
		StringBuffer sf = new StringBuffer("from BaoXianChuDan");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的保险出单
	 */
	public List<BaoXianChuDan> queryBaoXianChuDanWeiBanLi(){
		StringBuffer sf = new StringBuffer("from BaoXianChuDan where banlizhuangtai = '未办理' ");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的保险出单数量
	 */
	public int getBaoXianChuDanJinDu(){
		StringBuffer sf = new StringBuffer("from BaoXianChuDan where banlizhuangtai = '未办理' ");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询指定车牌号的保险出单
	 */
	public BaoXianChuDan queryBaoXianChuDanChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer("from BaoXianChuDan where chepaihao = :chepaihao ");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (BaoXianChuDan) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的保险出单
	 */
	public void deleteBaoXianChuDanChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" delete from BaoXianChuDan where chepaihao = :chepaihao ");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
