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
		User qs = new User(25L, "abcd", "bhanu", "prakash", "bhanu@gmail", "9951976511", "voter");
		repo.save(qs);
		User as = new User(24L, "pqrs", "showbit", "kumar", "kumar@gmail", "6303316156", "nominated condiadate");
		repo.save(as);
	}
}