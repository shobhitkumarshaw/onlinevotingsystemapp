package org.society.service;

import java.util.List;

import org.society.dao.ElectionOfficerDao;
import org.society.entities.ElectionOfficer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionOfficerServiceImpl implements ElectionOfficerService {

	@Autowired
	private ElectionOfficerDao dao;

//Method to Add Election Officer Details	
	@Override
	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer) {

		return dao.save(officer);
	}

//Method to Update Election Officer Details	
	@Override
	public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer) {

		return dao.update(officer);
	}
	
//Method to Delete Election Officer Details
	@Override
	public boolean deleteElectionOfficer(long officerId) {

		return dao.delete(officerId);
	}

//Method to get Election officer details by their Officer ID	
	@Override
	public ElectionOfficer viewElectionOfficerById(long officerId) {

		return dao.getElectionOfficerById(officerId);
	}

//Method to get Election Officer List	
	@Override
	public List<ElectionOfficer> viewElectionOfficerList() {

		return dao.getElectionOfficerList();
	}

}