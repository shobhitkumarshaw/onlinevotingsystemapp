/*
  * @author: Nagidi Bhanu prakash
 */
package org.society.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class User implements  Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String userName;

	@NotNull
	private String password;
	
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



	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
	
}