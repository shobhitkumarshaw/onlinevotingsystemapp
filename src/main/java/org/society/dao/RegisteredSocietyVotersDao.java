package org.society.dao;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.VoterNotFoundException;

public interface RegisteredSocietyVotersDao {
	public RegisteredSocietyVoters save(RegisteredSocietyVoters voter);

	public RegisteredSocietyVoters update(RegisteredSocietyVoters voter) throws VoterNotFoundException;

	public boolean delete(long voterId) throws VoterNotFoundException;

	public List<RegisteredSocietyVoters> getRegisteredVoterList();

	public RegisteredSocietyVoters getByVoterID(long voterId) throws VoterNotFoundException;

	//public RegisteredSocietyVoters loginValidate(String userid, String password) throws VoterNotFoundException;
}