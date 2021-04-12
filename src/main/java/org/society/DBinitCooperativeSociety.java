package org.society;

import java.net.CookieStore;

import org.society.entities.CooperativeSociety;
import org.society.repository.CooporativeSocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinitCooperativeSociety implements CommandLineRunner{
	
	@Autowired
	CooporativeSocietyRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
		CooperativeSociety cs = new CooperativeSociety("Name", "Head", "Village", "mandal", "dis", "12345678", null, null);
		repo.save(cs);
		
	}
	
	

}
