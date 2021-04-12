package org.society.controller;
import java.util.List;

import javax.validation.Valid;

import org.society.entities.User;
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
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
		
		User user = service.findByUserId(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@GetMapping
	public List<User> getUserList(){
		
		List<User> userList = service.viewUserList();
		if(userList.size() == 0) {
			throw new EmptyDataException("No user found in database!");
		}
		return userList;
		
	}
	
	@PostMapping
	public String registerUser(@Valid @RequestBody User user) {
		service.save(user);
		
		return "User registation successful!";
	}
	
	@PutMapping
	public String updateUser(@Valid @RequestBody User user) {
		
		service.update(user);
		
		return "User details updated!";
	}
	
	@DeleteMapping(value = "{userId}")
	public String deleteUser(@PathVariable("userId") long userId) {
		
		service.delete(userId);
		
		return "User with Id: "+ userId +" deleted!";
	}
	
}
