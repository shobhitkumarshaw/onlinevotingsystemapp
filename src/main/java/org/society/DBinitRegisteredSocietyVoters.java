/*
 * @author: Aditya mohapatra
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
	registeredSocietyVotersRepository.save(new RegisteredSocietyVoters(100L,"v12345", "Kishore", "Pal", "Male", "st", "5549315672", "kishore.pal@outlook.com", "Japjpur", "Jappur Road", "Bhubhanswer", 634896, true, "active", null));
	registeredSocietyVotersRepository.save(new RegisteredSocietyVoters(101L,"v56324", "Ashish", "Singh", "Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, true, "active", null));
	registeredSocietyVotersRepository.save(new RegisteredSocietyVoters(102L,"v32345", "Rasmita", "Panda","Female", "gen", "5463128795", "rasmita.panda@yahoo.com", "Berhampur", "Brahama Nagar", "Berhampur", 521463, false, "active", null));
	}
}