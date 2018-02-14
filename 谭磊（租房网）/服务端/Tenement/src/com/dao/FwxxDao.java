package com.dao;

import java.util.List;

import com.entity.Fwxx;

/**
 * @author Administrator 房屋信息
 */
public interface FwxxDao {

	/**
	 * 查询所有房屋信息
	 * 
	 * @return 房屋信息集合
	 */
	public abstract List<Fwxx> findAllFwxx();

	/**
	 * 房屋信息删除
	 * 
	 * @param id
	 *            根据fwid删除
	 */
	public abstract void delByIdFwxx(int fwid);

	/**
	 * 房屋信息修改
	 * 
	 * @param id
	 *            根据fwid修改
	 */
	public abstract void upByIdFwxx(Fwxx fwxx);

	/**
	 * 房屋信息详情查询
	 * 
	 * @param fwid
	 *            房屋id
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdFwxx(int fwid);

	/**
	 * 添加发布房屋信息
	 * 
	 * @param fwxx
	 *            房屋信息
	 * @return 成功失败
	 */
	public abstract boolean addPublish(Fwxx fwxx);
	
	@SuppressWarnings("unchecked")
	public abstract List findByUidFwxx(String uid);
}
