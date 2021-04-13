package org.society.service;


import org.society.entities.Admin;
import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionOfficer;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.User;
import org.society.entities.VotedList;

public interface AdminService {
	public void addAdminDetails(Admin admin);

	public boolean updateAdminDetails(Admin admin);

	public boolean deleteAdminDetails(long adminId);

	public Admin viewAdminById(long adminId);

	
}
