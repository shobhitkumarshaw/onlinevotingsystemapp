package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
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
		//RegisteredSocietyVoters  registeredSocietyVoters= new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543, true, null);
		//when(registeredSocietyVotersRepository.save(registeredSocietyVoters)).thenReturn(registeredSocietyVoters);
		//assertEquals(registeredSocietyVoters, registeredSocietyVotersDao.save(registeredSocietyVoters));
	
	
/*
		List<RegisteredSocietyVoters> regList = new ArrayList<>();
		List<NominatedCandidates> candidateList = new ArrayList<>();
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321",regList,candidateList);
		regList.add(new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc", "9876543210",
				"mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1));
		
		candidateList
				.add(new NominatedCandidates(100L, 111, "Life", "Water", 10000, true, true, true,
						new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc",
								"9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1),
						cs1));
		
		RegisteredSocietyVoters rs1=new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw","Bcrec1", "Male", "obc", "9876543210", "mihir@gmail.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1);
		when(registeredSocietyVotersRepository.save(rs1)).thenReturn(rs1);
		assertEquals(rs1, registeredSocietyVotersDao.save(rs1));
	
	*/
	}
}