package tn.booky.corp.DAO.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.booky.corp.DAO.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
