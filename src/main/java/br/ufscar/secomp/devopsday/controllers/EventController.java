package br.ufscar.secomp.devopsday.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufscar.secomp.devopsday.model.Event;
import br.ufscar.secomp.devopsday.repositories.EventRepository;

@RestController
@RequestMapping (path = "/{user_id}")
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@RequestMapping (path = "/event", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
		Event eventSaved = eventRepository.save(event);
		return new ResponseEntity<Event>(eventSaved, HttpStatus.CREATED);
	}
	
	@RequestMapping (path = "/event", method = RequestMethod.GET)
	public ResponseEntity<?> listAllEvents() {
		List<Event> events = new ArrayList<>();
		loadEventsIntoList(events, eventRepository.findAll());
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	private List<Event> loadEventsIntoList(List<Event> listToFill, Iterable<Event> events) {
		for (Event eachEvent : events) {
			listToFill.add(eachEvent);
		}
		return listToFill;
	}
}
