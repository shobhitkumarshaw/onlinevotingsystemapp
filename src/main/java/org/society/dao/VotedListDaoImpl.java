/*
 * @author: Aditya Mohapatra
 */

package org.society.dao;

import java.util.List;

import org.society.entities.VotedList;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.repository.VotedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VotedListDaoImpl implements VotedListDao {

	@Autowired
	private VotedListRepository votedListRepository;

	@Override
	public VotedList save(VotedList votedList) {
		if (votedListRepository.existsById(votedList.getId())) {
			throw new DuplicateEntityFoundException("Casting vote", "Can not cast vote more than once");
		}
		return votedListRepository.save(votedList);
	}

	@Override
	public List<VotedList> getVotedList() {
		List<VotedList> list = (List<VotedList>) votedListRepository.findAll();
		return list;
	}
}