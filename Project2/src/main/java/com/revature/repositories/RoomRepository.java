//package com.revature.repositories;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.revature.beans.Reservation;
//import com.revature.beans.Room;
//
//@Repository
//public class RoomRepository {
//	
//	SessionFactory sf;
//	// need to add more methods here
//	@Transactional
//	public void insert(Reservation rs) {
//		sf.getCurrentSession().persist(rs);
//	}
//	
//	// Updates an element of the room that is targeted
//	@Transactional
//	public void update(Reservation rs) {
//		sf.getCurrentSession().update(rs);
//	}
//	
//	// Still trying to do more research on this.
//	// Gets a list of rooms w/ the matching status, from the database.
//	@Transactional
//	public List<Room> get(String status) {
//		String query = "Select * FROM room where status = :status";
//		try (Session session = sf.openSession()){
//			List<Room> rooms = session.createQuery(query, Room.class)
//					.setParameter("status",status).getResultList();
//			return rooms;
//			
//		}
//	}
//
//	
//	@Autowired
//	public RoomRepository(SessionFactory sf) {
//		super();
//		this.sf = sf;
//	}
//
//	public List<Reservation> get(Date checkin) {
//		// TODO Auto-generated method stub
//		List<Reservation> reservations = new ArrayList<>();
//		return reservations;
//	}
//}
