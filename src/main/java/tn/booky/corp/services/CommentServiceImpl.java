package tn.booky.corp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Blog;
import tn.booky.corp.DAO.entities.Comment;
import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.repositories.BlogRepository;
import tn.booky.corp.DAO.repositories.CommentRepository;
import tn.booky.corp.DAO.repositories.CustomerRepository;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Comment saveComment(Comment comment) {
        // TODO Auto-generated method stub
    	Customer customer = customerRepository.findById(comment.getCustomer().getId()).orElse(null);
    	Blog blog = blogRepository.findById(comment.getBlog().getId()).orElse(null);
    	comment.setBlog(blog);
    	comment.setCustomer(customer);
        return commentRepository.save(comment);    }

    @Override
    public List<Comment> saveComments(List<Comment> Comments) {
        // TODO Auto-generated method stub
         return (List<Comment>) commentRepository.saveAll(Comments);
    }

    @Override
    public Comment getCommentById(int id) {
        // TODO Auto-generated method stub
         return commentRepository.findById(id).orElse(null);    }



    @Override
    public String deleteComment(int id) {
        // TODO Auto-generated method stub
        commentRepository.deleteById(id);
        return "Comment with label " + id + " removed";    }

    @Override
    public Comment updateComment(Comment b) {
        // TODO Auto-generated method stub
         Comment existingComment = commentRepository.findById(b.getId()).orElse(null);
            if (b.getDescription() != null)
                existingComment.setDescription(b.getDescription());
            if (b.getCustomer() != null)
                existingComment.setCustomer(b.getCustomer());
            if (b.getBlog() != null)
                existingComment.setBlog(b.getBlog());
            return commentRepository.save(existingComment);    }


}
