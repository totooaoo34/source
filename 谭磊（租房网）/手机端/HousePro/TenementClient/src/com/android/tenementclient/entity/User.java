package com.android.tenementclient.entity;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Administrator �û�
 */
public class User implements Parcelable {

	/**
	 * �û�ID
	 */
	private Integer uid;
	/**
	 * �û�����
	 */
	private String uname;
	/**
	 * �û���¼�˺�
	 */
	private String ulogin;
	/**
	 * �û�����
	 */
	private String upass;
	/**
	 * �û�ͷ��
	 */
	private String uimg;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUlogin() {
		return ulogin;
	}

	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer uid, String uname, String ulogin, String upass,
			String uimg) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.ulogin = ulogin;
		this.upass = upass;
		this.uimg = uimg;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		arg0.writeInt(uid);
		arg0.writeString(uname);
		arg0.writeString(ulogin);
		arg0.writeString(upass);
		arg0.writeString(uimg);
	}

	public static Creator<User> CREATOR = new Creator<User>() {

		public User[] newArray(int arg0) {
			// TODO Auto-generated method stub
			return new User[arg0];
		}

		@Override
		public User createFromParcel(Parcel arg0) {
			// TODO Auto-generated method stub
			int uid = arg0.readInt();
			String uname = arg0.readString();
			String ulogin = arg0.readString();
			String upass = arg0.readString();
			String uimg = arg0.readString();
			User user = new User(uid, uname, ulogin, upass, uimg);
			return user;
		}
	};

}
