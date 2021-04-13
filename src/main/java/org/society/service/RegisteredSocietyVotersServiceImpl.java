

package org.society.service;

import java.util.List;

import org.society.dao.RegisteredSocietyVotersDaoImpl;
import org.society.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredSocietyVotersServiceImpl implements RegisteredSocietyVotersService {
	
	@Autowired
	RegisteredSocietyVotersDaoImpl dao;

	@Override
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) {
		return dao.save(voter);
	}

	@Override
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {
		return dao.update(voter);
		
	}
	
	@Override
	public boolean deleteRegisteredVoter(long voterId) {
		dao.delete(voterId);
		return true;
	}

	@Override
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
		return dao.getRegisteredVoterList();
	}

	@Override
	public RegisteredSocietyVoters searchByVoterID(String voterId) {
		return  dao.getByVoterID(voterId);
	}

	@Override
	public RegisteredSocietyVoters loginValidate(String userid, String password) {
		return null;
	}

}