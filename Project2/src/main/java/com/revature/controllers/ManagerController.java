package com.revature.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Reservation;
import com.revature.beans.Room;
import com.revature.services.UserServices;

@RestController
@RequestMapping("")
public class ManagerController {
	UserServices userService;
	
	@Autowired
	public ManagerController(UserServices userService) {
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
	
	// Still working on this function. 
	@GetMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Reservation> pendingReservations(Date checkin) {// need to check this.
		return this.userService.pendingReservations(checkin);
	}
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Room> availableRooms(String status) {// need to check this too.
		return this.userService.availableRooms(status);
	}
	
	// This can be used to cancel a new reservation
	@DeleteMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	
}
