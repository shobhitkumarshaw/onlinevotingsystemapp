package org.society;

import java.time.LocalDate;

import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionResult;
import org.society.repository.ElectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbinitElectionResult implements CommandLineRunner{

	@Autowired
	ElectionResultRepository repo;
	@Override
	public void run(String... args) throws Exception {
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321", null, null);
		ElectionResult er1 = new ElectionResult(LocalDate.now(), cs1, 20000, 10000, 50, 6000, 60, "Win");
		repo.save(er1);
		
		CooperativeSociety cs2 = new CooperativeSociety("c Society", "HeadofResult3", "village3", "mandal3", "dis3",
				"454321", null, null);
		ElectionResult er2 = new ElectionResult(LocalDate.now(), cs2, 30000, 15000, 50, 6000, 40, "loss");
		repo.save(er2);
		
		CooperativeSociety cs3 = new CooperativeSociety("B Society", "HeadofResult2", "village2", "mandal2", "dis2",
				"554321", null, null);
		ElectionResult er3 = new ElectionResult(LocalDate.now(), cs3, 10000, 5000, 50, 1500, 30, "loss");
		repo.save(er3);
	}

}
