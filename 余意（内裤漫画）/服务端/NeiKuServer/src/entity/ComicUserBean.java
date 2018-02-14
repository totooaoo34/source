package entity;

public class ComicUserBean {
	public Integer userId;

	public String userName;

	public String userPassword;

	public ComicUserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComicUserBean(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "ComicUserBean [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + "]";
	}

}
