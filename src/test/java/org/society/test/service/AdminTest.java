package org.society.test.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.AdminDao;
import org.society.entities.Admin;
import org.society.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AdminTest {
	@Autowired
	private AdminDao adDao;
	@MockBean
	private AdminRepository repo;

	@Test
	@DisplayName("Test for adding Admin in database")
	public void addAdminDetailsTest() {
		Admin ad = new Admin(111l, "Life", "Water");

		when(repo.save(ad)).thenReturn(ad);
		assertEquals(ad, adDao.save(ad));
	}
	
	
	//update remaining
	
	/*
	@Test
	@DisplayName("Test for deleting Admin")
	public void deleteAdminDetailsTest() {
		Admin ad = new Admin(111l, "Life", "Water");
		adDao.delete(111);
		verify(repo, times(1)).deleteById(111l);
	}
	*/
	@Test
	@DisplayName("Test for displaying Admin by Id")
	public void getAdminDetailsTest() {
		Admin ad = new Admin(111l, "Life", "Water");
		when(repo.findById(111l)).thenReturn(Optional.of(ad));
		assertEquals(ad, adDao.getAdmin(111l));
	}
	@Test
	@DisplayName("Test for displaying list of Admin")
	public void getAdminList() {
		when(repo.findAll()).thenReturn(Stream
				.of(new Admin(1111l, "Life", "Dead"),new Admin(123l, "Water","Fire"))
				.collect(Collectors.toList()));
		assertEquals(2, adDao.getAllAdmin().size());
	}
		
}
