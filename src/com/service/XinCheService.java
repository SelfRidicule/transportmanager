package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.XinCheDao;
import com.entity.XinChe;

/**
 *  新车业务层
 */
public class XinCheService {
	/**
	 * 构造方法
	 */
	public XinCheService() {
		super();
	}

	/**
	 * 属性
	 */
	private XinCheDao xinCheDao;	//新车dao对象

	
	/**
	 *  查询所有新车
	 */
	public List<XinChe> queryXinCheList(){
		return xinCheDao.queryXinChe();
	}
	
	/**
	 *  查询指定id的新车
	 */
	public XinChe queryXinCheId(Integer id){
		return xinCheDao.queryXinCheId(id);
	}
	
	/**
	 *  查询未办理的新车
	 */
	public List<XinChe> queryXinCheWeiBanLi(){
		return xinCheDao.queryXinCheWeiBanLi();
	}
	
	/**
	 *  查询未办理的新车数量
	 */
	public int getXinCheJinDu(){
		return xinCheDao.getXinCheJinDu();
	}
	
	/**
	 *  查询指定车牌号的新车
	 */
	public XinChe queryXinCheChePaiHao(String chepaihao){
		return xinCheDao.queryXinCheChePaiHao(chepaihao);
	}
	
	/**
	 *  查看指定编号 的新车数量
	 */
	public int queryXinCheBianHaoShuLiang(String bianhao){
		return  xinCheDao.queryXinCheBianHaoShuLiang(bianhao);
	}
	
	/**
	 *  查看指定车牌号 的新车数量
	 */
	public int queryXinCheChePaiHaoShuLiang(String chepaihao){
		return  xinCheDao.queryXinCheChePaiHaoShuLiang(chepaihao);
	}
	
	/**
	 *  模糊查询
	 */
	public List<XinChe> vagueSearchXinChe(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from XinChe where id is not null ");
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
		Query query = xinCheDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(bianhao==null || "".equals(bianhao)){
		}else{
			query.setString("bianhao", "%"+bianhao+"%" );
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
	 *  删除指定id的新车
	 */
	public void deleteXinCheId(Integer id){
		xinCheDao.deleteXinCheId(id);
	}
	
	/**
	 *  删除新车对象
	 */
	public void deleteXinChe(XinChe xinche){
		xinCheDao.delete(xinche);
	}
	
	/**
	 *  修改新车
	 */
	public void updateXinChe(XinChe xinche){
		xinCheDao.updateXinChe(xinche);
	}
	
	/**
	 *  添加新车
	 */
	public void addXinChe(XinChe xinche){
		xinCheDao.save(xinche);
	}
	
	/**
	 * get set  
	 */
	public XinCheDao getXinCheDao() {
		return xinCheDao;
	}

	public void setXinCheDao(XinCheDao xinCheDao) {
		this.xinCheDao = xinCheDao;
	}
	
}
