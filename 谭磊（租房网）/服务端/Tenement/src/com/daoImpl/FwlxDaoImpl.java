package com.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.FwlxDao;
import com.entity.Fwlx;

/**
 * @author Administrator ∑øŒ›¿‡–Õ
 * 
 */
public class FwlxDaoImpl implements FwlxDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.FwlxDao#findAllFwlx()
	 */
	@SuppressWarnings("unchecked")
	public List<Fwlx> findAllFwlx() {
		// TODO Auto-generated method stub
		List<Fwlx> fwlxs = template.find("from Fwlx");
		return fwlxs;
	}

	/* (non-Javadoc)
	 * @see com.dao.FwlxDao#findByIdFwlx(int)
	 */
	@SuppressWarnings("unchecked")
	public List findByIdFwlx(int lxid) {
		// TODO Auto-generated method stub
		String queryString="from Fwlx where lxid=?";
		List find = template.find(queryString, lxid);
		return find;
	}

}
