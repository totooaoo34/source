package com.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.FwxxDao;
import com.entity.Fwxx;

/**
 * @author Administrator 房屋信息dao接口实现类
 */
public class FwxxDaoImpl implements FwxxDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.FwxxDao#findAllFwxx()
	 */
	@SuppressWarnings("unchecked")
	public List<Fwxx> findAllFwxx() {
		// TODO Auto-generated method stub
		String queryString = "from Fwxx";
		List<Fwxx> list = template.find(queryString);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.FwxxDao#delByIdFwxx(int)
	 */
	public void delByIdFwxx(int fwid) {
		// TODO Auto-generated method stub
		Fwxx fwxx = template.get(Fwxx.class, fwid);
		template.delete(fwxx);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.FwxxDao#upByIdFwxx(int)
	 */
	public void upByIdFwxx(Fwxx fwxx) {
		// TODO Auto-generated method stub
		template.update(fwxx);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.FwxxDao#findByIdFwxx()
	 */
	@SuppressWarnings("unchecked")
	public List findByIdFwxx(int fwid) {
		// TODO Auto-generated method stub
		String queryString = "from Fwxx where fwid=?";
		return template.find(queryString, fwid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.FwxxDao#addPublish(com.entity.Fwxx)
	 */
	public boolean addPublish(Fwxx fwxx) {
		// TODO Auto-generated method stub
		Serializable save = template.save(fwxx);
		if (save != null)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	public List findByUidFwxx(String uid) {
		// TODO Auto-generated method stub
		String queryString = null;
		if (uid != null && !"".equals(uid)) {
			queryString = "from Fwxx where uid=?";
			return template.find(queryString, Integer.parseInt(uid));
		} else {
			return null;
		}
	}

}
