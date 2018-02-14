package com.entity;

public class Post_a_message {
	private int Post_id;
	private int U_id;
	private String Post_date;
	private String Post_message;
	public int getPost_id() {
		return Post_id;
	}
	public void setPost_id(int postId) {
		Post_id = postId;
	}
	public int getU_id() {
		return U_id;
	}
	public void setU_id(int uId) {
		U_id = uId;
	}
	public String getPost_date() {
		return Post_date;
	}
	public void setPost_date(String postDate) {
		Post_date = postDate;
	}
	public String getPost_message() {
		return Post_message;
	}
	public void setPost_message(String postMessage) {
		Post_message = postMessage;
	}
	@Override
	public String toString() {
		return "Post_a_message [Post_date=" + Post_date + ", Post_id="
				+ Post_id + ", Post_message=" + Post_message + ", U_id=" + U_id
				+ "]";
	}
	
}
