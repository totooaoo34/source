package com.serviceImpl;

import java.util.List;

import com.dao.FwlxDao;
import com.entity.Fwlx;
import com.service.FwlxService;

/**
 * @author Administrator ∑øŒ›¿‡–Õ
 * 
 */
public class FwlxServiceImpl implements FwlxService {

	private FwlxDao fwlxDao;

	public void setFwlxDao(FwlxDao fwlxDao) {
		this.fwlxDao = fwlxDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.FwlxService#findAllFwlx()
	 */
	public List<Fwlx> findAllFwlx() {
		// TODO Auto-generated method stub
		List<Fwlx> fwlxs = fwlxDao.findAllFwlx();
		return fwlxs;
	}

	/* (non-Javadoc)
	 * @see com.service.FwlxService#findByIdFwlx()
	 */
	@SuppressWarnings("unchecked")
	public Fwlx findByIdFwlx(int lxid) {
		// TODO Auto-generated method stub
		List<Fwlx> list = fwlxDao.findByIdFwlx(lxid);
		Fwlx fwlx = new Fwlx();
		for (int i = 0; i < list.size(); i++) {
			fwlx=list.get(i);
		}
		return fwlx;
	}

}
