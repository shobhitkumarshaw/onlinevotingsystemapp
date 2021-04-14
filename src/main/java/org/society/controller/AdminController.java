package org.society.controller;

import java.util.List;
import javax.validation.Valid;
import org.society.entities.Admin;
import org.society.entities.ElectionOfficer;
import org.society.entities.ElectionResult;
import org.society.entities.User;

import org.society.exceptions.EmptyDataException;
import org.society.exceptions.NoAdminFoundException;
import org.society.service.AdminService;
import org.society.service.ElectionOfficerService;
import org.society.service.ElectionResultService;
import org.society.service.UserService;
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
			throw new NoAdminFoundException("Election Result not found!");

		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

}
