package com.revature.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
//--------Reservation end points -------------------------------
	
	@PostMapping("reserve")
	public Reservation createReservatoin(@RequestBody Reservation res, @RequestHeader HttpHeaders headers) {
		System.out.println(res);
	return roomService.creatReservatoin(res);
	}
	
	@CrossOrigin
	@GetMapping("viewres")
	public List<?> getReservationsByDate(){
		System.out.println("My endpoint");
		Date date = Date.valueOf(LocalDate.now());
		return roomService.getReservationsByDate(date);
		
	}
	
	
//------------Room end points ------------------------------
	
	@CrossOrigin
	@PostMapping("")
	public Room createRoom(@RequestBody Room room, @RequestHeader HttpHeaders headers) {
		System.out.println(room);
	return roomService.creatRoom(room);
	}
	
}
