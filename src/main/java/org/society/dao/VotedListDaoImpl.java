/*
 * @author: Aditya Mohapatra
 */

package org.society.dao;

import java.util.List;

import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.VoterNotFoundException;
import org.society.repository.VotedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class VotedListDaoImpl implements VotedListDao{

	@Autowired
	private VotedListRepository votedListRepository;
	
	@Override
	public int cast(VotedList votedList) {
		return 0;
	}

	@Override
	public boolean update(VotedList votedList) throws CastedVoteNotFoundException {
		if(votedListRepository.existsById(votedList.getId())) {
			votedListRepository.save(votedList);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(long id) throws CastedVoteNotFoundException {
		if(votedListRepository.existsById(id)){
			votedListRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<VotedList> getVotedList() {
		List<VotedList> list = (List<VotedList>) votedListRepository.findAll();
		return list;
	}

	@Override
	public VotedList getByVoterId(long voterId) throws VoterNotFoundException {
		return votedListRepository.findById(voterId);
	}

	/*@Override
	*public List<VotedList> searchByNominatedCandidateId(long candidateId) throws NominatedCandidateNotFoundException {
	*	// TODO Auto-generated method stub
	*	return null;
	*}
	*/
}