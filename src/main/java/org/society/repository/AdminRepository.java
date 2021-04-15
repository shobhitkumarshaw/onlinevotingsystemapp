package org.society.repository;

import org.society.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	@Query("From Admin a WHERE a.adminName = :name")
	Admin findByName(@Param("name") String name);
	
	@Query("From Admin a WHERE a.adminPassword = :password")
	Admin findByPassword(@Param("password") String password);

}
