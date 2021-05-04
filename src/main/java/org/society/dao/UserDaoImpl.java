/*
  * @author: Nagidi Bhanu prakash
 */
package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.User;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.UserNotFoundException;
import org.society.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;

	//Save Method for User Module	
	@Override
	public User save(User user) {
		if (repository.existsById(user.getUserName())) {
			throw new DuplicateEntityFoundException("Save user", "User is duplicate");

		}

		return repository.save(user);
	}

	//Update Method for User Module	
	@Override
	public User update(User user) {
		if (repository.existsById(user.getUserName())) {
			return repository.save(user);

		}
		throw new UserNotFoundException("User not found to update!");

	}

	//Delete Method for User Module	
	@Override
	public boolean delete(String userId) {
		if (repository.existsById(userId)) {
			repository.deleteById(userId);
			return true;
		}

		throw new UserNotFoundException("User not found to delete!");
	}
	
	// Method to view User List 
	@Override
	public List<User> viewUserList() {
		List<User> userList = repository.findAll();
		return userList;
	}
	
	//Method to find by User ID
	@Override
	public User findByUserId(String userId) {
		Optional<User> user = repository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else
			throw new UserNotFoundException("User not found!");
	}
}