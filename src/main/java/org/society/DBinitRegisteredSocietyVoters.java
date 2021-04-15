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
		registeredSocietyVotersRepository.save(new RegisteredSocietyVoters("v56324", "Ashish", "Singh", "plmokn", "Male", "sc", "8521674392", "ashish.singh@yahoo.com", "Rayagada", "Kotepada", "Gunupur", 573942, false, "active", null));
		registeredSocietyVotersRepository.save(new RegisteredSocietyVoters("v63792", "Kishore", "Pal", "sdv52a", "Male", "st", "5549315672", "kishore.pal@outlook.com", "Japjpur", "Jappur Road", "Bhubhanswer", 634896, false, "active", null));
		registeredSocietyVotersRepository.save(new RegisteredSocietyVoters("v15976", "Rasmita", "Panda", "fcv 5210", "Female", "gen", "5463128795", "rasmita.panda@yahoo.com", "Berhampur", "Brahama Nagar", "Berhampur", 521463, false, "active", null));
	}
}