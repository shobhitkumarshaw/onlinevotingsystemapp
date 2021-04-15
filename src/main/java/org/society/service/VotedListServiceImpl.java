package org.society.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.society.dao.VotedListDaoImpl;
import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.society.exceptions.VoteAllReadyCastedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotedListServiceImpl implements VotedListService {

	@Autowired
	private VotedListDaoImpl dao;

	@Autowired
	private CooperativeSocietyService cooperativeSocietyService;

	@Autowired
	private RegisteredSocietyVotersService registeredSocietyVotersService;

	@Autowired
	private NominatedCandidatesService nominatedCandidatesService;

//Method to Add Voted List 	
	@Override
	public VotedList addVotedList(VotedList votedList) {

		return dao.save(votedList);
	}

//Method to Update Voted List	
	@Override
	public VotedList updateVotedListDetails(VotedList votedList) {

		return dao.update(votedList);
	}

//Method to Delete Voted List	
	@Override
	public boolean deletedVotedListDetails(long id) {
		return dao.delete(id);
	}

//Method to get Voted List	
	@Override
	public List<VotedList> viewVotedList() {
		return dao.getVotedList();
	}

//Method to Search by Voter ID	
	@Override
	public VotedList searchByVoterId(String voterId) {
		return dao.getByVoterId(voterId);
	}

//Method to Search by Nominated Candidate ID 	
	@Override
	public VotedList searchByNominatedCandidateId(long candidateId) {
		return dao.searchByNominatedCandidateId(candidateId);
	}

//Method to Cast a Vote	
	@Transactional
	@Override
	public VotedList castVote(long scoietyId, long nominatedCandidateId, String voterIdNumber) {

		CooperativeSociety scoiety = cooperativeSocietyService.viewSocietyById(scoietyId);

		RegisteredSocietyVoters voter = registeredSocietyVotersService.searchByVoterID(voterIdNumber);
		

		if (!(voter.isCastedVote())) {
			voter.setCastedVote(true);
		} else {
			throw new VoteAllReadyCastedException("Vote is already casted");
		}

		NominatedCandidates candidate = nominatedCandidatesService.searchByCandidateId(nominatedCandidateId);

		VotedList vote = new VotedList(LocalDateTime.now(), scoiety, voter, candidate);
		dao.save(vote);

		return vote;
	}
}