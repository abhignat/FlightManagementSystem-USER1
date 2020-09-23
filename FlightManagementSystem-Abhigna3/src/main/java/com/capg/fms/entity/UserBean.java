package com.capg.fms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User_Spring")
public class UserBean {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;

	@NotEmpty
	private String userType;

	@NotEmpty
	@Size(min = 2, message = "Name should have atleast two characters ")
	private String userName;

	@NotEmpty
	private String email;

	@NotNull
	private Long userPhone;
	@NotEmpty
	private String password;

	public UserBean() {
	}

	public UserBean(String userType, String userName, String email, Long userPhone, String password) {
		this.userType = userType;
		this.userName = userName;
		this.email = email;
		this.userPhone = userPhone;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", email=" + email
				+ ", userPhone=" + userPhone + ", password=" + password + "]";
	}
}
