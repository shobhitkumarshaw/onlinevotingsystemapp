package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.ElectionResultDao;
import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.repository.ElectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ElectionResultTest {
	@Autowired
	private ElectionResultDao erDao;

	@MockBean
	private ElectionResultRepository repo;

	@Test
	@DisplayName("Test for adding Election Result")
	public void addElectionResultDetailsTest() {
//		CooperativeSociety cs = new CooperativeSociety(100l, "Taj", "Mahal", "Sathpur", "Mondal", "Saran", "123456");
//		RegisteredSocietyVoters rs = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc",
//				"9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
//		NominatedCandidates nc = new NominatedCandidates(33l, 2222l, "Shor", "Tiger", 25000f, true, true, true, rs);
//		ElectionResult er1 = new ElectionResult(10l, LocalDate.of(2021, 1, 26), nc, "Indra Nagar", 1000, 500, 50, 250,
//				50, "Win");
//
//		when(repo.save(er1)).thenReturn(er1);
//		assertEquals(er1, erDao.save(er1));

	}
//UPDATE
	/*
	 * @Test
	 * 
	 * @DisplayName("Test for updating Election Result") public void
	 * updateElectionResultDetailsTest() { CooperativeSociety cs = new
	 * CooperativeSociety(100l, "Taj", "Mahal", "Sathpur", "Mondal", "Saran",
	 * "123456"); RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(2l,
	 * "22345", "Shobit", "Kumar", "Bcrec1", "Male", "gen", "1876543210",
	 * "shobit@email.com", "add1", "add23", "mondal", "Dis", 178543, false, cs);
	 * NominatedCandidates nc2 = new NominatedCandidates(22l, 3333l, "Life",
	 * "Water", 35000f, true, true, true, rs2); ElectionResult er2 = new
	 * ElectionResult(121l, LocalDate.of(2021, 1, 26), nc2, "Mohit Nagar", 20000,
	 * 10000, 50, 5000, 50, "Loss"); when(repo.save(er2)).thenReturn(er2);
	 * assertEquals(er2, erDao.update(er2));
	 * 
	 * }
	 */
//DELETE
	/*
	@Test
	@DisplayName("Test for deleting Election Result")
	public void deleteElectionResultDetailsTest() {
		CooperativeSociety cs = new CooperativeSociety(100l, "Taj", "Mahal", "Sathpur", "Mondal", "Saran", "123456");
		RegisteredSocietyVoters rs = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc",
				"9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
		NominatedCandidates nc = new NominatedCandidates(33l, 2222l, "Shor", "Tiger", 25000f, true, true, true, rs);
		ElectionResult er1 = new ElectionResult(10l, LocalDate.of(2021, 1, 26), nc, "Indra Nagar", 1000, 500, 50, 250,
				50, "Win");
		erDao.delete(10l);
		verify(repo, times(1)).deleteById(10l);
	}*/
	
	@Test
	@DisplayName("Test for displaying Election Result by Id")
	public void getCandidatewiseResultDetailsTest() {
//		CooperativeSociety cs = new CooperativeSociety(100l, "Taj", "Mahal", "Sathpur", "Mondal", "Saran", "123456");
//		RegisteredSocietyVoters rs = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc",
//				"9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
//		NominatedCandidates nc = new NominatedCandidates(33l, 2222l, "Shor", "Tiger", 25000f, true, true, true, rs);
//		ElectionResult er1 = new ElectionResult(10l, LocalDate.of(2021, 1, 26), nc, "Indra Nagar", 1000, 500, 50, 250,
//				50, "Win");
//		when(repo.findById(10l)).thenReturn(Optional.of(er1));
//		assertEquals(er1, erDao.getCandidatewiseResult(10l));
	}
	
	@Test
	@DisplayName("Test for displaying list of Election Result")
	public void getElectionResultList() {
//		CooperativeSociety cs = new CooperativeSociety(100l, "Taj", "Mahal", "Sathpur", "Mondal", "Saran", "123456");
//		RegisteredSocietyVoters rs = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc",
//				"9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
//		NominatedCandidates nc = new NominatedCandidates(33l, 2222l, "Shor", "Tiger", 25000f, true, true, true, rs);
//		when(repo.findAll()).thenReturn(Stream
//				.of(new ElectionResult(40l, LocalDate.of(2021, 1, 26), nc, "Mohit Nagar", 20000, 10000, 50,
//				5000, 50, "Loss"),new ElectionResult(50l, LocalDate.of(2021, 1, 26), nc, "Indra Nagar", 10000, 5000, 50,
//				2500, 50, "Win"))
//				.collect(Collectors.toList()));
//		assertEquals(2, erDao.getElectionResultList().size());
	}
}












