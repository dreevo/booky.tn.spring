package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Comment;
import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.services.CommentService;



@RestController
@RequestMapping("/rest/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment c) {
        return commentService.saveComment(c);
    }

    @PostMapping("/addComments")
    public List<Comment> addComments(@RequestBody List<Comment> comments) {
        return commentService.saveComments(comments);
    }

    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable int id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/updateComment")
    public Comment updateComment(@RequestBody Comment c) {
        return commentService.updateComment(c);
    }

    @DeleteMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable int id) {
        return commentService.deleteComment(id);
    }
    
    @GetMapping("/blogcomments/{b_id}")
    public List<Comment> getCommentsByBlId(@PathVariable int blogId) {
        return commentService.getCommentsByblogId(blogId);
    }
    
    @GetMapping("/Cuscomments/{id}")
    public List<Comment> getCommentsByCuId(@PathVariable int id) {
        return commentService.getCommentsByCuId(id);
    }
    
    @GetMapping("/Fan/getTopFan")
    public Customer getTopFan (){
    	return commentService.getTopFan();
    
    }
}
