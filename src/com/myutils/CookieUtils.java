package com.myutils;

import java.util.List;

import javax.servlet.http.Cookie;

import net.sf.json.JSONArray;

import com.entity.QuanXian;

public class CookieUtils {
	/**
	 * 构造方法
	 */
	public CookieUtils() {
		super();
	}
	
	public static final String quanxian_cookie = "quanxian_cookie";
	
	 // 增加cookie
    public static Cookie addCookie(List<QuanXian> usersquanxianlist) {
    	
    	JSONArray ja = JSONArray.fromObject(usersquanxianlist);
    	String quanxianJson =  ja.toString();
    	
        Cookie cookie = new Cookie(quanxian_cookie,quanxianJson);
        cookie.setMaxAge(60 * 60 * 24);
        return cookie;
    }
	
	
	
}
