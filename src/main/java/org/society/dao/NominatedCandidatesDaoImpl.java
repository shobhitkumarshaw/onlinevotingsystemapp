package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.repository.NominatedCandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NominatedCandidatesDaoImpl implements NominatedCandidatesDao {
	@Autowired
	private NominatedCandidatesRepository nominatedCandidatesRepository;

	@Override
	public NominatedCandidates save(NominatedCandidates candidate) {

		if (nominatedCandidatesRepository.existsById(candidate.getCandidateId())) {
			throw new DuplicateEntityFoundException("Duplicate Candidate can not be saved");
		}

		return nominatedCandidatesRepository.save(candidate);
	}

	@Override
	public NominatedCandidates update(NominatedCandidates candidate) throws NominatedCandidateNotFoundException {
		if(nominatedCandidatesRepository.existsById(candidate.getCandidateId())) {
		return nominatedCandidatesRepository.save(candidate);
		}
		throw new NominatedCandidateNotFoundException("Candidate not found to update!");

	}

	@Override
	public boolean delete(long candidateId) throws NominatedCandidateNotFoundException {

		if (nominatedCandidatesRepository.existsById((long) candidateId)) {
			nominatedCandidatesRepository.deleteById((long) candidateId);
			return true;
		}
		throw new NominatedCandidateNotFoundException("Candidate not found to delete!");
	}

	@Override
	public List<NominatedCandidates> getNominatedCandidatesList() {
		List<NominatedCandidates> list = (List<NominatedCandidates>) nominatedCandidatesRepository.findAll();
		return list;
	}

	@Override
	public NominatedCandidates getByCandidateId(long candidateId) throws NominatedCandidateNotFoundException{
		Optional<NominatedCandidates> candidate = nominatedCandidatesRepository.findById(candidateId);
		if (candidate.isPresent()) {
			return candidate.get();
		}
		throw new NominatedCandidateNotFoundException("Candidate not found!");
	}

}
