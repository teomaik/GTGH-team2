package com.GTGH_team2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GTGH_team2.Entities.Event;
import com.GTGH_team2.Entities.Reservation;
import com.GTGH_team2.Services.EventServices;

@RestController // Set the class as a rest controller 
@RequestMapping("/events") // The Path
public class EventControllers {
	@Autowired 
	EventServices eventServices;
	
	@GetMapping("/allEvents")
	public List<Event> getAllEvents() {
		return eventServices.getAllEvents();
	}
	
	@PostMapping("/addEvent")
	public List<Event> addEvent(@RequestBody Event event) {
		eventServices.addEvent(event);
		return eventServices.getAllEvents();
	}
	
	@DeleteMapping("/deleteEvent")
	public List<Event> deleteEvent(@RequestParam Integer id) {
		return eventServices.removeEvent(id);
	}
	
	@PutMapping("/updateEvent")
	public List<Event> updateEvent(@RequestParam Integer id, @RequestParam String newTitle, @RequestParam String newTheme,@RequestParam  String newDescription,@RequestParam  String newLocation, @RequestParam Integer newMaxCapacity, @RequestParam Integer newDay, Integer newMonth, @RequestParam Integer newYear, @RequestParam Integer newHour, @RequestParam Integer newMinute,@RequestParam  String newDuration){
		return eventServices.updateEvent(id, newTitle, newTheme, newDescription, newLocation, newMaxCapacity, newDay, newMonth, newYear, newHour, newMinute, newDuration);
	}
	
	@PostMapping("/bookAnEvent")
	public List<Reservation> bookAnEvent(@RequestParam Integer visitorId, @RequestParam Integer eventId) {
		return eventServices.bookingAnEvent(visitorId,eventId);
	}
	
	@GetMapping("/getApprovedEvents") // Get all the approved events
	public List<Event> getApprovedEvents(){
		return eventServices.getAllApprovedEvents();
	}
	
	@PutMapping("/updateLocation")
	public List<Event> updateLocation(@RequestParam Integer idEvent, @RequestParam String newLocation) {
		return eventServices.updateLocation(idEvent, newLocation);
	}
	
	@PutMapping("/updateDescription")
	public List<Event> updateDescription(@RequestParam Integer idEvent, @RequestParam String newDescription) {
		return eventServices.updateDescription(idEvent, newDescription);
	}
	
	@PutMapping("/updateDate")
	public List<Event> updateDate(@RequestParam Integer idEvent, @RequestParam Integer day, Integer month, Integer year) {
		return eventServices.updateDateOfEvent(idEvent, day,month,year);
	}

	@GetMapping("/getSearchingEvents")
	public List<Event> searchingEvent(@RequestParam Integer day, @RequestParam Integer month, @RequestParam Integer year, @RequestParam String theme){
		return eventServices.searchingAnEvent(day,  month, year,  theme);
	}
	
	@GetMapping("/getSearchingCriteria")
	public List<Event> searchingAnEvent(Integer day, Integer month, Integer year, String theme){
		return eventServices.searchingAnEvent(day,  month, year,  theme);
   }
 

	@PostMapping("/deleteEventByEmployee")
	public List<Event> deleteEvent(@RequestParam Integer idEvent, @RequestParam Integer idEmployee) {
	    return eventServices.deleteEvent(idEvent, idEmployee);
	}
	
	@PostMapping("/CancelEvent")
	public List<Event> cancelEvent(@RequestParam Integer idEvent){
		return eventServices.eventCancellation(idEvent);
	}
	
}
