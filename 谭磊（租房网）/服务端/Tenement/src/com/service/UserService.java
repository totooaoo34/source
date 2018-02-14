package com.service;

import com.entity.User;

/**
 * @author Administrator �û�service��
 */
public interface UserService {

	/**
	 * �û���¼
	 * 
	 * @param user
	 *            �û�����
	 * @return
	 */
	public User userLogin(User user);

	/**
	 * �û�ע��
	 * 
	 * @param user
	 *            �û�����
	 * @return
	 */
	public Boolean userAdd(User user);

	public void userUpdate(User user);

	/**
	 * ��ά���¼
	 * 
	 * @param user
	 * @return
	 */
	public User userQRCodeLogin(String sid);

}
