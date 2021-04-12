package org.society.service;

import org.society.dao.AdminDaoImp;
import org.society.dao.ElectionOfficerDaoImpl;
import org.society.dao.ElectionResultDaoImpl;
import org.society.dao.NominatedCandidatesDaoImpl;
import org.society.dao.RegisteredSocietyVotersDaoImpl;
import org.society.dao.UserDaoImpl;
import org.society.dao.VotedListDaoImpl;
import org.society.entities.Admin;
import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionOfficer;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.User;
import org.society.entities.VotedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDaoImp daoAdmin;
	@Autowired
	ElectionOfficerDaoImpl daoElectionOfficer;
	@Autowired
	ElectionResultDaoImpl daoElectionResult;
	@Autowired
	NominatedCandidatesDaoImpl daoNominatedCandidate;
	@Autowired
	RegisteredSocietyVotersDaoImpl daoRegisteredSocietyVoters;
	//@Autowired
	//CooperativeSocietyDaoImpl daoCooperativeSociety;
	@Autowired
	UserDaoImpl daoUser;
	@Autowired
	VotedListDaoImpl daoVotedList;
	
	@Override
	public void addAdminDetails(Admin admin) {
		daoAdmin.save(admin);
		
	}
	@Override
	public boolean updateAdminDetails(Admin admin) {
		daoAdmin.update(admin);
		return true;
	}
	@Override
	public boolean deleteAdminDetails(long adminID) {
		daoAdmin.delete(adminID);
		return true;
	}
	@Override
	public Admin viewAdminById(long adminId) {
		return daoAdmin.getAdmin(adminId);
		 
	}
	@Override
	public boolean addElectionOfficerDetails(ElectionOfficer officer) {
		daoElectionOfficer.save(officer);
		return true;
	}
	@Override
	public boolean updateElectionOfficerDetails(ElectionOfficer officer) {
		daoElectionOfficer.update(officer);
		return true;
	}
	@Override
	public boolean deleteElectionOfficer(long officerId) {
		daoElectionOfficer.delete(officerId);
		return false;
	}
	@Override
	public void addElectionResult(ElectionResult result) {
		daoElectionResult.save(result);
		
	}
	@Override
	public boolean updateElectionResult(ElectionResult result) {
		daoElectionResult.update(result);
		return true;
	}
	@Override
	public boolean deleteElectionResult(long candidateId) {
		daoElectionResult.delete(candidateId);
		return true;
	}
	@Override
	public boolean addNominatedCandidate(NominatedCandidates candidate) {
		daoNominatedCandidate.save(candidate);		
		return false;
	}
	@Override
	public void updateNominatedCandidateDetails(NominatedCandidates candidate) {
		daoNominatedCandidate.update(candidate);
		
	}
	@Override
	public void deleteNominatedCandididate(long candidateId) {
		daoNominatedCandidate.delete(candidateId);		
	}

	@Override
	public void voterRegistration(RegisteredSocietyVoters voter) {
		daoRegisteredSocietyVoters.save(voter);
		
	}
	@Override
	public boolean updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {
	daoRegisteredSocietyVoters.update(voter);
		return true;
	}
	
	@Override
	public boolean deleteRegisteredVoter(long voterId) {
		daoRegisteredSocietyVoters.delete(voterId);
		return true;
	}
	
	
	@Override
	public void addSocietyDetails(CooperativeSociety society) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean updateSocietyDetails(CooperativeSociety society) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteSociety(long societyId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public void registerUser(User user) {
		daoUser.save(user);		
	}
	@Override
	public boolean updateUser(User user) {
		daoUser.update(user);
		return true;
	}
	@Override
	public boolean deleteUser(long userId) {
		daoUser.delete(userId);
		return true;
	}
	@Override
	public void castVotedList(VotedList votedList) {
		daoVotedList.cast(votedList);
		
	}
	@Override
	public boolean updateVotedListDetails(VotedList votedList) {
		daoVotedList.update(votedList);
		return true;
	}
	@Override
	public boolean deletedVotedListDetails(long id) {
		daoVotedList.delete(id);
		return true;
	}

}
