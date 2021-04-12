package org.society.service;

import java.util.List;

import org.society.entities.NominatedCandidates;

public interface NominatedCandidatesService {
	
	public NominatedCandidates saveNominatedCandidate(NominatedCandidates candidate);

	public NominatedCandidates updateNominatedCandidateDetails(NominatedCandidates candidate);

	public boolean deleteNominatedCandididate(long candidateId);

	public List<NominatedCandidates> viewNominatedCandidatesList();

	public NominatedCandidates searchByCandidateId(long id);
}
