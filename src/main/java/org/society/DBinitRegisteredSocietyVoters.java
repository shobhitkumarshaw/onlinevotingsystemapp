/*
 *@author: Aditya Mohapatra 
 */

package org.society;

import org.society.entities.RegisteredSocietyVoters;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinitRegisteredSocietyVoters implements CommandLineRunner {

	@Autowired
	RegisteredSocietyVotersRepository registeredSocietyVotersRepository;

	@Override
	public void run(String... args) throws Exception {
		registeredSocietyVotersRepository.save(new RegisteredSocietyVoters(1l, "12345", "Mihir", "shaw", "Bcrec", "Male", "obc", "9876543210", "mihir@email.com", "add1", "add23", "mondal", "Dis", 678543, false, null));
		registeredSocietyVotersRepository.save(new RegisteredSocietyVoters(2l, "22345", "Shobit", "Kumar", "Bcrec1", "Male", "gen", "1876543210", "shobit@email.com", "add1", "add23", "mondal", "Dis", 178543, false, null));
		registeredSocietyVotersRepository.save(new RegisteredSocietyVoters(3l, "32345", "Aditya", "Kumar", "Bcrec3", "Male", "obc", "2876543210", "aditya@email.com", "add1", "add23", "mondal", "Dis", 278543, false, null));
		
		RegisteredSocietyVoters rs = registeredSocietyVotersRepository.findByVoterIdCardNo("12345");
		System.out.println("Reg voter: "+rs.toString());
	}

}




