package com.serviceImpl;

import java.util.List;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

/**
 * @author Administrator
 * 
 */
public class UserServiceImpl implements UserService {

	private UserDao dao;

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.UserService#userLogin(com.entity.User)
	 */
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		List<User> userLogin = dao.userLogin(user);
		User u = new User();
		for (int i = 0; i < userLogin.size(); i++) {
			u = userLogin.get(i);
		}
		return u;
	}
	
	public User userQRCodeLogin(String sid){
		List<User> login = dao.userQRLogin(sid);
		User u = new User();
		for (int i = 0; i < login.size(); i++) {
			u = login.get(i);
		}
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.UserService#userAdd(com.entity.User)
	 */
	public Boolean userAdd(User user) {
		// TODO Auto-generated method stub
		boolean flag = dao.userAdd(user);
		return flag;
	}

	public void userUpdate(User user) {
		// TODO Auto-generated method stub
		dao.userUpdate(user);
	}
	
	

}
