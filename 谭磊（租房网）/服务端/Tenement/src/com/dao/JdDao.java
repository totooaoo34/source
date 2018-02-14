package com.dao;

import java.util.List;

/**
 * @author Administrator 街道
 * 
 */
public interface JdDao {

	/**
	 * 根据jdid查询街道
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdJd(int jdid);
	
	/**
	 * 根据qxid查询街道
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByQxId(int qxid);
}
