package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.entity.Users;

/**
 *  用户Dao 类
 */
public class UsersDao extends Dao<Users> {

	/**
	 * 构造方法
	 */
	public UsersDao() {
		super();
	}

	/**
	 * 查询所有用户
	 */
	public List<Users> findAll() {
		String hql ="from Users";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 查询指定权限名称的用户集合
	 */
	public List<Users> queryUsersQuanXianMingCheng(String quanxianmingcheng) {
		String hql =" from Users where quanxianmingcheng = :quanxianmingcheng ";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setString("quanxianmingcheng", quanxianmingcheng);
		return query.list();
	}
	
	/**
	 *  用户登录
	 */
	public Integer loginUsers(String account,String password){
		String hql = "from Users where account = :account and password = :password ";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setString("account", account);
		query.setString("password", password);
		return query.list().size();
	}
	
	/**
	 *  查询指定id用户
	 */
	public Users getSingleUsers(Integer id){
		return  findById(id);
	}
	
	/**
	 *  修改用户
	 */
	public void updateUsers(Users users){
		update(users);
	}
	
	/**
	 *  是否存在对应deptid的用户
	 */
	public boolean existUsers(Integer deptid){
		String hql ="select count(*) from Users where deptid = :deptid" ;
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setInteger("deptid", deptid);
		
		long count =  (Long) query.uniqueResult();
		System.out.println("count="+count);
//		如果有值那么就有对应的用户 ，不可删除
		if(count==0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 *  修改指定权限名称的权限
	 */
	public void updateUsersQuanXianMingCheng(String quanxianmingcheng){
		StringBuffer sf = new StringBuffer("update Users set quanxianmingcheng = '' where quanxianmingcheng = :quanxianmingcheng ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("quanxianmingcheng", quanxianmingcheng);
		query.executeUpdate();
	}
	
	
	/**
	 *  查询指定部门名称的用户
	 */
	public List<Users> queryUsersInDeptName(String deptname) {
		StringBuffer hql = new StringBuffer();
		hql.append(" select u.* from Users u , Dept d ");
		hql.append(" where u.deptid = d.deptid ");
		hql.append(" and d.deptname = :deptname ");
		
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(hql.toString());
		
		query.setString("deptname", deptname);
		
		query.addEntity(Users.class);
		
		return query.list();
	}
	
}
