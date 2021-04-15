package org.society.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.ElectionOfficer;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.EmptyDataException;
import org.society.service.ElectionOfficerService;
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
@RequestMapping("/api/ElectionOfficer")
public class ElectionOfficerController {

	Logger logger = LoggerFactory.getLogger(ElectionOfficerController.class);

	@Autowired
	private ElectionOfficerService service;
	
	@Autowired
	private NominatedCandidatesService candidateService;

	@GetMapping(value = "{id}")
	public ResponseEntity<?> getElectionOfficerById(@PathVariable("id") long id) {
		// Duplicate validation is done in DAO part. If Exception is thrown than it will
		// be propagated to ApplicationExecptionHandler class
		
		ElectionOfficer officer = service.viewElectionOfficerById(id);
		logger.info("Election Officer id: " + id + " found!");
		return new ResponseEntity<ElectionOfficer>(officer, HttpStatus.OK);
		
	}

	@GetMapping
	public List<ElectionOfficer> getListOfElectionOfficer() {

		List<ElectionOfficer> officerList = service.viewElectionOfficerList();
		if (officerList.size() == 0) {
			logger.error("No data found in election officer database!");
			throw new EmptyDataException("No Election officer in database!");
		}
		logger.info("Election Officer list found!");
		return officerList;
	}

	@PostMapping
	public String addElectionOfficerDetails(@Valid @RequestBody ElectionOfficer officer) {

		service.addElectionOfficerDetails(officer);
		logger.info("Election Officer added with id: "+officer.getId());
		return "Election Officer Details added successfully!";

	}

	@PutMapping
	public String updateElectionOfficerDetails(@Valid @RequestBody ElectionOfficer officer) {

		service.updateElectionOfficerDetails(officer);
		logger.info("Election Officer with id: "+officer.getId() + " updated!");
		return "Election Officer with id: " + officer.getId() + " updated successfully!";

	}

	@DeleteMapping(value = "{id}")
	public String deleteElectionOfficerDetailsById(@PathVariable("id") long id) {
		service.deleteElectionOfficer(id);
		logger.info("Election Officer with id: "+ id + " deleted!");
		return "Election Officer with id: " + id + " removed successfully !";
	}
	
	@GetMapping(value = "{candidateId}/{approval}")
	public String approveCandidate(@PathVariable("candidateId") long id, 
			@PathVariable("approval") String approval) {
		if(approval.equalsIgnoreCase("PASS")) {
			NominatedCandidates candidate = candidateService.searchByCandidateId(id);
			candidate.setApprovedByElectionOfficer(true);
			candidate.setOathOrAffirmationSummited(true);
			candidate.setPoliceVerificationDone(true);
			candidateService.updateNominatedCandidateDetails(candidate);
			return "Nominated Candidate with id: "+id+" approval successfull!";
		}
		else if(approval.equalsIgnoreCase("REJECTED")) {
			NominatedCandidates candidate = candidateService.searchByCandidateId(id);
			candidate.setApprovedByElectionOfficer(false);
			candidate.setOathOrAffirmationSummited(false);
			candidate.setPoliceVerificationDone(false);
			candidateService.updateNominatedCandidateDetails(candidate);
			return "Nominated Candidate with id: "+id+" approval rejected!";
			
		}
		else
			return "Wrong input for approval. Enter pass or rejected!";
		
	}
		
	
}