package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.society.repository.ElectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ElectionResultTest {
	@Autowired
	private ElectionResultDao erDao;
	

	@MockBean
	private ElectionResultRepository erRepo;

	// Test For Add
	@Test
	@DisplayName("Test for adding Election Result")
	public void addElectionResultDetailsTest() {

		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321", null, null);
		ElectionResult er1 = new ElectionResult(LocalDate.now(), cs1, 20000, 10000, 50, 5000, 50, "loosed");

		when(erRepo.save(er1)).thenReturn(er1);
		assertEquals(er1, erDao.save(er1));
	}

	// Test For Update
	@Test
	@DisplayName("Test for updating Election Result")
	public void updateElectionResultDetailsTest() {

		CooperativeSociety cs3 = new CooperativeSociety("c Society", "HeadofResult3", "village3", "mandal3", "dis3",
				"454321", null, null);
		ElectionResult er3 = new ElectionResult(LocalDate.now(), cs3, 30000, 15000, 50, 7500, 50, "loss");

		er3.setResult("Win");
		assertThat(erRepo.findById(er3.getId())).isNotEqualTo(er3);
	}

	// Test For Delete
	@Test
	@DisplayName("Test for deleting Election Result")
	public void deleteElectionResultDetailsTest() {

		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321", null, null);
		ElectionResult er1 = new ElectionResult(LocalDate.now(), cs1, 20000, 10000, 50, 5000, 50, "loosed");

		when(erRepo.existsById(er1.getId())).thenReturn(true);
		erDao.delete(er1.getId());
		verify(erRepo).deleteById(er1.getId());
	}

	// Test For DetailsById
	@Test
	@DisplayName("Test for displaying Election Result by Id")
	public void getCandidatewiseResultDetailsTest() {

		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadofResult2", "village2", "mandal2", "dis2",
				"554321", null, null);
		ElectionResult er2 = new ElectionResult(LocalDate.now(), cs2, 10000, 5000, 50, 2500, 50, "Win");

		when(erRepo.findById(301l)).thenReturn(Optional.of(er2));
		assertEquals(er2, erDao.getCandidatewiseResult(301l));
	}

	// Test For AllDetails
	@Test
	@DisplayName("Test for displaying list of Election Result")
	public void getElectionResultList() {

		// First input
		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadofResult2", "village2", "mandal2", "dis2",
				"554321", null, null);
		ElectionResult er2 = new ElectionResult(LocalDate.now(), cs2, 10000, 5000, 50, 2500, 50, "Win");

		// Second input
		CooperativeSociety cs3 = new CooperativeSociety("c Society", "HeadofResult3", "village3", "mandal3", "dis3",
				"454321", null, null);
		ElectionResult er3 = new ElectionResult(LocalDate.now(), cs3, 30000, 15000, 50, 7500, 50, "loss");

		when(erRepo.findAll()).thenReturn(Stream.of(er2, er3).collect(Collectors.toList()));
		assertEquals(2, erDao.getElectionResultList().size());
	}

}