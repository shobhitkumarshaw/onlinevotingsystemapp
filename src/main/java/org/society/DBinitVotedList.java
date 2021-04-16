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

		

		CooperativeSociety cs = new CooperativeSociety("E Society", "HeadOfCooperativeSociety1", "Village1", "mondal1", "Dis1", "654321", null, null);
		RegisteredSocietyVoters rs = new RegisteredSocietyVoters("v54321", "Ashish", "Singh", "plmokn", "Male", "sc", "5521674392", "ashish.singh@gmail.com", "Rayagada", "Kotepada", "Gunupur", 573942, true, "active", cs);
		NominatedCandidates nc = new NominatedCandidates(523698, "yoga", "cycle", 56000, true, true, true, rs, cs);
		votedListRepository.save(new VotedList(LocalDateTime.now(), cs, rs, nc));
		
		
		CooperativeSociety cs1 = new CooperativeSociety("C Society", "HeadOfCooperativeSociety2", "Village2", "mondal2", "Dis2", "754321", null, null);
		RegisteredSocietyVoters rs1 = new RegisteredSocietyVoters("v44321", "Shanu", "Singh", "plmokn", "Male", "gen", "9521674392", "ashish.singh@gmail.com", "Rayagada", "Kotepada", "Gunupur", 573942, true, "active", cs1);
		NominatedCandidates nc1 = new NominatedCandidates(123698, "Win", "Fan", 66000, true, true, true, rs1, cs1);
		votedListRepository.save(new VotedList(LocalDateTime.of(2021, 05, 15, 8, 00), cs1, rs1, nc1));
		
		//RegisteredSocietyVoters rs3 = new RegisteredSocietyVoters("v34321", "Ritik", "Kumar", "Bcrec1", "Male", "Obc", "9876543210","ritik@gmail.com", "ad1", "mondal1", "saran", 841301, true, "active", cs1);
		//votedListRepository.save(new VotedList(LocalDateTime.of(2021, 05, 15, 8, 00), cs1, rs3, nc1));

	}
}