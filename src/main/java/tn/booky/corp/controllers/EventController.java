package tn.booky.corp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.booky.corp.DAO.entities.Event;
import tn.booky.corp.services.EventService;

public class EventController {
@Autowired
private EventService eventService;
@PostMapping("/addEvent")
public Event addEvent(@RequestBody Event ev){
	return eventService .addEvent(ev);
}
}
