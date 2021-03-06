package com.service;

import java.util.List;

import org.hibernate.Query;


import com.dao.FeiYongJieSuanDao;
import com.entity.BaoXianChuDan;
import com.entity.FeiYongJieSuan;

/**
 *  费用结算 业务层
 */
public class FeiYongJieSuanService {
	/**
	 * 构造方法
	 */
	public FeiYongJieSuanService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private FeiYongJieSuanDao feiYongJieSuanDao ;	//费用结算dao对象

	/**
	 *  查询所有费用结算
	 */
	public List<FeiYongJieSuan> queryFeiYongJieSuanList(){
		return feiYongJieSuanDao.queryFeiYongJieSuanList();
	}

	/**
	 *  查询所有未办理的费用结算
	 */
	public List<FeiYongJieSuan> queryFeiYongJieSuanWeiBanLi(){
		return feiYongJieSuanDao.queryFeiYongJieSuanWeiBanLi();
	}
	
	/**
	 *  查询所有未办理的费用结算数量
	 */
	public int getFeiYongJieSuanJinDu(){
		return feiYongJieSuanDao.getFeiYongJieSuanJinDu();
	}
	
	/**
	 *  查询指定车牌号的费用结算
	 */
	public FeiYongJieSuan queryFeiYongJieSuanChePaiHao(String chepaihao){
		return feiYongJieSuanDao.queryFeiYongJieSuanChePaiHao(chepaihao);
	}
	
	/**
	 *  模糊查询
	 */
	public List<FeiYongJieSuan> vagueSearchFeiYongJieSuan(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from FeiYongJieSuan where id is not null ");
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
		Query query = feiYongJieSuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
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
	 *  添加费用结算
	 */
	public void addFeiYongJieSuan(FeiYongJieSuan feiyongjiesuan){
		feiYongJieSuanDao.save(feiyongjiesuan);
	}
	
	/**
	 *  修改费用结算
	 */
	public void updateFeiYongJieSuan(FeiYongJieSuan feiyongjiesuan){
		feiYongJieSuanDao.update(feiyongjiesuan);
	}
	
	/**
	 *  删除费用结算
	 */
	public void deleteFeiYongJieSuan(Integer id){
		FeiYongJieSuan feiyongjiesuan = new FeiYongJieSuan();
		feiyongjiesuan.setId(id);
		feiYongJieSuanDao.delete(feiyongjiesuan);
	}
	
	/**
	 *  删除指定车牌号的费用结算
	 */
	public void deleteFeiYongJieSuanChePaiHao(String chepaihao){
		feiYongJieSuanDao.deleteFeiYongJieSuanChePaiHao(chepaihao);
	}
	
	/**
	 *  get set
	 */
	public FeiYongJieSuanDao getFeiYongJieSuanDao() {
		return feiYongJieSuanDao;
	}

	public void setFeiYongJieSuanDao(FeiYongJieSuanDao feiYongJieSuanDao) {
		this.feiYongJieSuanDao = feiYongJieSuanDao;
	}
	
}
