/*
 * @author: Aditya Mohapatra
 */

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

	//Method to save Registered Society Voters	
	@Override
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter, long societyId) {
		return dao.save(voter, societyId);
	}
	
	//Method to Update Registered Society Voters
	@Override
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {
		return dao.update(voter);

	}

	//MEthod to Delete Registered Society Voters 	
	@Override
	public boolean deleteRegisteredVoter(String voterId) {
		dao.delete(voterId);
		return true;
	}
	
	//Method to get Registered Society Voters List
	@Override
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
		return dao.getRegisteredVoterList();
	}

	//Method to get Registered Society Voters List by their Voter ID	
	@Override
	public RegisteredSocietyVoters searchByVoterID(String voterId) {
		return dao.getByVoterID(voterId);
	}
}