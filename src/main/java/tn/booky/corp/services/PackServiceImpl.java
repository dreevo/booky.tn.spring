package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Pack;
import tn.booky.corp.DAO.repositories.PackRepository;

/**
 * @author gharbimedaziz
 */
@Service
public class PackServiceImpl implements PackService {
	@Autowired
	private PackRepository packRepository;
	@Autowired
	CustomerService customerService;

	public Pack savePack(Pack p) {
		return packRepository.save(p);
	}

	public List<Pack> savePacks(List<Pack> packs) {
		return packRepository.saveAll(packs);
	}

	public List<Pack> getPacks(String keyword) {
		List<Pack> packs = new ArrayList<>();
		if (keyword != null)
			packs = packRepository.searchPacksByLabel(keyword);
		else
			packs = packRepository.findAll();
		return packs;
	}
	
	public List<Pack> getPacksSortedByPriceASC() {
		List<Pack> packs = packRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
		return packs;
	}

	public List<Pack> getPacksSortedByPriceDESC() {
		List<Pack> packs = packRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
		return packs;
	}

	public Pack getPackById(int id) {
		return packRepository.findById(id).orElse(null);
	}

	public Pack getPackByLabel(String label) {
		return packRepository.findByLabel(label);
	}

	public String deletePack(int id) {
		packRepository.deleteById(id);
		return "Pack with label " + id + " removed";
	}

	public Pack updatePack(Pack p) {
		Pack existingPack = packRepository.findById(p.getId()).orElse(null);
		if (p.getLabel() != null)
			existingPack.setLabel(p.getLabel());
		if (p.getDescription() != null)
			existingPack.setDescription(p.getDescription());
		if (p.getImageUrl() != null)
			existingPack.setImageUrl(p.getImageUrl());
		if (p.getPrice() != 0)
			existingPack.setPrice(p.getPrice());
		if (p.getBooks().size() != 0)
			existingPack.setBooks(p.getBooks());
		return packRepository.save(existingPack);
	}
	
	public List<Pack> getMostSelectedPacksByCustomer(){
		Customer customer = customerService.getAuthenticatedCustomer();
		List<Pack> topSelectedPacks = packRepository.getMostSelectedPacksByCustomer(customer.getId());
		topSelectedPacks = topSelectedPacks.stream().collect(Collectors.toList());
		return topSelectedPacks;
	}
}
