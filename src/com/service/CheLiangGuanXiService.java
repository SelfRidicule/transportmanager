package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.CheLiangGuanXiDao;
import com.entity.CheLiangGuanXi;

/**
 *  车辆关系业务层
 */
public class CheLiangGuanXiService {
	/**
	 * 构造方法
	 */
	public CheLiangGuanXiService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private CheLiangGuanXiDao cheLiangGuanXiDao;	//车辆关系dao对象

	/**
	 *  查询所有车辆关系
	 */
	public List<CheLiangGuanXi> queryCheLiangGuanXi(){
		return cheLiangGuanXiDao.queryCheLiangGuanXi();
	}
	
	/**
	 *  查询指定id的车辆关系
	 */
	public CheLiangGuanXi queryCheLiangGuanXiId(Integer id){
		return cheLiangGuanXiDao.findById(id);
	}
	
	/**
	 *  查询指定牵引车的车辆关系
	 */
	public CheLiangGuanXi queryCheLiangGuanXiInQianYinChe(String qianyinche){
		return cheLiangGuanXiDao.queryCheLiangGuanXiInQianYinChe(qianyinche);
	}
	
	/**
	 *  模糊查询
	 */
	public List<CheLiangGuanXi> vagueSearchCheLiangGuanXi(String qianyinche,String guache){
		StringBuffer hql = new StringBuffer("from CheLiangGuanXi where id is not null ");
		
		if(qianyinche==null || "".equals(qianyinche)){
		}else{
			hql.append(" and qianyinche like :qianyinche");
		}		
		if(guache==null || "".equals(guache)){
		}else{
			hql.append(" and guache like :guache");
		}		
		
		Query query = cheLiangGuanXiDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		if(qianyinche==null || "".equals(qianyinche)){
		}else{
			query.setString("qianyinche", "%"+qianyinche+"%");
		}		
		if(guache==null || "".equals(guache)){
		}else{
			query.setString("guache", "%"+guache+"%");
		}		
		
		return query.list();
	}
	
	/**
	 *  删除指定id的车辆关系
	 */
	public void deleteCheLiangGuanXi(Integer id){
		CheLiangGuanXi cheliangguanxi = new CheLiangGuanXi();
		cheliangguanxi.setId(id);
		cheLiangGuanXiDao.delete(cheliangguanxi);
	}
	
	/**
	 *  删除指定车牌号的车辆关系
	 */
	public void deleteChePaiHao(String chepaihao){
		cheLiangGuanXiDao.deleteChePaiHao(chepaihao);
	}
	
	/**
	 *  添加车辆关系
	 */
	public void addCheLiangGuanXi(CheLiangGuanXi instance){
		cheLiangGuanXiDao.save(instance);
	}
	
	/**
	 *  修改车辆关系
	 */
	public void updateCheLiangGuanXi(CheLiangGuanXi instance){
		cheLiangGuanXiDao.update(instance);
	}
	
	/**
	 *  get set
	 */
	public CheLiangGuanXiDao getCheLiangGuanXiDao() {
		return cheLiangGuanXiDao;
	}

	public void setCheLiangGuanXiDao(CheLiangGuanXiDao cheLiangGuanXiDao) {
		this.cheLiangGuanXiDao = cheLiangGuanXiDao;
	}
	
}
