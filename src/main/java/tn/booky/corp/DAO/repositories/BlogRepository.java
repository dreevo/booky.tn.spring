package tn.booky.corp.DAO.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.booky.corp.DAO.entities.Blog;

public interface BlogRepository extends CrudRepository<Blog, Integer> {

}