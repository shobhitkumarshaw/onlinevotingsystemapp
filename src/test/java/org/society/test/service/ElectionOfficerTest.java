package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.entities.ElectionOfficer;
import org.society.repository.ElectionOfficerRepository;
import org.society.service.ElectionOfficerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ElectionOfficerTest {

	@Autowired
	private ElectionOfficerServiceImpl service;

	@MockBean
	private ElectionOfficerRepository repository;

	// Add
	@Test
	@DisplayName("Test for adding Election officer in database")
	public void addElectionOfficerDetailsTest() {
		// when - then
		ElectionOfficer officer = new ElectionOfficer(1L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		when(repository.save(officer)).thenReturn(officer);
		assertEquals(officer, service.addElectionOfficerDetails(officer));
	}

	// Update
	@Test
	@DisplayName("Test for updating Election officer in database")
	public void updateElectionOfficerDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer(788L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		officer.setFirstName("Tej");
		assertThat(repository.findById(officer.getId())).isNotEqualTo(officer);
	}

	// Delete
	@Test
	@DisplayName("Test for deleting Election officer in database")
	public void deleteElectionOfficerDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer(3L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		when(repository.existsById(officer.getId())).thenReturn(true);
		service.deleteElectionOfficer(officer.getId());
		verify(repository).deleteById(3l);
	}

	// DetailsById

	@Test
	@DisplayName("Test for displaying Election officer by Id in database")
	public void getElectionOfficerByIdDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer(2L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		when(repository.findById(2l)).thenReturn(Optional.of(officer));
		assertEquals(officer, service.viewElectionOfficerById(2l));

	}

	// AllDetails
	@Test
	@DisplayName("Test for displaying list of Election officer  in database")
	public void getElectionOfficerListDetailsTest() {

		ElectionOfficer officer = new ElectionOfficer(2L, "shobhit", "shaw", "Bcrec1", "Male", "9876543210",
				"shobhit@gmail.com", "add1", "add2", "dis1", 654321);
		ElectionOfficer officer2 = new ElectionOfficer(3L, "Raj", "Kumar", "Bcrec2", "Male", "8876543210",
				"raj@gmail.com", "add2", "add3", "dis2", 554321);

		when(repository.findAll()).thenReturn(Stream.of(officer, officer2).collect(Collectors.toList()));
		assertEquals(2, service.viewElectionOfficerList().size());
	}
}