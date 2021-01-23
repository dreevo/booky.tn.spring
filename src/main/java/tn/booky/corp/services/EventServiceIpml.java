package tn.booky.corp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Event;
import tn.booky.corp.DAO.repositories.EventRepository;

@Service
public class EventServiceIpml implements EventService {
	@Autowired
	private EventRepository eventRepository;

	public Event addEvent(Event ev) {
		return eventRepository.save(ev);
	}

	public Event updateEvent(Event ev) {
		Event existingEvent = eventRepository.findById(ev.getId()).orElse(null);
		if (ev.getTitle() != null)
			existingEvent.setTitle(ev.getTitle());
		if (ev.getImageUrl() != null)
			existingEvent.setDescription(ev.getDescription());
		if (ev.getBeginDate() != null)
			existingEvent.setBeginDate(ev.getBeginDate());
		if (ev.getEndDate() != null)
			existingEvent.setEndDate(ev.getEndDate());
		if (ev.getImageUrl() != null)
			existingEvent.setImageUrl(ev.getImageUrl());
		return eventRepository.save(existingEvent);
	}

	public String deleteEvent(int id) {
		eventRepository.deleteById(id);
		return "Event with name " + id + " removed";
	}
}
