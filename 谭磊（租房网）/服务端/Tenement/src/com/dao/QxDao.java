package com.dao;

import java.util.List;

import com.entity.Qx;

/**
 * @author Administrator ����
 * 
 */
public interface QxDao {

	/**
	 * ��ѯ��������
	 */
	public abstract List<Qx> findAllQx();
	/**
	 * ����qxid��ѯ����
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdQx(int qxid);
}
