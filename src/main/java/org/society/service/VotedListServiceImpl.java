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
	VotedListDaoImpl dao;
	
	@Override
	public int castVotedList(VotedList votedList) {
		return 0;
	}

	@Override
	public boolean updateVotedListDetails(VotedList votedList) {
		dao.update(votedList);
		return true;
	}

	@Override
	public boolean deletedVotedListDetails(long id) {
		dao.delete(id);
		return true;
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
		return null;
	}

}