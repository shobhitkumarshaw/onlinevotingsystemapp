/*
 * @author- Govind Kidambi
 * 
 * This is Nominated Candidates File
 */

package org.society.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Nominated_Candidates")
public class NominatedCandidates implements Serializable {

	private static final long serialVersionUID = 99L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long candidateId;
	// add unique constraint here
	//@Column(unique = true)
	private long nominationFormNo;

	private String partyName;

	private String symbol;

	@Min(value = 0, message = "Security Deposit should not be less than 0")
	private float securityDeposit;

	// It must be true only than a candidate can complete his or her can registration process
	//@AssertTrue
	private boolean oathOrAffirmationSummited;

	//@AssertTrue
	private boolean policeVerificationDone;

	//@AssertTrue
	private boolean approvedByElectionOfficer;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "registered_society_voter_fk")
	private RegisteredSocietyVoters registeredSocietyVoter;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)// added cascade
	@JoinColumn(name="cooperativeSociety_fk")
	private CooperativeSociety cooperativeSociety;

	public NominatedCandidates() {
		super();
	}

	

	public NominatedCandidates(long candidateId, long nominationFormNo, String partyName, String symbol,
			@Min(value = 0, message = "Security Deposit should not be less than 0") float securityDeposit,
			@AssertTrue boolean oathOrAffirmationSummited, @AssertTrue boolean policeVerificationDone,
			@AssertTrue boolean approvedByElectionOfficer, RegisteredSocietyVoters registeredSocietyVoter,
			CooperativeSociety cooperativeSociety) {
		super();
		this.candidateId = candidateId;
		this.nominationFormNo = nominationFormNo;
		this.partyName = partyName;
		this.symbol = symbol;
		this.securityDeposit = securityDeposit;
		this.oathOrAffirmationSummited = oathOrAffirmationSummited;
		this.policeVerificationDone = policeVerificationDone;
		this.approvedByElectionOfficer = approvedByElectionOfficer;
		this.registeredSocietyVoter = registeredSocietyVoter;
		this.cooperativeSociety = cooperativeSociety;
	}

	

	public CooperativeSociety getCooperativeSociety() {
		return cooperativeSociety;
	}



	public void setCooperativeSociety(CooperativeSociety cooperativeSociety) {
		this.cooperativeSociety = cooperativeSociety;
	}



	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public long getNominationFormNo() {
		return nominationFormNo;
	}

	public void setNominationFormNo(long nominationFormNo) {
		this.nominationFormNo = nominationFormNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getSecurityDeposit() {
		return securityDeposit;
	}

	public void setSecurityDeposit(float securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	public boolean isOathOrAffirmationSummited() {
		return oathOrAffirmationSummited;
	}

	public void setOathOrAffirmationSummited(boolean oathOrAffirmationSummited) {
		this.oathOrAffirmationSummited = oathOrAffirmationSummited;
	}

	public boolean isPoliceVerificationDone() {
		return policeVerificationDone;
	}

	public void setPoliceVerificationDone(boolean policeVerificationDone) {
		this.policeVerificationDone = policeVerificationDone;
	}

	public boolean isApprovedByElectionOfficer() {
		return approvedByElectionOfficer;
	}

	public void setApprovedByElectionOfficer(boolean approvedByElectionOfficer) {
		this.approvedByElectionOfficer = approvedByElectionOfficer;
	}

	public RegisteredSocietyVoters getRegisteredSocietyVoter() {
		return registeredSocietyVoter;
	}

	public void setRegisteredSocietyVoter(RegisteredSocietyVoters registeredSocietyVoter) {
		this.registeredSocietyVoter = registeredSocietyVoter;
	}



	@Override
	public String toString() {
		return "NominatedCandidates [candidateId=" + candidateId + ", nominationFormNo=" + nominationFormNo
				+ ", partyName=" + partyName + ", symbol=" + symbol + ", securityDeposit=" + securityDeposit
				+ ", oathOrAffirmationSummited=" + oathOrAffirmationSummited + ", policeVerificationDone="
				+ policeVerificationDone + ", approvedByElectionOfficer=" + approvedByElectionOfficer
				+ ", registeredSocietyVoter=" + registeredSocietyVoter + ", cooperativeSociety=" + cooperativeSociety
				+ "]";
	}
	
	
	
}
