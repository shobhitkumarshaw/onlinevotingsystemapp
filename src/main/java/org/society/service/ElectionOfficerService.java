package org.society.service;

import java.util.List;

import org.society.entities.ElectionOfficer;
import org.springframework.web.bind.annotation.PathVariable;

public interface ElectionOfficerService {

	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer);

	public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer);

	public boolean deleteElectionOfficer(long officerId);

	public ElectionOfficer viewElectionOfficerById(long officerId);

	public List<ElectionOfficer> viewElectionOfficerList();
	
	String approveCandidate(long id,String approval);

}