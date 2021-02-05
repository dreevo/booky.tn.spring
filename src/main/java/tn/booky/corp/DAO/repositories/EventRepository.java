package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.booky.corp.DAO.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
	Event findByTitle(String title);

	@Query("SELECT E from Event E WHERE E.title LIKE %?1%")
	public List<Event> searchEventsByTitle(String keyword);
	
	@Query("SELECT count(C.id),E.id from Event E join E.customers C GROUP BY (E.id) ORDER BY count(C.id)")
	public List<String> getEventsidByParticpation(int Eventid);
	
	@Query("SELECT E.id from Event E join E.book B where B.id=?1")
	public List<String> getEventsByBook(int bookid);
}
