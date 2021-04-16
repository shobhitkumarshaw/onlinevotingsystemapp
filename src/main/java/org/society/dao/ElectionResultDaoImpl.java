package org.society.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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

//Method to Save Election Result	
	@Override
	public ElectionResult save(ElectionResult result) {
		if (repository.existsById(result.getId())) {
			throw new DuplicateEntityFoundException("Save operation", "Duplicate Election Result found");
		}
		return repository.save(result);

	}

//Method to Update Election Result	
	@Override
	public ElectionResult update(ElectionResult result) throws ElectionResultNotFoundException {
		if (repository.existsById(result.getId())) {
			return repository.save(result);
		}
		throw new ElectionResultNotFoundException("Election Result not found to update!");
	}

//Method to Delete Election Result	
	@Override
	public boolean delete(long candidateId) throws ElectionResultNotFoundException {
		if (repository.existsById(candidateId)) {
			repository.deleteById(candidateId);
			return true;
		}
		throw new ElectionResultNotFoundException("Election Result not found to delete!");
	}

//Method to get list of Election Result	
	@Override
	public List<ElectionResult> getElectionResultList() {
		List<ElectionResult> list = (List<ElectionResult>) repository.findAll();
		return list;
	}

//Method to get Candidate wise Election Result	
	@Override
	public ElectionResult getCandidatewiseResult(long candidateId) throws ElectionResultNotFoundException {
		Optional<ElectionResult> er = repository.findById(candidateId);
		if (er.isPresent()) {

			return er.get();
		}
		throw new ElectionResultNotFoundException("Election Result not found ");
	}

//Method to view Voting Percentage
	@Override
	public double viewVotingPercentage() {
		List<RegisteredSocietyVoters> voters = voterRepo.findByCastedVote(true);
		List<RegisteredSocietyVoters> totalVoterInSociety = (List<RegisteredSocietyVoters>)voterRepo.findAll();
		//return (voters.size() / totalVoterInSociety.size())*100;
		return voters.size();
	}

//Method to view Candidate Voting Percentage	
	@Override
	public double viewCandidateVotingPercent(long candidateId) {
		List<RegisteredSocietyVoters> voters = voterRepo.findByCastedVote(true);
		List<RegisteredSocietyVoters> totalVoterInSociety = (List<RegisteredSocietyVoters>)voterRepo.findAll();
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

//Method to display Voting Statistics
	@Override
	public void displayVotingStatistics() {
		// TODO Auto-generated method stub

	}

//Method to get Nominated Candidate which has highest Voting Percentage
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

//Method to get Nominated Candidate which has lowest Voting Percentage
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

//Method to get Invalid Votes
	@Override
	public int viewInvalidVotes() {
		List<RegisteredSocietyVoters> voters = voterRepo.findByCastedVote(false);
		return voters.size();
	}

//Method to get list of candidate wise Invalid Votes
	@Override
	public List<NominatedCandidates> candidatewiseInvalidVotesList() {

		return null;
	}

//Method to display Polling Result
	@Override
	public void displayPollingResult() {
//		List<Object> list = repository.votedlistResult();
//		System.out.println("list: "+list);

	}
}
