package com.service;

import java.util.List;

import com.entity.Fwlx;

/**
 * @author Administrator ��������
 */
public interface FwlxService {

	/**
	 * ��ѯ���з�������
	 */
	public List<Fwlx> findAllFwlx();
	
	/**
	 * ����ID��ѯ��������
	 */
	public Fwlx findByIdFwlx(int lxid);

}
