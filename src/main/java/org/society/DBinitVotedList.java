/*
 *@author: Aditya Mohapatra 
 */

package org.society;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionResult;
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
		
		
//		CooperativeSociety cs = new CooperativeSociety(1l, "BKgdgdggdgg", "Arun Sdgdgdg", "village", "mandal", "district", "7485");
//		
//		RegisteredSocietyVoters rs = new RegisteredSocietyVoters(1l, "12345", "shodgdgdg", "shawdgdg", "555fdgd", "male", "gen", "895255dgdgdd", "dummy@email.com", "add1", "add23", "mandal", "dis", 74441, false, cs);
//		
//		
//		NominatedCandidates nc = new NominatedCandidates(55l, 55588l, "Sjdlfgdjgl", "jjflll", 88885, true, true, true, rs);
//		
//		VotedList vl = new VotedList(1L, LocalDate.now(), cs, rs, nc, LocalTime.now(), LocalTime.now());
//		
//		votedListRepository.save(vl);
//		
//		RegisteredSocietyVoters rs2 = new RegisteredSocietyVoters(2l, "788f", "shodgdgdg", "shawdgdg", "555fdgd", "male", "gen", "895255dgdgdd", "dummy@email.com", "add1", "add23", "mandal", "dis", 74441, false, cs);
//
//		
//		VotedList v2 = new VotedList(2L, LocalDate.now(), cs, rs2, nc, LocalTime.now(), LocalTime.now());
//		
//		votedListRepository.save(v2);
		
		CooperativeSociety cs = new CooperativeSociety("Name", "HeadVoterList", "Village", "mandal", "dis", "12345678", null, null);
		RegisteredSocietyVoters regv = new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc", "9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, true, cs);
		NominatedCandidates cand = new NominatedCandidates(1L, 788, "PartyName", "Symbol", 788, true, true, true, regv, cs);
		
		votedListRepository.save(new VotedList(1, LocalDate.now(), cs, regv, cand, LocalTime.now(), LocalTime.now()));
		
		//System.out.println(votedListRepository.findByNominatedCandidateId(1l).toString());
		
		//System.out.println(votedListRepository.findByVoterIdCard("12345"));
		
		

	}

}