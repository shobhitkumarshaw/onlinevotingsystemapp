package org.society.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
/*
 * @author: Shobhit Kumar Shaw
 */

@Entity
@Table(	name = "Admin")
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "admin_name")
	private String adminName;
	
	@NotNull
	@Column(name = "admin_password")
	private String adminPassword;
	
	public Admin() {
		super();
		
	}

	public Admin(long id, String adminName, String adminPassword) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
	

}
