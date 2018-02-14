package com.serviceImpl;

import java.util.List;

import com.dao.FwxxDao;
import com.dao.QxDao;
import com.entity.Fwxx;
import com.entity.Qx;
import com.service.FwxxService;

/**
 * @author Administrator ·¿ÎÝÐÅÏ¢
 *
 */
public class FwxxServiceImpl implements FwxxService {

	private FwxxDao dao;
	private QxDao qxDao;


	public void setQxDao(QxDao qxDao) {
		this.qxDao = qxDao;
	}

	public void setDao(FwxxDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.FwxxService#findAllFwxx()
	 */
	public List<Fwxx> findAllFwxx() {
		// TODO Auto-generated method stub
		return dao.findAllFwxx();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.FwxxService#delByIdFwxx(int)
	 */
	public void delByIdFwxx(int id) {
		// TODO Auto-generated method stub
		dao.delByIdFwxx(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.FwxxService#upByIdFwxx(int)
	 */
	public void upByIdFwxx(Fwxx fwxx) {
		// TODO Auto-generated method stub
		dao.upByIdFwxx(fwxx);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.FwxxService#findByIdFwxx(int)
	 */
	@SuppressWarnings("unchecked")
	public Fwxx findByIdFwxx(int fwid) {
		// TODO Auto-generated method stub
		List<Fwxx> fwxxs = dao.findByIdFwxx(fwid);
		Fwxx fwxx = new Fwxx();
		for (int i = 0; i < fwxxs.size(); i++) {
			fwxx = fwxxs.get(i);
		}
		return fwxx;
	}

	/* (non-Javadoc)
	 * @see com.service.FwxxService#findAllQx()
	 */
	public List<Qx> findAllQx() {
		List<Qx> qx = qxDao.findAllQx();
		return qx;
	}

	/* (non-Javadoc)
	 * @see com.service.FwxxService#addPublish(com.entity.Fwxx)
	 */
	public Boolean addPublish(Fwxx fwxx) {
		// TODO Auto-generated method stub
		boolean flag = dao.addPublish(fwxx);
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Fwxx> findByUidFwxx(String uid) {
		// TODO Auto-generated method stub
		List<Fwxx> list = dao.findByUidFwxx(uid);
		return list;
	}

}
