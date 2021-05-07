package org.society.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.society.entities.CooperativeSociety;
import org.society.exceptions.EmptyDataException;
import org.society.service.CooperativeSocietyService;
import org.society.service.ValidateLogin;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/CooperativeSociety")
public class CooperativeSocietyController {
	
	@Autowired
	private CooperativeSocietyService service;
	
	@Autowired
	private ValidateLogin login;
	
	@GetMapping(value = "{id}")
	public CooperativeSociety getCooperativeString(@PathVariable("id") long id,HttpServletRequest request) {
		login.validateToken(request, "ElectionOfficer");
		return service.viewSocietyById(id);
	}
	
//Method to add Co-operative Society Details 	
	@PostMapping
	public String addCooperativeSociety(@Valid @RequestBody CooperativeSociety society,HttpServletRequest request) {
		login.validateToken(request, "ElectionOfficer");
		service.addSocietyDetails(society);
		
		return "Scoiety name : " + society.getSocietyName() + " added successfully!";
		
	}
	
//Method to Update Co-operative Society Details	
	@PutMapping
	public String updateCooperativeSociety(@Valid @RequestBody CooperativeSociety society,HttpServletRequest request) {
		login.validateToken(request,"ElectionOfficerr");
		service.updateSocietyDetails(society);
		
		return "Society with id: "+ society.getId() +" updated successfully!";
		
	}
	
//Method to delete Co-operative Society Details	
	@DeleteMapping(value = "{societyId}")
	public String deleteCooperativeScoiety(@PathVariable("societyId") long societyId,HttpServletRequest request) {
		login.validateToken(request,"ElectionOfficer");
		service.deleteSociety(societyId);
		
		return "Cooperative Society with id: "+ societyId +" deleted successfully!";
		
	}
	
//Method to get the list of Co-operative Society 	
	@GetMapping
	public List<CooperativeSociety> getCooperativeSocietyList(HttpServletRequest request){
		login.validateToken(request,"ElectionOfficer");
		List<CooperativeSociety> societyList = service.viewSocietiesList();
		
		if(societyList.size() == 0) {
			throw new EmptyDataException("No Cooperative Society is present in database!");
		}
		
		return societyList;
		
	}
	
	
	

}
