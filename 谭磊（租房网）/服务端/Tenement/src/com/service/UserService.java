package com.service;

import com.entity.User;

/**
 * @author Administrator 用户service层
 */
public interface UserService {

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户对象
	 * @return
	 */
	public User userLogin(User user);

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户对象
	 * @return
	 */
	public Boolean userAdd(User user);

	public void userUpdate(User user);

	/**
	 * 二维码登录
	 * 
	 * @param user
	 * @return
	 */
	public User userQRCodeLogin(String sid);

}
