package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.Admin;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.NoAdminFoundException;
import org.society.exceptions.UserNotFoundException;
import org.society.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminDaoImp implements AdminDao {

	@Autowired
	AdminRepository repository;

	@Override
	public Admin save(Admin ad) throws DuplicateEntityFoundException {
		if (repository.existsById(ad.getId())) {
			throw new DuplicateEntityFoundException("Save Operation", "Duplicate Admin Found");
		}

		return repository.save(ad);

	}

	@Override
	public Admin update(Admin ad) throws NoAdminFoundException {
		if (repository.existsById(ad.getId())) {

			return repository.save(ad);
		}
		throw new NoAdminFoundException("Admin not found to update!");
	}

	@Override
	public boolean delete(long adminId) throws NoAdminFoundException{
		if (repository.existsById(adminId)) {
			repository.deleteById(adminId);
			return true;
		}
		throw new NoAdminFoundException("Admin not found to delete!");
	}

	@Override
	public Admin getAdmin(long adminId) throws NoAdminFoundException {
		Optional<Admin> an = repository.findById(adminId);
		if (an.isPresent()) {
			return an.get();
		}
		else
			throw new NoAdminFoundException("Admin not found!");
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> adI = (List<Admin>) repository.findAll();
		return adI;
	}

}
