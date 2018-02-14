package com.serviceImpl;

import java.util.List;

import com.dao.JdDao;
import com.entity.Jd;
import com.service.JdService;

public class JdServiceImpl implements JdService {

	private JdDao jdDao;

	public void setJdDao(JdDao jdDao) {
		this.jdDao = jdDao;
	}

	@SuppressWarnings("unchecked")
	public Jd findByIdJd(int jdid) {
		// TODO Auto-generated method stub
		List<Jd> list = jdDao.findByIdJd(jdid);
		Jd jd = new Jd();
		for (int i = 0; i < list.size(); i++) {
			jd = list.get(i);
		}
		return jd;
	}

	@SuppressWarnings("unchecked")
	public List<Jd> findByQxId(int qxid) {
		// TODO Auto-generated method stub
		List<Jd> list = jdDao.findByQxId(qxid);
		return list;
	}

}
