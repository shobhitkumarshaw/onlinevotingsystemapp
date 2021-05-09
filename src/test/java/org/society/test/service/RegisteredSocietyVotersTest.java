/*
 *@author: Aditya Mohapatra 
 */

package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.RegisteredSocietyVotersDao;
import org.society.entities.CooperativeSociety;
import org.society.entities.RegisteredSocietyVoters;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class RegisteredSocietyVotersTest {

	@Autowired
	private RegisteredSocietyVotersDao registeredSocietyVotersDao;

	@MockBean
	private RegisteredSocietyVotersRepository registeredSocietyVotersRepository;

	@Test
	@DisplayName("Test for adding Registered Society VotersDetails")
	public void addRegisteredSocietyVotersDetailsTest() {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadOfCooperativeSociety1", "Village1", "mondal1",
				"Dis1", "654321", null, null);
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(100L, "v15976", "Rasmita",
				"Panda", "Female", "gen", "5463128795", "rasmita.panda@yahoo.com", "Berhampur", "Brahama Nagar",
				"Berhampur", 521463, false, "active", cs1);

		when(registeredSocietyVotersRepository.save(registeredSocietyVoters)).thenReturn(registeredSocietyVoters);
		assertEquals(registeredSocietyVoters, registeredSocietyVotersDao.save(registeredSocietyVoters, 1l));
	}

	@Test
	@DisplayName("Test for updating Registered Society Voters")
	public void updateRegisteredSocietyVotersTest() {
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(101L, "v56324", "Ashish", "Singh",
				"Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, false,
				"active", null);

		registeredSocietyVoters.setFirstName("Mohit");
		assertThat(registeredSocietyVotersRepository.findById(registeredSocietyVoters.getId()))
				.isNotEqualTo(registeredSocietyVoters);
	}

	@Test
	@DisplayName("Test for deleting Registered Society Voters")
	public void deleteRegisteredSocietyVotersTest() {
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(101L, "v56324", "Ashish", "Singh",
				"Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, false,
				"active", null);

		when(registeredSocietyVotersRepository.findByVoterIdCardNo(registeredSocietyVoters.getVoterIdCardNo()))
				.thenReturn(registeredSocietyVoters);
		registeredSocietyVotersDao.delete(registeredSocietyVoters.getVoterIdCardNo());
		verify(registeredSocietyVotersRepository).findByVoterIdCardNo("v56324");
	}

	@Test
	@DisplayName("Test for displaying  Registered Society Voters by VoterId Number")
	public void getVoterByVoterIdDetailsTest() {
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(100L, "v63792", "Kishore", "Pal",
				"Male", "st", "5549315672", "kishore.pal@outlook.com", "Japjpur", "Jappur Road", "Bhubhanswer", 634896,
				false, "active", null);

		when(registeredSocietyVotersRepository.findByVoterIdCardNo("v63792")).thenReturn(registeredSocietyVoters);
		assertEquals(registeredSocietyVoters, registeredSocietyVotersDao.getByVoterID("v63792"));
	}

	@Test
	@DisplayName("Test for displaying list of Registered Society Voters")
	public void getRegisteredVoterListTest() {

		RegisteredSocietyVoters registeredSocietyVoters1 = new RegisteredSocietyVoters(101L, "v56324", "Ashish",
				"Singh", "Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur",
				573942, false, "active", null);
		RegisteredSocietyVoters registeredSocietyVoters2 = new RegisteredSocietyVoters(100L, "v63792", "Kishore", "Pal",
				"Male", "st", "5549315672", "kishore.pal@outlook.com", "Japjpur", "Jappur Road", "Bhubhanswer", 634896,
				false, "active", null);

		when(registeredSocietyVotersRepository.findAll())
				.thenReturn(Stream.of(registeredSocietyVoters1, registeredSocietyVoters2).collect(Collectors.toList()));
		assertEquals(2, registeredSocietyVotersDao.getRegisteredVoterList().size());
	}
}