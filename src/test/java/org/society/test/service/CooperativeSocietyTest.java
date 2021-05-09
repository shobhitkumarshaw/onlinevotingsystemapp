package org.society.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.society.dao.CooperativeSocietyDao;
import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionResult;
import org.society.repository.CooporativeSocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CooperativeSocietyTest {
	@Autowired
	private CooperativeSocietyDao csDao;

	@MockBean
	private CooporativeSocietyRepository csRepo;

	// Test For Add
	@Test
	@DisplayName("Test for adding Election Result")
	public void addElectionResultDetailsTest() {

		CooperativeSociety cs1 = new CooperativeSociety("D Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321", null, null);
		when(csRepo.save(cs1)).thenReturn(cs1);
		assertEquals(cs1, csDao.save(cs1));
	}

	// Test For Update
	@Test
	@DisplayName("Test for updating Election Result")
	public void updateElectionResultDetailsTest() {

		CooperativeSociety cs3 = new CooperativeSociety("E Society", "HeadofResult3", "village3", "mandal3", "dis3",
				"454321", null, null);
		cs3.setSocietyName("Abc Society");
		assertThat(csRepo.findById(cs3.getId())).isNotEqualTo(cs3);
	}

}
