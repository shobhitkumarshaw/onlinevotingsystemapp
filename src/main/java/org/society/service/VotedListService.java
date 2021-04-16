/*
 * @author: Aditya Mohapatra
 */

package org.society.service;

import java.util.List;

import org.society.entities.VotedList;

public interface VotedListService {
	public List<VotedList> viewVotedList();

	public VotedList castVote(long scoietyId, long nominatedCandidateId, String voterIdNumber);
}