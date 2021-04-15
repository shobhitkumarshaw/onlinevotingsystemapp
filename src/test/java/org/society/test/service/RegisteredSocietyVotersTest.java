package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.RegisteredSocietyVotersDao;
import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
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
	public void addRegisteredSocietyVotersDetailsTest() {
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar",
				"Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543,
				true, null);
		when(registeredSocietyVotersRepository.save(registeredSocietyVoters)).thenReturn(registeredSocietyVoters);
		assertEquals(registeredSocietyVoters, registeredSocietyVotersDao.save(registeredSocietyVoters));

	}

	@Test
	@DisplayName("Test for updating Registered Society Voters")
	public void updateRegisteredSocietyVotersTest() {
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar",
				"Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543,
				true, null);
		registeredSocietyVoters.setFirstName("Mohit");
		assertThat(registeredSocietyVotersRepository.findById(registeredSocietyVoters.getId()))
				.isNotEqualTo(registeredSocietyVoters);

	}

	@Test

	@DisplayName("Test for deleting Registered Society Voters")
	public void deleteRegisteredSocietyVotersTest() {
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar",
				"Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543,
				true, null);
		when(registeredSocietyVotersRepository.findByVoterIdCardNo(registeredSocietyVoters.getVoterIdCardNo())).thenReturn(registeredSocietyVoters);
		registeredSocietyVotersDao.delete(registeredSocietyVoters.getVoterIdCardNo());
		verify(registeredSocietyVotersRepository).findByVoterIdCardNo("32345");

	}

	@Test

	@DisplayName("Test for displaying  Registered Society Voters by VoterId Number")
	public void getVoterByVoterIdDetailsTest() {
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar",
				"Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543,
				true, null);

		when(registeredSocietyVotersRepository.findByVoterIdCardNo("32345")).thenReturn(registeredSocietyVoters);
		assertEquals(registeredSocietyVoters, registeredSocietyVotersDao.getByVoterID("32345"));
	}
	
	@Test
	@DisplayName("Test for displaying list of Registered Society Voters")
	public void getRegisteredVoterListTest() {

		RegisteredSocietyVoters registeredSocietyVoters1 = new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar",
				"Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543,
				true, null);
		RegisteredSocietyVoters registeredSocietyVoters2=new RegisteredSocietyVoters(2l, "22345", "Shobit", "Kumar", "Bcrec1", "Male", "gen", "1876543210", "shobit@email.com", "add1", "add23", "mondal", "Dis", 178543, false, null);
		
		when(registeredSocietyVotersRepository.findAll()).thenReturn(
				Stream.of(registeredSocietyVoters1, registeredSocietyVoters2)
						.collect(Collectors.toList()));
		assertEquals(2, registeredSocietyVotersDao.getRegisteredVoterList().size());
	
	
	}
}

















