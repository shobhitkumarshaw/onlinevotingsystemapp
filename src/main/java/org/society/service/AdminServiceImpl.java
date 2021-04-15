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

	@Override
	public Admin addAdminDetails(Admin admin) {
		return daoAdmin.save(admin);

	}

	@Override
	public Admin updateAdminDetails(Admin admin) {
		return daoAdmin.update(admin);

	}

	@Override
	public boolean deleteAdminDetails(long adminID) {
		daoAdmin.delete(adminID);
		return true;
	}

	@Override
	public Admin viewAdminById(long adminId) {
		return daoAdmin.getAdmin(adminId);

	}

	@Override
	public List<Admin> getAllAdminList() {

		return daoAdmin.getAllAdmin();
	}

}