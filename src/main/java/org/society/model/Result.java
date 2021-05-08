package org.society.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Result {
	
	private LocalDateTime date;
	private String socityName;
	private String candidateName;
	private String party;
	private long postedVotes;
	private long totalVotes;
	private double pollingPercentage;
	
	public Result(LocalDateTime date, String socityName, String candidateName, String party, long postedVotes,
			long totalVotes, double pollingPercentage) {
		super();
		this.date = date;
		this.socityName = socityName;
		this.candidateName = candidateName;
		this.party = party;
		this.postedVotes = postedVotes;
		this.totalVotes = totalVotes;
		this.pollingPercentage = pollingPercentage;
	}
	
	public Result() {
		super();
		
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getSocityName() {
		return socityName;
	}

	public void setSocityName(String socityName) {
		this.socityName = socityName;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public long getPostedVotes() {
		return postedVotes;
	}

	public void setPostedVotes(long postedVotes) {
		this.postedVotes = postedVotes;
	}

	public long getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(long totalVotes) {
		this.totalVotes = totalVotes;
	}

	public double getPollingPercentage() {
		return pollingPercentage;
	}

	public void setPollingPercentage(long pollingPercentage) {
		this.pollingPercentage = pollingPercentage;
	}
	
	
	
	
	
	

}
