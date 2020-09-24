package com.capg.fms.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.fms.dao.UserRepository;
import com.capg.fms.entity.UserBean;
import com.capg.fms.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FlightManagementSystemAbhignaApplicationTests {
	@Autowired
	private UserServiceImpl userService;
	@MockBean
	private UserRepository userRepo;

	@Test
	public void testAddUser() {
		UserBean bean = new UserBean();
		bean.setUserId(114);
		bean.setUserType("customer");
		bean.setUserName("abhi");
		bean.setUserPhone(9794067987L);
		bean.setEmail("abhi123@gmail.com");
		bean.setPassword("abhi23");
		Mockito.when(userRepo.save(bean)).thenReturn(bean);
		assertThat(userService.addUser(bean)).isEqualTo(bean);
	}

	@Test
	public void testviewUser() {
		UserBean user1 = new UserBean();
		user1.setUserId(114);
		user1.setUserType("customer");
		user1.setUserName("abhi");
		user1.setPassword("abhi23");
		user1.setUserPhone(9129568025L);
		user1.setEmail("abhi123@gmail.com");

		UserBean user2 = new UserBean();
		user2.setUserId(114);
		user2.setUserType("customer");
		user2.setUserName("abhi");
		user2.setPassword("abhi23");
		user2.setUserPhone(9129568025L);
		user2.setEmail("abhi123@gmail.com");
		List<UserBean> userlist = new ArrayList<>();
		userlist.add(user1);
		userlist.add(user2);
		Mockito.when(userRepo.findAll()).thenReturn(userlist);
		assertThat(userService.viewUser()).isEqualTo(userlist);
		assertEquals(userlist.size(), 2);
	}

}
