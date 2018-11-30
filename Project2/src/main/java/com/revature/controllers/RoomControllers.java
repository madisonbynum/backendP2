package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Reservation;
import com.revature.beans.Room;
import com.revature.services.RoomServices;

@RestController
@RequestMapping("room")
public class RoomControllers {

	RoomServices roomService;
	
	@Autowired
	public RoomControllers(RoomServices roomService) {
		super();
		this.roomService = roomService;
	}
	
	@PostMapping("reserve")
	public Reservation createReservatoin(@RequestBody Reservation res, @RequestHeader HttpHeaders headers) {
		System.out.println(res);
	return roomService.creatReservatoin(res);
	}
	
	@CrossOrigin
	@PostMapping("")
	public Room createRoom(@RequestBody Room room, @RequestHeader HttpHeaders headers) {
		System.out.println(room);
	return roomService.creatRoom(room);
	}
	
}
