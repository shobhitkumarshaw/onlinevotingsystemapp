/*
 * @author: Aditya Mohapatra
 */

package org.society.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.society.dao.VotedListDaoImpl;
import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.society.exceptions.VoteAllReadyCastedException;
import org.society.repository.VotedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotedListServiceImpl implements VotedListService{

	@Autowired
	private VotedListDaoImpl dao;
	
	@Autowired
	private CooperativeSocietyService cooperativeSocietyService;
	
	@Autowired
	private RegisteredSocietyVotersService registeredSocietyVotersService;
	
	@Autowired
	private NominatedCandidatesService nominatedCandidatesService;
	
	@Override
	public VotedList addVotedList(VotedList votedList) {
		
		return dao.save(votedList);
	}

	@Override
	public VotedList updateVotedListDetails(VotedList votedList) {
		
		return dao.update(votedList);
	}

	@Override
	public boolean deletedVotedListDetails(long id) {
		
		return dao.delete(id);
	}

	@Override
	public List<VotedList> viewVotedList() {
		return dao.getVotedList();
	}

	@Override
	public VotedList searchByVoterId(long voterId) {
		return dao.getByVoterId(voterId);
	}

	@Override
	public List<VotedList> searchByNominatedCandidateId(int candidateId) {
		return dao.searchByNominatedCandidateId(candidateId);
	}

	@Override
	public VotedList castVote(long scoietyId, long nominatedCandidateId, String voterIdNumber) {
		
		CooperativeSociety scoiety = cooperativeSocietyService.viewSocietyById(scoietyId);
		RegisteredSocietyVoters voter = registeredSocietyVotersService.searchByVoterID(voterIdNumber);
		if(!voter.isCastedVote()) {
			voter.setCastedVote(true);
		}else {
			throw new VoteAllReadyCastedException("Vote is already casted");
		}	
		voter.setCooperativeSociety(scoiety);
		NominatedCandidates candidate = nominatedCandidatesService.searchByCandidateId(nominatedCandidateId);
		
		VotedList vote = new VotedList(nominatedCandidateId, LocalDate.now(), scoiety, voter, candidate, LocalTime.now(), LocalTime.now());
		
		return vote;
		
	}

}