package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.CheLiangBeiFenDao;
import com.entity.CheLiangBeiFen;

/**
 *  车辆备份 业务层
 */
public class CheLiangBeiFenService {
	/**
	 * 构造方法
	 */
	public CheLiangBeiFenService() {
		super();
	}

	/**
	 *  属性
	 */
	private CheLiangBeiFenDao cheLiangBeiFenDao;

	/**
	 *  查询所有
	 */
	public List<CheLiangBeiFen> queryList(){
		return cheLiangBeiFenDao.queryList();
	}
	
	/**
	 * 查询 车辆备份 指定caozuoyuan 
	 */
	public CheLiangBeiFen queryCaoZuoYuan(String caozuoyuan){
		return cheLiangBeiFenDao.queryCaoZuoYuan(caozuoyuan);
	}
	
	
	public void saveAndUpdate( CheLiangBeiFen cheliangbeifen){
		cheLiangBeiFenDao.saveAndUpdate(cheliangbeifen);
	}
	
	public void deleteCaoZuoYuan(String caozuoyuan){
		cheLiangBeiFenDao.deleteCaoZuoYuan(caozuoyuan);
	}
	
	
	/**
	 *  get set
	 */
	public CheLiangBeiFenDao getCheLiangBeiFenDao() {
		return cheLiangBeiFenDao;
	}

	public void setCheLiangBeiFenDao(CheLiangBeiFenDao cheLiangBeiFenDao) {
		this.cheLiangBeiFenDao = cheLiangBeiFenDao;
	}
	
}
