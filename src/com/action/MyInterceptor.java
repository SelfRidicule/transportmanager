package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.Users;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
//		创建请求对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		System.out.println("进入拦截器");
		
		Users users = (Users) session.getAttribute("users");
		
		if(users!=null && !"".equals(users)){
//			返回invocation.invoke()的值 ，表示通过拦截器继续往下走
			return invocation.invoke();
		}
//		返回的值会和struts.xml 里的 result标签里的name值进行匹配
		return "returnLogin";
			
	}

}
