/*
  * @author: Nagidi Bhanu prakash
 */
package org.society.service;

import java.util.List;

import org.society.dao.UserDaoImpl;
import org.society.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;

//Method to save User details	
	@Override
	public User save(User user) {

		return dao.save(user);
	}
	
//Method to Update User details 
	@Override
	public User update(User user) {

		return dao.update(user);
	}

//Method to Delete User Details	
	@Override
	public boolean delete(long userId) {

		return dao.delete(userId);
	}

//Method to view Users List	
	@Override
	public List<User> viewUserList() {

		return dao.viewUserList();
	}

//Method to Find User by their USer ID	
	@Override
	public User findByUserId(long userId) {

		return dao.findByUserId(userId);
	}

}