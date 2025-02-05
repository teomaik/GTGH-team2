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

import com.GTGH_team2.Entities.Organizer;
import com.GTGH_team2.Services.OrganizerServices;



//Spring REST Controller
//The organizer requests are created here through HTTP protocol

@RestController // Set the class a REST controller
@RequestMapping("organizers") // The path
public class OrganizerController {

	@Autowired 
	OrganizerServices organizerServices; 
	
	@GetMapping("/allOrganizers") // Get request for the list of organizers
	public List<Organizer> getAllOrganizers(){
		return organizerServices.getOrganizers();
	}
	
	@PostMapping("/add")  // Post request for adding an organizer
	public List<Organizer> addOrganizer(@RequestBody Organizer organizer) {
		return organizerServices.addOrganizer(organizer);
		
	}
	
	@PostMapping("/addMany")  // Post request for adding an organizer
	public List<Organizer> addOrganizers(@RequestBody List<Organizer> organizers) {
		return organizerServices.addOrganizers(organizers);
		
	}
	
	@DeleteMapping("/deleteOrganizer") // Delete request for removing organizers
	public List<Organizer> removeOrganizer(@RequestParam Integer id) {
		System.out.print(id);
		return organizerServices.removeOrganizer(id);
		
	}
	
	@PutMapping("/updateOrganizer") // Update the organizers details
	public List<Organizer> updateOrganizer(@RequestParam Integer id,@RequestParam String afmUpdated, @RequestParam String nameUpdated,@RequestParam String surnameUpdated,@RequestParam String descriptionUpdated){
		organizerServices.updateOrganizer(id,afmUpdated,nameUpdated,surnameUpdated,descriptionUpdated);
		return organizerServices.getOrganizers();
	}
	

}

