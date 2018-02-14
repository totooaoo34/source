package com.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.User;

/**
 * @author Administrator 用户接口实现类
 */
public class UserDaoImpl implements com.dao.UserDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.UserDao#userLogin(com.entity.User)
	 */
	@SuppressWarnings("unchecked")
	public List<User> userLogin(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where ulogin=? and upass=?";
		List<User> list = template.find(hql, user.getUlogin(), user.getUpass());
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.UserDao#userAdd(com.entity.User)
	 */
	public boolean userAdd(User user) {
		// TODO Auto-generated method stub
		Serializable save = template.save(user);
		if (save != null)
			return true;
		else
			return false;
	}

	public void userUpdate(User user) {
		// TODO Auto-generated method stub
		template.update(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> userQRLogin(String sid) {
		String hql = "from User where usessionid=?";
		List<User> list = template.find(hql, sid);
		return list;
	}

}
