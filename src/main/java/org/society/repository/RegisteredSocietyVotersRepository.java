package org.society.repository;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredSocietyVotersRepository extends JpaRepository<RegisteredSocietyVoters, Long>{
	List<RegisteredSocietyVoters> findByEmailId (String emailId);
	
	RegisteredSocietyVoters findByVoterIdCardNo (String votercardId);
}