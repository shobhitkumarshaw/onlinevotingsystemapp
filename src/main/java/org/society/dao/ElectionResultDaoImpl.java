package org.society.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	private ElectionResultRepository repository;
	
	@PersistenceContext
	private EntityManager em;

//Save Method for Election Result Module	
	@Override
	public ElectionResult save(ElectionResult result) {
		if (repository.existsById(result.getId())) {
			throw new DuplicateEntityFoundException("Save operation", "Duplicate Election Result found");
		}
		return repository.save(result);

	}

//Update Method for Election Result Module	
	@Override
	public ElectionResult update(ElectionResult result) throws ElectionResultNotFoundException {
		if (repository.existsById(result.getId())) {
			return repository.save(result);
		}
		throw new ElectionResultNotFoundException("Election Result not found to update!");
	}

//Delete Method for Election Result Module	
	@Override
	public boolean delete(long candidateId) throws ElectionResultNotFoundException {
		if (repository.existsById(candidateId)) {
			repository.deleteById(candidateId);
			return true;
		}
		throw new ElectionResultNotFoundException("Election Result not found to delete!");
	}

//Method to get the list of Election Result	
	@Override
	public List<ElectionResult> getElectionResultList() {
		List<ElectionResult> list = (List<ElectionResult>) repository.findAll();
		return list;
	}

//Method to get Candidate wise Result	
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
//		Query totalVoters = em.createQuery("SELECT COUNT(id) FROM RegisteredSocietyVoters v");
//		Query totalNumberOfVotes = em.createNativeQuery("SELECT COUNT(REGISTERED_SOCIETY_VOTERS_FK ) FROM VOTED_LIST");
//		//System.out.println("totalvotes2"+totalVoters.getSingleResult());
//		//System.out.println("totalvotes2"+totalNumberOfVotes.getSingleResult());
//		long l1 = (long) totalVoters.getSingleResult();
//		long l2 = (long) totalNumberOfVotes.getSingleResult();
//		return ( l2/l1)*100;
		return 0;
	}

//Method to view Candidate Voting Percentage	
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
//		List<Object> list = repository.votedlistResult();
//		System.out.println("list: "+list);
		
	}
}
