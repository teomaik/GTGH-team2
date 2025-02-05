package com.GTGH_team2.Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GTGH_team2.Entities.ApprovalRequest;
import com.GTGH_team2.Entities.Employee;
import com.GTGH_team2.Entities.Event;
import com.GTGH_team2.Entities.Organizer;

//The ApprovalRequestServices class handles the requests 
//that an organizer makes for the events. The organizer makes a request
//to add or delete an event. This request has to be approved or rejected by the 
//employee

@Service
public class ApprovalRequestServices {

	// List to store all the ApprovalRequests
	private List<ApprovalRequest> approvalRequests = new ArrayList<>();

	@Autowired
	OrganizerServices organizerServices;
	@Autowired
	EmployeeServices employeeServices;
	@Autowired
	EventServices eventServices;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");

	// This method creates and adds an Approval Request to the approvalRequests list
	public void addApprovalRequest(String type, Event event, Organizer organizer, String comments) {
		int newId = 1;
		if (approvalRequests.size() > 0) {
			newId = approvalRequests.get(approvalRequests.size() - 1).getId() + 1;
		}

		approvalRequests.add(new ApprovalRequest(newId, type, event, organizer, comments));

	}

	// This method removes an Approval Request from the approvalRequests list
	public List<ApprovalRequest> removeApprovalRequest(Integer idRequest) {
		approvalRequests.removeIf(approvalRequest -> approvalRequest.getId() == idRequest);
		return approvalRequests;
	}

	// This method returns the approvalRequests list
	public List<ApprovalRequest> getApprovalRequest() {
		return approvalRequests;
	}

