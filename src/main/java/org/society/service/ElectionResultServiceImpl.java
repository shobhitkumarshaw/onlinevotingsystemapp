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

	@Override
	public ElectionResult addElectionResult(ElectionResult result) {
		return dao.save(result);

	}

	@Override
	public ElectionResult updateElectionResult(ElectionResult result) {
		return dao.update(result);
		
	}

	@Override
	public boolean deleteElectionResult(long candidateId) {
		dao.delete(candidateId);
		return true;

	}

	@Override
	public List<ElectionResult> viewElectionResultList() {
		return dao.getElectionResultList();
	}

	@Override
	public ElectionResult viewCandidatewiseResult(long candidateId) {
		return dao.getCandidatewiseResult(candidateId);
	}

	@Override
	public double viewVotingPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double viewCandidateVotingPercent(long candidateId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displayVotingStatistics() {
		// TODO Auto-generated method stub

	}

	@Override
	public NominatedCandidates viewHighestVotingPercentCandidate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NominatedCandidates viewLowestVotingPercentCandidate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int viewInvalidVotes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NominatedCandidates> candidatewiseInvalidVotesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayPollingResult() {
		// TODO Auto-generated method stub

	}

}
