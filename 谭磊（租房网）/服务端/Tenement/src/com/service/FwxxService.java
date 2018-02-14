package com.service;

import java.util.List;

import com.entity.Fwxx;
import com.entity.Qx;

/**
 * @author Administrator 房屋信息service层
 */
public interface FwxxService {

	/**
	 * 查询所有房屋信息
	 * 
	 * @return 房屋信息集合
	 */
	public List<Fwxx> findAllFwxx();

	/**
	 * 根据fwid删除
	 * 
	 * @param id
	 *            房屋id
	 */
	public void delByIdFwxx(int fwid);

	/**
	 * 根据fwid更新
	 * 
	 * @param fwid
	 *            房屋id
	 */
	public void upByIdFwxx(Fwxx fwxx);

	/**
	 * 根据fwid查询单个
	 * 
	 * @param fwid
	 *            房屋id
	 */
	public Fwxx findByIdFwxx(int fwid);

	/**
	 * 查询所有区县
	 */
	public List<Qx> findAllQx();

	/**
	 * 添加房屋信息
	 * 
	 * @param fwxx
	 *            房屋信息
	 */
	public Boolean addPublish(Fwxx fwxx);
	
	public List<Fwxx> findByUidFwxx(String uid);
}
