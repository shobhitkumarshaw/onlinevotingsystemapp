/*
 * @:author: Aditya Mohapatra
 */

package org.society.service;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;

public interface RegisteredSocietyVotersService {
	public void voterRegistration(RegisteredSocietyVoters voter);

	public boolean updateRegisteredVoterDetails(RegisteredSocietyVoters voter);

	public boolean deleteRegisteredVoter(long voterId);

	public List<RegisteredSocietyVoters> viewRegisteredVoterList();

	public RegisteredSocietyVoters searchByVoterID(long voterId);

	public RegisteredSocietyVoters loginValidate(String userid, String password);
}