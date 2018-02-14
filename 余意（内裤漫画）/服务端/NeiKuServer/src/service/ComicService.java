package service;

import java.util.List;

import dao.ComicDao;
import entity.ComicBean;
import entity.ComicTypeBean;
import entity.ComicUserBean;

public class ComicService {
	
	private ComicDao comicDao;

	public List<ComicBean> cList;
	
	public List<ComicTypeBean> tList;
	
	public ComicUserBean userBean;
	
	public List<ComicUserBean> uList;
	
	
	
	public List<ComicUserBean> getuList() {
		return uList;
	}

	public void setuList(List<ComicUserBean> uList) {
		this.uList = uList;
	}

	public ComicDao getComicDao() {
		return comicDao;
	}
	
	public void setComicDao(ComicDao comicDao) {
		this.comicDao = comicDao;
	}
	
	public List<ComicBean> getcList() {
		return cList;
	}

	public void setcList(List<ComicBean> cList) {
		this.cList = cList;
	}
	
	public List<ComicTypeBean> gettList() {
		return tList;
	}

	public void settList(List<ComicTypeBean> tList) {
		this.tList = tList;
	}

	public ComicUserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(ComicUserBean userBean) {
		this.userBean = userBean;
	}

	public List<ComicBean> getComicList(){
		return comicDao.getComicList();
	}
	
	public List<ComicTypeBean> getComicTypeList(){
		return comicDao.getComicTypeList();
	}
	
	public void insertUser(ComicUserBean userbean){
		comicDao.insertUser(userbean);
	}
	
	public List<ComicUserBean> loginUser(ComicUserBean userBean){
		return comicDao.loginUser(userBean);
	}
}
