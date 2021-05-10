/*
  * @author: Nagidi Bhanu prakash
 */
package org.society.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String userName;

	@NotNull(message = "Password can not be null")
	@Length(min = 5, max = 30, message = "Password size must be between 5 and 30")
	private String password;
	@NotNull(message = "Role can not be null")
	@Length(min = 2, max = 30)
	private String role;

	public User(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}