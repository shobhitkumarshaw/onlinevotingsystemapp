package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.society.dao.UserDao;
import org.society.entities.User;
import org.society.entities.User;
import org.society.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserDao userService;
	
	@MockBean
	private UserRepository repo;
	
	@Test
	public void addUserDetailsTest() {
		//when
		User ur = new User(788L, "pass", "bhanu", "prakash", "mail", "5555","voter");
		when(repo.save(ur)).thenReturn(ur);
		assertEquals(ur, userService.save(ur));
	}	
		
		//@Test
		public void updateUserDetailsTest() {
		User ur = new User(788L, null, "bha", "pra", "mail@", "7655","nominated");
			when(repo.save(ur)).thenReturn(ur);
			assertEquals(ur, userService.update(ur));

		
		
	}

}
