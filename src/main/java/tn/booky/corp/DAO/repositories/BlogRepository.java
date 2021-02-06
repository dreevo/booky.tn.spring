package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.booky.corp.DAO.entities.Blog;



public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	@Query (value= "SELECT B FROM Blog B WHERE B.title LIKE ?1%")
    public List<Blog> searchBlogByLabel(String keyword);
	
	@Query (value= "SELECT B FROM Blog B WHERE B.author.id = :a_id")
    public List<Blog> getBlogByAId(@Param("a_id") int a_id);

} 