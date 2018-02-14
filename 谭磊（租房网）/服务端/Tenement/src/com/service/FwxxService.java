package com.service;

import java.util.List;

import com.entity.Fwxx;
import com.entity.Qx;

/**
 * @author Administrator ������Ϣservice��
 */
public interface FwxxService {

	/**
	 * ��ѯ���з�����Ϣ
	 * 
	 * @return ������Ϣ����
	 */
	public List<Fwxx> findAllFwxx();

	/**
	 * ����fwidɾ��
	 * 
	 * @param id
	 *            ����id
	 */
	public void delByIdFwxx(int fwid);

	/**
	 * ����fwid����
	 * 
	 * @param fwid
	 *            ����id
	 */
	public void upByIdFwxx(Fwxx fwxx);

	/**
	 * ����fwid��ѯ����
	 * 
	 * @param fwid
	 *            ����id
	 */
	public Fwxx findByIdFwxx(int fwid);

	/**
	 * ��ѯ��������
	 */
	public List<Qx> findAllQx();

	/**
	 * ��ӷ�����Ϣ
	 * 
	 * @param fwxx
	 *            ������Ϣ
	 */
	public Boolean addPublish(Fwxx fwxx);
	
	public List<Fwxx> findByUidFwxx(String uid);
}
