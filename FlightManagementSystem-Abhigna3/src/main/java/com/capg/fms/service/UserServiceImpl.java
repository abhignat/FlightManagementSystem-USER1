package com.capg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.dao.UserRepository;
import com.capg.fms.entity.UserBean;
import com.capg.fms.exceptions.UserException;

@Service

public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserBean addUser(UserBean user) {
		return userRepository.save(user);
	}

	@Override
	public UserBean viewUserById(int userId) {
		if (userRepository.findById(userId).isPresent()) {
			System.out.println("Id found");
		} else {
			throw new UserException("Id not found");
		}
		return userRepository.findById(userId).get();
	}

	@Override
	public List<UserBean> viewUser() {
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUser(int userId) {
		if (userRepository.existsById(userId)) {

			userRepository.deleteById(userId);
		} else {
			throw new UserException("Id not found");
		}
		return true;

	}
}
