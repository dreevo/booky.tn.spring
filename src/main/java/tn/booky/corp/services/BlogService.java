package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Blog;

public interface BlogService {
	public Blog saveBlog(Blog b);

    public List<Blog> saveBlogs(List<Blog> categories);

    public Blog getBlogById(int id);

    public String deleteBlog(int id);

    public Blog updateBlog(Blog b);
}
