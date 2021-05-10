/*
 * @author Shobhit Kumar Shaw
 * 
 */

package org.society.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Election_Officer")
public class ElectionOfficer implements Serializable {

	private static final long serialVersionUID = 99L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Name is Required")
	@Length(min = 2, max = 30, message = "First name size must be between 2 and 30")
	private String firstName;
	@NotNull(message = "Last Name is Required")
	@Length(min = 2, max = 30, message = "Last name size must be between 2 and 30")
	private String lastName;
	@NotNull(message = "Gender is Required")
	private String gender;
	
	@Pattern(regexp = "^[0][1-9]\\d{9}$|^[1-9]\\d{9}$",message = "Enter Valid Mobile Number")
	@NotNull(message = "Mobile is Required")
	@Length(min = 10, max = 13, message = "mobile number should be valid")
	private String mobileno;
	@Column(unique = true)
	
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message ="Enter valid Email Id")
	@NotNull(message = "Email is Required")
	private String emailId;
	
	@NotNull(message = "Address 1 is required")
	private String address1;
	@NotNull(message = "Address 2 is required")
	private String address2;
	
	@NotNull(message = "district is required")
	private String district;
	
	@NotNull(message = "Pincode is required")
	@Min(6)
	private int pincode;

	public ElectionOfficer() {
		super();

	}

	public ElectionOfficer(String firstName, String lastName, String gender, String mobileno, String emailId,
			String address1, String address2, String district, int pincode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.district = district;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	@Override
	public String toString() {
		return "ElectionOfficer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobileno=" + mobileno + ", emailId=" + emailId + ", address1=" + address1 + ", address2="
				+ address2 + ", district=" + district + ", pincode=" + pincode + "]";
	}

}
