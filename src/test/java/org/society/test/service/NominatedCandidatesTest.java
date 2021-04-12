package org.society.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.society.dao.NominatedCandidatesDao;
import org.society.entities.NominatedCandidates;
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

	@Test
	public void addNominatedCandidatesDetailsTest() {
		NominatedCandidates  nominatedCandidates= new NominatedCandidates();
		when(nominatedCandidatesRepository.save(nominatedCandidates)).thenReturn(nominatedCandidates);
		assertEquals(nominatedCandidates, nominatedCandidatesDao.save(nominatedCandidates));
	}


}
