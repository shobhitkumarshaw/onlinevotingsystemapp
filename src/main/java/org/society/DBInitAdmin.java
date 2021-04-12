package org.society;

import org.society.entities.Admin;
import org.society.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitAdmin implements CommandLineRunner {
	@Autowired
	AdminRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Admin ad1 = new Admin(123L, "Life", "Dead");
		repository.save(ad1);
		Admin ad2 = new Admin(223L, "Water", "Fire");
		repository.save(ad2);
		Admin ad3 = new Admin(323L, "Bright", "Dark");
		repository.save(ad3);
	}

}
