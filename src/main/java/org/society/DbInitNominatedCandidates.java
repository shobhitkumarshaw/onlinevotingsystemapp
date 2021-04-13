package org.society;

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
//CooperativeSociety cs = new CooperativeSociety(100l, "Taj", "Mahal", "Sathpur", "Mondal", "Saran", "123456");
		
//		RegisteredSocietyVoters rs = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc", "9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
//		NominatedCandidates nc = new NominatedCandidates(33l, 2222l, "Shor", "Tiger", 25000f, true, true, true,rs );
//		repo.save(nc);
//		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(2l, "22345", "Shobit", "Kumar", "Bcrec1", "Male", "gen", "1876543210", "shobit@email.com", "add1", "add23", "mondal", "Dis", 178543, false, cs);
//		NominatedCandidates nc2 = new NominatedCandidates(22l, 3333l, "Life", "Water", 35000f, true, true, true,rs2 );
//	repo.save(nc2);
//		RegisteredSocietyVoters rs3 = new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543, true, cs);
//		NominatedCandidates nc3 = new NominatedCandidates(33l, 4444l, "Death", "Fire", 45000f, true, true, true,rs3 );
//	repo.save(nc3);
		
		CooperativeSociety cs = new CooperativeSociety("Name", "HeadNominatedCandidate", "Village", "mandal", "dis", "12345678", null, null);
		RegisteredSocietyVoters rgv = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc", "9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
		NominatedCandidates cand = new NominatedCandidates(1L, 788, "PartyName", "Symbol", 788, true, true, true, rgv, cs);
		repo.save(cand);
	}

}
