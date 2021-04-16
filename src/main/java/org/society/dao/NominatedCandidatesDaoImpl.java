/*
 * Author- Govind Kidambi
 */

package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.repository.NominatedCandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NominatedCandidatesDaoImpl implements NominatedCandidatesDao {
	@Autowired
	private NominatedCandidatesRepository nominatedCandidatesRepository;
	
	@Autowired
	private CooperativeSocietyDao societyDao;
	
	@Autowired
	private RegisteredSocietyVotersDao voterDao;

    //Save Method for Nominated Candidates Module	
	@Override
	public NominatedCandidates save(NominatedCandidates candidate,String voterId, long societyId) {

		if (nominatedCandidatesRepository.existsById(candidate.getCandidateId())) {
			throw new DuplicateEntityFoundException("Duplicate Nominated Candidate can not be saved!");
		}
		candidate.setRegisteredSocietyVoter(voterDao.getByVoterID(voterId));
		candidate.setCooperativeSociety(societyDao.getById(societyId));
		return nominatedCandidatesRepository.save(candidate);
	}
	
    //Update Method for Nominated Candidates Module
	@Override
	public NominatedCandidates update(NominatedCandidates candidate) throws NominatedCandidateNotFoundException {
		if(nominatedCandidatesRepository.existsById(candidate.getCandidateId())) {
		return nominatedCandidatesRepository.save(candidate);
		}
		throw new NominatedCandidateNotFoundException(" Nominated Candidate not found to update!");

	}

    //Delete Method for Nominated Candidates Module	
	@Override
	public boolean delete(long candidateId) throws NominatedCandidateNotFoundException {

		if (nominatedCandidatesRepository.existsById((long) candidateId)) {
			nominatedCandidatesRepository.deleteById((long) candidateId);
			return true;
		}
		throw new NominatedCandidateNotFoundException("Nominated Candidate not found to delete!");
	}
	
    //Method to get Nominated Candidates List
	@Override
	public List<NominatedCandidates> getNominatedCandidatesList() {
		List<NominatedCandidates> list = (List<NominatedCandidates>) nominatedCandidatesRepository.findAll();
		return list;
	}

    //Method to get List of Nominated Candidates by their Candidate ID	
	@Override
	public NominatedCandidates getByCandidateId(long candidateId) throws NominatedCandidateNotFoundException{
		Optional<NominatedCandidates> candidate = nominatedCandidatesRepository.findById(candidateId);
		if (candidate.isPresent()) {
			return candidate.get();
		}
		throw new NominatedCandidateNotFoundException("Candidate not found!");
	}

}
