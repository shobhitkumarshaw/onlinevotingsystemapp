
package org.society.service;

import java.util.List;

import org.society.entities.User;

public interface UserService {

	public User save(User user);

	public User update(User user);

	public boolean delete(String userName);

	public List<User> viewUserList();

	public User findByUserName(String userName);
}