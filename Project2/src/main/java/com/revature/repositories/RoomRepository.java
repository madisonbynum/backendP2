package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Reservation;
import com.revature.beans.Room;

@Repository
public class RoomRepository {
	
	SessionFactory sf;
	// need to add more methods here
	@Transactional
	public void insert(Reservation rs) {
		sf.getCurrentSession().persist(rs);
	}
	
	@Transactional
	public void update(Reservation rs) {
		sf.getCurrentSession().update(rs);
	}
	
	// Still trying to do more research on this.
	@Transactional
	public List<Room> get(String status) {
		String query = "Select * FROM room where status = :status";
		try (Session session = sf.openSession()){
			List<Room> rooms = session.createQuery(query, Room.class)
					.setParameter("status",status).getResultList();
			return rooms;
			
		}
	}

	
	@Autowired
	public RoomRepository(SessionFactory sf) {
		super();
		this.sf = sf;
	}
}
