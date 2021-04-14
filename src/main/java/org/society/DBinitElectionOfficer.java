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
		
	
		repo.save(new ElectionOfficer(30L, "Rahul", "Raj", "RahulRaj", "Male", "1234567890", "rahul@gmail.com", "add1", "add2", "Dis1", 654321));
	
		repo.save(new ElectionOfficer(31L, "Mohit", "Kumar", "MohitKumar", "Male", "2234567890", "mohit@gmail.com", "add2", "add3", "Dis2", 554321));

		repo.save(new ElectionOfficer(32L, "Rohit", "Yadav", "RohitYadav", "Male", "3234567890", "rohit@gmail.com", "add3", "add4", "Dis3", 454321));

	}
}
