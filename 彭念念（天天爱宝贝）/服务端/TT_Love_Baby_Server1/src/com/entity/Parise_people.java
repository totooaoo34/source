package com.entity;

public class Parise_people {
	private int Parise_id;
	private int U_id;
	private int Post_id;
	public int getParise_id() {
		return Parise_id;
	}
	public void setParise_id(int pariseId) {
		Parise_id = pariseId;
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
	@Override
	public String toString() {
		return "Parise_people [Parise_id=" + Parise_id + ", Post_id=" + Post_id
				+ ", U_id=" + U_id + "]";
	}
	
	
}
