package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.ZeRenRenDao;
import com.entity.FeiYongJieSuan;
import com.entity.ZeRenRen;

/**
 *  责任人业务层
 */
public class ZeRenRenService {
	/**
	 * 构造方法
	 */
	public ZeRenRenService() {
		super();
	}

	/**
	 * 属性
	 */
	private ZeRenRenDao zeRenRenDao;	//责任人dao对象

	/**
	 *  查询所有责任人
	 */
	public List<ZeRenRen> queryZeRenRenList(){
		return zeRenRenDao.queryZeRenRenList();
	}
	
	/**
	 *  查询所有未办理的责任人
	 */
	public List<ZeRenRen> queryZeRenRenWeiBanLi(){
		return zeRenRenDao.queryZeRenRenWeiBanLi();
	}
	
	/**
	 *  查询所有未办理的责任人数量
	 */
	public int getZeRenRenJinDu(){
		return zeRenRenDao.getZeRenRenJinDu();
	}
	
	/**
	 *  查询指定车牌号的责任人
	 */
	public ZeRenRen queryZeRenRenChePaiHao(String chepaihao){
		return zeRenRenDao.queryZeRenRenChePaiHao(chepaihao);
	}
	
	/**
	 *  模糊查询
	 */
	public List<ZeRenRen> vagueSearchZeRenRen(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from ZeRenRen where id is not null ");
//		判断值是否为空
		if(bianhao==null || "".equals(bianhao)){
		}else{
			hql.append(" and bianhao like :bianhao");
		}
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}
		if(banlizhuangtai==null || "".equals(banlizhuangtai)){
		}else{
			hql.append(" and banlizhuangtai like :banlizhuangtai");
		}
		
//		创建query对象
		Query query = zeRenRenDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(bianhao==null || "".equals(bianhao)){
		}else{
			query.setString("bianhao","%"+bianhao+"%" );
		}
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", chepaihao);
		}
		if(banlizhuangtai==null || "".equals(banlizhuangtai)){
		}else{
			query.setString("banlizhuangtai", banlizhuangtai);
		}
		
		return query.list();
	}	
	
	/**
	 *  添加责任人
	 */
	public void addZeRenRen(ZeRenRen zerenren){
		zeRenRenDao.save(zerenren);
	}
	
	/**
	 *  修改责任人
	 */
	public void updateZeRenRen(ZeRenRen zerenren){
		zeRenRenDao.update(zerenren);
	}
	
	/**
	 *  删除责任人
	 */
	public void deleteZeRenRenId(Integer id){
		ZeRenRen zerenren = new ZeRenRen();
		zerenren.setId(id);
		zeRenRenDao.delete(zerenren);
	}
	
	/**
	 *  删除指定车牌号的责任人
	 */
	public void deleteZeRenRenChePaiHao(String chepaihao){
		zeRenRenDao.deleteZeRenRenChePaiHao(chepaihao);
	}
	
	/**
	 *  get set 
	 */
	public ZeRenRenDao getZeRenRenDao() {
		return zeRenRenDao;
	}

	public void setZeRenRenDao(ZeRenRenDao zeRenRenDao) {
		this.zeRenRenDao = zeRenRenDao;
	}
	
}
