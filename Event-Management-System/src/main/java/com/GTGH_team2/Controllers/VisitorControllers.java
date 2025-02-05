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

import com.GTGH_team2.Entities.Visitor;
import com.GTGH_team2.Services.VisitorServices;

@RestController
@RequestMapping("visitors")
public class VisitorControllers {

		@Autowired
		VisitorServices visitorServices;

	 	@GetMapping("/allvisitors")
		public List<Visitor> getAllVisitors() {
	 		visitorServices.getAllVisitors();
	 		return visitorServices.getVisitors();
		}
	 	
	 	@PostMapping("/add")
		public List<Visitor> addVisitor(@RequestBody List<Visitor> visitors) {
	 		return visitorServices.addVisitors(visitors);
		}
	 	
	 	@DeleteMapping("/remove")
		public List<Visitor> removeVisitor(@RequestParam Integer id ) {
	 		return visitorServices.removeVisitor(id);
		}
	 	
	 	@PutMapping("/update")
		public List<Visitor> updateVisitor(@RequestParam Integer id, @RequestParam(required = false) String newName, @RequestParam(required = false) String newSurname, @RequestParam(required = false) String newEmail){
	 		return visitorServices.updateVisitor(id, newName, newSurname, newEmail);
		}
	 	
	 	
}
	 	
