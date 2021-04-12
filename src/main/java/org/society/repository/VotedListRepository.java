package org.society.repository;

import org.society.entities.VotedList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotedListRepository extends JpaRepository<VotedList, Long>{
	VotedList findById (long id);
}