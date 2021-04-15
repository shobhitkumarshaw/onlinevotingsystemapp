package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v56324", "Ashish", "Singh", "plmokn", "Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, false, "active", cs1);
		NominatedCandidates nc1 = new NominatedCandidates(523698l, "yoga", "cycle", 5632014f, false, false, false, rs1, cs1);

		when(nominatedCandidatesRepository.save(nc1)).thenReturn(nc1);
		assertEquals(nc1, nominatedCandidatesDao.save(nc1,"v12345",1l));
	}
	
	// Update
	@Test
	public void updateNominatedCandidatesDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v56324", "Ashish", "Singh", "plmokn", "Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, false, "active", cs1);
		NominatedCandidates nc1 = new NominatedCandidates(523698l, "yoga", "cycle", 5632014f, false, false, false, rs1, cs1);

		nc1.setSecurityDeposit(25000);
		assertThat(nominatedCandidatesRepository.findById(nc1.getCandidateId())).isNotEqualTo(nc1);
	}

	// Delete
	@Test
	public void deleteNominatedCandidatesDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v56324", "Ashish", "Singh", "plmokn", "Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, false, "active", cs1);
		NominatedCandidates nc1 = new NominatedCandidates(523698l, "yoga", "cycle", 5632014f, false, false, false, rs1, cs1);
		when(nominatedCandidatesRepository.existsById(nc1.getCandidateId())).thenReturn(true);
		nominatedCandidatesDao.delete(nc1.getCandidateId());
		verify(nominatedCandidatesRepository).deleteById(100l);
	}

	// getById
	@Test
	@DisplayName("Test for displaying nominated Candidate by Id")
	public void getNominatedCandidateByIdDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1",
				"Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v56324", "Ashish", "Singh", "plmokn", "Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, false, "active", cs1);
		NominatedCandidates nc1 = new NominatedCandidates(523698l, "yoga", "cycle", 5632014f, false, false, false, rs1, cs1);
		when(nominatedCandidatesRepository.findById(100l)).thenReturn(Optional.of(nc1));
		assertEquals(nc1, nominatedCandidatesDao.getByCandidateId(100l));
	}
}