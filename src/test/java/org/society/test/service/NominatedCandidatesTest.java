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
import org.society.dao.NominatedCandidatesDao;
import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.repository.NominatedCandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class NominatedCandidatesTest {
	@Autowired
	private NominatedCandidatesDao nominatedCandidatesDao;

	@MockBean
	private NominatedCandidatesRepository nominatedCandidatesRepository;

//Add
	@Test
	public void addNominatedCandidatesDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male",
				"obc", "9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 678543, true, cs1);
		NominatedCandidates nc1 = new NominatedCandidates(100l, 111, "Life", "Water", 10000, true, true, true, rs1,
				cs1);

		when(nominatedCandidatesRepository.save(nc1)).thenReturn(nc1);
		assertEquals(nc1, nominatedCandidatesDao.save(nc1));
	}

//Update
	@Test
	public void updateNominatedCandidatesDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male",
				"obc", "9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 678543, true, cs1);
		NominatedCandidates nc1 = new NominatedCandidates(100l, 111, "Life", "Water", 10000, true, true, true, rs1,
				cs1);

		nc1.setSecurityDeposit(25000);
		assertThat(nominatedCandidatesRepository.findById(nc1.getCandidateId())).isNotEqualTo(nc1);
	}

	// Delete
	@Test
	public void deleteNominatedCandidatesDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male",
				"obc", "9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 678543, true, cs1);
		NominatedCandidates nc1 = new NominatedCandidates(100l, 111, "Life", "Water", 10000, true, true, true, rs1,
				cs1);
		when(nominatedCandidatesRepository.existsById(nc1.getCandidateId())).thenReturn(true);
		nominatedCandidatesDao.delete(nc1.getCandidateId());
		verify(nominatedCandidatesRepository).deleteById(300l);
	}

	// getById
	@Test
	@DisplayName("Test for displaying nominated Candidate by Id")
	public void getNominatedCandidateByIdDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male",
				"obc", "9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 678543, true, cs1);
		NominatedCandidates nc1 = new NominatedCandidates(100l, 111, "Life", "Water", 10000, true, true, true, rs1,
				cs1);
		when(nominatedCandidatesRepository.findById(100l)).thenReturn(Optional.of(nc1));
		assertEquals(nc1, nominatedCandidatesDao.getByCandidateId(100l));
	}

	//getAll
	@Test
	@DisplayName("Test for displaying list of nominated Candidate")
	public void getNominatedCandidateListDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "654321", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male",
				"obc", "9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 678543, true, cs1);
		NominatedCandidates nc1 = new NominatedCandidates(100l, 111, "Life", "Water", 10000, true, true, true, rs1,
				cs1);
		
		
		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadNominatedCandidate12", "Village2", "mondal2",
				"Dis2", "554321", null, null);
		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(300l, "v22345", "Shobbit", "kumar", "Bcrec2", "Male",
				"gen", "8876543210", "shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 578543, true, cs2);
		NominatedCandidates nc2 = new NominatedCandidates(200l, 222, "Death", "Fire", 20000, true, true, true, rs2,
				cs2);
		when(nominatedCandidatesRepository.findAll()).thenReturn(
				Stream.of(nc1, nc2)
						.collect(Collectors.toList()));
		assertEquals(2, nominatedCandidatesDao.getNominatedCandidatesList().size());
		
}

}	
	
	
	
	
	
	