/*
 * @author: Aditya Mohapatra
 */

package org.society.repository;

import org.society.entities.VotedList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotedListRepository extends JpaRepository<VotedList, Long> {

	@Query(value = "SELECT * FROM VOTED_LIST  WHERE NOMINATED_CANDIDATES_FK  = :id", nativeQuery = true)
	VotedList findByNominatedCandidateId(@Param("id") long candidateId);

	// find by voter id

	@Query(value = "SELECT * FROM VOTED_LIST vl , REGISTERED_SOCIETY_VOTERS  rg "
			+ " WHERE vl.REGISTERED_SOCIETY_VOTERS_FK  = rg.ID "
			+ " AND  rg.VOTER_ID_CARD_NO = :voterId", nativeQuery = true)
	VotedList findByVoterIdCard(@Param("voterId") String voterId);
}