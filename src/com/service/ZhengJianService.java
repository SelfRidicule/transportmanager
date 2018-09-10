package com.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.dao.ZhengJianDao;
import com.entity.BaoXian;
import com.entity.ZhengJian;

/**
 * 证件 业务层
 */
public class ZhengJianService {
	/**
	 * 构造方法
	 */
	public ZhengJianService() {
		super();
	}

	/**
	 * 属性
	 */
	private ZhengJianDao zhengJianDao; //证件dao属性

	/**
	 *  查询所有证件信息
	 */
	public List<ZhengJian> queryZhengJianList(){
		return zhengJianDao.queryZhengJianList();
	}
	
	/**
	 * 查询排序时间的证件信息 
	 */
	public List<ZhengJian> queryZhengJianOrderByList(){
		return zhengJianDao.queryZhengJianOrderByList();
	}
	
	/**
	 *  模糊查询
	 */
	public List<ZhengJian> vagueSearchZhengJian(String chepaihao, String zhengjianleixing,String caozuoyuan ,Date  chaxunxiaoyudaoqiriqi, Date  chaxundayudaoqiriqi){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from ZhengJian where id is not null ");
//		判断值是否为空
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}
		if(zhengjianleixing==null || "".equals(zhengjianleixing)){
		}else{
			hql.append(" and zhengjianleixing like :zhengjianleixing");
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			hql.append(" and caozuoyuan like :caozuoyuan");
		}		
		if(chaxunxiaoyudaoqiriqi==null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi < :chaxunxiaoyudaoqiriqi");
		}	
		if(chaxundayudaoqiriqi==null || "".equals(chaxundayudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi > :chaxundayudaoqiriqi");
		}	
//		创建query对象
		Query query = zhengJianDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		判断是否要添加值
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", "%"+chepaihao+"%");
		}
		if(zhengjianleixing==null || "".equals(zhengjianleixing)){
		}else{
			query.setString("zhengjianleixing", "%"+zhengjianleixing+"%");
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			query.setString("caozuoyuan", "%"+caozuoyuan+"%");
		}		
		if(chaxunxiaoyudaoqiriqi==null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			query.setDate("chaxunxiaoyudaoqiriqi", chaxunxiaoyudaoqiriqi);
		}	
		if(chaxundayudaoqiriqi==null || "".equals(chaxundayudaoqiriqi)){
		}else{
			query.setDate("chaxundayudaoqiriqi", chaxundayudaoqiriqi);
		}	

		return query.list();
	}
	
	/**
	 *  添加证件信息
	 */
	public void addZhengJian(ZhengJian zhengjian){
		zhengJianDao.save(zhengjian);
	}
	
	/**
	 *  删除证件
	 */
	public void deleteZhengJian(Integer id){
		ZhengJian zhengjian = new ZhengJian();
		zhengjian.setId(id);
		zhengJianDao.delete(zhengjian);
	}
	
	/**
	 *  删除指定车牌号的证件
	 */
	public void deleteZhengJianExistChePaiHao(String chepaihao){
		zhengJianDao.deleteZhengJianExistChePaiHao(chepaihao);
	}
	
	
	/**
	 *  查询指定id的证件对象
	 */
	public ZhengJian queryIdZhengJian(Integer id){
		return zhengJianDao.findById(id);
	}
	
	/**
	 *  修改证件
	 */
	public void updateZhengJian(ZhengJian zhengjian){
		zhengJianDao.update(zhengjian);
	}
	
	/**
	 *	是否存在相同证件类型  
	 */
	public Integer existZhengJianLeiXing(String chepaihao,String zhengjianleixing){
		String hql = "from ZhengJian where chepaihao = :chepaihao and zhengjianleixing = :zhengjianleixing";
		StringBuffer sf =new StringBuffer(hql);
		Query query = zhengJianDao.getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.setString("zhengjianleixing", zhengjianleixing);
		
		return query.list().size();
		
	}
	
	/**
	 *  get set
	 */
	public ZhengJianDao getZhengJianDao() {
		return zhengJianDao;
	}

	public void setZhengJianDao(ZhengJianDao zhengJianDao) {
		this.zhengJianDao = zhengJianDao;
	}
	
}
