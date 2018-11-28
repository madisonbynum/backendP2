package com.revature.services;

//import java.sql.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.revature.beans.Reservation;
//import com.revature.beans.Room;
//import com.revature.repositories.EmployeeRepository;
//import com.revature.repositories.GuestRepository;
//import com.revature.repositories.RoomRepository;
//
///**
// *  This class will include all functions that any user will
// *  need:
// *  - Login/logout
// *  - Check-in/out
// *  - Make/cancel reservations
// *  - Send/receive payments
// *
// */
//@Service
//public class UserServices {
//	
//	EmployeeRepository empRepo;
//	GuestRepository guestRepo;
//	RoomRepository roomRepo;
//	
//	// Injects the guest repository to UserServices
//	@Autowired
//	public UserServices(GuestRepository guestRepository) {
//		super();
//		this.guestRepo = guestRepository;
//	}
//	
//	// Injects the room repository to UserServices
//	@Autowired
//	public UserServices(RoomRepository roomRepository) {
//		super();
//		this.roomRepo = roomRepository;
//	}
//
//	// Injects the employee repository to UserServices
//	@Autowired
//	public UserServices(EmployeeRepository employeeRepository) {
//		super();
//		this.empRepo = employeeRepository;
//	}
//	
//	
//	/*
//	 * Receives reservation created in the front end and sends it to the room repository.
//	 */
//	@Transactional
//	public Reservation create(Reservation rs) {
//		roomRepo.insert(rs);
//		return rs;
//	}
//	
//	/*
//	 * Gets a status from the front-end and  calls the method from the room repository that will 
//	 * extract a list of rooms with the specific status/availability.
//	 */
//	@Transactional
//	public List<Room> availableRooms(String status) {
//		return roomRepo.get(status);
//	}
//	
//	/*
//	 * This takes a request from the front-end and updates the checkIn date of a reservation, but this may have to be changed on what is sent 
//	 * to the room repository.
//	 */
//	@Transactional
//	public Reservation checkIn(Reservation rs) {
//		rs.setDateIn(rs.getDateIn());
//		roomRepo.update(rs);
//		return rs;
//	}
//	
//	/*
//	 * This takes a request from the front-end and  updates the checkOut date of a reservation, but this may have to be changed on what is sent 
//	 * to the room repository.
//	 */
//	@Transactional
//	public Reservation checkOut(Reservation rs) {
//		rs.setDateOut(rs.getDateOut());
//		roomRepo.update(rs);
//		return rs;
//	}
//	
//	/* check this function. Supposed to pull list of pending reservations from repo.
//	 * This will probably only be used by a manager user.
//	 */
//	@Transactional
//	public List<Reservation> pendingReservations(Date checkin) {
//		return roomRepo.get(checkin);
//	}
//
//}
