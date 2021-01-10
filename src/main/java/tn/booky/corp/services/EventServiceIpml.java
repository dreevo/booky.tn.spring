package tn.booky.corp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Event;
import tn.booky.corp.repositories.EventRepository;
@Service
public class EventServiceIpml {
	@Autowired
	private EventRepository eventRepository;

	public Event addEvent(Event ev){
		return eventRepository.save(ev);
	}
}
