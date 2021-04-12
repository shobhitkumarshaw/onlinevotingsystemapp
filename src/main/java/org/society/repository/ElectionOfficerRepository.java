package org.society.repository;

import org.society.entities.ElectionOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionOfficerRepository extends JpaRepository<ElectionOfficer, Long> {
	
	

}
