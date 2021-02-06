package tn.booky.corp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Blog;
import tn.booky.corp.DAO.entities.Comment;
import tn.booky.corp.DAO.repositories.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Blog saveBlog(Blog b) {
		// TODO Auto-generated method stub
		return blogRepository.save(b);
	}

	@Override
	public List<Blog> saveBlogs(List<Blog> blogs) {
		// TODO Auto-generated method stub
		return (List<Blog>) blogRepository.saveAll(blogs);
	}

	@Override
	public Blog getBlogById(int id) {
		// TODO Auto-generated method stub
		return blogRepository.findById(id).orElse(null);
	}

	@Override
	public String deleteBlog(int id) {
		// TODO Auto-generated method stub
		blogRepository.deleteById(id);
		return "Blog with label " + id + " removed";
	}

	@Override
	public Blog updateBlog(Blog b) {
		// TODO Auto-generated method stub
		Blog existingBlog = blogRepository.findById(b.getId()).orElse(null);
		if (b.getTitle() != null)
			existingBlog.setTitle(b.getTitle());
		if (b.getContent() != null)
			existingBlog.setContent(b.getContent());
		if (b.getAuthor() != null)
			existingBlog.setAuthor(b.getAuthor());
		if (b.getComments().size() != 0)
			existingBlog.setComments(b.getComments());
		return blogRepository.save(existingBlog);
	}
	
	@Override
	public List<Blog> searchBlogByLabel(String keyword){
        return blogRepository.searchBlogByLabel(keyword);
    }
	@Override
    public List<Blog> getBlogsByAId(int a_id){

        return blogRepository.getBlogByAId(a_id);
    }

}
