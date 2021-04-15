package org.society.service;

import java.util.List;

import org.society.dao.AdminDaoImp;
import org.society.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDaoImp daoAdmin;

// Method to add Admin details	
	@Override
	public Admin addAdminDetails(Admin admin) {
		return daoAdmin.save(admin);

	}

//Method to Update Admin details	
	@Override
	public Admin updateAdminDetails(Admin admin) {
		return daoAdmin.update(admin);

	}
	
//Method to Delete Admin details
	@Override
	public boolean deleteAdminDetails(long adminID) {
		daoAdmin.delete(adminID);
		return true;
	}

//Method to view Admin details by ID	
	@Override
	public Admin viewAdminById(long adminId) {
		return daoAdmin.getAdmin(adminId);

	}

//Method to get Admin List	
	@Override
	public List<Admin> getAllAdminList() {

		return daoAdmin.getAllAdmin();
	}

}