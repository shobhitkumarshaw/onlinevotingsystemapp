package org.society.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.VotedList;
import org.society.exceptions.EmptyDataException;
import org.society.exceptions.VoterNotFoundException;
import org.society.service.VotedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/voted_list")
public class VotedListController {
	Logger logger = LoggerFactory.getLogger(VotedListController.class);

	@Autowired
	private VotedListService service;

	@PutMapping("{scoietyId}/{nominatedCandidateId}/{voterIdNumber}")
	public String castVote(@PathVariable("scoietyId") long scoietyId,
			@PathVariable("nominatedCandidateId") long nominatedCandidateId,
			@PathVariable("voterIdNumber") String voterIdNumber) {

		service.castVote(scoietyId, nominatedCandidateId, voterIdNumber);

		return "Vote added successfully!";

	}

	@GetMapping
	public List<VotedList> getVotedList() {
		List<VotedList> votedList = service.viewVotedList();
		if (votedList.size() == 0) {
			new EmptyDataException("Voted List is empty!");
		}
		return votedList;
	}

	@PostMapping
	public String addVotedListDetails(@Valid @RequestBody VotedList votedList) {
		service.addVotedList(votedList);
		logger.info("VotedList added with id: " + votedList.getId());
		return "VotedList successfully saved";
	}

	@PutMapping
	public String updateVotedList(@Valid @RequestBody VotedList votedList) {

		service.updateVotedListDetails(votedList);
		logger.info("Elction Result with id: " + votedList.getId() + " updated!");
		return "VotedList successfully Updated";
	}

	@DeleteMapping("{id}")
	public String deleteVotedList(@PathVariable("id") long id) {

		service.deletedVotedListDetails(id);
		logger.info("VotedList with id: " + id + " deleted!");
		return "VotedList data successfully deleted";
	}

	@GetMapping(value = "{voterId}")
	public ResponseEntity<?> getVotedListByVoterId(@PathVariable("voterId") String voterId) {
		VotedList vl = service.searchByVoterId(voterId);
		if (vl == null) {
			logger.error("No data found with this Voter Id:" + voterId + " in VotedList database!");
			throw new VoterNotFoundException("VotedList not found!");
		}
		logger.info("Voter id with: " + voterId + " is found in VotedList database!");
		return new ResponseEntity<VotedList>(vl, HttpStatus.OK);
	}

	@GetMapping(value = "{nominatedCandidateId}")
	public ResponseEntity<?> getVotedListByNominatedCandidateId(
			@PathVariable("nominatedCandidateId") long nominatedCandidateId) {
		VotedList v2 = service.searchByNominatedCandidateId(nominatedCandidateId);
		if (v2 == null) {
			logger.error("No data found with this nominated candidate id:" + nominatedCandidateId
					+ " in VotedList database!");
			throw new VoterNotFoundException("VotedList not found!");
		}
		logger.info("Nominated Candidate id with: " + nominatedCandidateId + " is found in VotedList database!");
		return new ResponseEntity<VotedList>(v2, HttpStatus.OK);
	}
}