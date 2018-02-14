package com.serviceImpl;

import java.util.List;

import com.dao.QxDao;
import com.entity.Qx;
import com.service.QxService;

/**
 * @author Administrator 区县service业务类
 * 
 */
public class QxServiceImpl implements QxService {

	public QxDao qxDao;

	public void setQxDao(QxDao qxDao) {
		this.qxDao = qxDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.QxService#findAllQx()
	 */
	public List<Qx> findAllQx() {
		// TODO Auto-generated method stub
		List<Qx> qx = qxDao.findAllQx();
		return qx;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.QxService#findByIdQx()
	 */
	@SuppressWarnings("unchecked")
	public Qx findByIdQx(int qxid) {
		// TODO Auto-generated method stub
		List<Qx> list = qxDao.findByIdQx(qxid);
		Qx qx = new Qx();
		for (int i = 0; i < list.size(); i++) {
			qx = list.get(i);
		}
		return qx;
	}

}
