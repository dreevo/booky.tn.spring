package tn.booky.corp.DAO.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.booky.corp.DAO.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

}