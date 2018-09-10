package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.GeRenGuanLiDao;
import com.entity.GeRenGuanLi;

/**
 *  个人管理 业务层
 */
public class GeRenGuanLiService {
	/**
	 * 构造方法
	 */
	public GeRenGuanLiService() {
		super();
	}

	/**
	 * 属性
	 */
	private GeRenGuanLiDao geRenGuanLiDao; //个人管理dao对象

	/**
	 *  查询指定id的个人管理
	 */
	public GeRenGuanLi queryGeRenGuanLiId(Integer id){
		return geRenGuanLiDao.findById(id);
	}
	
	/**
	 *  查询所有个人管理
	 */
	public List<GeRenGuanLi> queryGeRenGuanLiList(){
		return geRenGuanLiDao.queryGeRenGuanLiList();
	}
	
	/**
	 *  添加个人管理
	 */
	public void addGeRenGuanLi(GeRenGuanLi gerenguanli){
		geRenGuanLiDao.save(gerenguanli);
	}
	
	/**
	 *  修改个人管理
	 */
	public void updateGeRenGuanLi(GeRenGuanLi gerenguanli){
		geRenGuanLiDao.update(gerenguanli);
	}
	
	/**
	 *  删除指定id的个人管理
	 */
	public void deleteGeRenGuanLi(Integer id){
		GeRenGuanLi gerenguanli = new GeRenGuanLi();
		gerenguanli.setId(id);
		geRenGuanLiDao.delete(gerenguanli);
	}
	
	/**
	 *  删除指定id的个人管理
	 */
	public void deleteGeRenGuanLiId(String id){
		geRenGuanLiDao.deleteGeRenGuanLiId(id);
	}
	
	/**
	 *  get set
	 */
	public GeRenGuanLiDao getGeRenGuanLiDao() {
		return geRenGuanLiDao;
	}

	public void setGeRenGuanLiDao(GeRenGuanLiDao geRenGuanLiDao) {
		this.geRenGuanLiDao = geRenGuanLiDao;
	}
	
}
