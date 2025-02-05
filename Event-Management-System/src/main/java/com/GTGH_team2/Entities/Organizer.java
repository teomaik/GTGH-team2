package com.GTGH_team2.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GTGH_team2.Services.OrganizerServices;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Organizer {
	
	@Autowired
	OrganizerServices organizerServices;
	
	private Integer id;
    private String afm;
    private String name;
    private String surname;
    private String description;
    @JsonIgnore
    private List<Event> eventsByOrganizer = new ArrayList<>();

    // Constructor
    
    public Organizer(String afm, String name, String surname, String description) {
    	this.afm = afm;
        this.name = name;
        this.surname = surname;
        this.description = description;
    }
    
    public void addEvent(Event event) {
		this.eventsByOrganizer.add(event);
	}

    public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAfm() {
	     return afm;
	}
	
	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

	public List<Event> getEventsByOrganizer() {
		return eventsByOrganizer;
	}

	public void setEventsByOrganizer(List<Event> eventsByOrganizer) {
		this.eventsByOrganizer = eventsByOrganizer;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
        return description;
    }

    // It returns the name and the surname of the Organizer

    @Override
    public String toString() {
        return name + " " + surname;
    }

}

