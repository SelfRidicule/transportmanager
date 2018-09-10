package com.entity;

/**
 *  进度 实体类
 */
public class JinDu {
	/**
	 * 构造方法
	 */
	public JinDu() {
		super();
	}
	
	public JinDu(String chepaihao, String dangqianjindu) {
		super();
		this.chepaihao = chepaihao;
		this.dangqianjindu = dangqianjindu;
	}

	/**
	 * 属性
	 */
	private Integer id;
	private String chepaihao;
	private String dangqianjindu;
	
	/**
	 *  赋值
	 */
	public void setJinDu(String chepaihao, String dangqianjindu) {
		this.chepaihao = chepaihao;
		this.dangqianjindu = dangqianjindu;
	}
	
	/**
	 *  get set 
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getDangqianjindu() {
		return dangqianjindu;
	}
	public void setDangqianjindu(String dangqianjindu) {
		this.dangqianjindu = dangqianjindu;
	}
	
}
