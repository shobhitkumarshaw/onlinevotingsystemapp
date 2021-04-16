/*
 *@author: Ritik Kumar 
 */
package org.society.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cooperative_Society")
public class CooperativeSociety implements Serializable {

	private static final long serialVersionUID = -5923648127953469592L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String societyName;

	@NotNull
	private String headOfSociety;

	@NotNull
	private String village;

	@NotNull
	private String mandal;

	@NotNull
	private String district;

	@NotNull(message = "Pincode is required")
	@Length(min = 6)//@Min(6)
	private String pincode;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cooperativeSociety", targetEntity = RegisteredSocietyVoters.class)
	private List<RegisteredSocietyVoters> registeredSocietyVoters = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "cooperativeSociety", targetEntity = NominatedCandidates.class)
	private List<NominatedCandidates> nominatedCandidates = new ArrayList<>();

	public CooperativeSociety() {
		super();

	}

	public CooperativeSociety(String societyName, String headOfSociety, String village, String mandal, String district,
			String pincode, List<RegisteredSocietyVoters> registeredSocietyVoters,
			List<NominatedCandidates> nominatedCandidates) {
		super();
		this.societyName = societyName;
		this.headOfSociety = headOfSociety;
		this.village = village;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
		this.registeredSocietyVoters = registeredSocietyVoters;
		this.nominatedCandidates = nominatedCandidates;
	}

	public List<RegisteredSocietyVoters> getRegisteredSocietyVoters() {
		return registeredSocietyVoters;
	}

	public void setRegisteredSocietyVoters(List<RegisteredSocietyVoters> registeredSocietyVoters) {
		this.registeredSocietyVoters = registeredSocietyVoters;
	}

	public List<NominatedCandidates> getNominatedCandidates() {
		return nominatedCandidates;
	}

	public void setNominatedCandidates(List<NominatedCandidates> nominatedCandidates) {
		this.nominatedCandidates = nominatedCandidates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getHeadOfSociety() {
		return headOfSociety;
	}

	public void setHeadOfSociety(String headOfSociety) {
		this.headOfSociety = headOfSociety;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
