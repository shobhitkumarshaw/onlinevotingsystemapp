/*
 *@author: Ritik Kumar 
 */

package org.society.dao;

import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;

public interface ElectionResultDao {
	public ElectionResult save(ElectionResult result);
	
	public ElectionResult update(ElectionResult result) throws ElectionResultNotFoundException;
	
	public boolean delete(long candidateId)throws ElectionResultNotFoundException;
	
	public List<ElectionResult> getElectionResultList();

	public ElectionResult getCandidatewiseResult(long candidateId) throws NominatedCandidateNotFoundException;
	
	public NominatedCandidates viewHighestVotingPercentCandidate();

	public NominatedCandidates viewLowestVotingPercentCandidate();

	public int viewInvalidVotes();
	
}
