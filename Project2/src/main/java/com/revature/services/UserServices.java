package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Reservation;
import com.revature.beans.Room;
import com.revature.repositories.EmployeeRepository;
import com.revature.repositories.GuestRepository;
import com.revature.repositories.RoomRepository;

/**
 *  This class will include all functions that any user will
 *  need:
 *  - Login/logout
 *  - Check-in/out
 *  - Make/cancel reservations
 *  - Send/receive payments
 *
 */
@Service
public class UserServices {
	
	EmployeeRepository empRepo;
	GuestRepository guestRepo;
	RoomRepository roomRepo;
	
	@Autowired
	public UserServices(GuestRepository guestRepository) {
		super();
		this.guestRepo = guestRepository;
	}
	
	@Autowired
	public UserServices(RoomRepository roomRepository) {
		super();
		this.roomRepo = roomRepository;
	}
	
	@Autowired
	public UserServices(EmployeeRepository employeeRepository) {
		super();
		this.empRepo = employeeRepository;
	}
	
	
	@Transactional
	public Reservation create(Reservation rs) {
		roomRepo.insert(rs);
		return rs;
	}
	
	@Transactional
	public List<Room> availableRooms(String status) {
		return roomRepo.get(status);
	}
	
	@Transactional
	public Reservation checkIn(Reservation rs) {
		rs.setDateIn(rs.getDateIn());
		roomRepo.update(rs);
		return rs;
	}
	
	@Transactional
	public Reservation checkOut(Reservation rs) {
		rs.setDateOut(rs.getDateOut());
		roomRepo.update(rs);
		return rs;
	}
	
	// check this function. Supposed to pull list of reservations from repo
	@Transactional
	public List<Reservation> pendingReservations(Date checkin) {
		return roomRepo.get(rs);
	}

}
