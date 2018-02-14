package com.yuyi.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ComicBeanParcelable implements Parcelable{
	public Integer comicId;//封面漫画ID
	
	public String comicFmImgUrl;//封面漫画地址
	
	public String comicName;//漫画名称
	
	public String comicFmJiesao;//漫画封面文字介绍
	
	public String comicJqJiesao;//漫画剧情介绍
	
	public String comicAuthor;//漫画作者
	
	public String comicComat;//漫画战斗力
	
	public String comicSource;//漫画来源

	public String comicUpdateTime;//漫画最后更新时间
	
	public String comicIma01Url;//漫画01
	
	public String comicIma02Url;//漫画02
	
	public String comicIma03Url;//漫画03
	
	public String comicIma04Url;//漫画04
	
	public String comicIma05Url;//漫画05
	
	public String comicIma06Url;//漫画06
	
	public String comicIma07Url;//漫画07
	
	public String comicIma08Url;//漫画08
	
	public String comicIma09Url;//漫画09
	
	public String comicIma10Url;//漫画10

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
	//将值类型进行压缩

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
	//将值类型进行解压
			public static final Parcelable.Creator<ComicBeanParcelable> CREATOR =
					new Creator<ComicBeanParcelable>() {
						//获取解压的容器数组，存储临时数据
						@Override
						public ComicBeanParcelable[] newArray(int arg0) {
							// TODO Auto-generated method stub
							return new ComicBeanParcelable[arg0];
						}
						//获取解压的内容
						@Override
						public ComicBeanParcelable createFromParcel(Parcel arg0) {
							// TODO Auto-generated method stub
							ComicBeanParcelable comicbean = new ComicBeanParcelable(arg0.readInt(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString(),arg0.readString());
							return comicbean;
						}
					};
	
	
}
