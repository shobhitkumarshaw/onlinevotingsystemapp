package org.society.service;

import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;

public interface ElectionResultService {
	public ElectionResult addElectionResult(ElectionResult result);
	public ElectionResult updateElectionResult(ElectionResult result);
	public boolean deleteElectionResult(long candidateId);
	public List<ElectionResult> viewElectionResultList();
	public ElectionResult viewCandidatewiseResult(long candidateId);
	public double viewVotingPercentage();
	public double viewCandidateVotingPercent(long candidateId);
	public void displayVotingStatistics();
	public NominatedCandidates viewHighestVotingPercentCandidate();
	public NominatedCandidates viewLowestVotingPercentCandidate();
	public int viewInvalidVotes();
	public List<NominatedCandidates> candidatewiseInvalidVotesList();
	public void displayPollingResult();
}
