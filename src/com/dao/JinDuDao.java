package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.JinDu;

/**
 *  进度dao层
 */
public class JinDuDao extends Dao<JinDu>{
	/**
	 * 构造方法
	 */
	public JinDuDao() {
		super();
	}
	

	/**
	 *  查询所有进度
	 */
	public List<JinDu> queryJinDUList(){
		StringBuffer sf = new StringBuffer("from JinDu");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定车牌号的进度对象
	 */
	public JinDu queryJinDuInChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer("from JinDu where chepaihao = :chepaihao");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (JinDu) query.uniqueResult();
	}
	
	/**
	 *  查询当前进度的数量
	 */
	public Long queryDangQianJinDuSize(String dangqianjindu){
		StringBuffer sf = new StringBuffer(" select count(*) from JinDu where dangqianjindu = :dangqianjindu");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("dangqianjindu", dangqianjindu);
		return  (Long) query.uniqueResult();
	}
	
}
