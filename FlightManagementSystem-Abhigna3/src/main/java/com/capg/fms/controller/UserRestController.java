package com.capg.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.entity.UserBean;

import com.capg.fms.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/user" })
public class UserRestController {
	@Autowired
	UserServiceImpl userService;

	@PostMapping(value = "/add")
	public ResponseEntity<Boolean> addUser(@Valid @RequestBody UserBean user) {
		userService.addUser(user);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;

	}

	@DeleteMapping(value = "/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		try {
			userService.deleteUser(userId);
			ResponseEntity<String> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			System.out.println("response entity=" + responseEntity);
			return responseEntity;
		} catch (Exception e) {

			System.err.println("Invalid UserId");
			return new ResponseEntity("Invalid User Id", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/view/{userId}")
	public ResponseEntity<UserBean> viewUser(@PathVariable int userId) {
		try {
			UserBean user = userService.viewUserById(userId);
			ResponseEntity<UserBean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			System.out.println("response entity=" + responseEntity);
			return responseEntity;
		} catch (Exception e) {

			System.err.println("Invalid UserId");
			return new ResponseEntity("Invalid User Id", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/viewall")
	public List<UserBean> viewUser() {
		return userService.viewUser();
	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}

}
