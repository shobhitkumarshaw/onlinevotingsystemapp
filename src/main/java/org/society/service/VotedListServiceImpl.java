/*
 * @author: Aditya Mohapatra
 */

package org.society.service;

import java.time.LocalDateTime;
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

	//Method to get Voted List	
	@Override
	public List<VotedList> viewVotedList() {
		return dao.getVotedList();
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