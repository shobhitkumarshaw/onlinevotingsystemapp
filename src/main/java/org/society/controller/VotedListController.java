/*
 * @author: Aditya Mohapatra
 */

package org.society.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.VotedList;
import org.society.exceptions.EmptyDataException;
import org.society.service.ValidateLogin;
import org.society.service.VotedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/votedList")
public class VotedListController {
	Logger logger = LoggerFactory.getLogger(VotedListController.class);

	@Autowired
	private VotedListService service;
	
	@Autowired
	private ValidateLogin login;

	// Method for Casting Vote
	@GetMapping("{scoietyId}/{nominatedCandidateId}/{voterIdNumber}")
	public String castVote(@PathVariable("scoietyId") long scoietyId,
			@PathVariable("nominatedCandidateId") long nominatedCandidateId,
			@PathVariable("voterIdNumber") String voterIdNumber) {
		
		service.castVote(scoietyId, nominatedCandidateId, voterIdNumber);

		return "Vote added successfully!";

	}

	// Method to get the Voted List
	@GetMapping
	public List<VotedList> getVotedList(HttpServletRequest request) {
		//login.validateToken(request, "ElectionOfficer");
		List<VotedList> votedList = service.viewVotedList();
		if (votedList.size() == 0) {
			new EmptyDataException("Voted List is empty!");
		}
		return votedList;
	}
}