package com.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Post_a_message;

public class Post_a_message_Dao {
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	//查询全部
	public List<Post_a_message> FindAll_Post_a_message(){
		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		String hql="from Post_a_message";
		Query query = session.createQuery(hql);
		List<Post_a_message> list = query.list();
		return list;
	}
	//添加
	public int save_Post_a_message(Post_a_message p){
		try{
			template.save(p);
			return 1;
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	//删除
	public int Delect_Post_a_message(int id){
		try{
			Post_a_message p = template.get(Post_a_message.class, id);
				template.delete(p);
			return 1;
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	//根据ID查询单个
	public Post_a_message findBy_post_id(int id){
		Post_a_message p = template.get(Post_a_message.class, id);
		return p;
	}
	
	
}
