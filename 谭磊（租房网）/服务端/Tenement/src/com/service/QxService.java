package com.service;

import java.util.List;

import com.entity.Qx;

/**
 * @author Administrator 区县service层
 */
public interface QxService {

	/**
	 *查询所有区县
	 */
	public List<Qx> findAllQx();
	/**
	 *根据qxid查询区县
	 */
	public Qx findByIdQx(int qxid);
}
