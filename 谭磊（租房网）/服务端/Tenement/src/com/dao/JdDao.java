package com.dao;

import java.util.List;

/**
 * @author Administrator �ֵ�
 * 
 */
public interface JdDao {

	/**
	 * ����jdid��ѯ�ֵ�
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdJd(int jdid);
	
	/**
	 * ����qxid��ѯ�ֵ�
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByQxId(int qxid);
}
