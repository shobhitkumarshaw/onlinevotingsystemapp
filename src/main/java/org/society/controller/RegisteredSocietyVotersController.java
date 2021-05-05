
package org.society.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.EmptyDataException;
import org.society.exceptions.VoterNotFoundException;
import org.society.service.RegisteredSocietyVotersService;
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
@RequestMapping("/api/RegisteredSocietyVoter")
public class RegisteredSocietyVotersController {

	@Autowired
	RegisteredSocietyVotersService registeredSocietyVotersService;
	Logger logger = LoggerFactory.getLogger(RegisteredSocietyVotersController.class);

	//Method to get Registered Society Voter by their Voter Card Number 	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getRegisteredSocietyVoterByVoterCardNo(@PathVariable("id") String id) {
		RegisteredSocietyVoters registeredSocietyVoters = registeredSocietyVotersService.searchByVoterID(id);
		if (registeredSocietyVoters == null) {
			logger.error("No data found with this id:" + id + " in Registered Society Voter database!");
			throw new VoterNotFoundException("Registered Society Voter not found!");
		}
		logger.info("Registered Society Voter id: " + id + " found!");
		return new ResponseEntity<RegisteredSocietyVoters>(registeredSocietyVoters, HttpStatus.OK);
	}

	//Method to get the list of Registered Society Voters	
	@GetMapping
	public List<RegisteredSocietyVoters> getListOfRegisteredSocietyVoters() {

		List<RegisteredSocietyVoters> registeredSocietyVotersList = registeredSocietyVotersService
				.viewRegisteredVoterList();
		if (registeredSocietyVotersList.size() == 0) {
			logger.error("No data found in Registered Society Voter database!");
			throw new EmptyDataException("No Registered Voter in database!");
		}
		logger.info("Registered Society Voter list found!");
		return registeredSocietyVotersList;
	}

	//Method to add the Registered Society Voters Details
	@PostMapping("{societyId}")
	public String addRegisteredSocietyVotersDetails(@Valid @RequestBody RegisteredSocietyVoters voter,
			@PathVariable("societyId") long societyId) {
		registeredSocietyVotersService.voterRegistration(voter, societyId);

		logger.info("Registered Society Voter added with id: " + voter.getId());
		return "Voter Details added successfully!";
	}

	//Method to Update the Registered Society Voters Details	
	@PutMapping
	public String updateRegisteredSocietyVotersDetails(@Valid @RequestBody RegisteredSocietyVoters voter) {

		registeredSocietyVotersService.updateRegisteredVoterDetails(voter);
		logger.info("Registered Society Voter with id: " + voter.getId() + " updated!");
		return "Voter details updated successfully!";

	}

	//Method to Delete the Registered Society Voters Details by their ID 	
	@DeleteMapping(value = "{voterId}")
	public String deleteRegisteredSocietyVotersDetailsById(@PathVariable("voterId") String id) {
		registeredSocietyVotersService.deleteRegisteredVoter(id);
		logger.info("Registered Society Voter with id: " + id + " deactivated!");
		return "Registered Society Voter deactivated successfully !";
	}
}