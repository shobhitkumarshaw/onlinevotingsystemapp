package org.society;

import java.time.LocalDateTime;

import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.society.repository.VotedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinitVotedList implements CommandLineRunner {
	@Autowired
	VotedListRepository votedListRepository;

	@Override
	public void run(String... args) throws Exception {


//		CooperativeSociety cs = new CooperativeSociety("A Society", "HeadOfCooperativeSociety1", "Village1", "mondal1", "Dis1", "654321", null, null);
//		RegisteredSocietyVoters regv = new RegisteredSocietyVoters("v56327", "Ashish", "Singh", "plmokn", "Male", "sc", "8521674392", "ashishsingh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, true, "active", cs);
//		NominatedCandidates cand = new NominatedCandidates(523698l, "yoga", "cycle", 5632014f, false, false, false, regv, cs);
//
//		votedListRepository.save(new VotedList(LocalDateTime.now(), cs, regv, cand));
	
	}
}