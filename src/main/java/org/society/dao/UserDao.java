/*
  * @author: Nagidi Bhanu prakash
 */
package org.society.dao;

import java.util.List;

import org.society.entities.User;
import org.society.exceptions.UserNotFoundException;

public interface UserDao {
	
	public User save(User user);

	public User update(User user) throws UserNotFoundException;

	public boolean delete(long userId) throws UserNotFoundException;

	public List<User> viewUserList();

	public User findByUserId(long userId) throws UserNotFoundException;
}
