package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.WeiXianPinDao;
import com.entity.WeiXianPin;
import com.entity.ZeRenRen;

/**
 *  危险品 业务层
 */
public class WeiXianPinService {
	/**
	 * 构造方法
	 */
	public WeiXianPinService() {
		super();
	}

	/**
	 * 属性
	 */
	private WeiXianPinDao weiXianPinDao;	//属性

	/**
	 *  查询所有危险品
	 */
	public List<WeiXianPin> queryWeiXianPinList(){
		return weiXianPinDao.queryWeiXianPinList();
	}
	
	/**
	 *  查询指定id的危险品
	 */
	public WeiXianPin queryWeiXianPinId(Integer id){
		return weiXianPinDao.findById(id);
	}
	
	/**
	 *  查找指定安全卡名称的危险品对象
	 */
	public WeiXianPin queryWeiXianPinInAnQuanKaMingCheng(String anquankamingcheng){
		return weiXianPinDao.queryWeiXianPinInAnQuanKaMingCheng(anquankamingcheng);
	}
	
	/**
	 *  查找指定安全卡名称的危险品货物名称
	 */
	public String queryWeiXianPinInHuoWuMingCheng(String anquankamingcheng){
		return weiXianPinDao.queryWeiXianPinInHuoWuMingCheng(anquankamingcheng);
	}
	
	/**
	 *  模糊查询
	 */
	public List<WeiXianPin> vagueSearchWeiXianPin(String huowumingcheng){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from WeiXianPin where id is not null ");
//		判断值是否为空
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			hql.append(" and huowumingcheng like :huowumingcheng");
		}
		
//		创建query对象
		Query query = weiXianPinDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			query.setString("huowumingcheng","%"+huowumingcheng+"%" );
		}
		
		return query.list();
	}	
	
	
	/**
	 *  添加危险品
	 */
	public void addWeiXianPin(WeiXianPin weixianpin){
		weiXianPinDao.save(weixianpin);
	}
	
	/**
	 *  删除危险品
	 */
	public void deleteWeiXianPin(WeiXianPin weixianpin){
		weiXianPinDao.delete(weixianpin);
	}
	
	/**
	 *  修改危险品
	 */
	public void updateWeiXianPin(WeiXianPin weixianpin){
		weiXianPinDao.update(weixianpin);
	}
	
	
	/**
	 *  get set
	 */
	public WeiXianPinDao getWeiXianPinDao() {
		return weiXianPinDao;
	}

	public void setWeiXianPinDao(WeiXianPinDao weiXianPinDao) {
		this.weiXianPinDao = weiXianPinDao;
	}
	
}
