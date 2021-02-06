package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Pack;

/**
 * @author gharbimedaziz
 */
public interface PackService {
	public Pack savePack(Pack c);

	public List<Pack> savePacks(List<Pack> categories);

	public List<Pack> getPacks(String keyword);
	
	public List<Pack> getPacksSortedByPriceASC();

	public List<Pack> getPacksSortedByPriceDESC();

	public Pack getPackById(int id);

	public Pack getPackByLabel(String label);

	public String deletePack(int id);

	public Pack updatePack(Pack c);
	
	public List<Pack> getMostSelectedPacksByCustomer();
	
	public List<Pack> getRecommendedPacksForCustomer(String surveyAnswer);
	
	public boolean validatePackImageUrl(int packId);
}
