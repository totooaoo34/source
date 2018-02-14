package com.dao;

import java.util.List;

import com.entity.User;

/**
 * @author Administrator �û�
 */
public interface UserDao {

	/**
	 * �û���¼
	 * 
	 * @param user
	 *            �û�ʵ��
	 * @return �û�ʵ�弯��
	 */
	public abstract List<User> userLogin(User user);

	/**
	 * �û�ע��
	 * 
	 * @param user
	 *            �û�ʵ��
	 * @return
	 */
	public abstract boolean userAdd(User user);
	
	public abstract void userUpdate(User user);
	public abstract List<User> userQRLogin(String sid);

}