	// This method returns only the pending requests from the approvalRequests list
	public List<ApprovalRequest> getAllPendingRequests() {
		List<ApprovalRequest> pendingRequests = new ArrayList<ApprovalRequest>(); // All requests that are pending
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (approvalRequest.getStatus() == "Pending")
				pendingRequests.add(approvalRequest);
		}
		return pendingRequests;
	}

	// This method updates the parameters of Approval Request
	public List<ApprovalRequest> updateApprovalRequest(Integer id, String newType, Event newEvent,
			Organizer newOrganizer, String newCreatedAt, String newStatus, Employee newEmployee, String newClosedAt,
			String newComments) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (id == approvalRequest.getId()) {
				if (newType != null)
					approvalRequest.setType(newType);
				if (newEvent != null)
					approvalRequest.setEvent(newEvent);
				if (newOrganizer != null)
					approvalRequest.setSubmittedBy(newOrganizer);
				if (newCreatedAt != null)
					approvalRequest.setCreatedAt(newCreatedAt);
				if (newStatus != null)
					approvalRequest.setStatus(newStatus);
				if (newEmployee != null)
					approvalRequest.setHandledBy(newEmployee);
				if (newClosedAt != null)
					approvalRequest.setClosedAt(newClosedAt);
				if (newComments != null)
					approvalRequest.setComments(newComments);
			}
		}
		return approvalRequests;
	}

	// This method assigns the Employee that handles the Approval Request
	public void assignApprovalRequestEmployee(int idApprovalRequest, int idEmployee) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (idApprovalRequest == approvalRequest.getId()) {
				for (Employee employeee : employeeServices.getAllEmployees()) {
					if (employeee.getId() == idEmployee) {
						approvalRequest.setHandledBy(employeee);
					}
				}
			}
		}
	}

	// This method updates the status of the Approval Request. status is "Accepted"
	// or "Rejected"
	public void updateApprovalRequestStatus(int idApprovalRequest, String newStatus) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (idApprovalRequest == approvalRequest.getId()) {
				if (newStatus != null)
					approvalRequest.setStatus(newStatus);
			}
		}
	}

	// This method updates the time and date that Approval Request is closed at.
	public void updateApprovalRequestClosedAt(int idApprovalRequest, String newClosedAt) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (idApprovalRequest == approvalRequest.getId()) {
				if (newClosedAt != null)
					approvalRequest.setClosedAt(newClosedAt);
			}
		}
	}

	// This method allows the Organizer to make a request to add an Event
	public List<ApprovalRequest> makeRequestToAddAnEvent(String title, String theme, String description,
			String location, Integer maxCapacity, Integer day, Integer month, Integer year, Integer hour,
			Integer minutes, String duration, Integer idOrganizer, String comments) {
		for (Organizer organizer : organizerServices.getOrganizers()) {
			if (idOrganizer == organizer.getId()) {
				Event event = eventServices.createAnEvent(title, theme, description, location, maxCapacity, day, month,
						year, hour, minutes, duration, organizer);
				addApprovalRequest("Add", event, organizer, comments);

			}
		}
		return approvalRequests;
	}

	// This method allows the Organizer to make a request to delete an Event
	// with comments.
	public List<ApprovalRequest> makeRequestToDelete(Integer idEvent, Integer idOrganizer, String comments) {
		for (Event event : eventServices.getAllEvents()) {
			if (event.getId() == idEvent) {
				for (Organizer organizer : organizerServices.getOrganizers()) {
					if (idOrganizer == organizer.getId()) {
						addApprovalRequest("Delete", event, organizer, comments);
					}
				}
			}
		}
		return approvalRequests;
	}

	// This method allows the Employee to accept or reject a request to add an
	// event. updatedStatus
	// is "Accepted" or "Rejected"
	public List<ApprovalRequest> handleRequestToAdd(Integer idApprovalRequest, Integer idEmployee,
			String updatedStatus) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				Employee employee = employeeServices.getEmployeeById(idEmployee);
				assignApprovalRequestEmployee(idApprovalRequest, idEmployee);
				updateApprovalRequestStatus(idApprovalRequest, updatedStatus);
				LocalDateTime time = LocalDateTime.now();
				String timeClosed = time.format(formatter);
				updateApprovalRequestClosedAt(idApprovalRequest, timeClosed);
				eventServices.updateEventStatus(getEventID(idApprovalRequest), updatedStatus);
				if (updatedStatus.equals("Accepted"))
					updateOrganizersEvent(approvalRequest.getSubmittedBy(), approvalRequest.getEvent());
			}

		}
		return approvalRequests;
	}

	private void updateOrganizersEvent(Organizer organizer, Event event) {
		organizer.addEvent(event);
	}

	// This method allows the Employee to approve or reject a request to delete an
	// Event. updatedStatus is "Accepted" or "Rejected"
	public List<ApprovalRequest> handleRequestToDelete(Integer idApprovalRequest, Integer idEmployee,
			String updatedStatus) {
		for (ApprovalRequest approvalRequest : getApprovalRequest()) {
			if (approvalRequest.getId() == idApprovalRequest) {
				Employee employee = employeeServices.getEmployeeById(idEmployee);
				assignApprovalRequestEmployee(idApprovalRequest, idEmployee);
				updateApprovalRequestStatus(idApprovalRequest, updatedStatus);
				LocalDateTime time = LocalDateTime.now();
				String timeClosed = time.format(formatter);
				updateApprovalRequestClosedAt(idApprovalRequest, timeClosed);
				if (updatedStatus.equals("Accepted"))
					eventServices.updateEventStatus(getEventID(idApprovalRequest), "Deleted");

			}
		}
		return approvalRequests;
	}

	// This method returs the request that an employee has handled
	public List<ApprovalRequest> getRequestsOfEmployee(Integer employeeId) {
		List<ApprovalRequest> tempList = new ArrayList<>();
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (approvalRequest.getHandledBy().getId() == employeeId) {
				tempList.add(approvalRequest);
			}
		}
		return tempList;
	}

	// This method returns the ID of the event that is in the request
	public Integer getEventID(Integer idApprovalRequest) {
		for (ApprovalRequest approvalRequest : approvalRequests) {
			if (approvalRequest.getId() == idApprovalRequest)
				return approvalRequest.getEvent().getId();
		}
		return null;
	}

	@Override
	public String toString() {
		return "ApprovalRequestServices [approvalRequests=" + approvalRequests + "]";
	}

}