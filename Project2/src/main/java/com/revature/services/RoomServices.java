package com.revature.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Reservation;
import com.revature.beans.Room;
import com.revature.repositories.RoomRepository;

@Service
public class RoomServices {

	RoomRepository roomRepository;
	
	@Autowired
	public RoomServices(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}
	
	
	
	public Room creatRoom(Room room) {
		return roomRepository.createRoom(room);
	}



	public Reservation creatReservatoin(Reservation res) {
		return roomRepository.createReservation(res);
	}



	public List<?> getReservationsByDate(Date date) {
		return roomRepository.getReservationByDate(date);
	}

}
