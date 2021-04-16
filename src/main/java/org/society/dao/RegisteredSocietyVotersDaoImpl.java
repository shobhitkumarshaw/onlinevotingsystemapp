/*
 *@author: Aditya Mohapatra 
 */

package org.society.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.VoterNotFoundException;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisteredSocietyVotersDaoImpl implements RegisteredSocietyVotersDao {

	@Autowired
	private RegisteredSocietyVotersRepository registeredSocietyVotersRepository;
	
	@Autowired
	private CooperativeSocietyDao societyDao;

	//Save Method for Registered Society Voters	
	@Override
	public RegisteredSocietyVoters save(RegisteredSocietyVoters voter, long societyId) {
		if (registeredSocietyVotersRepository.existsById(voter.getId())) {
			throw new DuplicateEntityFoundException("Duplicate Voter can not be saved");
		}
		voter.setCooperativeSociety(societyDao.getById(societyId));
		return registeredSocietyVotersRepository.save(voter);

	}

	//Update Method for Registered Society Voters	
	@Override
	public RegisteredSocietyVoters update(RegisteredSocietyVoters voter) throws VoterNotFoundException {
		if (registeredSocietyVotersRepository.existsById(voter.getId())) {
			return registeredSocietyVotersRepository.save(voter);
		}
		throw new VoterNotFoundException("voter not found to update!");

	}
	
	//Delete Method for Registered Society Voters	
	@Transactional
	@Override
	public boolean delete(String voterId) throws VoterNotFoundException {
		RegisteredSocietyVoters voter = registeredSocietyVotersRepository.findByVoterIdCardNo(voterId);
		if (voter == null)
			throw new VoterNotFoundException("Voter Id not found to delete!");
		if(voter.getStatus().equalsIgnoreCase("active"))
			voter.setStatus("Deactivated");
		registeredSocietyVotersRepository.save(voter);
		return true;
	}
	
	// Method to get Registered Voters List
	@Override
	public List<RegisteredSocietyVoters> getRegisteredVoterList() {
		List<RegisteredSocietyVoters> list = (List<RegisteredSocietyVoters>) registeredSocietyVotersRepository
				.findAll();
		return list;
	}
	
	//Method to get Registered voters by their Voter ID
	@Override
	public RegisteredSocietyVoters getByVoterID(String voterId) throws VoterNotFoundException {
		RegisteredSocietyVoters voter = registeredSocietyVotersRepository.findByVoterIdCardNo(voterId);
		if (voter == null)
			throw new VoterNotFoundException("Voter not found!");

		return voter;

	}
}