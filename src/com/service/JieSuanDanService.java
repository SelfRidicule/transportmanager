package com.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.dao.JieSuanDanDao;
import com.entity.JieSuanDan;

/**
 *  结算单 业务层
 */
public class JieSuanDanService {
	/**
	 * 构造方法
	 */
	public JieSuanDanService() {
		super();
	}

	/**
	 * 属性
	 */
	private JieSuanDanDao jieSuanDanDao;

	
	/**
	 * 查询结算单 以id降序查询
	 */
	public List<JieSuanDan> queryJieSuanDanListOrderById(){
		return jieSuanDanDao.queryJieSuanDanListOrderById();
	}
	
	/**
	 * 	查询指定id的结算单
	 */
	public JieSuanDan queryJieSuanDanId( Integer id ){
		return  jieSuanDanDao.findById(id);
	}
	
	/**
	 * 	模糊查询
	 */
	public List<JieSuanDan> vagueSearchJieSuanDan( String dingdanhao, String chezhuxingming, String huowumingcheng, Date chaxunxiaoyulingkuanshijian, Date chaxundayulingkuanshijian, String kehudanwei){
//		创建查询语句
		StringBuffer hql = new StringBuffer("from JieSuanDan where id is not null ");
//		判断值是否为空
		if(dingdanhao!=null && !"".equals(dingdanhao)){
			hql.append(" and dingdanhao like :dingdanhao");
		}
		if(chezhuxingming!=null && !"".equals(chezhuxingming)){
			hql.append(" and chezhuxingming like :chezhuxingming");
		}
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			hql.append(" and huowumingcheng like :huowumingcheng");
		}
		if(chaxunxiaoyulingkuanshijian!=null && !"".equals(chaxunxiaoyulingkuanshijian)){
			hql.append(" lingkuanshijian < :chaxunxiaoyulingkuanshijian ");
		}
		if(chaxundayulingkuanshijian!=null && !"".equals(chaxundayulingkuanshijian)){
			hql.append(" lingkuanshijian > :chaxundayulingkuanshijian ");
		}
		if(kehudanwei!=null && !"".equals(kehudanwei)){
			hql.append(" and kehudanwei like :kehudanwei");
		}
		
//		创建query对象
		Query query = jieSuanDanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
	
//		判断值是否赋值
		if(dingdanhao!=null && !"".equals(dingdanhao)){
			query.setString("dingdanhao", "%"+dingdanhao+"%");
		}
		if(chezhuxingming!=null && !"".equals(chezhuxingming)){
			query.setString("chezhuxingming", "%"+chezhuxingming+"%");
		}
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			query.setString("huowumingcheng", "%"+huowumingcheng+"%");
		}
		if(chaxunxiaoyulingkuanshijian!=null && !"".equals(chaxunxiaoyulingkuanshijian)){
			query.setDate("chaxunxiaoyulingkuanshijian", chaxunxiaoyulingkuanshijian);
		}
		if(chaxundayulingkuanshijian!=null && !"".equals(chaxundayulingkuanshijian)){
			query.setDate("chaxundayulingkuanshijian", chaxundayulingkuanshijian);
		}
		if(kehudanwei!=null && !"".equals(kehudanwei)){
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		
		return query.list();
		
	}
	
	
	/**
	 * 	添加结算单
	 */
	public void addJieSuanDan( JieSuanDan jiesuandan ){
		jieSuanDanDao.save(jiesuandan);
	}
	
	/**
	 * 	删除指定id的结算单
	 */
	public void deleteJieSuanDanId( String id ){
		jieSuanDanDao.deleteJieSuanDanId(id);
	}
	
	/**
	 * 	修改结算单
	 */
	public void updateJieSuanDan( JieSuanDan jiesuandan ){
		jieSuanDanDao.update(jiesuandan);
	}
	
	/**
	 *  get set
	 */
	public JieSuanDanDao getJieSuanDanDao() {
		return jieSuanDanDao;
	}

	public void setJieSuanDanDao(JieSuanDanDao jieSuanDanDao) {
		this.jieSuanDanDao = jieSuanDanDao;
	}

	
}
