package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.XinChe;

/**
 *  新车dao层
 */
public class XinCheDao extends Dao<XinChe>{
	/**
	 * 构造方法
	 */
	public XinCheDao() {
		super();
	}

	/**
	 *  查询所有新车
	 */
	public List<XinChe> queryXinChe(){
		StringBuffer sf = new StringBuffer(" from XinChe order by id desc  ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定id的新车
	 */
	public XinChe queryXinCheId(Integer id){
		return  findById(id);
	}
	
	/**
	 *  查询未办理的新车
	 */
	public List<XinChe> queryXinCheWeiBanLi(){
		StringBuffer sf = new StringBuffer(" from XinChe where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询未办理的新车数量
	 */
	public int getXinCheJinDu(){
		StringBuffer sf = new StringBuffer(" from XinChe where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询指定车牌号的新车
	 */
	public XinChe queryXinCheChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" from XinChe where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (XinChe) query.uniqueResult();
	}
	
	/**
	 *  查看指定编号 的新车数量
	 */
	public int queryXinCheBianHaoShuLiang(String bianhao){
		StringBuffer sf = new StringBuffer(" from XinChe where bianhao = :bianhao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("bianhao", bianhao);
		return  query.list().size();
	}
	
	/**
	 *  查看指定车牌号 的新车数量
	 */
	public int queryXinCheChePaiHaoShuLiang(String chepaihao){
		StringBuffer sf = new StringBuffer(" from XinChe where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return  query.list().size();
	}
	
	/**
	 *  删除指定id的新车
	 */
	public void deleteXinCheId(Integer id){
		XinChe xinche = new XinChe();
		xinche.setId(id);
		delete(xinche);
	}
	
	
	
	/**
	 *  修改新车
	 */
	public void updateXinChe(XinChe xinche){
		update(xinche);
	}
	
}
