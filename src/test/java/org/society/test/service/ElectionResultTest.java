package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
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
	// private ElectionResultService erService;

	@MockBean
	private ElectionResultRepository erRepo;

	// Add
	@Test
	@DisplayName("Test for adding Election Result")
	public void addElectionResultDetailsTest() {

		List<RegisteredSocietyVoters> regList = new ArrayList<>();

		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321", null, null);
		regList.add(new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc", "9876543210",
				"mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1));
		List<NominatedCandidates> candidateList = new ArrayList<>();
		candidateList
				.add(new NominatedCandidates(100L, 111, "Life", "Water", 10000, true, true, true,
						new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc",
								"9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1),
						cs1));

		ElectionResult er1 = new ElectionResult(300l, LocalDate.now(), cs1, 20000, 10000, 50, 5000, 50, "loosed");

		when(erRepo.save(er1)).thenReturn(er1);
		assertEquals(er1, erDao.save(er1));
	}

//UPDATE
	
	@Test

	@DisplayName("Test for updating Election Result")
	public void updateElectionResultDetailsTest() {
		List<RegisteredSocietyVoters> regList3 = new ArrayList<>();

		CooperativeSociety cs3 = new CooperativeSociety("c Society", "HeadofResult3", "village3", "mandal3", "dis3",
				"454321", null, null);
		regList3.add(new RegisteredSocietyVoters(201l, "v32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc",
				"7876543210", "aditya@email.com", "add3", "add4", "mondal3", "Dis3", 454321, true, cs3));
		List<NominatedCandidates> candidateList3 = new ArrayList<>();
		candidateList3
				.add(new NominatedCandidates(102L, 333, "Shor", "Tiger", 30000, true, true, true,
						new RegisteredSocietyVoters(202l, "v32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc",
								"7876543210", "aditya@email.com", "add3", "add4", "mondal3", "Dis3", 454321, true, cs3),
						cs3));

		ElectionResult er3 = new ElectionResult(302l, LocalDate.now(), cs3, 30000, 15000, 50, 7500, 50, "loss");
		er3.setResult("Win");
		assertThat(erRepo.findById(er3.getId())).isNotEqualTo(er3);
	}

//DELETE

	@Test

	@DisplayName("Test for deleting Election Result")
	public void deleteElectionResultDetailsTest() {
		List<RegisteredSocietyVoters> regList = new ArrayList<>();

		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321", null, null);
		regList.add(new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc", "9876543210",
				"mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1));
		List<NominatedCandidates> candidateList = new ArrayList<>();
		candidateList
				.add(new NominatedCandidates(100L, 111, "Life", "Water", 10000, true, true, true,
						new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc",
								"9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1),
						cs1));

		ElectionResult er1 = new ElectionResult(300l, LocalDate.now(), cs1, 20000, 10000, 50, 5000, 50, "loosed");

		when(erRepo.existsById(er1.getId())).thenReturn(true);
		erDao.delete(er1.getId());
		verify(erRepo).deleteById(300l);

	}

	// DetailsById
	
	@Test

	@DisplayName("Test for displaying Election Result by Id")
	public void getCandidatewiseResultDetailsTest() {

		List<RegisteredSocietyVoters> regList2 = new ArrayList<>();

		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadofResult2", "village2", "mandal2", "dis2",
				"554321", null, null);
		regList2.add(new RegisteredSocietyVoters(201l, "v22345", "Shobbit", "Kumar", "Bcrec2", "Male", "gen",
				"8876543210", "shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 554321, true, cs2));
		List<NominatedCandidates> candidateList2 = new ArrayList<>();
		candidateList2.add(new NominatedCandidates(101L, 222, "Death", "Fire", 20000, true, true, true,
				new RegisteredSocietyVoters(201l, "v22345", "Shobbit", "Kumar", "Bcrec2", "Male", "gen", "8876543210",
						"shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 554321, true, cs2),
				cs2));
		ElectionResult er2 = new ElectionResult(301l, LocalDate.now(), cs2, 10000, 5000, 50, 2500, 50, "Win");

		when(erRepo.findById(301l)).thenReturn(Optional.of(er2));
		assertEquals(er2, erDao.getCandidatewiseResult(301l));
	}

	
	//AllDetails
	@Test
	@DisplayName("Test for displaying list of Election Result")
	public void getElectionResultList() {
//First input	
		List<RegisteredSocietyVoters> regList2 = new ArrayList<>();

		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadofResult2", "village2", "mandal2", "dis2",
				"554321", null, null);
		regList2.add(new RegisteredSocietyVoters(201l, "v22345", "Shobbit", "Kumar", "Bcrec2", "Male", "gen",
				"8876543210", "shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 554321, true, cs2));
		List<NominatedCandidates> candidateList2 = new ArrayList<>();
		candidateList2.add(new NominatedCandidates(101L, 222, "Death", "Fire", 20000, true, true, true,
				new RegisteredSocietyVoters(201l, "v22345", "Shobbit", "Kumar", "Bcrec2", "Male", "gen", "8876543210",
						"shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 554321, true, cs2),
				cs2));
		ElectionResult er2 = new ElectionResult(301l, LocalDate.now(), cs2, 10000, 5000, 50, 2500, 50, "Win");

//Second input
		List<RegisteredSocietyVoters> regList3 = new ArrayList<>();

		CooperativeSociety cs3 = new CooperativeSociety("c Society", "HeadofResult3", "village3", "mandal3", "dis3",
				"454321", null, null);
		regList3.add(new RegisteredSocietyVoters(201l, "v32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc",
				"7876543210", "aditya@email.com", "add3", "add4", "mondal3", "Dis3", 454321, true, cs3));
		List<NominatedCandidates> candidateList3 = new ArrayList<>();
		candidateList3
				.add(new NominatedCandidates(102L, 333, "Shor", "Tiger", 30000, true, true, true,
						new RegisteredSocietyVoters(202l, "v32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc",
								"7876543210", "aditya@email.com", "add3", "add4", "mondal3", "Dis3", 454321, true, cs3),
						cs3));

		ElectionResult er3 = new ElectionResult(302l, LocalDate.now(), cs3, 30000, 15000, 50, 7500, 50, "loss");

		when(erRepo.findAll()).thenReturn(
				Stream.of(er2, er3)
						.collect(Collectors.toList()));
		assertEquals(2, erDao.getElectionResultList().size());
	}

}
