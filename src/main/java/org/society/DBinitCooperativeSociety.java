package org.society;


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
		
		CooperativeSociety cs1 = new CooperativeSociety("A Society", "HeadOfCooperativeSociety1", "Village1", "mondal1", "Dis1", "654321", null, null);
		repo.save(cs1);
		
		CooperativeSociety cs2 = new CooperativeSociety("B Society", "HeadOfCooperativeSociety2", "Village2", "mondal2", "Dis2", "554321", null, null);
		repo.save(cs2);
		
		CooperativeSociety cs3 = new CooperativeSociety("C Society", "HeadOfCooperativeSociety3", "Village3", "mondal3", "Dis3", "454321", null, null);
		repo.save(cs3);
	}
	
	

}
