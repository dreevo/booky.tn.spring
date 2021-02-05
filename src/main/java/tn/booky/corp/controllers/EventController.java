package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Event;
import tn.booky.corp.services.EventService;

@RestController
public class EventController {
	@Autowired
	private EventService eventService;

	@PostMapping("/addEvent")
	public Event addEvent(@RequestBody Event ev) {
		return eventService.addEvent(ev);
	}

	@PutMapping("/updateEvent")
	public Event updateEvent(@RequestBody Event ev) {
		return eventService.updateEvent(ev);
	}

	@GetMapping("/events")
	public List<Event> findAllevents(@Param("keyword") String keyword) {
		return eventService.getEvents(keyword);
	}

	@GetMapping("/event/{title}")
	public Event getEventByTitle(@PathVariable String title) {
		return eventService.getEventByTitle(title);
	}

	@DeleteMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable int id) {
		return eventService.deleteEvent(id);
	}
}
