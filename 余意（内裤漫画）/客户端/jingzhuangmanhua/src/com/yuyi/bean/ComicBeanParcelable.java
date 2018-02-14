package com.yuyi.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ComicBeanParcelable implements Parcelable{
	public Integer comicId;//��������ID
	
	public String comicFmImgUrl;//����������ַ
	
	public String comicName;//��������
	
	public String comicFmJiesao;//�����������ֽ���
	
	public String comicJqJiesao;//�����������
	
	public String comicAuthor;//��������
	
	public String comicComat;//����ս����
	
	public String comicSource;//������Դ

	public String comicUpdateTime;//����������ʱ��
	
	public String comicIma01Url;//����01
	
	public String comicIma02Url;//����02
	
	public String comicIma03Url;//����03
	
	public String comicIma04Url;//����04
	
	public String comicIma05Url;//����05
	
	public String comicIma06Url;//����06
	
	public String comicIma07Url;//����07
	
	public String comicIma08Url;//����08
	
	public String comicIma09Url;//����09
	
	public String comicIma10Url;//����10

	public ComicBeanParcelable(Integer comicId, String comicFmImgUrl,
			String comicName, String comicFmJiesao, String comicJqJiesao,
			String comicAuthor, String comicComat, String comicSource,
			String comicUpdateTime, String comicIma01Url, String comicIma02Url,
			String comicIma03Url, String comicIma04Url, String comicIma05Url,
			String comicIma06Url, String comicIma07Url, String comicIma08Url,
			String comicIma09Url, String comicIma10Url) {
		super();
		this.comicId = comicId;
		this.comicFmImgUrl = comicFmImgUrl;
		this.comicName = comicName;
		this.comicFmJiesao = comicFmJiesao;
		this.comicJqJiesao = comicJqJiesao;
		this.comicAuthor = comicAuthor;
		this.comicComat = comicComat;
		this.comicSource = comicSource;
		this.comicUpdateTime = comicUpdateTime;
		this.comicIma01Url = comicIma01Url;
		this.comicIma02Url = comicIma02Url;
		this.comicIma03Url = comicIma03Url;
		this.comicIma04Url = comicIma04Url;
		this.comicIma05Url = comicIma05Url;
		this.comicIma06Url = comicIma06Url;
		this.comicIma07Url = comicIma07Url;
		this.comicIma08Url = comicIma08Url;
		this.comicIma09Url = comicIma09Url;
		this.comicIma10Url = comicIma10Url;
	}
	//��ֵ���ͽ���ѹ��

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(comicId);
		dest.writeString(comicFmImgUrl);
		dest.writeString(comicName);
		dest.writeString(comicFmJiesao);
		dest.writeString(comicJqJiesao);
		dest.writeString(comicAuthor);
		dest.writeString(comicComat);
		dest.writeString(comicSource);
		dest.writeString(comicUpdateTime);
		dest.writeString(comicIma01Url);
		dest.writeString(comicIma02Url);
		dest.writeString(comicIma03Url);
		dest.writeString(comicIma04Url);
		dest.writeString(comicIma05Url);
		dest.writeString(comicIma06Url);
		dest.writeString(comicIma07Url);
		dest.writeString(comicIma08Url);
		dest.writeString(comicIma09Url);
		dest.writeString(comicIma10Url);
	}
	//��ֵ���ͽ��н�ѹ
			public static final Parcelable.Creator<ComicBeanParcelable> CREATOR =
					new Creator<ComicBeanParcelable>() {
						//��ȡ��ѹ���������飬�洢��ʱ����
						@Override
						public ComicBeanParcelable[] newArray(int arg0) {
							// TODO Auto-generated method stub
							return new ComicBeanParcelable[arg0];
						}
						//��ȡ��ѹ������
						@Override
						public ComicBeanParcelable createFromParcel(Parcel arg0) {
							// TODO Auto-generated method stub
							ComicBeanParcelable comicbean = new ComicBeanParcelable(arg0.readInt(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString());
							return comicbean;
						}
					};
	
	
}
