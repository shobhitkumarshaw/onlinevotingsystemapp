package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.VotedListDao;
import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.society.repository.VotedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class VotedListTest {
	@Autowired
	private VotedListDao vlDao;
	@MockBean
	private VotedListRepository vlRepo;

//Add
	@Test
	@DisplayName("Test for adding VotedList")
	public void addVotedListTest() {
		CooperativeSociety cs1 = new CooperativeSociety("Banganj Society", "Mohan Tiwari", "Sathpur", "NagarMoti",
				"Nawada", "975310", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v1234", "Mihir", "Shaw", "mihirshaw1", "Male",
				"General", "9876543210", "mihir@gmail.com", "Moti Nagar", "NagarMoti", "Nawada", 975310, true, "Active",
				cs1);
		NominatedCandidates nc1 = new NominatedCandidates(1122, "Power", "Joint Hands", 20000, true, true, true, rs1,
				cs1);
		VotedList vl = new VotedList(LocalDateTime.of(2021, 05, 26, 8, 00), cs1, rs1, nc1);

		when(vlRepo.save(vl)).thenReturn(vl);
		assertEquals(vl, vlDao.save(vl));
	}

//UPDATE
	@Test
	@DisplayName("Test for updating VotedList")
	public void updateVotedListTest() {

		CooperativeSociety cs1 = new CooperativeSociety("Banganj Society", "Mohan Tiwari", "Sathpur", "NagarMoti",
				"Nawada", "975310", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v1234", "Mihir", "Shaw", "mihirshaw1", "Male",
				"General", "9876543210", "mihir@gmail.com", "Moti Nagar", "NagarMoti", "Nawada", 975310, true, "Active",
				cs1);
		NominatedCandidates nc1 = new NominatedCandidates(1122, "Power", "Joint Hands", 20000, true, true, true, rs1,
				cs1);
		VotedList vl = new VotedList(LocalDateTime.of(2021, 05, 26, 8, 00), cs1, rs1, nc1);

		vl.setPollingDateTime(LocalDateTime.of(2021, 06, 01, 9, 00));
		;
		assertThat(vlRepo.findById(vl.getId())).isNotEqualTo(vl);
	}

//DELETE
	@Test
	@DisplayName("Test for deleting VotedList")
	public void deleteVotedListTest() {

		CooperativeSociety cs1 = new CooperativeSociety("Banganj Society", "Mohan Tiwari", "Sathpur", "NagarMoti",
				"Nawada", "975310", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v1234", "Mihir", "Shaw", "mihirshaw1", "Male",
				"General", "9876543210", "mihir@gmail.com", "Moti Nagar", "NagarMoti", "Nawada", 975310, true, "Active",
				cs1);
		NominatedCandidates nc1 = new NominatedCandidates(1122, "Power", "Joint Hands", 20000, true, true, true, rs1,
				cs1);
		VotedList vl = new VotedList(LocalDateTime.of(2021, 05, 26, 8, 00), cs1, rs1, nc1);

		when(vlRepo.existsById(vl.getId())).thenReturn(true);
		vlDao.delete(vl.getId());
		verify(vlRepo).deleteById(vl.getId());
	}

//All VotedList
	@Test
	@DisplayName("Test for displaying list of VotedList")
	public void getVotedListTest() {
	// First Input
		CooperativeSociety cs1 = new CooperativeSociety("Banganj Society", "Mohan Tiwari", "Sathpur", "NagarMoti",
				"Nawada", "975310", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v1234", "Mihir", "Shaw", "mihirshaw1", "Male",
				"General", "9876543210", "mihir@gmail.com", "Moti Nagar", "NagarMoti", "Nawada", 975310, true, "Active",
				cs1);
		NominatedCandidates nc1 = new NominatedCandidates(1122, "Power", "Joint Hands", 20000, true, true, true, rs1,
				cs1);
		VotedList vl = new VotedList(LocalDateTime.of(2021, 05, 26, 8, 00), cs1, rs1, nc1);
	//Second Input
		CooperativeSociety cs2 = new CooperativeSociety("Gandhi Society", "Rahul Yadav", "Milanpur", "Chapra", "Saran",
				"875310", null, null);
		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters("v2234", "Rohit", "Kumar", "rohitkumar1", "Male",
				"Obc", "8876543210", "rohit@gmail.com", "Indra Nagar", "Chapra", "Saran", 875310, true, "Active", cs2);
		NominatedCandidates nc2 = new NominatedCandidates(2233, "Flying", "Birds", 30000, true, true, true, rs2, cs2);
		VotedList vl2 = new VotedList(LocalDateTime.of(2021, 10, 16, 8, 00), cs2, rs2, nc2);

		when(vlRepo.findAll()).thenReturn(Stream.of(vl, vl2).collect(Collectors.toList()));
		assertEquals(2, vlDao.getVotedList().size());
	}
//VotedList By VoterId
		@Test
		@DisplayName("Test for displaying Election Result by Id")
		public void getVotedListByVoterIdTest(){
			CooperativeSociety cs2 = new CooperativeSociety("Gandhi Society", "Rahul Yadav", "Milanpur", "Chapra", "Saran",
					"875310", null, null);
			RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters("v2234", "Rohit", "Kumar", "rohitkumar1", "Male",
					"Obc", "8876543210", "rohit@gmail.com", "Indra Nagar", "Chapra", "Saran", 875310, true, "Active", cs2);
			NominatedCandidates nc2 = new NominatedCandidates(2233, "Flying", "Birds", 30000, true, true, true, rs2, cs2);
			VotedList vl2 = new VotedList(LocalDateTime.of(2021, 10, 16, 8, 00), cs2, rs2, nc2);

			when(vlRepo.findByVoterIdCard("v2234")).thenReturn(vl2);
			assertEquals(vl2, vlDao.getByVoterId("v2234"));
}
//VotedList By NominatedCandidateId
		@Test
		@DisplayName("Test for displaying VotedList by NominatedCandidateId")
		public void getVotedListByNominatedCandidateIdTest(){
			CooperativeSociety cs2 = new CooperativeSociety("Gandhi Society", "Rahul Yadav", "Milanpur", "Chapra", "Saran",
					"875310", null, null);
			RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters("v2234", "Rohit", "Kumar", "rohitkumar1", "Male",
					"Obc", "8876543210", "rohit@gmail.com", "Indra Nagar", "Chapra", "Saran", 875310, true, "Active", cs2);
			NominatedCandidates nc2 = new NominatedCandidates(2233, "Flying", "Birds", 30000, true, true, true, rs2, cs2);
			VotedList vl2 = new VotedList(LocalDateTime.of(2021, 10, 16, 8, 00), cs2, rs2, nc2);
			
			when(vlRepo.findByNominatedCandidateId(nc2.getCandidateId())).thenReturn(vl2);
			assertEquals(vl2, vlDao.searchByNominatedCandidateId(nc2.getCandidateId()));
	}
}