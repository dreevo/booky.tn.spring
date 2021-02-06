package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Comment;
import tn.booky.corp.DAO.entities.Customer;

public interface CommentService {
	
	public Comment saveComment(Comment c);

    public List<Comment> saveComments(List<Comment> categories);

    public Comment getCommentById(int id);

    public String deleteComment(int id);

    public Comment updateComment(Comment c);
    
    public List<Comment> getCommentsByblogId(int blogId);
    
    public List<Comment> getCommentsByCuId(int cu_id);
	
    public Customer getTopFan();

}
