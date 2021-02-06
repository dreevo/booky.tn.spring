package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Blog;
import tn.booky.corp.DAO.entities.Comment;

public interface BlogService {
	public Blog saveBlog(Blog b);

    public List<Blog> saveBlogs(List<Blog> categories);

    public Blog getBlogById(int id);

    public String deleteBlog(int id);

    public Blog updateBlog(Blog b);
    
    public List<Blog> searchBlogByLabel(String keyword);
    
    public List<Blog> getBlogsByAId(int a_id);
}
