package com.filter;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings({ "serial", "unused" })
public class MyInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		//ActionContext context = invocation.getInvocationContext();
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			String method = request.getMethod();
			if("GET".equals(method)) {
				Map<String,String[]> map = request.getParameterMap();
				Set<String> keys = map.keySet();
				for (String key : keys) {
					String[] vals = map.get(key);
					for (int i = 0; i <vals.length; i++) {
						vals[i]=new String(vals[i].getBytes("iso-8859-1"),"utf-8");
					}
				}
				
			}else {
				request.setCharacterEncoding("utf-8");
			}
			
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			
			
			 
		return invocation.invoke();
	}

}
