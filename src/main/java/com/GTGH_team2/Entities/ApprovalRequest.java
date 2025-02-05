package com.GTGH_team2.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ApprovalRequest {
	private Integer id;
    private String type; // Type of the request ("Add" or "Delete")
    private Event event; // The event
    private Organizer submittedBy; // The organizer who submitted the request
    private String createdAt; // Date when the request was created
    private String status; // Status of the request("Pending", "Approved", "Rejected")
    private Employee handledBy; // The employee who handles the request
    private String closedAt; // Date when the request was closed
    private String comments; 

    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
    
    // Constructor
	public ApprovalRequest(Integer id,String type, Event event, Organizer submittedBy, String comments) {
	    this.id = id;
		this.type = type;
		this.event = event;
		this.submittedBy = submittedBy;
		LocalDateTime time = LocalDateTime.now();
		this.createdAt = time.format(formatter);
		this.status = "Pending";
		this.handledBy = null;
		this.closedAt = null;
		this.comments = comments;
	}
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}


	public Organizer getSubmittedBy() {
		return submittedBy;
	}


	public void setSubmittedBy(Organizer submittedBy) {
		this.submittedBy = submittedBy;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Employee getHandledBy() {
		return handledBy;
	}


	public void setHandledBy(Employee handledBy) {
		this.handledBy = handledBy;
	}


	public String getClosedAt() {
		return closedAt;
	}


	public void setClosedAt(String closedAt) {
		this.closedAt = closedAt;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


}


