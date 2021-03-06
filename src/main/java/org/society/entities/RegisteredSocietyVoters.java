/*
  * @author: Aditya Mohapatra
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
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Registered_Society_Voters")
public class RegisteredSocietyVoters implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Voter Id card number must be unique
	@NotNull(message = "Voter Id number can not be null")
	@Column(unique = true)
	private String voterIdCardNo;

	@NotNull(message = "Name is Required")
	@Length(min = 2, max = 30, message = "Name size must be between 2 and 30")
	private String firstName;
	
	@NotNull(message = "Last Name is Required")
	@Length(min = 2, max = 30, message = "Name size must be between 2 and 30")
	private String lastName;

	@NotNull(message = "Gender is Required")
	private String gender;

	@NotNull(message = "Reservation Category is required")
	private String reservationCategory;

	@Pattern(regexp = "^[0][1-9]\\d{9}$|^[1-9]\\d{9}$",message = "Enter Valid Mobile Number!")
	@NotNull(message = "Mobile is Required")
	@Length(min = 10, max = 13, message = "Moblile number should of length between 10 and 13")
	private String mobileno;

	// @email
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Enter Valid Email Id!")
	@NotNull(message = "Email is Required")
	private String emailId;

	@NotNull(message = "address is required")
	private String address;

	@NotNull(message = "mandal is required")
	private String mandal;

	@NotNull(message = "district is required")
	private String district;

	@NotNull(message = "Pincode is required")
	private int pincode;

	private boolean castedVote;

	// active & inactive
	private String status;

	// ManyToOne relationship one Society can have many voters
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL) // added cascade
	@JoinColumn(name = "cooperative_society_fk")
	private CooperativeSociety cooperativeSociety;

	public RegisteredSocietyVoters() {
		super();
	}

	public RegisteredSocietyVoters(long id, @NotNull(message = "Voter Id number can not be null") String voterIdCardNo,
			@NotNull(message = "Name is Required") @Length(min = 2, max = 30, message = "Name size must be between 5 and 30") String firstName,
			String lastName, @NotNull(message = "Gender is Required") String gender,
			@NotBlank(message = "Reservation Category is required") String reservationCategory,
			@Pattern(regexp = "^[0][1-9]\\d{9}$|^[1-9]\\d{9}$") @NotNull(message = "Mobile is Required") @Length(min = 10, max = 13, message = "mobile number should be valid") String mobileno,
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") @NotNull(message = "Email is Required") String emailId,
			@NotNull String address, @NotNull String mandal, @NotNull String district,
			@NotNull(message = "Pincode is required") @Min(6) int pincode, boolean castedVote, String status,
			CooperativeSociety cooperativeSociety) {
		super();
		this.id = id;
		this.voterIdCardNo = voterIdCardNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.reservationCategory = reservationCategory;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address = address;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
		this.castedVote = castedVote;
		this.status = status;
		this.cooperativeSociety = cooperativeSociety;
	}
	
	

	public RegisteredSocietyVoters(@NotNull(message = "Voter Id number can not be null") String voterIdCardNo,
			@NotNull(message = "Name is Required") @Length(min = 2, max = 30, message = "Name size must be between 5 and 30") String firstName,
			String lastName, @NotNull(message = "Gender is Required") String gender,
			@NotBlank(message = "Reservation Category is required") String reservationCategory,
			@Pattern(regexp = "^[0][1-9]\\d{9}$|^[1-9]\\d{9}$") @NotNull(message = "Mobile is Required") @Length(min = 10, max = 13, message = "mobile number should be valid") String mobileno,
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") @NotNull(message = "Email is Required") String emailId,
			@NotNull String address, @NotNull String mandal, @NotNull String district,
			@NotNull(message = "Pincode is required") @Min(6) int pincode, boolean castedVote, String status,
			CooperativeSociety cooperativeSociety) {
		super();
		this.voterIdCardNo = voterIdCardNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.reservationCategory = reservationCategory;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address = address;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
		this.castedVote = castedVote;
		this.status = status;
		this.cooperativeSociety = cooperativeSociety;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVoterIdCardNo() {
		return voterIdCardNo;
	}

	public void setVoterIdCardNo(String voterIdCardNo) {
		this.voterIdCardNo = voterIdCardNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReservationCategory() {
		return reservationCategory;
	}

	public void setReservationCategory(String reservationCategory) {
		this.reservationCategory = reservationCategory;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public boolean isCastedVote() {
		return castedVote;
	}

	public void setCastedVote(boolean castedVote) {
		this.castedVote = castedVote;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CooperativeSociety getCooperativeSociety() {
		return cooperativeSociety;
	}

	public void setCooperativeSociety(CooperativeSociety cooperativeSociety) {
		this.cooperativeSociety = cooperativeSociety;
	}

	@Override
	public String toString() {
		return "RegisteredSocietyVoters [id=" + id + ", voterIdCardNo=" + voterIdCardNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", reservationCategory=" + reservationCategory
				+ ", mobileno=" + mobileno + ", emailId=" + emailId + ", address=" + address + ", mandal=" + mandal
				+ ", district=" + district + ", pincode=" + pincode + ", castedVote=" + castedVote + ", status="
				+ status + ", cooperativeSociety=" + cooperativeSociety + "]";
	}

}