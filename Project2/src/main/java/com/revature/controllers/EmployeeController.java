package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Reservation;
import com.revature.services.UserServices;

@RestController
@RequestMapping("")
public class EmployeeController {
	
	UserServices userService;
	
	@Autowired
	public EmployeeController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation createReservation(@RequestBody Reservation rs) {
		return this.userService.create(rs);
	}
	
	@PutMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation checkin(@RequestBody Reservation rs) {
		return this.userService.checkIn(rs);
	}
	
	@PutMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation checkout(@RequestBody Reservation rs) {
		return this.userService.checkOut(rs);
	}
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Reservation> pendingReservations(Date checkIn) {
		return this.userService.pendingReservations(checkin);
		
	}
}
