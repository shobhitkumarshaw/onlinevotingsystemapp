package org.society.service;

import java.util.List;

import org.society.dao.ElectionResultDaoImpl;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionResultServiceImpl implements ElectionResultService {
	@Autowired
	ElectionResultDaoImpl dao;

//Method to Add Election Result 	
	@Override
	public ElectionResult addElectionResult(ElectionResult result) {
		return dao.save(result);

	}

//Method to Update Election Result	
	@Override
	public ElectionResult updateElectionResult(ElectionResult result) {
		return dao.update(result);

	}

//Method to Delete Election Result	
	@Override
	public boolean deleteElectionResult(long candidateId) {
		dao.delete(candidateId);
		return true;

	}

//Method to get Election Result list
	@Override
	public List<ElectionResult> viewElectionResultList() {
		return dao.getElectionResultList();
	}

//Method to view Candidate Wise Result	
	@Override
	public ElectionResult viewCandidatewiseResult(long candidateId) {
		return dao.getCandidatewiseResult(candidateId);
	}

//Method to view Voting Percentage	
	@Override
	public double viewVotingPercentage() {
		return dao.viewVotingPercentage();
	}

	@Override
	public double viewCandidateVotingPercent(long candidateId) {
		return dao.viewCandidateVotingPercent(candidateId);
	}

	/*
	 * @Override public void displayVotingStatistics() { // TODO Auto-generated
	 * method stub }
	 */
	@Override
	public NominatedCandidates viewHighestVotingPercentCandidate() {
		return dao.viewHighestVotingPercentCandidate();
	}

	@Override
	public NominatedCandidates viewLowestVotingPercentCandidate() {
		return dao.viewLowestVotingPercentCandidate();
	}

	@Override
	public int viewInvalidVotes() {
		return dao.viewInvalidVotes();
	}

	@Override
	public List<NominatedCandidates> candidatewiseInvalidVotesList() {
		return dao.candidatewiseInvalidVotesList();
	}

	/*
	 * @Override public void displayPollingResult() {
	 * 
	 * 
	 * }
	 */
}
