/*
 *@author: Ritik Kumar 
 */

package org.society.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import org.society.exceptions.EmptyDataException;
import org.society.model.Result;
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
	
	@Autowired
	private RegisteredSocietyVotersDao voterDao;

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

	//Method to get Nominated Candidate which has highest Voting Percentage
	@Override
	public NominatedCandidates viewHighestVotingPercentCandidate() {
		List<VotedList> list = votedList.getVotedList();
		Map<Long, Long> highResult = list.stream().filter(l -> l.getNominatedCandidates() != null)
				.map(VotedList::getNominatedCandidates)
				.collect(Collectors.groupingBy(NominatedCandidates::getCandidateId, Collectors.counting()));
		
		long high = 0;
		long val = highResult.get(3l);
		System.out.println(val);
		for (long K : highResult.keySet()) {
			if (val <= highResult.get(K)) {
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
		long low = 3l;
		long val = Result.get(3l);
		for (long K : Result.keySet()) {
			if (val >= Result.get(K)) {
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
	
	public List<Result> getResult(){
		List<Result> electionResult = new ArrayList<>();
	
		
		List<VotedList> list = votedList.getVotedList();
		if(list.size() == 0) {
			throw new EmptyDataException("No data found in Database!");
		}
		Map<Long, Long> result = list.stream().filter(l -> l.getNominatedCandidates() != null)
				.map(VotedList::getNominatedCandidates)
				.collect(Collectors.groupingBy(NominatedCandidates::getCandidateId, Collectors.counting()));
		System.out.println(result);
		for(long k : result.keySet()) {
			Optional<LocalDateTime> date = list.stream().filter(l -> l.getNominatedCandidates().getCandidateId() == k)
					.map(d -> d.getPollingDateTime())
					.findFirst();
			LocalDateTime pollingDate = date.get();
			NominatedCandidates candidate = candidateDao.getByCandidateId(k);
			String socity = candidate.getCooperativeSociety().getSocietyName();
			String candidateName = candidate.getRegisteredSocietyVoter().getFirstName() 
					+ " " + candidate.getRegisteredSocietyVoter().getLastName();
			String party = candidate.getPartyName();
			Long postedVotes = result.get(k);
			Long totalVotes = list.stream().filter(s -> s.getNominatedCandidates().getCooperativeSociety().getSocietyName().equals(socity))
					.collect(Collectors.counting());
			double pollingPercentage = (postedVotes/totalVotes) * 100;
			electionResult.add(new Result(pollingDate, socity, candidateName, party, postedVotes, totalVotes, pollingPercentage));
		}
		
		return electionResult;
		
	}
}