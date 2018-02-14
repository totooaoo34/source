package com.dao;

import java.util.List;

import com.entity.Qx;

/**
 * @author Administrator 区县
 * 
 */
public interface QxDao {

	/**
	 * 查询所有区县
	 */
	public abstract List<Qx> findAllQx();
	/**
	 * 根据qxid查询区县
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdQx(int qxid);
}
