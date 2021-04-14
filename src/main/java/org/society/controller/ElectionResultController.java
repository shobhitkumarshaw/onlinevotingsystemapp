package org.society.controller;

import java.util.List;

import javax.validation.Valid;

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

	
	@GetMapping
	public List<ElectionResult> getAllResult() {
		List<ElectionResult> list = service.viewElectionResultList();
		if (list.size() == 0) {
			throw new EmptyDataException("No result in database!");
		}
		return list;
	}

	
	@GetMapping(value = "{CandidateId}")
	public ResponseEntity<?> getResult(@PathVariable("CandidateId") long candidateId) {
		ElectionResult er = service.viewCandidatewiseResult(candidateId);
		if (er == null)
			throw new ElectionResultNotFoundException("Election Result not found!");

		return new ResponseEntity<ElectionResult>(er, HttpStatus.OK);
	}

	@PostMapping
	public String saveResult(@Valid @RequestBody ElectionResult result) {
		service.addElectionResult(result);
		return "Election Result successfully saved";
	}

	@PutMapping
	public String updateResult(@Valid @RequestBody ElectionResult result) {

		service.updateElectionResult(result);
		return "Election Result successfully Updated";
	}

	@DeleteMapping("{CandidateId}")
	public String deleteResult(@PathVariable("CandidateId") long CandidateId) {

		service.deleteElectionResult(CandidateId);
		return "Election Result data successfully deleted";

	}

}