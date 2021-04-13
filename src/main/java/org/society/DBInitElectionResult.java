package org.society;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

		//First input
		
		
		List<RegisteredSocietyVoters> regList = new ArrayList<>();

		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadofResult1", "Village1", "mandal1", "dis1",
				"654321", null, null);
		regList.add(new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc", "9876543210",
				"mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1));
		List<NominatedCandidates> candidateList = new ArrayList<>();
		candidateList
				.add(new NominatedCandidates(100L, 111, "Life", "Water", 10000, true, true, true,
						new RegisteredSocietyVoters(200l, "v12345", "Mihir", "shaw", "Bcrec1", "Male", "obc",
								"9876543210", "mihir@email.com", "add1", "add2", "mondal1", "Dis1", 654321, true, cs1),
						cs1));

		ElectionResult es1 = new ElectionResult(300l, LocalDate.now(), cs1, 20000, 10000, 50, 5000, 50, "loosed");
		repo.save(es1);

		
		
		//Second input
		
		
		List<RegisteredSocietyVoters> regList2 = new ArrayList<>();

		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadofResult2", "village2", "mandal2", "dis2",
				"554321", null, null);
		regList2.add(new RegisteredSocietyVoters(201l, "v22345", "Shobbit", "Kumar", "Bcrec2", "Male", "gen",
				"8876543210", "shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 554321, true, cs2));
		List<NominatedCandidates> candidateList2 = new ArrayList<>();
		candidateList2.add(new NominatedCandidates(101L, 222, "Death", "Fire", 20000, true, true, true,
				new RegisteredSocietyVoters(201l, "v22345", "Shobbit", "Kumar", "Bcrec2", "Male", "gen", "8876543210",
						"shobbit@email.com", "add2", "add3", "mondal2", "Dis2", 554321, true, cs2),
				cs2));

		ElectionResult es2 = new ElectionResult(301l, LocalDate.now(), cs2, 10000, 5000, 50, 2500, 50, "Win");
		repo.save(es2);

		
		
		//Third input

		
		List<RegisteredSocietyVoters> regList3 = new ArrayList<>();

		CooperativeSociety cs3 = new CooperativeSociety("c Society", "HeadofResult3", "village3", "mandal3", "dis3",
				"454321", null, null);
		regList3.add(new RegisteredSocietyVoters(201l, "v32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc",
				"7876543210", "aditya@email.com", "add3", "add4", "mondal3", "Dis3", 454321, true, cs3));
		List<NominatedCandidates> candidateList3 = new ArrayList<>();
		candidateList3
				.add(new NominatedCandidates(102L, 333, "Shor", "Tiger", 30000, true, true, true,
						new RegisteredSocietyVoters(202l, "v32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc",
								"7876543210", "aditya@email.com", "add3", "add4", "mondal3", "Dis3", 454321, true, cs3),
						cs3));

		ElectionResult es3 = new ElectionResult(302l, LocalDate.now(), cs3, 30000, 15000, 50, 7500, 50, "loss");
		repo.save(es3);


	}

}
