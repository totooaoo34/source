package com.dao;

import java.util.List;

import com.entity.Fwlx;

/**
 * @author Administrator ��������
 * 
 */
public interface FwlxDao {

	/**
	 * ��ѯ���з�������
	 */
	public abstract List<Fwlx> findAllFwlx();
	
	/**
	 * ����ID��ѯ��������
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdFwlx(int lxid);
	
}
