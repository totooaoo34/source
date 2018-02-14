package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Ai_student;
import com.entity.Post_a_message;
import com.entity.Red_list;

public class Ai_student_Dao {
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	//²éÑ¯È«²¿
	public List<Ai_student> FindAll_Post_a_message(){
		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		String hql="from Ai_student";
		Query query = session.createQuery(hql);
		List<Ai_student> list = query.list();
		return list;
	}
}
