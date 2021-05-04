/*
  * @author: Nagidi Bhanu prakash
 */
package org.society;

import org.society.entities.User;
import org.society.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinitUser implements CommandLineRunner {
	@Autowired
	UserRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.save(new User("Ritik","pass1","Admin"));
		repo.save(new User("Shobhit","pass2","ElectionOfficer"));
		repo.save(new User("Govind","pass3","RegisteredSocietyVoter"));
		repo.save(new User("Aditya","pass4","NominatedCandidate"));
	}
}