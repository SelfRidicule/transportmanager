package com.model;

import java.util.List;

/**
 * @author Administrator
 *	车辆服务器json
 */
public class CheLiangServer {
	/**
	 * 构造方法
	 */
	public CheLiangServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private List rows;
	private  Integer page;  
	private Integer total;
	
	/**
	 * @return
	 */
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
