package org.society.service;

import java.util.List;

import org.society.entities.Admin;

public interface AdminService {
	public Admin addAdminDetails(Admin admin);

	public Admin updateAdminDetails(Admin admin);

	public boolean deleteAdminDetails(long adminId);

	public Admin viewAdminById(long adminId);

	public List<Admin> getAllAdminList();
}