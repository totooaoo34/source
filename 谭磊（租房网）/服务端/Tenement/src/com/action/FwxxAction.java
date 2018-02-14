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
 * @author Administrator Fwxx���Ʋ�
 */
public class FwxxAction {

	/** ������Ϣservice **/
	private FwxxService service;
	/** ����service **/
	private QxService qxService;
	/** �ֵ�service **/
	private JdService jdService;
	/** ��������service **/
	private FwlxService fwlxService;

	/** ������Ϣ���϶��� **/
	private List<Fwxx> fwxxs;
	/** ������Ϣʵ����� **/
	private Fwxx fwxx;
	/** ������Ϣid **/
	private int fwid;
	/** ���ؼ��� **/
	private List<Qx> qxs;
	/** �������� **/
	private Qx qx;
	/** �����ֵ� **/
	private Jd jd;
	/** JS�е�ajax������qxid **/
	private int qxid;
	private List<Jd> jds;
	/** �������ͼ��� **/
	private List<Fwlx> fwlxs;
	/** �������� **/
	private Fwlx fwlx;
	/** ��Ƭ���� **/
	private String imgName;
	// �ļ������������ǰ̨���ļ����nameһ��
	private File pic;
	/** �����ҵ��ⷿ��Ϣ��������UID **/
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
	 * ��ѯ���з�����Ϣ
	 */
	public String findAllFwxx() {
		fwxxs = service.findAllFwxx();
		return "index";
	}

	/**
	 * �����ҵ��ⷿ��Ϣ
	 */
	public String findByUidFwxx() {
		fwxxs = service.findByUidFwxx(uid);
		return "utenement";
	}

	/**
	 * ����fwidɾ��
	 */
	public String delByIdFwxx() {
		service.delByIdFwxx(fwid);
		return findAllFwxx();
	}

	/**
	 * �޸Ĳ�ѯ����������Ϣ
	 */
	public String findByIdFwxx() {
		// ��ѯ���з�����Ϣ
		fwxx = service.findByIdFwxx(fwid);
		// ��ѯ��������
		qxs = qxService.findAllQx();
		// ��ѯ���з�������
		fwlxs = fwlxService.findAllFwlx();
		// 1.��ѯ��������Ϣ�е�jdId
		// 2.����jdId��ѯ��ѯ�ֵ����е�qxid
		// 3.�����޸�ʱĬ�ϻ��Ե����ض���
		jd = jdService.findByIdJd(fwxx.getJdid());
		qx = qxService.findByIdQx(jd.getQxid());
		jds = jdService.findByQxId(qx.getQxid());
		return "upmsg";
	}

	/**
	 * ��ѯ������Ϣ
	 */
	public String findSingleFwxx() {
		fwxx = service.findByIdFwxx(fwid);// ������Ϣ
		fwlx = fwlxService.findByIdFwlx(fwxx.getLxid());// ��������
		jd = jdService.findByIdJd(fwxx.getJdid());// �ֵ�
		qx = qxService.findByIdQx(jd.getQxid());// ����
		return "single";
	}

	/**
	 * AJAX ������ض��������ֵ�
	 * 
	 */
	public String findByJd() {
		HttpServletResponse response = ServletActionContext.getResponse();
		jds = jdService.findByQxId(qxid);
		// ajax�е�response�ı�
		String ajaxJd = "-��ѡ��-,";
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
	 * ����fwid�޸�
	 */
	public String upByIdFwxx() {
		service.upByIdFwxx(fwxx);
		return findByIdFwxx();
	}

	/**
	 * �����ⷿ��Ϣʱ�Ļ���
	 */
	public String publishSel() {
		qxs = qxService.findAllQx();// ��ѯ��������
		fwlxs = fwlxService.findAllFwlx();// ��ѯ���з�������
		return "publish";
	}

	/**
	 * �����ⷿ��Ϣ
	 */
	public String addMessage() {
		// ��ȡϵͳ��ǰʱ��
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		String str = dateFormat.format(curDate);
		fwxx.setDate(str);// �������Ϊϵͳ��ǰʱ��
		fwxx.setImg(imgName + ".PNG");
		fwxx.setUid(Integer.parseInt(uid));
		service.addPublish(fwxx);
		// Ѱ����tomcat�д��·��
		String path = ServletActionContext.getServletContext().getRealPath("/");
		File file = new File(path + "/house_img/" + imgName+".PNG");
		// ��װ���������
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

	/************** ������ϢJson *****************/
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
	
	//����������Ϣ
	public String inntFwxxByIdJson() throws IOException{
		request=ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		out = response.getWriter();
		Integer fwid = (Integer) request.getAttribute("fwid");
		fwxx = service.findByIdFwxx(fwid);// ������Ϣ
		fwlx = fwlxService.findByIdFwlx(fwxx.getLxid());// ��������
		jd = jdService.findByIdJd(fwxx.getJdid());// �ֵ�
		qx = qxService.findByIdQx(jd.getQxid());// ����
		
		util=new FwxxJSON();
		String json = util.fwxxByIdJson(fwxx, fwlx, jd, qx);
		out.write(json);
		out.flush();
		out.close();
		return null;
	}
}
