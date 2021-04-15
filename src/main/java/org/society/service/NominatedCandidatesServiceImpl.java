package org.society.service;

import java.util.List;

import org.society.dao.NominatedCandidatesDaoImpl;
import org.society.entities.NominatedCandidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NominatedCandidatesServiceImpl implements NominatedCandidatesService {
	@Autowired
	NominatedCandidatesDaoImpl dao;

//Method to save Nominated Candidates	
	@Override
	public NominatedCandidates saveNominatedCandidate(NominatedCandidates candidate, String voterId, long societyId) {
		return dao.save(candidate,voterId, societyId);
	}

//MEthod to Update Nominated Candidates 	
	@Override
	public NominatedCandidates updateNominatedCandidateDetails(NominatedCandidates candidate) {

		return dao.update(candidate);
	}

//Method to Delete Nominated Candidates 	
	@Override
	public boolean deleteNominatedCandididate(long candidateId) {
		return dao.delete(candidateId);
	}

//MEthod to get Nominated Condidates List	
	@Override
	public List<NominatedCandidates> viewNominatedCandidatesList() {
		return dao.getNominatedCandidatesList();
	}
	
//Method to get Candidates List by their Candidate ID
	@Override
	public NominatedCandidates searchByCandidateId(long id) {
		return dao.getByCandidateId(id);

	}
}