package org.society.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.ElectionResult;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.EmptyDataException;
import org.society.service.ElectionResultService;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestMapping("/api/ElectionResult")
public class ElectionResultController {
	@Autowired
	private ElectionResultService service;
	Logger logger = LoggerFactory.getLogger(ElectionResultController.class);

	
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

	
	@GetMapping(value = "{CandidateId}")
	public ResponseEntity<?> getResult(@PathVariable("CandidateId") long candidateId) {
		ElectionResult er = service.viewCandidatewiseResult(candidateId);
		if (er == null) {
			logger.error("No data found in Election Result database!");
			throw new ElectionResultNotFoundException("Election Result not found!");
		}
		logger.info("Admin id: " + candidateId + " found!");
		return new ResponseEntity<ElectionResult>(er, HttpStatus.OK);
	}

	@PostMapping
	public String saveResult(@Valid @RequestBody ElectionResult result) {
		service.addElectionResult(result);
		logger.info("Election Result added with id: " + result.getId());
		return "Election Result successfully saved";
	}

	@PutMapping
	public String updateResult(@Valid @RequestBody ElectionResult result) {

		service.updateElectionResult(result);
		logger.info("Elction Result with id: " + result.getId() + " updated!");
		return "Election Result successfully Updated";
	}

	@DeleteMapping("{CandidateId}")
	public String deleteResult(@PathVariable("CandidateId") long CandidateId) {

		service.deleteElectionResult(CandidateId);
		logger.info("Election Result with id: " + CandidateId + " deleted!");
		return "Election Result data successfully deleted";

	}

}