package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.booky.corp.DAO.entities.Comment;
import tn.booky.corp.DAO.entities.Customer;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    @Query ("SELECT C FROM Comment C join C.customer CU where CU.id=?1")
    public List<Comment> getCommentsByCuId(long id, String x);
    
    @Query(value = "SELECT count(CO) from Customer C join C.comments CO group by C.id order by count(CO) DESC")
    Customer getTopFan();
}