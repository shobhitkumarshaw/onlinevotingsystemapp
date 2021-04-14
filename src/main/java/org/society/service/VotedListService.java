/*
 * @author: Aditya Mohapatra
 */

package org.society.service;

import java.util.List;

import org.society.entities.VotedList;

public interface VotedListService {
	
	public VotedList addVotedList(VotedList votedList);

	public VotedList updateVotedListDetails(VotedList votedList);

	public boolean deletedVotedListDetails(long id);

	public List<VotedList> viewVotedList();

	public VotedList searchByVoterId(String voterId);

	public VotedList searchByNominatedCandidateId(int candidateId);

	public VotedList castVote(long scoietyId, long nominatedCandidateId, String voterIdNumber);
}
