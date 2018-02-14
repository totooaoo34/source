package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.dao.Chenshi_Dao;
import com.entity.Ai_student;
import com.entity.Chengshi_1;
import com.entity.Chengshi_2;
import com.entity.Chengshi_3;

public class Chengshi_Action {
	private HttpServletRequest request;
	private HttpServletResponse response;

	private Chenshi_Dao dao;

	public void setDao(Chenshi_Dao dao) {
		this.dao = dao;
	}

	public void findchengshi_1() {

		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();

		List<Chengshi_1> chengshi_1list = dao.findAll_Chengshi_1();
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONObject root = new JSONObject();
			JSONArray jsonlist = new JSONArray();
			for (int i = 0; i < chengshi_1list.size(); i++) {
				Chengshi_1 chengshi_1 = chengshi_1list.get(i);
				JSONObject data = new JSONObject();
				data.put("cs1_id", chengshi_1.getCs1_id());
				data.put("cs_name", chengshi_1.getCs_name());
				jsonlist.add(data);
			}
			root.put("chengshi1_list", jsonlist);
			out.println(root.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findchengshi_2() {

		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		int cs1_id = Integer.parseInt(request.getParameter("cs1_id"));
		List<Chengshi_2> chengshi_1list = dao.findAll_Chengshi_2(cs1_id);
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONObject root = new JSONObject();
			JSONArray jsonlist = new JSONArray();
			for (int i = 0; i < chengshi_1list.size(); i++) {
				Chengshi_2 chengshi_2 = chengshi_1list.get(i);
				JSONObject data = new JSONObject();
				data.put("cs1_id", chengshi_2.getCs1_id());
				data.put("cs2_id", chengshi_2.getCs2_id());
				data.put("cs2_name", chengshi_2.getCS2_name());
				jsonlist.add(data);
			}
			root.put("chengshi2_list", jsonlist);
			out.println(root.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findchengshi_3() {

		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		int cs1_id = Integer.parseInt(request.getParameter("cs1_id"));
		int cs2_id = Integer.parseInt(request.getParameter("cs2_id"));
		List<Chengshi_3> chengshi_1list = dao.findAll_Chengshi_3(cs1_id,cs2_id);
		PrintWriter out;
		try {
			out = response.getWriter();

			JSONObject root = new JSONObject();
			JSONArray jsonlist = new JSONArray();
			for (int i = 0; i < chengshi_1list.size(); i++) {
				Chengshi_3 chengshi_3 = chengshi_1list.get(i);
				JSONObject data = new JSONObject();
				data.put("cs1_id", chengshi_3.getCs1_id());
				data.put("cs2_id", chengshi_3.getCs2_id());
				data.put("cs3_id", chengshi_3.getCs3_id());
				data.put("cs3_name", chengshi_3.getCs3_name());
				jsonlist.add(data);
			}
			root.put("chengshi3_list", jsonlist);
			out.println(root.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
