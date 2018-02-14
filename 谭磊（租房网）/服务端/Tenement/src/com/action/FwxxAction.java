package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.Fwlx;
import com.entity.Fwxx;
import com.entity.Jd;
import com.entity.Qx;
import com.json.FwxxJSON;
import com.service.FwlxService;
import com.service.FwxxService;
import com.service.JdService;
import com.service.QxService;

/**
 * @author Administrator Fwxx控制层
 */
public class FwxxAction {

	/** 房屋信息service **/
	private FwxxService service;
	/** 区县service **/
	private QxService qxService;
	/** 街道service **/
	private JdService jdService;
	/** 房屋类型service **/
	private FwlxService fwlxService;

	/** 房屋信息集合对象 **/
	private List<Fwxx> fwxxs;
	/** 房屋信息实体对象 **/
	private Fwxx fwxx;
	/** 房屋信息id **/
	private int fwid;
	/** 区县集合 **/
	private List<Qx> qxs;
	/** 单个区县 **/
	private Qx qx;
	/** 单个街道 **/
	private Jd jd;
	/** JS中的ajax传来的qxid **/
	private int qxid;
	private List<Jd> jds;
	/** 房屋类型集合 **/
	private List<Fwlx> fwlxs;
	/** 房屋类型 **/
	private Fwlx fwlx;
	/** 照片名字 **/
	private String imgName;
	// 文件对象的名字与前台表单文件域的name一致
	private File pic;
	/** 管理我的租房信息传过来的UID **/
	private String uid;
	
	HttpServletResponse response;
	HttpServletRequest request;
	PrintWriter out;
	FwxxJSON util;

	public void setService(FwxxService service) {
		this.service = service;
	}

	public void setQxService(QxService qxService) {
		this.qxService = qxService;
	}

	public void setJdService(JdService jdService) {
		this.jdService = jdService;
	}

	public void setFwlxService(FwlxService fwlxService) {
		this.fwlxService = fwlxService;
	}

	public List<Qx> getQxs() {
		return qxs;
	}

	public void setQxs(List<Qx> qxs) {
		this.qxs = qxs;
	}

	public void setFwxxs(List<Fwxx> fwxxs) {
		this.fwxxs = fwxxs;
	}

	public List<Fwxx> getFwxxs() {
		return fwxxs;
	}

	public Fwxx getFwxx() {
		return fwxx;
	}

	public void setFwxx(Fwxx fwxx) {
		this.fwxx = fwxx;
	}

	public void setFwid(int fwid) {
		this.fwid = fwid;
	}

	public int getFwid() {
		return fwid;
	}

	public List<Fwlx> getFwlxs() {
		return fwlxs;
	}

	public void setFwlxs(List<Fwlx> fwlxs) {
		this.fwlxs = fwlxs;
	}

	public Qx getQx() {
		return qx;
	}

	public void setQx(Qx qx) {
		this.qx = qx;
	}

	public Jd getJd() {
		return jd;
	}

	public void setJd(Jd jd) {
		this.jd = jd;
	}

	public List<Jd> getJds() {
		return jds;
	}

	public void setJds(List<Jd> jds) {
		this.jds = jds;
	}

	public int getQxid() {
		return qxid;
	}

