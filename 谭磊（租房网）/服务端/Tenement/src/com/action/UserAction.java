package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.User;
import com.json.UserJSON;
import com.service.UserService;

/**
 * @author Administrator user���Ʋ�
 */
public class UserAction {

	/** �û�service **/
	private UserService userService;
	/** �û����� **/
	private User user;
	private String imgName;
	private File pic;
	private List<User> users;

	HttpServletResponse response;
	HttpServletRequest request;
	HttpSession session;
	PrintWriter out;
	UserJSON userJSON;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	/**
	 * �û�ע��
	 * 
	 * @return �ɹ�����index��ҳ,ʧ�ܽ���ע��ҳ��
	 */
	public String userAdd() {

		String path = ServletActionContext.getServletContext().getRealPath("/");
		File file = new File(path + "/user_img/" + imgName + ".jpg");
		// ��װ���������
		try {
			InputStream is = new FileInputStream(pic);
			OutputStream out = new FileOutputStream(file);
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = is.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			out.close();
			is.close();
			FileUtils.copyFile(pic, file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setUimg(imgName + ".jpg");
		userService.userAdd(user);
		return "login";
	}
	
	/**
	 * ע��
	 */
	public String userClose() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		//ÿһ��ע�� ����������汣���sessionid��
		if(session.getAttribute("user")!=null){
		session.removeAttribute("user");
		user.setUsessionid("");
		userService.userUpdate(user);
		}
		// PS:���д��벢û����������session,�������¸�ֵΪ��
		@SuppressWarnings("unused")
		Object s = session.getAttribute("user");
		s = null;
		return "login";
	}

	/**************************************�û���¼********************************************/
	/**
	 * ��ҳ���û���¼
	 * 
	 * @return to be or not to be
	 */
	public String userLogin() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		user = userService.userLogin(user);
		//ÿһ�ε�¼ ����������汣���sessionid��
		user.setUsessionid(null);
		userService.userUpdate(user);
		if (user != null) {
				user.setUsessionid(session.getId());
				userService.userUpdate(user);
			session.setAttribute("user", user);
			return "index";
		} else {
			return "fail";
		}
	}

	/**
	 * �ֻ���ɨ����ҳ���ѵ�¼���û��Ķ�ά��
	 */
	public String inntQRCodeLogin() throws IOException {
		request=ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		out = response.getWriter();
		String sessionid = request.getParameter("sessionid");
		System.out.println("���˵�¼..ID����" + sessionid);
		User u = userService.userQRCodeLogin(sessionid);
		userJSON = new UserJSON();
		String json = userJSON.loginJson(u);
		System.out.println("JSON..:"+json);
		out.write(json);
		out.flush();
		out.close();
		return null;
	}
	
	public String inntClienLogin() throws IOException{
		request=ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		out = response.getWriter();
		
		String ulogin = request.getParameter("ulogin");
		String upass=request.getParameter("upass");
		
		User u = new User();
		u.setUlogin(ulogin);//��¼��
		u.setUpass(upass);
		
		user = userService.userLogin(u);
		userJSON = new UserJSON();
		String json = userJSON.loginJson(user);
		
		out.write(json);
		out.flush();
		out.close();
		return null;
	}
}
