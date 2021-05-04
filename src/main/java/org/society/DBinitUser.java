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

		
	}
}