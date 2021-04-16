/*
 * Author- Govind Kidambi
 */

package org.society;

import org.society.entities.NominatedCandidates;
import org.society.repository.NominatedCandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinitNominatedCandidate implements CommandLineRunner {
	@Autowired
	NominatedCandidatesRepository nominatedCandidatesRepository;
	
	@Override
	public void run(String... args) throws Exception {
		nominatedCandidatesRepository.save(new NominatedCandidates(523698l, "yoga", "cycle", 5632014f, false, false, false, null, null));
	}
}