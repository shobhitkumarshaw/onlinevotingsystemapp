package org.society.dao;

import java.util.List;

import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerNotFoundException;

public interface ElectionOfficerDao {
	
	public ElectionOfficer save(ElectionOfficer officer);

	public ElectionOfficer update(ElectionOfficer officer) throws ElectionOfficerNotFoundException;

	public boolean delete(long officerId) throws ElectionOfficerNotFoundException;

	public ElectionOfficer getElectionOfficerById(long officerId) throws ElectionOfficerNotFoundException;

	public List<ElectionOfficer> getElectionOfficerList();
	
}
