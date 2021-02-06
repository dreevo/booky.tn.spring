package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Category;

/**
 * @author gharbimedaziz
 */
public interface CategoryService {
	public Category saveCategory(Category c);

	public List<Category> saveCategories(List<Category> categories);

	public List<Category> getCategories();

	public Category getCategoryById(int id);

	public Category getCategoryByName(String name);

	public String deleteCategory(int id);

	public Category updateCategory(Category c);
}
