package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import entity.ComicBean;
import entity.ComicTypeBean;
import entity.ComicUserBean;
import service.ComicService;

public class ComicAction {

	private HttpServletResponse response = ServletActionContext.getResponse();

	private HttpServletRequest request = ServletActionContext.getRequest();

	private ComicService comicService;

	public ComicBean comicbean;

	List<ComicBean> cList;

	public List<ComicTypeBean> tList;

	public ComicUserBean userBean;
	
	public List<ComicUserBean> uList;
	
	
	public List<ComicUserBean> getuList() {
		return uList;
	}

	public void setuList(List<ComicUserBean> uList) {
		this.uList = uList;
	}

	public ComicUserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(ComicUserBean userBean) {
		this.userBean = userBean;
	}

	public ComicService getComicService() {
		return comicService;
	}

	public void setComicService(ComicService comicService) {
		this.comicService = comicService;
	}

	public ComicBean getComicbean() {
		return comicbean;
	}

	public void setComicbean(ComicBean comicbean) {
		this.comicbean = comicbean;
	}

	public List<ComicBean> getcList() {
		return cList;
	}

	public void setcList(List<ComicBean> cList) {
		this.cList = cList;
	}

	public List<ComicTypeBean> gettList() {
		return tList;
	}

	public void settList(List<ComicTypeBean> tList) {
		this.tList = tList;
	}

	public void getComicList() throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		cList = comicService.getComicList();
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < cList.size(); i++) {
			JSONObject data = new JSONObject();
			data.put("comicId", cList.get(i).getComicId());
			data.put("comicFmImgUrl", cList.get(i).getComicFmImgUrl());
			data.put("comicName", cList.get(i).getComicName());
			data.put("comicFmJiesao", cList.get(i).getComicFmJiesao());
			data.put("comicJqJiesao", cList.get(i).getComicJqJiesao());
			data.put("comicAuthor", cList.get(i).getComicAuthor());
			data.put("comicComat", cList.get(i).getComicComat());
			data.put("comicSource", cList.get(i).getComicSource());
			data.put("comicUpdateTime", cList.get(i).getComicUpdateTime());
			data.put("comicIma01Url", cList.get(i).getComicIma01Url());
			data.put("comicIma02Url", cList.get(i).getComicIma02Url());
			data.put("comicIma03Url", cList.get(i).getComicIma03Url());
			data.put("comicIma04Url", cList.get(i).getComicIma04Url());
			data.put("comicIma05Url", cList.get(i).getComicIma05Url());
			data.put("comicIma06Url", cList.get(i).getComicIma06Url());
			data.put("comicIma07Url", cList.get(i).getComicIma07Url());
			data.put("comicIma08Url", cList.get(i).getComicIma08Url());
			data.put("comicIma09Url", cList.get(i).getComicIma09Url());
			data.put("comicIma10Url", cList.get(i).getComicIma10Url());
			array.add(data);
		}
		root.put("comic_remeng", array);
		PrintWriter out = response.getWriter();
		out.print(root.toString());
		out.flush();
		out.close();
		System.out.println(root.toString());

		// return "getComicList";
		// return null;
	}

	// »ñÈ¡Âþ»­ÀàÐÍJson
	public void getComicTypeList() throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		tList = comicService.getComicTypeList();
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < tList.size(); i++) {
			JSONObject data = new JSONObject();
			data.put("typesId", tList.get(i).getTypesId());
			data.put("typeFmImgUrl", tList.get(i).getTypeFmImgUrl());
			data.put("typeName", tList.get(i).getTypeName());
			data.put("foreignId", tList.get(i).getForeignId());
			array.add(data);
		}

		root.put("comic_type", array);
		PrintWriter out = response.getWriter();
		out.print(root.toString());
		out.flush();
		out.close();
		System.out.println(root.toString());
	}

	public void postzhucexinxi() throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		InputStream is = request.getInputStream();
		// int count = -1;
		StringBuffer sb = new StringBuffer();
		// byte[] buff = new byte[2014];
		// while((count =is.read(buff))!=-1){
		// sb.append(buff.toString());
		// }
		// System.out.println(sb.toString());

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String[] user = sb.toString().split("/");
		ComicUserBean userbean = new ComicUserBean(user[0], user[1]);

		System.out.println("ÕÊºÅ£º" + user[0] + "----ÃÜÂë£º" + user[1]);
		comicService.insertUser(userbean);

		out.flush();
		out.close();

	}

	public void userLogin() throws IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		String sessionid = session.getId();

		PrintWriter out = response.getWriter();
		InputStream is = request.getInputStream();
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		String[] userLogin = sb.toString().split("/");
		System.out.println("ÕÊºÅ£º" + userLogin[0] + "----ÃÜÂë£º" + userLogin[1]+"sessionid:"+sessionid);
		
		// System.out.println("Ö°Î»  ");
		userBean = new ComicUserBean();
		userBean.setUserName(userLogin[0]);
		userBean.setUserPassword(userLogin[1]);
		uList = comicService.loginUser(userBean);
		if (uList.size()>0) {// µÇÂ¼³É¹¦
			// session.setAttribute("isLog", "success");
			System.out.println("µÇÂ¼³É¹¦");
			out.print(sessionid.toString());
		} else {
			// session.setAttribute("isLog", "fail");
			System.out.println("µÇÂ¼Ê§°Ü");
		}
		out.flush();
		out.close();

	}

}
