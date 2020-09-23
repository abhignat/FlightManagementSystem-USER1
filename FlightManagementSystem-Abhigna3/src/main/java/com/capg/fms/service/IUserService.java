package com.capg.fms.service;

import java.util.List;

import com.capg.fms.entity.UserBean;

public interface IUserService {

	public UserBean addUser(UserBean user);

	public UserBean viewUserById(int userId);

	public List<UserBean> viewUser();

	public boolean deleteUser(int userId);

}
