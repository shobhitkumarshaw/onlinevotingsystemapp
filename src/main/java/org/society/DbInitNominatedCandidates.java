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

		
		NominatedCandidates nc1 = new NominatedCandidates(111L, "Life", "Water",10000, true, true, true, null, null);
		repo.save(nc1);
		
		
		NominatedCandidates nc2 = new NominatedCandidates(222L, "Death", "Fire", 20000, true, true, true, null,
				null);
		repo.save(nc2);
		NominatedCandidates nc3 = new NominatedCandidates(333L, "Game", "Thrones", 30000, true, true, true, null,
				null);
		repo.save(nc3);
		
		NominatedCandidates nc4 = new NominatedCandidates(444L, "Peaky", "Blinder", 40000, true, true, true, null,
				null);
		repo.save(nc4);
		
		NominatedCandidates nc5 = new NominatedCandidates(555L, "Naruto", "Kurama", 50000, true, true, true, null,
				null);
		repo.save(nc5);
		
		
		
		
	}

}
