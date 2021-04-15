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

//Method to add Co-operative Society Details 	
	@Override
	public CooperativeSociety addSocietyDetails(CooperativeSociety society) {

		return repository.save(society);
	}

//Method to Update Co-operative Society Details	
	@Override
	public CooperativeSociety updateSocietyDetails(CooperativeSociety society) {

		return repository.update(society);
	}

//Method to Delete Co-operative Society Details	
	@Override
	public boolean deleteSociety(long societyId) {

		return repository.delete(societyId);
	}

//Method to get Co-operative Society List	
	@Override
	public List<CooperativeSociety> viewSocietiesList() {

		return repository.getAll();
	}

//Method to get Co-operative List by their Society ID 	
	@Override
	public CooperativeSociety viewSocietyById(long societyId) {

		return repository.getById(societyId);
	}

}