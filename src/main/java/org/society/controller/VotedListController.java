package org.society.controller;

import org.society.service.VotedListService;
import org.springframework.beans.factory.annotation.Autowired;
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
	

}
