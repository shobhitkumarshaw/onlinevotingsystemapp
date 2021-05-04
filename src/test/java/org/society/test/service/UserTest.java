/*
  * @author: Nagidi Bhanu prakash
 */
package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.UserDao;
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
	@DisplayName("Test for adding User in database")
	public void addUserDetailsTest() {
		User u1 = new User("Ritik", "pass1", "Admin");

		when(repo.save(u1)).thenReturn(u1);
		assertEquals(u1, userService.save(u1));
	}

	// Update
	@Test
	@DisplayName("Test for updating User in database")
	public void updateUserDetailsTest() {
		User u1 = new User("Shobhit", "pass2", "ElectionOfficer");
		u1.setUserName("Bhanu");
		assertThat(repo.findById(u1.getUserName())).isNotEqualTo(u1);
	}

	// Delete
	@Test
	@DisplayName("Test for deleting User in database")
	public void deleteUserDetailsTest() {
		User u1 = new User("Shobhit", "pass2", "ElectionOfficer");
		when(repo.existsById(u1.getUserName())).thenReturn(true);
		userService.delete(u1.getUserName());
		verify(repo).deleteById("Shobhit");
	}

	// getById
	@Test
	@DisplayName("Test for displaying user by Id")
	public void getUserTest() {
		User u1 = new User("Shobhit", "pass2", "ElectionOfficer");
		when(repo.findById(u1.getUserName())).thenReturn(Optional.of(u1));
		assertEquals(u1, userService.findByUserId("Shobhit"));
	}

	// getAll
	@Test
	@DisplayName("Test for displaying list of user")
	public void getUserListDetailsTest() {
		User u1 = new User("Shobhit", "pass2", "ElectionOfficer");
		User u2 = new User("Ritik", "pass1", "Admin");

		when(repo.findAll()).thenReturn(Stream.of(u1, u2).collect(Collectors.toList()));
		assertEquals(2, userService.viewUserList().size());
	}
}