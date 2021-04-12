package org.society.service;

import java.util.List;

import org.society.dao.CooperativeSocietyDao;
import org.society.entities.CooperativeSociety;
import org.society.repository.CooporativeSocietyRepository;
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
		
		return null;
	}

	@Override
	public boolean deleteSociety(long societyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CooperativeSociety> viewSocietiesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CooperativeSociety viewSocietyById(long societyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
