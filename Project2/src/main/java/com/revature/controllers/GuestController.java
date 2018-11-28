package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Guest;
import com.revature.services.GuestService;

/*
 * Will pick out which functions from the UserService class  that pertain
 * to the guest.
 */

@RestController
@RequestMapping("/guest")
public class GuestController {
	GuestService guestService;
	
	@Autowired
	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}
	
	//Example of a post in spring mvc
//	@PostMapping("world") //Post requests to hello/world
//	public MyObject addHello(@RequestBody MyObject myObject) {
//		
//		myObject.setX(myObject.getX()+ 1);
//		return myObject;
//	}
	
	@PostMapping("create")
	@ResponseStatus(HttpStatus.CREATED)
	public Guest createGuest(@RequestBody Guest guest) {
//		return catService.save(cat);
		return guestService.save(guest);
	}
	
	
	
	
// This should be in the reservation controller
//
//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Reservation createReservation(@RequestBody Reservation rs) {
//		return this.userService.create(rs);
//	}

// This should be in the rooms controller
//	@GetMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public List<Room> avaialbleRooms(String status) {
//		return this.userService.availableRooms(status);
//	}

}
