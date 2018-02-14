package com.entity;

public class Paste_images {
	private int Paste_images_id;
	private int Post_id;
	private String Paste_images_url ;
	public int getPaste_images_id() {
		return Paste_images_id;
	}
	public void setPaste_images_id(int pasteImagesId) {
		Paste_images_id = pasteImagesId;
	}
	public int getPost_id() {
		return Post_id;
	}
	public void setPost_id(int postId) {
		Post_id = postId;
	}
	public String getPaste_images_url() {
		return Paste_images_url;
	}
	public void setPaste_images_url(String pasteImagesUrl) {
		Paste_images_url = pasteImagesUrl;
	}
	@Override
	public String toString() {
		return "Paste_images [Paste_images_id=" + Paste_images_id
				+ ", Paste_images_url=" + Paste_images_url + ", Post_id="
				+ Post_id + "]";
	}
	
	
}
