package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.YingYunZhengDao;
import com.entity.TouRuShenHe;
import com.entity.YingYunZheng;

/**
 *  营运证 业务层
 */
public class YingYunZhengService {
	/**
	 * 构造方法
	 */
	public YingYunZhengService() {
		super();
	}

	/**
	 * 属性
	 */
	private YingYunZhengDao yingYunZhengDao; //营运证dao对象
	
	/**
	 *  查询指定id的营运证
	 */
	public YingYunZheng queryYingYunZhengId(Integer id){
		return yingYunZhengDao.findById(id);
	}
	
	/**
	 *  查询所有营运证
	 */
	public List<YingYunZheng> queryYingYunZheng(){
		return yingYunZhengDao.queryYingYunZheng();
	}
	
	/**
	 *  查询所有未办理的营运证
	 */
	public List<YingYunZheng> queryYingYunZhengWeiBanLi(){
		return yingYunZhengDao.queryYingYunZhengWeiBanLi();
	}

	/**
	 *  查询所有未办理的营运证数量
	 */
	public int getYingYunZhengJinDu(){
		return yingYunZhengDao.getYingYunZhengJinDu();
	}
	
	/**
	 *  查询指定车牌号的营运证
	 */
	public YingYunZheng queryYingYunZhengChePaiHao(String chepaihao){
		return yingYunZhengDao.queryYingYunZhengChePaiHao(chepaihao);
	}
	
	/**
	 *  模糊查询
	 */
	public List<YingYunZheng> vagueSearchYingYunZheng(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingYunZheng where id is not null ");
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
		Query query = yingYunZhengDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
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
	 *  添加营运证
	 */
	public void addYingYunZheng( YingYunZheng yingyunzheng ){
		yingYunZhengDao.save(yingyunzheng);
	}
	
	/**
	 *  删除营运证
	 */
	public void deleteYingYunZheng(Integer id){
		YingYunZheng yingyunzheng = new YingYunZheng();
		yingyunzheng.setId(id);
		yingYunZhengDao.delete(yingyunzheng);
	}
	
	/**
	 *  修改营运证
	 */
	public void updateYingYunZheng( YingYunZheng yingyunzheng ){
		yingYunZhengDao.update(yingyunzheng);
	}
	
	/**
	 *  删除指定车牌号的营运证
	 */
	public void deleteYingYunZhengChePaiHao(String chepaihao){
		yingYunZhengDao.deleteYingYunZhengChePaiHao(chepaihao);
	}
	
	/**
	 *  get set
	 */
	public YingYunZhengDao getYingYunZhengDao() {
		return yingYunZhengDao;
	}

	public void setYingYunZhengDao(YingYunZhengDao yingYunZhengDao) {
		this.yingYunZhengDao = yingYunZhengDao;
	}
	
}
