package org.society.service;

import java.util.List;

import org.society.dao.CooperativeSocietyDao;
import org.society.entities.CooperativeSociety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CooperativeSocietyServiceImpl implements CooperativeSocietyService {

	@Autowired
	private CooperativeSocietyDao repository;

	@Override
	public CooperativeSociety addSocietyDetails(CooperativeSociety society) {

		return repository.save(society);
	}

	@Override
	public CooperativeSociety updateSocietyDetails(CooperativeSociety society) {

		return repository.update(society);
	}

	@Override
	public boolean deleteSociety(long societyId) {

		return repository.delete(societyId);
	}

	@Override
	public List<CooperativeSociety> viewSocietiesList() {

		return repository.getAll();
	}

	@Override
	public CooperativeSociety viewSocietyById(long societyId) {

		return repository.getById(societyId);
	}

}