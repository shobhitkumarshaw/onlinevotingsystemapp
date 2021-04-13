/*
 * @author: Aditya Mohapatra
 */

package org.society.service;

import java.util.List;

import org.society.dao.VotedListDaoImpl;
import org.society.entities.VotedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotedListServiceImpl implements VotedListService{

	@Autowired
	private VotedListDaoImpl dao;
	
	@Override
	public VotedList castVotedList(VotedList votedList) {
		
		return dao.cast(votedList);
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

}