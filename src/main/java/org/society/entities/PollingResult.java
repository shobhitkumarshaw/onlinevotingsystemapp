package org.society.entities;

import org.society.service.CooperativeSocietyService;
import org.society.service.NominatedCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PollingResult {
	
	@Autowired
	private CooperativeSocietyService society;
	@Autowired
	private NominatedCandidatesService candidates;
	
	
	
	private String societyName;
	private String candidateName;
	private long countedVotes;
	public PollingResult(long societyName, long candidateName, long countedVotes) {
		super();
		this.societyName = society.viewSocietyById(societyName).getSocietyName();
		this.candidateName = candidates.searchByCandidateId(candidateName).getRegisteredSocietyVoter().getFirstName();
		this.countedVotes = countedVotes;
	}
	
	
	public PollingResult() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(long societyName) {
		this.societyName = society.viewSocietyById(societyName).getSocietyName();
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(long candidateName) {
		this.candidateName = candidates.searchByCandidateId(candidateName).getRegisteredSocietyVoter().getFirstName();
	}
	public long getCountedVotes() {
		return countedVotes;
	}
	public void setCountedVotes(long countedVotes) {
		this.countedVotes = countedVotes;
	}
	
	
	
	
	
	

}
