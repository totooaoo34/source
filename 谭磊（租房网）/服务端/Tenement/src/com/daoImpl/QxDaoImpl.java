package com.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.QxDao;
import com.entity.Qx;

/**
 * @author Administrator ÇøÏØ
 */
public class QxDaoImpl implements QxDao {

	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.QxDao#findAllQx()
	 */
	@SuppressWarnings("unchecked")
	public List<Qx> findAllQx() {
		// TODO Auto-generated method stub
		List<Qx> qxs = template.find("from Qx");
		return qxs;
	}

	/* (non-Javadoc)
	 * @see com.dao.QxDao#findByIdQx()
	 */
	@SuppressWarnings("unchecked")
	public List findByIdQx(int qxid) {
		// TODO Auto-generated method stub
		String queryString = "from Qx where qxid=?";
		List find = template.find(queryString, qxid);
		return find;
	}

}
