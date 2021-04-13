
package org.society.service;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;

public interface RegisteredSocietyVotersService {
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter);

	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter);

	public boolean deleteRegisteredVoter(long voterId);

	public List<RegisteredSocietyVoters> viewRegisteredVoterList();

	public RegisteredSocietyVoters searchByVoterID(String voterId);

	public RegisteredSocietyVoters loginValidate(String userid, String password);


}