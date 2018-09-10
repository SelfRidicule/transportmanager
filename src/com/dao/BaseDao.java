package com.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public void save(T instance);   //增加方法
	
	public void delete(T instance); //删除方法
	
	public void update(T instance); //更新方法
	
	public T findById(Integer id);  //根据id查找
	
	public List<T> findAll();       //查找所有对象
	
	public List<T> findPage(Integer currentPage,Integer pageSize); //分页查询
	
	public void saveAndUpdate(T instance);
	
}
