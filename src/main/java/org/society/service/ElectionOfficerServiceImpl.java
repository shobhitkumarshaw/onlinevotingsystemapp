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

	@Override
	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer) {
		
		return dao.save(officer);
	}

	@Override
	public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer) {
		
		return dao.update(officer);
	}

	@Override
	public boolean deleteElectionOfficer(long officerId) {
		
		return dao.delete(officerId);
	}

	@Override
	public ElectionOfficer viewElectionOfficerById(long officerId) {
		
		return dao.getElectionOfficerById(officerId);
	}

	@Override
	public List<ElectionOfficer> viewElectionOfficerList() {
		
		return dao.getElectionOfficerList();
	}
	
	
	

}
