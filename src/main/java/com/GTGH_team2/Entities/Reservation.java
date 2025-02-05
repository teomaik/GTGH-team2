package com.GTGH_team2.Entities;



public class Reservation {
	private Visitor visitor;
	private Event event;
	private Integer id;

	public Reservation(Visitor visitor, Event event) {
		this.visitor = visitor;
		this.event = event;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Reservation{" + "visitor=" + visitor.getName() + " " + visitor.getSurname() + ", event="
				+ event.getTitle() + '}';
	}

}
