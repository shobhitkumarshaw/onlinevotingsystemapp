package org.society.controller;

import java.util.List;

import org.society.entities.VotedList;
import org.society.exceptions.EmptyDataException;
import org.society.service.VotedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/voted_list")
public class VotedListController {
	
	@Autowired
	private VotedListService service;
	
	@PutMapping("{scoietyId}/{nominatedCandidateId}/{voterIdNumber}")
	public String castVote(@PathVariable("scoietyId") long scoietyId,
			@PathVariable("nominatedCandidateId") long nominatedCandidateId,
			@PathVariable("voterIdNumber") String voterIdNumber) {
		
		service.castVote(scoietyId,nominatedCandidateId, voterIdNumber);
		
		return "Vote added successfully!";
		
	}

	@GetMapping
	public List<VotedList> getVotedList(){
		List<VotedList> votedList = service.viewVotedList();
		if(votedList.size() == 0) {
			new EmptyDataException("Voted List is empty!");
		}
		return votedList;
	}

}
