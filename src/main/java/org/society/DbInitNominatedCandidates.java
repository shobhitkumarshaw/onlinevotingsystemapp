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

		
		//CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadNominatedCandidate1", "Sathpur", "Gandhi Nagar", "Jajapur", "123456", null, null);
		//RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Male", "obc", "9876543210", "mihir@email.com", "Orissa","Gandhi Nagar", "Jajapur",123456 , true,"active", cs1);
		NominatedCandidates nc1 = new NominatedCandidates(111L, "Life", "Water",10000, true, true, true, null, null);
		repo.save(nc1);
		
		
		/*
		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadNominatedCandidate12", "Motipur", "Mouna Nagar",
				"Saran", "223456", null, null);
		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(300l, "v22345", "Shobbit", "kumar", "Male",
			"gen", "8876543210", "shobbit@email.com", "Chapra", "Mouna Nagar", "Saran", 223456, true,"active", cs2);
		*/
		NominatedCandidates nc2 = new NominatedCandidates(222L, "Death", "Fire", 20000, true, true, true, null,
				null);
		repo.save(nc2);
	
		
		
	}

}
