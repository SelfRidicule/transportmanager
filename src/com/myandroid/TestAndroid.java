package com.myandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.*;
import com.myandroid.Goods.LingYong;
import com.myandroid.Goods.WeiXiu;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;

public class TestAndroid extends ActionSupport{

	
	
	public void androidTests() throws IOException{
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		String acceptjson = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                 request.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer("");
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        br.close();
        
        acceptjson = sb.toString();
        

        
        JSONObject jo = JSONObject.fromObject(acceptjson);
        
        UserModel userModel = (UserModel) jo.toBean(jo,UserModel.class);
        
        
              
        
        //服务器返回jason给android
        // 创建json根对象
       /* JSONObject mJson = new JSONObject();
        // 创建json跟对象的子对象，里面存放对个实体类的值的json数组   
        mJson.put("flag", "true");
        
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(mJson.toString());*/
		
        
        
        //服务器返回jason给android
        // 创建json根对象
        Goods g1 = new Goods("a", "毛巾", "a","纯棉","123", "2017-05-01");
        g1.setId(1);
        g1.setLeibieid(222);
        ArrayList<WeiXiu> list = new ArrayList<WeiXiu>();
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        list.add(g1.new WeiXiu("a", "a", "2017-05-01", "123"));
        g1.setWx(list);
        
        ArrayList<LingYong> list2 = new ArrayList<LingYong>();
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "领用"));
        list2.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "归还"));
        g1.setLy(list2); 
        
        
        Goods g2 = new Goods("a", "毛巾", "a","纯棉","123", "2017-05-01");
        g2.setId(1);
        g2.setLeibieid(222);
        
        ArrayList<WeiXiu> list3 = new ArrayList<WeiXiu>();
        list3.add(g2.new WeiXiu("a", "a", "2017-05-01", "123"));
        list3.add(g2.new WeiXiu("a", "a", "2017-05-01", "123"));
        g2.setWx(list3);
        
        ArrayList<LingYong> list4 = new ArrayList<LingYong>();
        list4.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "a"));
        list4.add(g1.new LingYong("a", "a", "2017-05-01", "wangopan", "wagnqc", "a"));
        g2.setLy(list4);
        
        
      
        
        
        
        List<Goods> list5 = new ArrayList<Goods>();
        list5.add(g1);
        list5.add(g2);
        
        String s = JSON.toJSONString(list5);
        //JSONArray ja = JSONArray.fromObject(list);
        
        
        // 创建json跟对象的子对象，里面存放对个实体类的值的json数组   
        
        try {
			PrintWriter pw = response.getWriter();
			pw.print(s);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
        
		
	}
	
	
	
}