	public void setQxid(int qxid) {
		this.qxid = qxid;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Fwlx getFwlx() {
		return fwlx;
	}

	public void setFwlx(Fwlx fwlx) {
		this.fwlx = fwlx;
	}

	/**
	 * 查询所有房屋信息
	 */
	public String findAllFwxx() {
		fwxxs = service.findAllFwxx();
		return "index";
	}

	/**
	 * 管理我的租房信息
	 */
	public String findByUidFwxx() {
		fwxxs = service.findByUidFwxx(uid);
		return "utenement";
	}

	/**
	 * 根据fwid删除
	 */
	public String delByIdFwxx() {
		service.delByIdFwxx(fwid);
		return findAllFwxx();
	}

	/**
	 * 修改查询单个房屋信息
	 */
	public String findByIdFwxx() {
		// 查询所有房屋信息
		fwxx = service.findByIdFwxx(fwid);
		// 查询所有区县
		qxs = qxService.findAllQx();
		// 查询所有房屋类型
		fwlxs = fwlxService.findAllFwlx();
		// 1.查询出房屋信息中的jdId
		// 2.根据jdId查询查询街道表中的qxid
		// 3.返回修改时默认回显的区县对象
		jd = jdService.findByIdJd(fwxx.getJdid());
		qx = qxService.findByIdQx(jd.getQxid());
		jds = jdService.findByQxId(qx.getQxid());
		return "upmsg";
	}

	/**
	 * 查询单个信息
	 */
	public String findSingleFwxx() {
		fwxx = service.findByIdFwxx(fwid);// 房屋信息
		fwlx = fwlxService.findByIdFwlx(fwxx.getLxid());// 房屋类型
		jd = jdService.findByIdJd(fwxx.getJdid());// 街道
		qx = qxService.findByIdQx(jd.getQxid());// 区县
		return "single";
	}

	/**
	 * AJAX 点击区县二级联动街道
	 * 
	 */
	public String findByJd() {
		HttpServletResponse response = ServletActionContext.getResponse();
		jds = jdService.findByQxId(qxid);
		// ajax中的response文本
		String ajaxJd = "-请选择-,";
		String ajaxJdId = "0|";
		for (int i = 0; i < jds.size(); i++) {
			ajaxJd += jds.get(i).getJd() + ",";
			ajaxJdId += jds.get(i).getJdid() + "|";
		}
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(ajaxJd);
			out.print(ajaxJdId);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "upmsg";
	}

	/**
	 * 根据fwid修改
	 */
	public String upByIdFwxx() {
		service.upByIdFwxx(fwxx);
		return findByIdFwxx();
	}

	/**
	 * 发布租房信息时的回显
	 */
	public String publishSel() {
		qxs = qxService.findAllQx();// 查询所有区县
		fwlxs = fwlxService.findAllFwlx();// 查询所有房屋类型
		return "publish";
	}

	/**
	 * 发布租房信息
	 */
	public String addMessage() {
		// 获取系统当前时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		String str = dateFormat.format(curDate);
		fwxx.setDate(str);// 添加日期为系统当前时间
		fwxx.setImg(imgName + ".PNG");
		fwxx.setUid(Integer.parseInt(uid));
		service.addPublish(fwxx);
		// 寻找在tomcat中存放路径
		String path = ServletActionContext.getServletContext().getRealPath("/");
		File file = new File(path + "/house_img/" + imgName+".PNG");
		// 包装输入的数据
		try {
			InputStream is = new FileInputStream(pic);
			OutputStream out = new FileOutputStream(file);
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = is.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			out.close();
			is.close();
			FileUtils.copyFile(pic, file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findAllFwxx();
	}

	/************** 房屋信息Json *****************/
	public String inntFwxxJson() throws IOException {
		response = ServletActionContext.getResponse();
		out = response.getWriter();
		fwxxs = service.findAllFwxx();
		util = new FwxxJSON();
		String json = util.inntJson(fwxxs);
		out.write(json);
		out.flush();
		out.close();
		return null;
	}
	
	//单个详情信息
	public String inntFwxxByIdJson() throws IOException{
		request=ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		out = response.getWriter();
		Integer fwid = (Integer) request.getAttribute("fwid");
		fwxx = service.findByIdFwxx(fwid);// 房屋信息
		fwlx = fwlxService.findByIdFwlx(fwxx.getLxid());// 房屋类型
		jd = jdService.findByIdJd(fwxx.getJdid());// 街道
		qx = qxService.findByIdQx(jd.getQxid());// 区县
		
		util=new FwxxJSON();
		String json = util.fwxxByIdJson(fwxx, fwlx, jd, qx);
		out.write(json);
		out.flush();
		out.close();
		return null;
	}
}
