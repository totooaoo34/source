package com.service;

import java.util.List;

import com.entity.Qx;

/**
 * @author Administrator ����service��
 */
public interface QxService {

	/**
	 *��ѯ��������
	 */
	public List<Qx> findAllQx();
	/**
	 *����qxid��ѯ����
	 */
	public Qx findByIdQx(int qxid);
}
