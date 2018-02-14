package com.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.JdDao;

public class JdDaoImpl implements JdDao {

	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/* (non-Javadoc)
	 * @see com.dao.JdDao#findByIdJd()
	 */
	@SuppressWarnings("unchecked")
	public List findByIdJd(int jdid) {
		// TODO Auto-generated method stub
		String queryString = "from Jd where jdid=?";
		List find = template.find(queryString, jdid);
		return find;
	}

	@SuppressWarnings("unchecked")
	public List findByQxId(int qxid) {
		// TODO Auto-generated method stub
		String queryString = "from Jd where qxid=?";
		List find = template.find(queryString, qxid);
		return find;
	}

}
