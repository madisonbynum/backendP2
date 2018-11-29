package com.revature.controllers;
//
//import java.sql.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.beans.Reservation;
//import com.revature.beans.Room;
//import com.revature.services.UserServices;

/**
 * Will pick out functions from the UserService class that
 * pertain to the Manager.
 */
//@RestController
//@RequestMapping("")
//public class ManagerController {
//	UserServices userService;
//	
//	@Autowired
//	public ManagerController(UserServices userService) {
//		super();
//		this.userService = userService;
//	}
//	
//	/* Receives a post request w/ the a specified URI "" and runs this specific method.
//	 */
//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Reservation createReservation(@RequestBody Reservation rs) {
//		return this.userService.create(rs);
//	}
//	
//	/* Receives a put request w/ a specified URI "" w/ an Reservation object in the body
//	 * and uses a function from the UserService to update and send to the database through
//	 * the room repository.
//	 */
//	@PutMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Reservation checkin(@RequestBody Reservation rs) {
//		return this.userService.checkIn(rs);
//	}
//	
//	/* Receives a put request w/ a specified URI "" w/ an Reservation object in the body
//	 * and uses a function from the UserService to update and send to the database through
//	 * the room repository.
//	 */
//	@PutMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Reservation checkout(@RequestBody Reservation rs) {
//		return this.userService.checkOut(rs);
//	}
//	
//	
//	@GetMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public List<Room> availableRooms(String status) {// need to check this too.
//		return this.userService.availableRooms(status);
//	}
//	
//	
////----------------------------------------------------------------------------------------------------------------------------------
//	// Still working on these
//	// Still working on this function. It's supposed to receive a get request and runs this method.
//	@GetMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public List<Reservation> pendingReservations(Date checkin) {// need to check this.
//		return this.userService.pendingReservations(checkin);
//	}
//	
//	@PutMapping("") 
//	@ResponseStatus(HttpStatus.CREATED) 
//	public void changeRoomStatust(String status) {
//		return this.userService
//	}
//	
//	// This can be used to cancel a new reservation
//	@DeleteMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public void cancelRequest( ) {
//		
//	}
//	
////----------------------------------------------------------------------------------------------------------------------------------
//
//}
