package com.service;

import java.util.List;

import com.entity.Jd;

/**
 * @author Administrator 街道
 *
 */
public interface JdService {

	/**
	 * 根据jdid查询
	 */
	public Jd findByIdJd(int jdid);
	
	/**
	 * 根据qxid查询
	 */
	public List<Jd> findByQxId(int qxid);
}
