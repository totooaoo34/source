package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.Ai_user_Dao;
import com.entity.Ai_user;

public class Ai_user_Action {
	private Ai_user_Dao dao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public void setDao(Ai_user_Dao dao) {
		this.dao = dao;
	}

	// 登录查询
	public String findby() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		PrintWriter out = null;
		String cookieid = session.getId();
		String phnoe = request.getParameter("userphone");
		String psw = request.getParameter("userpassword");
		Ai_user user1 = dao.findAllAi_user(phnoe, psw);
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject data;
		// 成功的时候
		if (user1 != null) {
			data = new JSONObject();
			data.put("User_id", user1.getUser_id());
			data.put("User_name", user1.getUser_name());
			data.put("User_headimage", user1.getUser_headimage());
			data.put("User_phone", user1.getUser_phone());
			data.put("User_password", user1.getUser_password());
			data.put("User_school", user1.getUser_school());
			session.setAttribute("isLog", "success");
			out.println(data.toString());

		} else {// 失败的时候
			data = new JSONObject();
			data.put("code", 0);
			session.setAttribute("isLog", "fail");
			out.println();
		}

		// Cookie[] cookies = request.getCookies();
		// for(Cookie c:cookies){
		// System.out.println(c.getName()+"---"+c.getValue());
		// }

		return null;
	}

	// 添加用户
	public void insert_Ai_user() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			Ai_user user = new Ai_user();
			user.setUser_name(request.getParameter("User_name"));
			user.setUser_headimage(request.getParameter("User_headimage"));
			user.setUser_phone(request.getParameter("User_phone"));
			user.setUser_password(request.getParameter("User_password"));
			user.setUser_school(request.getParameter("User_school"));
			out.print(dao.save_Ai_user(user));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 修改用户密码
	public void updata_Ai_user() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			String shouji=request.getParameter("User_phone");
			String psw = request.getParameter("User_password");
			Ai_user user=dao.findBy_Ai_userhaoma(shouji);
			user.setUser_password(psw);
			if(user==null){
				out.print("修改失败");
			}else{
				dao.updata_Ai_user(user);
				out.print("修改成功");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 单个查询用户
	public void selectBy_Ai_userID() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			int userid = Integer.parseInt(request.getParameter("Ai_user_id"));
			Ai_user user1 = dao.findBy_Ai_userID(userid);

			JSONObject data = new JSONObject();
			data.put("User_id", user1.getUser_id());
			data.put("User_name", user1.getUser_name());
			data.put("User_headimage", user1.getUser_headimage());
			data.put("User_phone", user1.getUser_phone());
			data.put("User_password", user1.getUser_password());
			data.put("User_school", user1.getUser_school());
			out.println(data.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
