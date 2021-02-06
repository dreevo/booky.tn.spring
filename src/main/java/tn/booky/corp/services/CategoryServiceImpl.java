package tn.booky.corp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Category;
import tn.booky.corp.DAO.repositories.CategoryRepository;

/**
 * @author gharbimedaziz
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Category saveCategory(Category c) {
		return categoryRepository.save(c);
	}

	public List<Category> saveCategories(List<Category> categories) {
		return categoryRepository.saveAll(categories);
	}

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public Category getCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

	public String deleteCategory(int id) {
		categoryRepository.deleteById(id);
		return "Category with name " + id + " removed";
	}

	public Category updateCategory(Category c) {
		// CHECKING IF THE CATEGORY EXISTS IN DATABASE
		Category searchCategoryName = categoryRepository.findByName(c.getName());
		if (searchCategoryName != null)
			return null;
		Category existingCategory = categoryRepository.findById(c.getId()).orElse(null);
		existingCategory.setName(c.getName());
		return categoryRepository.save(existingCategory);
	}
	
	public Category getMostSelectedCategory(){
		return categoryRepository.getMostSelectedCategory();
	}
}
