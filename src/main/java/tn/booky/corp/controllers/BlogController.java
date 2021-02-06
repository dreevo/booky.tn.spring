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

import tn.booky.corp.DAO.entities.Blog;
import tn.booky.corp.services.BlogService;


@RestController
public class BlogController {
	@Autowired
    private BlogService blogService;

    @PostMapping("/addBlog")
    public Blog addComment(@RequestBody Blog b) {
        return blogService.saveBlog(b);
    }

    @PostMapping("/addBlogs")
    public List<Blog> addBlogs(@RequestBody List<Blog> blogs) {
        return blogService.saveBlogs(blogs);
    }

    @GetMapping("/blog/{id}")
    public Blog getBlogById(@PathVariable int id) {
        return blogService.getBlogById(id);
    }

    @PutMapping("/updateBlog")
    public Blog updateBlog(@RequestBody Blog b) {
        return blogService.updateBlog(b);
    }

    @DeleteMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id) {
        return blogService.deleteBlog(id);
    }
    
    @GetMapping("/blogSeek/{keyword}")
    public List<Blog> seekBlogByLabel(@PathVariable String keyword){
        return blogService.searchBlogByLabel(keyword);
    }
    
    @GetMapping("/Ablogs/{id}")
    public List<Blog> getBlogsByAId(@PathVariable int a_Id) {
        return blogService.getBlogsByAId(a_Id);
    }
    
    

}
