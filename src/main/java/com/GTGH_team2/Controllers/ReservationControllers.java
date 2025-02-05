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
import com.GTGH_team2.Entities.Visitor;
import com.GTGH_team2.Services.ReservationServices;

@RestController
@RequestMapping("reservations")
public class ReservationControllers {

	@Autowired
	ReservationServices reservationServices;

	@GetMapping("/allreservations")
	public List<Reservation> viewAllReservations() {
		reservationServices.viewAllReservations();
		return reservationServices.getReservations();
	}
	
	@GetMapping("/reservationsByVisitor")
	public List<Reservation> viewReservationsByVisitor(@RequestParam Integer idVisitor) {
		return reservationServices.getReservationsByVisitor(idVisitor);
	}

	@PostMapping("/add")
	public List<Reservation> addReservation(@RequestBody Visitor visitor, @RequestBody Event event) {
		return reservationServices.addReservation(visitor, event);
	}

	@DeleteMapping("/deleteReservationsByVisitorId")
	public List<Reservation> deleteReservationsByVisitorId(@RequestParam Integer id) {
		return reservationServices.deleteReservationsByVisitorId(id);
	}

	@DeleteMapping("/deleteReservationsByEventId")
	public List<Reservation> deleteReservationsByEventId(@RequestParam Integer id) {
		return reservationServices.deleteReservationsByEventId(id);
	}

	@PutMapping("/canceling")
	public List<Reservation> ReservationCanceling(@RequestParam Integer visitorId,
			@RequestParam Integer eventId) {
		return reservationServices.ReservationCanceling(visitorId, eventId);
	}

}
