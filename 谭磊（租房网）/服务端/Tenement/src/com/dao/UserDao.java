package com.dao;

import java.util.List;

import com.entity.User;

/**
 * @author Administrator 用户
 */
public interface UserDao {

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户实体
	 * @return 用户实体集合
	 */
	public abstract List<User> userLogin(User user);

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户实体
	 * @return
	 */
	public abstract boolean userAdd(User user);
	
	public abstract void userUpdate(User user);
	public abstract List<User> userQRLogin(String sid);

}
