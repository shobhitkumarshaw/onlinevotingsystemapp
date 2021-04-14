/*
 * @author: Aditya Mohapatra
 */

package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.ElectionOfficer;
import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.exceptions.VoterNotFoundException;
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
	public VotedList update(VotedList votedList) throws CastedVoteNotFoundException {
		if (votedListRepository.existsById(votedList.getId())) {

			return votedListRepository.save(votedList);
		}
		return null;

	}

	@Override
	public boolean delete(long id) throws CastedVoteNotFoundException {
		if (votedListRepository.existsById(id)) {
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
//		VotedList list = votedListRepository.findVoterListByVoterId(voterId);
//		if(list == null)
//			throw new VoterNotFoundException("Voter Id + "+voterId+ " does not exits in votered list!");
//		return list;
		return null;
	}

	@Override
	public List<VotedList> searchByNominatedCandidateId(long candidateId) throws NominatedCandidateNotFoundException {

//		Optional<VotedList> candidate = votedListRepository.findById(candidateId);
//		if (candidate.isPresent()) {
//			return candidate.get();
//		} else
//			throw new CastedVoteNotFoundException("");
		return null;
	}

}