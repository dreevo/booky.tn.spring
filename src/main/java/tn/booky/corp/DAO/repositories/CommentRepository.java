package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.booky.corp.DAO.entities.Comment;
import tn.booky.corp.DAO.entities.Customer;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	//NativeQuery
	@Query (value= "select * from t_comment WHERE t_comments.b_id= :blog_id", nativeQuery= true )
    public List<Comment> getCommentsByblogId(@Param("blog_id") int blog_id);
	
	@Query ("SELECT C FROM Comment C join C.customer CU where CU.id=?1")
    public List<Comment> getCommentsByCuId(long id);
	
	@Query(value = "SELECT count(CO) from Customer C join C.comments CO group by C.id order by count(CO) DESC")
    Customer getTopFan();
	
     
    
}