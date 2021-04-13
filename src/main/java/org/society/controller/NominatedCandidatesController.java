package org.society.controller;

import javax.validation.Valid;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.service.NominatedCandidatesService;
import org.society.service.RegisteredSocietyVotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestMapping("api/NominatedCandidates")
public class NominatedCandidatesController {
	@Autowired
	NominatedCandidatesService nominatedCandidatesService;

	@GetMapping(value = "{candidateId}")
	public ResponseEntity<?> getCandidateById(@PathVariable("candidateId") long id) {
		NominatedCandidates n = nominatedCandidatesService.searchByCandidateId(id);

		return new ResponseEntity<NominatedCandidates>(n, HttpStatus.OK);
	}

	@PostMapping
	public String saveResult(@Valid @RequestBody NominatedCandidates candidate) {
		nominatedCandidatesService.saveNominatedCandidate(candidate);
		return "candidate successfully saved";
	
}
}