package com.GTGH_team2.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GTGH_team2.Entities.Event;
import com.GTGH_team2.Entities.Reservation;
import com.GTGH_team2.Entities.Visitor;

@Service
public class ReservationServices {

	private List<Reservation> reservations = new ArrayList<Reservation>();
	@Autowired
	VisitorServices visitorServices;


	public List<Reservation> getReservations() {
		return reservations;
	}

	public void viewAllReservations() {
		if (reservations.isEmpty()) {
			System.out.println("There are no reservations.");
		} else {
			System.out.println("Reservations: ");
			for (Reservation res : reservations) {
				System.out.println(reservations);
			}
		}
	}
	
	public List<Reservation> addReservation(Visitor visitor, Event event) {
		reservations.add(new Reservation(visitor, event));
		System.out.println("Booked Successfully");
		return reservations;
	}

	// Deletes all reservations with a specific visitor id, when a visitor is deleted, his reservations are deleted too
	public List<Reservation>  deleteReservationsByVisitorId(Integer visitorId) {
		reservations.removeIf(reservation -> reservation.getVisitor().getId() == visitorId); // Remove reservations
																								// where the visitor
		System.out.println("All reservations for visitor with id number " + visitorId + " have been deleted!"); // matches the id
		return reservations;																							
	}

	// Deletes all reservations with a specific event id.
	public List<Reservation> deleteReservationsByEventId(Integer eventId) {
		reservations.removeIf(reservation -> reservation.getEvent().getId() == eventId); // Remove reservations where
																							// the event matches the id
		System.out.println("All reservations for event with id number " + eventId + " have been deleted!");
		return reservations;
	}

	
	public Integer reservationsByEvent(Integer idEvent) {
    	Integer counter = 0;
        for (Reservation reservation : reservations) {
            if (reservation.getEvent().getId().equals(idEvent)) {
            	counter++;
               
            }
        }
        return  counter; 
    }
 

	//checking if the visitor has already made a reservation for the event
	public boolean visitorHasMadeARes(Visitor visitor, Event event) {
		for(Reservation res: reservations) {
			if(res.getVisitor() == visitor && res.getEvent() == event)
				return false;
		}
		return true;
	}

	// Canceling an Event
	// This method allows a visitor to cancel a booking for a specific event by
	// their IDs, it checks if the reservation exists and removes it if found
	public List<Reservation> ReservationCanceling(Integer visitorId, Integer eventId) {
		for (Visitor visitor : visitorServices.getAllVisitors()) {
			if (visitor.getId() == visitorId )
				for (Reservation res : reservations) {
					if(res.getEvent().equals(eventId))
						reservations.remove(res);
				}
		}
		return reservations;
	}
    
	//This method returs the reservations that a visitor has made
	public List<Reservation> getReservationsByVisitor(Integer visitorId){
		List<Reservation> visitorsReservations = new ArrayList<>();
		for(Reservation reservation : reservations) {
			if(reservation.getVisitor().getId()==visitorId) {
				visitorsReservations.add(reservation);
			}			
		}
		return visitorsReservations;
	}
	
	//Checking whether a visitor is a participant (has made a reservation)
	public boolean visitorIsParticipant(Visitor visitor, Event event) {
		for(Reservation res: reservations) {
			if(res.getVisitor() == visitor && res.getEvent() == event) {
				return true;
			}
		}
		return false;	
	}


}
