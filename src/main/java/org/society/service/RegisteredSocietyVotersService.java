/*
 * @author: Aditya Mohapatra
 */

package org.society.service;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;

public interface RegisteredSocietyVotersService {
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter, long societyId);

	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter);

	public boolean deleteRegisteredVoter(String voterId);

	public List<RegisteredSocietyVoters> viewRegisteredVoterList();

	public RegisteredSocietyVoters searchByVoterID(String voterId);
}