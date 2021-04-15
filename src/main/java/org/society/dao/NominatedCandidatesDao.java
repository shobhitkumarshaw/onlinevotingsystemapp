package org.society.dao;

import java.util.List;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateNotFoundException;

public interface NominatedCandidatesDao {
	public NominatedCandidates save(NominatedCandidates candidate, String voterId, long societyId);

	public NominatedCandidates update(NominatedCandidates candidate);

	public boolean delete(long candidateId) throws NominatedCandidateNotFoundException;

	public List<NominatedCandidates> getNominatedCandidatesList();

	public NominatedCandidates getByCandidateId(long id);
}
