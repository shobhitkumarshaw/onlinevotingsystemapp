package org.society;

import java.util.ArrayList;
import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.repository.NominatedCandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitNominatedCandidates implements CommandLineRunner {
	@Autowired
	NominatedCandidatesRepository repo;

	@Override
	public void run(String... args) throws Exception {

		
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Village1", "mondal1", "Dis1", "12345678", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc", "9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 678543, true, cs1);
		NominatedCandidates nc1 = new NominatedCandidates(100l, 111, "Life", "Water",10000, true, true, true, rs1, cs1);
		repo.save(nc1);
		
		
		
		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadNominatedCandidate12", "Village2", "mondal2",
				"Dis2", "554321", null, null);
		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(300l, "v22345", "Shobbit", "kumar", "Bcrec2", "Male",
				"gen", "8876543210", "shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 578543, true, cs2);
		NominatedCandidates nc2 = new NominatedCandidates(200l, 222, "Death", "Fire", 20000, true, true, true, rs2,
				cs2);
		repo.save(nc2);
	}

}
