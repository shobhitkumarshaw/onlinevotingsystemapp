/*
 * @author: Aditya Mohapatra
 */

package org.society.dao;

import java.util.List;

import org.society.entities.VotedList;

public interface VotedListDao {
	
	public VotedList save(VotedList votedList);

	public List<VotedList> getVotedList();
}