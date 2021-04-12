package org.society.controller;

import java.util.List;
import javax.validation.Valid;
import org.society.entities.Admin;
import org.society.entities.ElectionOfficer;
import org.society.entities.ElectionResult;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.EmptyDataException;
import org.society.exceptions.NoAdminFoundException;
import org.society.service.AdminService;
import org.society.service.ElectionOfficerService;
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
@RequestMapping("/api/Admins")
public class AdminController {
	@Autowired
	private AdminService adService;
	//@Autowired
	//private ElectionOfficerService eoService;
	//@Autowired
	//private ElectionResultService erService;

	@PostMapping
	public String saveAdmin(@Valid @RequestBody Admin admin) {
		adService.addAdminDetails(admin);
		return "Admin data successfully saved";
	}

	@PutMapping
	public String updateAdmin(@Valid @RequestBody Admin admin) {

		adService.updateAdminDetails(admin);
		return "Admin data successfully Updated";

	}

	@DeleteMapping("{adminId}")
	public String deleteAdmin(@PathVariable("adminId") long adminId) {

		adService.deleteAdminDetails(adminId);
		return "Admin data successfully deleted";

	}

	@JsonIgnore
	@GetMapping(value = "{adminId}")
	public ResponseEntity<?> getAdmin(@PathVariable("adminId") long adminId) {
		Admin ad = adService.viewAdminById(adminId);
		if (ad == null)
			throw new NoAdminFoundException("Request", "Election Result not found!");

		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}
/*
	//ElectionOfficer
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getElectionOfficerById(@PathVariable("id") long id) {
		
		ElectionOfficer officer = eoService.viewElectionOfficerById(id);
		return new ResponseEntity<ElectionOfficer>(officer, HttpStatus.OK);
	}
	
	@GetMapping
	public List<ElectionOfficer> getListOfElectionOfficer() {
		
		List<ElectionOfficer> officerList = eoService.viewElectionOfficerList();
		if (officerList.size() == 0) {
			throw new EmptyDataException("No Election officer in database!");
		}
		return officerList;
	}
	
	@PostMapping
	public String addElectionOfficerDetails(@Valid @RequestBody ElectionOfficer officer) {
		
		
		eoService.addElectionOfficerDetails(officer);
		return "Election Officer Details added successfully!";
		
	}
	
	@PutMapping
	public String updateElectionOfficerDetails(@Valid @RequestBody ElectionOfficer officer) {
		
		eoService.updateElectionOfficerDetails(officer);
		
		return "Election Officer details updated successfully!";
		
	}
	
	@DeleteMapping(value = "{id}")
	public String deleteElectionOfficerDetailsById(@PathVariable("id") long id) {
		eoService.deleteElectionOfficer(id);
		
		return "Election Officer details removed!";
	}
	
	//ElectionResult
	
	@JsonIgnore
	@GetMapping
	public List<ElectionResult> getAllResult() {
		List<ElectionResult> list = erService.viewElectionResultList();
		if (list.size() == 0) {
			throw new EmptyDataException("No result in database!");
		}
		return list;
	}

	@JsonIgnore
	@GetMapping(value = "{CandidateId}")
	public ResponseEntity<?> getResult(@PathVariable("CandidateId") long candidateId) {
		ElectionResult er = erService.viewCandidatewiseResult(candidateId);
		if (er == null)
			throw new ElectionResultNotFoundException("Request", "Election Result not found!");

		return new ResponseEntity<ElectionResult>(er, HttpStatus.OK);
	}

	@PostMapping
	public String saveResult(@Valid @RequestBody ElectionResult result) {
		erService.addElectionResult(result);
		return "Election Result successfully saved";
	}

	@PutMapping
	public String updateResult(@Valid @RequestBody ElectionResult result) {

		erService.updateElectionResult(result);
		return "Election Result successfully Updated";
	}

	@DeleteMapping("{CandidateId}")
	public String deleteResult(@PathVariable("CandidateId") long CandidateId) {

		erService.deleteElectionResult(CandidateId);
		return "Election Result data successfully deleted";

	}
	
*/
	
	
	
}













