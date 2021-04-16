package org.society.service;

import java.util.List;

import org.society.dao.ElectionOfficerDao;
import org.society.entities.ElectionOfficer;
import org.society.entities.NominatedCandidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * @author: Shobhit Kumar Shaw
 */
@Service
public class ElectionOfficerServiceImpl implements ElectionOfficerService {

	@Autowired
	private ElectionOfficerDao dao;

	@Autowired
	private NominatedCandidatesService candidateService;

	//Method to Add Election Officer Details	
	@Override
	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer) {

		return dao.save(officer);
	}

	//Method to Update Election Officer Details	
	@Override
	public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer) {

		return dao.update(officer);
	}

	//Method to Delete Election Officer Details
	@Override
	public boolean deleteElectionOfficer(long officerId) {

		return dao.delete(officerId);
	}

	//Method to get Election officer details by their Officer ID	
	@Override
	public ElectionOfficer viewElectionOfficerById(long officerId) {

		return dao.getElectionOfficerById(officerId);
	}

	//Method to get Election Officer List	
	@Override
	public List<ElectionOfficer> viewElectionOfficerList() {

		return dao.getElectionOfficerList();
	}

	// Method to approve or reject the Nominated candidate
	@Override
	public String approveCandidate(long id, String approval) {

		if (approval.equalsIgnoreCase("PASS")) {
			NominatedCandidates candidate = candidateService.searchByCandidateId(id);
			candidate.setApprovedByElectionOfficer(true);
			candidate.setOathOrAffirmationSummited(true);
			candidate.setPoliceVerificationDone(true);
			candidateService.updateNominatedCandidateDetails(candidate);
			
			return "Nominated Candidate with id: " + id + " approval successfull!";
			
		} else if (approval.equalsIgnoreCase("REJECTED")) {
			NominatedCandidates candidate = candidateService.searchByCandidateId(id);
			candidate.setApprovedByElectionOfficer(false);
			candidate.setOathOrAffirmationSummited(false);
			candidate.setPoliceVerificationDone(false);
			candidateService.updateNominatedCandidateDetails(candidate);
			
			return "Nominated Candidate with id: " + id + " approval rejected!";

		} else
			
			return "Wrong input for approval. Enter pass or rejected!";
	}

}