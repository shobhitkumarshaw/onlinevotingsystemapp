package org.society;

import org.society.entities.ElectionOfficer;
import org.society.repository.ElectionOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinitElectionOfficer implements CommandLineRunner {
	
	@Autowired
	ElectionOfficerRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
	
		repo.save(new ElectionOfficer(788L, "sho", "sh", "lsfj", "male", "5555", "jsfj", "lsjf", "jsflj", "null", 7444));
	}
}
