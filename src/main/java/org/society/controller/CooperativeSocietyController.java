package org.society.controller;

import javax.validation.Valid;

import org.society.entities.CooperativeSociety;
import org.society.service.CooperativeSocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cooperative_society")
public class CooperativeSocietyController {
	
	@Autowired
	private CooperativeSocietyService service;
	
	@PostMapping
	public String addCooperativeSociety(@Valid @RequestBody CooperativeSociety society) {
		
		service.addSocietyDetails(society);
		
		return "Scoiety name : " + society.getSocietyName() + " added successfully!";
		
	}
	
	@GetMapping(value = "{id}")
	public CooperativeSociety getCooperativString(@PathVariable("id") long id) {
		
		return service.viewSocietyById(id);
	}

}
