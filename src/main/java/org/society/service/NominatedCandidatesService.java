package org.society.service;

import java.util.List;

import org.society.entities.NominatedCandidates;

public interface NominatedCandidatesService {

	public NominatedCandidates saveNominatedCandidate(NominatedCandidates candidate, String voterId, long societyId);

	public NominatedCandidates updateNominatedCandidateDetails(NominatedCandidates candidate);

	public boolean deleteNominatedCandididate(long candidateId);

	public List<NominatedCandidates> viewNominatedCandidatesList();

	public NominatedCandidates searchByCandidateId(long id);
}