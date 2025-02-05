package com.GTGH_team2.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

//import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.GTGH_team2.Services.OrganizerServices;

public class Event {
	
	@Autowired
	OrganizerServices organizerServices;
	
	private Integer id;
    private String title;
    private String theme;
    private String description;
    private String location;
    private Integer maxCapacity;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer hour;
    private Integer minutes;
    private String duration;
    private Organizer organizer;
    private String status;// is "Accepted","Rejected","Deleted"
    private LocalDate date;
    private LocalTime time;

    public Event(String title, String theme, String description, String location, Integer maxCapacity, Integer day, Integer month, Integer year, Integer hour, Integer minutes, String duration,Organizer organizer) {
        this.title = title;
        this.theme = theme;
        this.description = description;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.day = day;
        this.month = month;
        this.year = year;
        this.date = LocalDate.of(year,month,day); // Date Format
        this.hour = hour; 
        this.minutes = minutes;
        this.time = LocalTime.of(hour, minutes); // Time Format
        this.duration = duration;
        this.organizer = organizer;
        this.status = "Pending";
        
    }
   
    // Setters & Getters

    public Integer getId() {
		return id;
	}
    
	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
		
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer newYear) {
		this.year = newYear;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
//    public static LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		Event.date = date;
//	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
    public String toString() {
        return  "Id: " + id +
        		"\nEvent title: " + title  +
                "\nTheme: " + theme +
                "\nDescription: " + description  +
                "\nLocation: " + location +
                "\nMax Capacity: " + maxCapacity +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nDuration: " + duration  +
                "\nOrganizer: " + organizer +
                "\nStatus: " + status;
    }
    
	
}

