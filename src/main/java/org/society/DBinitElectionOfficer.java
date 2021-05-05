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
		repo.save(new ElectionOfficer("Rahul", "Raj",  "Male", "1234567890", "rahul@gmail.com", "add1", "add2", "Dis1", 123456));
	
		repo.save(new ElectionOfficer("Mohit", "Kumar", "Male", "2234567890", "mohit@gmail.com", "add2", "add3", "Dis2", 223456));

		repo.save(new ElectionOfficer("Rohit", "Yadav", "Male", "3234567890", "rohit@gmail.com", "add3", "add4", "Dis3", 323456));
	}
}