/*
 * @author: Aditya Mohapatra
 */

package org.society.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Voted_list")
public class VotedList implements Serializable {
	private static final long serialVersionUID = 856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Basic
	private LocalDateTime pollingDateTime; 
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cooperative_society_fk")
	private CooperativeSociety cooperativeSociety;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "registered_society_voters_fk")
	private RegisteredSocietyVoters registeredSocietyVoters;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nominated_candidates_fk")
	private NominatedCandidates nominatedCandidates;
	

	public VotedList() {
		super();
	}


	public VotedList(LocalDateTime pollingDateTime, CooperativeSociety cooperativeSociety,
			RegisteredSocietyVoters registeredSocietyVoters, NominatedCandidates nominatedCandidates) {
		super();
		this.pollingDateTime = pollingDateTime;
		this.cooperativeSociety = cooperativeSociety;
		this.registeredSocietyVoters = registeredSocietyVoters;
		this.nominatedCandidates = nominatedCandidates;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public LocalDateTime getPollingDateTime() {
		return pollingDateTime;
	}


	public void setPollingDateTime(LocalDateTime pollingDateTime) {
		this.pollingDateTime = pollingDateTime;
	}


	public CooperativeSociety getCooperativeSociety() {
		return cooperativeSociety;
	}


	public void setCooperativeSociety(CooperativeSociety cooperativeSociety) {
		this.cooperativeSociety = cooperativeSociety;
	}


	public RegisteredSocietyVoters getRegisteredSocietyVoters() {
		return registeredSocietyVoters;
	}


	public void setRegisteredSocietyVoters(RegisteredSocietyVoters registeredSocietyVoters) {
		this.registeredSocietyVoters = registeredSocietyVoters;
	}


	public NominatedCandidates getNominatedCandidates() {
		return nominatedCandidates;
	}


	public void setNominatedCandidates(NominatedCandidates nominatedCandidates) {
		this.nominatedCandidates = nominatedCandidates;
	}
	
	

	
	
	
	
	
	

}