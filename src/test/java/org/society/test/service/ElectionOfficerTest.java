package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.ElectionOfficerDaoImpl;
import org.society.entities.ElectionOfficer;
import org.society.repository.ElectionOfficerRepository;
import org.society.service.ElectionOfficerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ElectionOfficerTest {

	@Autowired
	private ElectionOfficerDaoImpl eoDao;

	@MockBean
	private ElectionOfficerRepository repository;

	// Add
	@Test
	@DisplayName("Test for adding Election officer in database")
	public void addElectionOfficerDetailsTest() {
		ElectionOfficer officer = new ElectionOfficer("Rahul", "Raj", "Male", "1234567890", "rahul@gmail.com", "add1", "add2", "Dis1", 1234);
		when(repository.save(officer)).thenReturn(officer);
		assertEquals(officer, eoDao.save(officer));
	}

	// Update
	@Test
	@DisplayName("Test for updating Election officer in database")
	public void updateElectionOfficerDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer("Rahul", "Raj",  "Male", "1234567890", "rahul@gmail.com", "add1", "add2", "Dis1", 123456);
		officer.setFirstName("Tej");
		assertThat(repository.findById(officer.getId())).isNotEqualTo(officer);
	}

	// Delete
	@Test
	@DisplayName("Test for deleting Election officer in database")
	public void deleteElectionOfficerDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer("Mohit", "Kumar", "Male", "2234567890", "mohit@gmail.com", "add2", "add3", "Dis2", 223456);
		officer.setId(3l);
		when(repository.existsById(officer.getId())).thenReturn(true);
		eoDao.delete(officer.getId());

		verify(repository,times(1)).deleteById(officer.getId());;

		
	}

	// DetailsById

	@Test
	@DisplayName("Test for displaying Election officer by Id in database")
	public void getElectionOfficerByIdDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer("Mohit", "Kumar", "Male", "2234567890", "mohit@gmail.com", "add2", "add3", "Dis2", 223456);
		when(repository.findById(2l)).thenReturn(Optional.of(officer));
		assertEquals(officer, eoDao.getElectionOfficerById(2l));

	}

	// AllDetails
	@Test
	@DisplayName("Test for displaying list of Election officer  in database")
	public void getElectionOfficerListDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer("Mohit", "Kumar", "Male", "2234567890", "mohit@gmail.com", "add2", "add3", "Dis2", 223456);
		ElectionOfficer officer2 = new ElectionOfficer("Rahul", "Raj",  "Male", "1234567890", "rahul@gmail.com", "add1", "add2", "Dis1", 123456);

		when(repository.findAll()).thenReturn(Stream.of(officer, officer2).collect(Collectors.toList()));
		assertEquals(2, eoDao.getElectionOfficerList().size());
	}
}