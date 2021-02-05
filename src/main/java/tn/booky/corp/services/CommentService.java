package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Comment;

public interface CommentService {
	
	public Comment saveComment(Comment c);

    public List<Comment> saveComments(List<Comment> categories);

    public Comment getCommentById(int id);

    public String deleteComment(int id);

    public Comment updateComment(Comment c);

}
