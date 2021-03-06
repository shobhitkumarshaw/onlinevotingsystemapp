package org.society.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.dao.ElectionResultDao;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.EmptyDataException;
import org.society.model.Result;
import org.society.service.ElectionResultService;
import org.society.service.ValidateLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/ElectionResult")
public class ElectionResultController {
	@Autowired
	private ElectionResultService service;
	
	@Autowired
	private ValidateLogin login;
	
	@Autowired
	private ElectionResultDao dao;
	
	Logger logger = LoggerFactory.getLogger(ElectionResultController.class);

	// Method to Get the Election Result list
	@GetMapping
	public List<ElectionResult> getAllResult() {
		List<ElectionResult> list = service.viewElectionResultList();
		if (list.size() == 0) {
			logger.error("No data found in Election Result database!");
			throw new EmptyDataException("No result in database!");
		}
		logger.info("Election Result list found!");
		return list;
	}

	// Method to get Election Result by their ID
	@GetMapping(value = "{CandidateId}")
	public ResponseEntity<?> getResult(@PathVariable("CandidateId") long candidateId) {
		ElectionResult er = service.viewCandidatewiseResult(candidateId);
		if (er == null) {
			logger.error("No data found with this id:" + candidateId + " in Election Result database!");
			throw new ElectionResultNotFoundException("Election Result not found!");
		}
		logger.info("Election Result with id: " + candidateId + " found!");
		return new ResponseEntity<ElectionResult>(er, HttpStatus.OK);
	}

	// Method to save the Election Result
	@PostMapping
	public String saveResult(@Valid @RequestBody ElectionResult result,HttpServletRequest request) {
		login.validateToken(request, "ElectionOfficer");
		service.addElectionResult(result);
		logger.info("Election Result added with id: " + result.getId());
		return "Election Result successfully saved";
	}

	// Method to Update the Election Result
	@PutMapping
	public String updateResult(@Valid @RequestBody ElectionResult result,HttpServletRequest request) {
		login.validateToken(request, "ElectionOfficer");
		service.updateElectionResult(result);
		logger.info("Elction Result with id: " + result.getId() + " updated!");
		return "Election Result successfully Updated";
	}

	// Method to Delete the Election Result details
	@DeleteMapping("{CandidateId}")
	public String deleteResult(@PathVariable("CandidateId") long CandidateId,HttpServletRequest request) {
		login.validateToken(request, "ElectionOfficer");
		service.deleteElectionResult(CandidateId);
		logger.info("Election Result with id: " + CandidateId + " deleted!");
		return "Election Result data successfully deleted";
	}

	// Method to view Nominated Candidate with Highest Voting Percentage
	@GetMapping("NominatedCandidateWithHighestVotingPercent")
	public NominatedCandidates viewHighestVotingPercentCandidate() {
		return service.viewHighestVotingPercentCandidate();
	}

	// Method to view Nominated Candidate with Lowest Voting Percentage
	@GetMapping("NominatedCandidateWithLowestVotingPercent")
	public NominatedCandidates viewLowestVotingPercentCandidate() {
		return service.viewLowestVotingPercentCandidate();
	}

	// Method for Invalid Votes
	@GetMapping("InvalidVotes")
	public double viewInvalidVotes() {
		return service.viewInvalidVotes();
	}
	
	@GetMapping("Result")
	public List<Result> getResult(){
		return dao.getResult();
	}

}
