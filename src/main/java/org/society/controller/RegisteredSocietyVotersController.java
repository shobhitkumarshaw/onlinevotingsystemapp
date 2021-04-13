package org.society.controller;

import org.society.entities.RegisteredSocietyVoters;
import org.society.service.RegisteredSocietyVotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/RegisteredSocietyVoter")
public class RegisteredSocietyVotersController {

	@Autowired
	RegisteredSocietyVotersService registeredSocietyVotersService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getRegisteredSocietyVoterById(@PathVariable("id") String id) {
		RegisteredSocietyVoters r = registeredSocietyVotersService.searchByVoterID(id);

		return new ResponseEntity<RegisteredSocietyVoters>(r, HttpStatus.OK);
	}
}