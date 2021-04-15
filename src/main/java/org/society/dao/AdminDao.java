package org.society.dao;

import java.util.List;

import org.society.entities.Admin;
import org.society.exceptions.NoAdminFoundException;

public interface AdminDao {
	public Admin save(Admin ad);

	public Admin update(Admin ad) throws NoAdminFoundException;

	public boolean delete(long adminId) throws NoAdminFoundException ;

	public Admin getAdmin(long adminId) throws NoAdminFoundException;

	public List<Admin> getAllAdmin();
	
	public boolean validateLogin(String user, String password);
}
