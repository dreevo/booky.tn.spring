package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Pack;
import tn.booky.corp.services.PackService;

/**
 * @author gharbimedaziz
 */
@RestController
public class PackController {
	@Autowired
	private PackService packService;

	@PostMapping("/addPack")
	public Pack addBook(@RequestBody Pack p) {
		return packService.savePack(p);
	}

	@PostMapping("/addPacks")
	public List<Pack> addPacks(@RequestBody List<Pack> packs) {
		return packService.savePacks(packs);
	}

	@GetMapping("/packs")
	public List<Pack> findAllPacks() {
		return packService.getPacks();
	}

	@GetMapping("/pack/{id}")
	public Pack getPackById(@PathVariable int id) {
		return packService.getPackById(id);
	}

	@GetMapping("/packLabel/{label}")
	public Pack getPackByLabel(@PathVariable String label) {
		return packService.getPackByLabel(label);
	}

	@PutMapping("/updatePack")
	public Pack updateCategory(@RequestBody Pack p) {
		return packService.updatePack(p);
	}

	@DeleteMapping("/deletePack/{id}")
	public String deleteCategory(@PathVariable int id) {
		return packService.deletePack(id);
	}
}
