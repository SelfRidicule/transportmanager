package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.JinDuDao;
import com.entity.JinDu;

/**
 *  进度 业务层
 */
public class JinDuService {
	/**
	 * 构造方法
	 */
	public JinDuService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private JinDuDao jinDuDao;	//进度dao对象

	/**
	 *  查询所有进度
	 */
	public List<JinDu> queryJinDuList(){
		return jinDuDao.queryJinDUList();
	}
	
	/**
	 *  查询指定车牌号的进度对象
	 */
	public JinDu queryJinDuInChePaiHao(String chepaihao){
		return jinDuDao.queryJinDuInChePaiHao(chepaihao);
	}
	
	/**
	 *  查询当前进度的数量
	 */
	public Long queryDangQianJinDuSize(String dangqianjindu){
		return jinDuDao.queryDangQianJinDuSize(dangqianjindu);
	}
	
	/**
	 *  保存进度
	 */
	public void saveJinDu(JinDu jindu){
		jinDuDao.save(jindu);
	}
	
	/**
	 *  删除指定id的进度
	 */
	public void deleteJinDuId(Integer id){
		JinDu jindu = new JinDu();
		jindu.setId(id);
		jinDuDao.delete(jindu);
	}
	
	/**
	 *  删除进度对象
	 */
	public void deleteJinDu(JinDu jindu){
		jinDuDao.delete(jindu);
	}
	
	/**
	 *  保存或修改进度
	 */
	public void saveOrUpdateJinDu(JinDu jindu){
		jinDuDao.saveAndUpdate(jindu);
	}
	
	/**
	 *  修改进度
	 */
	public void updateJinDu(JinDu jindu){
		jinDuDao.update(jindu);
	}
	
	/**
	 *  get set
	 */
	public JinDuDao getJinDuDao() {
		return jinDuDao;
	}

	public void setJinDuDao(JinDuDao jinDuDao) {
		this.jinDuDao = jinDuDao;
	}
	
}
