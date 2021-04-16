package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.Admin;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.NoAdminFoundException;
import org.society.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminDaoImp implements AdminDao {

	@Autowired
	AdminRepository repository;

	// Save Method for Admin Module
	@Override
	public Admin save(Admin ad) throws DuplicateEntityFoundException {
		if (repository.existsById(ad.getId())) {
			throw new DuplicateEntityFoundException("Save Operation", "Duplicate Admin Found");
		}

		return repository.save(ad);

	}

	// Update Method for Admin Module
	@Override
	public Admin update(Admin ad) throws NoAdminFoundException {
		if (repository.existsById(ad.getId())) {

			return repository.save(ad);
		}
		throw new NoAdminFoundException("Admin not found to update!");
	}

	// Delete Method for Admin Module
	@Override
	public boolean delete(long adminId) throws NoAdminFoundException {
		if (repository.existsById(adminId)) {
			repository.deleteById(adminId);
			return true;
		}
		throw new NoAdminFoundException("Admin not found to delete!");
	}

	// Get Admin ID of a single person in a list
	@Override
	public Admin getAdmin(long adminId) throws NoAdminFoundException {
		Optional<Admin> an = repository.findById(adminId);
		if (an.isPresent()) {
			return an.get();
		} else
			throw new NoAdminFoundException("Admin not found!");
	}

	// Get ID of all the people in the list
	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> adI = (List<Admin>) repository.findAll();
		return adI;
	}

	// To validate admin login
	@Override
	public boolean validateLogin(String user, String password) {
		Admin adminName = repository.findByName(user);
		if (adminName == null) {
			throw new NoAdminFoundException("Admin not found to validate!");
		}
		if (adminName.getAdminName().equals(user) && adminName.getAdminPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

}
