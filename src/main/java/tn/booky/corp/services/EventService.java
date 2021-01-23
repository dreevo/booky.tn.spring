package tn.booky.corp.services;

import tn.booky.corp.DAO.entities.Event;

public interface EventService {
	public Event addEvent(Event ev);

	public Event updateEvent(Event ev);

	public String deleteEvent(int id);
}
