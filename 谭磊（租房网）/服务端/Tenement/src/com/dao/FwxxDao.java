package com.dao;

import java.util.List;

import com.entity.Fwxx;

/**
 * @author Administrator ������Ϣ
 */
public interface FwxxDao {

	/**
	 * ��ѯ���з�����Ϣ
	 * 
	 * @return ������Ϣ����
	 */
	public abstract List<Fwxx> findAllFwxx();

	/**
	 * ������Ϣɾ��
	 * 
	 * @param id
	 *            ����fwidɾ��
	 */
	public abstract void delByIdFwxx(int fwid);

	/**
	 * ������Ϣ�޸�
	 * 
	 * @param id
	 *            ����fwid�޸�
	 */
	public abstract void upByIdFwxx(Fwxx fwxx);

	/**
	 * ������Ϣ�����ѯ
	 * 
	 * @param fwid
	 *            ����id
	 */
	@SuppressWarnings("unchecked")
	public abstract List findByIdFwxx(int fwid);

	/**
	 * ��ӷ���������Ϣ
	 * 
	 * @param fwxx
	 *            ������Ϣ
	 * @return �ɹ�ʧ��
	 */
	public abstract boolean addPublish(Fwxx fwxx);
	
	@SuppressWarnings("unchecked")
	public abstract List findByUidFwxx(String uid);
}
