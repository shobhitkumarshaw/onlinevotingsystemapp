/*
  * @author: Nagidi Bhanu prakash
 */
package org.society.controller;

import java.util.List;

import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.society.entities.User;
import org.slf4j.Logger;
import org.society.exceptions.EmptyDataException;
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


@RestController
@RequestMapping("/api/user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(ElectionOfficerController.class);

	@Autowired
	private UserService service;

//Method to get the User Details by their UserName	
	@GetMapping(value = "{userName}")
	public ResponseEntity<?> getUserByUserName(@PathVariable("userName") String userName) {

		User user = service.findByUserName(userName);
		logger.info("User name : " + userName + "found!");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

//Method to get the User List 	
	@GetMapping
	public List<User> getUserList() {

		List<User> userList = service.viewUserList();
		if (userList.size() == 0) {
			logger.error("no data found in user database!");
			throw new EmptyDataException("No user found in database!");
		}
		logger.info("User  list found!");
		return userList;

	}

//Method for Registration of the User	
	@PostMapping
	public String registerUser(@Valid @RequestBody User user) {
		service.save(user);
		logger.info("User register with name: " + user.getUserName());
		return "User registation successful!";
	}

//Method to Update the User Details	
	@PutMapping
	public String updateUser(@Valid @RequestBody User user) {

		service.update(user);
		logger.info("User with name: " + user.getUserName() + "udated!");

		return "User details updated!";
	}

//Method to Delete the User Details	
	@DeleteMapping(value = "{userName}")
	public String deleteUser(@PathVariable("userName") String userName) {

		service.delete(userName);
		logger.info("User with name:" + userName + " deleted!");

		return "User with name: " + userName + " deleted!";
	}
}