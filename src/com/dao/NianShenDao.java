package com.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.entity.NianShen;
import com.entity.QuanXian;
import com.entity.Users;

/**
 *  年审dao层
 */
public class NianShenDao extends Dao<NianShen>{
	/**
	 * 构造方法
	 */
	public NianShenDao() {
		super();
	}

	/**
	 *  查询所有年审
	 */
	public List<NianShen> queryNianShen(){
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		 
//		得到传递的用户对象
		Users users = (Users) session.getAttribute("users");
//			判断是否为null
		if(users == null){
			return null;
		}
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		
		StringBuffer sf = new StringBuffer(" from NianShen where id is not null ");
		
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("年审管理".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				sf.append(" order by id desc ");
				return getSessionFactory().getCurrentSession().createQuery(sf.toString()).list();
			}
		}
		
		sf.append(" and caozuoyuan = :caozuoyuan ");
		sf.append(" order by id desc ");
		
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		
		query.setString( "caozuoyuan", users.getUsersid().toString() );
		
		return query.list();
	}
	
	/**
	 *  删除指定车牌号的年审
	 */
	public void deleteChePaihao(String chepaihao){
		if(chepaihao == null || "".equals(chepaihao)){
			return ;
		}
		StringBuffer sf = new StringBuffer("delete NianShen where chepaihao = :chepaihao");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
	/**
	 *  查询指定车牌号的年审
	 */
	public NianShen queryNianShenChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" from NianShen where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		
		List<NianShen> list = query.list();
		
		if(list!=null && list.size()>0){
			return (NianShen) list.get(0);
		}
		return  null;
	}
	
}
