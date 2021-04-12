package org.society.service;


import org.society.entities.Admin;
import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionOfficer;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.User;
import org.society.entities.VotedList;

public interface AdminService {
	public void addAdminDetails(Admin admin);

	public boolean updateAdminDetails(Admin admin);

	public boolean deleteAdminDetails(long adminId);

	public Admin viewAdminById(long adminId);

	public boolean addElectionOfficerDetails(ElectionOfficer officer);

	public boolean updateElectionOfficerDetails(ElectionOfficer officer);

	public boolean deleteElectionOfficer(long officerId);

	public void addElectionResult(ElectionResult result);

	public boolean updateElectionResult(ElectionResult result);

	public boolean deleteElectionResult(long candidadeId);

	public boolean addNominatedCandidate(NominatedCandidates candidate);

	public void updateNominatedCandidateDetails(NominatedCandidates candidate);

	public void deleteNominatedCandididate(long candidateId);

	public void addSocietyDetails(CooperativeSociety society);

	public boolean updateSocietyDetails(CooperativeSociety society);

	public boolean deleteSociety(long societyId);

	public void voterRegistration(RegisteredSocietyVoters voter);

	public boolean updateRegisteredVoterDetails(RegisteredSocietyVoters voter);

	public boolean deleteRegisteredVoter(long voterId);

	public void registerUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(long userId);

	public void castVotedList(VotedList votedList);

	public boolean updateVotedListDetails(VotedList votedList);

	public boolean deletedVotedListDetails(long id);

}
