package org.society.service;

import org.society.dao.AdminDaoImp;
import org.society.dao.ElectionOfficerDaoImpl;
import org.society.dao.ElectionResultDaoImpl;
import org.society.dao.NominatedCandidatesDaoImpl;
import org.society.dao.RegisteredSocietyVotersDaoImpl;
import org.society.dao.UserDaoImpl;
import org.society.dao.VotedListDaoImpl;
import org.society.entities.Admin;
import org.society.entities.CooperativeSociety;
import org.society.entities.ElectionOfficer;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.User;
import org.society.entities.VotedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDaoImp daoAdmin;

	@Override
	public void addAdminDetails(Admin admin) {
		daoAdmin.save(admin);

	}

	@Override
	public boolean updateAdminDetails(Admin admin) {
		daoAdmin.update(admin);
		return true;
	}

	@Override
	public boolean deleteAdminDetails(long adminID) {
		daoAdmin.delete(adminID);
		return true;
	}

	@Override
	public Admin viewAdminById(long adminId) {
		return daoAdmin.getAdmin(adminId);

	}

}
