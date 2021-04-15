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
		User qs = new User(25L, "pass", "bhanu", "prakash", "b@gmail", "5432167890", "voter");
		repo.save(qs);
		User as = new User(24L, "password", "bha", "pra", "p@gmail", "1234509876", "nominated condiadate");
		repo.save(as);
	}
}