package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.dao.Ai_user_Dao;
import com.dao.Post_a_message_Dao;
import com.entity.Ai_user;
import com.entity.Post_a_message;

public class Post_a_message_Action {
	private Post_a_message_Dao dao;
	private Ai_user_Dao Ai_user_dao;
	
	private HttpServletRequest request;
	private HttpServletResponse response;

	
	public void setAi_user_dao(Ai_user_Dao aiUserDao) {
		Ai_user_dao = aiUserDao;
	}

	public void setDao(Post_a_message_Dao dao) {
		this.dao = dao;
	}

	//查询全部
	public String findAll() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		List<Post_a_message> list = dao.FindAll_Post_a_message();
		try {
			PrintWriter out = response.getWriter();
			JSONObject root = new JSONObject();
			JSONArray jsonlist = new JSONArray();
			for (int i = 0; i < list.size(); i++) {
				Post_a_message p=list.get(i);
				JSONObject data = new JSONObject();
				
				Ai_user user1 = Ai_user_dao.findBy_Ai_userID(p.getU_id());
				data.put("User_id", user1.getUser_id());
				data.put("User_name", user1.getUser_name());
				data.put("User_headimage", user1.getUser_headimage());
				data.put("User_phone", user1.getUser_phone());
				data.put("User_password", user1.getUser_password());
				data.put("User_school", user1.getUser_school());
				
				data.put("Post_id", p.getPost_id());
				data.put("U_id", p.getU_id());
				data.put("Post_date", p.getPost_date());
				data.put("Post_message", p.getPost_message());
				jsonlist.add(data);
			}
			root.put("pamlist", jsonlist);
			out.println(root.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block Tenement
			e.printStackTrace();
		}
		return null;
	}

	// 添加帖子（未上传图片）
	public void insert() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			Post_a_message p=new Post_a_message();
			p.setPost_message(request.getParameter("Post_message"));
			p.setU_id(Integer.parseInt(request.getParameter("Ai_user_id")));
			p.setPost_date(request.getParameter("Post_date"));
			out.print(dao.save_Post_a_message(p));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//单个查询用户
	public void selectBy_Post_a_messageID(){
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			JSONObject data = new JSONObject();
			int Post_id=Integer.parseInt(request.getParameter("Post_id"));
			Post_a_message p = dao.findBy_post_id(Post_id);
			Ai_user user1 = Ai_user_dao.findBy_Ai_userID(p.getU_id());
			data.put("User_id", user1.getUser_id());
			data.put("User_name", user1.getUser_name());
			data.put("User_headimage", user1.getUser_headimage());
			data.put("User_phone", user1.getUser_phone());
			data.put("User_password", user1.getUser_password());
			data.put("User_school", user1.getUser_school());
			
			data.put("Post_id", p.getPost_id());
			data.put("U_id", p.getU_id());
			data.put("Post_date", p.getPost_date());
			data.put("Post_message", p.getPost_message());
			out.print(data.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除
	public void delete(){
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			int Post_id=Integer.parseInt(request.getParameter("Post_id"));
			out.print(dao.Delect_Post_a_message(Post_id));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
