package com.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.dao.NianShenDao;
import com.entity.NianShen;
import com.entity.QuanXian;
import com.entity.Users;

/**
 *  年审业务层
 */
public class NianShenService {
	/**
	 * 构造方法
	 */
	public NianShenService() {
		super();
	}

	/**
	 * 属性
	 */
	private NianShenDao nianShenDao;	//年审dao对象
	
	/**
	 *  查询所有年审
	 */
	public List<NianShen> queryNianShen(){
		return nianShenDao.queryNianShen();
	}
	
	/**
	 *  查询指定操作员
	 */
	public List<NianShen> queryCaoZuoYuan(String caozuoyuan){
//		创建hql语句
		StringBuffer hql = new StringBuffer(" from NianShen where id is not null ");
		
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("年审管理".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				hql.append(" order by id desc ");
				return nianShenDao.getSessionFactory().getCurrentSession().createQuery(hql.toString()).list();
			}
		}
		
		
		hql.append(" and caozuoyuan = :caozuoyuan ");
		
		hql.append(" order by id desc ");
		
//		创建query对象
		Query query = nianShenDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		query.setString("caozuoyuan", caozuoyuan);
		
		return query.list();
	}
	
	/**
	 *  查询指定车牌号的年审
	 */
	public NianShen queryNianShenChePaiHao(String chepaihao){
		return nianShenDao.queryNianShenChePaiHao(chepaihao);
	}
	
	/**
	 *  查询指定id 年审
	 */
	public NianShen queryNianShenId(Integer id){
		return nianShenDao.findById(id);
	}
	
	/**
	 *  模糊查询
	 */
	public List<NianShen> vagueSearchNianShen(String chepaihao,Date chaxunxiaoyudaoqiriqi, Date chaxundayudaoqiriqi){
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		 
//		得到传递的用户对象
		Users users = (Users) session.getAttribute("users");
//				判断是否为null
		if(users == null){
			return null;
		}
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		
//		创建hql语句
		StringBuffer hql = new StringBuffer("from NianShen where id is not null");
//		判断值是否为空
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}		
		if(chaxunxiaoyudaoqiriqi==null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi < :chaxunxiaoyudaoqiriqi");
		}
		if(chaxundayudaoqiriqi==null || "".equals(chaxundayudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi > :chaxundayudaoqiriqi");
		}
		
		boolean flag = true;
		
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("年审管理".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				flag = false;
			}
		}
		
		if(flag){
			hql.append(" and caozuoyuan = :caozuoyuan ");
		}
		
		hql.append(" order by id desc ");
		
//		创建query对象
		Query query = nianShenDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断是否要添加值
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", chepaihao);
		}		
		if(chaxunxiaoyudaoqiriqi==null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			query.setDate("chaxunxiaoyudaoqiriqi", chaxunxiaoyudaoqiriqi);
		}
		if(chaxundayudaoqiriqi==null || "".equals(chaxundayudaoqiriqi)){
		}else{
			query.setDate("chaxundayudaoqiriqi", chaxundayudaoqiriqi);
		}
		
		if(flag){
			query.setString("caozuoyuan", users.getUsersid().toString());
		}
		
		return query.list();
	}
	
	/**
	 *  添加年审
	 */
	public void addNianShen(NianShen nianshen){
		nianShenDao.save(nianshen);
	}
	
	/**
	 *  修改年审
	 */
	public void updateNianShen(NianShen nianshen){
		nianShenDao.update(nianshen);
	}
	
	/**
	 *  删除指定车牌号的年审
	 */
	public void deleteChePaihao(String chepaihao){
		nianShenDao.deleteChePaihao(chepaihao);
	}
	
	/**
	 *  保存或修改
	 */
	public void saveAndUpdate(NianShen nianshen){
		nianShenDao.saveAndUpdate(nianshen);
	}
	
	/**
	 *  get set
	 */
	public NianShenDao getNianShenDao() {
		return nianShenDao;
	}
	public void setNianShenDao(NianShenDao nianShenDao) {
		this.nianShenDao = nianShenDao;
	}
	
}
