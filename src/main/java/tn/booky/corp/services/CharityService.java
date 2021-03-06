package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Charity;

/**
 * @author Malek
 *
 */
public interface CharityService {
	public Charity addCharity(Charity ch);

	public String deleteCharityById(int id);

	public List<Charity> getAllCharities();

	public Charity updateCharity(Charity ch);

	public Charity getCharityById(int id);

	public String deleteCharities();
}
