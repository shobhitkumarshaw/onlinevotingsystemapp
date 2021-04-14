package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.ElectionOfficerDao;
import org.society.entities.ElectionOfficer;
import org.society.repository.ElectionOfficerRepository;
import org.society.service.ElectionOfficerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ElectionOfficerTest {

	@Autowired
	private ElectionOfficerDao eoservice;

	@MockBean
	private ElectionOfficerRepository repo;

	// Add
	@Test
	@DisplayName("Test for adding Election officer in database")
	public void addElectionOfficerDetailsTest() {
		// when - then
		ElectionOfficer officer = new ElectionOfficer(788L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		when(repo.save(officer)).thenReturn(officer);
		assertEquals(officer, eoservice.save(officer));
	}

	// Update
	/*
	 * @Test
	 * 
	 * @DisplayName("Test for updating Election officer in database") 
	 * public void updateElectionOfficerDetailsTest() {
	 * 
	 * ElectionOfficer officer = new ElectionOfficer(788L, "shobhit", "shaw",
	 * "Bcrec1", "Male", "9876543210", "shobhit@gmail.com", "add1", "add2", "dis1",
	 * 654321); 
	 * when(repo.save(officer)).thenReturn(officer); 
	 * assertEquals(officer,eoservice.update(officer));
	 * 
	 * }
	 */

	//Delete
/*	
	@Test
	@DisplayName("Test for deleting Election officer in database")
	public void deleteElectionOfficerDetailsTest() {
		
		ElectionOfficer officer = new ElectionOfficer(788L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		repo.deleteById(788l);
		assertEquals(null, eoservice.delete(300l));

	}
*/
	//DetailsById
	
	@Test
	@DisplayName("Test for displaying Election officer by Id in database")
	public void getElectionOfficerByIdDetailsTest() {
		
		ElectionOfficer officer = new ElectionOfficer(788L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		when(repo.findById(301l)).thenReturn(Optional.of(officer));
		assertEquals(officer, eoservice.getElectionOfficerById(301l));

	}
	
	//AllDetails
	@Test
	@DisplayName("Test for displaying list of Election officer  in database")
	public void getElectionOfficerListDetailsTest() {
		
		ElectionOfficer officer = new ElectionOfficer(788L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		ElectionOfficer officer2 = new ElectionOfficer(888L, "Raj", "Kumar", "Bcrec2", "Male", "8876543210",
				"raj@gmail.com", "add2", "add3", "dis2", 554321);
		
		when(repo.findAll()).thenReturn(
				Stream.of(officer, officer2)
						.collect(Collectors.toList()));
		assertEquals(2, eoservice.getElectionOfficerList().size());
}
}