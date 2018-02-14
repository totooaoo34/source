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
 * @author Administrator user控制层
 */
public class UserAction {

	/** 用户service **/
	private UserService userService;
	/** 用户对象 **/
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
	 * 用户注册
	 * 
	 * @return 成功进入index主页,失败进入注册页面
	 */
	public String userAdd() {

		String path = ServletActionContext.getServletContext().getRealPath("/");
		File file = new File(path + "/user_img/" + imgName + ".jpg");
		// 包装输入的数据
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
	 * 注销
	 */
	public String userClose() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		//每一次注销 清空数据里面保存的sessionid号
		if(session.getAttribute("user")!=null){
		session.removeAttribute("user");
		user.setUsessionid("");
		userService.userUpdate(user);
		}
		// PS:上行代码并没有真正销毁session,所以重新赋值为空
		@SuppressWarnings("unused")
		Object s = session.getAttribute("user");
		s = null;
		return "login";
	}

	/**************************************用户登录********************************************/
	/**
	 * 网页端用户登录
	 * 
	 * @return to be or not to be
	 */
	public String userLogin() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		user = userService.userLogin(user);
		//每一次登录 清空数据里面保存的sessionid号
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
	 * 手机端扫描网页端已登录的用户的二维码
	 */
	public String inntQRCodeLogin() throws IOException {
		request=ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		out = response.getWriter();
		String sessionid = request.getParameter("sessionid");
		System.out.println("有人登录..ID号是" + sessionid);
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
		u.setUlogin(ulogin);//登录号
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
