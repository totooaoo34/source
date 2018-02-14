package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Chengshi_1;
import com.entity.Chengshi_2;
import com.entity.Chengshi_3;

public class Chenshi_Dao {
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	//查询城市1
	public List<Chengshi_1> findAll_Chengshi_1(){
		List<Chengshi_1> loadAll = template.loadAll(Chengshi_1.class);
		return loadAll;
	}
	
	//查询城市2
	public List<Chengshi_2> findAll_Chengshi_2(int CS1id){
		List<Chengshi_2> loadAll = template.find("from Chengshi_2 c where c.cs1_id =?",CS1id);
		return loadAll;
	}
	//查询城市3
	public List<Chengshi_3> findAll_Chengshi_3(int CS1id,int CS2id){
		List<Chengshi_3> loadAll = template.find("from Chengshi_3 c where c.cs1_id =? and c.cs2_id=?",CS1id,CS2id);
		return loadAll;
	}
}
