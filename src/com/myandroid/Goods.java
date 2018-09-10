package com.myandroid;

import java.util.ArrayList;
import java.util.Date;

/**
 * 	物品
 */
public class Goods {
	/**
	 * 构造方法
	 */
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goods(String wupinbianhao, String wupinmingcheng, String guige,
			String xinghao, String beizhu, String rukushijian) {
		super();
		this.wupinbianhao = wupinbianhao;
		this.wupinmingcheng = wupinmingcheng;
		this.guige = guige;
		this.xinghao = xinghao;
		this.beizhu = beizhu;
		this.rukushijian = rukushijian;
	}
	
	
	
	public Goods(Integer id, String wupinbianhao, String wupinmingcheng,
			String guige, String xinghao, String beizhu, String rukushijian,
			Integer leibieid) {
		super();
		this.id = id;
		this.wupinbianhao = wupinbianhao;
		this.wupinmingcheng = wupinmingcheng;
		this.guige = guige;
		this.xinghao = xinghao;
		this.beizhu = beizhu;
		this.rukushijian = rukushijian;
		this.leibieid = leibieid;
	}

	/**
	 * 属性
	 */
	private Integer id;
	private String wupinbianhao ;	
	private String wupinmingcheng ;
	private String guige;
	private String xinghao;
	private String beizhu;
	private String  rukushijian;
	private Integer leibieid ;
	private ArrayList<WeiXiu>  wx ;
	private ArrayList<LingYong>  ly ;
	
	
	
	/**
	 * 构造方法
	 */
	public Goods(Integer id, String wupinbianhao, String wupinmingcheng,
			String guige, String xinghao, String beizhu, String rukushijian,
			Integer leibieid, ArrayList<WeiXiu> wx, ArrayList<LingYong> ly) {
		super();
		this.id = id;
		this.wupinbianhao = wupinbianhao;
		this.wupinmingcheng = wupinmingcheng;
		this.guige = guige;
		this.xinghao = xinghao;
		this.beizhu = beizhu;
		this.rukushijian = rukushijian;
		this.leibieid = leibieid;
		this.wx = wx;
		this.ly = ly;
	}

	
	
	/**
	 * get set
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWupinbianhao() {
		return wupinbianhao;
	}

	public void setWupinbianhao(String wupinbianhao) {
		this.wupinbianhao = wupinbianhao;
	}

	public String getWupinmingcheng() {
		return wupinmingcheng;
	}

	public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
	}

	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getXinghao() {
		return xinghao;
	}

	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getRukushijian() {
		return rukushijian;
	}

	public void setRukushijian(String rukushijian) {
		this.rukushijian = rukushijian;
	}

	public Integer getLeibieid() {
		return leibieid;
	}

	public void setLeibieid(Integer leibieid) {
		this.leibieid = leibieid;
	}

	public ArrayList<WeiXiu> getWx() {
		return wx;
	}

	public void setWx(ArrayList<WeiXiu> wx) {
		this.wx = wx;
	}

	public ArrayList<LingYong> getLy() {
		return ly;
	}

	public void setLy(ArrayList<LingYong> ly) {
		this.ly = ly;
	}



	class WeiXiu{
		/**
		 * 构造方法
		 */
		public WeiXiu() {
			super();
			// TODO Auto-generated constructor stub
		}
		public WeiXiu(String id, String wupinbianhao, String shijian,
				String leirong) {
			super();
			this.id = id;
			this.wupinbianhao = wupinbianhao;
			this.shijian = shijian;
			this.leirong = leirong;
		}




		/**
		 * 属性
		 */
		private String id;
		private String wupinbianhao;
		private String shijian ;
		private String leirong;
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getShijian() {
			return shijian;
		}


		public void setShijian(String shijian) {
			this.shijian = shijian;
		}


		public String getLeirong() {
			return leirong;
		}


		public void setLeirong(String leirong) {
			this.leirong = leirong;
		}
		public String getWupinbianhao() {
			return wupinbianhao;
		}
		public void setWupinbianhao(String wupinbianhao) {
			this.wupinbianhao = wupinbianhao;
		}
		
		
	}
	
	class LingYong{
		/**
		 * 构造方法
		 */
		public LingYong() {
			super();
			// TODO Auto-generated constructor stub
		}
		public LingYong(String id, String wupinbianhao, String shijian,
				String lingyongren, String zerenren, String leixing) {
			super();
			this.id = id;
			this.wupinbianhao = wupinbianhao;
			this.shijian = shijian;
			this.lingyongren = lingyongren;
			this.zerenren = zerenren;
			this.leixing = leixing;
		}
		/**
		 * 属性
		 */
		private String id;
		private String wupinbianhao;
		private String shijian ;
		private String lingyongren;
		private String zerenren;
		private String leixing ;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getWupinbianhao() {
			return wupinbianhao;
		}
		public void setWupinbianhao(String wupinbianhao) {
			this.wupinbianhao = wupinbianhao;
		}
		public String getShijian() {
			return shijian;
		}
		public void setShijian(String shijian) {
			this.shijian = shijian;
		}
		public String getLingyongren() {
			return lingyongren;
		}
		public void setLingyongren(String lingyongren) {
			this.lingyongren = lingyongren;
		}
		public String getZerenren() {
			return zerenren;
		}
		public void setZerenren(String zerenren) {
			this.zerenren = zerenren;
		}
		public String getLeixing() {
			return leixing;
		}
		public void setLeixing(String leixing) {
			this.leixing = leixing;
		}
		
		
		
		
	}
	
	
	
}
