package com.service;

import java.util.List;

import com.entity.Jd;

/**
 * @author Administrator �ֵ�
 *
 */
public interface JdService {

	/**
	 * ����jdid��ѯ
	 */
	public Jd findByIdJd(int jdid);
	
	/**
	 * ����qxid��ѯ
	 */
	public List<Jd> findByQxId(int qxid);
}
