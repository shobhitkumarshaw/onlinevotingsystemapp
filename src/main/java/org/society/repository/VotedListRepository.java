package org.society.repository;

import org.society.entities.VotedList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotedListRepository extends JpaRepository<VotedList, Long>{
	
	
//	@Query("SELECT * FROM Voted_list vl WHERE vl.registered_society_voters_fk =:voterID")
//	VotedList findVoterListByVoterId(@Param("voterId") long voterId);

	
}