package org.society.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.Admin;

import org.society.exceptions.EmptyDataException;
import org.society.exceptions.NoAdminFoundException;
import org.society.exceptions.NoUserLoggedInException;
import org.society.repository.AdminRepository;
import org.society.service.AdminService;
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

@CrossOrigin
@RestController
@RequestMapping("/api/Admins")
public class AdminController {
	@Autowired
	private AdminService adminService;
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminRepository repo;
	
//	private void loginValidate(HttpSession session) {
//		String userName = (String) session.getAttribute("user_name");
//		String name = repo.findByName(userName).getAdminName();
//		if(userName == null && name == null) {
//			throw new NoUserLoggedInException("Login to access!");
//		}
//		
//		if(userName.equals(name) == false) {
//			throw new NoUserLoggedInException("Login to access!");
//		}
//		
//	}

	@GetMapping("/login/{user_name}/{user_password}")
	public ResponseEntity<String> validateLogin(@PathVariable("user_name") String userName,
			@PathVariable("user_password") String userPassword, HttpServletRequest request) {
		
		if (adminService.validateLogin(userName, userPassword)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("AdminName", userName);
			String userid = (String) session.getAttribute("user_name");
			System.out.println("***********"+userid+"***************");
		}
		else {
			throw new NoAdminFoundException("Admin not found to login or wrong user name and password!");
		}

		return new ResponseEntity<String>("Login Success!", HttpStatus.OK);

	}

	@GetMapping("/logout")
	public ResponseEntity<String> logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.invalidate();

		return new ResponseEntity<String>("Logout Success!", HttpStatus.OK);
	}

	@PostMapping
	public String saveAdmin(@Valid @RequestBody Admin admin, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//loginValidate( session);
		adminService.addAdminDetails(admin);
		logger.info("Admin added with id: " + admin.getId());
		return "Admin data successfully saved";
	}

	@PutMapping
	public String updateAdmin(@Valid @RequestBody Admin admin, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//loginValidate(session);
		adminService.updateAdminDetails(admin);
		logger.info("Admin with id: " + admin.getId() + " updated!");
		return "Admin data successfully Updated";
	}

	@DeleteMapping("{adminId}")
	public String deleteAdmin(@PathVariable("adminId") long adminId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//loginValidate( session);
		adminService.deleteAdminDetails(adminId);
		logger.info("Admin with id: " + adminId + " deleted!");
		return "Admin data successfully deleted";

	}

	@GetMapping(value = "{adminId}")
	public ResponseEntity<?> getAdmin(@PathVariable("adminId") long adminId) {
		Admin ad = adminService.viewAdminById(adminId);
		if (ad == null) {
			logger.error("No data found in admin database!");
			throw new NoAdminFoundException("Election Result not found!");
		}
		logger.info("Admin id: " + adminId + " found!");
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	@GetMapping
	public List<Admin> getListOfAdmin(HttpServletRequest request) {

		HttpSession session = request.getSession();
		//loginValidate(session);

		String userid = (String) session.getAttribute("user_name");

		System.out.println("************************" + userid + "**************************");
		
		List<Admin> adminList = adminService.getAllAdminList();
		if (adminList.size() == 0) {
			logger.error("No data found in Admin database!");
			throw new EmptyDataException("No Admin in database!");
		}
		logger.info("Admin list found!");
		return adminList;
	}

}