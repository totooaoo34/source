package com.yuyi.bean;

public class SoftwareSetBean {
	
	public String setTitle;
	
	public String setContent;
	
	public int beaconImage;

	
	
	public SoftwareSetBean(String setTitle, String setContent, int beaconImage) {
		super();
		this.setTitle = setTitle;
		this.setContent = setContent;
		this.beaconImage = beaconImage;
	}

	public SoftwareSetBean(String setTitle, String setContent) {
		super();
		this.setTitle = setTitle;
		this.setContent = setContent;
	}


	public String getSetTitle() {
		return setTitle;
	}

	public void setSetTitle(String setTitle) {
		this.setTitle = setTitle;
	}

	public String getSetContent() {
		return setContent;
	}

	public void setSetContent(String setContent) {
		this.setContent = setContent;
	}

	public int getBeaconImage() {
		return beaconImage;
	}

	public void setBeaconImage(int beaconImage) {
		this.beaconImage = beaconImage;
	}
}
