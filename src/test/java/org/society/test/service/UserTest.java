package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.UserDao;
import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
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
		User u1 = new User(44l,"pass","bhanu","prakash","mail","9951","User");
		

		when(repo.save(u1)).thenReturn(u1);
		assertEquals(u1, userService.save(u1));
	}

//Update
/*	@Test
	public void updateUserDetailsTest() {
		User u1 = new User(55l,"fdfd","bha","pra","mail@","6262","nominated condiadate");

		when(repo.save(u1)).thenReturn(u1);
		assertEquals(u1,userService.update(u1));
	}

	// Delete
	@Test
	public void deleteUserDetailsTest() {
		User u1 = new User(212l,"gaja","yhsh","hshs","mailll","43536","voter");
		repo.deleteById(212l);
		assertEquals(null, userService.delete(212l));
	}*/

	// getById
	@Test
	@DisplayName("Test for displaying nominated Candidate by Id")
	public void getUserTest() {
		User u1 = new User(2121l,"gaja","yhsh","hshs","mailll","43536","voter");
		when(repo.findById(2121l)).thenReturn(Optional.of(u1));
		assertEquals(u1, userService.findByUserId(2121l));
	}

	//getAll
	@Test
	@DisplayName("Test for displaying list of nominated Candidate")
	public void getUserListDetailsTest() {
		User u1 = new User(212l,"gaja","yhsh","hshs","mailll","43536","voter");
		User u2 = new User(55l,"fdfd","bha","pra","mail@","6262","nominated condiadate");

		when(repo.findAll()).thenReturn(
				Stream.of(u1, u2)
						.collect(Collectors.toList()));
		assertEquals(2, userService.viewUserList().size());
		
}

}	
	
		
		



