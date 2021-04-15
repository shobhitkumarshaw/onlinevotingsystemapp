package org.society.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "Election_Result")
public class ElectionResult implements Serializable {

	private static final long serialVersionUID = 123456789L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Basic
	private LocalDate pollingDate;
	
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cooperativeSociety_fk")
	private CooperativeSociety cooperativeSociety;
	
	private int totalSocietyVotes;
	private int totalPolledVotes;
	private float totalPollingPercentage;
	private int totalCandidateVotes;
	private float candidateVotesPercentage;
	@NotNull(message = "Result can not be null")
	private String result;

	public ElectionResult() {
		super();
	}

	public ElectionResult(LocalDate pollingDate, CooperativeSociety cooperativeSociety, int totalSocietyVotes,
			int totalPolledVotes, float totalPollingPercentage, int totalCandidateVotes, float candidateVotesPercentage,
			@NotNull(message = "Result can not be null") String result) {
		super();
		this.pollingDate = pollingDate;
		this.cooperativeSociety = cooperativeSociety;
		this.totalSocietyVotes = totalSocietyVotes;
		this.totalPolledVotes = totalPolledVotes;
		this.totalPollingPercentage = totalPollingPercentage;
		this.totalCandidateVotes = totalCandidateVotes;
		this.candidateVotesPercentage = candidateVotesPercentage;
		this.result = result;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getPollingDate() {
		return pollingDate;
	}

	public void setPollingDate(LocalDate pollingDate) {
		this.pollingDate = pollingDate;
	}

	public CooperativeSociety getCooperativeSociety() {
		return cooperativeSociety;
	}

	public void setCooperativeSociety(CooperativeSociety cooperativeSociety) {
		this.cooperativeSociety = cooperativeSociety;
	}

	public int getTotalSocietyVotes() {
		return totalSocietyVotes;
	}

	public void setTotalSocietyVotes(int totalSocietyVotes) {
		this.totalSocietyVotes = totalSocietyVotes;
	}

	public int getTotalPolledVotes() {
		return totalPolledVotes;
	}

	public void setTotalPolledVotes(int totalPolledVotes) {
		this.totalPolledVotes = totalPolledVotes;
	}

	public float getTotalPollingPercentage() {
		return totalPollingPercentage;
	}

	public void setTotalPollingPercentage(float totalPollingPercentage) {
		this.totalPollingPercentage = totalPollingPercentage;
	}

	public int getTotalCandidateVotes() {
		return totalCandidateVotes;
	}

	public void setTotalCandidateVotes(int totalCandidateVotes) {
		this.totalCandidateVotes = totalCandidateVotes;
	}

	public float getCandidateVotesPercentage() {
		return candidateVotesPercentage;
	}

	public void setCandidateVotesPercentage(float candidateVotesPercentage) {
		this.candidateVotesPercentage = candidateVotesPercentage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
	

	

}
