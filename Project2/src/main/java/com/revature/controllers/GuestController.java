package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Guest;
import com.revature.services.GuestService;

@RestController
@RequestMapping("guest")
public class GuestController {

	GuestService guestService;

	@Autowired
	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}
	
	
//	@CrossOrigin
	@PostMapping("")
	public Guest createGuest(@RequestBody Guest guest, @RequestHeader HttpHeaders headers) {
//		Optional<Guest> optionalObject;
//		List<Reservation> reservations = null;
//		List<HostedAt> hostedAts = null;
//
//		if(email == null ) {
//			throw new Exception();
//		}
//		else {
//			optionalObject = Optional.of(new Guest(firstName, lastName, email, phoneNumber, reservations, hostedAts));
//		}	
//			
//		ResponseEntity <Guest> guest = ResponseEntity
//				.status(HttpStatus.CREATED)
//				.body(optionalObject.orElseThrow(() -> new NullPointerException()));
//		
		System.out.println(guest);
		return guestService.createGuest(guest);
}
}
