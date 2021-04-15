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

	@Override
	public NominatedCandidates saveNominatedCandidate(NominatedCandidates candidate, String voterId, long societyId) {
		return dao.save(candidate,voterId, societyId);
	}

	@Override
	public NominatedCandidates updateNominatedCandidateDetails(NominatedCandidates candidate) {

		return dao.update(candidate);
	}

	@Override
	public boolean deleteNominatedCandididate(long candidateId) {
		return dao.delete(candidateId);
	}

	@Override
	public List<NominatedCandidates> viewNominatedCandidatesList() {
		return dao.getNominatedCandidatesList();
	}

	@Override
	public NominatedCandidates searchByCandidateId(long id) {
		return dao.getByCandidateId(id);

	}
}