/*
 * Author- Govind Kidambi
 */

package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

	//Add Nominated Candidates Details
	@Test
	@DisplayName("Test for adding Nominated Candidates Details")
	public void addNominatedCandidatesDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Sathpur", "Gandhi Nagar", "Jajapur", "123456", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Male", "obc", "9876543210", "mihir@email.com", "Orissa","Gandhi Nagar", "Jajapur",123456 , true,"active", cs1);
		NominatedCandidates nc1 = new NominatedCandidates(111L, "Life", "Water",10000, true, true, true, rs1, cs1);
		
		when(nominatedCandidatesRepository.save(nc1)).thenReturn(nc1);
		assertEquals(nc1, nominatedCandidatesDao.save(nc1,"v12345",1l));
	}
	
	// Update Nominated Candidates Details
	@Test
	@DisplayName("Test for Updating Nominated Candidates Details")
	public void updateNominatedCandidatesDetailsTest() {
		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadNominatedCandidate12", "Motipur", "Mouna Nagar",
				"Saran", "223456", null, null);
		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(300l, "v22345", "Shobbit", "kumar", "Male",
				"gen", "8876543210", "shobbit@email.com", "Chapra", "Mouna Nagar", "Saran", 223456, true,"active", cs2);
		NominatedCandidates nc2 = new NominatedCandidates(222L, "Death", "Fire", 20000, true, true, true, rs2,
				cs2);
		
		nc2.setSecurityDeposit(25000);
		assertThat(nominatedCandidatesRepository.findById(nc2.getNominationFormNo())).isNotEqualTo(nc2);
	}

	

	// Method to  get by Id
	@Test
	@DisplayName("Test for displaying nominated Candidate by Id")
	public void getNominatedCandidateByIdDetailsTest() {
		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadNominatedCandidate12", "Motipur", "Mouna Nagar",
				"Saran", "223456", null, null);
		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(300l, "v22345", "Shobbit", "kumar", "Male",
				"gen", "8876543210", "shobbit@email.com", "Chapra", "Mouna Nagar", "Saran", 223456, true,"active", cs2);
		NominatedCandidates nc2 = new NominatedCandidates(222L, "Death", "Fire", 20000, true, true, true, rs2,
				cs2);
		when(nominatedCandidatesRepository.findById(222L)).thenReturn(Optional.of(nc2));
		assertEquals(nc2, nominatedCandidatesDao.getByCandidateId(222l));
	}
}