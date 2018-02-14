package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import entity.ComicBean;
import entity.ComicTypeBean;
import entity.ComicUserBean;

public class ComicDao {
	HibernateTemplate template;
	Session session;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public List<ComicBean> getComicList(){
		//List<ComicBean> clist = template.loadAll(ComicBean.class);
		List<ComicBean> clist = template.find("from ComicBean");
		return clist;
	}
	
	public List<ComicTypeBean> getComicTypeList(){
		//List<ComicTypeBean> tList = template.loadAll(ComicTypeBean.class);
		List<ComicTypeBean> tList = template.find("from ComicTypeBean");
		return tList;
	}
	
	public void insertUser(ComicUserBean userbean){
		template.save(userbean);
	}
	
	@SuppressWarnings("unchecked")
	public List<ComicUserBean> loginUser(ComicUserBean userBean){
//		session = template.getSessionFactory().openSession();
//		
//		Query query = session.createQuery("from ComicUserBean c where c.userName='"+userBean.getUserName()+"' and c.userPassword='"+userBean.getUserPassword()+"'");
//		
//		List<ComicUserBean> clist = query.list();
		
		//session.close();
		//return new ComicUserBean("บร", "บร");
		//System.out.println(userBean.toString());
//		String hql = "from ComicUserBean where userName=? and userPassword=?";
//		String hql ="from ComicUserBean c where c.userName=? and c.userPassword=?";
		
//		List<ComicUserBean> cList = template.find(hql,userBean.getUserName(),userBean.getUserPassword());
		List<ComicUserBean> cList = template.find("from ComicUserBean c where c.userName='"+userBean.getUserName()+"' and c.userPassword='"+userBean.getUserPassword()+"'");
//		for (int i = 0; i < cList.size(); i++) {
//			System.out.println(cList.get(i).getUserName());
//		}
		return cList;
		
	}
}
