package org.society.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.EmptyDataException;
import org.society.exceptions.VoterNotFoundException;
import org.society.service.NominatedCandidatesService;
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
@RequestMapping("api/NominatedCandidates")
public class NominatedCandidatesController {

	
	@Autowired
	NominatedCandidatesService nominatedCandidatesService;
	Logger logger = LoggerFactory.getLogger(NominatedCandidatesController.class);

//Method to	get Nominated Candidates List by their ID
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getNominatedCandidatesById(@PathVariable("id") long id) {
		NominatedCandidates nominatedCandidates = nominatedCandidatesService.searchByCandidateId(id);
		if (nominatedCandidates == null) {
			logger.error("No data found with this id:"+ id +" in Nominated Candidates database!");
			throw new VoterNotFoundException("Nominated Candidates not found!");
		}
		logger.info("Nominated Candidates id: " + id + " found!");
		return new ResponseEntity<NominatedCandidates>(nominatedCandidates, HttpStatus.OK);
	}
	

//Method to get List of Nominated Candidates	
	@GetMapping
	public List<NominatedCandidates> getListOfNominatedCandidates() {
		
		List<NominatedCandidates> nominatedCandidatesList = nominatedCandidatesService.viewNominatedCandidatesList();
		if (nominatedCandidatesList.size() == 0) {
			logger.error("No data found in Nominated Candidates database!");
			throw new EmptyDataException("No Nominated Candidates in database!");
		}
		logger.info("Nominated Candidates list found!");
		return nominatedCandidatesList;
	}
	
//Method to Add Nominated Candidate Details 	
	@PostMapping("{voterIdNumber}/{societyId}")
	public String addNominatedCandidateDetails(@Valid @RequestBody NominatedCandidates candidate,
			@PathVariable("voterIdNumber") String voterId, 
			@PathVariable("societyId") long societyId) {
		nominatedCandidatesService.saveNominatedCandidate(candidate, voterId, societyId);
		logger.info("Nominated Candidates added with id: "+candidate.getCandidateId());
		return "Nominated Candidates added successfully!";
	}

//Method to Update Nominated Candidate Details	
	@PutMapping
	public String updateNominatedCandidatesDetails(@Valid @RequestBody NominatedCandidates candidate) {
		
		nominatedCandidatesService.updateNominatedCandidateDetails(candidate);
		logger.info("Nominated Candidates with id: "+candidate.getCandidateId() + " updated!");
		return "Nominated Candidates details updated successfully!";
		
	}
	
//Method to Delete Nominated Candidate Details	
	@DeleteMapping(value = "{id}")
	public String deleteNominatedCandidatesDetailsById(@PathVariable("id") long id) {
		nominatedCandidatesService.deleteNominatedCandididate(id);
		logger.info("Nominated Candidates with id: "+ id + " deleted!");
		return "Nominated Candidates removed successfully!";
	}
	
}