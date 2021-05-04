package org.society.repository;

import org.society.entities.CooperativeSociety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooporativeSocietyRepository extends JpaRepository<CooperativeSociety, Long> {

}
