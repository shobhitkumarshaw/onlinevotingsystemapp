package org.society;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.repository.ElectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sun.el.stream.Stream;

@Component
public class DBInitElectionResult implements CommandLineRunner {
	@Autowired
	ElectionResultRepository repo;

	@Override
	public void run(String... args) throws Exception {

//		CooperativeSociety cs = new CooperativeSociety(100l, "Taj", "Mahal", "Sathpur", "Mondal", "Saran", "123456");
//		RegisteredSocietyVoters rs = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc",
//				"9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
//		NominatedCandidates nc = new NominatedCandidates(33l, 2222l, "Shor", "Tiger", 25000f, true, true, true, rs);
//		ElectionResult er1 = new ElectionResult(10l, LocalDate.of(2021, 1, 26), nc, "Indra Nagar", 10000, 5000, 50,
//				2500, 50, "Win");
//		repo.save(er1);
//		
//		
//		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(2l, "22345", "Shobit", "Kumar", "Bcrec1", "Male",
//				"gen", "1876543210", "shobit@email.com", "add1", "add23", "mondal", "Dis", 178543, false, cs);
//
//		NominatedCandidates nc2 = new NominatedCandidates(22l, 3333l, "Life", "Water", 35000f, true, true, true, rs2);
//		ElectionResult er2 = new ElectionResult(10l, LocalDate.of(2021, 1, 26), nc2, "Mohit Nagar", 20000, 10000, 50,
//				5000, 50, "Loss");
//		repo.save(er2);
//		
//		
//		RegisteredSocietyVoters rs3 = new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar", "Bcrec3", "Male",
//				"obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543, true, cs);
//
//		NominatedCandidates nc3 = new NominatedCandidates(33l, 4444l, "Death", "Fire", 45000f, true, true, true, rs3);
//		ElectionResult er3 = new ElectionResult(10l, LocalDate.of(2021, 1, 26), nc3, "Ganga Nagar", 30000, 15000, 50,
//				7500, 50, "Win");
//		repo.save(er3);
		
		List<RegisteredSocietyVoters> regList = new ArrayList<>();
		
		CooperativeSociety cs = new CooperativeSociety("Name", "Head", "Village", "mandal", "dis", "12345678", null, null);
		regList.add(new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc", "9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs));
		List<NominatedCandidates> candidateList = new ArrayList<>();
		candidateList.add(new NominatedCandidates(2L, 788, "PartyName", "Symbol", 788, true, true, true, new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc", "9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs), cs));
		
		

		CooperativeSociety cs1 = new CooperativeSociety("Name", "Head", "Village", "mandal", "dis", "12345678", regList, candidateList);
		ElectionResult es = new ElectionResult(1l, LocalDate.now(), cs1, 7, 8, 7, 8, 8, "loosed");
		
		repo.save(es);
		
	}

}
