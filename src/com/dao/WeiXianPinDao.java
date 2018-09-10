package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.WeiXianPin;

/**
 *  危险品dao层
 */
public class WeiXianPinDao extends Dao<WeiXianPin>{
	/**
	 * 构造方法
	 */
	public WeiXianPinDao() {
		super();
	}

	/**
	 *  查询所有危险品
	 */
	public List<WeiXianPin> queryWeiXianPinList(){
		StringBuffer sf = new StringBuffer("from WeiXianPin");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查找指定安全卡名称的危险品对象
	 */
	public WeiXianPin queryWeiXianPinInAnQuanKaMingCheng(String anquankamingcheng){
		StringBuffer sf = new StringBuffer("from WeiXianPin where anquankamingcheng = :anquankamingcheng ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("anquankamingcheng", anquankamingcheng);
		return (WeiXianPin) query.uniqueResult();
	}
	
	/**
	 *  查找指定安全卡名称的危险品货物名称
	 */
	public String queryWeiXianPinInHuoWuMingCheng(String anquankamingcheng){
		StringBuffer sf = new StringBuffer("from WeiXianPin where anquankamingcheng = :anquankamingcheng ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("anquankamingcheng", anquankamingcheng);
		
		WeiXianPin weixianpin = (WeiXianPin) query.uniqueResult();
		
		if(weixianpin == null){
			return "";
		}
		
		return weixianpin.getHuowumingcheng();
	}
	
}
