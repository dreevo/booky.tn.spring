package tn.booky.corp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Pack;
import tn.booky.corp.repositories.PackRepository;

/**
 * @author gharbimedaziz
 */
@Service
public class PackServiceImpl implements PackService{
	@Autowired
	private PackRepository packRepository;

	public Pack savePack(Pack p) {
		return packRepository.save(p);
	}

	public List<Pack> savePacks(List<Pack> packs) {
		return packRepository.saveAll(packs);
	}

	public List<Pack> getPacks() {
		return packRepository.findAll();
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
		// CHECKING IF THE PACK LABEL EXISTS IN DATABASE
		Pack searchPackLabel = packRepository.findByLabel(p.getLabel());
		if (searchPackLabel != null)
			return null;
		Pack existingPack = packRepository.findById(p.getId()).orElse(null);
		existingPack.setLabel(p.getLabel());
		existingPack.setDescription(p.getDescription());
		existingPack.setImageUrl(p.getImageUrl());
		existingPack.setPrice(p.getPrice());
		existingPack.setBooks(p.getBooks());
		return packRepository.save(existingPack);
	}
}
