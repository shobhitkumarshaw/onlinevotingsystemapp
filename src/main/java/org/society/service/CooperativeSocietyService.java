package org.society.service;

import java.util.List;

import org.society.entities.CooperativeSociety;

public interface CooperativeSocietyService {
	
	public CooperativeSociety addSocietyDetails(CooperativeSociety society);

	public CooperativeSociety updateSocietyDetails(CooperativeSociety society);

	public boolean deleteSociety(long societyId);

	public List<CooperativeSociety> viewSocietiesList();

	public CooperativeSociety viewSocietyById(long societyId);
}
