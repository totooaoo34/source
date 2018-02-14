package com.dao;

import java.util.List;

import com.entity.Fwlx;

/**
 * @author Administrator 房屋类型
 * 
 */
public interface FwlxDao {

	/**
	 * 查询所有房屋类型
	 */
	public abstract List<Fwlx> findAllFwlx();
	
	/**
	 * 根据ID查询房屋类型
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdFwlx(int lxid);
	
}
