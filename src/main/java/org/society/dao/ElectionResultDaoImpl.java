package org.society.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.repository.ElectionResultRepository;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElectionResultDaoImpl implements ElectionResultDao {
	@Autowired
	private ElectionResultRepository repository;

	@Autowired
	private RegisteredSocietyVotersRepository voterRepo;

	@Autowired
	private NominatedCandidatesDao candidateDao;

	@Autowired
	private VotedListDao votedList;

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
		List<RegisteredSocietyVoters> voters = voterRepo.findByCastedVote(true);
		List<RegisteredSocietyVoters> totalVoterInSociety = voterRepo.findAll();
		return voters.size() / totalVoterInSociety.size();
	}

//Method to view Candidate Voting Percentage	
	@Override
	public double viewCandidateVotingPercent(long candidateId) {
		List<RegisteredSocietyVoters> voters = voterRepo.findByCastedVote(true);
		List<RegisteredSocietyVoters> totalVoterInSociety = voterRepo.findAll();
		double result = 0;
		long totalVotes = 0;
		double castedVoterForSociety = 0;
		if (voters.size() != 0 && totalVoterInSociety.size() != 0) {
			totalVotes = voters
					.stream().map(voter -> voter.getCooperativeSociety()).filter(society -> society
							.getId() == candidateDao.getByCandidateId(candidateId).getCooperativeSociety().getId())
					.count();

			castedVoterForSociety = totalVoterInSociety
					.stream().map(voter -> voter.getCooperativeSociety()).filter(society -> society
							.getId() == candidateDao.getByCandidateId(candidateId).getCooperativeSociety().getId())
					.count();
		}

		return (totalVotes / castedVoterForSociety) * 100;
	}

	@Override
	public void displayVotingStatistics() {
		// TODO Auto-generated method stub

	}

	@Override
	public NominatedCandidates viewHighestVotingPercentCandidate() {
		List<VotedList> list = votedList.getVotedList();
		Map<Long, Long> highResult = list.stream().filter(l -> l.getNominatedCandidates() != null)
				.map(VotedList::getNominatedCandidates)
				.collect(Collectors.groupingBy(NominatedCandidates::getCandidateId, Collectors.counting()));
		long high = 0;
		long val = highResult.get(1);
		for (long K : highResult.keySet()) {
			if (val > highResult.get(K)) {
				val = highResult.get(K);
				high = K;
			}
		}
		
		
		return candidateDao.getByCandidateId(high);
	}

	@Override
	public NominatedCandidates viewLowestVotingPercentCandidate() {
		List<VotedList> list = votedList.getVotedList();
		Map<Long, Long> Result = list.stream().filter(l -> l.getNominatedCandidates() != null)
				.map(VotedList::getNominatedCandidates)
				.collect(Collectors.groupingBy(NominatedCandidates::getCandidateId, Collectors.counting()));
		long low = 0;
		long val = Result.get(1);
		for (long K : Result.keySet()) {
			if (val < Result.get(K)) {
				val = Result.get(K);
				low = K;
			}
		}
		
		
		return candidateDao.getByCandidateId(low);
		
	}

	@Override
	public int viewInvalidVotes() {
		List<RegisteredSocietyVoters> voters = voterRepo.findByCastedVote(false);
		return voters.size();
	}

	@Override
	public List<NominatedCandidates> candidatewiseInvalidVotesList() {

		return null;
	}

	@Override
	public void displayPollingResult() {
//		List<Object> list = repository.votedlistResult();
//		System.out.println("list: "+list);

	}
}
