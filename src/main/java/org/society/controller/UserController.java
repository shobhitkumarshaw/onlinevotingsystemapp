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

	@GetMapping(value = "{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") long id) {

		User user = service.findByUserId(id);
		logger.info("User id : " + id + "found!");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

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

	@PostMapping
	public String registerUser(@Valid @RequestBody User user) {
		service.save(user);
		logger.info("User register with id: " + user.getId());
		return "User registation successful!";
	}

	@PutMapping
	public String updateUser(@Valid @RequestBody User user) {

		service.update(user);
		logger.info("User with id: " + user.getId() + "udated!");

		return "User details updated!";
	}

	@DeleteMapping(value = "{userId}")
	public String deleteUser(@PathVariable("userId") long userId) {

		service.delete(userId);
		logger.info("User with Id:" + userId + " deleted!");

		return "User with Id: " + userId + " deleted!";
	}
}