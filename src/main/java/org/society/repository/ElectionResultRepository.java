package org.society.repository;


import java.util.List;

import org.society.entities.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ElectionResultRepository extends JpaRepository<ElectionResult, Long> {

	@Query(value = "SELECT COOPERATIVE_SOCIETY_FK , NOMINATED_CANDIDATES_FK , COUNT(REGISTERED_SOCIETY_VOTERS_FK)  FROM VOTED_LIST "
			+ "GROUP BY  COOPERATIVE_SOCIETY_FK , NOMINATED_CANDIDATES_FK "
			+ "ORDER BY  COOPERATIVE_SOCIETY_FK ASC, NOMINATED_CANDIDATES_FK  DESC", nativeQuery = true)
	List votedlistResult();
	
	@Query(value = "SELECT COUNT(REGISTERED_SOCIETY_VOTERS_FK ) FROM VOTED_LIST "
			, nativeQuery = true)
	long getTotalCastedVotes();
}
