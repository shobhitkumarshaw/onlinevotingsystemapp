package org.society.dao;

import java.util.List;

import org.society.entities.User;
import org.society.exceptions.UserNotFoundException;

public interface UserDao {
	
	public User save(User user);

	public User update(User user) throws UserNotFoundException;

	public boolean delete(String userName) throws UserNotFoundException;

	public List<User> viewUserList();

	public User findByUserName(String userName) throws UserNotFoundException;
}
