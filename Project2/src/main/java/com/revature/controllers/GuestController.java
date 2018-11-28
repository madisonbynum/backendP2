package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Reservation;
import com.revature.beans.Room;
import com.revature.services.UserServices;

/*
 * Will pick out which functions from the UserService class  that pertain
 * to the guest.
 */

@RestController
@RequestMapping("")
public class GuestController {
	UserServices userService;
	
	@Autowired
	public GuestController(UserServices userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation createReservation(@RequestBody Reservation rs) {
		return this.userService.create(rs);
	}
	
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Room> avaialbleRooms(String status) {
		return this.userService.availableRooms(status);
	}

}
