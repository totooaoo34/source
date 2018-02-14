package com.service;

import java.util.List;

import com.entity.Fwlx;

/**
 * @author Administrator 房屋类型
 */
public interface FwlxService {

	/**
	 * 查询所有房屋类型
	 */
	public List<Fwlx> findAllFwlx();
	
	/**
	 * 根据ID查询房屋类型
	 */
	public Fwlx findByIdFwlx(int lxid);

}
