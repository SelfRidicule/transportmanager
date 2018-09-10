package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.CheLiangGuanLiDao;
import com.entity.CheLiangGuanLi;

/**
 *  车辆管理业务层
 */
public class CheLiangGuanLiService {
	/**
	 * 构造方法
	 */
	public CheLiangGuanLiService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private CheLiangGuanLiDao cheLiangGuanLiDao;

	/**
	 *  查询所有车辆管理
	 */
	public List<CheLiangGuanLi> queryCheLiangGuanLi(){
		return cheLiangGuanLiDao.queryCheLiangGuanLi();
	}
	
	/**
	 *  查询指定id的车辆管理
	 */
	public CheLiangGuanLi queryCheLiangGuanLiId(Integer id){
		return cheLiangGuanLiDao.queryCheLiangGuanLiId(id);
	}
	
	/**
	 *  查询指定名称
	 */
	public List<CheLiangGuanLi> queryCheLiangGuanLiName(String shijileixing){
		return cheLiangGuanLiDao.queryCheLiangGuanLiName(shijileixing);
	}
	
	/**
	 *  模糊查询
	 */
	public List<CheLiangGuanLi> vagueSearchCheLiangGuanLi(String type,String name){
		
		StringBuffer hql = new StringBuffer("from CheLiangGuanLi where id is not null ");
		
		if(type==null || "".equals(type)){
		}else{
			hql.append(" and type like :type");
		}
		if(name==null || "".equals(name)){
		}else{
			hql.append(" and name like :name");
		}
		
		Query query = cheLiangGuanLiDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		if(type==null || "".equals(type)){
		}else{
			query.setString("type", "%"+type+"%");
		}
		if(name==null || "".equals(name)){
		}else{
			query.setString("name", "%"+name+"%");
		}
		
		return  query.list();
	}
	
	/**
	 *  添加车辆管理
	 */
	public void addCheLiangGuanLi(CheLiangGuanLi cheliangguanli){
		cheLiangGuanLiDao.save(cheliangguanli);
	}
	
	/**
	 *  添加车辆管理 并 返回id
	 */
	public Integer addCheLiangGuanLiReturnId(CheLiangGuanLi cheliangguanli){
		return (Integer) cheLiangGuanLiDao.getSessionFactory().getCurrentSession().save(cheliangguanli);
	}
	
	/**
	 *  删除车辆管理
	 */
	public void deleteCheLiangGuanLi(Integer id){
		CheLiangGuanLi clgl = new CheLiangGuanLi();
		clgl.setId(id);
		cheLiangGuanLiDao.delete(clgl);
	}
	
	/**
	 *  修改车辆管理
	 */
	public void updateCheLiangGuanLi(CheLiangGuanLi cheliangguanli){
		cheLiangGuanLiDao.update(cheliangguanli);
	}
	
	/**
	 *  查询指定类型的车辆管理集合对象
	 */
	public List<CheLiangGuanLi> queryCheLiangGuanLiType(String type){
		return cheLiangGuanLiDao.queryCheLiangGuanLiType(type);
	}
	
	/**
	 *  查询车辆管理指定字段不重复数据(无作用)
	 */
	public List<String> queryCheLiangGuanLiZiDuan(String ziduan){
		return cheLiangGuanLiDao.queryCheLiangGuanLiZiDuan(ziduan);
	}
	 
	/**
	 *  get set 
	 */
	public CheLiangGuanLiDao getCheLiangGuanLiDao() {
		return cheLiangGuanLiDao;
	}

	public void setCheLiangGuanLiDao(CheLiangGuanLiDao cheLiangGuanLiDao) {
		this.cheLiangGuanLiDao = cheLiangGuanLiDao;
	} 
	
}
