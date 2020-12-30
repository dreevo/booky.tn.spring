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

import tn.booky.corp.DAO.entities.Category;
import tn.booky.corp.services.CategoryService;

/**
 * @author gharbimedaziz
 */
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public Category addBook(@RequestBody Category c){
		return categoryService.saveCategory(c);
	}
	
	@PostMapping("/addCategories")
	public List<Category> addCategories(@RequestBody List<Category> categories){
		return categoryService.saveCategories(categories);
	}
	
	@GetMapping("/categories")
	public List<Category> findAllCategories(){
		return categoryService.getCategories();
	}
	
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable int id){
		return categoryService.getCategoryById(id);
	}
	
	@GetMapping("/categoryName/{label}")
	public Category getCategoryByName(@PathVariable String name){
		return categoryService.getCategoryByName(name);
	}
	
	@PutMapping("/updateCategory")
	public Category updateCategory(@RequestBody Category c){
		return categoryService.updateCategory(c);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id){
		return categoryService.deleteCategory(id);
	}
}
