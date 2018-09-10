package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.Dept;

/**
 *  部门类
 */
public class DeptDao extends Dao<Dept>{

	/**
	 * 构造方法
	 */
	public DeptDao() {
		super();
	}

	/**
	 * 查询所有部门
	 */
	public List<Dept> findAll() {
		String sql ="from Dept" ;
		List<Dept> list = getSessionFactory().getCurrentSession().createQuery(sql).list();
		return list;
	}
	
	/**
	 *  查询指定部门名称的部门对象
	 */
	public List<Dept> queryDeptName(String deptname){
		StringBuffer sf = new StringBuffer(" from Dept where deptname = :deptname ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("deptname", deptname);
		return  query.list();
	}
	
	
	
	
	/**
	 *  查询指定的部门
	 */
	/*public Dept findById(Integer deptid){
		String sql ="from Dept where deptid == :deptid";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql);
		query.setInteger("deptid", deptid);
		return (Dept) query.uniqueResult();
	}
	*/
	/**
	 * 部门分页查询
	 */
	public List<Dept> findPage(Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		return super.findPage(currentPage, pageSize);
	}
	
}
