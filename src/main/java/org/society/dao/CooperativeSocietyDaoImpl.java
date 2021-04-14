package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.CooperativeSociety;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.SocietyNotFoundException;
import org.society.repository.CooporativeSocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CooperativeSocietyDaoImpl implements CooperativeSocietyDao {

	@Autowired
	private CooporativeSocietyRepository repository;

	@Override
	public CooperativeSociety save(CooperativeSociety society) {
		if (repository.existsById(society.getId())) {
			throw new DuplicateEntityFoundException("Society save operation", "Duplicated Society can be saved!");
		}
		return repository.save(society);
	}

	@Override
	public CooperativeSociety update(CooperativeSociety society) {
		if (repository.existsById(society.getId())) {
			return repository.save(society);
		}

		throw new SocietyNotFoundException("Society not found to update!");
	}

	@Override
	public boolean delete(long societyId) throws SocietyNotFoundException {
		if (repository.existsById(societyId)) {
			repository.deleteById(societyId);
			return true;
		}
		throw new SocietyNotFoundException("Society not found to delete!");
	}

	@Override
	public List<CooperativeSociety> getAll() {
		List<CooperativeSociety> societyList = repository.findAll();
		return societyList;
	}

	@Override
	public CooperativeSociety getById(long societyId) throws SocietyNotFoundException {
		Optional<CooperativeSociety> society = repository.findById(societyId);
		if (society.isPresent()) {
			return society.get();
		} else
			throw new SocietyNotFoundException("Society not found!");
	}

}
