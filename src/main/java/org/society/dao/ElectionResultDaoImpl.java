package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.repository.ElectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElectionResultDaoImpl implements ElectionResultDao {
	@Autowired
	ElectionResultRepository repository;

	@Override
	public ElectionResult save(ElectionResult result) {
		if (repository.existsById(result.getId())) {
			throw new DuplicateEntityFoundException("Save operation", "Duplicate Election Result found");
		}
		return repository.save(result);

	}

	@Override
	public ElectionResult update(ElectionResult result) throws ElectionResultNotFoundException {
		if (repository.existsById(result.getId())) {
			return repository.save(result);
		}
		throw new ElectionResultNotFoundException("Election Result not found to update!");
	}

	@Override
	public boolean delete(long candidateId) throws ElectionResultNotFoundException {
		if (repository.existsById(candidateId)) {
			repository.deleteById(candidateId);
			return true;
		}
		throw new ElectionResultNotFoundException("Election Result not found to delete!");
	}

	@Override
	public List<ElectionResult> getElectionResultList() {
		List<ElectionResult> list = (List<ElectionResult>) repository.findAll();
		return list;
	}

	@Override
	public ElectionResult getCandidatewiseResult(long candidateId) throws ElectionResultNotFoundException {
		Optional<ElectionResult> er = repository.findById(candidateId);
		if (er.isPresent()) {

			return er.get();
		}
		throw new ElectionResultNotFoundException("Election Result not found ");
	}

	@Override
	public double viewVotingPercentage() {
		
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
