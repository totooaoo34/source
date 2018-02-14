package com.entity;

import java.sql.Date;

public class Comment_table {
	private int Comment_id;
	private int U_id;
	private int Post_id;
	private String Comment_content;
	private Date Comment_date;
	public int getComment_id() {
		return Comment_id;
	}
	public void setComment_id(int commentId) {
		Comment_id = commentId;
	}
	public int getU_id() {
		return U_id;
	}
	public void setU_id(int uId) {
		U_id = uId;
	}
	public int getPost_id() {
		return Post_id;
	}
	public void setPost_id(int postId) {
		Post_id = postId;
	}
	public String getComment_content() {
		return Comment_content;
	}
	public void setComment_content(String commentContent) {
		Comment_content = commentContent;
	}
	public Date getComment_date() {
		return Comment_date;
	}
	public void setComment_date(Date commentDate) {
		Comment_date = commentDate;
	}
	@Override
	public String toString() {
		return "Comment_table [Comment_content=" + Comment_content
				+ ", Comment_date=" + Comment_date + ", Comment_id="
				+ Comment_id + ", Post_id=" + Post_id + ", U_id=" + U_id + "]";
	}
	
	
}
