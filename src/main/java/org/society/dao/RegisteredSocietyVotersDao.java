/*
 * @author: Aditya Mohapatra
 */

package org.society.dao;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.VoterNotFoundException;

public interface RegisteredSocietyVotersDao {
	public RegisteredSocietyVoters save(RegisteredSocietyVoters voter, long societyId);

	public RegisteredSocietyVoters update(RegisteredSocietyVoters voter) throws VoterNotFoundException;

	public boolean delete(String voterId) throws VoterNotFoundException;

	public List<RegisteredSocietyVoters> getRegisteredVoterList();

	public RegisteredSocietyVoters getByVoterID(String voterId) throws VoterNotFoundException;
}