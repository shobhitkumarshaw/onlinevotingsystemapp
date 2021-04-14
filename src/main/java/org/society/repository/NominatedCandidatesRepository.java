package org.society.repository;

import org.society.entities.NominatedCandidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominatedCandidatesRepository extends JpaRepository<NominatedCandidates, Long> {
	NominatedCandidates findByCandidateId (long candidateId);

}
