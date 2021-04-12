/*
 * @author: Aditya Mohapatra
 */

package org.society.service;

import java.util.List;

import org.society.entities.VotedList;

public interface VotedListService {
	
	public int castVotedList(VotedList votedList);

	public boolean updateVotedListDetails(VotedList votedList);

	public boolean deletedVotedListDetails(long id);

	public List<VotedList> viewVotedList();

	public VotedList searchByVoterId(long voterId);

	public List<VotedList> searchByNominatedCandidateId(int candidateId);
}
